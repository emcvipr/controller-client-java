package com.emc.vipr.model.object.ingestion;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.net.URI;

/**
 * Parameters associated with file share
 */
@XmlRootElement(name="filesystem_device_info")
public class FileSystemDeviceInfo {
    private URI fileShareId;

    /**
     *  Identifier of the file share
     *  @valid Valid file share
     */
    @XmlElement(name="fileshare_id")
    public URI getFileShareId() {
        return fileShareId;
    }

    public void setFileShareId(URI fileShareId) {
        this.fileShareId = fileShareId;
    }
}
