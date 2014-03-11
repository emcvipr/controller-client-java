package com.emc.vipr.model.object.datastore;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Data Store creation parameters for data stores hosted on pre-provisioned NFS servers
 */
@XmlRootElement(name = "nfs_exportpoints_data_store_create")
public class NfsExportPointsDataStoreParam extends DataStoreParam {
    private Long size;
    private String mountPoint;

    /**
     * size of the pre-provisioned server to be used for creating the data store
     */
    @XmlElement(required = true, name = "size")
    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    /**
     * mount point to be used by Bourne in order to use the pre-provisioned server
     */
    @XmlElement(required = true, name = "mount_point")
    public String getMountPoint() {
        return mountPoint;
    }

    public void setMountPoint(String mountPoint) {
        this.mountPoint = mountPoint;
    }
}
