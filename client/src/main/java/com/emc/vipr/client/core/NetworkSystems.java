package com.emc.vipr.client.core;

import static com.emc.vipr.client.core.util.ResourceUtils.defaultList;

import java.net.URI;
import java.util.List;

import com.emc.storageos.model.BulkIdParam;
import com.emc.storageos.model.NamedRelatedResourceRep;
import com.emc.storageos.model.network.FCEndpointRestRep;
import com.emc.storageos.model.network.FCEndpoints;
import com.emc.storageos.model.network.Fabrics;
import com.emc.storageos.model.network.NetworkSystemBulkRep;
import com.emc.storageos.model.network.NetworkSystemCreate;
import com.emc.storageos.model.network.NetworkSystemList;
import com.emc.storageos.model.network.NetworkSystemRestRep;
import com.emc.storageos.model.network.NetworkSystemUpdate;
import com.emc.storageos.model.network.SanZone;
import com.emc.storageos.model.network.SanZones;
import com.emc.vipr.client.Task;
import com.emc.vipr.client.Tasks;
import com.emc.vipr.client.ViPRCoreClient;
import com.emc.vipr.client.core.filters.ResourceFilter;
import com.emc.vipr.client.core.impl.PathConstants;
import com.emc.vipr.client.impl.RestClient;
import com.emc.vipr.client.core.util.ResourceUtils;

/**
 * Network Systems resources.
 * <p>
 * Base URL: <tt>/vdc/network-systems</tt>
 */
