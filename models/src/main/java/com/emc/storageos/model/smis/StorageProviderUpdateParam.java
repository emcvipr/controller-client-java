package com.emc.storageos.model.smis;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.emc.storageos.model.valid.Length;

@XmlRootElement(name = "storage_provider_update")
public class StorageProviderUpdateParam {


    private String name;
    private String ipAddress;
    private Integer portNumber;
    private String userName;
    private String password;
    private Boolean useSSL;
    private String interfaceType;

    public StorageProviderUpdateParam() {}
    
    public StorageProviderUpdateParam(String name, String ipAddress,
            Integer portNumber, String userName, String password, Boolean useSSL, String interfaceType) {
        this.name = name;
        this.ipAddress = ipAddress;
        this.portNumber = portNumber;
        this.userName = userName;
        this.password = password;
        this.useSSL = useSSL;
        this.interfaceType = interfaceType;
    }

    /**
     * New mgmt Provider name 
     */     
    @XmlElement
    @Length(min = 2, max = 128)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * New mgmt Provider IP address 
     * @valid example: 10.247.99.87
     */     
    @XmlElement(name = "ip_address")
    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    /**
     * New Provider port number 
     * @valid example: 5989
     */     
    @XmlElement(name = "port_number")
    public Integer getPortNumber() {
        return portNumber;
    }

    public void setPortNumber(Integer portNumber) {
        this.portNumber = portNumber;
    }

    /**
     * New Provider user name 
     * @valid none
     */     
    @XmlElement(name = "user_name")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * New SMIS Provider password 
     * @valid none
     */     
    @XmlElement
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Specifies whether to use SSL (Secure Sockets Layer) 
     * as the authentication method.
     * @valid none 
     */     
    @XmlElement(name = "use_ssl")
    public Boolean getUseSSL() {
        return useSSL;
    }

    public void setUseSSL(Boolean useSSL) {
        this.useSSL = useSSL;
    }
    
    /**
     * Interface type of the Storage Provider
     * @valid example: hicommand,smis,vplex,cinder,scaleio
     */
    @XmlElement(name = "interface_type")
    public String getInterfaceType() {
        return interfaceType;
    }

    public void setInterfaceType(String interfaceType) {
        this.interfaceType = interfaceType;
    }

}
