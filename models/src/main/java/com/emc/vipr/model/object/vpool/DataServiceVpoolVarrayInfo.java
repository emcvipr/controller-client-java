package com.emc.vipr.model.object.vpool;


import com.emc.storageos.model.StringHashMapEntry;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
import java.util.Map;

@XmlRootElement(name = "data_service_vpool_varrays")
public class DataServiceVpoolVarrayInfo {
    private List<StringHashMapEntry> mappings;

    public DataServiceVpoolVarrayInfo() {}

    public DataServiceVpoolVarrayInfo(List<StringHashMapEntry> mappings) {
        this.mappings = mappings;
    }

    @XmlElement(required = true)
    public List<StringHashMapEntry> getMappings() {
        return mappings;
    }

    public void setMappings( List<StringHashMapEntry> mappings) {
        this.mappings = mappings;
    }
}
