package com.emc.storageos.fabric.models;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
/**
 * REST API model for capacity information
 *
 */
@XmlRootElement(name = "capacity")
public class Capacity implements Serializable {
    /**
     * Total capacity for the element.
     * Units are GB
     */
    private int total;
    
    @XmlElement(name = "total_capacity")
    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
