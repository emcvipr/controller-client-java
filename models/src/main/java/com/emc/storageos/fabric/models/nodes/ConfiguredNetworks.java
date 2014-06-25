package com.emc.storageos.fabric.models.nodes;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
/**
 * REST API model for networks configured on a node
 *
 */
@XmlRootElement(name = "networks")
public class ConfiguredNetworks implements Serializable {
    /**
     * Info about management network
     */
    private NetworkInfo mgmtNetwork;
    /**
     * Info about data network
     */
    private NetworkInfo dataNetwork;
    /**
     * Info about bmc network
     */
    private NetworkInfo bmcNetwork;
    
    
    @XmlElement(name = "mgmt")
    public NetworkInfo getMgmtNetwork() {
        return mgmtNetwork;
    }

    public void setMgmtNetwork(NetworkInfo mgmtNetwork) {
        this.mgmtNetwork = mgmtNetwork;
    }
    
    @XmlElement(name = "data")
    public NetworkInfo getDataNetwork(){
        return dataNetwork;
    }
    
    public void setDataNetwork(NetworkInfo dataNetwork){
        this.dataNetwork = dataNetwork;
    }
    
    @XmlElement(name = "bmc")
    public NetworkInfo getBmcNetwork(){
        return bmcNetwork;
    }
    
    public void setBmcNetwork(NetworkInfo bmcNetwork){
        this.bmcNetwork = bmcNetwork;
    }
}
