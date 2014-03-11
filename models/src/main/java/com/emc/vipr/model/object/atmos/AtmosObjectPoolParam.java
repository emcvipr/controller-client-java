package com.emc.vipr.model.object.atmos;

import com.emc.vipr.model.object.datastore.DataStoreParam;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.net.URI;

/**
 * Object Pool creation parameters for object pools hosted on atmos devices
 */
@XmlRootElement(name = "atmos_data_store_create")
public class AtmosObjectPoolParam extends DataStoreParam {
    private String namespace;
    private URI project;
    private String tenantName;
    private String tenantId;
    private String tenantAdmin;
    private String tenantAdminPassword;
    private String ip;

    /**
     * tenant namespace
     * used to lookup tenant to get default project
     */
    @XmlElement(required = true, name = "namespace")
    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    /**
     * keypools created on this objectpool will be associated with the project
     */
    @XmlElement(name = "project")
    public URI getProject() {
        return project;
    }

    public void setProject(URI project) {
        this.project = project;
    }

    /**
     * name of the tenant to be imported
     * name used in atmos system management API
     */
    @XmlElement(required = true, name = "tenant_name")
    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    /**
     * name of the tenant to be imported
     * name used in atmos system management API
     */
    @XmlElement(required = true, name = "tenant_id")
    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    /**
     * an atmos user with administrator privileges for the provided tenant
     */
    @XmlElement(required = true, name = "tenant_admin")
    public String getTenantAdmin() {
        return tenantAdmin;
    }

    public void setTenantAdmin(String tenantAdmin) {
        this.tenantAdmin = tenantAdmin;
    }

    /**
     * password for "tenant_admin"
     */
    @XmlElement(required = true, name = "tenant_admin_password")
    public String getTenantAdminPassword() {
        return tenantAdminPassword;
    }

    public void setTenantAdminPassword(String tenantAdminPassword) {
        this.tenantAdminPassword = tenantAdminPassword;
    }

    /**
     * atmos endpoint.  in the form "ip:port:sslport"
     * port and sslport are optional and will default to 80, 443 respectively
     * (if sslport specified than port must be specified as well)
     * the following forms are valid:
     * 10.6.144.70:80:443
     * 10.6.144.70:80
     * 10.6.144.70
     */
    @XmlElement(required = true, name = "ip")
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
