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
package com.emc.vipr.model.object.retention;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Request object used to create a retention class in namespace
 */
@XmlRootElement(name = "retention_class_create")
public class RetentionClassCreateParam {

    private String name;

    private long period;

    /**
     * Name of the retention class
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Period of the retention class in seconds
     */
    public long getPeriod() {
        return period;
    }

    public void setPeriod(long period) {
        this.period = period;
    }
}
