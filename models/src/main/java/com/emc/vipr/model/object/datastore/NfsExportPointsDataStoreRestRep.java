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

/**
 * Information about the data store from NFS export points
 */
@XmlRootElement(name = "nfs_export_points_data_store")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class NfsExportPointsDataStoreRestRep extends DataStoreRestRep {
    private String mountPoint;

    /**
     * Mount point associated with this data store. This is relevant only for data store hosted on pre-provisioned
     * servers
     * @valid None
     * @return Mount point
     */
    @XmlElement(name = "mount_point")
    public String getMountPoint() {
        return mountPoint;
    }

    public void setMountPoint(String mountPoint) {
        this.mountPoint = mountPoint;
    }
}
