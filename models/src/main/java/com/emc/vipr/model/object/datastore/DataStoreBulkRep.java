package com.emc.vipr.model.object.datastore;

import com.emc.storageos.model.BulkRestRep;
import org.codehaus.jackson.annotate.JsonProperty;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "bulk_data_stores")
public class DataStoreBulkRep extends BulkRestRep {
    private List<DataStoreRestRep> pools;

    @SuppressWarnings("unchecked")
    @XmlElement(name = "data_store")
    public List<DataStoreRestRep> getDataStores() {
        if (pools == null) {
            pools = new ArrayList<DataStoreRestRep>();
        }
        return pools;
    }

    public void setPools(List<DataStoreRestRep> pools) {
        this.pools = pools;
    }

    public DataStoreBulkRep() {
    }

    public DataStoreBulkRep(List<DataStoreRestRep> list) {
        setPools(list);
    }
}
