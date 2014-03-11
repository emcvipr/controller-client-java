package com.emc.vipr.client.core.util;

import com.emc.storageos.model.vpool.NamedRelatedVirtualPoolRep;
import java.util.ArrayList;
import java.util.List;

public class VirtualPoolUtils {
    public static final String FILE = "file";
    public static final String BLOCK = "block";

    public static List<NamedRelatedVirtualPoolRep> fileVpools(List<NamedRelatedVirtualPoolRep> pools) {
        return byType(pools, FILE);
    }

    public static List<NamedRelatedVirtualPoolRep> blockVpools(List<NamedRelatedVirtualPoolRep> pools) {
        return byType(pools, BLOCK);
    }

    private static List<NamedRelatedVirtualPoolRep> byType(List<NamedRelatedVirtualPoolRep> pools, String type) {
        List<NamedRelatedVirtualPoolRep> response = new ArrayList<NamedRelatedVirtualPoolRep>();
        for (NamedRelatedVirtualPoolRep pool: pools) {
            if (type.equalsIgnoreCase(pool.getVirtualPoolType())) {
                response.add(pool);
            }
        }
        return response;
    }
}
