package com.emc.storageos.model.file;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "share")
public class SmbShareResponse extends FileSystemShareBase {

    private String mountPoint;
    
    public SmbShareResponse() {
        super();
    }

    public SmbShareResponse(String shareName, String description,
            String maxUsers, String permissionType, String permission,
            String mountPoint) {
        super(shareName, description, maxUsers, permissionType, permission);
        this.mountPoint = mountPoint;
    }

    /**
     * The SMB mount point of the file system.
     * @valid String path
     */
    @XmlElement(name = "mount_point")
    public String getMountPoint() {
        return mountPoint;
    }

    public void setMountPoint(String mountPoint) {
        this.mountPoint = mountPoint;
    }
    
}
