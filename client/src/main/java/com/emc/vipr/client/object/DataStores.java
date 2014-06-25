package com.emc.vipr.client.object;

import static com.emc.vipr.client.object.impl.PathConstants.COMMODITY_PATH;
import static com.emc.vipr.client.object.impl.PathConstants.DATA_STORES_URL;
import static com.emc.vipr.client.object.impl.PathConstants.DEACTIVATE_PATH;
import static com.emc.vipr.client.object.impl.PathConstants.FILESYSTEMS_PATH;
import static com.emc.vipr.client.object.impl.PathConstants.ID_PATH;
import static com.emc.vipr.client.object.impl.PathConstants.NFSEXPORT_PATH;
import static com.emc.vipr.client.object.impl.PathConstants.SEARCH_PATH;
import static com.emc.vipr.client.object.impl.PathConstants.VARRAY_PATH;
import static com.emc.vipr.client.object.impl.PathConstants.IP_ADDR_PATH;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import com.emc.storageos.model.TaskList;
import com.emc.storageos.model.TaskResourceRep;
import com.emc.vipr.client.Task;
import com.emc.vipr.client.Tasks;
import com.emc.vipr.client.core.util.ResourceUtils;
import com.emc.vipr.client.exceptions.ViPRException;
import com.emc.vipr.client.impl.RestClient;
import com.emc.vipr.model.object.datastore.CommodityDataStoreList;
import com.emc.vipr.model.object.datastore.CommodityDataStoreParam;
import com.emc.vipr.model.object.datastore.CommodityDataStoreRestRep;
import com.emc.vipr.model.object.datastore.DataStoreList;
import com.emc.vipr.model.object.datastore.DataStoreNamedRelatedResourceRep;
import com.emc.vipr.model.object.datastore.DataStoreRestRep;
import com.emc.vipr.model.object.datastore.FileSystemsDataStoreParam;
import com.emc.vipr.model.object.datastore.FileSystemsDataStoreRestRep;
import com.emc.vipr.model.object.datastore.ModifyDataStoreParam;
import com.emc.vipr.model.object.datastore.NfsExportPointsDataStoreRestRep;

public class DataStores {
    public static final String FILE_SYSTEM_TYPE = "FileSystems";
    public static final String NFS_EXPORT_TYPE = "NfsExportPoints";
    public static final String COMMODITY_TYPE = "Commodity";

    private RestClient client;

    public DataStores(RestClient client) {
        this.client = client;
    }

    /**
     * Lists all data stores.
     * <p>
     * API Call: <tt>GET /vdc/data-stores</tt>
     *
     * @return References to data stores.
     */
    public List<DataStoreNamedRelatedResourceRep> list() {
        return client.get(DataStoreList.class, DATA_STORES_URL).getPools();
    }

    /**
     * Convenience method for calling getByRefs(list()).
     *
     * @return Returns all data store objects.
     */
    public List<DataStoreRestRep> getAll() {
        List<DataStoreNamedRelatedResourceRep> refs = list();
        return getByRefs(refs);
    }

    /**
     * Gets all datastores of a given type.
     * 
     * @param type
     *        the type of datastore.
     * @return the list of datastores.
     */
    public List<DataStoreRestRep> getAllByType(String type) {
        List<DataStoreNamedRelatedResourceRep> refs = listByType(type);
        return getByRefs(refs);
    }

    /**
     * Lists all datastores of a given type.
     * 
     * @param type
     *        the type of datastore.
     * @return the datastore references.
     */
    public List<DataStoreNamedRelatedResourceRep> listByType(String type) {
        List<DataStoreNamedRelatedResourceRep> refs = new ArrayList<DataStoreNamedRelatedResourceRep>();
        for (DataStoreNamedRelatedResourceRep ref : list()) {
            if (ref.getResourceType().equalsIgnoreCase(type)) {
                refs.add(ref);
            }
        }
        return refs;
    }

    /**
     * Begins deactivating a data store by ID.
     * <p>
     * API Call: <tt>POST /vdc/data-stores/{id}/deactivate</tt>
     *
     * @param id
     *        the ID of the data store to deactivate.
     * @return a task for monitoring the progress of the operation.
     */
    public Task<DataStoreRestRep> deactivate(URI id) {
        TaskResourceRep task = client.post(TaskResourceRep.class, DATA_STORES_URL + ID_PATH + DEACTIVATE_PATH, id);
        return new Task<DataStoreRestRep>(client, task, DataStoreRestRep.class);
    }

    /**
     * Creates a filesystem data store.
     * <p>
     * API Call: <tt>POST /vdc/data-stores/filesystems</tt>
     *
     * @param create Create parameters.
     * @return Task for monitoring progress of the operation.
     */
    public Task<DataStoreRestRep> createOnFileSystem(FileSystemsDataStoreParam create) {
        TaskResourceRep task = client.post(TaskResourceRep.class, create, DATA_STORES_URL + FILESYSTEMS_PATH);
        return new Task<DataStoreRestRep>(client, task, DataStoreRestRep.class);
    }

    /**
     * Updates a filesystem data store.
     * <p>
     * API Call: <tt>PUT /vdc/data-stores/filesystems/{id}</tt>
     *
     * @param id Identifier of the data store.
     * @param param Update parameters.
     */
    public void updateOnFileSystem(URI id, ModifyDataStoreParam param) {
        client.put(String.class, param, DATA_STORES_URL + FILESYSTEMS_PATH + ID_PATH, id);
    }

