package com.emc.storageos.model.network;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;

import com.emc.storageos.model.valid.Length;
import com.emc.storageos.model.valid.Range;

/**
 * These are the arguments used for creating a NetworkSystem.
 */
@XmlRootElement(name = "network_system_create")
public class NetworkSystemCreate {

    private String name;
    private String ipAddress;
    private Integer portNumber;
    private String userName;
    private String password;
    private String systemType;
    private String smisProviderIp;
    private Integer smisPortNumber;
    private String smisUserName;
    private String smisPassword;
    private Boolean smisUseSsl;

    public NetworkSystemCreate() {}
    
    /** 
     * Name of the Network System; must be unique.
     * @valid Must be unique within all existing network systems
     */
    @Length(min = 2, max = 128)
    @XmlElement(required = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /** 
     * IP address of the Network System for SSH communication.
     * This field is required for network systems of type 'mds'.
     * It is ignored for 'brocade' type network systems and can be null for 'brocade' type.
     * @valid example: 10.247.12.99
     * @valid example: my.host.name
     */
    @XmlElement(name = "ip_address")
    @JsonProperty("ip_address")
    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    /**
     * The integer TCP port number to be used for SSH communication.
     */
    @XmlElement(name = "port_number")
    @Range(min=1,max=65535)
    @JsonProperty("port_number")
    public Integer getPortNumber() {
        return portNumber;
    }

    public void setPortNumber(Integer portNumber) {
        this.portNumber = portNumber;
    }

    /** 
     * The user name credential used for SSH login.
     * @valid example: user1
     */
    @XmlElement(name = "user_name")
    @JsonProperty("user_name")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    
    /**
     * The password credential used for SSH login.
     * @valid example: abc1
     */
    @XmlElement()
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * The NetworkSystem type.
     * @valid brocade
     * @valid mds
     */
    //@EnumType(NetworkSystem.Type.class)
    @XmlElement(name = "system_type", required = true)
    @JsonProperty("system_type")
    public String getSystemType() {
        return systemType;
    }

    public void setSystemType(String systemType) {
        this.systemType = systemType;
    }

    /**
     * The IP address used for communication with an SMI-S provider.
     * This field is required for 'brocade' type network systems.
     * It is ignored for 'mds' type network systems and can be null for 'mds' type.
     * @valid example: 10.247.12.100
     * @valid example: my.host.name
     */
    @XmlElement(name = "smis_provider_ip")
    @JsonProperty("smis_provider_ip")
    public String getSmisProviderIp() {
        return smisProviderIp;
    }

    public void setSmisProviderIp(String smisProviderIp) {
        this.smisProviderIp = smisProviderIp;
    }

    /**
     * The integer TCP port number used for communication with an SMI-S provider.
     */
    @XmlElement(name = "smis_port_number")
    @Range(min=1,max=65535)
    @JsonProperty("smis_port_number")
    public Integer getSmisPortNumber() {
        return smisPortNumber;
    }

    public void setSmisPortNumber(Integer smisPortNumber) {
        this.smisPortNumber = smisPortNumber;
    }

    /** 
     * The user name credential used for communication with an SMI-S provider.
     * @valid example: smisuser1
     */
    @XmlElement(name = "smis_user_name")
    @JsonProperty("smis_user_name")
    public String getSmisUserName() {
        return smisUserName;
    }

    public void setSmisUserName(String smisUserName) {
        this.smisUserName = smisUserName;
    }

    /** 
     * The password credential used for communication with an SMI-S provider. 
     * @valid example: smispassword1
     */
    @XmlElement(name = "smis_password")
    @JsonProperty("smis_password")
    public String getSmisPassword() {
        return smisPassword;
    }

    public void setSmisPassword(String smisPassword) {
        this.smisPassword = smisPassword;
    }

    /**
     * A boolean flag, that if true, will result in SSL being used for communication with an SMI-S provider.
     * @valid true = use SSL
     * @valid false = do not use SSL
     */
    @XmlElement(name = "smis_use_ssl")
    @JsonProperty("smis_use_ssl")
    public Boolean getSmisUseSsl() {
        return smisUseSsl;
    }

    public void setSmisUseSsl(Boolean smisUseSsl) {
        this.smisUseSsl = smisUseSsl;
    }
    
}
