/*
 * Copyright (c) 2013 EMC Corporation
 * All Rights Reserved
 */
package com.emc.vipr.model.sys.healthmonitor;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Represents storage usage stats.
 */
@XmlRootElement(name = "storage_stats")
public class StorageStats {

    public StorageStats() {
    }

    public StorageStats(ControllerStorageStats controllerStorageStats) {
        this.controllerStorageStats = controllerStorageStats;
    }

    private ControllerStorageStats controllerStorageStats;

    public static class ControllerStorageStats {
        private double fileCapacityKB;
        private double blockCapacityKB;
        private double freeManagedCapacityKB;
        private double objectCapacityKB;

        public ControllerStorageStats() {
        }

        public ControllerStorageStats(double blockCapacityKB, double fileCapacityKB, double objectCapacityKB,
                double freeManagedCapacityKB) {
            this.blockCapacityKB = blockCapacityKB;
            this.fileCapacityKB = fileCapacityKB;
            this.objectCapacityKB = objectCapacityKB;
            this.freeManagedCapacityKB = freeManagedCapacityKB;
        }

        @XmlElement(name = "file_managed_capacity_kb")
        public double getFileCapacityKB() {
            return fileCapacityKB;
        }

        public void setFileCapacityKB(double fileCapacityKB) {
            this.fileCapacityKB = fileCapacityKB;
        }

        @XmlElement(name = "block_managed_capacity_kb")
        public double getBlockCapacityKB() {
            return blockCapacityKB;
        }

        public void setBlockCapacityKB(double blockCapacityKB) {
            this.blockCapacityKB = blockCapacityKB;
        }
        
        @XmlElement(name = "object_managed_capacity_kb")
        public double getObjectCapacityKB() {
            return objectCapacityKB;
        }

        public void setObjectCapacityKB(double objectCapacityKB) {
            this.objectCapacityKB = objectCapacityKB;
        }

        @XmlElement(name = "free_managed_capacity_kb")
        public double getFreeManagedCapacityKB() {
            return freeManagedCapacityKB;
        }

        public void setFreeManagedCapacityKB(double freeManagedCapacityKB) {
            this.freeManagedCapacityKB = freeManagedCapacityKB;
        }
    }

    public static class DataServiceStorageStats {
        private double capacityKB;

        public DataServiceStorageStats() {
        }

        public DataServiceStorageStats(double capacityKB) {
            this.capacityKB = capacityKB;
        }

        @XmlElement(name = "capacity_kb")
        public double getCapacityKB() {
            return capacityKB;
        }

        public void setCapacityKB(double capacityKB) {
            this.capacityKB = capacityKB;
        }
    }

    @XmlElement(name = "controller")
    public ControllerStorageStats getControllerStorageStats() {
        return controllerStorageStats;
    }

    public void setControllerStorageStats(ControllerStorageStats controllerStorageStats) {
        this.controllerStorageStats = controllerStorageStats;
    }
}
