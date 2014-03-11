package com.emc.vipr.model.object.user;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Parameter for creation of a new user secret key
 */
@XmlRootElement(name = "user_secret_key_create")
public class UserSecretKeyCreateParam {
    private String expiryTimeInMins;

    /**
     * Expiry time/date for the secret key
     * @valid None
     */
    @XmlElement(required = false, name = "existing_key_expiry_time_mins")
    public String getExpiryTimeInMins() {
        return expiryTimeInMins;
    }

    public void setExpiryTimeInMins(String expiryTimeInMins) {
        this.expiryTimeInMins = expiryTimeInMins;
    }
}
