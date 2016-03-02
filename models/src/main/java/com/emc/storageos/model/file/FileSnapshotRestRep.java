/*
 * Copyright 2015 EMC Corporation
 * All Rights Reserved
 */
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

package com.emc.storageos.model.file;

import javax.xml.bind.annotation.*;
import com.emc.storageos.model.RelatedResourceRep;

/**
 * Information relevant to a file snapshot, returned as a 
 * response to a REST request.
 *
 */
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlRootElement(name = "file_snapshot")
public class FileSnapshotRestRep extends FileObjectRestRep {
    private String timestamp;
    private RelatedResourceRep parent;
    private String nativeId;
    
    /**
     * ID of the snapshot, as exported by the array.
     * @valid none
     */
    @XmlElement(name = "native_id")
    public String getNativeId() {
        return nativeId;
    }

    public void setNativeId(String nativeId) {
        this.nativeId = nativeId;
    }
    
    /**
     * URI and reference link to the file share that is the
     * source of the snapshot.
     * @valid none
     */
    @XmlElement
    public RelatedResourceRep getParent() {
        return parent;
    }

    public void setParent(RelatedResourceRep parent) {
        this.parent = parent;
    }

    /**
     * Time instant when the snapshot was created.
     * @valid none
     */
    @XmlElement
    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
