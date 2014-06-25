package com.emc.storageos.fabric.models.utils;

import java.io.Serializable;
/**
 * Enum for License Type
 *
 */
public enum LicenseTypeEnum implements Serializable  {
    Commodity("Commodity"), 
    ECS("ECS");
        
    private final String _type;

    LicenseTypeEnum(String type) {
        _type = type;
    }

    @Override
    public String toString() {
        return _type;
    }
}
