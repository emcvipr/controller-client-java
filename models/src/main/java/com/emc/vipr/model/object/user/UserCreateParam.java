package com.emc.vipr.model.object.user;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Parameter for creation of new object storage user
 */
@XmlRootElement(name = "user_create_param")
public class UserCreateParam {
    private String user;
    private String namespace;

    /**
     * User to be created
     * @valid None
     */
    @XmlElement(required = true, name = "user")
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    /**
     * Namespace identifier to associate with the user
     * @valid None
     */
    @XmlElement(required = true, name = "namespace")
    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }
}
