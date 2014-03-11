package com.emc.vipr.model.object.datastore;

import org.codehaus.jackson.annotate.JsonProperty;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * A list of provisioned data stores
 */
@XmlRootElement(name = "data_stores")
public class DataStoreList {
    private List<DataStoreNamedRelatedResourceRep> pools = new ArrayList<DataStoreNamedRelatedResourceRep>();

    public void addHostingDevice(DataStoreNamedRelatedResourceRep hostingDevice) {
        getPools().add(hostingDevice);
    }

    /**
     * A list of provisioned data stores
     * @valid None
     */
    @XmlElement(name="data_store")
    public List<DataStoreNamedRelatedResourceRep> getPools() {
        return pools;
    }

    public void setPools(List<DataStoreNamedRelatedResourceRep> pools) {
        this.pools = pools;
    }
}
