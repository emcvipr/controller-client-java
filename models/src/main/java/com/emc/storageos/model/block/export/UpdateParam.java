package com.emc.storageos.model.block.export;

import java.net.URI;
import java.util.Collection;

public abstract class UpdateParam {
    
    public abstract Collection<URI> getAdd();
    public abstract Collection<URI> getRemove();
    public boolean hasAdded() {
        return getAdd() != null && getAdd().size() > 0;
    }
    public boolean hasRemoved() {
        return getRemove() != null && getRemove().size() > 0;
    }
    public boolean hasUpdates() {
        return hasAdded() || hasRemoved();
    }
  
}
