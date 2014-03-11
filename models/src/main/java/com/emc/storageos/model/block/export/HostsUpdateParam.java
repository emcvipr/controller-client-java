package com.emc.storageos.model.block.export;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

/**
 * Update parameter for host
 */
public class HostsUpdateParam extends UpdateParam {
    
    private List<URI> add;
    private List<URI> remove;

    public HostsUpdateParam() {}
    
    public HostsUpdateParam(List<URI> add, List<URI> remove) {
        this.add = add;
        this.remove = remove;
    }

    @XmlElementWrapper(required = false)
    /**
     * List of host URIs to be added to the export group.
     * @valid example: [ urn:storageos:Host:2935a936-c821-4e0e-b69c-2d8a6d620ae5: ]
     * @valid example: [ ]
     */
    @XmlElement(name = "host")
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
    /**
     * List of host URIs to be removed from the export group.
     * @valid example: [ urn:storageos:Host:2935a936-c821-4e0e-b69c-2d8a6d620ae5: ]
     * @valid example: [ ]
     */
    @XmlElement(name = "host")
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