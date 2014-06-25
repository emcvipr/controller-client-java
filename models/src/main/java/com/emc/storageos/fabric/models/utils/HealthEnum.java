package com.emc.storageos.fabric.models.utils;

import java.io.Serializable;

/**
 * Enum for Health of an element
 *
 */
public enum HealthEnum implements Serializable {
    GOOD("GOOD"), 
    BAD("BAD"), 
    SUSPECT("SUSPECT"),
    DEGRADED("DEGRADED"),
    STAGING("STAGING");
    
    private final String _health;

    HealthEnum(String health) {
        _health = health;
    }

    @Override
    public String toString() {
        return _health;
    }
}
