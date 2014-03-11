package com.emc.storageos.model.block.export;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

/**
 * Update parameter for cluster
 */
public class ClustersUpdateParam extends UpdateParam {

    private List<URI> add;
    private List<URI> remove;
    
    public ClustersUpdateParam() {}
    
    public ClustersUpdateParam(List<URI> add, List<URI> remove) {
        this.add = add;
        this.remove = remove;
    }
    
    @XmlElementWrapper(required = false)
    @XmlElement(name = "cluster")
    public List<URI> getAdd() {
        if (add == null) {
            add = new ArrayList<URI>();
        }
        return add;
    }
    
    public void setAdd(List<URI> add) {
        this.add = add;
    }
    
    @XmlElementWrapper(required = false)
    @XmlElement(name = "cluster")
    public List<URI> getRemove() {
        if (remove == null) {
            remove = new ArrayList<URI>();
        }
        return remove;
    }
    
    public void setRemove(List<URI> remove) {
        this.remove = remove;
    }
}