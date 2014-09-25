package com.emc.vipr.client.object.impl;

public class PathConstants {
    public static final String ID_PATH = "/{id}";
    public static final String NAMESPACE_ID_PATH = "/{namespace}";
    public static final String DATA_STORES_URL = "/vdc/data-stores";
    public static final String FILESYSTEMS_PATH = "/filesystems";
    public static final String NFSEXPORT_PATH = "/nfsexportpoints";
    public static final String COMMODITY_PATH = "/commodity"; 
    public static final String NETWORKS_URL = "/object/networks";
    public static final String DEACTIVATE_PATH = "/deactivate";
    public static final String SECRET_KEYS_URL = "/object/secret-keys";
    public static final String BASE_URLS_URL = "/object/baseurl";
    public static final String NAMESPACES_URL = "/object/namespaces";
    public static final String NAMESPACE_PATH = "/namespace";
    public static final String NAMESPACE_RETENTION_CLASSES_URL = NAMESPACES_URL + NAMESPACE_PATH
            + "/{namespace}/retention";
    public static final String NAMESPACE_RETENTION_CLASS_URL = NAMESPACE_RETENTION_CLASSES_URL + "/{className}";
    public static final String TENANT_PATH = "/tenant";
    public static final String DATA_STORES_PATH = "/data-stores";
    public static final String USERS_URL = "/object/users";
    public static final String USER_SECRET_KEYS_URL = "/object/user-secret-keys/{userId}";
    public static final String ATMOS_IMPORTER_URL = "/object/atmos-importer";
    public static final String USER_PASSWORD_URL = "/object/user-password";
    public static final String OBJECT_INGESTION_URL = "/object/ingestion";
    public static final String OBJECT_BUCKET_URL = "/object/bucket";
    public static final String OBJECT_BUCKET_RETENTION_URL = OBJECT_BUCKET_URL + "/{bucketName}/retention";
    public static final String OBJECT_BUCKET_UPDATE_OWNER_URL = OBJECT_BUCKET_URL + "/{bucketName}/owner";
    public static final String OBJECT_VDC_VPOOLS_URL = "/vdc/data-service/vpools";
    public static final String ADD_VARRAY_PATH = "/addvarrays";
    public static final String REMOVE_VARRAY_PATH = "/removevarrays";   
    public static final String SEARCH_PATH = "/search";
    public static final String VARRAY_PATH = "/varray";
    public static final String IP_ADDR_PATH = "/ipaddress";
    public static final String CAS_CLUSTERS_URL = "/dataservice/cas-cluster";
    public static final String CLUSTER_CAPACITY_URL="/object/capacity";
    public static final String CAS_PROFILES_URL = CAS_CLUSTERS_URL + "/{clusterId}/profile";
    public static final String CAS_PROFILE_PEA_URL = CAS_PROFILES_URL + "/{profileId}/pea";
    public static final String CAS_POOLS_URL = CAS_CLUSTERS_URL + "/{clusterId}/pool";
    public static final String CAS_APPLICATIONS_URL = CAS_CLUSTERS_URL + "/{clusterId}/applications";
    public static final String VDCS_URL = "/object/vdcs";
    public static final String VDC_URL = VDCS_URL + "/vdc/{vdcName}";
    public static final String VDC_LIST_URL = VDCS_URL + "/vdc/list";
}
