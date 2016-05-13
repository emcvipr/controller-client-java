/*
 * Copyright (c) 2014 EMC Corporation
 * All Rights Reserved
 */
package com.emc.storageos.model.ports;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.emc.storageos.model.valid.Length;

/**
 * The Class StoragePortRequestParam.
 * This is only applicable to Cinder storage systems
 * for users to manually create storage ports.
 */
@XmlRootElement(name = "storage_port_create")
public class StoragePortRequestParam {

    private String name;
    private String transportType;
    private String portNetworkId;

    /**
     * Name of the storage system
     * 
     */
    @XmlElement(required = true, name = "name")
    @Length(min = 2, max = 128)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Storage port transport type.
     * 
     */
    @XmlElement(required = true, name = "transport_type")
    public String getTransportType() {
        return transportType;
    }

    public void setTransportType(String transportType) {
        this.transportType = transportType;
    }

    /**
     * Storage port network identifier.
     * 
     *        IP - iSCSI Qualified Name (IQN) or Extended Unique Identifier (EUI)
     */
    @XmlElement(required = true, name = "port_network_id")
    public String getPortNetworkId() {
        return portNetworkId;
    }

    public void setPortNetworkId(String portNetworkId) {
        this.portNetworkId = portNetworkId;
    }
}
