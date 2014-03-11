package com.emc.storageos.model.vpool;

import javax.xml.bind.annotation.XmlElement;

public class ProtectionSourcePolicy {
    
    private String journalSize;

    public ProtectionSourcePolicy() {}
    
    public ProtectionSourcePolicy(String journalSize) {
        this.journalSize = journalSize;
    }

    /**
     * The journal size for a protection source.
     * 
     * @valid none
     */
    @XmlElement(name = "journal_size", required = false)
    public String getJournalSize() {
        return journalSize;
    }

    public void setJournalSize(String journalSize) {
        this.journalSize = journalSize;
    }
    
}
