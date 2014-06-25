package com.emc.vipr.model.object.namespace;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * Namespace update parameters
 */
@XmlRootElement(name = "namespace_update")
public class NamespaceUpdateParam {
    private URI tenant;
    private URI tenantDefaultProject;
    private URI tenantDefaultVpool;

    public NamespaceUpdateParam() {
    }

    public NamespaceUpdateParam(final URI tenant, final URI tenantDefaultProject, final URI tenantDefaultVpool) {
        this.tenant = tenant;
        this.tenantDefaultProject = tenantDefaultProject;
        this.tenantDefaultVpool = tenantDefaultVpool;
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
