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
 * A response object that contains default retention period for bucket
 */
@XmlRootElement(name = "default_bucket_retention")
public class BucketRetentionInfoRep {

    private Long period;

    public BucketRetentionInfoRep(){
        this.period = 0l;
    }

    public BucketRetentionInfoRep(Long period) {
        this.period = period;
    }

    /**
     * Default retention period for bucket in seconds
     */
    public Long getPeriod() {
        return period;
    }

    public void setPeriod(Long period) {
        this.period = period;
    }
}
