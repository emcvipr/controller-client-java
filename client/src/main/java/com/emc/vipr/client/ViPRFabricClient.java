package com.emc.vipr.client;

import com.emc.vipr.client.fabric.*;
import com.emc.vipr.client.impl.RestClient;

/**
 */
public class ViPRFabricClient {
    protected RestClient client;

    public ViPRFabricClient(String host) {
        this(new ClientConfig().withHost(host));
    }

    public ViPRFabricClient(ClientConfig config) {
        this.client = config.newClient();
    }

    /**
     * Sets the authentication token to be used for this client.
     *
     * @param authToken
     *        The authentication token to set.
     */
    public void setAuthToken(String authToken) {
        client.setAuthToken(authToken);
    }

    /**
     * Sets the proxy token to be used for this client.
     *
     * @param proxyToken
     *        The authentication token to set.
     */
    public void setProxyToken(String proxyToken) {
        client.setProxyToken(proxyToken);
    }

    public AuthClient auth() {
        return new AuthClient(client);
    }

    /**
     * Performs an authentication login and returns the updated client.
     *
     * @see AuthClient#login(String, String)
     * @param username
     *        The username.
     * @param password
     *        The password.
     * @return The updated client.
     */
    public ViPRFabricClient withLogin(String username, String password) {
        auth().login(username, password);
        return this;
    }

    /**
     * Sets the authentication token and returns the updated client.
     *
     * @see #setAuthToken(String)
     * @param token
     *        The authentication token to set.
     * @return The updated client.
     */
    public ViPRFabricClient withAuthToken(String token) {
        setAuthToken(token);
        return this;
    }

    /**
     * Sets the proxy token and returns the updated client.
     *
     * @see #setProxyToken(String)
     * @param token
     *        The proxy token to set.
     * @return The updated client.
     */
    public ViPRFabricClient withProxyToken(String token) {
        setProxyToken(token);
        return this;
    }

    public Nodes nodes() {
        return new Nodes(client);
    }

    public Disks disks() {
        return new Disks(client);
    }

    public Services services() {
        return new Services(client);
    }

    public Stats stats() {
        return new Stats(client);
    }

    public Fabric fabric() {
        return new Fabric(client);
    }
    
    public Provisioning provisioning() {
        return new Provisioning(client);
    }
}
