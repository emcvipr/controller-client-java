/*
 * Copyright (c) 2015 EMC Corporation
 * All Rights Reserved
 */
package com.emc.storageos.model.protection;

import com.emc.storageos.model.NamedRelatedResourceRep;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "protection_systems")
public class ProtectionSystemList {

    private List<NamedRelatedResourceRep> systems;

    public ProtectionSystemList() {
    }

    public ProtectionSystemList(List<NamedRelatedResourceRep> systems) {
        this.systems = systems;
    }

    /**
     * The list of all Protection Systems
     * 
     */
    @XmlElement(name = "protection_system")
    public List<NamedRelatedResourceRep> getSystems() {
        if (systems == null) {
            systems = new ArrayList<NamedRelatedResourceRep>();
        }
        return systems;
    }

    public void setSystems(List<NamedRelatedResourceRep> systems) {
        this.systems = systems;
    }

}
