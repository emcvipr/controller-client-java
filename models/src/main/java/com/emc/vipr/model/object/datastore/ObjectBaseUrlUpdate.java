package com.emc.vipr.model.object.datastore;

import org.codehaus.jackson.annotate.JsonProperty;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Parameter for base url creation
 */
@XmlRootElement(name = "object_base_url_update")
public class ObjectBaseUrlUpdate {
    private String name;
    private String baseUrl;
    private Boolean isNamespaceInHost;

    /**
     * Name for this base-url
     */
    @XmlElement(required = true, name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Base URL to be used
     */
    @XmlElement(required = true, name = "base_url")
    @JsonProperty("base_url")
    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @XmlElement(required = true , name = "is_namespace_in_host")
    @JsonProperty("is_namespace_in_host")
    public Boolean getIsNamespaceInHost() {
        return isNamespaceInHost;
    }

    public void setIsNamespaceInHost(Boolean isNamespaceInHost) {
        this.isNamespaceInHost = isNamespaceInHost;
    }
}
