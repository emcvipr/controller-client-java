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
 * A reply for create/update caspool operation
 * Contains link to newly created pool
 */
@XmlRootElement(name = "cas_pool")
public class CasPoolRep {

    private RestLinkRep link;

    public CasPoolRep() {

    }

    public CasPoolRep(RestLinkRep link) {
        this.link = link;
    }

    /**
     * Link to created/updated pool
     */
    public RestLinkRep getLink() {
        return link;
    }

    public void setLink(RestLinkRep link) {
        this.link = link;
    }

}
