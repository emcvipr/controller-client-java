package com.emc.vipr.client;

import com.emc.vipr.client.catalog.*;
import com.emc.vipr.client.impl.RestClient;

public class ViPRCatalogClient {
    protected RestClient client;

    public ViPRCatalogClient(String host) {
        this(new ClientConfig().withHost(host));
    }

    public ViPRCatalogClient(ClientConfig config) {
        this.client = config.newPortalClient();
    }

    /**
     * Sets the authentication token to be used for this client.
     *
     * @param authToken The authentication token to set.
     */
    public void setAuthToken(String authToken) {
        client.setAuthToken(authToken);
    }

    /**
     * Sets the authentication token and returns the updated client.
     *
     * @see #setAuthToken(String)
     * @param token The authentication token to set.
     * @return The updated client.
     */
    public ViPRCatalogClient withAuthToken(String token) {
        setAuthToken(token);
        return this;
    }

    public Orders orders() {
        return new Orders(this, client);
    }

    public Approvals approvals() {
        return new Approvals(this, client);
    }

    public Catalog catalog() {
        return new Catalog(this, client);
    }

    public Hosts hosts() {
        return new Hosts(this, client);
    }

    public VCenters vcenters() {
        return new VCenters(this, client);
    }

    public ExecutionWindows executionWindows() {
        return new ExecutionWindows(this, client);
    }
}
