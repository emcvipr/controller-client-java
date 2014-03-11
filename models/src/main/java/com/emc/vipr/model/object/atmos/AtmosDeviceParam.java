package com.emc.vipr.model.object.atmos;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.net.URI;

/**
 * Creation parameters for an atmos device
 */
@XmlRootElement(name = "atmos_device_import")
public class AtmosDeviceParam {
    private String name;
    private String namespace;
    private URI project;
    private String tenantName;
    private String tenantId;
    private String tenantAdmin;
    private String tenantAdminPassword;
    private String ip;

    /**
     * Name for the device
     * @valid Should not be empty
     * @valid Should not be null
     * @valid Does not contain spaces
     * @valid Contains only alphanumeric characters (a-z,A-Z,0-9)
     * @valid Cannot contain decimal point(.)
     * @valid Cannot contain dash (-)
     */
    @XmlElement(required = true, name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Tenant namespace
     * Used to lookup tenant to get default project
     * @valid None
     */
    @XmlElement(required = true, name = "namespace")
    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    /**
     * Project to associate keypools with (optional)
     * @vaid None
     */
    @XmlElement(name = "project")
    public URI getProject() {
        return project;
    }

    public void setProject(URI project) {
        this.project = project;
    }

    /**
     * Name of the tenant to be imported
     * Name used in atmos system management API
     * @valid None
     */
    @XmlElement(required = true, name = "tenant_name")
    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    /**
     * ID of the tenant to be imported
     * @valid None
     */
    @XmlElement(required = true, name = "tenant_id")
    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    /**
     * An atmos user with administrator privileges for the provided tenant
     * @valid None
     */
    @XmlElement(required = true, name = "tenant_admin")
    public String getTenantAdmin() {
        return tenantAdmin;
    }

    public void setTenantAdmin(String tenantAdmin) {
        this.tenantAdmin = tenantAdmin;
    }

    /**
     * Password for "tenant_admin"
     * @valid None
     */
    @XmlElement(required = true, name = "tenant_admin_password")
    public String getTenantAdminPassword() {
        return tenantAdminPassword;
    }

    public void setTenantAdminPassword(String tenantAdminPassword) {
        this.tenantAdminPassword = tenantAdminPassword;
    }

    /**
     * Atmos endpoint.  in the form "ip:port:sslport"
     * (If sslport specified then port must be specified as well)
     * @optional port - End point for atmos service @defaultValue 80
     * @optional sslport - End point for secure service @defaultValue 443
     * @valid ip: port: sslport
     * @valid ip: port
     * @valid ip
     */
    @XmlElement(required = true, name = "ip")
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
