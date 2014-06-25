package com.emc.vipr.client.fabric;

import java.util.List;

import com.emc.storageos.fabric.models.NodeStats;
import com.emc.storageos.fabric.models.StatsList;
import com.emc.vipr.client.fabric.impl.PathConstants;
import com.emc.vipr.client.impl.RestClient;

public class Stats {
    private RestClient client;

    public Stats(RestClient client) {
        this.client = client;
    }

    /**
     * Lists stat information across all nodes
     * <p>
     * API Call: <tt>GET /vdc/fabric/stats</tt>
     *
     * @return List of stat information across all nodes
     */
    public List<NodeStats> list() {
        return client.get(StatsList.class, PathConstants.STATS_URL).getList();
    }
}
