package com.emc.vipr.client.core.filters;

import com.emc.storageos.model.DataObjectRestRep;

public class NameFilter<T extends DataObjectRestRep> extends DefaultResourceFilter<T> {
    private String name;

    public NameFilter(String name) {
        this.name = name;
    }

    @Override
    public boolean accept(T item) {
        return name.equals(item.getName());
    }
}
