/*
 * Copyright (c) 2015 EMC Corporation
 * All Rights Reserved
 */
package com.emc.storageos.model.block.export;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "bulk_itls")
public class ITLBulkRep {

    private List<ITLRestRep> exportList;

    public ITLBulkRep() {
    }

    public ITLBulkRep(List<ITLRestRep> exportList) {
        this.exportList = exportList;
    }

    /**
     * A list of Initiator-Target-Lun Rest Response objects.
     * Each entry in the list represents one initiator - target connection to a volume.
     * 
     */
    @XmlElement(name = "itl")
    public List<ITLRestRep> getExportList() {
        if (exportList == null) {
            exportList = new ArrayList<ITLRestRep>();
        }
        return exportList;
    }

    public void setExportList(List<ITLRestRep> exportList) {
        this.exportList = exportList;
    }

}
