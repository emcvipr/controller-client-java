package com.emc.vipr.model.object.vpool;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Update object store parameters
 */
@XmlRootElement(name = "data_service_vpool_update")
public class DataServiceVpoolUpdateParam {
    private String name;
    private String description;
    private Boolean allowAllNamespaces;

    public DataServiceVpoolUpdateParam() { }
    public DataServiceVpoolUpdateParam(String name, String description) {
       this(name, description, null);
    }
    public DataServiceVpoolUpdateParam(String name, String description, Boolean allowAllNamespaces) {
        this.name = name;
        this.description = description;
        this.allowAllNamespaces = allowAllNamespaces;
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
    
    /**
     * AllowAllNamespaces to update
     * @valid None
     */
    @XmlElement(required = false)
	public Boolean isAllowAllNamespaces() {
		return allowAllNamespaces;
	}
    
	public void setAllowAllNamespaces(Boolean allowAllNamespaces) {
		this.allowAllNamespaces = allowAllNamespaces;
	}    
}

