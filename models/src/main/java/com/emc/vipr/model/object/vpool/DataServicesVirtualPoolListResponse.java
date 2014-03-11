package com.emc.vipr.model.object.vpool;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * A list of object stores
 */
@XmlRootElement(name = "data_services_vpools")
public class DataServicesVirtualPoolListResponse {
    private List<DataServicesVirtualPoolRestRep> vpools;

    /**
     * A list of object stores
     * @valid None
     */
    @XmlElement(name = "data_services_vpool", required = true)
    public List<DataServicesVirtualPoolRestRep> getVpools() {
        if (vpools == null) {
            vpools = new ArrayList<DataServicesVirtualPoolRestRep>();
        }
        return vpools;
    }

    public void setVpools(List<DataServicesVirtualPoolRestRep> vpools) {
        this.vpools = vpools;
    }
}

