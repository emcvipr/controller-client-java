package com.emc.vipr.client.object;

import com.emc.vipr.client.impl.RestClient;
import com.emc.vipr.model.object.user.*;
import java.net.URI;
import static com.emc.vipr.client.object.impl.PathConstants.DEACTIVATE_PATH;
import static com.emc.vipr.client.object.impl.PathConstants.ID_PATH;
import static com.emc.vipr.client.object.impl.PathConstants.NAMESPACE_ID_PATH;
import static com.emc.vipr.client.object.impl.PathConstants.USER_PASSWORD_URL;

public class UserPasswords {
    private RestClient client;

    public UserPasswords(RestClient client) {
        this.client = client;
    }

    /**
     * Retrieves groups for the specified user ID.
     * <p>
     *     API Call: <tt>GET /object/user-password/{uid}</tt>
     * </p>
     *
     * @param userId User identifier.
     * @return User groups.
     */
    public UserGroupRestRep getGroups(URI userId) {
        return client.get(UserGroupRestRep.class, USER_PASSWORD_URL + ID_PATH, userId);
    }
    
    /**
     * Retrieves groups for the specified user ID.
     * <p>
     *     API Call: <tt>GET /object/user-password/{uid}/{namespace}</tt>
     * </p>
     *
     * @param userId User identifier.
     * @return User groups.
     */
    public UserGroupRestRep getGroups(URI userId, URI namespace) {
        return client.get(UserGroupRestRep.class, USER_PASSWORD_URL + ID_PATH + NAMESPACE_ID_PATH, userId, namespace);
    }

    /**
     * Creates a new user password.
     * <p>
     *     API Call: <tt>PUT /object/user-password/{uid}</tt>
     * </p>
     *
     * @param userId User identifier.
     * @param param Creation parameters.
     */
    public void create(URI userId, UserPasswordGroupCreateParam param) {
        client.put(String.class, param, USER_PASSWORD_URL + ID_PATH, userId);
    }

    /**
     * Updates a user password.
     * <p>
     *     API Call: <tt>POST /object/user-password/{uid}</tt>
     * </p>
     *
     * @param userId User identifier.
     * @param param Update parameters.
     */
    public void update(URI userId, UserPasswordGroupUpdateParam param) {
        client.post(String.class, param, USER_PASSWORD_URL + ID_PATH, userId);
    }

    /**
     * Deactivates a user.
     * <p>
     *     API Call: <tt>POST /object/user-password/{uid}/deactivate</tt>
     * </p>
     *
     * @param userId User identifier.
     */
    public void deactivate(URI userId) {
        client.post(String.class, USER_PASSWORD_URL + ID_PATH + DEACTIVATE_PATH, userId);
    }
}
