package com.emc.vipr.client.system;

import static com.emc.vipr.client.system.impl.PathConstants.CONTROL_RESTART_URL;
import static com.emc.vipr.client.system.impl.PathConstants.CONTROL_POWER_OFF_CLUSTER_URL;
import static com.emc.vipr.client.system.impl.PathConstants.CONTROL_REBOOT_NODE_URL;
import static com.emc.vipr.client.impl.jersey.ClientUtils.addQueryParam;

import javax.ws.rs.core.UriBuilder;

import com.emc.vipr.client.impl.RestClient;

public class Control {
			
	private static final String NODE_ID_PARAM = "node_id";
	private static final String NAME_PARAM = "name";
    private static final String FORCE_PARAM = "force";
    private static final String FORCE_VALUE = "1";
	
	private RestClient client;
	
	public Control(RestClient client) {
        this.client = client;
    }
	
	/**
	 * Restart a service on a virtual machine.
	 * <p>
	 * API Call: POST /control/service/restart
	 * 
	 * @param nodeId Virtual machine id
	 * @param name Service name
	 */
	public void restartService(String nodeId, String name) {
    	UriBuilder builder = client.uriBuilder(CONTROL_RESTART_URL);
    	addQueryParam(builder, NODE_ID_PARAM, nodeId);
    	addQueryParam(builder, NAME_PARAM, name);
		client.postURI(String.class, builder.build());			
	}

	/**
	 * Reboot a virtual machine.
	 * <p>
	 * API Call: POST /control/node/reboot
	 * 
	 * @param nodeId Virtual machine id
	 */
	public void rebootNode(String nodeId) {
    	UriBuilder builder = client.uriBuilder(CONTROL_REBOOT_NODE_URL);
    	addQueryParam(builder, NODE_ID_PARAM, nodeId);
		client.postURI(String.class, builder.build());				
	}
	
	/**
	 * Powers off all nodes in a ViPR cluster.
	 * <p>
	 * API Call: POST /control/cluster/poweroff
	 */
	public void powerOffCluster() {
		powerOffCluster(false);
	}

    /**
     * Powers off all nodes in a ViPR cluster.
     * <p>
     * API Call: POST /control/cluster/poweroff
     *
     * @param force Set to true to force poweroff
     */
    public void powerOffCluster(boolean force) {
        UriBuilder builder = client.uriBuilder(CONTROL_POWER_OFF_CLUSTER_URL);
        if (force) {
            addQueryParam(builder, FORCE_PARAM, FORCE_VALUE);
        }
        client.postURI(String.class, builder.build());
    }
}
