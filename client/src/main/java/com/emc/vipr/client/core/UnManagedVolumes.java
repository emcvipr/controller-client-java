package com.emc.vipr.client.core;

import static com.emc.vipr.client.core.util.ResourceUtils.defaultList;
import java.net.URI;
import java.util.List;
import com.emc.storageos.model.BulkIdParam;
import com.emc.storageos.model.NamedRelatedResourceRep;
import com.emc.storageos.model.RelatedResourceRep;
import com.emc.storageos.model.block.*;
import com.emc.vipr.client.ViPRCoreClient;
import com.emc.vipr.client.core.filters.ResourceFilter;
import com.emc.vipr.client.core.impl.PathConstants;
import com.emc.vipr.client.impl.RestClient;
import com.emc.vipr.client.core.util.ResourceUtils;

/**
 * Unmanaged Volumes resources.
 * <p>
 * Base URL: <tt>/vdc/unmanaged/volumes</tt>
 */
public class UnManagedVolumes extends AbstractCoreBulkResources<UnManagedVolumeRestRep> {
    public UnManagedVolumes(ViPRCoreClient parent, RestClient client) {
        super(parent, client, UnManagedVolumeRestRep.class, PathConstants.UNMANAGED_VOLUMES_URL);
    }

    @Override
    public UnManagedVolumes withInactive(boolean inactive) {
        return (UnManagedVolumes) super.withInactive(inactive);
    }

    @Override
    public UnManagedVolumes withInternal(boolean internal) {
        return (UnManagedVolumes) super.withInternal(internal);
    }

    @Override
    protected List<UnManagedVolumeRestRep> getBulkResources(BulkIdParam input) {
        UnManagedBulkRep response = client.post(UnManagedBulkRep.class, input, getBulkUrl());
        return defaultList(response.getUnManagedVolumes());
    }

    /**
     * Gets the list of unmanaged volumes for the given storage system by ID.
     * <p>
     * API Call: <tt>GET /vdc/storage-systems/{storageSystemId}/unmanaged/volumes</tt>
     * 
     * @param storageSystemId
     *        the ID of the storage system.
     * @return the list of unmanaged volume references.
     */
    public List<RelatedResourceRep> listByStorageSystem(URI storageSystemId) {
        UnManagedVolumeList response = client.get(UnManagedVolumeList.class,
                PathConstants.UNMANAGED_VOLUME_BY_STORAGE_SYSTEM_URL, storageSystemId);
        return ResourceUtils.defaultList(response.getUnManagedVolumes());
    }

    /**
     * Gets the list of unmanaged volumes for the given storage system by ID. This is a convenience method for:
     * <tt>getByRefs(listByStorageSystem(storageSystemId))</tt>
     * 
     * @param storageSystemId
     *        the ID of the storage system.
     * @return the list of unmanaged volumes.
     */
    public List<UnManagedVolumeRestRep> getByStorageSystem(URI storageSystemId) {
        return getByStorageSystem(storageSystemId, null);
    }

    /**
     * Gets the list of unmanaged volumes for the given storage system by ID. This is a convenience method for:
     * <tt>getByRefs(listByStorageSystem(storageSystemId), filter)</tt>
     * 
     * @param storageSystemId
     *        the ID of the storage system.
     * @param filter
     *        the resource filter to apply to the results as they are returned (optional).
     * @return the list of unmanaged volumes.
     */
    public List<UnManagedVolumeRestRep> getByStorageSystem(URI storageSystemId,
            ResourceFilter<UnManagedVolumeRestRep> filter) {
        List<RelatedResourceRep> refs = listByStorageSystem(storageSystemId);
        return getByRefs(refs, filter);
    }

    /**
     * Gets the list of unmanaged volumes for the given host by ID.
     * <p>
     * API Call: <tt>GET /compute/hosts/{hostId}/unmanaged-volumes</tt>
     *
     * @param hostId
     *        the ID of the host.
     * @return the list of unmanaged volume references.
     */
    public List<RelatedResourceRep> listByHost(URI hostId) {
        UnManagedVolumeList response = client.get(UnManagedVolumeList.class,
            PathConstants.UNMANAGED_VOLUME_BY_HOST_URL, hostId);
        return ResourceUtils.defaultList(response.getUnManagedVolumes());
    }

