package com.emc.vipr.client.impl;

import com.emc.vipr.client.ClientConfig;
import com.emc.vipr.client.impl.jersey.*;
import com.emc.vipr.client.impl.jersey.ValidationErrorFilter;
import com.sun.jersey.api.client.*;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import org.codehaus.jackson.jaxrs.JacksonJaxbJsonProvider;
import org.slf4j.LoggerFactory;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;

public class RestClient {
    private ClientConfig config;
    private URI apiBaseUri;

    // Authentication token (either directly set or set after auth)
    private String authToken;

    // Proxy token for proxy authentication
    private String proxyToken;

    private Client client;

    public RestClient(URI baseUri, ClientConfig config) {
        this.apiBaseUri = baseUri;
        this.config = config;
        SSLUtil.trustAllHostnames();
        SSLUtil.trustAllSSLCertificates();
    }

    public ClientConfig getConfig() {
        return config;
    }

    public Client getClient() {
        if (client == null) {
            com.sun.jersey.api.client.config.ClientConfig jerseyConfig = new DefaultClientConfig();
            // The ViPR API services use the Jackson JAXB JSON provider.
            jerseyConfig.getClasses().add(JacksonJaxbJsonProvider.class);
            Client c = Client.create(jerseyConfig);

            // Do not follow redirect, this will be handled in the AuthTokenFilter so we can capture the token
            c.setFollowRedirects(false);

            // Set timeouts based on the configuration
            c.setConnectTimeout(config.getConnectionTimeout());
            c.setReadTimeout(config.getReadTimeout());

            // Logging filter will log all requests.
            if (config.isRequestLoggingEnabled()) {
                c.addFilter(new LoggingFilter(LoggerFactory.getLogger(getClass()), config.getLoggingEntityLength()));
            }
            if (config.getMaxRetries() > 0) {
                c.addFilter(new RetryFilter(config.getMaxRetries(), config.getRetryInterval()));
            }
            c.addFilter(new ValidationErrorFilter(config));
            c.addFilter(new ExceptionOnErrorFilter());

            // Add Proxy token if it is set
            c.addFilter(new ProxyTokenFilter(new TokenAccess() {
                public void setToken(String token) {
                    // Not required
                }
                public String getToken() {
                    return proxyToken;
                }
            }));
            // Auth filter that captures and sends token, also handles redirect
            c.addFilter(new AuthTokenFilter(new TokenAccess() {
                public void setToken(String token) {
                    authToken = token;
                }
                public String getToken() {
                    return authToken;
                }
            }));
            client = c;
        }

        return client;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public String getProxyToken() {
        return proxyToken;
    }

    public void setProxyToken(String proxyToken) {
        this.proxyToken = proxyToken;
    }

    public UriBuilder uriBuilder() {
        return UriBuilder.fromUri(apiBaseUri);
    }

    public UriBuilder uriBuilder(String path) {
        return uriBuilder().path(path);
    }

    public WebResource.Builder resource(String path, Object... args) {
        URI uri = uriBuilder(path).build(args);
        return resource(uri);
    }

    public WebResource.Builder resource(URI uri) {
        return getClient().resource(uri).accept(config.getMediaType())
            .type(config.getMediaType());
    }

    // Method takes path + args for replacement
    public <T> T put(Class<T> responseType, Object request, String path, Object... args) {
        return resource(path, args).put(responseType, request);
    }

    public <T> T put(Class<T> responseType, String path, Object... args) {
        return resource(path, args).put(responseType);
    }

    // Method takes URI. Construct URI with args, query params using uriBuilder()
    public <T> T putURI(Class<T> responseType, Object request, URI uri) {
        return resource(uri).put(responseType, request);
    }

    public <T> T post(Class<T> responseType, Object request, String path, Object... args) {
        return resource(path, args).post(responseType, request);
    }

    public <T> T postURI(Class<T> responseType, Object request, URI uri) {
        return resource(uri).post(responseType, request);
    }

    public <T> T post(Class<T> responseType, String path, Object... args) {
        return resource(path, args).post(responseType);
    }

    public <T> T postURI(Class<T> responseType, URI uri) {
        return resource(uri).post(responseType);
    }

    public <T> T delete(Class<T> responseType, String path, Object... args) {
        return resource(path, args).delete(responseType);
    }

    public <T> T deleteURI(Class<T> responseType, URI uri) {
        return resource(uri).delete(responseType);
    }

    public <T> T get(Class<T> responseType, String path, Object... args) {
        return resource(path, args).get(responseType);
    }

    public <T> T get(GenericType<T> responseType, String path, Object... args) {
        return resource(path, args).get(responseType);
    }

    public <T> T post(GenericType<T> responseType, Object request, String path, Object... args) {
        return resource(path, args).post(responseType, request);
    }

    public <T> T getURI(Class<T> responseType, URI uri) {
        return resource(uri).get(responseType);
    }

    public <T> T getURI(GenericType<T> responseType, URI uri) {
        return resource(uri).get(responseType);
    }
}
