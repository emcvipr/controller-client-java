package com.emc.vipr.model.object.ingestion;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.net.URI;

/**
 * Parameters for creating an ingestion task.
 */
@XmlRootElement(name = "object_ingestion_create")
public class ObjectIngestionCreateParam {

    private String dataStoreName;
    private String dataStoreDescription;
    private FileSystemDeviceInfo fileSystemDeviceInfo;
    private String keypoolName;

    /**
     * Name of the data store
     * @valid name should not be null
     * @valid name should not be empty
     * @valid name should not be greater than 128 characters
     */
    @XmlElement(required = true, name = "datastore_name")
    public String getDataStoreName() {
        return dataStoreName;
    }

    public void setDataStoreName(String dataStoreName) {
        this.dataStoreName = dataStoreName;
    }

    /**
     * Description of the data store
     * @valid description should not be null
     * @valid description should not be empty
     * @valid description should not be greater than 128 characters
     */
    @XmlElement(required = false, name = "datastore_description")
    public String getDataStoreDescription() {
        return dataStoreDescription;
    }

    public void setDataStoreDescription(String dataStoreDescription) {
        this.dataStoreDescription = dataStoreDescription;
    }

    /**
     * Details of the file share
     * @valid None
     */
    @XmlElement(required = false, name = "filesystem_device_info")
    public FileSystemDeviceInfo getFileSystemDeviceInfo() {
        return fileSystemDeviceInfo;
    }

    public void setFileSystemDeviceInfo(FileSystemDeviceInfo fileSystemDeviceInfo) {
        this.fileSystemDeviceInfo = fileSystemDeviceInfo;
    }

    /**
     *  Name of the pre-created keypool
     *  @valid Existing keypool
     */
    @XmlElement(required = true, name = "keypool_name")
    public String getKeypoolName() {
        return keypoolName;
    }

    public void setKeypoolName(String keypoolName) {
        this.keypoolName = keypoolName;
    }

}
