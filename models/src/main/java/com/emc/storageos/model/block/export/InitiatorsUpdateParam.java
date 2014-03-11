package com.emc.storageos.model.block.export;

import java.net.URI;
import java.util.Collection;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

/**
 * Update parameter for initiator
 */
public class InitiatorsUpdateParam extends UpdateParam{

    private List<URI>  add;
    private List<URI> remove;

    public InitiatorsUpdateParam() {}
    
    public InitiatorsUpdateParam(List<URI> add, List<URI> remove) {
        this.add = add;
        this.remove = remove;
    }

    @XmlElementWrapper(required = false)
    @XmlElement(name = "initiator")
    public List<URI> getAdd() {
        return add;
    }
    
    public void setAdd(List<URI> add) {
        this.add = add;
    }
    
    @XmlElementWrapper(required = false)
    @XmlElement(name = "initiator")
    public List<URI> getRemove() {
        return remove;
    }
    
    public void setRemove(List<URI> remove) {
        this.remove = remove;
    }
}