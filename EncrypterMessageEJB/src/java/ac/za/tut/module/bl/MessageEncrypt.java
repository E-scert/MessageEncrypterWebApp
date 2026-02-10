/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.za.tut.module.bl;

import ac.za.tut.entities.MessageEncrypter;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author JREscert
 */
@Stateless
public class MessageEncrypt implements MessageEncryptorInt{
    @PersistenceContext(unitName ="EncrypterMessageEJBPU")
    private EntityManager em;
    @Override
    public MessageEncrypter encryptMessage(String message) {
        
       String alphabet = "abcdefghijklmnopqrstuvwxyz";
       StringBuilder cipher = new StringBuilder();
       
       String originalMessage =message.toLowerCase();//place the message to lower case
       for(int i =0; i < originalMessage.length(); i++){
                    char cChar = originalMessage.charAt(i);
                    
                    //encrypt the message
                    if(Character.isLetter(cChar)){
                        int cPosition = alphabet.indexOf(cChar);
                        int nPosition = (cPosition + 3) % 26;
                        int nChar = alphabet.charAt(nPosition);
                        cipher.append(nChar);
                    }else{
                    
                    cipher.append(cChar);//append the message
                    }
          
        }
      //create entity 
      MessageEncrypter entity = new MessageEncrypter(message,cipher.toString());
       em.persist(entity);
       return entity;
    }
    
}
