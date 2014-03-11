package com.emc.vipr.client.exceptions;

import com.emc.storageos.model.errorhandling.ServiceErrorRestRep;
import java.util.ArrayList;
import java.util.List;

public class ServiceErrorsException extends ViPRException {
    private List<ServiceErrorRestRep> serviceErrors;

    public ServiceErrorsException() {
        this(new ArrayList<ServiceErrorRestRep>());
    }

    public ServiceErrorsException(List<ServiceErrorRestRep> serviceErrors) {
        this.serviceErrors = serviceErrors;
    }

    @Override
    public String getLocalizedMessage() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s Error occurred\n", serviceErrors.size()));
        for (ServiceErrorRestRep error: serviceErrors) {
            sb.append(String.format("Error %s: %s. %s\n",
                error.getCode(), error.getCodeDescription(), error.getDetailedMessage()));
        }
        return sb.toString();
    }

    @Override
    public String getMessage() {
        return getLocalizedMessage();
    }

    public List<ServiceErrorRestRep> getServiceErrors() {
        return serviceErrors;
    }
}
