package com.emc.vipr.model.object.user;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "user_secret_key_delete")
public class UserSecretKeyDeleteParam {
    private String secretKey;
    
    private String namespace;
    
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
    
    /**
     * User qualifier if the User Scope is NAMESPACE
     * @valid None
     */
	public String getNamespace() {
		return namespace;
	}

	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}
    
    
}
