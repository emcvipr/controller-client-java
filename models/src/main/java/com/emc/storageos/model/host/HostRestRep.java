/**
 *  Copyright (c) 2013 EMC Corporation
 * All Rights Reserved
 *
 * This software contains the intellectual property of EMC Corporation
 * or is licensed to EMC Corporation from third parties.  Use of this
 * software and the intellectual property contained therein is expressly
 * limited to the terms and conditions of the License Agreement under which
 * it is provided by or on behalf of EMC.
 */
package com.emc.storageos.model.host;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.emc.storageos.model.RelatedResourceRep;

/**
 * REST Response representing an Host.
 */
@XmlRootElement(name = "host")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class HostRestRep extends ComputeSystemRestRep {

    private String hostName;
    private String type;
    private String username;
    private Integer portNumber;
    private RelatedResourceRep cluster;
    private RelatedResourceRep project;
    private String osVersion;
    private Boolean useSsl;
    private RelatedResourceRep vCenterDataCenter;
    private Boolean discoverable;

    public HostRestRep() {}
    
    /**
     * The cluster when the host is in a cluster.
     * @valid none
     */
    @XmlElement(name="cluster")
    public RelatedResourceRep getCluster() {
        return cluster;
    }

    public void setCluster(RelatedResourceRep cluster) {
        this.cluster = cluster;
    }

    /**
     * The host name.
     * @valid none
     */
    @XmlElement(name="host_name")
    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    /**
     * The operating system version of the host.
     * @valid none
     */
    @XmlElement(name="os_version")
    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    /**
     * The host management port number.
     * @valid none
     */
    @XmlElement(name="port_number")
    public Integer getPortNumber() {
        return portNumber;
    }

    public void setPortNumber(Integer portNumber) {
        this.portNumber = portNumber;
    }

    /**
     * The project to which the host is assigned.
     * @valid none
     */
    @XmlElement(name="project")
    public RelatedResourceRep getProject() {
        return project;
    }

    public void setProject(RelatedResourceRep project) {
        this.project = project;
    }

    /**
     * The host type.
     * @valid none
     */
    @XmlElement(name="type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    /**
     * The login account name.
     * @valid none
     */
    @XmlElement(name="user_name")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * The boolean flag that indicates if SSL should be used when communicating with the host.
     * @valid true = use SSL
     * @valid false = do not use SSL
     */
    @XmlElement(name="use_ssl")
    public Boolean getUseSsl() {
        return useSsl;
    }

    public void setUseSsl(Boolean useSsl) {
        this.useSsl = useSsl;
    }

    /**
     * The name of the data center in vCenter where this host resides.
     * @valid none
     */
    @XmlElement(name="vcenter_data_center")
    public RelatedResourceRep getvCenterDataCenter() {
        return vCenterDataCenter;
    }

    public void setvCenterDataCenter(RelatedResourceRep vCenterDataCenter) {
        this.vCenterDataCenter = vCenterDataCenter;
    }

    /**
     * Gets the discoverable flag. Discoverable indicates if automatic discovery should be
     * performed against this host.
     *
     * @return true if automatic discovery is enabled, false if automatic discovery is disabled.
     * @valid true = discovery is enabled
     * @valid false = discovery is disabled
     */
    @XmlElement(name="discoverable")
    public Boolean getDiscoverable() {
        return discoverable;
    }

    public void setDiscoverable(Boolean discoverable) {
        this.discoverable = discoverable;
    }
}

