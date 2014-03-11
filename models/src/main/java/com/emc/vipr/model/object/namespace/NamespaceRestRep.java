/**
 *  Copyright (c) 2008-2012 EMC Corporation
 * All Rights Reserved
 *
 * This software contains the intellectual property of EMC Corporation
 * or is licensed to EMC Corporation from third parties.  Use of this
 * software and the intellectual property contained therein is expressly
 * limited to the terms and conditions of the License Agreement under which
 * it is provided by or on behalf of EMC.
 */

package com.emc.vipr.model.object.namespace;

import com.emc.storageos.model.DataObjectRestRep;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashMap;

/**
 * Namespace used for object services bucket defaults and access
 */
@XmlRootElement(name = "namespace")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class NamespaceRestRep extends DataObjectRestRep {
    private HashMap<String,NamespaceVDCRestRep> zoneMap;

    /**
     * Namespace to vdc mappings
     * @valid None
     * @return Namespace to vdc mappings
     */
    @XmlElement(name = "vdcs")
    public HashMap<String,NamespaceVDCRestRep> getZones() {
        return zoneMap;
    }

    public void setZones(HashMap<String, NamespaceVDCRestRep> zoneMap) {
        this.zoneMap = zoneMap;
    }
}

