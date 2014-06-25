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

public enum VirtualPoolChangeOperationEnum {
    VPLEX_LOCAL_TO_DISTRIBUTED("Change one or more volumes from local VPLEX to distributed VPLEX virtual pool"), 
    VPLEX_DATA_MIGRATION("Migrate data from one or more volumes to new virtual pool"), 
    NON_VPLEX_TO_VPLEX("Change one or more volumes from non-VPLEX to a local or distributed virtual pool"), 
    RP_PROTECTED("Change one or more volumes to include RecoverPoint protection"), 
    SRDF_PROTECED("Chnage one or more volumes to include SRDF protection"), 
    ADD_MIRRORS("Change one or more volumes to include continuous copies protection"), 
    EXPORT_PATH_PARAMS("Change one or more volumes' path paramters");

    private String description;

    private VirtualPoolChangeOperationEnum(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }

}
