/*
 * Copyright (c) 2014 EMC Corporation
 * All Rights Reserved
 *
 * This software contains the intellectual property of EMC Corporation
 * or is licensed to EMC Corporation from third parties.  Use of this
 * software and the intellectual property contained therein is expressly
 * limited to the terms and conditions of the License Agreement under which
 * it is provided by or on behalf of EMC.
 */
package com.emc.vipr.model.object.cashead;

import com.emc.storageos.model.RestLinkRep;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * A reply for create/update cascluster operation
 * Contains link to newly created cluster
 */
@XmlRootElement(name = "cas_cluster")
public class CasClusterRep {

    private RestLinkRep link;

    public CasClusterRep() {
    }

    public CasClusterRep(RestLinkRep link) {
        this.link = link;
    }

    /**
     * A link to created or updated cluster
     */
    public RestLinkRep getLink() {
        return link;
    }

    public void setSelf(RestLinkRep link) {
        this.link = link;
    }
}
