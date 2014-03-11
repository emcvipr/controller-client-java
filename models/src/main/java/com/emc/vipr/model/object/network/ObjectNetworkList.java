package com.emc.vipr.model.object.network;

import com.emc.vipr.model.object.ObjectNamedRelatedResourceRep;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * List of object transport zones.
 */
@XmlRootElement(name = "object_networks")
public class ObjectNetworkList {
    private List<ObjectNamedRelatedResourceRep> networks;

    @XmlElement(name = "object_network")
    public List<ObjectNamedRelatedResourceRep> getNetworks() {
        if (networks == null) {
            networks = new ArrayList<ObjectNamedRelatedResourceRep>();
        }
        return networks;
    }

    public void setNetworks(List<ObjectNamedRelatedResourceRep> networkList) {
	if (networks == null) {
            networks = new ArrayList<ObjectNamedRelatedResourceRep>();
        }

        this.networks = networkList;
    }

    public void addObjectNetwork(ObjectNamedRelatedResourceRep network) {

	if (networks == null) {
            networks = new ArrayList<ObjectNamedRelatedResourceRep>();
        }

        networks.add(network);
    }
}
