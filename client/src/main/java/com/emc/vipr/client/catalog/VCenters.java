package com.emc.vipr.client.catalog;

import com.emc.vipr.client.ViPRCatalogClient;
import com.emc.vipr.client.impl.RestClient;

import static com.emc.vipr.client.catalog.impl.PathConstants.HOST_DISCOVER_URL;
import static com.emc.vipr.client.catalog.impl.PathConstants.VCENTER_DISCOVER_URL;

public class VCenters {
    protected final ViPRCatalogClient parent;
    protected final RestClient client;

    public VCenters(ViPRCatalogClient parent, RestClient client) {
        this.parent = parent;
        this.client = client;
    }

    /**
     * Performs discovery operation on a vCenter.
     * <p>
     * API Call: POST /api/vcenters/{id}/discover
     *
     * @param id Identifier of the host to discover.
     */
    public void discover(String id) {
        client.postURI(String.class, client.uriBuilder(VCENTER_DISCOVER_URL).build(id));
    }
}
