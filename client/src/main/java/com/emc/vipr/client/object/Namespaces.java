package com.emc.vipr.client.object;

import static com.emc.vipr.client.object.impl.PathConstants.DEACTIVATE_PATH;
import static com.emc.vipr.client.object.impl.PathConstants.ID_PATH;
import static com.emc.vipr.client.object.impl.PathConstants.NAMESPACES_URL;
import static com.emc.vipr.client.object.impl.PathConstants.NAMESPACE_PATH;
import static com.emc.vipr.client.object.impl.PathConstants.NAMESPACE_RETENTION_CLASS_URL;
import static com.emc.vipr.client.object.impl.PathConstants.NAMESPACE_RETENTION_CLASSES_URL;
import static com.emc.vipr.client.object.impl.PathConstants.TENANT_PATH;

import java.net.URI;
import java.util.List;

import com.emc.vipr.client.core.util.ResourceUtils;
import com.emc.vipr.client.impl.RestClient;
import com.emc.vipr.model.object.ObjectNamedRelatedResourceRep;
import com.emc.vipr.model.object.namespace.NamespaceCreateParam;
import com.emc.vipr.model.object.namespace.NamespaceList;
import com.emc.vipr.model.object.namespace.NamespaceRestRep;
import com.emc.vipr.model.object.namespace.NamespaceUpdateParam;
import com.emc.vipr.model.object.namespace.TenantNamespaceRestRep;
import com.emc.vipr.model.object.retention.RetentionClassCreateParam;
import com.emc.vipr.model.object.retention.RetentionClassInfoRep;
import com.emc.vipr.model.object.retention.RetentionClassListRep;
import com.emc.vipr.model.object.retention.RetentionClassUpdateParam;

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
        return client.get(NamespaceRestRep.class, NAMESPACES_URL + NAMESPACE_PATH + ID_PATH, namespace);
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
    
    /**
     * Gets the retention classes for the given namespace.
     * <p>
     * API Call: <tt>GET /object/namespaces/namespace/{namespace}/retention</tt>
     * </p>
     * 
     * @param namespace
     *        the namespace ID.
     * @return the list of retention classes.
     */
    public List<RetentionClassInfoRep> getRetentionClasses(String namespace) {
        RetentionClassListRep list = client
                .get(RetentionClassListRep.class, NAMESPACE_RETENTION_CLASSES_URL, namespace);
        return ResourceUtils.defaultList(list != null ? list.getRetentionClasses() : null);
    }

    /**
     * Gets a retention classes for the given namespace by name.
     * <p>
     * API Call: <tt>GET /object/namespaces/namespace/{namespace}/retention/{className}</tt>
     * </p>
     * 
     * @param namespace
     *        the namespace ID.
     * @param className
     *        the retention class name.
     * @return the retention class.
     */
    public RetentionClassInfoRep getRetentionClass(String namespace, String className) {
        return client.get(RetentionClassInfoRep.class, NAMESPACE_RETENTION_CLASS_URL, namespace, className);
    }

    /**
     * Creates a retention class for the given namespace.
     * <p>
     * API Call: <tt>POST /object/namespaces/namespace/{namespace}/retention</tt>
     * </p>
     * 
     * @param namespace
     *        the namespace ID.
     * @param create
     *        the retention class configuration.
     */
    public void createRetentionClass(String namespace, RetentionClassCreateParam create) {
        client.post(String.class, create, NAMESPACE_RETENTION_CLASSES_URL, namespace);
    }

    /**
     * Updates a retention class for the given namespace.
     * <p>
     * API Call: <tt>PUT /object/namespaces/namespace/{namespace}/retention/{className}</tt>
     * </p>
     * 
     * @param namespace
     *        the namespace ID.
     * @param className
     *        the retention class name.
     * @param update
     *        the retention class configuration.
     */
    public void updateRetentionClass(String namespace, String className, RetentionClassUpdateParam update) {
        client.put(String.class, update, NAMESPACE_RETENTION_CLASS_URL, namespace, className);
    }
}
