/**
 *  Copyright (c) 2008-2012 EMC Corporation
 * All Rights Reserved
 *
 * This software contains the intellectual property of EMC Corporation
 * or is licensed to EMC Corporation from third parties.  Use of this
 * software and the intellectual property contained therein is expressly
 * limited to the terms and conditions of the License Agreement under which
 * it is provided by or on behalf of EMC.
 */

package com.emc.vipr.model.object.namespace;

import java.net.URI;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.emc.storageos.model.DataObjectRestRep;

/**
 * Namespace used for object services bucket defaults and access
 */
@XmlRootElement(name = "namespace")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class NamespaceRestRep extends DataObjectRestRep {
    private URI tenant;
    private URI tenantDefaultProject;
    private URI tenantDefaultVpool;
    private List<URI> listOfAllowedVpoolsList;
    private List<URI> listOfDisAllowedVpoolsList;

    /**
     * the tenant for the vdc
     */
    @XmlElement
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
     * List of Data Services Vpools that are allowed access to Namespace
     * @valid None
     */
    @XmlElement(required = false, name = "allowed_vpools_list")
	public List<URI> getListOfAllowedVpoolsList() {
		return listOfAllowedVpoolsList;
	}

	public void setListOfAllowedVpoolsList(List<URI> listOfAllowedVpoolsList) {
		this.listOfAllowedVpoolsList = listOfAllowedVpoolsList;
	}

	/**
	 * List of Data Services Vpools that are not allowed access to Namespace
	 * @valid None
	 */
	@XmlElement(required = true, name = "disallowed_vpools_list")
	public List<URI> getListOfDisAllowedVpoolsList() {
		return listOfDisAllowedVpoolsList;
	}

	public void setListOfDisAllowedVpoolsList(List<URI> listOfDisAllowedVpoolsList) {
		this.listOfDisAllowedVpoolsList = listOfDisAllowedVpoolsList;
	}
    
    
}

