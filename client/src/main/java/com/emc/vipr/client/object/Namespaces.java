package com.emc.vipr.client.object;

import com.emc.vipr.client.impl.RestClient;
import com.emc.vipr.model.object.ObjectNamedRelatedResourceRep;
import com.emc.vipr.model.object.namespace.*;
import java.net.URI;
import java.util.List;

import static com.emc.vipr.client.object.impl.PathConstants.*;

public class Namespaces {
    private RestClient client;

    public Namespaces(RestClient client) {
        this.client = client;
    }

    /**
     * Lists references to namespaces.
     * <p>
     * API Client: <tt>GET /object/namespaces</tt>
     *
     * @return References to namespaces.
     */
    public List<ObjectNamedRelatedResourceRep> list() {
        return client.get(NamespaceList.class, NAMESPACES_URL).getNamespaces();
    }

    /**
     * Gets a namespace by name.
     * <p>
     * API Client: <tt>GET /object/namespaces/namespace/{id}</tt>
     *
     * @param namespace Name of the namespace.
     * @return Namespace object.
     */
    public NamespaceRestRep get(String namespace) {
        return client.get(NamespaceRestRep.class, NAMESPACES_URL + ID_PATH, namespace);
    }

    /**
     * Gets a namespace for the given tenant.
     * <p>
     * API Client: <tt>GET /object/namespaces/tenant/{id}</tt>
     *
     * @param tenantId Identifier of the tenant.
     * @return Namespace object.
     */
    public TenantNamespaceRestRep getForTenant(URI tenantId) {
        return client.get(TenantNamespaceRestRep.class, NAMESPACES_URL + TENANT_PATH + ID_PATH, tenantId);
    }

    /**
     * Creates a new namespace.
     * <p>
     *     API Client: <tt>POST /object/namespaces/namespace</tt>
     * </p>
     *
     * @param create Namespace create parameters.
     * @return Create namespace object.
     */
    public NamespaceRestRep create(NamespaceCreateParam create) {
        return client.post(NamespaceRestRep.class, create, NAMESPACES_URL + NAMESPACE_PATH);
    }

    /**
     * Updates a namespace.
     * <p>
     *     API Client: <tt>PUT /object/namespaces/namespace/{namespace}</tt>
     * </p>
     *
     * @param namespace Name of the namespace.
     * @param param Namespace update parameters.
     */
    public void update(String namespace, NamespaceUpdateParam param) {
        client.put(String.class, param, NAMESPACES_URL + NAMESPACE_PATH + ID_PATH, namespace);
    }

    /**
     * Deactivates a namespace.
     * <p>
     *     API Client: <tt>POST /object/namespaces/namespace/{namespace}/deactivate</tt>
     * </p>
     *
     * @param namespace Name of the namespace.
     */
    public void deactivate(String namespace) {
        client.post(String.class, NAMESPACES_URL + NAMESPACE_PATH + ID_PATH + DEACTIVATE_PATH, new Object[] {namespace});
    }
}
