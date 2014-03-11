package com.emc.vipr.client.object;

import com.emc.vipr.client.impl.RestClient;
import com.emc.vipr.model.object.user.SecretKeyCreateParam;
import com.emc.vipr.model.object.user.SecretKeyDeleteParam;
import com.emc.vipr.model.object.user.SecretKeyInfoRep;
import com.emc.vipr.model.object.user.SecretKeyRestRep;

import static com.emc.vipr.client.object.impl.PathConstants.*;

public class SecretKeys {
    private RestClient client;

    public SecretKeys(RestClient client) {
        this.client = client;
    }

    /**
     * Gets the secret keys for the current user.
     * <p>
     *     API Call: <tt>GET /object/secret-keys</tt>
     * </p>
     *
     * @return Secret keys for this user.
     */
    public SecretKeyRestRep get() {
        return client.get(SecretKeyRestRep.class, SECRET_KEYS_URL);
    }

    /**
     * Creates secret keys for the current user.
     * <p>
     *     API Call: <tt>POST /object/secret-keys</tt>
     * </p>
     *
     * @param create Creation parameters.
     * @return Secret keys for this user.
     */
    public SecretKeyInfoRep create(SecretKeyCreateParam create) {
        return client.post(SecretKeyInfoRep.class, create, SECRET_KEYS_URL);
    }

    /**
     * Deactivates secret keys for the current user.
     * <p>
     *     API Call: <tt>POST /object/secret-keys/deactivate</tt>
     * </p>
     * @param param Deactivation parameters. Note if no key is specified, it will delete all keys.
     */
    public void deactivate(SecretKeyDeleteParam param) {
        client.post(String.class, param, SECRET_KEYS_URL + DEACTIVATE_PATH);
    }
}
