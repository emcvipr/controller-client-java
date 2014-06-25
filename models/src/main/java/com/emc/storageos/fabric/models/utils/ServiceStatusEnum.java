package com.emc.storageos.fabric.models.utils;

import java.io.Serializable;

/**
 * Enum class for status of a service
 *
 */
public enum ServiceStatusEnum implements Serializable {
    INSTALLED,
    RUNNING,
    STOPPED,
    CRASHED;
}
