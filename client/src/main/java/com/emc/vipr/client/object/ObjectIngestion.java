package com.emc.vipr.client.object;


import com.emc.storageos.model.TaskResourceRep;
import com.emc.vipr.client.Task;
import com.emc.vipr.client.impl.RestClient;
import com.emc.vipr.model.object.ObjectRelatedResourceRep;
import com.emc.vipr.model.object.ingestion.ObjectIngestionCreateParam;
import com.emc.vipr.model.object.ingestion.ObjectIngestionList;
import com.emc.vipr.model.object.ingestion.ObjectIngestionRestRep;

import static com.emc.vipr.client.object.impl.PathConstants.*;

import java.net.URI;
import java.util.List;

public class ObjectIngestion {

    private RestClient client;

    public ObjectIngestion(RestClient client) {
        this.client = client;
    }

    /**
     * Lists all the ingestion tasks.
     * <p>
     * API Call: <tt>GET /object/ingestion</tt>
     *
     * @return References to ingestion tasks.
     */
    public List<ObjectRelatedResourceRep> list() {
        return client.get(ObjectIngestionList.class, OBJECT_INGESTION_URL).getObjectIngestions();
    }

    /**
     * Creates a new ingestion task
     * <p>
     * API Call: <tt>POST /object/ingestion</tt>
     *
     * @param create Create parameters.
     * @return Task for monitoring progress of the operation.
     */
    public Task<ObjectIngestionRestRep> create(ObjectIngestionCreateParam create) {
        TaskResourceRep task = client.post(TaskResourceRep.class, create, OBJECT_INGESTION_URL);
        return new Task<ObjectIngestionRestRep>(client, task, ObjectIngestionRestRep.class);
    }

    /**
     * Begins deactivating an ingestion task by ID.
     * <p>
     * API Call: <tt>POST /object/ingestion/{id}/deactivate</tt>
     *
     * @param id the ID of the ingestion task to deactivate.
     * @return a task for monitoring the progress of the operation.
     */
    public Task<ObjectIngestionRestRep> deactivate(URI id) {
        TaskResourceRep task = client.post(TaskResourceRep.class, OBJECT_INGESTION_URL + ID_PATH + DEACTIVATE_PATH, id);
        return new Task<ObjectIngestionRestRep>(client, task, ObjectIngestionRestRep.class);
    }

    /**
     * Retrieves an ingestion task.
     * <p>
     * API Client: <tt>GET /object/ingestion/{id}</tt>
     *
     * @param id Identifier of the ingestion task.
     * @return The ingestion task object.
     */
    public ObjectIngestionRestRep get(URI id) {
        return client.get(ObjectIngestionRestRep.class, OBJECT_INGESTION_URL + ID_PATH, id);
    }
}
