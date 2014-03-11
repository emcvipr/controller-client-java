/**
 *  Copyright (c) 2008-2013 EMC Corporation
 * All Rights Reserved
 *
 * This software contains the intellectual property of EMC Corporation
 * or is licensed to EMC Corporation from third parties.  Use of this
 * software and the intellectual property contained therein is expressly
 * limited to the terms and conditions of the License Agreement under which
 * it is provided by or on behalf of EMC.
 */
package com.emc.storageos.model.vpool;

import com.emc.storageos.model.RestLinkRep;

import javax.xml.bind.annotation.XmlElement;

import org.codehaus.jackson.annotate.JsonProperty;

import java.net.URI;

/**
 * Extends the name related resource to add new fields
 * specifying if the a change to the virtual pool is allowed and
 * the reason if not allowed.
 */
public class VirtualPoolChangeRep extends NamedRelatedVirtualPoolRep {

    private Boolean allowed;
    private String notAllowedReason;
    
    public VirtualPoolChangeRep() {
    }

    public VirtualPoolChangeRep(URI id, RestLinkRep selfLink, String name, String virtualPoolType,
                                Boolean allowed, String notAllowedReason) {
        super(id, selfLink, name, virtualPoolType);
        this.allowed = allowed;
        this.notAllowedReason = notAllowedReason;
    }

    /**
     * Specifies whether or not a virtual pool change is allowed.
     * 
     * @valid true
     * @valid false
     */
    @XmlElement(name = "allowed")
    public Boolean getAllowed() {
        return allowed;
    }

    public void setAllowed(Boolean allowed) {
        this.allowed = allowed;
    }

    /**
     * When not allowed, the reason the virtual pool change is not allowed.
     * 
     * @valid none
     */
    @XmlElement(name = "not_allowed_reason")
    public String getNotAllowedReason() {
        return notAllowedReason;
    }

    public void setNotAllowedReason(String notAllowedReason) {
        this.notAllowedReason = notAllowedReason;
    }
    
}
