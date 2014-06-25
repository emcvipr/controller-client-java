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
 * A request object used to update existing retention class
 */
@XmlRootElement(name = "retention_class_update")
public class RetentionClassUpdateParam {

    private long period;

    /**
     * A new period value for class in seconds
     */
    public long getPeriod() {
        return period;
    }

    public void setPeriod(long period) {
        this.period = period;
    }
}
