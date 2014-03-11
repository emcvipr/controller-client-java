package com.emc.vipr.client;

import com.emc.vipr.client.impl.Constants;
import com.emc.vipr.client.impl.RestClient;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import javax.ws.rs.core.MultivaluedMap;
import java.net.URI;

public class AuthClient {
    protected RestClient client;

    AuthClient(RestClient client) {
        this.client = client;
    }

    public AuthClient(String host) {
        this(new ClientConfig().withHost(host));
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
        ClientResponse response = client.resource("/logout").get(ClientResponse.class);
        response.close();
    }

    public void forceLogout() {
        URI uri = client.uriBuilder("/logout").queryParam("force", "true").build();
        ClientResponse response = client.resource(uri).get(ClientResponse.class);
        response.close();
    }
}
