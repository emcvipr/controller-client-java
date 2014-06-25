package com.emc.vipr.model.object.datastore;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "commodity_data_store_create")
public class CommodityDataStoreParam {

    private List<CommodityParam> commodityParams;

    public CommodityDataStoreParam()
    {
    	
    }
    
    public CommodityDataStoreParam(List<CommodityParam> params) {
        commodityParams = params;
    }

    /**
     * A list of commodity nodes.
     *
     * @valid none
     */
    @XmlElement(name = "nodes")
    public List<CommodityParam> getCommodityParams() {
        if (commodityParams == null) {
            commodityParams = new ArrayList<CommodityParam>();
        }
        return commodityParams;
    }

    public void setCommodityParams(List<CommodityParam> commodityParams) {
        this.commodityParams = commodityParams;
    }
}
