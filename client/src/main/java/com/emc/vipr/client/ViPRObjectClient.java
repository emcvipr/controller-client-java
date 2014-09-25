package com.emc.vipr.client;

import com.emc.vipr.client.impl.RestClient;
import com.emc.vipr.client.object.*;
import com.emc.vipr.client.system.UserConfig;

public class ViPRObjectClient {
    protected RestClient client;

    /**
     * Convenience method for calling constructor with new ClientConfig().withHost(host)
     *
     * @param host Hostname or IP address for the Virtual IP of the target environment.
     */
    public ViPRObjectClient(String host) {
        this(new ClientConfig().withHost(host));
    }

    /**
     * Convenience method for calling constructor with new ClientConfig().withHost(host).withIgnoringCertificates(ignoreCertificates)
     *
     * @param host Hostname or IP address for the Virtual IP of the target environment.
     * @param ignoreCertificates True if SSL certificates should be ignored.
     */
    public ViPRObjectClient(String host, boolean ignoreCertificates) {
        this(new ClientConfig().withHost(host).withIgnoringCertificates(ignoreCertificates));
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
    
    public ObjectDataServiceVpools objectVirtualPools() {
    	return new ObjectDataServiceVpools(client);
    }
    
    public CasHead casHead() {
        return new CasHead(client);
    }

    public UserConfig userConfiguration() {
        return new UserConfig(client);
    }

    public Vdcs vdcs() {
        return new Vdcs(client);
    }
    
    public Capacities capacities() {
    	return new Capacities(client);
    }
}
