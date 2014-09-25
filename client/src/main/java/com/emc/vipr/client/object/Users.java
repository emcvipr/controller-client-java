package com.emc.vipr.client.object;

import static com.emc.vipr.client.object.impl.PathConstants.DEACTIVATE_PATH;
import static com.emc.vipr.client.object.impl.PathConstants.NAMESPACE_ID_PATH;
import static com.emc.vipr.client.object.impl.PathConstants.USERS_URL;

import java.util.List;

import com.emc.vipr.client.impl.RestClient;
import com.emc.vipr.model.object.user.SecretKeyInfoRep;
import com.emc.vipr.model.object.user.BlobUser;
import com.emc.vipr.model.object.user.UserCreateParam;
import com.emc.vipr.model.object.user.UserDeleteParam;
import com.emc.vipr.model.object.user.UsersList;

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
     * @return All user identifiers with namespace.
     */
    public List<BlobUser> getAll() {
        return client.get(UsersList.class, USERS_URL).getUsers();
    }
    
    /**
     * Retrieve all User identifiers associated with a particular Namespace
     * <p>
     *     API Call: <tt>GET /object/users/{namespace}</tt>
     * </p>
     *
     * @return All user identifiers with namespace.
     */
    
    public List<BlobUser> getAllFromNamespace(String namespace) {
        return client.get(UsersList.class, USERS_URL + NAMESPACE_ID_PATH, namespace).getUsers();
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
