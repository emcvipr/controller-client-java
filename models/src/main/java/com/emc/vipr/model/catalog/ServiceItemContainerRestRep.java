package com.emc.vipr.model.catalog;

import java.util.List;

public interface ServiceItemContainerRestRep {
    public List<? extends ServiceItemRestRep> getItems();
}
