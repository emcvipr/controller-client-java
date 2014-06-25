package com.emc.vipr.model.object.datastore;



import javax.xml.bind.annotation.XmlElement;
import java.net.URI;

public class CommodityParam extends DataStoreParam {

    private String _nodeId;

    /**
     * Default constructor
     */
    
    public CommodityParam()
    {
    	
    }

    public CommodityParam(String nodeId) {
        this._nodeId = nodeId;
    }

    /**
     * IP Address for the commodity node.
     *
     * @valid none
     */
    @XmlElement(name = "nodeId")
    public String getNodeId() {
       return  _nodeId;
    }

    public void setNodeId(String ipAddress) {
        this._nodeId = ipAddress;
    }
}
