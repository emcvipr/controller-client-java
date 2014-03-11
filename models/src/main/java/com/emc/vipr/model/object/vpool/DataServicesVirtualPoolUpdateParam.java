package com.emc.vipr.model.object.vpool;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Update object store parameters
 */
@XmlRootElement(name = "data_services_vpool_update")
public class DataServicesVirtualPoolUpdateParam {
    private String name;
    private String description;

    public DataServicesVirtualPoolUpdateParam() { }
    public DataServicesVirtualPoolUpdateParam(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * Name to update
     * @valid None
     */
    @XmlElement(required = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Description to update
     * @valid None
     */
    @XmlElement (name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

