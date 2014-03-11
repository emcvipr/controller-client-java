package com.emc.vipr.client.catalog;

import com.emc.storageos.model.BulkIdParam;
import com.emc.storageos.model.host.HostBulkRep;
import com.emc.vipr.model.catalog.ExecutionInfo;
import com.emc.vipr.model.catalog.OrderInfo;
import com.emc.vipr.model.catalog.Reference;
import com.emc.vipr.client.ViPRCatalogClient;
import com.emc.vipr.client.impl.RestClient;
import com.emc.vipr.client.catalog.impl.PathConstants;
import com.sun.jersey.api.client.GenericType;

import java.util.List;

import static com.emc.vipr.client.catalog.impl.ApiListUtils.getApiList;
import static com.emc.vipr.client.catalog.impl.ApiListUtils.postApiList;
import static com.emc.vipr.client.catalog.impl.PathConstants.*;
import static com.emc.vipr.client.core.util.ResourceUtils.defaultList;

public class Orders extends AbstractBulkResources<OrderInfo> {
    public Orders(ViPRCatalogClient parent, RestClient client) {
        super(parent, client, OrderInfo.class, PathConstants.ORDER_URL);
    }

    /**
     * Lists all orders for the current user.
     * <p>
     * API Call: GET /api/orders
     *
     * @return Order references
     */
    public List<Reference> list() {
        return doList();
    }

    /**
     * Retrieves all orders for the current user.
     * <p>
     * API Call: GET /api/orders
     *
     * @return All orders for the current user.
     */
    public List<OrderInfo> getAll() {
        return doGetAll();
    }

    /**
     * Retrieves the execution info for the specified order.
     * <p>
     * API Call: GET /api/orders/{id}/execution
     *
     * @param id Identifier of the order to retrieve execution information for.
     * @return Execution information.
     */
    public ExecutionInfo getExecutionInfo(String id) {
        return client.get(ExecutionInfo.class, String.format(EXECUTION_URL_FORMAT, baseUrl), id);
    }

    @Override
    protected List<OrderInfo> getBulkResources(BulkIdParam input) {
        List<OrderInfo> orders = postApiList(client, input, new GenericType<List<OrderInfo>>() {}, getBulkUrl());
        return orders;
    }
}
