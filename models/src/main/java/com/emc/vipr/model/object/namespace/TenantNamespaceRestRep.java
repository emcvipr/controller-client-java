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

import com.emc.storageos.model.RelatedResourceRep;
import com.emc.storageos.model.DataObjectRestRep;
import com.emc.vipr.model.object.ObjectRelatedResourceRep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Tenant's namespace information
 */
@XmlRootElement(name = "tenant_namespace_response")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class TenantNamespaceRestRep extends DataObjectRestRep {

    private String _namespace;
    private ObjectRelatedResourceRep _defaultVpool;
    private RelatedResourceRep _defaultProject;

    /**
     * Namespace identifier
     * @valid None
     * @return Namespace
     */
    @XmlElement(name = "namespace")
    public String getNamespace() {
        return _namespace;
    }

    public void setNamespace(String namespace) {
        _namespace = namespace;
    }

    /**
     * Default Object CoS
     * @valid None
     * @return default object Cos
     */
    @XmlElement(name = "default_data_services_vpool")
    public ObjectRelatedResourceRep getDefaultObjectCos() {
        return _defaultVpool;
    }

    public void setDefaultObjectCos(ObjectRelatedResourceRep vpool) {
        this._defaultVpool = vpool;
    }

    /**
     * Default Object Project
     * @valid None
     * @return Default object project
     */
    @XmlElement(name = "default_object_project")
    public RelatedResourceRep getDefaultObjectProject() {
        return _defaultProject;
    }

    public void setDefaultObjectProject(RelatedResourceRep defaultObjectProject) {
        _defaultProject = defaultObjectProject;
    }
}
