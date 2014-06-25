package com.emc.vipr.client.fabric;

import java.net.URI;
import java.util.List;

import javax.ws.rs.core.UriBuilder;

import com.emc.storageos.fabric.models.Capacity;
import com.emc.storageos.fabric.models.nodes.FabricNode;
import com.emc.storageos.fabric.models.nodes.FabricNodeList;
import com.emc.storageos.fabric.models.services.FabricService;
import com.emc.storageos.fabric.models.services.FabricServiceList;
import com.emc.storageos.fabric.models.services.ServiceInfo;
import com.emc.vipr.client.fabric.impl.PathConstants;
import com.emc.vipr.client.impl.RestClient;

public class Services {
    private RestClient client;

    public Services(RestClient client) {
        this.client = client;
    }

    /**
     * Lists all Services
     * <p>
     * API Call: <tt>GET /vdc/fabric/services</tt>
     *
     * @return the list of services
     */
    public List<FabricService> list() {
        return client.get(FabricServiceList.class, PathConstants.SERVICES_URL).getServiceList();


    }

    /**
     * Lists all Services
     * <p>
     * API Call: <tt>GET /vdc/fabric/services?index={index}&max={max}</tt>
     *
     * @param index  index where to start in the list of items
     * @param max  maximum number of items to return, or -1 if all
     * @return the list of services
     */
    public List<FabricService> list(int index, int max) {
        UriBuilder builder = client.uriBuilder(PathConstants.SERVICES_URL);
        builder.queryParam("index", index);
        builder.queryParam("max", max);
        return client.getURI(FabricServiceList.class, builder.build()).getServiceList();
    }


    /**
     * Get all nodes running the service
     * <p>
     * API Call: <tt>GET /vdc/fabric/services{id}/nodes</tt>
     *
     * @param id The Service
     * @return Information on which nodes the service is deployed on
     */
    public List<FabricNode> getNodes(URI id) {
        return client.get(FabricNodeList.class, PathConstants.SERVICES_NODES_URL, id).getList();
    }

    /**
     * Gets a Service.
     * <p>
     *     API Call: <tt>GET /vdc/fabric/services/{id}</tt>
     * </p>
     *
     * @param id Gets a Service.
     * @return The service
     */
    public ServiceInfo get(URI id) {
        return client.get(ServiceInfo.class, PathConstants.SERVICE_INFO_URL, id);
    }    
    
    /**
     * Get information on which nodes the service is deployed on
     * <p>
     * API Call: <tt>GET /vdc/fabric/services{id}/nodes?index={index}&max={max}</tt>
     *
     * @param id The Service
     * @param index  index where to start in the list of nodes
     * @param max  maximum number of nodes to return, or -1 if all
     * @return Information on which nodes the service is deployed on
     */
    public List<FabricNode> getNodes(URI id, int index, int max) {
        UriBuilder builder = client.uriBuilder(PathConstants.SERVICES_NODES_URL);
        builder.queryParam("index", index);
        builder.queryParam("max", max);
        return client.getURI(FabricNodeList.class, builder.build(id)).getList();
    }

    /**
     * Get capacity information for a service
     * <p>
     * API Call: <tt>GET /vdc/fabric/services/{id}/capacity</tt>
     *
     * @param id The Service
     * @return Capacity information for the service
     */
    public Capacity getCapacity(URI id) {
        return client.get(Capacity.class, PathConstants.SERVICES_CAPACITY_URL, id);
    }
}
