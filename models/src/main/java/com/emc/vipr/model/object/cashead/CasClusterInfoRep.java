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

import javax.xml.bind.annotation.XmlRootElement;

/**
 * CAS cluster is an object that brings additional CAS-specific configuration on namespace
 * See CasCluster
 */
@XmlRootElement(name = "cas_cluster")
public class CasClusterInfoRep extends CasClusterCreateParam {

}
