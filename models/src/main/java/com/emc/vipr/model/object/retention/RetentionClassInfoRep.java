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
 * Response object that contains info about single retention class
 */
@XmlRootElement(name = "retention_class")
public class RetentionClassInfoRep {

    private String name;

    private long period;

    public RetentionClassInfoRep() {

    }

    public RetentionClassInfoRep(String name, long period) {
        this.name = name;
        this.period = period;
    }

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
