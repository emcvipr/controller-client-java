package com.emc.storageos.fabric.models.utils;

import java.io.Serializable;

/**
 * Enum class for mode of an element
 *
 */
public enum ModeEnum implements Serializable {
    OPERATIONAL("OPERATIONAL"), 
    MAINTENANCE("MAINTENANCE");
    
    private final String _mode;

    ModeEnum(String mode) {
        _mode = mode;
    }

    @Override
    public String toString() {
        return _mode;
    }
}
