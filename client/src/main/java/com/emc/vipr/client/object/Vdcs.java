package com.emc.vipr.client.object;

import java.util.List;

import com.emc.vipr.client.core.util.ResourceUtils;
import com.emc.vipr.client.impl.RestClient;
import com.emc.vipr.client.object.impl.PathConstants;
import com.emc.vipr.model.object.zone.VdcInsertParam;
import com.emc.vipr.model.object.zone.VdcList;
import com.emc.vipr.model.object.zone.VdcRestRep;

public class Vdcs {
    private RestClient client;

    public Vdcs(RestClient client) {
        this.client = client;
    }

    public List<VdcRestRep> list() {
        VdcList list = client.get(VdcList.class, PathConstants.VDC_LIST_URL);
        return ResourceUtils.defaultList(list != null ? list.getVdcList() : null);
    }
    
    public VdcRestRep getVdc(String vdcName) {
        return client.get(VdcRestRep.class, PathConstants.VDC_URL, vdcName);
    }

    public void updateVdc(String vdcName, VdcInsertParam param) {
        client.put(String.class, param, PathConstants.VDC_URL, vdcName);
    }
}
