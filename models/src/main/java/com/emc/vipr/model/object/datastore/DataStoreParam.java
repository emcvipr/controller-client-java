package com.emc.vipr.model.object.datastore;

import org.codehaus.jackson.annotate.JsonProperty;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.net.URI;

/**
 * Data Store creation parameters
 */
@XmlRootElement(name = "data_store_create")
public class DataStoreParam {
    private String name;
    private String description;
    private String virtual_array;


    /**
     * user provided name (not verified or unique)
     */
    @XmlElement(required = true, name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Desired virtual array ID for creating the data store
     */
    @XmlElement(required = true, name = "virtual_array")
    public String getVirtualArray() {
        return virtual_array;
    }

    public void setVirtualArray(String virtual_array) {
        this.virtual_array = virtual_array;
    }

    /**
     * user provided description (not verified or unique)
     */
    @XmlElement(required = false, name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
