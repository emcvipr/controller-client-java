package com.emc.vipr.model.object.user;

import java.net.URI;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Represents a blob user with its user id and namespace
 * @author sharique
 *
 */
@XmlRootElement(name = "blobuser")
public class BlobUser {
	private URI user;
    private URI namespace;
    
    /**
     * Gives the userid of the user
     * @return userid of the user registered in the system
     */
    @XmlElement( required = true, name = "userid")
	public URI getUser() {
		return user;
	}
	public void setUser(URI user) {
		this.user = user;
	}
	
	/**
	 * Gives the namespace associated with the corresponding user
	 * @return namespace
	 */
	@XmlElement( required = false, name = "namespace")
	public URI getNamespace() {
		return namespace;
	}
	public void setNamespace(URI namespace) {
		this.namespace = namespace;
	}
	
}
