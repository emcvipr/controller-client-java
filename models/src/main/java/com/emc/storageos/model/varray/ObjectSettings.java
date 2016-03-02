/*
 * Copyright 2015 EMC Corporation
 * All Rights Reserved
 */
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

public class ObjectSettings {
    private Boolean deviceRegistered;
    private String protectionType;

    /**
     * if device is registered
     *
     * @valid true
     * @valid false
     */
    @XmlElement(name="device_registered")
    public Boolean getDeviceRegistered() {
        return deviceRegistered;
    }

    public void setDeviceRegistered(Boolean deviceRegistered) {
        this.deviceRegistered = deviceRegistered;
    }

    /**
     * varray protection type
     */
    @XmlElement(name="protection_type")
    public String getProtectionType() {
        return protectionType;
    }

    public void setProtectionType(String protectionType) {
        this.protectionType = protectionType;
    }
}


