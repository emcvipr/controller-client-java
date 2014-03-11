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

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.emc.storageos.model.valid.Length;

/**
 * Parameter for virtual array update
 */
@XmlRootElement(name = "varray_update")
public class VirtualArrayUpdateParam extends VirtualArrayParam {
    
    private String label;

    public VirtualArrayUpdateParam() {}
    
    public VirtualArrayUpdateParam(String label) {
        super();
        this.label = label;
    }

    public VirtualArrayUpdateParam(Boolean autoSanZoning, String label) {
        super(autoSanZoning);
        this.label = label;
    }

    /**
     * The new name for the virtual array.
     * 
     * @valid none
     */
    @XmlElement(required = false, name = "name")
    @Length(min = 2, max = 128)
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
    
}
