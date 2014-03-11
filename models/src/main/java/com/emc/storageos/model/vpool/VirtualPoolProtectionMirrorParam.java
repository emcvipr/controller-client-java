/*
 * Copyright (c) 2013 EMC Corporation
 * All Rights Reserved
 *
 * This software contains the intellectual property of EMC Corporation
 * or is licensed to EMC Corporation from third parties.  Use of this
 * software and the intellectual property contained therein is expressly
 * limited to the terms and conditions of the License Agreement under which
 * it is provided by or on behalf of EMC.
 */
package com.emc.storageos.model.vpool;

import javax.xml.bind.annotation.XmlElement;
import java.net.URI;

public class VirtualPoolProtectionMirrorParam {
    
    public final static int MAX_DISABLED  =  0;
    
    private Integer maxMirrors;
    private URI vpool;

    public VirtualPoolProtectionMirrorParam() {}
    
    public VirtualPoolProtectionMirrorParam(Integer maxMirrors, URI vpool) {
        this.maxMirrors = maxMirrors;
        this.vpool = vpool;
    }

    /**
     * The maximum number of continuous copies for a virtual pool.
     * 
     * @valid none
     */
    @XmlElement(name="max_native_continuous_copies", required = false)
    public Integer getMaxMirrors() {
        return maxMirrors;
    }
    
    public void setMaxMirrors(Integer maxMirrors) {
        this.maxMirrors = maxMirrors;
    }

    /**
     * The virtual pool for protection mirrors.
     * 
     * @valid none
     */
    @XmlElement(name = "protection_mirror_vpool", required = false)
    public URI getVpool() {
        return vpool;
    }

    public void setVpool(URI vpool) {
        this.vpool = vpool;
    }
    
}
