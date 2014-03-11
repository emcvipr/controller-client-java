package com.emc.vipr.model.object.user;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Parameter for deletion of a Secret Key
 */
@XmlRootElement(name = "secret_key_delete_param")
public class SecretKeyDeleteParam {
    private String secretKey;

    public SecretKeyDeleteParam() { }
    public SecretKeyDeleteParam(String secretKey) {
        this.secretKey = secretKey;
    }

    /**
     * Secret key to be deleted
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
