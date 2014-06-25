package com.emc.vipr.client.catalog.impl;

public class PathConstants {
    public static final String ID_URL_FORMAT = "%s/{id}";

    public static final String ORDER_URL = "/api/orders";
    public static final String EXECUTION_URL_FORMAT = "%s/{id}/execution";

    public static final String APPROVALS_URL = "/api/approvals";
    public static final String APPROVALS_PENDING_URL = APPROVALS_URL + "/pending";
    public static final String APPROVE_URL = APPROVALS_URL + "{id}/approve";
    public static final String REJECT_URL = APPROVALS_URL + "{id}/reject";

    public static final String EXECUTION_WINDOWS_URL = "/admin/api/executionwindows";

    public static final String ASSET_OPTIONS_URL = "/api/options/{asset}";
    public static final String ASSET_DEPS_URL = "/api/options/{asset}/dependencies";
    public static final String CATEGORY_URL = "/api/categories/{id}";
    public static final String SERVICE_URL = "/api/services/{id}";
    public static final String SERVICE_DESCRIPTOR_URL = SERVICE_URL + "/descriptor";
    public static final String CATALOG_URL = "/api/catalog";
}
