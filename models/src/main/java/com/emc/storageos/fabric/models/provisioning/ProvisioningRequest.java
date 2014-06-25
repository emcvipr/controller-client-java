package com.emc.storageos.fabric.models.provisioning;

import java.net.URI;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Defines a request to provision storage services across the cluster.
 */
@XmlRootElement(name = "provisioning_request")
public class ProvisioningRequest {

	private Set<URI> nodes;
    private URI serviceType;
    
    @XmlElement(required = true, name = "serviceType")	
    public URI getServiceType() {
		return serviceType;
	}

	public void setServiceType(URI serviceType) {
		this.serviceType = serviceType;
	}
	
    @XmlElementWrapper(name = "nodes")
    @XmlElement(name = "node")
    public Set<URI> getNodes() {
        if (nodes == null) {
        	nodes = new LinkedHashSet<URI>();
        }
        return nodes;
    }

    public void setNodes(Set<URI> nodes) {
        this.nodes = nodes;
    }
}
