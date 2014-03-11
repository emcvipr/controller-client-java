package com.emc.vipr.client;

import com.emc.vipr.client.impl.RestClient;
import com.emc.vipr.client.object.*;

public class ViPRObjectClient {
    protected RestClient client;

    public ViPRObjectClient(String host) {
        this(new ClientConfig().withHost(host));
    }

    public ViPRObjectClient(ClientConfig config) {
        this.client = config.newClient();
    }

    ViPRObjectClient(RestClient client) {
        this.client = client;
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
     * Sets the proxy token to be used for this client.
     *
     * @param proxyToken
     *        The authentication token to set.
     */
    public void setProxyToken(String proxyToken) {
        client.setProxyToken(proxyToken);
    }

    /**
     * Performs an authentication login and returns the updated client.
     *
     * @see AuthClient#login(String, String)
     * @param username The username.
     * @param password The password.
     * @return The updated client.
     */
    public ViPRObjectClient withLogin(String username, String password) {
        auth().login(username, password);
        return this;
    }

    /**
     * Sets the authentication token and returns the updated client.
     *
     * @see #setAuthToken(String)
     * @param token The authentication token to set.
     * @return The updated client.
     */
    public ViPRObjectClient withAuthToken(String token) {
        setAuthToken(token);
        return this;
    }

    public AuthClient auth() {
        return new AuthClient(client);
    }

    public AtmosImporter atmosImporter() {
        return new AtmosImporter(client);
    }

    public BaseUrls baseUrls() {
        return new BaseUrls(client);
    }

    public VirtualPools virtualPools() {
        return new VirtualPools(client);
    }

    public DataStores dataStores() {
        return new DataStores(client);
    }

    public ObjectIngestion ingestion() {
        return new ObjectIngestion(client);
    }

    public Buckets buckets() {
        return new Buckets(client);
    }

    public Namespaces namespaces() {
        return new Namespaces(client);
    }

    public Networks networks() {
        return new Networks(client);
    }

    public SecretKeys secretKeys() {
        return new SecretKeys(client);
    }

    public UserPasswords userPasswords() {
        return new UserPasswords(client);
    }

    public Users users() {
        return new Users(client);
    }

    public UserSecretKeys userSecretKeys() {
        return new UserSecretKeys(client);
    }
}
