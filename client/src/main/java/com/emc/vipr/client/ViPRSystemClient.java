package com.emc.vipr.client;

import com.emc.vipr.client.impl.RestClient;
import com.emc.vipr.client.system.*;

public class ViPRSystemClient {
    protected RestClient client;

    public ViPRSystemClient(String host) {
        this(new ClientConfig().withHost(host));
    }

    public ViPRSystemClient(ClientConfig config) {
        this.client = config.newClient();
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
    public ViPRSystemClient withAuthToken(String token) {
        setAuthToken(token);
        return this;
    }
    
    /**
     * Performs an authentication login and returns the updated client.
     *
     * @see AuthClient#login(String, String)
     * @param username The username.
     * @param password The password.
     * @return The updated client.
     */
    public ViPRSystemClient withLogin(String username, String password) {
        auth().login(username, password);
        return this;
    }

    public AuthClient auth() {
        return new AuthClient(client);
    }

    public CallHome callHome() {
        return new CallHome(client);
    }

    public Config config() {
        return new Config(client);
    }

    public Control control() {
        return new Control(client);
    }

    public HealthMonitor health() {
        return new HealthMonitor(client);
    }

    public Licensing license() {
        return new Licensing(client);
    }

    public Logs logs() {
        return new Logs(client);
    }

    public Password password() {
        return new Password(client);
    }

    public Upgrade upgrade() {
        return new Upgrade(client);
    }
}
