package com.emc.vipr.model.object.network;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.net.URI;

/**
 * Object transport zone creation parameters.
 */
@XmlRootElement(name = "object_network_create")
public class ObjectNetworkCreateParam {
    private URI network;
    private String name;

    public ObjectNetworkCreateParam() { }
    public ObjectNetworkCreateParam(String name, URI network) {
        this.name = name;
        this.network = network;
    }

    @XmlElement(required = true, name = "network")
    public URI getNetwork() {
        return network;
    }

    public void setNetwork(URI network) {
        this.network = network;
    }

    @XmlElement(required = true, name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
