/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.za.tut.module.bl;

import ac.za.tut.entities.FileEncryptionEntity;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author JREscert
 */
@Stateless
public class FileEncryptionBean {
    @PersistenceContext
     private EntityManager em;
     
    public FileEncryptionEntity encryptFile(byte[] fileContent, String fileName){
     
        try{
            
           //genereate an AES key
           KeyGenerator keyGen = KeyGenerator.getInstance("AES");
           keyGen.init(128);//128 bit AES key
           SecretKey secretKey = keyGen.generateKey();
           
           //encrypt file content 
           Cipher cipher = Cipher.getInstance("AES");
           cipher.init(Cipher.ENCRYPT_MODE, secretKey);
           byte[] encryptedBytes = cipher.doFinal(fileContent);
           
           //create entity with meta data and encrpted data
           FileEncryptionEntity entity = new FileEncryptionEntity(fileName,"AES",encryptedBytes,Base64.getEncoder().encodeToString(secretKey.getEncoded()));
          //persit entity in database
          em.persist(entity);
          
          //return entity
          return entity;
        }catch(Exception e){
            throw new RuntimeException("File encryption failed ", e);
        }
    }
    
    //decrypt method 
    public byte[] decryptFile(Long id){
    
               try{
                 //find entity by id
                 FileEncryptionEntity entity = em.find(FileEncryptionEntity.class, id);
                 
                 if(entity == null){
                   throw new RuntimeException("File not found with ID: "+id);
                 }
                 //revuild the AES key from base64 string
                 byte[] decodedKey = Base64.getDecoder().decode(entity.getKey());
                 SecretKey originalKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");
                 
                 //initialize cipher in decode mode
                 Cipher cipher = Cipher.getInstance("AES");
                 cipher.init(Cipher.DECRYPT_MODE, originalKey);
                 
                 //decrypt the data
                 byte[] decryptedBytes = cipher.doFinal(entity.getEncryptedData());
                 
                 //retutn the original file bytes
                 return decryptedBytes;
               
               }catch(Exception e){
                   throw new RuntimeException("File decryption failed",e);
   
               }
    }
    
    //find all 
    public List<FileEncryptionEntity> findAll(){
        
      return em.createNamedQuery("FileEncryptionEntity.findAll",FileEncryptionEntity.class).getResultList();
    
    }
    
    public FileEncryptionEntity findById(Long Id){
       FileEncryptionEntity fee = em.find(FileEncryptionEntity.class, Id);
       
       return fee;
    
    }
    
}
