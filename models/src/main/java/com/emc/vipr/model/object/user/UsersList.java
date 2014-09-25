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
    private List<BlobUser> users;

    public void addUser(URI userId){
    	BlobUser user = new BlobUser();
    	user.setUser(userId);
    	user.setNamespace(null);
    	getUsers().add(user);
    }
    
    public void addUser(URI userId, URI namespace)
    {
    	BlobUser user = new BlobUser();
    	user.setUser(userId);
    	user.setNamespace(namespace);
    	getUsers().add(user);
    }

    /**
     * A list of users provisioned with the object service
     * @valid None
     */
    @XmlElement( name = "blobuser")
    public List<BlobUser> getUsers() {
        if (users == null) {
            users = new ArrayList<BlobUser>();
        }
        return users;
    }

    public void setUsers(List<BlobUser> users) {
        this.users = users;
    }
}
