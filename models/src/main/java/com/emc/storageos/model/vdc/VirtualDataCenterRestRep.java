package com.emc.storageos.model.vdc;

import java.net.URI;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.emc.storageos.model.DataObjectRestRep;

@XmlRootElement(name = "virtual_data_center")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class VirtualDataCenterRestRep extends DataObjectRestRep {
    private String description;
    private String apiEndpoint;
    private String connectionStatus;
    private Boolean local; 
    private String shortId;
    private String geoCommandEndpoint;
    private String geoDataEndpoint;
    
    @XmlElement(name="description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlElement(name="apiEndpoint")
    public String getApiEndpoint() {
        return apiEndpoint;
    }

    public void setApiEndpoint(String apiEndpoint) {
        this.apiEndpoint = apiEndpoint;
    }

    @XmlElement(name="connectionStatus")
    public String getConnectionStatus() {
        return connectionStatus;
    }

    public void setConnectionStatus(String connectionStatus) {
        this.connectionStatus = connectionStatus;
    }

    @XmlElement(name="local")
    public Boolean isLocal() {
        return local;
    }

    public void setLocal(Boolean local) {
        this.local = local;
    }

    @XmlElement(name="shortId")
    public String getShortId() {
        return shortId;
    }

    public void setShortId(String shortId) {
        this.shortId = shortId;
    }

    @XmlElement(name="geoCommandEndpoint")
    public String getGeoCommandEndpoint() {
        return geoCommandEndpoint;
    }

    public void setGeoCommandEndpoint(String geoCommandEndpoint) {
        this.geoCommandEndpoint = geoCommandEndpoint;
    }

    @XmlElement(name="geoDataEndpoint")
    public String getGeoDataEndpoint() {
        return geoDataEndpoint;
    }

    public void setGeoDataEndpoint(String geoDataEndpoint) {
        this.geoDataEndpoint = geoDataEndpoint;
    }
    
    
}