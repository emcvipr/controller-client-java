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
    private URI object_cos;


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
     * user provided description (not verified or unique)
     */
    @XmlElement(required = false, name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Desired vpool ID for creating the data store
     */
    @XmlElement(required = true, name = "data_services_vpool")
    public URI getObjectVpool() {
        return object_cos;
    }

    public void setObjectVpool(URI obj_vpool) {
        this.object_cos = obj_vpool;
    }
}
