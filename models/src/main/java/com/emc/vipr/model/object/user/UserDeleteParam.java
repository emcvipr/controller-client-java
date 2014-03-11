package com.emc.vipr.model.object.user;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Parameter for deletion of object storage user
 */
@XmlRootElement(name = "user_delete_param")
public class UserDeleteParam {
    private String user;

    /**
     * User to be deleted
     * @valid None
     */
    @XmlElement(required = true, name = "user")
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
