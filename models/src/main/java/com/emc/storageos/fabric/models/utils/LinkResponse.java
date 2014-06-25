package com.emc.storageos.fabric.models.utils;

import java.io.Serializable;
import java.net.URI;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * Class for creating a self link for a REST response
 *
 */
public class LinkResponse implements Serializable {
    private String linkName;
    private URI linkRef;

    public LinkResponse() {}

    public LinkResponse(String link, URI ref) {
        this.linkName = link;
        this.linkRef = ref;
    }

    @XmlAttribute(name = "rel")
    public String getLinkName() { 
        return linkName; 
    }
    
    public void setLinkName(String link) {
        linkName = link; 
    }

    @XmlAttribute(name = "href")
    public URI getLinkRef() { 
        return linkRef; 
    }
    
    public void setLinkRef(URI ref) {
        linkRef = ref;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((linkName == null) ? 0 : linkName.hashCode());
        result = prime * result
                + ((linkRef == null) ? 0 : linkRef.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        LinkResponse other = (LinkResponse) obj;
        if (linkName == null) {
            if (other.linkName != null)
                return false;
        } else if (!linkName.equals(other.linkName))
            return false;
        if (linkRef == null) {
            if (other.linkRef != null)
                return false;
        } else if (!linkRef.equals(other.linkRef))
            return false;
        return true;
    }
}
