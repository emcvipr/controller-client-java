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
import com.emc.storageos.model.StringHashMapEntry;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collections;
import java.util.List;

/**
 * DataService vpool information
 */
@XmlRootElement(name = "data_service_vpool")
public class DataServiceVpoolRestRep extends DataObjectRestRep {

    private String description;
    private String name;
    private List<StringHashMapEntry> mappings;

    private boolean allowAllNamespaces;
    
   /**
     * DataService VirtualPool description
     * @return Object store Descrption
     */
    @XmlElement(name = "description")
    public String getDescription() {
        return description;
    }

    /**
     * DataService VirtualPool description
     * @valid Should not be empty
     * @valid Should not be null
     * @valid Does not contain spaces
     * @valid Contains only alphanumeric characters (a-z,A-Z,0-9)
     * @valid Cannot contain decimal point(.)
     * @valid Cannot be more than 1024 characters
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Unique name identifying this classification of DataService vpool
     * @return Name of this object vpool
     */
    @XmlElement(name = "name")
    public String getName() {
        return name;
    }

    /**
     * Unique name identifying this classification of object vpool
     * @valid Should not be empty
     * @valid Should not be null
     * @valid Does not contain spaces
     * @valid Contains only alphanumeric characters (a-z,A-Z,0-9)
     * @valid Cannot contain decimal point(.)
     * @valid Cannot be more than 1024 characters
     */
    public void setName(String name) {
        this.name = name;
    }

    public List<StringHashMapEntry> getVarrayMappings() {
        return mappings;
    }

    public void setVarrayMappings(List<StringHashMapEntry> mappings) {
        if(mappings != null)
            this.mappings = mappings;
        else {
            this.mappings = Collections.emptyList();
        }
    }	

    /**
     * Parameter to check if the Vpool can access all Namespace
     * @return true or false
     */
    @XmlElement(name = "isAllowAllNamespaces")
    public boolean isAllowAllNamespaces() {
		return allowAllNamespaces;
	}

	public void setAllowAllNamespaces(boolean allowAllNamespaces) {
		this.allowAllNamespaces = allowAllNamespaces;
	}   
}


