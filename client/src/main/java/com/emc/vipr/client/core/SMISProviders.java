package com.emc.vipr.client.core;

import static com.emc.vipr.client.core.util.ResourceUtils.defaultList;

import java.net.URI;
import java.util.List;

import com.emc.storageos.model.BulkIdParam;
import com.emc.storageos.model.NamedRelatedResourceRep;
import com.emc.storageos.model.smis.SMISProviderBulkRep;
import com.emc.storageos.model.smis.SMISProviderCreateParam;
import com.emc.storageos.model.smis.SMISProviderList;
import com.emc.storageos.model.smis.SMISProviderRestRep;
import com.emc.storageos.model.smis.SMISProviderUpdateParam;
import com.emc.storageos.model.varray.DecommissionedResourceRep;
import com.emc.storageos.model.varray.DecommissionedResources;
import com.emc.vipr.client.Task;
import com.emc.vipr.client.Tasks;
import com.emc.vipr.client.ViPRCoreClient;
import com.emc.vipr.client.core.filters.ResourceFilter;
import com.emc.vipr.client.core.impl.PathConstants;
import com.emc.vipr.client.impl.RestClient;
import com.emc.vipr.client.core.util.ResourceUtils;

/**
 * SMI-S Providers resources.
 * <p>
 * Base URL: <tt>/vdc/smis-providers</tt>
 */
public class SMISProviders extends AbstractBulkResources<SMISProviderRestRep> implements
        TopLevelResources<SMISProviderRestRep>, TaskResources<SMISProviderRestRep> {
    public SMISProviders(ViPRCoreClient parent, RestClient client) {
        super(parent, client, SMISProviderRestRep.class, PathConstants.SMIS_PROVIDER_URL);
    }

    @Override
    public SMISProviders withInactive(boolean inactive) {
        return (SMISProviders) super.withInactive(inactive);
    }

    @Override
    protected List<SMISProviderRestRep> getBulkResources(BulkIdParam input) {
        SMISProviderBulkRep response = client.post(SMISProviderBulkRep.class, input, getBulkUrl());
        return defaultList(response.getSmisProviders());
    }

    @Override
    public Tasks<SMISProviderRestRep> getTasks(URI id) {
        return doGetTasks(id);
    }

    @Override
    public Task<SMISProviderRestRep> getTask(URI id, URI taskId) {
        return doGetTask(id, taskId);
    }

    /**
     * Lists all SMI-S providers.
     * <p>
     * API Call: <tt>GET /vdc/smis-providers</tt>
     * 
     * @return the list of SMI-S provider references.
     */
    @Override
    public List<NamedRelatedResourceRep> list() {
        SMISProviderList response = client.get(SMISProviderList.class, baseUrl);
        return ResourceUtils.defaultList(response.getSmisProviders());
    }

    /**
     * Gets a list of all SMI-S providers. This is a convenience method for: <tt>getByRefs(list())</tt>.
     * 
     * @return the list of SMI-S providers.
     */
    @Override
    public List<SMISProviderRestRep> getAll() {
        return getAll(null);
    }

    /**
     * Gets a list of all SMI-S providers, optionally filtering the results. This is a convenience method for:
     * <tt>getByRefs(list(), filter)</tt>.
     * 
     * @param filter
     *        the resource filter to apply to the results as they are returned (optional).
     * @return the list of SMI-S providers.
     */
    @Override
    public List<SMISProviderRestRep> getAll(ResourceFilter<SMISProviderRestRep> filter) {
        List<NamedRelatedResourceRep> refs = list();
        return getByRefs(refs, filter);
    }

    /**
     * Begins creating a new SMI-S provider.
     * <p>
     * API Call: <tt>POST /vdc/smis-providers</tt>
     * 
     * @param input
     *        the create configuration.
     * @return a task for monitoring the progress of the operation.
     */
    public Task<SMISProviderRestRep> create(SMISProviderCreateParam input) {
        return postTask(input, baseUrl);
    }

    /**
     * Updates the given SMI-S provider by ID.
     * <p>
     * API Call: <tt>PUT /vdc/smis-providers/{id}</tt>
     * 
     * @param id
     *        the ID of the SMI-S provider.
     * @param input
     *        the update configuration.
     * @return the updated SMI-S provider.
     */
    public SMISProviderRestRep update(URI id, SMISProviderUpdateParam input) {
        return client.put(SMISProviderRestRep.class, input, getIdUrl(), id);
    }

    /**
     * Deactivates the given SMI-S provider by ID.
     * <p>
     * API Call: <tt>POST /vdc/smis-providers/{id}/deactivate</tt>
     * 
     * @param id
     *        the ID of the SMI-S provider.
     */
    public void deactivate(URI id) {
        doDeactivate(id);
    }

    /**
     * Scans all SMI-S providers.
     * <p>
     * API Call: <tt>POST /vdc/smis-providers/scan</tt>
     * 
     * @return tasks for monitoring the progress of the operation(s).
     */
    public Tasks<SMISProviderRestRep> scanAll() {
        return postTasks(baseUrl + "/scan");
    }

    /**
     * Gets all deactivated systems.
     * <p>
     * API Call: <tt>GET /vdc/smis-providers/deactivated-systems</tt>
     * 
     * @return the list of deactivates systems.
     */
    public List<DecommissionedResourceRep> listDeactivatedSystems() {
        DecommissionedResources response = client.get(DecommissionedResources.class, baseUrl + "/deactivated-systems");
        return defaultList(response.getResources());
    }
}
