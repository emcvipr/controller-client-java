/**
 * Copyright (c) 2013-2014 EMC Corporation All Rights Reserved
 *
 * This software contains the intellectual property of EMC Corporation or is licensed to EMC
 * Corporation from third parties. Use of this software and the intellectual property contained
 * therein is expressly limited to the terms and conditions of the License Agreement under which it
 * is provided by or on behalf of EMC.
 */

package com.emc.vipr.client.object;

import static com.emc.vipr.client.object.impl.PathConstants.CLUSTER_CAPACITY_URL;
import com.emc.storageos.model.host.cluster.ClusterCapacityRep;
import com.emc.vipr.client.impl.RestClient;

public class Capacities {
    private RestClient client;

    public Capacities(RestClient client) {
        this.client = client;
    }

    /**
     * Get cluster capacity Info
     * <p>
     * API Call: <tt>GET /object/capacity</tt>
     *
     * @return the cluster capacity Information
     */
    public ClusterCapacityRep getClusterCapacity() {
        return client.get(ClusterCapacityRep.class, CLUSTER_CAPACITY_URL);
    }
}
