package com.emc.vipr.client.catalog;

import com.emc.vipr.client.ViPRCatalogClient;
import com.emc.vipr.client.impl.RestClient;
import static com.emc.vipr.client.catalog.impl.PathConstants.*;

public class Hosts {
    protected final ViPRCatalogClient parent;
    protected final RestClient client;

    public Hosts(ViPRCatalogClient parent, RestClient client) {
        this.parent = parent;
        this.client = client;
    }

    /**
     * Performs discovery operation on a host.
     * <p>
     * API Call: POST /api/hosts/{id}/discover
     *
     * @param id Identifier of the host to discover.
     */
    public void discover(String id) {
        client.postURI(String.class, client.uriBuilder(HOST_DISCOVER_URL).build(id));
    }
}
