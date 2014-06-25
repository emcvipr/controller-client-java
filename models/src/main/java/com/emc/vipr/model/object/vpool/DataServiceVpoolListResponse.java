package com.emc.vipr.model.object.vpool;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * A list of object vpools
 */
@XmlRootElement(name = "data_service_vpools")
public class DataServiceVpoolListResponse {
    private List<DataServiceVpoolRestRep> vpools;

    /**
     * A list of dataservice vpools
     * @valid None
     * @return list of object vpools on this system
     */
    @XmlElement(name = "data_service_vpool", required = true)
    public List<DataServiceVpoolRestRep> getVpools() {
        if (vpools == null) {
            vpools = new ArrayList<DataServiceVpoolRestRep>();
        }
        return vpools;
    }

    public void setVpools(List<DataServiceVpoolRestRep> vpools) {
        this.vpools = vpools;
    }
}

