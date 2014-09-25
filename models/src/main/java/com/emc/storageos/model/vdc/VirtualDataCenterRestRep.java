package com.emc.storageos.model.vdc;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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
    private Long lastSeenTimeInMillis;
            
    private static Set<String> ALLOW_DISCONNECT_STATUS = new HashSet<String>(Arrays.asList("CONNECTED", 
    		"REMOVE_FAILED", "REMOVE_PRECHECK_FAILED", "UPDATE_FAILED", 
    		"DISCONNECT_PRECHECK_FAILED", "DISCONNECT_FAILED"));
    private static Set<String> ALLOW_RECONNECT_STATUS = new HashSet<String>(Arrays.asList("DISCONNECTED", 
    	     "RECONNECT_PRECHECK_FAILED", "RECONNECT_FAILED"));
    
    
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
    
    @XmlElement(name="lastSeenTimeInMillis")
    public Long getLastSeenTimeInMillis() {
        return lastSeenTimeInMillis;
    }

    public void setLastSeenTimeInMillis(Long lastSeenTimeInMillis) {
        this.lastSeenTimeInMillis = lastSeenTimeInMillis;
    }
    
    public boolean canDisconnect() {        
        return (Boolean.FALSE.equals(this.local) 
                && ALLOW_DISCONNECT_STATUS.contains(this.connectionStatus != null ? this.connectionStatus.toUpperCase() : ""));
    }
    
    public boolean canReconnect() {
        return (Boolean.FALSE.equals(this.local) 
                && ALLOW_RECONNECT_STATUS.contains(this.connectionStatus != null ? this.connectionStatus.toUpperCase() : ""));
    }    
}