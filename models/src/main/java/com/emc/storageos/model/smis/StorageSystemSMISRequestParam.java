package com.emc.storageos.model.smis;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

import org.codehaus.jackson.annotate.JsonProperty;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class StorageSystemSMISRequestParam {

    private String systemType;
    private String name;
    private String ipAddress;
    private List<String> secondaryIPs;
    private Integer portNumber;
    private String userName;
    private String password;
    private String serialNumber;
    private List<URI> smisProviders;
    
    public StorageSystemSMISRequestParam() {}

    /**
     * Type of the storage system
     * 
     * @valid isilon
     * @valid vnxblock
     * @valid vnxfile
     * @valid vmax
     * @valid netapp
     * @valid vplex
     * @valid mds
     * @valid brocade
     * @valid rp
     * 
     */
    @XmlElement(name = "system_type", required = true)
    public String getSystemType() {
        return systemType;
    }

    public void setSystemType(String systemType) {
        this.systemType = systemType;
    }

    /**
     * User Defined Name of the storage system
     * 
     * @valid none
     */
    @XmlElement(name = "_name")
    @JsonProperty("_name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * IP Address of the storage system
     * 
     * @valid none
     */

    @XmlElement(name = "ip_address")
    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    @XmlElementWrapper(name = "secondary_ips")
    /**
     * List of  secondary ip addresses
     * 
     *  @valid none
     */
    @XmlElement(name = "secondary_ip", nillable = true)
    public List<String> getSecondaryIPs() {
        if (secondaryIPs == null) {
            secondaryIPs = new ArrayList<String>();
        }
        return secondaryIPs;
    }

    public void setSecondaryIPs(List<String> secondaryIPs) {
        this.secondaryIPs = secondaryIPs;
    }

    /**
     * Port Number used to connect to the storage system
     * 
     * @valid none
     */
    @XmlElement(name = "port_number")
    public Integer getPortNumber() {
        return portNumber;
    }

    public void setPortNumber(Integer portNumber) {
        this.portNumber = portNumber;
    }

    /**
     * Username to connect to storage system
     * 
     * @valid none
     */
    @XmlElement(nillable = true, name = "user_name")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Password to connect to storage system
     * 
     * 
     * @valid none
     */
    @XmlElement(name = "password", nillable = true)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Serial ID of the storage system
     * 
     * @valid none
     */
    @XmlElement(name = "serial_number", required = true)
    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    /**
     * List of SMI-S Providers managing this storage system
     * 
     * @valid none
     */
    @XmlElementWrapper(name = "providers", required = true)
    @XmlElement(name = "provider", required = true)
    public List<URI> getSmisProviders() {
        if (smisProviders == null) {
            smisProviders = new ArrayList<URI>();
        }
        return smisProviders;
    }

    public void setSmisProviders(List<URI> smisProviders) {
        this.smisProviders = smisProviders;
    }
    
}
