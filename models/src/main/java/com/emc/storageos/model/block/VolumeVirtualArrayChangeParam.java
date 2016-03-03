/*
 * Copyright (c) 2014 EMC Corporation
 * All Rights Reserved
 */
package com.emc.storageos.model.block;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Specifies the parameters to change the virtual array
 * for one or more volumes.
 */
@XmlRootElement(name = "volumes_varray_change")
public class VolumeVirtualArrayChangeParam {

    private List<URI> volumes;
    private URI virtualArray;

    public VolumeVirtualArrayChangeParam() {
    }

    public VolumeVirtualArrayChangeParam(List<URI> volumes, URI virtualArray) {
        this.volumes = volumes;
        this.virtualArray = virtualArray;
    }

    @XmlElementWrapper(required = true, name = "volumes")
    /**
     * List of Volume IDs.
     * @valid example:  list of valid URIs
     */
    @XmlElement(required = true, name = "volume")
    public List<URI> getVolumes() {
        if (volumes == null) {
            volumes = new ArrayList<URI>();
        }
        return volumes;
    }

    public void setVolumes(List<URI> volumes) {
        this.volumes = volumes;
    }

    // The new virtual array.
    @XmlElement(required = true, name = "varray")
    @JsonProperty("varray")
    public URI getVirtualArray() {
        return virtualArray;
    }

    public void setVirtualArray(URI virtualArray) {
        this.virtualArray = virtualArray;
    }
}