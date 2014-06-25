package com.emc.storageos.fabric.models.services;

import java.io.Serializable;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
/**
 * REST API model for list of services in the Fabric
 *
 */
@XmlRootElement(name = "services")
public class FabricServiceList implements Serializable {
    private List<FabricService> services;
    
    public FabricServiceList() {
        if (services == null) {
            services = new ArrayList<FabricService>();
        }
    }
    
    public FabricServiceList(List<FabricService> services) {
        this.services = services;
    }

    /**
     * List of services with service information
     * @valid none
     */
    @XmlElement(name = "service")
    public List<FabricService> getServiceList() {
        if (services == null) {
            services = new ArrayList<FabricService>();
        }
        return services;
    }

    public void setServiceList(List<FabricService> services) {
        this.services = services;
    }
    
    /**
     * Utility method to add services to the list individually
     * @param node
     */
    public void add(FabricService service){
        if (services == null) {
            services = new ArrayList<FabricService>();
        }
        services.add(service);
    }
}
