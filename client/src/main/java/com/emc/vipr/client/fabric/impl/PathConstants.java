package com.emc.vipr.client.fabric.impl;

public class PathConstants {
    public static final String CONTEXT_ROOT = "/vdc/fabric";

    public static final String ID_PATH = "/{id}";
    public static final String NODES_URL = CONTEXT_ROOT + "/nodes";
    public static final String NODE_INFO_URL = CONTEXT_ROOT + "/nodes/{id}";
    public static final String NODE_DISKS_URL = CONTEXT_ROOT + "/nodes/{id}/disks";
    public static final String NODE_CAPACITY_URL = CONTEXT_ROOT + "/nodes/{id}/capacity";
    public static final String NODE_HEALTH_URL = CONTEXT_ROOT + "/nodes/{id}/health";

    public static final String DISKS_URL = CONTEXT_ROOT + "/disks";
    public static final String DISK_INFO_URL = CONTEXT_ROOT + "/disks/{id}";
    public static final String DISK_CAPACITY_URL = CONTEXT_ROOT + "/disks/{id}/capacity";

    public static final String SERVICES_URL = CONTEXT_ROOT+"/services";
    public static final String SERVICE_INFO_URL = CONTEXT_ROOT +"/services/{id}";
    public static final String SERVICES_NODES_URL = CONTEXT_ROOT +"/services/{id}/nodes";
    public static final String SERVICES_CAPACITY_URL = CONTEXT_ROOT + "/services/{id}/capacity";

    public static final String STATS_URL = CONTEXT_ROOT + "/stats";

    public static final String PROVISIONING_PROVISION_URL = CONTEXT_ROOT + "/provisioning/provision";
    
    public static final String FABRIC_HEALTH_URL = CONTEXT_ROOT + "/health";
    public static final String FABRIC_CAPACITY_URL = CONTEXT_ROOT + "/capacity";

}
