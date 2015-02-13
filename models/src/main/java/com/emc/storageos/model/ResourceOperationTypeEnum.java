/**
 *  Copyright (c) 2008-2011 EMC Corporation
 * All Rights Reserved
 *
 * This software contains the intellectual property of EMC Corporation
 * or is licensed to EMC Corporation from third parties.  Use of this
 * software and the intellectual property contained therein is expressly
 * limited to the terms and conditions of the License Agreement under which
 * it is provided by or on behalf of EMC.
 */
package com.emc.storageos.model;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlElement;

public enum ResourceOperationTypeEnum {

    //@todo - update the following enum with more fields (esp description, audit message, event messages(if needed)
    //@todo- validate the actions/description (esp controller specific operation) with controller team.

    /*                          name                        description               */
    CREATE_TENANT           ("CREATE TENANT",           "create tenant operation"),
    UPDATE_TENANT           ("UPDATE TENANT",           "update tenant operation"),
    DELETE_TENANT           ("DELETE TENANT",           "delete tenant operaton"),
    UPDATE_TENANT_STS       ("UPDATE TENANT STS",       "update tenant's STS operation"),
    REASSIGN_TENANT_ROLES   ("REPLACE TENANT ROLES",    "overwrite tenant roles"),
    MODIFY_TENANT_ROLES     ("MODIFY TENANT ROLES",     "modify the tenant roles"),
    CREATE_TENANT_TAG       ("TAG TENANT",              "tag on a tenant"),
    REASSIGN_ZONE_ROLES     ("REPLACE ZONE ROLES",      "overwrite zone roles"),
    MODIFY_ZONE_ROLES       ("MODIFY ZONE ROLES",       "modify the zone roles"),
    CREATE_PROJECT          ("CREATE PROJECT",          "create project"),
    UPDATE_PROJECT          ("UPDATE PROJECT",          "update project"),
    DELETE_PROJECT          ("DELETE PROJECT",          "delete project operation"),
    MODIFY_PROJECT_ACL      ("MODIFY PROJECT ACL",      "modify project acls"),
    REASSIGN_PROJECT_ACL    ("REPLACE PROJECT ACL",     "overwrite project acls"),
    CREATE_VPOOL            ("CREATE VPOOL",            "create vpool operation"),
    UPDATE_VPOOL            ("UPDATE VPOOL",            "update vpool operation"),
    DELETE_VPOOL            ("DELETE VPOOL",            "delete vpool operation"),
    REASSIGN_VPOOL_ACL      ("REPLACE VPOOL ACL",         "overwrite vpool acls"),
    MODIFY_VPOOL_ACL        ("MODIFY VPOOL ACL",          "modify vpool acls"),
    ASSIGN_VPOOL_TAG        ("ASSIGN VPOOL TAG",          "assign a tag to a vpool"),
    CREATE_BLOCK_VOLUME     ("CREATE VOLUME",           "create volume operation"),
    DELETE_BLOCK_VOLUME     ("DELETE VOLUME",           "delete operation"),
    EXPAND_BLOCK_VOLUME     ("EXPAND VOLUME",           "expand volume operation"),
    IMPORT_BLOCK_VOLUME     ("IMPORT BLOCK VOLULME",    "import block volume"),
    MIGRATE_BLOCK_VOLUME    ("MIGRATE VOLUME",          "migrate volume operation"),
    MIGRATE_EXPAND_BLOCK_VOLUME    ("MIGRATE EXPAND VOLUME",          "migrate volume for expansion"),
    COMMIT_VOLUME_MIGRATION            ("COMMIT VOLUME MIGRATION",        "commit volume migration"),
    ROLLBACK_COMMIT_VOLUME_MIGRATION   ("ROLLBAK COMMIT VOLUME MIGRATION",  "rollback commit volume migration"),
    DELETE_MIGRATION_SOURCE_VOLUMES    ("DELETE MIGRATION SOURCE VOLUMES",  "delete migration source volumes"),
    CREATE_VOLUME_WORKFLOW_STEP ("CREATE VOLUME WF STEP",           "create volume workflow step"),
    DELETE_VOLUME_WORKFLOW_STEP ("DELETE VOLUME WF STEP",           "delete volume workflow step"),
    ADD_INITIATOR_WORKFLOW_STEP ("ADD INITIATOR WF STEP",           "add initiator workflow step"),
    DELETE_INITIATOR_WORKFLOW_STEP ("DELETE INITIATOR WF STEP",     "delete initiator workflow step"),
    CREATE_VOLUME_FULL_COPY ("CREATE VOLUME FULL COPY", "create a volume full copy"),
    ACTIVATE_VOLUME_FULL_COPY ("ACTIVATE VOLUME FULL COPY", "activate a volume full copy"),
    DETACH_VOLUME_FULL_COPY ("DETACH VOLUME FULL COPY", "detach a volume full copy"),
    CREATE_VOLUME_SNAPSHOT  ("CREATE VOLUME SNAPSHOT",  "create a volume snapshot"),
    ASSIGN_VOLUME_TAG       ("ASSIGN VOLUME TAG",       "tag a volume"),
    DELETE_VOLUME_SNAPSHOT  ("DELETE VOLUME SNAPSHOT",  "delete volume snapshot"),
    RESTORE_VOLUME_SNAPSHOT ("RESTORE VOLUME SNAPSHOT", "restore volume snapshot"),
    ACTIVATE_VOLUME_SNAPSHOT("ACTIVATE VOLUME SNAPSHOT","activate volume snapshot"),
    DEACTIVATE_VOLUME_SNAPSHOT("DEACTIVATE VOLUME SNAPSHOT","deactivate volume snapshot"),
    ASSIGN_VOLUME_SNAPSHOT_TAG ("TAG VOLUME SNAPSHOT",  "tag a volume snapshot"),
    CREATE_EXPORT_GROUP        ("CREATE EXPORT GROUP",  "create export group operation"),
    DELETE_EXPORT_GROUP        ("DELETE EXPORT GROUP",  "delete export group operation"),
    ADD_EXPORT_VOLUME          ("ADD VOLUME TO EXPORT GROUP",   "add volume to export group"),
    CREATE_VIRTUAL_VOLUME   ("CREATE VIRTUAL VOLUME",   "create a virtual volume"),
    ROLLBACK_CREATE_VIRTUAL_VOLUME   ("ROLLBACK CREATE VIRTUAL VOLUME",  "rollback virtual volume create"),
    DELETE_VIRTUAL_VOLUME   ("DELETE VIRTUAL VOLUME",       "delete a virtual volume"),
    EXPAND_VIRTUAL_VOLUME   ("EXPAND VIRTUAL VOLUME",       "expand a virtual volume"),
    MIGRATE_VIRTUAL_VOLUME  ("MIGRATE VIRTUAL VOLUME",      "migrate a virtual volume"),
    ROLLBACK_MIGRATE_VIRTUAL_VOLUME   ("ROLLBACK MIGRATE VIRTUAL VOLUME",  "rollback virtual volume migrate"),
    CREATE_VVOLUME_FROM_IMPORT ("CREATE VIRTUAL VOLUME FROM IMPORT",       "create virtual volume from imported volume"),
    UPDATE_EXPORT_GROUP        ("UPDATE EXPORT GROUP",           "update export group operation"),
    DELETE_EXPORT_VOLUME       ("DELETE VOLUME FROM EXPORTGROUP",      "delete volume from the export group"),
    CREATE_FILE_SYSTEM         ("CREATE FILESYSTEM",     "create filesystem operation"),
    DELETE_FILE_SYSTEM         ("DELETE FILESYSTEM",     "delete filesystem operation"),
    EXPORT_FILE_SYSTEM         ("EXPORT FILESYSTEM",     "export filesystem operation"),
    UPDATE_EXPORT_RULES_FILE_SYSTEM  ("UPDATE EXPORT RULES FILESYSTEM",     "Update export rules filesystem operation"),
    EXPAND_FILE_SYSTEM         ("EXPAND FILESYSTEM",     "expand filesystem operation"),
    CREATE_FILE_SYSTEM_SHARE   ("CREATE FILESHARE",      "create fileshare operation"),
    CREATE_FILE_SYSTEM_SNAPSHOT("SNAPSHOT FILESYSTEM",   "snapshot filesystem"),
    CREATE_FILE_SYSTEM_QUOTA_DIR   ("CREATE FILESYSTEM QUOTA DIR",   "create filesystem quota directory"),
    DELETE_FILE_SYSTEM_QUOTA_DIR  ("DELETE FILESYSTEM QUOTA DIR",   "delete filesystem quota directory"),
    UPDATE_FILE_SYSTEM_QUOTA_DIR   ("UPDATE FILESYSTEM QUOTA DIR",   "update filesystem quota directory"),
    
