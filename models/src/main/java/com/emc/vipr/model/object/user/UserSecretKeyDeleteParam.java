package com.emc.vipr.model.object.user;

import javax.xml.bind.annotation.XmlElement;

public class UserSecretKeyDeleteParam {
    private String secretKey;

    /**
     * Expiry time/date for the secret key
     * @valid None
     */
    @XmlElement(required = false, name = "secret_key")
    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }
}
