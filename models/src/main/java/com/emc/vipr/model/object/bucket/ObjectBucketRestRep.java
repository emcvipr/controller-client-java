/**
 *  Copyright (c) 2013 EMC Corporation
 * All Rights Reserved
 *
 * This software contains the intellectual property of EMC Corporation
 * or is licensed to EMC Corporation from third parties.  Use of this
 * software and the intellectual property contained therein is expressly
 * limited to the terms and conditions of the License Agreement under which
 * it is provided by or on behalf of EMC.
 */

package com.emc.vipr.model.object.bucket;

import com.emc.storageos.model.RelatedResourceRep;
import com.emc.storageos.model.DataObjectRestRep;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.lang.String;


/**
 * Object Bucket information
 */
@XmlRootElement(name = "object_bucket")
public class ObjectBucketRestRep extends DataObjectRestRep {
    private String errorMessage;

    /**
     * Message returned by the server indicating the reason for create bucket failure (if any)
     * @valid None
     * @return Network
     */
    @XmlElement(name = "error_message")
    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMsg) {
        errorMessage = errorMsg;
    }
}

