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

package com.emc.storageos.model.smis;

import javax.xml.bind.annotation.*;

import com.emc.storageos.model.DataObjectRestRep;
import com.emc.storageos.model.RelatedResourceRep;

import java.util.ArrayList;
import java.util.List;


@XmlRootElement(name = "smis_provider")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class SMISProviderRestRep extends DataObjectRestRep {
    private String iPAddress;
    private Integer portNumber;
    private List<RelatedResourceRep> storageSystems;
    private String description;
    private String manufacturer;
    private String versionString;
    private String providerID;
    private String connectionStatus;
    private String userName;
    private Boolean useSSL;
    private String scanStatus;
    private String lastScanStatusMessage;
    private Long lastScanTime;
    private Long nextScanTime;
    private Long successScanTime;
    private String compatibilityStatus;
    private String registrationStatus;

    public SMISProviderRestRep() {}
    
    /** 
     * Status of the connection.
     * @valid CONNECTED
     * @valid NOTCONNECTED
     */
    @XmlElement(name = "connection_status")
    public String getConnectionStatus() {
        return connectionStatus;
    }

    public void setConnectionStatus(String connectionStatus) {
        this.connectionStatus = connectionStatus;
    }

    /** 
     * Information relevant to the SMIS provider software.
     * @valid none
     */
    @XmlElement(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * SMIS provider's IP address.
     * @valid none
     */
    @XmlElement(name = "ip_address")
    public String getIPAddress() {
        return iPAddress;
    }

    public void setIPAddress(String iPAddress) {
        this.iPAddress = iPAddress;
    }

    /**
     * Name of the manufacturer.
     * @valid none
     */
    @XmlElement(name = "manufacturer")
    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    /**
     * The port number used to connect with the SMIS
     * provider, typically 5988 or 5989.
     * @valid none
     */
    @XmlElement(name = "port_number")
    public Integer getPortNumber() {
        return portNumber;
    }

    public void setPortNumber(Integer portNumber) {
        this.portNumber = portNumber;
    }

    /**
     * A combination of the provider's IP address and the port
     * number, used as an ID.
     * @valid none
     */
    @XmlElement(name = "provider_id")
    public String getProviderID() {
        return providerID;
    }

    public void setProviderID(String providerID) {
        this.providerID = providerID;
    }

    @XmlElementWrapper(name = "storage_systems")
    /**
     * List of URIs representing the storage systems accessible 
     * through this provider.
     * @valid none
     */
    @XmlElement(name = "storage_system")
    public List<RelatedResourceRep> getStorageSystems() {
        if (storageSystems == null) {
            storageSystems = new ArrayList<RelatedResourceRep>();
        }
        return storageSystems;
    }

    public void setStorageSystems(List<RelatedResourceRep> storageSystems) {
        this.storageSystems = storageSystems;
    }

    /** 
     * Login credential at the provider.
     * @valid none
     */
    @XmlElement(name = "user_name")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Whether or not secure SSL connection is used.
     * @valid true
     * @valid false
     */
    @XmlElement(name = "use_ssl")
    public Boolean getUseSSL() {
        return useSSL;
    }

    public void setUseSSL(Boolean useSSL) {
        this.useSSL = useSSL;
    }

    /** 
     * SMIS provider software revision number.
     * @valid none
     */
    @XmlElement(name = "version_string")
    public String getVersionString() {
        return versionString;
    }

    public void setVersionString(String versionString) {
        this.versionString = versionString;
    }

    /**
     * Status of the provider scan job.
     * @valid CREATED
     * @valid IN_PROGRESS
     * @valid COMPLETE 
     * @valid ERROR
     */
    @XmlElement(name = "job_scan_status")
    public String getScanStatus() {
        return scanStatus;
    }

    public void setScanStatus(String scanStatus) {
        this.scanStatus = scanStatus;
    }

    /** 
     * Status message from the last scan.
     * @valid none
     */
    @XmlElement(name = "last_scan_status_message")
    public String getLastScanStatusMessage() {
        return lastScanStatusMessage;
    }

    public void setLastScanStatusMessage(String statusMessage) {
        lastScanStatusMessage = statusMessage;
    }

    /**
     * Time the last scan occurred.
     * @valid none
     */
    @XmlElement(name = "last_scan_time")
    public Long getLastScanTime() {
        return lastScanTime;
    }

    public void setLastScanTime(Long lastScanTime) {
        this.lastScanTime = lastScanTime;
    }

    /**
     * Time for which the next scan job is scheduled.
     * @valid none
     */
    @XmlElement(name = "next_scan_time")
    public Long getNextScanTime() {
        return nextScanTime;
    }

    public void setNextScanTime(Long nextScanTime) {
        this.nextScanTime = nextScanTime;
    }


    /**
     * The latest timestamp when the system run scanning successfully
     *
     * @valid none
     */
    @XmlElement(name = "success_scan_time")
    public Long getSuccessScanTime() {
        return successScanTime;
    }

    public void setSuccessScanTime(Long successScanTime) {
        this.successScanTime = successScanTime;
    }


    /**
     * Registration status of the provider
     * @valid REGISTERED
     * @valid UNREGISTERED
     */
    @XmlElement(name = "registration_status")
    public String getRegistrationStatus() {
        return registrationStatus;
    }

    public void setRegistrationStatus(String registrationStatus) {
        this.registrationStatus = registrationStatus;
    }

    /** 
     * Whether or not the provider software is compatible with
     * ViPR.
     * @valid COMPATIBLE
     * @valid INCOMPATIBLE
     * @valid UNKNOWN
     */
    @XmlElement(name = "compatibility_status")
    public String getCompatibilityStatus() {
        return compatibilityStatus;
    }

    public void setCompatibilityStatus(String compatibilityStatus) {
        this.compatibilityStatus = compatibilityStatus;
    }
}
