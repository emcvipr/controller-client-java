/**
 *  Copyright (c) 2008-2011 EMC Corporation
 * All Rights Reserved
 *
 * This software contains the intellectual property of EMC Corporation
 * or is licensed to EMC Corporation from third parties.  Use of this
 * software and the intellectual property contained therein is expressly
 * limited to the terms and conditions of the License Agreement under which
 * it is provided by or on behalf of EMC.
 */

package com.emc.vipr.model.object.datastore;

import com.emc.vipr.model.object.datastore.DataStoreRestRep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.net.URI;

/**
 * Information about the data store
 */
@XmlRootElement(name = "file_systems_data_store")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class FileSystemsDataStoreRestRep extends DataStoreRestRep {
    private URI fileSystemId;

    /**
     * File system ID associated with this  data store. This is relevant only for  data store hosted on file shares
     * @valid None
     * @return File System Id
     */
    @XmlElement(name = "file_system")
    public URI getFileSystemId() {
        return fileSystemId;
    }

    public void setFileSystemId(URI fileSystemId) {
        this.fileSystemId = fileSystemId;
    }
}
