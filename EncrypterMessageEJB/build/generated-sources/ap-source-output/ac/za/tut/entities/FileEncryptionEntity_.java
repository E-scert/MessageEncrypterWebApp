package ac.za.tut.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2026-02-17T03:43:25")
@StaticMetamodel(FileEncryptionEntity.class)
public class FileEncryptionEntity_ { 

    public static volatile SingularAttribute<FileEncryptionEntity, String> fileName;
    public static volatile SingularAttribute<FileEncryptionEntity, String> encryptionType;
    public static volatile SingularAttribute<FileEncryptionEntity, byte[]> encryptedData;
    public static volatile SingularAttribute<FileEncryptionEntity, Long> id;
    public static volatile SingularAttribute<FileEncryptionEntity, String> key;

}