    ASSIGN_FILE_SYSTEM_TAG     ("TAG A FILESYSTEM",      "tag a filesystem"),
    DELETE_FILE_SNAPSHOT       ("DELETE FILESYSTEM SNAPSHOT",   "delete filesystem snapshot"),
    UNEXPORT_FILE_SYSTEM       ("UNEXPORT FILESYSTEM",          "unexport filesystem operation"),
    DELETE_FILE_SYSTEM_SHARE   ("DELETE FILESHARE",             "delete fileshare"),
    EXPORT_FILE_SNAPSHOT       ("EXPORT FILESYSTEM SNAPSHOT",   "export fileshare snapshot"),
    UPDATE_EXPORT_RULES_FILE_SNAPSHOT       ("UPDATE EXPORT RULES FILESYSTEM SNAPSHOT",   "update export rules fileshare snapshot"),
    CREATE_FILE_SNAPSHOT_SHARE ("SNAPSHOT FILESHARE",           "perform fileshare snapshot"),
    ASSIGN_FILE_SNAPSHOT_TAG   ("TAG A FILESYSTEM SNAPSHOT",    "tag a fileshare snapshot"),
    UNEXPORT_FILE_SNAPSHOT     ("UNEXPORT FILESYSTEM SNAPSHOT", "unexport fileshare snapshot"),
    DELETE_FILE_SNAPSHOT_SHARE ("DELETE FILESHARE SNAPSHOT",    "delete fileshare snapshot"),
    RESTORE_FILE_SNAPSHOT      ("RESTORE FILE SANPSHOT",        "restore fileshare snapshot"),
    CREATE_KEYPOOL             ("CREATE KEYPOOL",     "create keypool operation"),
    DELETE_KEYPOOL             ("DELETE KEYPOOL",     "delete keypool operation"),
    UPDATE_KEYPOOL_ACCESSMODE  ("UPDATE KEYPOOL",     "update keypool operation"),
    CREATEnameSPACE           ("CREATE NAMESPACE",   "create object namespace operaiton"),
    UPDATEnameSPACE           ("UPDATE NAMESPACE",   "update object namespace operaiton"),
    DELETEnameSPACE           ("DELETE NAMESPACE",   "delete object namespace operaiton"),
    CREATE_VARRAY              ("CREATE VARRAY",      "create varray operation"),
    DELETE_VARRAY              ("DELETE VARRAY",      "delete varray operation"),
    UPDATE_VARRAY              ("UPDATE VARRAY",      "update varray operation"),
    MODIFY_VARRAY_ACL          ("UPDATE VARRAY ACL",   "update varray acls"),
    REASSIGN_VARRAY_ACL        ("REPLACE VARRAY ACL",  "overwrite varray acls"),
    CREATE_NETWORK             ("CREATE NETWORK",      "create network operation"),
    CREATE_DATA_STORE          ("CREATE DATASTORE",     "create data store operation"),
    DELETE_DATA_STORE          ("DELETE DATASTORE",     "delete data store operation"),
    CREATE_SECRET_KEY          ("CREATE SECRET KEY",     "create a secret key for a user"),
    DELETE_SECRET_KEY          ("DELETE SECRET KEY",     "delete a user's secret key"),
    REGISTER_SMISPROVIDER      ("REGISTER SMIS PROVIDER","register smis provider"),
    DELETE_SMISPROVIDER        ("DELETE SMIS PROVIDER",  "delete smis provider"),
    UPDATE_SMISPROVIDER        ("UPDATE SMIS PROVIDER",  "update smis provider"),
    SCAN_SMISPROVIDER          ("SCAN SMIS PROVIDER",    "scan smis provider"),
    SCAN_STORAGEPROVIDER       ("SCAN STORAGE PROVIDER",  "scan storage provider"),
    REGISTER_STORAGE_SYSTEM    ("REGISTER SMIS SYSTEM","register sims system"),
    REGISTER_STORAGEPROVIDER   ("REGISTER STORAGE PROVIDER","register storage provider"),
    UPDATE_STORAGE_POOL        ("UPDATE STORAGEPOOL",     "update storage pool"),
    DELETE_STORAGE_POOL        ("DELETE STORAGEPOOL",     "delete storage pool"),
    DEREGISTER_STORAGE_POOL    ("UNREGISTER STORAGEPOOL", "unregister a storage pool"),
    ASSIGN_STORAGE_POOL_TAG    ("TAG STORAGEPOOL",        "tag a storage pool"),
    UPDATE_STORAGE_PORT        ("UPDATE STORAGEPORT",     "update storage port"),
    DELETE_STORAGE_PORT        ("DELETE STORAGEPORT",     "delete storage port"),
    SELECT_STORAGE_PORT        ("SELECT STORAGEPORT",     "select storage port for export"),
    DEREGISTER_STORAGE_PORT    ("UNREGISTER STORAGEPORT", "unregister storage port"),
    ASSIGN_STORAGE_PORT_TAG    ("TAG STORAGEPORT",        "tag a storage port"),
    CREATE_STORAGE_SYSTEM      ("CREATE STORAGESYSTEM",   "create a storage system"),
    UPDATE_STORAGE_SYSTEM      ("UPDATE STORAGESYSTEM",   "update a storage system"),
    DELETE_STORAGE_SYSTEM      ("DELETE STORAGESYSTEM",   "delete a storage system"),
    ADD_STORAGE_SYSTEM         ("ADD STORAGESYSTEM",   "add a storage system"),
    DISCOVER_ALL_STORAGE_SYSTEM("DISCOVER ALL STORAGESYSTEMS",  "discover all storage systems"),
    DISCOVER_STORAGE_SYSTEM    ("DISCOVER STORAGESYSTEM",       "discover a storage systems"),
    METERING_STORAGE_SYSTEM    ("METERING STORAGE SYSTEM",      "obtain metering information on a storage system"),
    DEREGISTER_STORAGE_SYSTEM  ("UNREGISTER STORAGESYSTEM",     "unregister a storage systems"),
    CREATE_STORAGE_POOL        ("CREATE STORAGEPOOL",     "create storagepool operation"),
    CREATE_STORAGE_PORT        ("CREATE STORAGEPORT",     "create storageport operation"),
    ASSIGN_STORAGE_SYSTEM_TAG  ("TAG STORAGESYSTEM",      "tag a storage system"),
    REGISTER_STORAGE_POOL      ("REGISTER STORAGEPOOL",   "register storageport"),
    REGISTER_STORAGE_PORT      ("REGISTER STORAGEPORT",   "register storage port"),
    DELETE_NETWORK             ("DELETE NETWORK",   "delete network"),
    UPDATE_NETWORK             ("UPDATE NETWORK",  "update network"),
    UPDATE_NETWORK_ENDPOINT    ("UPDATE NETWORK ENDPOINT", "update network endpoint"),
    ASSIGN_NETWORK_TAG         ("TAG NETWORK",     "tag a network"),
    CREATE_ATMOS_SUBTENANT        ("CREATE ATMOS SUBTENANT","create atmos subtenant"),
    DELETE_ATMOS_SUBTENANT        ("DELETE ATMOS SUBTENANT","delete atmos subtenant"),
    CREATE_S3_BUCKET              ("CREATE S3 BUCKET",      "create S3 bucket"),
    SET_S3_BUCKET_ACL             ("SET ACL ON S3 BUCKET",  "set an acl on S3 bucket"),
    SET_S3_BUCKET_VERSION         ("VERSION S3 BUCKET",     "set the version of S3 bucket"),
    CREATE_SWIFT_CONTAINER        ("CREATE SWIFT CONTAINER","create swift container"),
    DELETE_SWIFT_CONTAINER        ("DELETE SWIFT CONTAINER","delete swift container"),
    CREATE_INITIATOR           ("CREATE INITIATOR",         "create initiator"),
    ADD_HOST_INITIATOR           ("ADD HOST INITIATOR",         "add an initiator associated with a host"),
    DELETE_INITIATOR           ("DELETE INITIATOR",         "delete initiator"),
    CREATE_NETWORK_SYSTEM      ("CREATE NETWORKSYSTEM",     "create a network system"),
    UPDATE_NETWORK_SYSTEM      ("UPDATE NETWORKSYSTEM",     "update a network system"),
    DELETE_NETWORK_SYSTEM      ("DELETE NETWORKSYSTEM",     "delete a network system"),
    DISCOVER_NETWORK_SYSTEM    ("DISCOVER NETWORKSYSTEM",   "discover one network system"),
    ADD_SAN_ZONE               ("ADD SAN ZONE",          "add one or more san zones"),
    REMOVE_SAN_ZONE            ("REMOVE SAN ZONE",       "remove one or more san zones"),
    UPDATE_SAN_ZONE            ("UPDATE SAN ZONE",       "update one or more san zones"),
    ACTIVATE_SAN_ZONE          ("ACTIVATE SAN ZONE",     "activate one or more san zones"),
    PERFORM_PROTECTION_OPERATION  ("PERFORM PROTECTION OPERATION",  "protect a block volume" ),
    DISCOVER_PROTECTION_SET       ("DISCOVER_PROTECTION_SET", "discover protection set"),
    PERFORM_PROTECTION_ACTION                      ("PERFORM PROTECTION ACTION",                      "perform unspecified link management"),
    PERFORM_PROTECTION_ACTION_SYNC                 ("PERFORM PROTECTION ACTION SYNC",                 "synchronize replication link(s)"),
    PERFORM_PROTECTION_ACTION_FAILOVER             ("PERFORM PROTECTION ACTION FAILOVER",             "failover target volume(s)"),
    PERFORM_PROTECTION_ACTION_FAILOVER_CANCEL      ("PERFORM PROTECTION ACTION FAILOVER CANCEL",      "cancel a previous failover operation"),
    PERFORM_PROTECTION_ACTION_FAILOVER_TEST        ("PERFORM PROTECTION ACTION FAILOVER TEST",        "test a failover"),
    PERFORM_PROTECTION_ACTION_FAILOVER_TEST_CANCEL ("PERFORM PROTECTION ACTION FAILOVER TEST CANCEL", "cancel a test of a previous failover operation"),
    PERFORM_PROTECTION_ACTION_SWAP                 ("PERFORM PROTECTION ACTION SWAP",                 "swap source and target volumes"),
    PERFORM_PROTECTION_ACTION_STOP                 ("PERFORM PROTECTION ACTION STOP",                 "stop the replication link between source and target"),
    PERFORM_PROTECTION_ACTION_START                ("PERFORM PROTECTION ACTION START",                "start the replication link between source and target"),
    PERFORM_PROTECTION_ACTION_PAUSE                ("PERFORM PROTECTION ACTION PAUSE",                "pause the replication link between source and target"),
    PERFORM_PROTECTION_ACTION_SUSPEND               ("PERFORM PROTECTION ACTION SUSPEND",               "suspend the replication link between source and target"),
    PERFORM_PROTECTION_ACTION_RESUME               ("PERFORM PROTECTION ACTION RESUME",               "resume the replication link between source and target"),
    CREATE_AUTHPROVIDER        ("CREATE AUTH PROVIDER",     "create an authentication provider"),
    UPDATE_AUTHPROVIDER        ("UPDATE AUTH PROVIDER",     "update an authentication provider"),
    DELETE_AUTHPROVIDER        ("DELETE AUTH PROVIDER",     "delete an authentication provider"),
    SSH_LOGIN                   ("SSH LOGIN",                "ssh login"),
    AUTHENTICATION             ("AUTHENTICATION",           "authentication"),
    UPDATE_VERSION             ("UPDATE VERSION",           "upgrade"),
    WAKEUP_UPGRAGE_MANAGER     ("WAKEUP UPGRADE MANAGER",   "wakeup upgrade manager"),
    UPDATE_SYSTEM_PROPERTY     ("UPDATE SYSTEM PROPERTY",  "update system property"),
    SEND_ALERT                 ("SEND ALERT",               "send an alert"),
    SEND_REGISTRATION          ("SEND ALERT",               "send a registration"),
    SEND_HEARTBEAT             ("SEND HEARTBEAT",           "send heartbeat signal"),
    SEND_STAT                  ("SEND STAT",                "send a state"),
    SEND_LICENSE_EXPIRATION    ("SEND LICENCE EXPIRATION",  "inform license expiration"),
    CREATE_ESRS_CONFIGURATION       ("CREATE ESRS CONFIGURATION",       "create esrs configuration"),
    SCHEDULE_EVENT                  ("SCHEDULE EVENT",                  "schedule event"),
    CHANGE_LOCAL_AUTHUSER_PASSWORD  ("CHANGE LOCAL AUTHUSER PASSWORD",  "change local authuser password"),
    RESET_LOCAL_USER_PASSWORD       ("RESET LOCAL AUTHUSER PASSWORD",   "reset local authuser password"),
    CHANGE_LOCAL_AUTHUSER_AUTHKEY   ("CHANGE LOCAL AUTHUSER AUTHKEY",   "change local authuser authkey"),
    FRACTURE_VOLUME_MIRROR          ("FRACTURE VOLUME MIRROR",          "fracture a volume mirror"),
    RESUME_VOLUME_MIRROR            ("RESUME VOLUME MIRROR",            "resume a volume mirror"),
    DEACTIVATE_VOLUME_MIRROR        ("DEACTIVATE VOLUME MIRROR",        "deactivate a volume mirror"),
    DISCOVER_HOST                   ("DISCOVER HOST",                   "discover a compute host"),
	CREATE_HOST                     ("CREATE HOST",                     "create a compute host"),
    DELETE_CLUSTER                  ("DELETE CLUSTER",                  "delete a compute cluster"),
    DELETE_HOST                     ("DELETE HOST",                     "delete a compute host"),
    DELETE_HOST_IPINTERFACE         ("DELETE HOST IP INTERFACE",        "delete a compute host's IP interface"),
    DISCOVER_VCENTER                ("DISCOVER VCENTER",                "discover a vcenter"),
    DELETE_VCENTER                  ("DELETE VCENTER",                  "delete a vcenter"),
    DELETE_VCENTER_DATACENTER_STORAGE ("DELETE VCENTER DATACENTER STORAGE", "delete vcenter and detach datacenter storage"),
    DETACH_VCENTER_DATACENTER_STORAGE ("DETACH VCENTER DATACENTER STORAGE", "detach datacenter storage"),
    DETACH_HOST_STORAGE             ("DETACH HOST STORAGE",             "detach host storage"),
    CHANGE_BLOCK_VOLUME_VPOOL       ("CHANGE VOLUME VPOOL",             "change volume vpool operation"),
    CHANGE_BLOCK_VOLUME_VARRAY      ("CHANGE VOLUME VARRAY",            "change volume varray operation"),
    CREATE_CONSISTENCY_GROUP        ("CREATE CONSISTENCY GROUP",        "create a consistency group"),
    DELETE_CONSISTENCY_GROUP        ("DELETE CONSISTENCY GROUP",        "delete a consistency group"),
    CREATE_VOLUME_MIRROR            ("CREATE VOLUME MIRROR",            "create a volume mirror"),
    ATTACH_BLOCK_MIRROR     ("ATTACH MIRROR",           "attach mirror operation"),
    DETACH_BLOCK_MIRROR     ("DETACH MIRROR",           "detach mirror operation"),
    DETACH_VPLEX_LOCAL_MIRROR     ("DETACH VPLEX LOCAL MIRROR",     "detach vplex local mirror operation"),
    DELETE_VPLEX_LOCAL_MIRROR     ("DELETE VPLEX LOCAL MIRROR",     "delete vplex local mirror operation"),
    ATTACH_VPLEX_LOCAL_MIRROR     ("ATTACH VPLEX LOCAL MIRROR",     "attach vplex local mirror operation"),
    PROMOTE_COPY_TO_VPLEX         ("PROMOTE CONTINUOUS COPY TO VPLEX",       "promote continuous copy to vplex local"),
    PROMOTE_COPY_TO_VOLUME         ("PROMOTE CONTINUOUS COPY TO VOLUME",       "promote continuous copy to volume"),
    SET_CG_VISIBILITY               ("SET CG VISIBILITY",               "set visibility of a consistency group with no volumes"),
    ADD_CG_VOLUME                   ("ADD CG VOLUME",                   "add volumes to CG"),
    DELETE_CG_VOLUME                ("DELETE CG VOLUME",                "delete volumes from CG"),
    CREATE_STORAGE_SYSTEM_CONNECTION    ("CREATE STORAGE SYSTEM CONNECTION", "establish storage system connection"),
    DELETE_STORAGE_SYSTEM_CONNECTION    ("DELETE STORAGE SYSTEM CONNECTION", "terminate storage system connection"),
    UPDATE_CONSISTENCY_GROUP        ("UPDATE CONSISTENCY GROUP",        "update a consistency group"),
    CREATE_CONSISTENCY_GROUP_SNAPSHOT      ("CREATE CONSISTENCY GROUP SNAPSHOT",      "create a consistency group snapshot"),
    DELETE_CONSISTENCY_GROUP_SNAPSHOT      ("DELETE CONSISTENCY GROUP SNAPSHOT",      "delete a consistency group snapshot"),
    DEACTIVATE_CONSISTENCY_GROUP_SNAPSHOT  ("DEACTIVATE CONSISTENCY GROUP SNAPSHOT",  "deactivate a consistency group snapshot"),
    ACTIVATE_CONSISTENCY_GROUP_SNAPSHOT    ("ACTIVATE CONSISTENCY GROUP SNAPSHOT",    "activate a consistency group snapshot"),
    RESTORE_CONSISTENCY_GROUP_SNAPSHOT     ("RESTORE CONSISTENCY GROUP SNAPSHOT",     "restore a consistency group snapshot"),
    CREATE_STORAGE_VIEW             ("CREATE STORAGE VIEW",                   "create a storage view"),
    DELETE_STORAGE_VIEW             ("DELETE STORAGE VIEW",                   "delete a storage view"),
    ADD_EXPORT_INITIATOR            ("ADD INITIATOR TO EXPORT GROUP",         "add initiator to export group"),
    DELETE_EXPORT_INITIATOR         ("DELETE INITIATOR FROM EXPORT GROUP",    "delete initiator from export group"),
    ADD_STORAGE_VIEW_INITIATOR      ("ADD INITIATOR TO STORAGE VIEW",         "add initiator to storage view"),
    DELETE_STORAGE_VIEW_INITIATOR   ("DELETE INITIATOR TO STORAGE VIEW",      "delete initiator from storage view"),
    REMOVE_STORAGE_VIEW_VOLUME   ("REMOVE VOLUME FROM STORAGE VIEW",      "remove volume(s) from storage view"),
    ADD_STORAGE_VIEW_STORAGEPORTS   ("ADD STORAGE PORTS TO STORAGE VIEW",     "add storage ports to storage view"),
    DELETE_STORAGE_VIEW_STORAGEPORTS   ("DELETE STORAGE PORTS FROM STORAGE VIEW",     "delete storage ports from storage view"),
    ROLLBACK_NOOP              ("ROLLBACK NOOP",            "no-op rollback operation"),
    PAUSE_NATIVE_CONTINUOUS_COPIES     ("PAUSE NATIVE CONTINUOUS COPIES", "pause Native Continuous Copies"),
    RESUME_NATIVE_CONTINUOUS_COPIES    ("RESUME NATIVE CONTINUOUS COPIES", "resume Native Continuous Copies"),
    CHECK_SYNC_PROGRESS    ("CHECK SYNC PROGRESS", "check progress between two block objects"),
    DISCOVER_COMPUTE_SYSTEM    ("DISCOVER COMPUTE SYSTEM",   "discover a compute system."),
    DELETE_COMPUTE_SYSTEM      ("DELETE COMPUTE SYSTEM",     "delete a compute system."),
    IMPORT_IMAGE               ("IMPORT IMAGE", "import an image."),
    UPDATE_IMAGE               ("UPDATE IMAGE", "update an image."),
    REMOVE_IMAGE               ("REMOVE IMAGE", "remove an image."),
    INSTALL_OPERATING_SYSTEM   ("INSTALL OPERATING SYSTEM",  "install an operating system."),
    ADD_VDC                ("ADD VDC",          "add a new VDC to ViPR"),
    UPDATE_VDC             ("UPDATE VDC",          "update a VDC info"),
    REMOVE_VDC             ("REMOVE VDC",       "remove a VDC from ViPR"),
    DISCONNECT_VDC         ("DISCONNECT VDC",   "temporarily disconnect a VDC from ViPR"),
    RECONNECT_VDC          ("RECONNECT VDC",    "reconnect a VDC to ViPR"),
    UPGRADE_VPLEX_LOCAL_TO_DISTRIBUTED         ("UPGRADE VPLEX LOCAL TO DISTRIBUTED",   "Upgrade a VPLEX local volume to distributed"),
    WAIT_ON_VPLEX_VOLUME_REBUILD    ("WAIT ON VPLEX VOLUME REBUILD",   "Wait on VPLEX volume rebuild"),
    ADD_ALIAS               ("ADD ALIAS",          "add one or more aliases"),
    REMOVE_ALIAS               ("REMOVE ALIAS",          "remove one or more aliases"),
    UPDATE_ALIAS              ("UPDATE ALIAS",          "update one or more aliases"),
    CREATE_BACKUP ("CREATE BACKUP", "create ViPR backup"),
    UPLOAD_BACKUP ("UPLOAD BACKUP", "upload ViPR backup to external location"),
    CREATE_VCENTER_CLUSTER   ("CREATE VCENTER CLUSTER",  "create a cluster in vCenter server"),
    UPDATE_VCENTER_CLUSTER   ("UPDATE VCENTER CLUSTER",  "update a cluster in vCenter server"),
    SYS_EVENT                ("SYSTEM EVENT", "System Event");



    private final String name;
    private final String description;

    ResourceOperationTypeEnum(String name, String description) {
        this.description = description;
        this.name = name;
    }

    /**
     * The name of the resource operation
     * @valid none
     */
    @XmlElement
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String toStr() {
        return name;
    }

    public static ResourceOperationTypeEnum fromString(String name) {
        return resourceOpMap.get(name);
    }

    private static final Map<String, ResourceOperationTypeEnum> resourceOpMap = new HashMap<String, ResourceOperationTypeEnum>();

    static {
        for (ResourceOperationTypeEnum res : values()) {
            resourceOpMap.put(res.name, res);
        }
    }
}
