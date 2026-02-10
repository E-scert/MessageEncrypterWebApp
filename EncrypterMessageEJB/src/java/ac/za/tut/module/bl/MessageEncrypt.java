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
    public MessageEncrypter encryptMessage(String message,Integer shifKey) {
        
       String alphabet = "abcdefghijklmnopqrstuvwxyz";
       StringBuilder cipher = new StringBuilder();
       
       String originalMessage =message.toLowerCase();//place the message to lower case
       for(int i =0; i < originalMessage.length(); i++){
                    char cChar = originalMessage.charAt(i);
                    
                    //encrypt the message
                    if(Character.isLetter(cChar)){
                        int cPosition = alphabet.indexOf(cChar);//current character postion
                        int nPosition = (cPosition + shifKey) % 26;//new position iin place of the old position
                        char nChar = alphabet.charAt(nPosition); //new char placement
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

    @Override
    public MessageEncrypter encryptNumberMessage(String message, Integer shiftKey) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz!@#$&?";//add special characters
        StringBuilder numberCipher = new StringBuilder();
        
        String origMessage = message.toLowerCase();
        for(int i =0; i < origMessage.length();i++){
         char cChar = origMessage.charAt(i);
         
         
         //encrypt the message
         if(Character.isLetter(cChar)){
             int cPosition = alphabet.indexOf(cChar);//current possition
             int nPosition = (cPosition + shiftKey)% 32;//new position of character
             int nChar = alphabet.charAt(nPosition);//new numbers placement of the character
             numberCipher.append(nChar);
         
         } else{
             numberCipher.append(cChar);
         }    
   
       }
         // create the entity
                MessageEncrypter entity = new MessageEncrypter(message, numberCipher.toString());
                em.persist(entity);
                return entity;
    }
    
}
