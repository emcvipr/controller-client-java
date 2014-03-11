package com.emc.vipr.model.object.namespace;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Namespace creation parameters
 */
@XmlRootElement(name = "namespace_create")
public class NamespaceCreateParam {
    private String namespace;
    private List<NamespaceVDCParam> vdcs;

    public NamespaceCreateParam() { }
    public NamespaceCreateParam(String namespace, List<NamespaceVDCParam> vdcs) {
        this.namespace = namespace;
        this.vdcs = vdcs;
    }

    /**
     * User provided namespace (verified unique)
     * <p>can not include dots or slashes (.|/) in the name</p>
     * @valid Can contain slashes (/)
     * @valid Can contain dots (.)
     */
    @XmlElement(required = true)
    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    /**
     * List of vdcs associated with this namespace. Each vdc has an associated tenant.
     * @valid None
     */
    @XmlElement(name = "vdcs")
    public List<NamespaceVDCParam> getVDCs() {
        if (vdcs == null) {
            vdcs = new ArrayList<NamespaceVDCParam>();
        }
        return vdcs;
    }

    public void setVDCs(List<NamespaceVDCParam> vdcs) {
        this.vdcs = vdcs;
    }
}
