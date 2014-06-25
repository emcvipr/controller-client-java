package com.emc.storageos.fabric.models.nodes;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
/**
 * REST API model for basic information about a network
 *
 */
@XmlRootElement(name = "network")
public class NetworkInfo implements Serializable {
    /**
     * Network FQDN
     */
    private String fqdn;
    /**
     * IPV4 address
     */
    private String ipv6Addr;
    /**
     * IPV6 address
     */
    private String ipv4Addr;
    
    @XmlElement(name = "fqdn")
    public String getFqdn(){
        return fqdn;
    }
            
    public void setFqdn(String fqdn){
        this.fqdn = fqdn;
    }
    
    @XmlElement(name = "ipv4_address")
    public String getIPV4Address(){
        return ipv4Addr;
    }
            
    public void setIPV4Address(String address){
        this.ipv4Addr = address;
    }
            
    @XmlElement(name = "ipv6_address")
    public String getIPV6Address(){
        return ipv6Addr;
    }
            
    public void setIPV6Address(String address){
        this.ipv6Addr = address;
    }
}
