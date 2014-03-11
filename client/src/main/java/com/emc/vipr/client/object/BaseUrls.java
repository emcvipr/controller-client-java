package com.emc.vipr.client.object;

import com.emc.vipr.client.impl.RestClient;
import com.emc.vipr.model.object.BaseUrlList;
import com.emc.vipr.model.object.ObjectBaseUrlRestRep;
import com.emc.vipr.model.object.ObjectNamedRelatedResourceRep;
import com.emc.vipr.model.object.datastore.ObjectBaseUrlCreate;
import com.emc.vipr.model.object.datastore.ObjectBaseUrlUpdate;
import java.net.URI;
import java.util.List;
import static com.emc.vipr.client.object.impl.PathConstants.*;

public class BaseUrls {
    private RestClient client;

    public BaseUrls(RestClient client) {
        this.client = client;
    }

    /**
     * Lists references to all base URLs.
     * <p>
     * API Call: <tt>GET /object/baseurl</tt>
     *
     * @return List of base url references.
     */
    public List<ObjectNamedRelatedResourceRep> list() {
        return client.get(BaseUrlList.class, BASE_URLS_URL).getBaseUrls();
    }

    /**
     * Creates a base URL.
     * <p>
     * API Call: <tt>POST /object/baseurl</tt>
     *
     * @param create Base url create parameter.
     * @return Base url object.
     */
    public ObjectBaseUrlRestRep create(ObjectBaseUrlCreate create) {
        return client.post(ObjectBaseUrlRestRep.class, create, BASE_URLS_URL);
    }

    /**
     * Retrieves a base URL by ID.
     * <p>
     * API Call: <tt>GET /object/baseurl/{id}</tt>
     *
     * @param id Identifier of the base URL.
     * @return The base URL object.
     */
    public ObjectBaseUrlRestRep get(URI id) {
        return client.get(ObjectBaseUrlRestRep.class, BASE_URLS_URL + ID_PATH, id);
    }

    /**
     * Updates a base URL.
     * <p>
     * API Call: <tt>POST /object/baseurl/{id}</tt>
     *
     * @param id Identifier of the base URL.
     * @param param Update parameter.
     */
    public void update(URI id, ObjectBaseUrlUpdate param) {
        client.post(String.class, param, BASE_URLS_URL + ID_PATH, id);
    }

    /**
     * Deactivates a base URL.
     * <p>
     * API Call: <tt>POST /object/baseurl/{id}/deactivate</tt>
     *
     * @param id Identifier of the base url.
     */
    public void deactivate(URI id) {
        client.post(String.class, BASE_URLS_URL + ID_PATH + DEACTIVATE_PATH, id);
    }
}
