package com.emc.vipr.model.object.vpool;


import com.emc.storageos.model.StringHashMapEntry;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import java.net.URI;
import java.util.List;
import java.util.Map;

/**
 * Create data services virtual pool parameters
 */
@XmlRootElement(name = "data_service_vpool_create")
public class DataServiceVpoolCreateParam {
    private String id;
    private String name;
    private String description;
    private List<StringHashMapEntry> mappings;
    private Boolean allowAllNamespaces;

    public DataServiceVpoolCreateParam() { }
    public DataServiceVpoolCreateParam(String name, String description, List<StringHashMapEntry> mappings, Boolean allowedAllNamespaces) {
        this(null, name, description, mappings, allowedAllNamespaces);
    }
    

    /**
     * This constructor is used when allowAllNamespaces param is not based
     * @param name
     * @param description
     * @param mappings
     */
    public DataServiceVpoolCreateParam(String name, String description, List<StringHashMapEntry> mappings) {
        this(null, name, description, mappings, null);
    }
    
    public DataServiceVpoolCreateParam(String id, String name, String description, List<StringHashMapEntry> mappings, Boolean allowAllNamespaces) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.mappings = mappings;
        this.allowAllNamespaces = allowAllNamespaces;
    }

    /**
     * identifier for this vpool
     * @valid Should be uuid
    */
    @XmlElement(required = true)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * Unique name identifying this classification of data service vpool
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
     * Description of this object vpool
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

    /**
     * List of varrayId-zoneId tuples with are associated with the same vpool created under data-services
     * @return a list of varray-zoneid tuples associated with a particular vpool
     */
    @XmlElement (name = "zone_mappings")
    public List<StringHashMapEntry> getVarrayMappings() {
        return mappings;
    }

    public void setVarrayMappings( List<StringHashMapEntry> mappings) {
        this.mappings = mappings;
    }

    /**
     * set if Vpool Allows access to all Namespaces for dataservices
     * @valid None
     */
    @XmlElement(required = false, name = "isAllowAllNamespaces", defaultValue = "true")
    public Boolean isAllowAllNamespaces() {
    	if (this.allowAllNamespaces == null)
    	{
    		return new Boolean(true);
    	}
		return this.allowAllNamespaces;
	}

	public void setAllowAllNamespaces(Boolean allowAllNamespaces) {
		this.allowAllNamespaces = allowAllNamespaces;
	}
}

