/*
 * Copyright (c) 2014 EMC Corporation
 * All Rights Reserved
 *
 * This software contains the intellectual property of EMC Corporation
 * or is licensed to EMC Corporation from third parties.  Use of this
 * software and the intellectual property contained therein is expressly
 * limited to the terms and conditions of the License Agreement under which
 * it is provided by or on behalf of EMC.
 */
package com.emc.vipr.model.object.cashead;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * A response object for REST list operations
 * Contains list of CAS registered applications
 */
@XmlRootElement(name = "cas_registered_applications")
public class CasRegisteredApplicationListRep {

    private List<CasRegisteredApplication> casRegisteredApplications;

    public CasRegisteredApplicationListRep(){
        casRegisteredApplications = new ArrayList<>();
    }

    public CasRegisteredApplicationListRep(List<CasRegisteredApplication> casRegisteredApplications) {
        this.casRegisteredApplications = casRegisteredApplications;
    }

    @XmlElement(name = "cas_registered_application")
    public List<CasRegisteredApplication> getCasRegisteredApplications() {
        return casRegisteredApplications;
    }

    public void setCasRegisteredApplications(List<CasRegisteredApplication> casRegisteredApplications) {
        this.casRegisteredApplications = casRegisteredApplications;
    }
}
