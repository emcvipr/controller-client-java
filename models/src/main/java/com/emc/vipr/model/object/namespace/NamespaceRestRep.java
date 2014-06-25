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

import com.emc.storageos.model.DataObjectRestRep;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.net.URI;
import java.util.HashMap;

/**
 * Namespace used for object services bucket defaults and access
 */
@XmlRootElement(name = "namespace")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class NamespaceRestRep extends DataObjectRestRep {
    private URI tenant;
    private URI tenantDefaultProject;
    private URI tenantDefaultVpool;

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
}

