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

package com.emc.storageos.model.ports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.emc.storageos.model.RelatedResourceRep;
import com.emc.storageos.model.varray.VirtualArrayResourceRestRep;


@XmlRootElement(name = "storage_port")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class StoragePortRestRep extends VirtualArrayResourceRestRep {
    private String portName;
    private String portAlias;
    private String ipAddress;
    private Long tcpPortNumber;
    private String portNetworkId;
    private String portEndPointId;
    private String transportType;
    private RelatedResourceRep network;
    private RelatedResourceRep storageDevice;
    private Long portSpeed;
    private String portType;
    private String portGroup;
    private Long avgBandwidth;
    private Long staticLoad;
    private String registrationStatus;
    private String operationalStatus;
    private String compatibilityStatus;

    public StoragePortRestRep() {}
    
    /**
     * The average bandwidth through the port (Gbps)
     *
     * @valid none
     */
    @XmlElement(name = "avg_band_width")
    public Long getAvgBandwidth() {
        return avgBandwidth;
    }

    public void setAvgBandwidth(Long avgBandwidth) {
        this.avgBandwidth = avgBandwidth;
    }

    /**
     * The port's IP address (for IP-based transport)
     *
     * @valid none
     */
    @XmlElement(name = "ip_address")
    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    /**
     * ID of the endpoint with which this port is associated.
     * 
     * @valid none    
     */
    @XmlElement(name = "port_endpoint_id")
    public String getPortEndPointId() {
        return portEndPointId;
    }

    public void setPortEndPointId(String portEndPointId) {
        this.portEndPointId = portEndPointId;
    }

    /**
     * The name of  this  port's group. A port  group is a  mapping
     * that is configured on a storage system  between a collection
     * of ports, a collection of volumes and a collection of  hosts
     * that use those volumes. This name is what the storage system
     * uses to identify the port group.
     *
     * @valid none
     */
    @XmlElement(name = "port_group")
    public String getPortGroup() {
        return portGroup;
    }

    public void setPortGroup(String portGroup) {
        this.portGroup = portGroup;
    }


    /**
     * The native name of the port. This name consists of identifiers that
     * are used by the hosting storage system. It may also follow a naming
     * convention that is in common use for that make and model of storage
     * system.
     *
     * @valid none
     */
    @XmlElement(name = "port_name")
    public String getPortName() {
        return portName;
    }

    public void setPortName(String portName) {
        this.portName = portName;
    }
    
    /**
     * The alias represents port's wwn id
     *
     * @valid none
     */
    @XmlElement(name = "port_alias")
    public String getPortAlias() {
        return portAlias;
    }

    public void setPortAlias(String portAlias) {
        this.portAlias = portAlias;
    }    

    /**
     * The network address of the port. When Fibre-Channel (FC) is the
     * transport protocol, the address is a World Wide Name (WWN).
     * If the port is using an IP-based protocol, this is an IP address,
     * or name of the port that a storage system uses to identify the port.
     *
     * @valid none
     */
    @XmlElement(name = "port_network_id")
    public String getPortNetworkId() {
        return portNetworkId;
    }

    public void setPortNetworkId(String portNetworkId) {
        this.portNetworkId = portNetworkId;
    }

    /**
     * The port's clock speed (Gbps)
     * 
     * @valid none
     */
    @XmlElement(name = "port_speed_gbps")
    public Long getPortSpeed() {
        return portSpeed;
    }

    public void setPortSpeed(Long portSpeed) {
        this.portSpeed = portSpeed;
    }

    /**
     * How the port connects its storage controller to its network
     *
     * @valid backend  = connects a VPLEX storage controller to another array
     * @valid frontend = connects the storage controller to the hosts
     */
    @XmlElement(name = "port_type")
    public String getPortType() {
        return portType;
    }

    public void setPortType(String portType) {
        this.portType = portType;
    }

    /**
     * The number of exports on the storage port
     *
     * @valid none
     */
    @XmlElement(name = "static_load")
    public Long getStaticLoad() {
        return staticLoad;
    }

    public void setStaticLoad(Long staticLoad) {
        this.staticLoad = staticLoad;
    }

    /**
     * The storage system that hosts this port
     *
     * @valid none
     */
    @XmlElement(name = "storage_system")
    public RelatedResourceRep getStorageDevice() {
        return storageDevice;
    }

    public void setStorageDevice(RelatedResourceRep storageDevice) {
        this.storageDevice = storageDevice;
    }

    /**
     * The port's TCP port number (for IP-based transport)
     *
     * @valid 1-65535
     */
    @XmlElement(name = "tcp_port_number")
    public Long getTcpPortNumber() {
        return tcpPortNumber;
    }

    public void setTcpPortNumber(Long tcpPortNumber) {
        this.tcpPortNumber = tcpPortNumber;
    }

    /**
     * The protocol that this port uses to transport disk commands
     * and responses across its network
     *
     * @valid FC = Fibre-Channel
     * @valid IP
     *
     */
    @XmlElement(name = "transport_type")
    public String getTransportType() {
        return transportType;
    }

    public void setTransportType(String transportType) {
        this.transportType = transportType;
    }

    /**
     * The ViPR network that connects to this port
     *
     * @valid none
     */
    @XmlElement(name = "network")
    public RelatedResourceRep getNetwork() {
        return network;
    }

    public void setNetwork(RelatedResourceRep network) {
        this.network = network;
    }

    /**
     * Whether or not this port is registered with ViPR. A
     * port must be registered before it can be managed by
     * ViPR.
     *
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
     * The operational status of the port
     *
     * @valid OK
     * @valid NOT_OK
     * @valid UNKNOWN
     */
    @XmlElement(name = "operational_status")
    public String getOperationalStatus() {
        return operationalStatus;
    }

    public void setOperationalStatus(String operationalStatus) {
        this.operationalStatus = operationalStatus;
    }
    
    /**
     * Whether or not this storage port is compatible with ViPR
     * 
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
