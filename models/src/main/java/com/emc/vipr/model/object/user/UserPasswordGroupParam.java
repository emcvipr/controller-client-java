package com.emc.vipr.model.object.user;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "user_password_group_param")
public class UserPasswordGroupParam {
	private String namespace;
	/**
	 * Namespace identifier to associate with the user
	 * 
	 * @valid None
	 */
	@XmlElement(required = false, name = "namespace")
	public String getNamespace() {
		return namespace;
	}
	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}
}
