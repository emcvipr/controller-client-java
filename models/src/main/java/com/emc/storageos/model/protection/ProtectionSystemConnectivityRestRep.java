/**
 *  Copyright (c) 2013 EMC Corporation
 * All Rights Reserved
 *
 * This software contains the intellectual property of EMC Corporation
 * or is licensed to EMC Corporation from third parties.  Use of this
 * software and the intellectual property contained therein is expressly
 * limited to the terms and conditions of the License Agreement under which
 * it is provided by or on behalf of EMC.
 */

package com.emc.storageos.model.protection;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import com.emc.storageos.model.NamedRelatedResourceRep;


@XmlRootElement(name = "protection_connectivity")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class ProtectionSystemConnectivityRestRep {
    private NamedRelatedResourceRep protectionSystem;
    private List<ProtectionSystemConnectivitySiteRestRep> protectionSites;

    public ProtectionSystemConnectivityRestRep() {}
    
    public ProtectionSystemConnectivityRestRep(
            NamedRelatedResourceRep protectionSystem,
            List<ProtectionSystemConnectivitySiteRestRep> protectionSites) {
        this.protectionSystem = protectionSystem;
        this.protectionSites = protectionSites;
    }

    /**
     * The Protection System ID for the connectivity 
     * @valid example: urn:storageos:ProtectionSystem:4379693c-c2f9-4e8e-ac4f-c67789cf1934:
     */
    @XmlElement(name="protection_system")
    public NamedRelatedResourceRep getProtectionSystem() {
        return protectionSystem;
    }

    public void setProtectionSystem(NamedRelatedResourceRep protectionSystem) {
        this.protectionSystem = protectionSystem;
    }

    /**
     * The Protection Sites for this Protection System. 
     * @valid 0 or more Protection Sites
     */
    //TODO possibly add XmlElementWrapper(name="protection_sites") since this is a list
    @XmlElement(name="protection_site")
    public List<ProtectionSystemConnectivitySiteRestRep> getProtectionSites() {
        if (protectionSites == null) {
            protectionSites = new ArrayList<ProtectionSystemConnectivitySiteRestRep>();
        }
        return protectionSites;
    }

    public void setProtectionSites(List<ProtectionSystemConnectivitySiteRestRep> protectionSites) {
        this.protectionSites = protectionSites;
    }
}
