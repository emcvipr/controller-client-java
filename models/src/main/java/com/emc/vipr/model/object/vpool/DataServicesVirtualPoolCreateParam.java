package com.emc.vipr.model.object.vpool;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Create data services virtual pool parameters
 */
@XmlRootElement(name = "data_services_vpool_create")
public class DataServicesVirtualPoolCreateParam {
    private String name;
    private String description;
    private String type;

    public DataServicesVirtualPoolCreateParam() { }
    public DataServicesVirtualPoolCreateParam(String name, String description, String type) {
        this.name = name;
        this.description = description;
        this.type = type;
    }

    /**
     * Unique name identifying this classification of object store
     * @valid Should not be empty
     * @valid Should not be null
     * @valid Does not contain spaces
     * @valid Contains only alphanumeric characters (a-z,A-Z,0-9)
     * @valid Cannot contain decimal point(.)
     * @valid Cannot be more than 1024 characters
     */
    @XmlElement(required = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Description of this object store
     * @valid Should not be empty
     * @valid Should not be null
     * @valid Does not contain spaces
     * @valid Contains only alphanumeric characters (a-z,A-Z,0-9)
     * @valid Cannot contain decimal point(.)
     * @valid Cannot be more than 1024 characters
     */
    @XmlElement (name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlElement(name="type", defaultValue = "OBJ")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

