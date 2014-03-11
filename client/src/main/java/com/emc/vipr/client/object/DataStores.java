package com.emc.vipr.client.object;

import com.emc.storageos.model.TaskResourceRep;
import com.emc.vipr.client.Task;
import com.emc.vipr.client.exceptions.ViPRException;
import com.emc.vipr.client.impl.RestClient;
import com.emc.vipr.model.object.datastore.*;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import static com.emc.vipr.client.object.impl.PathConstants.*;

public class DataStores {
    public static final String FILE_SYSTEM_TYPE = "FileSystems";
    public static final String NFS_EXPORT_TYPE = "NfsExportPoints";

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
     * Convienece method for calling getByRefs(list()).
     *
     * @return Returns all data store objects.
     */
    public List<DataStoreRestRep> getAll() {
        List<DataStoreNamedRelatedResourceRep> refs = list();
        return getByRefs(refs);
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
        throw new ViPRException("Unknown resource type: " + ref.getResourceType());
    }
}
