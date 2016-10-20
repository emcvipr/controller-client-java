/*
 * Copyright 2008-2013 EMC Corporation
 * Copyright 2016 Intel Corporation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.emc.storageos.model;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlElement;

public enum ResourceTypeEnum {
    /* type service */
    FILE("fileshare", "/file/filesystems"),
    VOLUME("volume", "/block/volumes"),
    BUCKET("bucket", "/object/buckets"),
    PROJECT("project", "/projects"),
    TENANT("tenant", "/tenants"),
    VPOOL("vpool", "/"),
    BLOCK_VPOOL("block_vpool", "/block/vpools"),
    FILE_VPOOL("file_vpool", "/file/vpools"),
    OBJECT_VPOOL("object_vpool", "/object/vpools"),
    COMPUTE_VPOOL("compute_vpool", "/compute/vpools"),
    VARRAY("varray", "/vdc/varrays"),
    STORAGE_SYSTEM("storage_system", "/vdc/storage-systems"),
    STORAGE_POOL("storage_pool", "/vdc/storage-systems/%1$s/storage-pools"),
    STORAGE_TIER("storage_tier", "/vdc/storage-tiers"),
    STORAGE_PORT("storage_port", "/vdc/storage-systems/%1$s/storage-ports"),
    RDF_GROUP("rdf_group", "/vdc/storage-systems/%1$s/rdf-groups"),
    PROTECTION_SYSTEM("protection_system", "/vdc/protection-systems"),
    PROTECTION_SET("protection_set", "/block/volumes/%1$s/protection/protection-sets"),
    FILE_SNAPSHOT("snapshot", "/file/snapshots"),
    BLOCK_SNAPSHOT("block_snapshot", "/block/snapshots"),
    BLOCK_MIRROR("block_mirror", "/block/volumes/%1$s/protection/continuous-copies"),
    VPLEX_MIRROR("block_mirror", "/block/volumes/%1$s/protection/continuous-copies"),
    BLOCK_CONSISTENCY_GROUP("block_consistency_group", "/block/consistency-groups"),
    NETWORK("network", "/vdc/networks"),
    EXPORT_GROUP("block_export", "/block/exports"),
    SMIS_PROVIDER("smis_provider", "/vdc/smis-providers"),
    STORAGE_PROVIDER("storage_provider", "/vdc/storage-providers"),
    NETWORK_SYSTEM("network_system", "/vdc/network-systems"),
    FC_PORT_CONNECTION("fc_port_connection", "/vdc/fc-port-connections"),
    AUTHN_PROVIDER("authnprovider", "/vdc/admin/authnproviders"),
    OPENSTACK_TENANT("openstack_tenant", "/v2/keystone/tenants"),
    WORKFLOW("workflow", "/vdc/workflows"),
    WORKFLOW_STEP("workflow_step", "/vdc/workflows/steps"),
    HOST("host", "/compute/hosts"),
    VCENTER("vcenter", "/compute/vcenters"),
    CLUSTER("cluster", "/compute/clusters"),
    INITIATOR("initiator", "/compute/initiators"),
    IPINTERFACE("ipinterface", "/compute/ip-interfaces"),
    COMPUTE_SYSTEM("compute_system", "/vdc/compute-systems"),
    COMPUTE_ELEMENT("compute_element", "/vdc/compute-elements"),
    COMPUTE_IMAGE("compute_image", "/compute/images"),
    VCENTERDATACENTER("vcenter_data_center", "/compute/vcenter-data-centers"),
    AUTO_TIERING_POLICY("auto_tiering_policy", "/vdc/auto-tier-policies"),
    MIGRATION("migration", "/block/migrations"),
    UNMANAGED_VOLUMES("unmanaged_volumes", "/vdc/unmanaged/volumes"),
    UNMANAGED_CGS("unmanaged_cgs", "/vdc/unmanaged/cgs"),
    UNMANAGED_FILESYSTEMS("unmanaged_filesystems", "/vdc/unmanaged/filesystems"),
    UNMANAGED_EXPORT_MASKS("unmanaged_export_masks", "/vdc/unmanaged/export-masks"),
    DATA_STORE("data_store", "/vdc/object-pools"),
    ZONE("zone", "/zone"),
    VDC("virtual_data_center", "/vdc"),
    CATALOG_CATEGORY("catalog_category", "/catalog/categories"),
    CATALOG_SERVICE("catalog_service", "/catalog/services"),
    CATALOG_SERVICE_FIELD("catalog_service_field", ""),
    CATALOG_IMAGE("catalog_image", "/catalog/images"),
    APPROVAL("approval", "/catalog/approvals"),
    EXECUTION_WINDOW("execution_window", "/catalog/execution-windows"),
    ORDER("order", "/catalog/orders"),
    SCHEDULED_EVENT("scheduled_event", "/catalog/events"),
    TASK("task", "/vdc/tasks"),
    QUOTA_DIR("quota_dir", "/file/quotadirectories"),
    CUSTOM_CONFIG("controller_config", "/config/controller"),
    CONFIG_TYPE("config_type", "/config/controller/types"),
    SYS_EVENT("sysevent", ""),
    USER_GROUP("user_group", "/vdc/admin/user-groups"),
    SITE("site", "/site"),
    EVENT("event", "/vdc/events"),
    VIRTUAL_NAS("vnas-servers", "/vdc/vnas-servers"),
    VOLUME_GROUP("volume_group", "/volume-groups/block"),
    COMPUTE_IMAGESERVER("compute_imageserver", "/compute/imageservers"),
    BLOCK_SNAPSHOT_SESSION("block_snapshot_session", "/block/snapshot-sessions"),
    SCHEDULE_POLICY("schedule_policy", "/schedule-policies"),
    STORAGE_SYSTEM_TYPE("storage_system_type", "/vdc/storage-system-types"),
    OBJECT_NAMESPACE("object_namespaces", "/vdc/object-namespaces"),
    ACTIONABLE_EVENT("actionable_event", "/vdc/events");

    private final String type;
    private final String service;

    ResourceTypeEnum(String type, String service) {
        this.service = service;
        this.type = type;
    }

    /**
     * The type of the resource
     * 
     */
    @XmlElement
    public String getType() {
        return type;
    }

    public String getService() {
        return service;
    }

    @Override
    public String toString() {
        return type;
    }

    public static ResourceTypeEnum fromString(String resourceType) {
        return resourceMap.get(resourceType);
    }

    private static final Map<String, ResourceTypeEnum> resourceMap = new HashMap<String, ResourceTypeEnum>();

    static {
        for (ResourceTypeEnum res : values()) {
            resourceMap.put(res.type, res);
        }
    }
}
