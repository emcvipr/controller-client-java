package com.emc.vipr.model.object.bucket;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Object bucket owner update parameters.
 */
@XmlRootElement(name = "object_bucket_update_owner")
public class UpdateBucketOwnerParam {

    private String namespace;
    private String newOwner;

    public UpdateBucketOwnerParam() { }

    /**
     * Namespace that is allowed to access this bucket
     * @valid none
     */
    @XmlElement(required = true, name = "namespace")
    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    /**
     * New owner of the bucket
     * @valid none
     */
    @XmlElement(required = true, name = "new_owner")
    public String getNewOwner() {
        return newOwner;
    }

    public void setNewOwner(String newOwner) {
        this.newOwner = newOwner;
    }
}
