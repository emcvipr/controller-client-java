/**
 *  Copyright (c) 2008-2014 EMC Corporation
 * All Rights Reserved
 *
 * This software contains the intellectual property of EMC Corporation
 * or is licensed to EMC Corporation from third parties.  Use of this
 * software and the intellectual property contained therein is expressly
 * limited to the terms and conditions of the License Agreement under which
 * it is provided by or on behalf of EMC.
 */
package com.emc.storageos.model.smis;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.emc.storageos.model.BulkRestRep;
@XmlRootElement(name = "bulk_storage_providers")
public class StorageProviderBulkRep extends BulkRestRep {
	
	public StorageProviderBulkRep(){
	}
	
	public StorageProviderBulkRep(List<StorageProviderRestRep> storageProviders){
		this.storageProviders = storageProviders;
	}
	
	private List<StorageProviderRestRep> storageProviders;
	/**
     * List of Storage Providers.
     * @valid none
     */
    @XmlElement(name = "storage_provider")
	public List<StorageProviderRestRep> getStorageProviders() {
		return storageProviders;
	}

	public void setStorageProviders(List<StorageProviderRestRep> storageProviders) {
		this.storageProviders = storageProviders;
	}

}
