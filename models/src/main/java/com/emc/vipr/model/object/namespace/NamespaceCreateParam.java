package com.emc.vipr.model.object.namespace;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * Namespace creation parameters
 */
@XmlRootElement(name = "namespace_create")
public class NamespaceCreateParam {
    private String namespace;
    private URI tenant;
    private URI tenantDefaultProject;
    private URI tenantDefaultVpool;

    public NamespaceCreateParam() {
    }

    public NamespaceCreateParam(final String namespace, final URI tenant, final URI tenantDefaultProject, final URI tenantDefaultVpool) {
        this.namespace = namespace;
        this.tenant = tenant;
        this.tenantDefaultProject = tenantDefaultProject;
        this.tenantDefaultVpool = tenantDefaultVpool;
    }

    /**
     * User provided namespace (verified unique)
     * <p>can not include dots or slashes (.|/) in the name</p>
     * @valid Can contain slashes (/)
     * @valid Can contain dots (.)
     */
    @XmlElement(required = true)
    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(final String namespace) {
        this.namespace = namespace;
    }

    /**
     * ID of tenant associated with this namespace
     * @valid None
     */
    @XmlElement(required = true)
    public URI getTenant() {
        return tenant;
    }

    public void setTenant(final URI tenant) {
        this.tenant = tenant;
    }

    /**
     * Default project id for this tenant when creating buckets
     * @valid None
     */
    @XmlElement(required = false, name = "default_object_project")
    public URI getTenantDefaultProject() {
        return tenantDefaultProject;
    }

    public void setTenantDefaultProject(final URI tenantDefaultProject) {
        this.tenantDefaultProject = tenantDefaultProject;
    }

    /**
     * Default data services vpool identifier for this tenant when creating buckets
     * @valid None
     */
    @XmlElement(required = false, name = "default_data_services_vpool")
    public URI getTenantDefaultVpool() {
        return tenantDefaultVpool;
    }

    public void setTenantDefaultVpool(final URI tenantDefaultVpool) {
        this.tenantDefaultVpool = tenantDefaultVpool;
    }
}
