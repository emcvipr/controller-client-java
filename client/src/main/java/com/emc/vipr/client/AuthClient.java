package com.emc.vipr.client;

import com.emc.vipr.client.impl.Constants;
import com.emc.vipr.client.impl.RestClient;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;

import static com.emc.vipr.client.impl.jersey.ClientUtils.addQueryParam;
import static com.emc.vipr.client.system.impl.PathConstants.CONTROL_POWER_OFF_CLUSTER_URL;

public class AuthClient {
    protected RestClient client;

    AuthClient(RestClient client) {
        this.client = client;
    }

    /**
     * Convenience method for calling constructor with new ClientConfig().withHost(host)
     *
     * @param host Hostname or IP address for the Virtual IP of the target environment.
     */
    public AuthClient(String host) {
        this(new ClientConfig().withHost(host));
    }

    /**
     * Convenience method for calling constructor with new ClientConfig().withHost(host).withIgnoringCertificates(ignoreCertificates)
     *
     * @param host Hostname or IP address for the Virtual IP of the target environment.
     * @param ignoreCertificates True if SSL certificates should be ignored.
     */
    public AuthClient(String host, boolean ignoreCertificates) {
        this(new ClientConfig().withHost(host).withIgnoringCertificates(ignoreCertificates));
    }

    public AuthClient(ClientConfig config) {
        this(config.newClient());
    }

    /**
     * Performs a login operation. The token is automatically associated with this client
     * connection.
     *
     * @param username The username.
     * @param password The password.
     * @return The authentication token.
     */
    public String login(String username, String password) {
        WebResource resource = client.getClient().resource(client.uriBuilder("/login").build());
        resource.addFilter(new HTTPBasicAuthFilter(username, password));
        ClientResponse response = resource.get(ClientResponse.class);
        response.close();
        return client.getAuthToken();
    }

    public String proxyToken() {
        ClientResponse response = client.resource("/proxytoken").get(ClientResponse.class);
        MultivaluedMap<String,String> headers = response.getHeaders();
        String proxyToken = headers.getFirst(Constants.PROXY_TOKEN_KEY);
        response.close();
        return proxyToken;
    }

    public void logout() {
        if (isLoggedIn()) {
            ClientResponse response = client.resource("/logout").get(ClientResponse.class);
            response.close();
        }
    }

    public void forceLogout() {
        if (isLoggedIn()) {
            URI uri = client.uriBuilder("/logout").queryParam("force", "true").build();
            ClientResponse response = client.resource(uri).get(ClientResponse.class);
            response.close();
        }
    }

    public void logoutUser(String username, boolean force, boolean includeProxyTokens) {
        UriBuilder builder = client.uriBuilder("/logout");
        builder.queryParam("username", username);
        if (force) {
            builder.queryParam("force", "true");
        }
        if (includeProxyTokens) {
            builder.queryParam("proxytokens", "true");
        }
        client.getURI(String.class, builder.build());
    }
    
    public boolean isLoggedIn() {
        return (client.getAuthToken() != null) && !("".equals(client.getAuthToken()));
    }
}
