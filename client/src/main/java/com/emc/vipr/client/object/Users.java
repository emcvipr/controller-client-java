package com.emc.vipr.client.object;

import com.emc.vipr.client.impl.RestClient;
import com.emc.vipr.model.object.ObjectNamedRelatedResourceRep;
import com.emc.vipr.model.object.namespace.*;
import com.emc.vipr.model.object.user.SecretKeyInfoRep;
import com.emc.vipr.model.object.user.UserCreateParam;
import com.emc.vipr.model.object.user.UserDeleteParam;
import com.emc.vipr.model.object.user.UsersList;

import java.net.URI;
import java.util.List;

import static com.emc.vipr.client.object.impl.PathConstants.*;

public class Users {
    private RestClient client;

    public Users(RestClient client) {
        this.client = client;
    }

    /**
     * Retrieves all User identifiers.
     * <p>
     *     API Call: <tt>GET /object/users</tt>
     * </p>
     *
     * @return All user identifiers.
     */
    public List<URI> getAll() {
        return client.get(UsersList.class, USERS_URL).getUsers();
    }

    /**
     * Adds a new user.
     * <p>
     *     API Call: <tt>POST /object/users</tt>
     * </p>
     *
     * @param create User creation parameters.
     * @return Secret key information for the user.
     */
    public SecretKeyInfoRep add(UserCreateParam create) {
        return client.post(SecretKeyInfoRep.class, create, USERS_URL);
    }

    /**
     * Deactivates the user.
     * <p>
     *     API Call: <tt>POST /object/users/deactivate</tt>
     * </p>
     *
     * @param param deactivation parameters.
     */
    public void deactivate(UserDeleteParam param) {
        client.post(String.class, param, USERS_URL + DEACTIVATE_PATH);
    }
}
