package com.emc.vipr.model.object.network;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.net.URI;

/**
 * Object transport zone update parameters.
 */
@XmlRootElement(name = "object_network_update")
public class ObjectNetworkUpdateParam {
    private URI network;

    public ObjectNetworkUpdateParam() { }
    public ObjectNetworkUpdateParam(URI network) {
        this.network = network;
    }

    @XmlElement(required = true, name = "network")
    public URI getNetwork() {
        return network;
    }

    public void setNetwork(URI network) {
        this.network = network;
    }
}
