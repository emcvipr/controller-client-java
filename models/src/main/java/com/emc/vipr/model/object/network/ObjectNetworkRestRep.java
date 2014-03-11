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

package com.emc.vipr.model.object.network;

import com.emc.storageos.model.RelatedResourceRep;
import com.emc.storageos.model.DataObjectRestRep;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * Object network information
 */
@XmlRootElement(name = "object_network")
public class ObjectNetworkRestRep extends DataObjectRestRep {
    private RelatedResourceRep network;

    /**
     * Network used by data nodes when creating and mounting file shares or nfs export points
     * @valid None
     * @return Network
     */
    @XmlElement(name = "network")
    public RelatedResourceRep getNetwork() {
        return network;
    }

    public void setNetwork(RelatedResourceRep network) {
        this.network = network;
    }
}

