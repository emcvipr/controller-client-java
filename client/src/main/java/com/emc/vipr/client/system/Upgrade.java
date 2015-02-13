package com.emc.vipr.client.system;

import static com.emc.vipr.client.impl.jersey.ClientUtils.addQueryParam;
import static com.emc.vipr.client.system.impl.PathConstants.*;

import javax.ws.rs.core.UriBuilder;

import com.emc.vipr.client.impl.RestClient;
import com.emc.vipr.model.sys.ClusterInfo;
import com.emc.vipr.model.sys.DownloadProgress;
import com.emc.vipr.model.sys.TargetVersionResponse;

public class Upgrade {
	private static final String VERSION_PARAM = "version";
	private static final String FORCE_PARAM = "force";
	private static final String FORCE = "1";
	private static final String SHOW_ALL_VERSIONS = "1";
	
	private RestClient client;
	
	public Upgrade(RestClient client) {
        this.client = client;
    }
	
	/**
     * Installs an image. Image can be installed only if the number of installed images 
     * are less than MAX_SOFTWARE_VERSIONS.
     * <p>
     * API Call: POST /upgrade/image/install
	 * 
	 * @param version The version to be installed
	 * @param force If true, image will be installed even if the maximum number
	 *              of versions installed are more than MAX_SOFTWARE_VERSIONS
	 * @return The cluster information of the installed image
	 */
	public ClusterInfo installImage(String version, boolean force) {
    	UriBuilder builder = client.uriBuilder(IMAGE_INSTALL_URL);
    	addQueryParam(builder, VERSION_PARAM, version);
    	if (force) {
    		addQueryParam(builder, FORCE_PARAM, FORCE);
    	}
		return client.postURI(ClusterInfo.class, builder.build());		
	}

    /**
     * Cancels download of an image
     * <p>
     * API Call: POST /upgrade/install/cancel
     *
     * @return The new state of the cluster
     */
    public ClusterInfo cancelInstallImage() {
        UriBuilder builder = client.uriBuilder(IMAGE_INSTALL_CANCEL_URL);
        return client.postURI(ClusterInfo.class, builder.build());
    }

    /**
     * Provides progress information when an image download is in progress
     * <p>
     * API Call: POST /upgrade/image/download/progress
     *
     * @return The Download Progress information
     */
    public DownloadProgress getDownloadProgress() {
        return client.get(DownloadProgress.class, IMAGE_DOWNLOAD_PROGRESS_URL);
    }
    /**
	 * Remove an image. Image can be removed only if the number of installed images 
	 * are greater than MAX_SOFTWARE_VERSIONS.
     * <p>
     * API Call: POST /upgrade/image/remove
     * 
	 * @param version Version to be removed
	 * @param force If true, image will be removed even if the maximum number of versions 
	 *              installed are less than MAX_SOFTWARE_VERSIONS
	 * @return The cluster information
	 */
	public ClusterInfo removeImage(String version, boolean force) {
    	UriBuilder builder = client.uriBuilder(IMAGE_REMOVE_URL);
    	addQueryParam(builder, VERSION_PARAM, version);
    	if (force) {
    		addQueryParam(builder, FORCE_PARAM, FORCE);
    	}
		return client.postURI(ClusterInfo.class, builder.build());			
	}
	
	/**
	 * Remove an image. Image can be removed only if the number of installed images 
	 * are greater than MAX_SOFTWARE_VERSIONS.
     * 
	 * @param version Version to be removed
	 * @return The cluster information
	 */
	public ClusterInfo removeImage(String version) {
    	return removeImage(version, false);		
	}	
	
    /**
     * Show the current target version.
     * <p>
     * API Call: GET /upgrade/target-version
     * 
     * @return The target version
     */
    public TargetVersionResponse getTargetVersion() {
		return client.get(TargetVersionResponse.class, TARGET_VERSION_URL);
    }
    
    /**
     * Update target version. Version can only be updated incrementally. Ex: storageos-1.0.0.2.xx 
     * can only be updated to sotrageos-1.0.0.3.xx and not to storageos-1.0.0.4.xx
     * <p>
     * API Call: PUT /upgrade/target-version
     * 
     * @param version The new version number
     * @param skipGeoPrecheck If true, skips all multi-VDC pre-checks.
     * @return The cluster information
     */
    public ClusterInfo setTargetVersion(String version, boolean skipGeoPrecheck) {
    	UriBuilder builder = client.uriBuilder(TARGET_VERSION_URL);
    	addQueryParam(builder, VERSION_PARAM, version);
    	if (!skipGeoPrecheck) {
    	    addQueryParam(builder, FORCE_PARAM, FORCE);
    	}
    	return client.putURI(ClusterInfo.class, null, builder.build());	
    }    
    
    /**
     * Update target version with no version number verification. Version can only be 
     * updated incrementally. Ex: storageos-1.0.0.2.xx can only be updated to 
     * sotrageos-1.0.0.3.xx and not to storageos-1.0.0.4.xx
     * 
	 * @param version The new version number
     * @return The cluster information
     */
    public ClusterInfo setTargetVersion(String version) {
    	return setTargetVersion(version, true);
    }  	
	
    /**
     * Shows the cluster information with all removable versions.
     * <p>
     * API Call: GET /upgrade/cluster-state
     *
     * @param showAllVersions If true, will show all removable versions even though 
     *                        the installed versions are less than MAX_SOFTWARE_VERSIONS
     * @return The cluster information
     */
    public ClusterInfo getClusterInfo(boolean showAllVersions) {
    	UriBuilder builder = client.uriBuilder(CLUSTER_STATE_URL);
    	if (showAllVersions) {
    		addQueryParam(builder, FORCE_PARAM, SHOW_ALL_VERSIONS);
    	}
		return client.getURI(ClusterInfo.class, builder.build());
    }
    
    /**
     * Shows the cluster information, excluding all removable versions.
     *
     * @return The cluster state information
     */
    public ClusterInfo getClusterInfo() {
    	return getClusterInfo(false);
    }    
    
    /**
     * Convenience method that gets the cluster state from the cluster info.
     * 
     * @return the cluster state
     */
    public String getClusterState() {
    	return getClusterInfo(false).getCurrentState();
    }

}
