package com.emc.vipr.model.object.namespace;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Namespace update parameters
 */
@XmlRootElement(name = "namespace_update")
public class NamespaceUpdateParam {
    private List<NamespaceVDCParam> vdcs;

    public NamespaceUpdateParam() { }
    public NamespaceUpdateParam(List<NamespaceVDCParam> vdcs) {
        this.vdcs = vdcs;
    }

    /**
     * List of zones associated with this namespace. Each zone has an associated tenant.
     * @valid None
     */
    @XmlElement(name = "vdc_update")
    public List<NamespaceVDCParam> getVdcs() {
        if (vdcs == null) {
            vdcs = new ArrayList<NamespaceVDCParam>();
        }
        return vdcs;
    }

    public void setVdcs(List<NamespaceVDCParam> vdcs) {
        this.vdcs = vdcs;
    }
}
