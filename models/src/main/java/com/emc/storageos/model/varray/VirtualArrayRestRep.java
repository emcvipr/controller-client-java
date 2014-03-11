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

package com.emc.storageos.model.varray;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.emc.storageos.model.DataObjectRestRep;


@XmlRootElement(name = "varray")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class VirtualArrayRestRep extends DataObjectRestRep {
    private Boolean autoSanZoning;    
    
    public VirtualArrayRestRep() {}
    
    public VirtualArrayRestRep(Boolean autoSanZoning) {
        this.autoSanZoning = autoSanZoning;
    }

    /**
     * ViPR creates the required zones in the SAN fabric
     * when a request to export a volume is made in this 
     * virtualstorage array. This will allow the exported
     * volume to be visible on the specified hosts.
     * 
     * @valid true
     * @valid false
     */
    @XmlElement(name="auto_san_zoning")
    public Boolean getAutoSanZoning() {
        return autoSanZoning;
    }

    public void setAutoSanZoning(Boolean autoSanZoning) {
        this.autoSanZoning = autoSanZoning;
    }
}
