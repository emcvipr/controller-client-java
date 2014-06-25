package com.emc.vipr.client.fabric;

import com.emc.storageos.fabric.models.provisioning.ProvisioningRequest;
import com.emc.vipr.client.fabric.impl.PathConstants;
import com.emc.vipr.client.impl.RestClient;

public class Provisioning {
    private RestClient client;

    public Provisioning(RestClient client) {
        this.client = client;
    }

    /**
     * Provision services on fabric nodes.
     * <p>
     * API Call: <tt>POST /vdc/fabric/provisioning/provision</tt>
     *
     */
    public void provision(ProvisioningRequest request) {
        client.post(String.class, request, PathConstants.PROVISIONING_PROVISION_URL);
    }
}
