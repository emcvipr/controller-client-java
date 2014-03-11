package com.emc.vipr.model.object.atmos;

import com.emc.vipr.model.object.ObjectNamedRelatedResourceRep;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * List of provisioned atmos devices
 */
@XmlRootElement(name = "atmos_devices")
public class AtmosDeviceList {
    private List<ObjectNamedRelatedResourceRep> devices;

    public void addDevice(ObjectNamedRelatedResourceRep resource) {
        getDevices().add(resource);
    }

    /**
     * List of provisioned atmos devices
     * @valid None
     */
    @XmlElement(name="atmos_device")
    public List<ObjectNamedRelatedResourceRep> getDevices() {
        if (devices == null) {
            devices = new ArrayList<ObjectNamedRelatedResourceRep>();
        }
        return devices;
    }

    public void setDevices(List<ObjectNamedRelatedResourceRep> devices) {
        this.devices = devices;
    }
}
