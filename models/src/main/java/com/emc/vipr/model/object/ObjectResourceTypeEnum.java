package com.emc.vipr.model.object;

import org.codehaus.jackson.annotate.JsonProperty;
import javax.xml.bind.annotation.XmlElement;

public enum ObjectResourceTypeEnum {

    ATMOS_DEVICE      ("atmos_device",  "/object/atmos-importer"),
    FILE_DATA_STORE  ("file_data_store", "/vdc/data-stores/filesystems"),
    NFS_DATA_STORE   ("nfs_data_store", "/vdc/data-stores/nfsexportpoints"),
    COMMODITY_DATA_STORE  ("commodity_data_store", "/vdc/data-stores/commodity"),
    DATA_STORE       ("data_store",   "/vdc/data-stores"),
    OBJECT_STORE      ("vpool", "/object/data-services-vpools"),
    SECRET_KEY        ("secret-keys",   "/object/secret-keys"),
    USER_SECRET_KEY   ("secret-keys",   "/object/user-secret-keys"),
    BASE_URL          ("baseurl",   "/object/baseurl"),
    NAMESPACE         ("namespace",     "/object/namespaces/namespace"),
    OBJECT_TZ         ("object_transport_zone", "/object/networks"),
    CAS_CLUSTER       ("cas_cluster", "/dataservice/cas-cluster"),
    VDC               ("vdc", "/object/vdcs/vdc");

    private final String type;
    private final String service;

    ObjectResourceTypeEnum(String type, String service) {
        this.service = service;
        this.type = type;
    }

    /**
     * Resource Type
     * @valid None
     * @return Resource Type
     */
    @XmlElement(name = "_type")
    @JsonProperty("_type")
    public String getType() {
        return type;
    }

    @XmlElement(name = "_service")
    @JsonProperty("_service")
    public String getService() {
        return service;
    }

    @Override
    public String toString() {
        return type;
    }
}





