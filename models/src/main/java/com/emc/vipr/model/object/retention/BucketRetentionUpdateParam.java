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
 * A request object to update default retention period on bucket
 */
@XmlRootElement(name = "default_bucket_retention_update")
public class BucketRetentionUpdateParam {

    private Long period;

    /**
     * Default retention period in seconds
     */
    public Long getPeriod() {
        return period;
    }

    public void setPeriod(Long period) {
        this.period = period;
    }
}
