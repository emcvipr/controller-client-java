package com.emc.vipr.model.object.datastore;

import org.codehaus.jackson.annotate.JsonProperty;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.net.URI;

/**
 * Data Store creation parameters for data stores hosted on fileshare based devices
 */
@XmlRootElement(name = "filesystems_data_store_create")
public class FileSystemsDataStoreParam extends DataStoreParam {
    private Long size;
    private URI fileVpool;
    private URI vArray;

    /**
     * Required size for the file share to be created
     */
    @XmlElement(required = true, name = "size")
    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    /**
     * Desired File Cos Id for creating the object pool
     */
    @XmlElement(required = false, name = "file_data_services_vpool")
    public URI getFileVpool() {
        return fileVpool;
    }

    public void setFileVpool(URI fileVpool) {
        this.fileVpool = fileVpool;
    }

    /**
     * URI of Varray on which the DataStore needs to be created
     */
    @XmlElement(required = true, name = "varray")
    public URI getVarray() {
        return vArray;
    }

    public void setVarray(URI vArray) {
        this.vArray = vArray;
    }
}
