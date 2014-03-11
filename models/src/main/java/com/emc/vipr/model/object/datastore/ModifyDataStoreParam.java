package com.emc.vipr.model.object.datastore;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Parameter to modify the name of an data store
 */
@XmlRootElement(name = "data_store_update")
public class ModifyDataStoreParam {
    private String name;
    private String description;

    /**
     * New name (if modified) to be used for the data store
     */
    @XmlElement(required = false, name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * New description (if modified) to be used for the data store
     */
    @XmlElement(required = false, name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