    /**
     * Gets the list of unmanaged volumes for the given host by ID. This is a convenience method for:
     * <tt>getByRefs(listByHost(hostId))</tt>
     *
     * @param hostId
     *        the ID of the host.
     * @return the list of unmanaged volumes.
     */
    public List<UnManagedVolumeRestRep> getByHost(URI hostId) {
        return getByHost(hostId, null);
    }

    /**
     * Gets the list of unmanaged volumes for the given host by ID. This is a convenience method for:
     * <tt>getByRefs(listByHost(hostId), filter)</tt>
     *
     * @param hostId
     *        the ID of the host.
     * @param filter
     *        the resource filter to apply to the results as they are returned (optional).
     * @return the list of unmanaged volumes.
     */
    public List<UnManagedVolumeRestRep> getByHost(URI hostId, ResourceFilter<UnManagedVolumeRestRep> filter) {
        List<RelatedResourceRep> refs = listByHost(hostId);
        return getByRefs(refs, filter);
    }

    /**
     * Gets the list of unmanaged volumes for the given cluster by ID.
     * <p>
     * API Call: <tt>GET /compute/clusters/{clusterId}/unmanaged-volumes</tt>
     *
     * @param clusterId
     *        the ID of the cluster.
     * @return the list of unmanaged volume references.
     */
    public List<RelatedResourceRep> listByCluster(URI clusterId) {
        UnManagedVolumeList response = client.get(UnManagedVolumeList.class,
            PathConstants.UNMANAGED_VOLUME_BY_CLUSTER_URL, clusterId);
        return ResourceUtils.defaultList(response.getUnManagedVolumes());
    }

    /**
     * Gets the list of unmanaged volumes for the given cluster by ID. This is a convenience method for:
     * <tt>getByRefs(listByCluster(clusterId))</tt>
     *
     * @param clusterId
     *        the ID of the cluster.
     * @return the list of unmanaged volumes.
     */
    public List<UnManagedVolumeRestRep> getByCluster(URI clusterId) {
        return getByCluster(clusterId, null);
    }

    /**
     * Gets the list of unmanaged volumes for the given cluster by ID. This is a convenience method for:
     * <tt>getByRefs(listByCluster(hostId), filter)</tt>
     *
     * @param clusterId
     *        the ID of the cluster.
     * @param filter
     *        the resource filter to apply to the results as they are returned (optional).
     * @return the list of unmanaged volumes.
     */
    public List<UnManagedVolumeRestRep> getByCluster(URI clusterId, ResourceFilter<UnManagedVolumeRestRep> filter) {
        List<RelatedResourceRep> refs = listByCluster(clusterId);
        return getByRefs(refs, filter);
    }

    /**
     * Ingests unmanaged volumes.
     * <p>
     * API Call: <tt>POST /vdc/unmanaged/volumes/ingest</tt>
     * 
     * @param input
     *        the ingest configuration.
     * @return the list of ingested volumes.
     */
    public List<NamedRelatedResourceRep> ingest(VolumeIngest input) {
        NamedVolumesList response = client.post(NamedVolumesList.class, input, baseUrl + "/ingest");
        return defaultList(response.getVolumes());
    }


    /**
     * Ingests unmanaged volumes.
     * <p>
     * API Call: <tt>POST /vdc/unmanaged/volumes/ingest-exported</tt>
     *
     * @param input
     *        the ingest configuration.
     * @return the list of ingested volumes.
     */
    public List<NamedRelatedResourceRep> ingestExported(VolumeExportIngestParam input) {
        NamedVolumesList response = client.post(NamedVolumesList.class, input, "/vdc/unmanaged/volumes/ingest-exported");
        return defaultList(response.getVolumes());
    }
}
