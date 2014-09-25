package com.emc.vipr.model.object.namespace;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * Namespace update parameters
 */
@XmlRootElement(name = "namespace_update")
public class NamespaceUpdateParam {
    private URI tenant;
    private URI tenantDefaultProject;
    private URI tenantDefaultVpool;
    private List<URI> listOfVpoolsAddedToAllowedVpoolsList;
    private List<URI> listOfVpoolsAddedToDisAllowedVpoolsList;
    private List<URI> listOfVpoolsRemovedFromAllowedVpoolsList;
    private List<URI> listOfVpoolsRemovedFromDisAllowedVpoolsList;

    public NamespaceUpdateParam() {
    }

    public NamespaceUpdateParam(final URI tenant, final URI tenantDefaultProject, final URI tenantDefaultVpool,
    		                    final List<URI> listOfVpoolsAddedToAllowedVpoolsList, final List<URI> listOfVpoolsAddedToDisAllowedVpoolsList,
    		                    final List<URI> listOfVpoolsRemovedFromAllowedVpoolsList, final List<URI> listVpoolsRemovedFromDisAllowedVpoolsList) {
        this.tenant = tenant;
        this.tenantDefaultProject = tenantDefaultProject;
        this.tenantDefaultVpool = tenantDefaultVpool;
        this.listOfVpoolsAddedToAllowedVpoolsList = listOfVpoolsAddedToAllowedVpoolsList;
        this.listOfVpoolsAddedToDisAllowedVpoolsList = listOfVpoolsAddedToDisAllowedVpoolsList;
        this.listOfVpoolsRemovedFromAllowedVpoolsList = listOfVpoolsRemovedFromAllowedVpoolsList;
        this.listOfVpoolsRemovedFromDisAllowedVpoolsList = listVpoolsRemovedFromDisAllowedVpoolsList;
    }
    
    public NamespaceUpdateParam(final URI tenant, final URI tenantDefaultProject, final URI tenantDefaultVpool) {
		this.tenant = tenant;
		this.tenantDefaultProject = tenantDefaultProject;
		this.tenantDefaultVpool = tenantDefaultVpool;
		this.listOfVpoolsAddedToAllowedVpoolsList = new ArrayList<URI>();
        this.listOfVpoolsAddedToDisAllowedVpoolsList = new ArrayList<URI>();
        this.listOfVpoolsRemovedFromAllowedVpoolsList = new ArrayList<URI>();
        this.listOfVpoolsRemovedFromDisAllowedVpoolsList = new ArrayList<URI>();
	}

    /**
     * ID of tenant associated with this namespace
     * @valid None
     */
    @XmlElement(required = true)
    public URI getTenant() {
        return tenant;
    }

    public void setTenant(final URI tenant) {
        this.tenant = tenant;
    }

    /**
     * Default project id for this tenant when creating buckets
     * @valid None
     */
    @XmlElement(required = false, name = "default_object_project")
    public URI getTenantDefaultProject() {
        return tenantDefaultProject;
    }

    public void setTenantDefaultProject(final URI tenantDefaultProject) {
        this.tenantDefaultProject = tenantDefaultProject;
    }

    /**
     * Default data services vpool identifier for this tenant when creating buckets
     * @valid None
     */
    @XmlElement(required = false, name = "default_data_services_vpool")
    public URI getTenantDefaultVpool() {
        return tenantDefaultVpool;
    }

    public void setTenantDefaultVpool(final URI tenantDefaultVpool) {
        this.tenantDefaultVpool = tenantDefaultVpool;
    }

    /**
     * List of data services vpools identifier which will be added in the allowed List for allowing Namespace access 
     * @valid None
     */
    @XmlElement(required = false, name = "vpools_added_to_allowed_vpools_list")
    public List<URI> getListOfVpoolsAddedToAllowedVpoolsList() {
		return listOfVpoolsAddedToAllowedVpoolsList;
	}

	public void setListOfVpoolsAddedToAllowedVpoolsList(
			List<URI> listOfVpoolsAddedToAllowedVpoolsList) {
		this.listOfVpoolsAddedToAllowedVpoolsList = listOfVpoolsAddedToAllowedVpoolsList;
	}

	/**
	 * List of data services vpools identifier which will be added in the DisAllowed List for prohibiting Namespace access
	 * @valid None
	 */
	@XmlElement(required = false, name = "vpools_added_to_disallowed_vpools_list")
	public List<URI> getListOfVpoolsAddedToDisAllowedVpoolsList() {
		return listOfVpoolsAddedToDisAllowedVpoolsList;
	}

	public void setListOfVpoolsAddedToDisAllowedVpoolsList(
			List<URI> listOfVpoolsAddedToDisAllowedVpoolsList) {
		this.listOfVpoolsAddedToDisAllowedVpoolsList = listOfVpoolsAddedToDisAllowedVpoolsList;
	}

	/**
	 * List of data services vpools identifier which will be removed from Allowed List
	 * @valid None
	 */
	@XmlElement(required = false, name = "vpools_removed_from_allowed_vpools_list")
	public List<URI> getListOfVpoolsRemovedFromAllowedVpoolsList() {
		return listOfVpoolsRemovedFromAllowedVpoolsList;
	}

	public void setListOfVpoolsRemovedFromAllowedVpoolsList(
			List<URI> listOfVpoolsRemovedFromAllowedVpoolsList) {
		this.listOfVpoolsRemovedFromAllowedVpoolsList = listOfVpoolsRemovedFromAllowedVpoolsList;
	}

	/**
	 * List of data services vpools identifier which will be removed from DisAllowed List for removing their prohibition Namespace Access
	 * @valid None
	 */
	@XmlElement(required = false, name = "vpools_removed_from_disallowed_vpools_list")
	public List<URI> getListOfVpoolsRemovedFromDisAllowedVpoolsList() {
		return listOfVpoolsRemovedFromDisAllowedVpoolsList;
	}

	public void setListOfVpoolsRemovedFromDisAllowedVpoolsList(
			List<URI> listOfVpoolsRemovedFromDisAllowedVpoolsList) {
		this.listOfVpoolsRemovedFromDisAllowedVpoolsList = listOfVpoolsRemovedFromDisAllowedVpoolsList;
	}
    
    
}
