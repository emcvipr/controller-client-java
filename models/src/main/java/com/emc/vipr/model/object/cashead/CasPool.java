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

/**
 * CAS Pool is an object that brings CAS-specific configuration on keypool
 */
public abstract class CasPool {

    private List<String> mask;

    /**
     * List of allowed operations on this pool
     * This should be replaced with bucket ACL once cas capabilities implemented in bucket ACL
     */
    public List<String> getMask() {
        return mask;
    }

    public void setMask(List<String> mask) {
        this.mask = mask;
    }
}
