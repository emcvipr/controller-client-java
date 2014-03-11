package com.emc.storageos.model.host.vcenter;

import com.emc.storageos.model.valid.Endpoint;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Request POST parameter for vcenter creation.
 */
@XmlRootElement(name = "vcenter_create")
public class VcenterCreateParam extends VcenterParam {

    private String ipAddress;
    
    public VcenterCreateParam() {}
    
    public VcenterCreateParam(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    /** 
     * The IP address or host name of the vCenter. 
     * @valid none 
     */
    @XmlElement(name = "ip_address", required = true)
    @Endpoint(type= Endpoint.EndpointType.HOST)
    @JsonProperty("ip_address")
    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    @Override
    public String findIpAddress() {
        return ipAddress;
    }
}
