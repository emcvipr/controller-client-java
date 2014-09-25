package com.emc.vipr.model.object.user;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Parameter for creating groups for user
 */
@XmlRootElement(name = "user_groups")
public class UserGroupRestRep {
    /**
     * List of groups for the user
     * @valid None
     */
    private List<String> groups;

    public UserGroupRestRep() {
	if (groups == null) {
            groups = new ArrayList<String>();
        }
    }

    public UserGroupRestRep(Collection<String> groupList) {
	if (groups == null) {
            groups = new ArrayList<String>();
        }

        this.groups.addAll(groupList);
    }

    @XmlElement(name="groups_list")
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
