/*
 * Copyright 2015 EMC Corporation
 * All Rights Reserved
 */
/**
 *  Copyright (c) 2008-2013 EMC Corporation
 * All Rights Reserved
 *
 * This software contains the intellectual property of EMC Corporation
 * or is licensed to EMC Corporation from third parties.  Use of this
 * software and the intellectual property contained therein is expressly
 * limited to the terms and conditions of the License Agreement under which
 * it is provided by or on behalf of EMC.
 */
package com.emc.storageos.model.vpool;

import org.codehaus.jackson.annotate.JsonProperty;
import javax.xml.bind.annotation.XmlElement;

import java.util.HashSet;
import java.util.Set;

/**
 * Class captures a list of Protocols to update in VirtualPool.
 */
public class ProtocolAssignments {

    private Set<String> protocols;

    /**
     * Default Constructor.
     */
    public ProtocolAssignments() {}

    public ProtocolAssignments(Set<String> protocols) {
        this.protocols = protocols;
    }

    /**
     * The set of protocols.
     * 
     * @valid FC = Fibre Channel (block)
     * @valid ISCSI =  Internet Small Computer System Interface (block)
     * @valid FCoE = Fibre Channel over Ethernet (block)
     * @valid NFS = Network File System (file)
     * @valid NFSv4 = Network File System Version 4 (file)
     * @valid CIFS = Common Internet File System (file)
     */
    @XmlElement(name = "protocol")
    @JsonProperty("protocol")
    public Set<String> getProtocols() {
        if (protocols == null) {
            protocols = new HashSet<String>();
        }
        return protocols;
    }

    public void setProtocols(Set<String> protocols) {
        this.protocols = protocols;
    }
    
}
