package com.emc.storageos.fabric.models.nodes;

import java.io.Serializable;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.emc.storageos.fabric.models.utils.LinkResponse;
/**
 * REST API model for list of nodes in the Fabric
 *
 */
@XmlRootElement(name = "nodes")
public class FabricNodeList implements Serializable {
    /**
     * Element id
     */
    private URI id;
    /**
     * Link to self
     */
    private LinkResponse selfLink;
    /**
     * List of all nodes in the Fabric
     */
    private List<FabricNode> nodes;
    
    @XmlElement(name = "id")
    public URI getId(){
        return id;
    }
    
    public void setId(URI id){
        this.id = id;
    }
    
    @XmlElement(name = "link")
    public LinkResponse getSelfLink() {
        return selfLink;
    }

    public void setSelfLink(LinkResponse selfLink) {
        this.selfLink = selfLink;
    }

    /**
     * List of nodes
     * @valid none
     */
    @XmlElement(name = "node")
    public List<FabricNode> getList() {
        if (nodes == null) {
            nodes = new ArrayList<FabricNode>();
        }
        return nodes;
    }

    public void setList(List<FabricNode> nodes) {
        this.nodes = nodes;
    }
    
    /**
     * Utility method to add node ids to the list individually
     * @param node
     */
    public void add(FabricNode node){
        if (nodes == null) {
            nodes = new ArrayList<FabricNode>();
        }
        nodes.add(node);
    }
}
