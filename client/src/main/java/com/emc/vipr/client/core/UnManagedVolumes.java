package com.emc.vipr.client.core;

import static com.emc.vipr.client.core.util.ResourceUtils.defaultList;

import java.net.URI;
import java.util.List;

import com.emc.storageos.model.BulkIdParam;
import com.emc.storageos.model.NamedRelatedResourceRep;
import com.emc.storageos.model.RelatedResourceRep;
import com.emc.storageos.model.block.NamedVolumesList;
import com.emc.storageos.model.block.UnManagedBulkRep;
import com.emc.storageos.model.block.UnManagedVolumeList;
import com.emc.storageos.model.block.UnManagedVolumeRestRep;
import com.emc.storageos.model.block.VolumeIngest;
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
public class UnManagedVolumes extends AbstractBulkResources<UnManagedVolumeRestRep> {
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
}
