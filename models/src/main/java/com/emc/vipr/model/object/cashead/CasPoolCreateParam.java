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

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * CAS Pool is an object that brings CAS-specific configuration on keypool
 */
@XmlRootElement(name = "cas_pool_create")
public class CasPoolCreateParam extends CasPool{

    private String name;

    /**
     * Name of the pool. Same as underlying keypool
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
