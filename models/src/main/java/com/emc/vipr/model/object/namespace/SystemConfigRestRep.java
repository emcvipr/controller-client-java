/**
 *  Copyright (c) 2008-2012 EMC Corporation
 * All Rights Reserved
 *
 * This software contains the intellectual property of EMC Corporation
 * or is licensed to EMC Corporation from third parties.  Use of this
 * software and the intellectual property contained therein is expressly
 * limited to the terms and conditions of the License Agreement under which
 * it is provided by or on behalf of EMC.
 */

package com.emc.vipr.model.object.namespace;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * System wide configuration Response
 * @author sharique
 *
 */

@XmlRootElement(name = "system_configuration")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class SystemConfigRestRep {

	
	private String userScopeConfig;

	
	/**
	 * User scope configuration 
	 * @return enum {GLOBAL, NAMESPACE}
	 */
	@XmlElement( required = false, name = "user_scope")
	public String getUserScopeConfig() {
		return userScopeConfig;
	}

	public void setUserScopeConfig(String userScopeConfig) {
		this.userScopeConfig = userScopeConfig;
	}
	
	
	
}
