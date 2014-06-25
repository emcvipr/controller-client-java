package com.emc.storageos.model.smis;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.emc.storageos.model.valid.Length;

@XmlRootElement(name = "storage_provider_create")
public class StorageProviderCreateParam {
    
    public static Boolean USE_SSL_DEFAULT = Boolean.TRUE;

    private String name;
    private String ipAddress;
    private Integer portNumber;
    private String userName;
    private String password;
    private Boolean useSSL;
    private String interfaceType;
    private String sioCLI;

    public StorageProviderCreateParam() {}
    
    public StorageProviderCreateParam(String name, String ipAddress,
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
     * Name of the Storage Provider 
     */     
    @XmlElement(required = true)
    @Length(min = 2, max = 128)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * IP address of the Storage provider. 
     * @valid example: 10.247.99.87
     */     
    @XmlElement(required = true, name = "ip_address")
    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    /**
     * The port number of the Storage provider  
     * @valid example: 2001 
     */     
    @XmlElement(required = true, name = "port_number")
    public Integer getPortNumber() {
        return portNumber;
    }

    public void setPortNumber(Integer portNumber) {
        this.portNumber = portNumber;
    }

    /**
     * User name of the Storage provider  
     * @valid example: system 
     */     
    @XmlElement(required = true, name = "user_name")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Password of the Storage provider  
     * @valid example: none 
     */     
    @XmlElement(required = true)
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
    @XmlElement(required = true, name = "interface_type")
    public String getInterfaceType() {
        return interfaceType;
    }

    public void setInterfaceType(String interfaceType) {
        this.interfaceType = interfaceType;
    }

    /**
     * A command prefix to invoke the ScaleIO CLI. This is an optional parameter
     * and is only applicable for a ScaleIO StorageProvider.
     * @valid none
     * @return
     */
    @XmlElement(required = false, name = "sio_cli")
    public String getSioCLI() {
        return sioCLI;
    }

    public void setSioCLI(String sioCLI) {
        this.sioCLI = sioCLI;
    }
}
