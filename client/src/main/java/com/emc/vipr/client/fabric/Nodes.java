package com.emc.vipr.client.fabric;

import com.emc.storageos.fabric.models.Capacity;
import com.emc.storageos.fabric.models.nodes.*;
import com.emc.storageos.fabric.models.utils.CommonInfo;
import com.emc.storageos.model.block.export.ITLRestRepList;
import com.emc.vipr.client.fabric.impl.PathConstants;
import com.emc.vipr.client.impl.RestClient;

import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.List;

import static com.emc.vipr.client.core.util.ResourceUtils.defaultList;


public class Nodes  {
    private RestClient client;

    public Nodes(RestClient client) {
        this.client = client;
    }

    /**
     * Lists all Nodes.
     * <p>
     * API Call: <tt>GET /vdc/fabric/nodes</tt>
     *
     * @return the list of node references.
     */
    public List<FabricNode> list() {
        return client.get(FabricNodeList.class, PathConstants.NODES_URL).getList();
    }

    /**
     * Lists a specified set of nodes
     * <p>
     * API Call: <tt>GET /vdc/fabric/nodes?max={max}&index={index}</tt>
     *
     * @param index  index where to start in the list of items
     * @param max  maximum number of items to return, or -1 if all
     * @return the list of node references.
     */
    public List<FabricNode> list(int index, int max) {
        UriBuilder builder = client.uriBuilder(PathConstants.NODES_URL);
        builder.queryParam("index", index);
        builder.queryParam("max", max);
        return client.getURI(FabricNodeList.class, builder.build()).getList();
    }

    /**
     * Gets an Node.
     * <p>
     *     API Call: <tt>GET /vdc/fabric/nodes/{id}</tt>
     * </p>
     *
     * @param id Gets an node.
     * @return The node
     */
    public NodeInfo get(URI id) {
        return client.get(NodeInfo.class, PathConstants.NODE_INFO_URL, id);
    }

    /**
     * Returns the capacity of a node
     * <p>
     *     API Call: <tt>GET /vdc/fabric/nodes/{id}/capacity</tt>
     * </p>
     *
     * @param id The Node
     * @return The capacity of the node
     */
    public Capacity getCapacity(URI id) {
        return client.get(Capacity.class, PathConstants.NODE_CAPACITY_URL, id);
    }

    /**
     * Gets all disks on node.
     * <p>
     *     API Call: <tt>GET /vdc/fabric/nodes/{id}/disks</tt>
     * </p>
     *
     * @param id The Node
     * @return A list of the disks on the node
     */
    public List<NodeDisk> getDisks(URI id) {
        return client.get(NodeDiskList.class, PathConstants.NODE_DISKS_URL, id).getList();
    }

    /**
     * Gets all disks on node.
     * <p>
     *     API Call: <tt>GET /vdc/fabric/nodes/{id}/disks?index={index}&max={max}</tt>
     * </p>
     *
     * @param id The Node
     * @param id The Service
     * @param index  index where to start in the list of nodes
     * @param max  maximum number of nodes to return, or -1 if all
     * @return A list of the disks on the node
     */
    public List<NodeDisk> getDisks(URI id, int index, int max) {
        UriBuilder builder = client.uriBuilder(PathConstants.NODE_DISKS_URL);
        builder.queryParam("index", index);
        builder.queryParam("max", max);
        return client.getURI(NodeDiskList.class, builder.build(id)).getList();
    }


    /**
     * Gets the health of a node.
     * <p>
     *     API Call: <tt>GET /vdc/fabric/nodes/{id}/health</tt>
     * </p>
     *
     * @param id The Node
     * @return The health of the node
     */
    public NodeHealth getHealth(URI id) {
        return client.get(NodeHealth.class, PathConstants.NODE_HEALTH_URL, id);
    }
}
