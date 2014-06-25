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

import java.util.List;
import java.util.Map;

/**
 * CAS profile brings additional CAS specific configuration to object user
 */
public abstract class CasProfile {

    private Boolean enabled;
    private List<String> capabilities;
    private String homepool;
    private String secret;
    private Map<String, String> metadata;

    /**
     * Flag indicating if this profile is enabled or not
     */
    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * List of operations allowed for this profile on home pool (like read,write,exists,delete etc.)
     */
    public List<String> getCapabilities() {
        return capabilities;
    }

    public void setCapabilities(List<String> capabilities) {
        this.capabilities = capabilities;
    }

    /**
     * Homepool for the profile. This contains name of CAS Pool to which all new data is written
     */
    public String getHomepool() {
        return homepool;
    }

    public void setHomepool(String homepool) {
        this.homepool = homepool;
    }

    /**
     * Profile metadata. Can be set by user via REST API
     */
    public Map<String, String> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
    }

    /**
     * Profile secret. Temporary field, to be removed once data IPC has API to retrieve objectuser secret
     */
    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }
}
