/**
 *  Copyright (c) 2008-2011 EMC Corporation
 * All Rights Reserved
 *
 * This software contains the intellectual property of EMC Corporation
 * or is licensed to EMC Corporation from third parties.  Use of this
 * software and the intellectual property contained therein is expressly
 * limited to the terms and conditions of the License Agreement under which
 * it is provided by or on behalf of EMC.
 */

package com.emc.storageos.model.protection;

import javax.xml.bind.annotation.*;

import com.emc.storageos.model.DiscoveredSystemObjectRestRep;


@XmlRootElement(name = "protection_system")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class ProtectionSystemRestRep extends DiscoveredSystemObjectRestRep {
    private String installationId;
    private String majorVersion;
    private String minorVersion;
    private String ipAddress;
    private String secondaryIP;
    private Integer portNumber;
    private Boolean reachableStatus;
    private String username;

    public ProtectionSystemRestRep() {}
    
    /**
     * The Installation ID of this Protection System
     * @valid example: 6b93babb3bc882b3a1695247e2d9b78f13ebddc0
     */
    @XmlElement(name = "installation_id")
    public String getInstallationId() {
        return installationId;
    }

    public void setInstallationId(String installationId) {
        this.installationId = installationId;
    }

    /**
     * IP Address of the Protection System device
     * @valid IPv4 only
     * @valid example: 10.27.100.99
     */
    @XmlElement(name = "ip_address")
    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    /**
     * The Major Version of the Protection System device
     * @valid example: 3.5.SP2(n123)
     */
    @XmlElement(name = "major_version")
    public String getMajorVersion() {
        return majorVersion;
    }

    public void setMajorVersion(String majorVersion) {
        this.majorVersion = majorVersion;
    }

    /**
     * The Minor Version of the Protection System device
     * @valid example: none - The full version is normally displayed only in the Major Version field
     */
    @XmlElement(name = "minor_version")
    public String getMinorVersion() {
        return minorVersion;
    }

    public void setMinorVersion(String minorVersion) {
        this.minorVersion = minorVersion;
    }

    /**
     * Management Port Number of the Protection System device
     * @valid Numerical value 1 through 65535 
     * @valid example: 7225
     */
    @XmlElement(name = "port_number")
    public Integer getPortNumber() {
        return portNumber;
    }

    public void setPortNumber(Integer portNumber) {
        this.portNumber = portNumber;
    }

    /**
     * Reachable Status which indicates that the Portection System is reachable 
     * by ViPR doing a ping. (establish connection)
     * @valid true
     * @valid false
     */
    @XmlElement(name = "reachable")
    public Boolean getReachableStatus() {
        return reachableStatus;
    }

    public void setReachableStatus(Boolean reachableStatus) {
        this.reachableStatus = reachableStatus;
    }

    /**
     * Secondary IP Address of the mirrored Protection System device
     * @valid IPv4 only  
     * @valid example: 10.27.100.98
     */
    @XmlElement(name = "secondary_ip")
    public String getSecondaryIP() {
        return secondaryIP;
    }

    public void setSecondaryIP(String secondaryIP) {
        this.secondaryIP = secondaryIP;
    }

    @XmlElement(name = "user_name")
    public String getUsername() {
        return username;
    }

    /**
     * The user name to connect to the Protection System device management port
     * @valid example: user1
     */
    public void setUsername(String username) {
        this.username = username;
    }
}
