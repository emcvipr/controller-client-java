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

package com.emc.vipr.model.object.datastore;

import com.emc.storageos.model.DataObjectRestRep;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Information about the data store
 */
@XmlRootElement(name = "data_store")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class DataStoreRestRep extends DataObjectRestRep
{
    private String _description;
    private Long _totalCapacityInGB;
    private Long _availableCapacityInGB;
    private String _deviceState;
    private String _vPool;
    private String _additionalInfo;

    public DataStoreRestRep(){
    }

    /**
     * <p>State of the data store</p>
     * <li>uninitialized - has not been initialized, unavailable for use</li>
     * <li>initializing - being initialized</li>
     * <li>initialized - initialized, ready for use</li>
     * <li>deleting - being deleted, can not be used</li>
     * <li>deleted - deleted, no longer exists</li>
     * @valid uninitialized, initializing, initialized, deleting, deleted
     * @return State of data store
     */
    @XmlElement(name = "device_state")
    public String getDeviceState() {
        return _deviceState;
    }

    @XmlElement(name = "device_info")
    public String getDeviceInfo() {
        return _additionalInfo;
    }

    /**
     * varray which is used for thisdata store
     * @valid None
     * @return vpool
     */
    @XmlElement(name = "data_services_varray")
    public String getCoS() {
        return _vPool;
    }

    /**
     * Total capacity for this data store
     * @valid None
     * @return Total Capacity
     */
    @XmlElement(name = "usable_gb")
    public Long getTotalCapacityInGB() {
        return _totalCapacityInGB;
    }

    /**
     * Estimated available capacity for this data store
     * @valid None
     * @return Available capacity
     */
    @XmlElement(name = "free_gb")
    public Long getAvailableCapacityInGB() {
        return _availableCapacityInGB;
    }

    @XmlElement(name = "used_gb")
    public Long getUsedCapacityInGB(){
        return _totalCapacityInGB - _availableCapacityInGB;
    }

    /**
     * Description for this data store
     * @valid None
     * @return data store description
     */
    @XmlElement(name = "description")
    public String getDescription() {
        return _description;
    }

    public void setDeviceInfo(String _additionalInfo) {
        this._additionalInfo = _additionalInfo;
    }

    public void setAvailableCapacityInGB(Long _availableCapacityInGB) {
        this._availableCapacityInGB = _availableCapacityInGB;
    }

    public void setDescription(String _description) {
        this._description = _description;
    }

    public void setDeviceState(String _deviceState) {
        this._deviceState = _deviceState;
    }

    public void setTotalCapacityInGB(Long _totalCapacityInGB) {
        this._totalCapacityInGB = _totalCapacityInGB;
    }

    public void setCoS(String _vPool) {
        this._vPool = _vPool;
    }
}
