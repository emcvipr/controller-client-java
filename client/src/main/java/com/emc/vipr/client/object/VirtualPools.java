package com.emc.vipr.client.object;

import com.emc.vipr.client.impl.RestClient;
import com.emc.vipr.model.object.datastore.DataStoreList;
import com.emc.vipr.model.object.datastore.DataStoreNamedRelatedResourceRep;
import com.emc.vipr.model.object.vpool.DataServicesVirtualPoolCreateParam;
import com.emc.vipr.model.object.vpool.DataServicesVirtualPoolListResponse;
import com.emc.vipr.model.object.vpool.DataServicesVirtualPoolRestRep;
import com.emc.vipr.model.object.vpool.DataServicesVirtualPoolUpdateParam;

import java.net.URI;
import java.util.List;

import static com.emc.vipr.client.object.impl.PathConstants.*;

public class VirtualPools {
    private RestClient client;

    public VirtualPools(RestClient client) {
        this.client = client;
    }

    /**
     * Retrieves all data services virtual pools
     * <p>
     *     API Call: <tt>GET /object/data-services-vpools</tt>
     * </p>
     *
     * @return All virtual pools.
     */
    public List<DataServicesVirtualPoolRestRep> getAll() {
        return client.get(DataServicesVirtualPoolListResponse.class, OBJECT_VPOOLS_URL).getVpools();
    }

    /**
     * Creates a new data services virtual pool.
     * <p>
     *     API Call: <tt>POST /object/data-services-vpools</tt>
     * </p>
     *
     * @param create Creation parameters.
     * @return The virtual pool.
     */
    public DataServicesVirtualPoolRestRep create(DataServicesVirtualPoolCreateParam create) {
        return client.post(DataServicesVirtualPoolRestRep.class, create, OBJECT_VPOOLS_URL);
    }

    /**
     * Lists data stores for the specified virtual pool.
     * <p>
     *     API Call: <tt>GET /object/data-services-vpools/{id}/data-stores</tt>
     * </p>
     * @param vpoolId Virtual pool identifier.
     * @return List of references to data stores in this virtual pool.
     */
    public List<DataStoreNamedRelatedResourceRep> listDataStores(URI vpoolId) {
        return client.get(DataStoreList.class, OBJECT_VPOOLS_URL + ID_PATH + DATA_STORES_PATH, vpoolId).getPools();
    }

    /**
     * Retrieves a virtual pool.
     * <p>
     *     API Call: <tt>GET /object/data-services-vpools/{id}</tt>
     * </p>
     *
     * @param id Identifier of the virtual pool.
     * @return The virtual pool.
     */
    public DataServicesVirtualPoolRestRep get(URI id) {
        return client.get(DataServicesVirtualPoolRestRep.class, OBJECT_VPOOLS_URL + ID_PATH, id);
    }

    /**
     * Updates a virtual pool.
     * <p>
     *     API Call: <tt>PUT /object/data-services-vpools/{id}</tt>
     * </p>
     *
     * @param id Identifier of the virtual pool.
     * @param param Update parameters to the virtual pool.
     */
    public void update(URI id, DataServicesVirtualPoolUpdateParam param) {
        client.put(String.class, param, OBJECT_VPOOLS_URL + ID_PATH, id);
    }

    /**
     * Deactivates a virtual pool.
     * <p>
     *     API Call: <tt>POST /object/data-services-vpools/{id}/deactivate</tt>
     * </p>
     *
     * @param id Identifier of the virtual pool.
     */
    public void deactivate(URI id) {
        client.post(String.class, OBJECT_VPOOLS_URL + ID_PATH + DEACTIVATE_PATH, id);
    }
}
