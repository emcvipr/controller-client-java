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

public class VirtualArrayParam {

    private Boolean autoSanZoning;

	public VirtualArrayParam() {}
    
    public VirtualArrayParam(Boolean autoSanZoning) {
        this.autoSanZoning = autoSanZoning;
    }

    /**
     * Specifies whether or not zoning is automatic for the virtual array.
     * 
     * @valid true
     * @valid false
     */
    @XmlElement(name="auto_san_zoning", required = false)
    public Boolean getAutoSanZoning() {
        return autoSanZoning;
    }

    public void setAutoSanZoning(Boolean autoSanZoning) {
        this.autoSanZoning = autoSanZoning;
    }
}
