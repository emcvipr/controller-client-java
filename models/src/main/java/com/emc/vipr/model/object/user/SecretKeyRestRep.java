/**
 *  Copyright (c) 2008-2011 EMC Corporation
 * All Rights Reserved
 *
 * This software contains the intellectual property of EMC Corporation
 * or is licensed to EMC Corporation from third parties.  Use of this
 * software and the intellectual property contained therein is expressly
 * limited to the terms and conditions of the License Agreement under which
 * it is provided by or on behalf of EMC.
 */
package com.emc.vipr.model.object.user;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import com.emc.storageos.model.RestLinkRep;

/**
 * Set of secret keys assigned to use for object data access
 */
@XmlRootElement(name = "user_secret_keys")
public class SecretKeyRestRep {
    private String secretKey1;
    private String secretKeyTimestamp1;
    private String secretKey2;
    private String secretKeyTimestamp2;
    private RestLinkRep selfLink;


    // Since _dbClient does not guarantee support for null values in the String,
    // empty string is used to indicate inactive keys.
    public SecretKeyRestRep() {
        setSecretKey1("");
        setSecretKeyTimestamp1("");
        setSecretKey2("");
        setSecretKeyTimestamp2("");
    }

    /**
     * First secret key
     * @valid None
     */
    @XmlElement(name = "secret_key_1")
    public String getSecretKey1() {
        return secretKey1;
    }

    public void setSecretKey1(String secretKey1) {
        this.secretKey1 = secretKey1;
    }

    /**
     * First key creation timestamp
     * @valid None
     */
    @XmlElement(name = "key_timestamp_1")
    public String getSecretKeyTimestamp1() {
        return secretKeyTimestamp1;
    }

    public void setSecretKeyTimestamp1(String secretKeyTimestamp1) {
        this.secretKeyTimestamp1 = secretKeyTimestamp1;
    }

    /**
     * Second secret key
     * @valid None
     */
    @XmlElement(name = "secret_key_2")
    public String getSecretKey2() {
        return secretKey2;
    }

    public void setSecretKey2(String secretKey2) {
        this.secretKey2 = secretKey2;
    }

    /**
     * Second key creation timestamp
     * @valid None
     */
    @XmlElement(name = "key_timestamp_2")
    public String getSecretKeyTimestamp2() {
        return secretKeyTimestamp2;
    }

    public void setSecretKeyTimestamp2(String secretKeyTimestamp2) {
        this.secretKeyTimestamp2 = secretKeyTimestamp2;
    }

    /**
     * User secret key reference link
     * @valid None
     */
    @XmlElement(name = "link")
    public RestLinkRep getSelfLink() {
        return selfLink;
    }

    public void setSelfLink(RestLinkRep selfLink) {
        this.selfLink = selfLink;
    }
}
