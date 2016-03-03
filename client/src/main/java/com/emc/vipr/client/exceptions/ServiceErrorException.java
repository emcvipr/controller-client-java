/*
 * Copyright (c) 2015 EMC Corporation
 * All Rights Reserved
 */
package com.emc.vipr.client.exceptions;

import com.emc.storageos.model.errorhandling.ServiceErrorRestRep;

public class ServiceErrorException extends ViPRHttpException {
    private final ServiceErrorRestRep serviceError;

    public ServiceErrorException(int httpStatus, ServiceErrorRestRep serviceError) {
        super(httpStatus);
        if (serviceError == null) {
            this.serviceError = new ServiceErrorRestRep();
        }
        else {
            this.serviceError = serviceError;
        }
    }

    public ServiceErrorException(ServiceErrorRestRep serviceError) {
        this(-1, serviceError);
    }

    @Override
    public String getLocalizedMessage() {
        String message = getDetailedMessage() == null || getDetailedMessage().isEmpty() ?
                getCodeDescription() : getDetailedMessage();
        return String.format("Error %s: %s", getCode(), message);
    }

    @Override
    public String getMessage() {
        return getLocalizedMessage();
    }

    public ServiceErrorRestRep getServiceError() {
        return serviceError;
    }

    public boolean isRetryable() {
        return getServiceError().isRetryable();
    }

    public int getCode() {
        return getServiceError().getCode();
    }

    public String getCodeDescription() {
        return getServiceError().getCodeDescription();
    }

    public String getDetailedMessage() {
        return getServiceError().getDetailedMessage();
    }
}
