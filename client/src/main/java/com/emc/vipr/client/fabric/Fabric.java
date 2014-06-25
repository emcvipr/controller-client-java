package com.emc.vipr.client.fabric;

import com.emc.storageos.fabric.models.Capacity;
import com.emc.storageos.fabric.models.FabricHealth;
import com.emc.vipr.client.fabric.impl.PathConstants;
import com.emc.vipr.client.impl.RestClient;

public class Fabric {
    private RestClient client;

    public Fabric(RestClient client) {
        this.client = client;
    }

    /**
     * Get fabric health information
     * <p>
     * API Call: <tt>GET /vdc/fabric/health</tt>
     *
     * @return Aggregated health of the fabric
     */
    public FabricHealth getHealth() {
        return client.get(FabricHealth.class, PathConstants.FABRIC_HEALTH_URL);
    }

    /**
     * Get fabric capacity information
     * <p>
     * API Call: <tt>GET /vdc/fabric/capacity</tt>
     *
     * @return Aggregated capacity of the fabric
     */
    public Capacity getCapacity() {
        return client.get(Capacity.class, PathConstants.FABRIC_CAPACITY_URL);
    }
}
