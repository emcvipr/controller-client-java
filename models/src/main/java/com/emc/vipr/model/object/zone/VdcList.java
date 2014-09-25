package com.emc.vipr.model.object.zone;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * List zone Info
 */
@XmlRootElement(name = "vdc_list")
public class VdcList {
    private List<VdcRestRep> vdcList = new ArrayList<VdcRestRep>();

    public void addVdc(VdcRestRep vdc) {
        vdcList.add(vdc);
    }

    /**
     * A list of vdc
     * @valid None
     */
    @XmlElement(name = "vdc")
    public List<VdcRestRep> getVdcList() {
        return vdcList;
    }
}
