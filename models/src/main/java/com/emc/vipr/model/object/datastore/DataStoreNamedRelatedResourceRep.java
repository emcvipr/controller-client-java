package com.emc.vipr.model.object.datastore;

import com.emc.storageos.model.RestLinkRep;
import com.emc.vipr.model.object.ObjectNamedRelatedResourceRep;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.net.URI;

/**
 * data store response with data store type.
 */
@XmlRootElement(name = "data_store_named_related_resource_rep")
public class DataStoreNamedRelatedResourceRep extends ObjectNamedRelatedResourceRep {
    private String resourceType;

    public DataStoreNamedRelatedResourceRep() {
        super();
    }

    public DataStoreNamedRelatedResourceRep(URI id, RestLinkRep selfLink, String name, String resourceType) {
        super(id, selfLink, name);
        this.resourceType = resourceType;
    }

    @XmlElement(name = "resource_type")
    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }
}
