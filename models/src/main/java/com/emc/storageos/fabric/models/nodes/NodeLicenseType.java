package com.emc.storageos.fabric.models.nodes;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.emc.storageos.fabric.models.utils.LicenseTypeEnum;
/**
 * REST API model class for the license type of a node
 *
 */
@XmlRootElement(name = "node_license_type")
public class NodeLicenseType  implements Serializable {
    /**
     * License type for the node
     */
    private LicenseTypeEnum type;
    
    @XmlElement(name = "license_type")
    public LicenseTypeEnum getType() {
        return type;
    }

    public void setType(LicenseTypeEnum type) {
        this.type = type;
    }
}
