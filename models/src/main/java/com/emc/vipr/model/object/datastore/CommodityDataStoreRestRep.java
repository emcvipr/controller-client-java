package com.emc.vipr.model.object.datastore;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import java.net.URI;

@XmlRootElement(name="commodity_data_store")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class CommodityDataStoreRestRep extends DataStoreRestRep{
    private URI id;
    private String ipAddress;
    private URI vArray;

    /**
     * ID of this commodity node
     * @valid None
     */
    @XmlElement(name = "id")
    public URI getCommodityId() {
        return id;
    }

    public void setCommodityId(URI id) {
        this.id = id;
    }

    /**
     * vArray associated with this commodity datastore
     * @valid None
     */
    @XmlElement(name = "varray")
    public URI getvArray() {
        return vArray;
    }

    public void setvArray(URI vArray) {
        this.vArray = vArray;
    }

    /**
     * IP address of this node
     * @valid None
     */
    @XmlElement(name = "ip")
    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
}
