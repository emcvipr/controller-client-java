package com.emc.vipr.client.object;

import com.emc.vipr.client.impl.RestClient;
import com.emc.vipr.model.object.ObjectNamedRelatedResourceRep;
import com.emc.vipr.model.object.network.ObjectNetworkCreateParam;
import com.emc.vipr.model.object.network.ObjectNetworkList;
import com.emc.vipr.model.object.network.ObjectNetworkUpdateParam;
import com.emc.vipr.model.object.network.ObjectNetworkRestRep;
import java.net.URI;
import java.util.List;
import static com.emc.vipr.client.object.impl.PathConstants.*;

public class Networks {
    private RestClient client;

    public Networks(RestClient client) {
        this.client = client;
    }

    /**
     * Lists object networks.
     * <p>
     *     API Call: <tt>GET /object/networks</tt>
     * </p>
     *
     * @return List of object network references.
     */
    public List<ObjectNamedRelatedResourceRep> list() {
        return client.get(ObjectNetworkList.class, NETWORKS_URL).getNetworks();
    }

    /**
     * Creates an object network.
     * <p>
     *     API Call: <tt>POST /object/networks</tt>
     * </p>
     *
     * @param create Create parameters.
     * @return The created object network.
     */
    public ObjectNetworkRestRep create(ObjectNetworkCreateParam create) {
        return client.post(ObjectNetworkRestRep.class, create, NETWORKS_URL);
    }

    /**
     * Gets an object network.
     * <p>
     *     API Call: <tt>GET /object/networks/{id}</tt>
     * </p>
     *
     * @param id Gets an object network.
     * @return The object network.
     */
    public ObjectNetworkRestRep get(URI id) {
        return client.get(ObjectNetworkRestRep.class, NETWORKS_URL + ID_PATH, id);
    }

    /**
     * Updates an object network.
     * <p>
     *     API Call: <tt>PUT /object/networks/{id}</tt>
     * </p>
     *
     * @param id Identifier of the object network.
     * @param update Update parameters.
     */
    public void update(URI id, ObjectNetworkUpdateParam update) {
        client.put(String.class, update, NETWORKS_URL + ID_PATH, id);
    }

    /**
     * Deactivates an object network.
     * <p>
     *     API Call: <tt>POST /object/networks/{id}/deactivate</tt>
     * </p>
     *
     * @param id Identifier of the object network.
     */
    public void deactivate(URI id) {
        client.post(String.class, NETWORKS_URL + ID_PATH + DEACTIVATE_PATH, id);
    }
}
