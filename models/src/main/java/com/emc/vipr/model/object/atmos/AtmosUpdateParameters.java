package com.emc.vipr.model.object.atmos;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Opaque key-value pairs used to update atmos device
 */
@XmlRootElement(name = "atmos_device_update")
public class AtmosUpdateParameters {
    private String tenantName;
    private String tenantAdmin;
    private String tenantAdminPassword;
    private String ip;

    /**
     * Name of the tenant to be imported
     * Name used in atmos system management API
     * @valid None
     */
    @XmlElement(required = false, name = "tenant_name")
    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    /**
     * An atmos user with administrator privileges for the provided tenant
     * @valid None
     */
    @XmlElement(required = false, name = "tenant_admin")
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
    @XmlElement(required = false, name = "tenant_admin_password")
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
    @XmlElement(required = false, name = "ip")
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
