/**
 *  Copyright (c) 2013 EMC Corporation
 * All Rights Reserved
 *
 * This software contains the intellectual property of EMC Corporation
 * or is licensed to EMC Corporation from third parties.  Use of this
 * software and the intellectual property contained therein is expressly
 * limited to the terms and conditions of the License Agreement under which
 * it is provided by or on behalf of EMC.
 */
package com.emc.vipr.model.object.user;

import com.emc.storageos.model.RestLinkRep;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * User secret key information
 */
@XmlRootElement(name = "user_secret_key")
public class SecretKeyInfoRep {
    private String secretKey;
    private String secretKeyTimestamp;
    private RestLinkRep link;

    public SecretKeyInfoRep() {
        setSecretKey("");
        setSecretKeyTimestamp("");
    }

    public SecretKeyInfoRep(RestLinkRep link, String key, String ts) {
        setSecretKey(key);
        setSecretKeyTimestamp(ts);
        setLink(link);
    }

    /**
     * Secret key
     * @valid None
     */
    @XmlElement(name = "secret_key")
    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    /**
     * Secret key creation timestamp
     * @valid None
     */
    @XmlElement(name = "key_timestamp")
    public String getSecretKeyTimestamp() {
        return secretKeyTimestamp;
    }

    public void setSecretKeyTimestamp(String secretKeyTimestamp) {
        this.secretKeyTimestamp = secretKeyTimestamp;
    }

    @XmlElement(name = "link")
    public RestLinkRep getLink() {
        return link;
    }

    public void setLink(RestLinkRep link) {
        this.link = link;
    }
}
