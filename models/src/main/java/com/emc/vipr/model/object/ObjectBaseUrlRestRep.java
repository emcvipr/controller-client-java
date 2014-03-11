/**
 *  Copyright (c) 2008-2011 EMC Corporation
 * All Rights Reserved
 *
 * This software contains the intellectual property of EMC Corporation
 * or is licensed to EMC Corporation from third parties.  Use of this
 * software and the intellectual property contained therein is expressly
 * limited to the terms and conditions of the License Agreement under which
 * it is provided by or on behalf of EMC.
 */
package com.emc.vipr.model.object;

import com.emc.storageos.model.DataObjectRestRep;
import org.codehaus.jackson.annotate.JsonProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Base URL representation
 */
@XmlRootElement(name = "base_url")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class ObjectBaseUrlRestRep extends DataObjectRestRep {
    private String _baseUrl;
    private Boolean _namespaceInHost;

    /**
     * Base URL
     * @valid None
     * @return Base URL
     */
    @XmlElement(name="baseurl")
    public String getBaseUrl() {
        return _baseUrl;
    }

    /**
     * Flag indicating whether namespace is a part of the host
     * @valid None
     * @return namespace flag
     */
    @XmlElement(name="namespace_in_host")
    @JsonProperty("baseUrlNamespaceInHostFlag")
    public Boolean getNamespaceInHost() {
        return _namespaceInHost;
    }

    public void setBaseUrl(String _baseUrl) {
        this._baseUrl = _baseUrl;
    }

    public void setNamespaceInHost(Boolean _namespaceInHost) {
        this._namespaceInHost = _namespaceInHost;
    }
}
