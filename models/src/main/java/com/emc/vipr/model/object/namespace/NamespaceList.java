package com.emc.vipr.model.object.namespace;

import com.emc.vipr.model.object.ObjectNamedRelatedResourceRep;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * A list of namespaces
 */
@XmlRootElement(name = "namespaces")
public class NamespaceList {
    private List<ObjectNamedRelatedResourceRep> namespaces;

    public void addNamespace(ObjectNamedRelatedResourceRep namespace) {
        getNamespaces().add(namespace);
    }

    /**
     * A list of namespaces
     * @valid None
     */
    @XmlElement(name = "namespace")
    public List<ObjectNamedRelatedResourceRep> getNamespaces() {
        if (namespaces == null) {
            namespaces = new ArrayList<ObjectNamedRelatedResourceRep>();
        }
        return namespaces;
    }

    public void setNamespaces(List<ObjectNamedRelatedResourceRep> namespaces) {
        this.namespaces = namespaces;
    }
}
