/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.za.tut.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author JREscert
 */
@Entity
@NamedQueries({
    @NamedQuery(name="findAll",query="SELECT m FROM MessageEncrypter m"),
    @NamedQuery(name="findByEncryptionType",query="SELECT m FROM MessageEncrypter m"),
    @NamedQuery(name="findByShiftKey",query = "SELECT m FROM MessageEncrypter m WHERE m.shifKeyNumber =:shifKeyNumber")
})
public class MessageEncrypter implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String message; 
    private String encryptedMessage;
    private String encryptionType;
    private Integer shifKeyNumber;

    //JPA
    public MessageEncrypter() {
    }

    public MessageEncrypter(String message, String encryptedMessage, String encryptionType, Integer shifKeyNumber) {
        this.message = message;
        this.encryptedMessage = encryptedMessage;
        this.encryptionType = encryptionType;
        this.shifKeyNumber = shifKeyNumber;
    }
    
    

    public MessageEncrypter(String message, String encryptedMessage) {
        this.message = message;
        this.encryptedMessage = encryptedMessage;
    }

    

    public String getEncryptionType() {
        return encryptionType;
    }

    public void setEncryptionType(String encryptionType) {
        this.encryptionType = encryptionType;
    }

    public Integer getShifKeyNumber() {
        return shifKeyNumber;
    }

    public void setShifKeyNumber(Integer shifKeyNumber) {
        this.shifKeyNumber = shifKeyNumber;
    }
    
    

  
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getEncryptedMessage() {
        return encryptedMessage;
    }

    public void setEncryptedMessage(String encryptedMessage) {
        this.encryptedMessage = encryptedMessage;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MessageEncrypter)) {
            return false;
        }
        MessageEncrypter other = (MessageEncrypter) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ac.za.tut.entities.MessageEncrypter[ id=" + id + " ]";
    }
    
}
