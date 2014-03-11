package com.emc.vipr.model.object.datastore;

import com.emc.storageos.model.StringHashMapEntry;
import com.emc.storageos.model.adapters.StringMapAdapter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * opaque key-value pairs used to update device
 */
@XmlRootElement(name = "device_update")
public class UpdateParameters {
    private Map<String, String> _params = new HashMap<String, String>();

    /**
     * opaque key/value pairs
     * for atmos this is ip address, tenant admin, credentials, etc
     */
    @XmlElementWrapper(name = "parameters")
    @XmlElement(name = "parameter")
    public List<StringHashMapEntry> getParams() {
        return (new StringMapAdapter()).marshal(_params);
    }
    public void setParams(ArrayList<StringHashMapEntry> params)   {
        _params = (new StringMapAdapter()).unmarshal(params);
    }
    public HashMap<String, String> getParameters() {
        return (HashMap<String,String>)_params;
    }
}
