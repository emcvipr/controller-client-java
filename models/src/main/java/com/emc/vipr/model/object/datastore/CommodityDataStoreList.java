package com.emc.vipr.model.object.datastore;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * A list of provisioned commodity data stores
 */
@XmlRootElement(name = "commodity_data_stores")
public class CommodityDataStoreList {
    private List<CommodityDataStoreRestRep> pools = new ArrayList<CommodityDataStoreRestRep>();

    public void addCommodityDataStore(CommodityDataStoreRestRep commoditydatastore) {
        getPools().add(commoditydatastore);
    }

    /**
     * A list of provisioned data stores
     * @valid None
     */
    @XmlElement(name="commodity_data_store")
    public List<CommodityDataStoreRestRep> getPools() {
        return pools;
    }

    public void setPools(List<CommodityDataStoreRestRep> pools) {
        this.pools = pools;
    }
}