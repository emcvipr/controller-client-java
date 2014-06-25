/**
 *  Copyright (c) 2014 EMC Corporation
 * All Rights Reserved
 *
 * This software contains the intellectual property of EMC Corporation
 * or is licensed to EMC Corporation from third parties.  Use of this
 * software and the intellectual property contained therein is expressly
 * limited to the terms and conditions of the License Agreement under which
 * it is provided by or on behalf of EMC.
 */
package com.emc.vipr.client.core;

import static com.emc.vipr.client.core.impl.PathConstants.TRUSTSTORE_SETTINGS_URL;
import static com.emc.vipr.client.core.impl.PathConstants.TRUSTSTORE_URL;
import static com.emc.vipr.client.core.util.ResourceUtils.defaultList;

import java.util.List;

import com.emc.vipr.client.impl.RestClient;
import com.emc.vipr.model.keystore.TrustedCertificateChanges;
import com.emc.vipr.model.keystore.TrustedCertificates;
import com.emc.vipr.model.keystore.TruststoreSettings;
import com.emc.vipr.model.keystore.TruststoreSettingsChanges;
/**
 * Truststore resource.
 * <p>
 * Base URL: <tt>/vdc/truststore</tt>
 */
public class Truststore {


    protected final RestClient client;

    public Truststore(RestClient client) {
        this.client = client;
    }

    /**
     * Gets the list of trusted certificates in PEM format.
     * <p>
     * API Call: <tt>GET /vdc/truststore</tt>
     * 
     * @return The list of trusted certificates
     */
    public List<String> getTrustedCertificates() {
        TrustedCertificates response =
                client.get(TrustedCertificates.class, TRUSTSTORE_URL);
        return defaultList(response.getTrustedCertificates());
    }

    /**
     * Update the list of trusted certificates.
     * <p>
     * API Call: <tt>PUT /vdc/truststore</tt>
     * 
     * @param trustedCertificateChanges
     *            trusted certificates changes
     * @return The list of trusted certificates
     */
    public List<String> updateTrustedCertificate(
            TrustedCertificateChanges trustedCertificateChanges) {
        TrustedCertificates response =
                client.put(TrustedCertificates.class, trustedCertificateChanges,
                        TRUSTSTORE_URL);
        return defaultList(response.getTrustedCertificates());
    }

    /**
     * Gets the truststore settings.
     * <p>
     * API Call: <tt>GET /vdc/truststore/settings</tt>
     * 
     * @return The truststore settings
     */
    public TruststoreSettings getTruststoreSettings() {
        return client.get(TruststoreSettings.class, TRUSTSTORE_SETTINGS_URL);
    }

    /**
     * Update the truststore settings
     * <p>
     * API Call: <tt>PUT /vdc/truststore/settings</tt>
     * 
     * @param truststoreSettingsChanges
     *            the new truststore settings
     * @return The truststore settings
     */
    public TruststoreSettings updateTruststoreSettings(
            TruststoreSettingsChanges truststoreSettingsChanges) {
        return client.put(TruststoreSettings.class, truststoreSettingsChanges,
                TRUSTSTORE_SETTINGS_URL);
    }

}
