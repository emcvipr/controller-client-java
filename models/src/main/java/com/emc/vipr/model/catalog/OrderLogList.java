package com.emc.vipr.model.catalog;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.emc.storageos.model.NamedRelatedResourceRep;

@XmlRootElement(name = "order_logs")
public class OrderLogList {
    
    private List<OrderLogRestRep> orderLogs;
    
    public OrderLogList() {}
    
    public OrderLogList(List<OrderLogRestRep> orderLogs) {
        this.orderLogs = orderLogs;
    }

    /**
     * List of order logs
     * @valid none
     */
    @XmlElement(name = "order_log")
    public List<OrderLogRestRep> getOrderLogs() {
        if (orderLogs == null) {
            orderLogs = new ArrayList<>();
        }
        return orderLogs;
    }

    public void setOrderLogs(List<OrderLogRestRep> orderLogs) {
        this.orderLogs = orderLogs;
    }        
    
}
