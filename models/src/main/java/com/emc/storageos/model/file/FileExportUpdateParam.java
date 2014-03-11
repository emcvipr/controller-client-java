package com.emc.storageos.model.file;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Parameter for file export update.  Contains lists of
 * end points that need to be added or removed for a file
 * share export.
 */
@XmlRootElement(name = "filesystem_export_update")
public class FileExportUpdateParam {
    
    private List<String> add;
    private List<String> remove;

    public FileExportUpdateParam() {}
    
    public FileExportUpdateParam(List<String> add, List<String> remove) {
        this.add = add;
        this.remove = remove;
    }

    @XmlElementWrapper(required=false)
    /**
     * List of endpoints to be added
     * @valid none
     */
    @XmlElement(name = "add")
    public List<String> getAdd() {
        if (add == null) {
            add = new ArrayList<String>();
        }
        return add;
    }

    public void setAdd(List<String> add) {
        this.add = add;
    }

    @XmlElementWrapper(required=false)
    /**
     * List of endpoints to be removed
     * @valid none
     */
    @XmlElement(name="remove")
    public List<String> getRemove() {
        if (remove == null) {
            remove = new ArrayList<String>();
        }
        return remove;
    }

    public void setRemove(List<String> remove) {
        this.remove = remove;
    }
    
}

