package com.emc.vipr.client.system.impl;

public class PathConstants {
    public static final String UPGRADE_URL = "/upgrade";
    public static final String IMAGE_INSTALL_URL = UPGRADE_URL + "/image/install";
    public static final String IMAGE_REMOVE_URL = UPGRADE_URL + "/image/remove";
    public static final String IMAGE_UPLOAD_URL = UPGRADE_URL + "/image/upload ";
    public static final String IMAGE_INSTALL_CANCEL_URL = UPGRADE_URL+ "/image/install/cancel/";
    public static final String IMAGE_DOWNLOAD_PROGRESS_URL = UPGRADE_URL + "/image/download/progress/";
    public static final String TARGET_VERSION_URL = UPGRADE_URL + "/target-version";
    public static final String CLUSTER_STATE_URL = UPGRADE_URL + "/cluster-state";
    public static final String LOGS_URL = "/logs";
    public static final String LOG_LEVELS_URL = LOGS_URL + "/log-levels";
    
    public static final String PASSWORD_URL = "/password";
    public static final String UPDATE_AUTH_KEY_URL = PASSWORD_URL + "/authorizedkey2";
    public static final String UPDATE_PASSWORD_URL = PASSWORD_URL + "/reset";
    
    public static final String LICENSE_URL = "/license";

    public static final String MONITOR_URL = "/monitor";
    public static final String MONITOR_STATS_URL = MONITOR_URL + "/stats";
    public static final String MONITOR_HEALTH_URL = MONITOR_URL + "/health";
    public static final String MONITOR_DIAGNOSTICS_URL = MONITOR_URL + "/diagnostics";
    public static final String MONITOR_STORAGE_URL = MONITOR_URL + "/storage";

    public static final String CONTROL_URL = "/control";
    public static final String CONTROL_RESTART_URL = CONTROL_URL + "/service/restart";
    public static final String CONTROL_REBOOT_NODE_URL = CONTROL_URL + "/node/reboot";
    public static final String CONTROL_POWER_OFF_CLUSTER_URL = CONTROL_URL + "/cluster/poweroff";
    
    public static final String CONFIG_URL = "/config";
    public static final String CONFIG_PROPERTIES_URL = CONFIG_URL + "/properties";
    public static final String CONFIG_PROP_METADATA_URL = CONFIG_URL + "/properties/metadata";
    public static final String CONFIG_CONNECT_EMC_FTPS_URL = CONFIG_URL + "/connectemc/ftps";
    public static final String CONFIG_CONNECT_EMC_EMAIL_URL = CONFIG_URL + "/connectemc/email";
    public static final String CONFIG_PROP_RESET_URL = CONFIG_URL + "/properties/reset";
    public static final String CONFIG_DATA_NODE_URL = CONFIG_URL + "/datanode-config";
    public static final String CONFIG_EXTRA_NODES_UPGRADE_LOCK_URL = CONFIG_URL + "/extranodes-upgradelock/reset";
    
    public static final String CALLHOME_URL = "/callhome";
    public static final String CALLHOME_REGISTRATION_URL = CALLHOME_URL + "/registration";
    public static final String CALLHOME_HEARTBEAT_URL = CALLHOME_URL + "/heartbeat";
    public static final String CALLHOME_ALERT_URL = CALLHOME_URL + "/alert";
    public static final String CALLHOME_ALERT_TASKS_URL = CALLHOME_URL + "/alert/{id}/tasks";
    public static final String CALLHOME_ALERT_TASK_URL = CALLHOME_URL + "/alert/{id}/tasks/{op_id}";
    public static final String CALLHOME_ERS_URL = CALLHOME_URL + "/esrs-device";
    
    public static final String USER_SCOPE_URL = "/user-scope";
    public static final String USER_SCOPE = "/{scope}";
    
}
