package com.emc.vipr.client.system;

import static com.emc.vipr.client.system.impl.PathConstants.CONFIG_URL;
import static com.emc.vipr.client.system.impl.PathConstants.USER_SCOPE;
import static com.emc.vipr.client.system.impl.PathConstants.USER_SCOPE_URL;

import com.emc.vipr.client.impl.RestClient;
import com.emc.vipr.model.object.namespace.SystemConfigRestRep;

public class UserConfig {
	
	 private RestClient client;
	 
	 public UserConfig(RestClient client)
	 {
		 this.client = client;
	 }
	
	 /**
     * This client method posts a request to set System wide User Scope either to GLOBAL or NAMESPACE
     * @param scope
     * @return Edited Value of System Configuration Rest Response for User Scope
     * 
     * API Call: PUT /config/user-scope/{scope}
     */
	public SystemConfigRestRep setUserScopeSystemConfiguration(String scope)
	{
		SystemConfigRestRep response = client.put(SystemConfigRestRep.class, CONFIG_URL + USER_SCOPE_URL + USER_SCOPE, new Object[] {scope});
		return response;
	}
	 
	/**
	 * This client method sends a GET request to retrieve the User Scope
	 * @return Already stored value of System Configuration for User Scope
	 * API Call: GET /config/user-scope
	 * 
	 */
	public SystemConfigRestRep getUserScopeSystemConfiguration()
	{
		SystemConfigRestRep response = client.get(SystemConfigRestRep.class, CONFIG_URL + USER_SCOPE_URL);
		return response;
	}

}
