package com.emc.vipr.client.object;

import com.emc.storageos.model.TaskResourceRep;
import com.emc.vipr.client.Task;
import com.emc.vipr.client.impl.RestClient;
import com.emc.vipr.model.object.ObjectNamedRelatedResourceRep;
import com.emc.vipr.model.object.atmos.AtmosDeviceList;
import com.emc.vipr.model.object.atmos.AtmosDeviceParam;
import com.emc.vipr.model.object.atmos.AtmosDeviceRestRep;
import com.emc.vipr.model.object.atmos.AtmosUpdateParameters;
import java.net.URI;
import java.util.List;
import static com.emc.vipr.client.object.impl.PathConstants.*;

public class AtmosImporter {
    private RestClient client;

    public AtmosImporter(RestClient client) {
        this.client = client;
    }

    /**
     * Register an atmos device
     * <p>
     * API Call: <tt>POST /object/atmos-importer</tt>
     *
     * @param param Parameter to registion.
     * @return a task for monitoring the progress of this operation.
     */
    public Task<AtmosDeviceRestRep> register(AtmosDeviceParam param) {
        TaskResourceRep task = client.post(TaskResourceRep.class, param, ATMOS_IMPORTER_URL);
        return new Task<AtmosDeviceRestRep>(client, task, AtmosDeviceRestRep.class);
    }

    /**
     * Lists atmos devices.
     * <p>
     * API Call: <tt>GET /object/atmos-importer</tt>
     *
     * @return List of references to atmos devices.
     */
    public List<ObjectNamedRelatedResourceRep> list() {
        return client.get(AtmosDeviceList.class, ATMOS_IMPORTER_URL).getDevices();
    }

    /**
     * Retrieves an atmos device.
     * <p>
     * API Call: <tt>GET /object/atmos-importer/{id}</tt>
     *
     * @param id Identifier of the atmos device.
     * @return The atmos device.
     */
    public AtmosDeviceRestRep get(URI id) {
        return client.get(AtmosDeviceRestRep.class, ATMOS_IMPORTER_URL + ID_PATH, id);
    }

    /**
     * Updates an atmos device.
     * <p>
     * API Call: <tt>PUT /object/atmos-importer/{id}</tt>
     *
     * @param id Identifier of the atmos device.
     * @param param Update parameter.
     * @return The updated atmos device representation.
     */
    public AtmosDeviceRestRep update(URI id, AtmosUpdateParameters param) {
        return client.put(AtmosDeviceRestRep.class, param, ATMOS_IMPORTER_URL + ID_PATH, id);
    }

    /**
     * Deactivates an atmos device.
     * <p>
     * API Call: <tt>POST /object/atmos-importer/{id}/deactivate</tt>
     *
     * @param id ID of the device to deactivate.
     */
    public void deactivate(URI id) {
        client.post(String.class, ATMOS_IMPORTER_URL + ID_PATH + DEACTIVATE_PATH, id);
    }
}
