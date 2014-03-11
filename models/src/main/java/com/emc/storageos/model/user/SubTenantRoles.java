package com.emc.storageos.model.user;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "subtenant")
public class SubTenantRoles {
    private String tenant;
    private List<String> roles;

    public String getTenant() {
        return tenant;
    }

    public void setTenant(String tenant) {
        this.tenant = tenant;
    }

    @XmlElementWrapper(name = "roles")
    /**
     * Roles that the user has.
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
}
