package com.emc.storageos.model.user;

import org.codehaus.jackson.annotate.JsonProperty;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "user")
public class UserInfo {
    private String commonName;
    private String distinguishedName;
    private String tenant;
    private List<String> roles;
    private List<SubTenantRoles> subTenantRoles;

    @XmlElement(name = "common_name")
    @JsonProperty("common_name")
    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    @XmlElement(name = "distinguished_name")
    @JsonProperty("distinguished_name")
    public String getDistinguishedName() {
        return distinguishedName;
    }

    public void setDistinguishedName(String distinguishedName) {
        this.distinguishedName = distinguishedName;
    }

    public String getTenant() {
        return tenant;
    }

    public void setTenant(String tenant) {
        this.tenant = tenant;
    }

    @XmlElementWrapper(name = "roles")
    /**
     * Roles that the user has.
     * @valid SYSTEM_ADMIN (virtual data center role)
     * @valid SECURITY_ADMIN (virtual data center role)
     * @valid SYSTEM_MONITOR (virtual data center role)
     * @valid SYSTEM_AUDITOR (virtual data center role)
     * @valid TENANT_ADMIN (tenant role)
     * @valid PROJECT_ADMIN (tenant role)
     * @valid TENANT_APPROVER (tenant role)
     */
    @XmlElement(name = "role")
    public List<String> getRoles() {
        if (roles == null) {
            roles = new ArrayList<String>();
        }
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    @XmlElementWrapper(name = "subtenant_roles")
    /**
     * Subtenant(s) that this user has roles in.
     * @valid none
     */
    @XmlElement(name = "subtenant")
    public List<SubTenantRoles> getSubTenantRoles() {
        if (subTenantRoles == null) {
            subTenantRoles = new ArrayList<SubTenantRoles>();
        }
        return subTenantRoles;
    }

    public void setSubTenantRoles(List<SubTenantRoles> subTenantRoles) {
        this.subTenantRoles = subTenantRoles;
    }
}
