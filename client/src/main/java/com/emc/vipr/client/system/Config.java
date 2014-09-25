package com.emc.vipr.client.system;

import static com.emc.vipr.client.impl.jersey.ClientUtils.addQueryParam;
import static com.emc.vipr.client.system.impl.PathConstants.CONFIG_CONNECT_EMC_EMAIL_URL;
import static com.emc.vipr.client.system.impl.PathConstants.CONFIG_CONNECT_EMC_FTPS_URL;
import static com.emc.vipr.client.system.impl.PathConstants.CONFIG_DATA_NODE_URL;
import static com.emc.vipr.client.system.impl.PathConstants.CONFIG_EXTRA_NODES_UPGRADE_LOCK_URL;
import static com.emc.vipr.client.system.impl.PathConstants.CONFIG_PROPERTIES_URL;
import static com.emc.vipr.client.system.impl.PathConstants.CONFIG_PROP_METADATA_URL;
import static com.emc.vipr.client.system.impl.PathConstants.CONFIG_PROP_RESET_URL;

import java.io.InputStream;

import javax.ws.rs.core.UriBuilder;

import com.emc.storageos.model.property.PropertiesMetadata;
import com.emc.storageos.model.property.PropertyInfoRestRep;
import com.emc.storageos.model.property.PropertyInfoUpdate;
import com.emc.storageos.model.property.PropertyList;
import com.emc.vipr.client.impl.RestClient;
import com.emc.vipr.model.sys.ClusterInfo;
import com.emc.vipr.model.sys.eventhandler.ConnectEmcEmail;
import com.emc.vipr.model.sys.eventhandler.ConnectEmcFtps;
import com.sun.jersey.api.client.ClientResponse;

public class Config {
	
	private static final String REMOVE_OBSOLETE_PARAM = "removeObsolete";
	private static final String REMOVE_OBSOLETE = "1";
	
	private RestClient client;
	
	private enum UserScopeType {GLOBAL, NAMESPACE};
	
	public Config(RestClient client) {
        this.client = client;
    }
	
	/**
	 * Get system configuration properties.
	 * <p>
	 * API Call: GET /config/properties
	 * 
	 * @return Property information
	 */
	public PropertyInfoRestRep getProperties() {
		return client.get(PropertyInfoRestRep.class, CONFIG_PROPERTIES_URL);
	}
	
	/**
	 * Update system configuration properties
	 * <p>
	 * API Call: PUT /config/properties
	 * 
	 * @param setProperty Property's key value pair.
	 * @return Cluster information
	 */
	public ClusterInfo setProperties(PropertyInfoUpdate setProperty) {
		return client.put(ClusterInfo.class, setProperty, CONFIG_PROPERTIES_URL);
	}
	
	/**
	 * Show metadata of system configuration properties.
	 * <p>
	 * API Call: GET /config/properties/metadata
	 * 
	 * @return Properties Metadata
	 */
	public PropertiesMetadata getPropMetadata() {
		return client.get(PropertiesMetadata.class, CONFIG_PROP_METADATA_URL);
	}
	
	/**
	 * Configure ConnectEMC FTPS transport related properties.
	 * <p>
	 * API Call: POST /config/connectemc/ftps
	 * 
	 * @param ftpsParams ConnectEMC FTPS transport related properties
	 * @return The cluster information
	 */
	public ClusterInfo configureConnectEmcFtpsParams(ConnectEmcFtps ftpsParams) {
		return client.post(ClusterInfo.class, ftpsParams, CONFIG_CONNECT_EMC_FTPS_URL);
	}
	
	/**
	 * Configure ConnectEMC SMTP/Email transport related properties.
	 * <p>
	 * API Call: POST /config/connectemc/email
	 * 
	 * @param emailParams ConnectEMC SMTP/Email transport related properties
	 * @return The cluster information
	 */
	public ClusterInfo configureConnectEmcEmailParams(ConnectEmcEmail emailParams) {
		return client.post(ClusterInfo.class, emailParams, CONFIG_CONNECT_EMC_EMAIL_URL);
	}
	
	/**
	 * Reset configuration properties to their default values. Properties with 
	 * no default values will remain unchanged.
	 * <p>
	 * API Call: POST /config/properties/reset
	 * 
	 * @param propertyList Configuration properties to reset
	 * @param removeObsoleteProps If true, removes obsolete properties
	 * @return The cluster information
	 */
	public ClusterInfo resetProps(PropertyList propertyList, boolean removeObsoleteProps) {
    	UriBuilder builder = client.uriBuilder(CONFIG_PROP_RESET_URL);
    	if (removeObsoleteProps) {
    		addQueryParam(builder, REMOVE_OBSOLETE_PARAM, REMOVE_OBSOLETE);
    	} 

		return client.postURI(ClusterInfo.class, propertyList, builder.build());		
	}
	
	/**
	 * Reset configuration properties to their default values. Properties with 
	 * no default values will remain unchanged. Removes obsolete properties.
	 * 
	 * @param propertyList Configuration properties to reset
	 * @return The cluster information
	 */
	public ClusterInfo resetProps(PropertyList propertyList) {
		return resetProps(propertyList, true);
	}
	
	/**
	 * Get ISO9660 image with one file (under root directory) having system properties 
	 * that are visible on all nodes (includes control& object). This is required for 
	 * data service VM deployment.
	 * <p>
	 * API Call: GET /config/datanode-config
	 * 
	 * @return The ISO image byte stream with 48KB size.
	 */
	public InputStream getVisiblePropertiesISO() {
		ClientResponse response = client.get(ClientResponse.class, CONFIG_DATA_NODE_URL);
		return response.getEntityInputStream();
	}
	
	/**
	 * Reset extra nodes' upgrade lock After starting reboot, an extra node will hold 
	 * the upgrade lock until the node comes back again. If it doesn't come back in a 
	 * long time, we have to release the lock. Otherwise, the cluster state will be 
	 * shown as 'DEGRADED', which prevents us from doing any other operations.
	 * <p>
	 * API Call: POST /config/extranodes-upgradelock/reset
	 */
	public void resetExtraNodesUpgradeLock() {
		client.post(String.class, CONFIG_EXTRA_NODES_UPGRADE_LOCK_URL);
	}
	
}
