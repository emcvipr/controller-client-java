package com.emc.vipr.client.core.search;

import com.emc.storageos.model.varray.VirtualArrayRestRep;
import com.emc.vipr.client.core.AbstractResources;
import static com.emc.vipr.client.core.impl.SearchConstants.*;

public class VirtualArraySearchBuilder extends SearchBuilder<VirtualArrayRestRep> {
    public VirtualArraySearchBuilder(AbstractResources<VirtualArrayRestRep> resources) {
        super(resources);
    }

    public SearchBuilder<VirtualArrayRestRep> byInitiatorPort(String initiatorPort) {
        return by(INITIATOR_PORT_PARAM, initiatorPort);
    }
}
