/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.za.tut.module.bl;

import ac.za.tut.entities.MessageEncrypter;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author JREscert
 */
@Local
public interface MessageEncryptorInt {
    
    MessageEncrypter encryptMessage(String message, Integer shiftKey,String encryptionType);
    MessageEncrypter encryptNumberMessage(String message, Integer shiftKey, String encrypTionType);
    //query methods
    List<MessageEncrypter> findAll();
    List<MessageEncrypter> findByEncryptionType(String encryptionType);
    List<MessageEncrypter> findByShiftKey(Integer shiftKey);
    
    
    
}
