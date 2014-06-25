package com.emc.storageos.fabric.models.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
/**
 * Generic model class for creating a list of service names
 *
 */
public class ServiceNameList implements Serializable {
    private List<ServiceName> services;
    
    public ServiceNameList() {}
    
    public ServiceNameList(List<ServiceName> services) {
        this.services = services;
    }

    /**
     * List of services
     * @valid none
     */
    @XmlElement(name = "service")
    public List<ServiceName> getServiceList() {
        if (services == null) {
            services = new ArrayList<ServiceName>();
        }
        return services;
    }

    public void setServiceList(List<ServiceName> services) {
        this.services = services;
    }
}
