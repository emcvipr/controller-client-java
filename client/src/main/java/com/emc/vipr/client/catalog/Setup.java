package com.emc.vipr.client.catalog;

import com.emc.vipr.client.ViPRCatalogClient;
import com.emc.vipr.client.impl.RestClient;
import static com.emc.vipr.client.catalog.impl.PathConstants.SETUP_SKIP_URL;

public class Setup {
    protected final ViPRCatalogClient parent;
    protected final RestClient client;

    public Setup(ViPRCatalogClient parent, RestClient client) {
        this.parent = parent;
        this.client = client;
    }

    /**
     * Skips the initial setup if required settings are already set.
     * <p>
     * API Call: PUT /api/setup/skip
     */
    public void skip() {
        client.put(String.class, SETUP_SKIP_URL);
    }
}
