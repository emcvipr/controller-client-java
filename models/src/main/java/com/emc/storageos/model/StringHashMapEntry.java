/*
 * Copyright (c) 2008-2011 EMC Corporation
 * All Rights Reserved
 */

package com.emc.storageos.model;

import javax.xml.bind.annotation.XmlElement;

/**
 * The class represent an entry for REST representation of a Map<String,String>
 * 
 */
public class StringHashMapEntry {

    private String name;
    private String value;

    public StringHashMapEntry() {
    }

    public StringHashMapEntry(String name, String value) {
        this.name = name;
        this.value = value;
    }

    @XmlElement(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name = "value")
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        int h = this.getName().hashCode() + 31 * this.getValue().hashCode();
        return h;
    }

    @Override
    public boolean equals(Object object) {
        boolean result = false;
        if (object instanceof StringHashMapEntry)
        {
            StringHashMapEntry otherobject = (StringHashMapEntry) object;
            if (this.name.equals(otherobject.getName()) && this.value.equals(otherobject.getValue())) {
                result = true;
            }
        }
        return result;
    }
}
