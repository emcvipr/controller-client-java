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

package com.emc.vipr.model.object.vpool;

import com.emc.storageos.model.DataObjectRestRep;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Object store information
 */
@XmlRootElement(name = "data_services_vpool")
public class DataServicesVirtualPoolRestRep extends DataObjectRestRep {

    private String description;
    private String type;

    /**
     * DataServices VirtualPool description
     * @valid Should not be empty
     * @valid Should not be null
     * @valid Does not contain spaces
     * @valid Contains only alphanumeric characters (a-z,A-Z,0-9)
     * @valid Cannot contain decimal point(.)
     * @valid Cannot be more than 1024 characters
     * @return Object store Descrption
     */
    @XmlElement(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Virtual Pool Type
     * @valid OBJ, HDFS, OBJ_AND_HDFS
     * @return Object Store Type
     */
    @XmlElement(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}


