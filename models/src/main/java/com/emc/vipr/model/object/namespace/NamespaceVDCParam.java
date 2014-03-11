package com.emc.vipr.model.object.namespace;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.net.URI;

/**
 * Namespace vdc to tenant mapping parameters
 */
@XmlRootElement(name = "vdc_namespace")
public class NamespaceVDCParam {
    public static final String DEFAULT_ZONE_ID = "ZONE0"; // Hard coded zone, for now!

    private URI tenant;
    private URI tenantDefaultProject;
    private URI tenantDefaultVpool;
    private String zoneId = DEFAULT_ZONE_ID;

    public NamespaceVDCParam() { }
    public NamespaceVDCParam(URI tenant, URI tenantDefaultProject, URI tenantDefaultVpool) {
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

    public void setTenant(URI tenant) {
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

    public void setTenantDefaultProject(URI tenantDefaultProject) {
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

    public void setTenantDefaultVpool(URI tenantDefaultVpool) {
        this.tenantDefaultVpool = tenantDefaultVpool;
    }

    /**
     * ID of the vdc associated with this namespace
     * @valid None
     */
    @XmlElement(required = false, name = "vdc_id")
    public String getZoneId() {
        return zoneId;
    }

    public void setZoneId(String zoneId) {
        this.zoneId = zoneId;
    }
}

