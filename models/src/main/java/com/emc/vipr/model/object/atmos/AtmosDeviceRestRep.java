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

package com.emc.vipr.model.object.atmos;

import com.emc.storageos.model.DataObjectRestRep;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * Represents an atmos device that has been registered with Bourne
 */
@XmlRootElement(name = "atmos_device")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class AtmosDeviceRestRep extends DataObjectRestRep
{
    private String _tenantId;
    private String _tenantName;
    private String _tenantAdmin;
    private String _ip;
    private String _deviceState;

    /**
     * State of the hosting device
     * @valid uninitialized - has not been initialized, unavailable for use
     * @valid initializing - being initialized
     * @valid initialized - initialized, ready for use
     * @valid deleting - being deleted, can not be used
     * @valid deleted - deleted, no longer exists
     * @return Device state
     * @valid Uninitialized,initializing, initialized, deleting, deleted
     * @return Device state
     */
    @XmlElement(name = "device_state")
    public String getDeviceState() {
        return _deviceState;
    }

    public void setDeviceState(String deviceState) {
        this._deviceState = deviceState;
    }

    /**
     * Tenant identifier
     * @valid None
     * @return Tenant Id
     */
    @XmlElement(name = "tenant_id")
    public String getTenantId() {
        return _tenantId;
    }

    public void setTenantId(String id) {
        _tenantId = id;
    }

    /**
     * Tenant user name
     * @valid: None
     * @return Tenant user name
     */
    @XmlElement(name = "tenant_name")
    public String getTenantName() {
        return _tenantName;
    }

    public void setTenantName(String tenantName) {
        _tenantName = tenantName;
    }

    /**
     * Tenant administrator user name
     * @valid None
     * @return Tenant admin user name
     */
    @XmlElement(name = "tenant_admin")
    public String getTenantAdmin() {
        return _tenantAdmin;
    }

    public void setTenantAdmin(String tenantAdmin) {
        _tenantAdmin = tenantAdmin;
    }

    /**
     * Atmos endpoint.  in the form "ip:port:sslport"
     * (If sslport specified then port must be specified as well)
     * @optional port - End point for atmos service @defaultValue 80
     * @optional sslport - End point for secure service @defaultValue 443
     * @valid ip: port: sslport
     * @valid ip: port
     * @valid ip
     * @return Atmos IP
     */
    @XmlElement(name = "ip")
    public String getIp() {
        return _ip;
    }

    public void setIp(String ip) {
        _ip = ip;
    }
}
