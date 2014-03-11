/**
 *  Copyright (c) 2013 EMC Corporation
 * All Rights Reserved
 *
 * This software contains the intellectual property of EMC Corporation
 * or is licensed to EMC Corporation from third parties.  Use of this
 * software and the intellectual property contained therein is expressly
 * limited to the terms and conditions of the License Agreement under which
 * it is provided by or on behalf of EMC.
 */
package com.emc.storageos.model.vpool;

import org.codehaus.jackson.annotate.JsonProperty;

import java.net.URI;
import javax.xml.bind.annotation.XmlElement;

public class VirtualPoolHighAvailabilityParam {
    
    private String type;
    private VirtualArrayVirtualPoolMapEntry haVirtualArrayVirtualPool;
    
    public VirtualPoolHighAvailabilityParam() {}
    
    public VirtualPoolHighAvailabilityParam(String type) {
        this.type = type;
    }
    
    public VirtualPoolHighAvailabilityParam(String type,
            VirtualArrayVirtualPoolMapEntry haVirtualArrayVirtualPool) {
        this.type = type;
        this.haVirtualArrayVirtualPool = haVirtualArrayVirtualPool;
    }

    /**
     * The high availability type.
     * 
     * @valid vplex_local
     * @valid vplex_distributed
     */
    @XmlElement(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    /**
     * The virtual pool for the high availability virtual array.
     * 
     * @valid none
     */
    @XmlElement(name = "ha_varray_vpool")
    @JsonProperty("ha_varray_vpool")
    public VirtualArrayVirtualPoolMapEntry getHaVirtualArrayVirtualPool() {
        return haVirtualArrayVirtualPool;
    }

    public void setHaVirtualArrayVirtualPool(
            VirtualArrayVirtualPoolMapEntry haVirtualArrayVirtualPool) {
        this.haVirtualArrayVirtualPool = haVirtualArrayVirtualPool;
    }

    /**
     *  The class provides the REST representation of an entry in a
     *  VirtualArray VirtualPool map.
     */
    public static class VirtualArrayVirtualPoolMapEntry {
 
        private URI virtualArray;
        private URI virtualPool;
        
        public VirtualArrayVirtualPoolMapEntry() {}
        
        public VirtualArrayVirtualPoolMapEntry(URI key, URI val) {
            virtualArray = key;
            virtualPool = val;
        }

        /**
         * The virtual array.
         * 
         * @valid none
         */
        @XmlElement(name = "varray")
        @JsonProperty("varray")
        public URI getVirtualArray() {
            return virtualArray;
        }

        public void setVirtualArray(URI virtualArray) {
            this.virtualArray = virtualArray;
        }

        /**
         * The virtual pool.
         * 
         * @valid none
         */
        @XmlElement(name = "vpool")
        @JsonProperty("vpool")
        public URI getVirtualPool() {
            return virtualPool;
        }

        public void setVirtualPool(URI virtualPool) {
            this.virtualPool = virtualPool;
        }
        
    }
  
}
