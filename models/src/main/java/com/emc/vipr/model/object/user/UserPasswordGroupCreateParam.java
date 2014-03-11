package com.emc.vipr.model.object.user;

import org.codehaus.jackson.annotate.JsonProperty;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Parameter for creation of a new user password
 */
@XmlRootElement(name = "user_password_create")
public class UserPasswordGroupCreateParam {
    private String password;
    private List<String> groups;
    private String namespace;

    /**
     * Password for the user
     * @valid None
     */
    @XmlElement(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * List of groups for the user
     * @valid None
     */
    @XmlElement(name = "groups_list")
    public List<String> getGroups() {
        if (groups == null) {
            groups = new ArrayList<String>();
        }
        return groups;
    }

    public void setGroups(List<String> groups) {
        this.groups = groups;
    }

    /**
     * Namespace of the object stores
     * @valid None
     */
    @XmlElement(name = "namespace")
    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }
}
