package com.emc.vipr.model.object.user;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * A list of users provisioned with the object service
 */
@XmlRootElement(name = "users")
public class UsersList {
    private List<URI> users;

    public void addUser(URI id){
        getUsers().add(id);
    }

    /**
     * A list of users provisioned with the object service
     * @valid None
     */
    @XmlElement(name="users_list")
    public List<URI> getUsers() {
        if (users == null) {
            users = new ArrayList<URI>();
        }
        return users;
    }

    public void setUsers(List<URI> users) {
        this.users = users;
    }
}
