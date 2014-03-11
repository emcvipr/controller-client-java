package com.emc.vipr.client.core.filters;

import static com.emc.vipr.client.core.util.UnmanagedHelper.getVpoolsForUnmanaged;

import java.net.URI;
import java.util.Set;

import com.emc.storageos.model.file.UnManagedFileSystemRestRep;

public class UnmanagedFileSystemVirtualPoolFilter extends DefaultResourceFilter<UnManagedFileSystemRestRep> {
    private URI virtualPoolId;

    public UnmanagedFileSystemVirtualPoolFilter(URI virtualPoolId) {
        this.virtualPoolId = virtualPoolId;
    }

    @Override
    public boolean accept(UnManagedFileSystemRestRep item) {
        if (!super.accept(item)) {
            return false;
        }

        Set<URI> vpools = getVpoolsForUnmanaged(item.getFileSystemInformation(), item.getFileSystemCharacteristics());
        return vpools.contains(virtualPoolId);
    }
}
