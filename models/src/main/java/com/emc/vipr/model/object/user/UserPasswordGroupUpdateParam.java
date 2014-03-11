package com.emc.vipr.model.object.user;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Parameter for updating of a new user password
 */
@XmlRootElement(name = "user_password_update")
public class UserPasswordGroupUpdateParam {
    private String password;
    private List<String> groups;

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
}
