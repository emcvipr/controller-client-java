package com.emc.vipr.client.core.filters;

import com.emc.storageos.model.block.VolumeRestRep;
import com.emc.storageos.model.block.VolumeRestRep.SRDFRestRep;

/**
 * Filter for volumes that are SRDF sources.
 */
public class SRDFSourceFilter extends DefaultResourceFilter<VolumeRestRep> {
    @Override
    public boolean accept(VolumeRestRep item) {
        if ((item.getProtection() != null) && (item.getProtection().getSrdfRep() != null)) {
            SRDFRestRep srdf = item.getProtection().getSrdfRep();
            return (srdf.getSRDFTargetVolumes() != null) && (srdf.getSRDFTargetVolumes().size() > 0);
        }
        else {
            return false;
        }
    }
}
