package com.emc.storageos.fabric.models.utils;

import java.io.Serializable;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
/**
 * Generic model class to create a list of node ids
 *
 */
@XmlRootElement(name = "nodes")
public class NodeIdList implements Serializable {
    private List<URI> nodes;
    
    public NodeIdList() {
        if (nodes == null) {
            nodes = new ArrayList<URI>();
        }
    }
    
    public NodeIdList(List<URI> nodes) {
        this.nodes = nodes;
    }

    /**
     * List of nodes by id
     * @valid none
     */
    @XmlElement(name = "id")
    public List<URI> getList() {
        if (nodes == null) {
            nodes = new ArrayList<URI>();
        }
        return nodes;
    }

    public void setList(List<URI> nodes) {
        this.nodes = nodes;
    }
    
    /**
     * Utility method to add node ids to the list individually
     * @param node
     */
    public void add(URI node){
        if (nodes == null) {
            nodes = new ArrayList<URI>();
        }
        nodes.add(node);
    }
}