    /**
     * Retrieves a filesystem data store.
     * <p>
     * API Client: <tt>GET /vdc/data-stores/filesystems/{id}</tt>
     *
     * @param id Identifier of the data store.
     * @return The data store object.
     */
    public FileSystemsDataStoreRestRep getOnFileSystem(URI id) {
        return client.get(FileSystemsDataStoreRestRep.class, DATA_STORES_URL + FILESYSTEMS_PATH + ID_PATH, id);
    }

    /**
     * Creates a NFS Export data store.
     * <p>
     * API Call: <tt>POST /vdc/data-stores/nfsexportpoints</tt>
     *
     * @param create Create parameters.
     * @return Task for monitoring progress of the operation.
     */
    public Task<DataStoreRestRep> createOnNfsExport(FileSystemsDataStoreParam create) {
        TaskResourceRep task = client.post(TaskResourceRep.class, create, DATA_STORES_URL + NFSEXPORT_PATH);
        return new Task<DataStoreRestRep>(client, task, DataStoreRestRep.class);
    }

    /**
     * Updates a NFS Export data store.
     * <p>
     * API Call: <tt>PUT /vdc/data-stores/nfsexportpoints/{id}</tt>
     *
     * @param id Identifier of the data store.
     * @param param Update parameters.
     */
    public void updateOnNfsExport(URI id, ModifyDataStoreParam param) {
        client.put(String.class, param, DATA_STORES_URL + NFSEXPORT_PATH + ID_PATH, id);
    }

    /**
     * Retrieves a NFS Export data store.
     * <p>
     * API Client: <tt>GET /vdc/data-stores/nfsexportpoints/{id}</tt>
     *
     * @param id Identifier of the data store.
     * @return The data store object.
     */
    public NfsExportPointsDataStoreRestRep getOnNfsExport(URI id) {
        return client.get(NfsExportPointsDataStoreRestRep.class, DATA_STORES_URL + FILESYSTEMS_PATH + ID_PATH, id);
    }

    /**
     * Convenience call for retrieving multiple data stores by their reference.
     *
     * @param refs List of references to data stores.
     * @return Datastore objects.
     */
    public List<DataStoreRestRep> getByRefs(List<DataStoreNamedRelatedResourceRep> refs) {
        List<DataStoreRestRep> resources = new ArrayList<DataStoreRestRep>();
        for (DataStoreNamedRelatedResourceRep ref: refs) {
            resources.add(get(ref));
        }
        return resources;
    }

    /**
     * Convenience call to retrieve an NFS Export or filesystem data store by reference.
     * <p>
     * API Client: <tt>GET /vdc/data-stores/nfsexportpoints/{id}</tt>, <tt>GET /vdc/data-stores/filesystems/{id}</tt>
     *
     * @param ref Reference to the data store.
     * @return The data store.
     */
    public DataStoreRestRep get(DataStoreNamedRelatedResourceRep ref) {
        if (FILE_SYSTEM_TYPE.equalsIgnoreCase(ref.getResourceType())) {
            return getOnFileSystem(ref.getId());
        }
        else if (NFS_EXPORT_TYPE.equalsIgnoreCase(ref.getResourceType())) {
            return getOnNfsExport(ref.getId());
        }
        else if (COMMODITY_TYPE.equalsIgnoreCase(ref.getResourceType())) {
            // TODO: CommodityDataStoreRestRep needs to extend from DataStoreRestRep
             return getOnCommodity(ref.getId());
        }
        throw new ViPRException("Unknown resource type: " + ref.getResourceType());
    }
    
    
    /**
     * Creates a commodity data store.
     * <p>
     * API Call: <tt>POST /vdc/data-stores/commodity</tt>
     *
     * @param create Create parameters.
     * @return List of Tasks for monitoring progress of the operation.
     */
    public Tasks<DataStoreRestRep> createOnCommodity(CommodityDataStoreParam create) {
        TaskList tasks = client.post(TaskList.class, create, DATA_STORES_URL + COMMODITY_PATH);
        return new Tasks<DataStoreRestRep>(client, tasks.getTaskList(), DataStoreRestRep.class);
       
    }
    
    /**
     * Retrieves a commodity data store.
     * <p>
     * API Client: <tt>GET /vdc/data-stores/commodity/{id}</tt>
     *
     * @param id Identifier of the commodity data store.
     * @return The data store object.
     */
    public CommodityDataStoreRestRep getOnCommodity(URI id) {
        return client.get(CommodityDataStoreRestRep.class, DATA_STORES_URL + COMMODITY_PATH + ID_PATH, id);
    }
    
    /**
     * Search list of commodity data stores associated with varray
     * <p>
     * API Client: <tt>GET /vdc/data-stores/commodity/search/varray/{id}</tt>
     *
     * @param id Identifier of the varray.
     * @return List of commodity data store object associated with the varray
     */
    public List<CommodityDataStoreRestRep> findOnCommodityByVirtualArray(URI id) {
        CommodityDataStoreList response = client.get(CommodityDataStoreList.class, 
                DATA_STORES_URL + COMMODITY_PATH + SEARCH_PATH + VARRAY_PATH +ID_PATH, id);
        return ResourceUtils.defaultList(response.getPools());
    }
    
    /**
     * Search a commodity data stores associated with a commodity server having with a particular ipAddress
     * <p>
     * API Client: <tt>GET /vdc/data-stores/commodity/search/ipaddress/{id}</tt>
     *
     * @param id is the ip address of the commodity server
     * @return The commodity data store object associated with the commodity server
     */
    public CommodityDataStoreRestRep findOnCommodityByNode(String id) {
        return client.get(CommodityDataStoreRestRep.class, 
                DATA_STORES_URL + COMMODITY_PATH + SEARCH_PATH + IP_ADDR_PATH +ID_PATH, id);
    }
}