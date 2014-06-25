package com.emc.vipr.client.fabric;

import com.emc.storageos.fabric.models.*;
import com.emc.storageos.fabric.models.disks.DiskInfo;
import com.emc.storageos.fabric.models.disks.FabricDiskInfo;
import com.emc.storageos.fabric.models.disks.FabricDiskList;
import com.emc.storageos.fabric.models.nodes.FabricNodeList;
import com.emc.vipr.client.fabric.impl.PathConstants;
import com.emc.vipr.client.impl.RestClient;

import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.List;

public class Disks {
    private RestClient client;

    public Disks(RestClient client) {
        this.client = client;
    }

    /**
     * Gets all disks
     * <p>
     *     API Call: <tt>GET /vdc/fabric/disks</tt>
     * </p>
     *
     * @return A list of disks on the fabric
     */
    public List<FabricDiskInfo> list() {
        return client.get(FabricDiskList.class, PathConstants.DISKS_URL).getList();
    }

    /**
     * Gets a specified set of disks
     * <p>
     *     API Call: <tt>GET /vdc/fabric/disks?index={index}&max={max}</tt>
     * </p>
     *
     * @param index  index where to start in the list of items
     * @param max  maximum number of items to return, or -1 if all
     * @return A list of disks on the fabric
     */
    public List<FabricDiskInfo> list(int index, int max) {
        UriBuilder builder = client.uriBuilder(PathConstants.DISKS_URL);
        builder.queryParam("index", index);
        builder.queryParam("max", max);
        return client.getURI(FabricDiskList.class, builder.build()).getList();
    }

    /**
     * Gets information about a fabric disk
     * <p>
     *     API Call: <tt>GET /vdc/fabric/disks/{id}</tt>
     * </p>
     *
     * @param id Gets all disks on the fabric
     * @return A list of disks on the fabric
     */
    public DiskInfo get(URI id) {
        return client.get(DiskInfo.class, PathConstants.DISK_INFO_URL, id);
    }

    /**
     * Gets the capacity of a disk
     * <p>
     *     API Call: <tt>GET /vdc/fabric/disks/{id}/capacity</tt>
     * </p>
     *
     * @param id The disk
     * @return The capacity information for the disk
     */
    public Capacity getCapacity(URI id) {
        return client.get(Capacity.class, PathConstants.DISK_CAPACITY_URL, id);
    }
}
