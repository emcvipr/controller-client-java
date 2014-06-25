package com.emc.storageos.fabric.models.nodes;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.emc.storageos.fabric.models.utils.CommonInfo;
import com.emc.storageos.fabric.models.utils.ServiceNameList;
/**
 * REST API model for info about a single node
 *
 */
@XmlRootElement(name = "node")
public class NodeInfo extends CommonInfo implements Serializable {
    /**
     * Node UUID
     */
    private String nodeUUID;
    /**
     * Node type
     */
    private String nodeType;
    /**
     * List of configured networks on the node
     */
    private ConfiguredNetworks networks;
    /**
     * List of configured services on the node
     */
    private ServiceNameList services;
    /**
     * List of fault domain tags
     */
    private List<String> faultDomains;
    
    @XmlElement(name = "nodeUUID")
    public String getNodeUUID(){
        return nodeUUID;
    }
    
    public void setNodeUUID(String nodeUUID){
        this.nodeUUID = nodeUUID;
    }
    
    @XmlElement(name = "nodeType")
    public String getNodeType(){
        return nodeType;
    }
    
    public void setNodeType(String nodeType){
        this.nodeType = nodeType;
    }
    
    @XmlElement(name = "networks")
    public ConfiguredNetworks getNetworks(){
        return networks;
    }
    
    public void setNetworks(ConfiguredNetworks networks){
        this.networks = networks;
    }
    
    @XmlElement(name = "services")
    public ServiceNameList getServices(){
        return services;
    }
    
    public void setServices(ServiceNameList services){
        this.services = services;
    }
    
    @XmlElement(name = "fault_domain_tags")
    public List<String> getFaultDomains(){
        return faultDomains;
    }
    
    public void setFaultDomains(List<String> faultDomains){
        this.faultDomains = faultDomains;
    }
    
}
