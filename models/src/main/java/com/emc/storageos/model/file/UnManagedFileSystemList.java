/**
 *  Copyright (c) 2008-2013 EMC Corporation
 * All Rights Reserved
 *
 * This software contains the intellectual property of EMC Corporation
 * or is licensed to EMC Corporation from third parties.  Use of this
 * software and the intellectual property contained therein is expressly
 * limited to the terms and conditions of the License Agreement under which
 * it is provided by or on behalf of EMC.
 */

package com.emc.storageos.model.file;

import com.emc.storageos.model.RelatedResourceRep;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * List of unmanaged file systems.  UnManaged FileSystem are FileSystems that 
 * are present within ViPR, but are not under ViPR management.
 * 
 */
@XmlRootElement(name = "unmanaged_filesystems")
public class UnManagedFileSystemList {
    
    private List<RelatedResourceRep> unManagedFileSystem;

    public UnManagedFileSystemList() {}
    
    public UnManagedFileSystemList(List<RelatedResourceRep> unManagedFileSystem) {
        this.unManagedFileSystem = unManagedFileSystem;
    }

    /**
     * List of unmanaged file systems.
     * @valid none
     */
    @XmlElement(name = "unmanaged_filesystem")
    public List<RelatedResourceRep> getUnManagedFileSystem() {
        if (unManagedFileSystem == null) {
            unManagedFileSystem = new ArrayList<RelatedResourceRep>();
        }
        return unManagedFileSystem;
    }

    public void setUnManagedFileSystem(List<RelatedResourceRep> unManagedFileSystem) {
        this.unManagedFileSystem = unManagedFileSystem;
    }
    
}