public class NetworkSystems extends AbstractBulkResources<NetworkSystemRestRep> implements
        TopLevelResources<NetworkSystemRestRep>, TaskResources<NetworkSystemRestRep> {
    public NetworkSystems(ViPRCoreClient parent, RestClient client) {
        super(parent, client, NetworkSystemRestRep.class, PathConstants.NETWORK_SYSTEM_URL);
    }

    @Override
    public NetworkSystems withInactive(boolean inactive) {
        return (NetworkSystems) super.withInactive(inactive);
    }

    @Override
    protected List<NetworkSystemRestRep> getBulkResources(BulkIdParam input) {
        NetworkSystemBulkRep response = client.post(NetworkSystemBulkRep.class, input, getBulkUrl());
        return defaultList(response.getNetworkSystems());
    }

    @Override
    public Tasks<NetworkSystemRestRep> getTasks(URI id) {
        return doGetTasks(id);
    }

    @Override
    public Task<NetworkSystemRestRep> getTask(URI id, URI taskId) {
        return doGetTask(id, taskId);
    }

    /**
     * Lists all network systems.
     * <p>
     * API Call: <tt>GET /vdc/network-systems</tt>
     * 
     * @return the list of network system references.
     */
    @Override
    public List<NamedRelatedResourceRep> list() {
        NetworkSystemList response = client.get(NetworkSystemList.class, baseUrl);
        return ResourceUtils.defaultList(response.getSystems());
    }

    /**
     * Gets the list of all network systems. This is a convenience for <tt>getByRefs(list())</tt>.
     * 
     * @return the list of network systems.
     */
    @Override
    public List<NetworkSystemRestRep> getAll() {
        return getAll(null);
    }

    /**
     * Gets the list of all network systems, optionally filtering the results. This is a convenience for
     * <tt>getByRefs(list(), filter)</tt>.
     * 
     * @param filter
     *        the resource filter to apply to the results as they are returned (optional).
     * @return the list of network systems.
     */
    @Override
    public List<NetworkSystemRestRep> getAll(ResourceFilter<NetworkSystemRestRep> filter) {
        List<NamedRelatedResourceRep> refs = list();
        return getByRefs(refs, filter);
    }

    /**
     * Begins creating a network system.
     * <p>
     * API Call: <tt>POST /vdc/network-systems</tt>
     * 
     * @param input
     *        the create configuration.
     * @return a task for monitoring the progress of the operation.
     */
    public Task<NetworkSystemRestRep> create(NetworkSystemCreate input) {
        return postTask(input, baseUrl);
    }

    /**
     * Begins updating a network system by ID.
     * <p>
     * API Call: <tt>PUT /vdc/network-systems/{id}</tt>
     * 
     * @param id
     *        the ID of the network system to update.
     * @param input
     *        the update configuration.
     * @return a task for monitoring the progress of the operation.
     */
    public Task<NetworkSystemRestRep> update(URI id, NetworkSystemUpdate input) {
        return putTask(input, getIdUrl(), id);
    }

    /**
     * Begins deactivating a network system by ID.
     * <p>
     * API Call: <tt>POST /vdc/network-systems/{id}</tt>
     * 
     * @param id
     *        the ID of the network system to deactivate.
     * @return a task for monitoring the progress of the operation.
     */
    public Task<NetworkSystemRestRep> deactivate(URI id) {
        return doDeactivateWithTask(id);
    }

    /**
     * Registers the given network system by ID.
     * <p>
     * API Call: <tt>POST /vdc/network-systems/{id}/register</tt>
     * 
     * @param id
     *        the ID of the network system to register.
     * @return the network system.
     */
    public NetworkSystemRestRep register(URI id) {
        return client.post(NetworkSystemRestRep.class, getIdUrl() + "/register", id);
    }

    /**
     * Deregisters the given network system by ID.
     * <p>
     * API Call: <tt>POST /vdc/network-systems/{id}/deregister</tt>
     * 
     * @param id
     *        the ID of the network system to deregister.
     * @return the network system.
     */
    public NetworkSystemRestRep deregister(URI id) {
        return client.post(NetworkSystemRestRep.class, getIdUrl() + "/deregister", id);
    }

    /**
     * Begins discovery of the given network system by ID.
     * <p>
     * API Call: <tt>POST /vdc/network-systems/{id}/discover</tt>
     * 
     * @param id
     *        the ID of the network system to discover.
     * @return a task for monitoring the progress of the operation.
     */
    public Task<NetworkSystemRestRep> discover(URI id) {
        return postTask(getIdUrl() + "/discover", id);
    }

    /**
     * Gets the list of FC endpoints in the given network system by ID.
     * <p>
     * API Call: <tt>GET /vdc/network-systems/{id}/fc-endpoints</tt>
     * 
     * @param id
     *        the ID of the network system.
     * @return the list of FC endpoints.
     */
    public List<FCEndpointRestRep> getFCEndpoints(URI id) {
        FCEndpoints response = client.get(FCEndpoints.class, getIdUrl() + "/fc-endpoints", id);
        return defaultList(response.getConnections());
    }

    /**
     * Gets the list of SAN fabric names in the given network system by ID.
     * <p>
     * API Call: <tt>GET /vdc/network-systems/{id}/san-fabrics</tt>
     * 
     * @param id
     *        the ID of the network system.
     * @return the list of SAN fabric names.
     */
    public List<String> getSanFabrics(URI id) {
        Fabrics response = client.get(Fabrics.class, getIdUrl() + "/san-fabrics", id);
        return defaultList(response.getFabricIds());
    }

    /**
     * Gets the list of SAN zones in the given network system by ID and fabric name.
     * <p>
     * API Call: <tt>GET /vdc/network-systems/{id}/san-fabrics/{fabric}</tt>
     * 
     * @param id
     *        the ID of the network system.
     * @param fabric
     *        the name of the fabric.
     * @return the list of SAN zones.
     */
    public List<SanZone> getSanZones(URI id, String fabric) {
        SanZones response = client.get(SanZones.class, getIdUrl() + "/san-fabrics/{fabric}", id, fabric);
        return defaultList(response.getZones());
    }

    /**
     * Adds SAN zones to the given network system by ID and fabric name.
     * <p>
     * API Call: <tt>POST /vdc/network-systems/{id}/add-san-zones/{fabric}</tt>
     * 
     * @param id
     *        the ID of the network system.
     * @param fabric
     *        the name of the fabric.
     * @param input
     *        the SAN zones configuration.
     * @return a task for monitoring the progress of the operation.
     */
    public Task<NetworkSystemRestRep> addSanZones(URI id, String fabric, SanZones input) {
        return postTask(input, getIdUrl() + "/add-san-zones/{fabric}", id, fabric);
    }

    /**
     * Removes a SAN zone from the given network system by ID and fabric name.
     * <p>
     * API Call: <tt>POST /vdc/network-systems/{id}/remove-san-zones/{fabric}</tt>
     * 
     * @param id
     *        the ID of the network system.
     * @param fabric
     *        the name of the fabric.
     * @param input
     *        the SAN zones configuration.
     * @return a task for monitoring the progress of the operation.
     */
    public Task<NetworkSystemRestRep> removeSanZones(URI id, String fabric, SanZones input) {
        return postTask(input, getIdUrl() + "/remove-san-zones/{fabric}", id, fabric);
    }
}
