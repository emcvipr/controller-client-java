/**
 * Copyright (c) 2013 EMC Corporation
 * All Rights Reserved
 *
 * This software contains the intellectual property of EMC Corporation
 * or is licensed to EMC Corporation from third parties.  Use of this
 * software and the intellectual property contained therein is expressly
 * limited to the terms and conditions of the License Agreement under which
 * it is provided by or on behalf of EMC.
 */
package com.emc.storageos.model.tenant;

import javax.xml.bind.annotation.XmlElement;

import org.codehaus.jackson.annotate.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class UserMappingAttributeParam {
    private String key;
    private List<String> values;
    
    public UserMappingAttributeParam() {}

    public UserMappingAttributeParam(String key, List<String> values) {
        this.key = key;
        this.values = values;
    }

    /**
     * 
     * Lookup string for this key-value pair
     * 
     * @valid none
     */
    @XmlElement(required=true, name="key")
    @JsonProperty("key")
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    /**
     * 
     * Lookup result for this key-value pair
     * 
     * @valid none
     */
    @XmlElement(required=true, name="value")
    public List<String> getValues() {
        if (values == null) {
            values = new ArrayList<String>();
        }
        return values;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }
}