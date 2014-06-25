package com.emc.vipr.client.object;

import static com.emc.vipr.client.object.impl.PathConstants.ADD_VARRAY_PATH;
import static com.emc.vipr.client.object.impl.PathConstants.DATA_STORES_PATH;
import static com.emc.vipr.client.object.impl.PathConstants.DEACTIVATE_PATH;
import static com.emc.vipr.client.object.impl.PathConstants.ID_PATH;
import static com.emc.vipr.client.object.impl.PathConstants.OBJECT_VDC_VPOOLS_URL;
import static com.emc.vipr.client.object.impl.PathConstants.REMOVE_VARRAY_PATH;

import java.net.URI;
import java.util.List;

import com.emc.vipr.client.impl.RestClient;
import com.emc.vipr.model.object.datastore.DataStoreList;
import com.emc.vipr.model.object.vpool.DataServiceVpoolCreateParam;
import com.emc.vipr.model.object.vpool.DataServiceVpoolListResponse;
import com.emc.vipr.model.object.vpool.DataServiceVpoolRestRep;
import com.emc.vipr.model.object.vpool.DataServiceVpoolUpdateParam;
import com.emc.vipr.model.object.vpool.DataServiceVpoolVarrayInfo;

public class ObjectDataServiceVpools {
    private RestClient client;

    public ObjectDataServiceVpools(RestClient client) {
        this.client = client;
    }


    /**
     * Retrieves all Data-service virtual pools
     * <p>
     *     API Call: <tt>GET /vdc/data-service/vpools</tt>
     * </p>
     *
     * @return All Data-service virtual pools.
     */
    public List<DataServiceVpoolRestRep> getAll() {
        return client.get(DataServiceVpoolListResponse.class, OBJECT_VDC_VPOOLS_URL).getVpools();
    }


    /**
     * Creates a new Data-service virtual pool.
     * <p>
     *     API Call: <tt>POST /vdc/data-service/vpools</tt>
     * </p>
     *
     * @param create Creation parameters.
     * @return The Data-service virtual pool.
     */
    public DataServiceVpoolRestRep create(DataServiceVpoolCreateParam create) {
        return client.post(DataServiceVpoolRestRep.class, create, OBJECT_VDC_VPOOLS_URL);
    }

    /**
     * Lists data stores for the specified Data-service virtual pool.
     * <p>
     *     API Call: <tt>GET /vdc/data-service/vpools/{id}/data-stores</tt>
     * </p>
     * @param vpoolId Data-service Virtual pool identifier.
     * @return List of references to data stores associated to this Data-service virtual pool.
     */
    public DataStoreList getAssociatedDataStoreList(URI vpoolId) {
        return client.get(DataStoreList.class, OBJECT_VDC_VPOOLS_URL + ID_PATH + DATA_STORES_PATH, vpoolId);
    }

    /**
     * Retrieves a Data-service virtual pool details of the given VpoolId
     * <p>
     *     API Call: <tt>GET /vdc/data-service/vpools/{id}</tt>
     * </p>
     *
     * @param id Identifier of the Data-service virtual pool.
     * @return The Data-service virtual pool.
     */
    public DataServiceVpoolRestRep get(URI id) {
        return client.get(DataServiceVpoolRestRep.class, OBJECT_VDC_VPOOLS_URL  + ID_PATH, id);
    }

    /**
     * Updates a Data-service virtual pool.
     * <p>
     *     API Call: <tt>PUT /vdc/data-service/vpools/{id}</tt>
     * </p>
     *
     * @param id Identifier of the Data-service virtual pool.
     * @param objectStoreUpdateParam Data-service virtual pool parameters which contains the name and the description
     */
    public void update(URI id, DataServiceVpoolUpdateParam objectStoreUpdateParam) {
        client.put(String.class, objectStoreUpdateParam, OBJECT_VDC_VPOOLS_URL  + ID_PATH, id);
    }


    /**
     * Updates a object virtual pool.
     * <p>
     *     API Call: <tt>PUT /vdc/object/vpools/{id}/addvarrays</tt>
     * </p>
     *
     * @param id Identifier of the object virtual pool.
     * @param objectStoreUpdateParam object virtual pool parameters which contains vdc-zoneid tuples to be added
     */

    public void addVarray(URI id, DataServiceVpoolVarrayInfo objectStoreUpdateParam )
    {
        client.put(String.class, objectStoreUpdateParam, OBJECT_VDC_VPOOLS_URL  + ID_PATH + ADD_VARRAY_PATH , id);
    }


    /**
     * Updates a Data-service virtual pool.
     * <p>
     *     API Call: <tt>PUT /vdc/data-service/vpools/{id}/remove</tt>
     * </p>
     *
     * @param id Identifier of the Data-service virtual pool.
     * @param objectStoreUpdateParam Data-service virtual pool parameters which contains vdc-zoneid tuples to be removed
     */

    public void removeVarray(URI id, DataServiceVpoolVarrayInfo objectStoreUpdateParam )
    {
        client.put(String.class, objectStoreUpdateParam, OBJECT_VDC_VPOOLS_URL  + ID_PATH + REMOVE_VARRAY_PATH , id);
    }


    /**
     * Deactivates a Data-service virtual pool.
     * <p>
     *     API Call: <tt>POST /vdc/data-service/vpools/{id}/deactivate</tt>
     * </p>
     *
     * @param id Identifier of the Data-service virtual pool.
     */
    public void deactivate(URI id) {
        client.post(String.class, OBJECT_VDC_VPOOLS_URL + ID_PATH + DEACTIVATE_PATH, id);
    }
}