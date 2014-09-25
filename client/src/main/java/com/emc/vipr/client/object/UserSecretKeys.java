package com.emc.vipr.client.object;

import static com.emc.vipr.client.object.impl.PathConstants.DEACTIVATE_PATH;
import static com.emc.vipr.client.object.impl.PathConstants.USER_SECRET_KEYS_URL;
import static com.emc.vipr.client.object.impl.PathConstants.NAMESPACE_ID_PATH;
import java.net.URI;
import com.emc.vipr.client.impl.RestClient;
import com.emc.vipr.model.object.user.SecretKeyInfoRep;
import com.emc.vipr.model.object.user.SecretKeyRestRep;
import com.emc.vipr.model.object.user.UserSecretKeyCreateParam;
import com.emc.vipr.model.object.user.UserSecretKeyDeleteParam;

public class UserSecretKeys {
    private RestClient client;

    public UserSecretKeys(RestClient client) {
        this.client = client;
    }

    /**
     * Retrieves secret keys for the specified user.
     * <p>
     *     API Call: <tt>GET /object/user-secret-keys/{uid}</tt>
     * </p>
     *
     * @param userId User identifier.
     * @return Secret keys for the user.
     */
    public SecretKeyRestRep get(URI userId) {
    		return client.get(SecretKeyRestRep.class, USER_SECRET_KEYS_URL, userId);   
    }
    
    /**
     * Retrieves secret keys for the specified user.
     * <p>
     *     API Call: <tt>GET /object/user-secret-keys/{uid}/{namespace}</tt>
     * </p>
     *
     * @param userId User identifier.
     * @param namespace associated with the user, works as a user qualifier if the User Scope is NAMESPACE
     * @return Secret keys for the user.
     */
    public SecretKeyRestRep get(URI userId, URI namespace) {
    		return client.get(SecretKeyRestRep.class, USER_SECRET_KEYS_URL + NAMESPACE_ID_PATH, userId, namespace);
    }

    /**
     * Creates new secret keys for the specified user.
     * <p>
     *     API Call: <tt>POST /object/user-secret-keys/{uid}</tt>
     * </p>
     *
     * @param userId User identifier.
     * @param create Key creation parameters.
     * @return Secret keys for the user.
     */
    public SecretKeyInfoRep create(URI userId, UserSecretKeyCreateParam create) {
        return client.post(SecretKeyInfoRep.class, create, USER_SECRET_KEYS_URL, userId);
    }

    /**
     * Deactivates secret keys for the specified user.
     * <p>
     *     API Call: <tt>POST /object/user-secret-keys/{uid}/deactivate</tt>
     * </p>
     *
     * @param userId User identifier.
     * @param param Parameters to deactivate the secret keys. If no keys are specified, will delete all keys.
     */
    public void deactivate(URI userId, UserSecretKeyDeleteParam param) {
        client.post(String.class, param, USER_SECRET_KEYS_URL + DEACTIVATE_PATH, userId);
    }
}
