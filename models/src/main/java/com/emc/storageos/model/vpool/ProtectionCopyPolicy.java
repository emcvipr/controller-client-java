package com.emc.storageos.model.vpool;

import javax.xml.bind.annotation.XmlElement;

public class ProtectionCopyPolicy {
   
    private String journalSize;

    public ProtectionCopyPolicy() {}
    
    public ProtectionCopyPolicy(String journalSize) {
        this.journalSize = journalSize;
    }

    /**
     * The journal size for a protection copy.
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((journalSize == null) ? 0 : journalSize.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ProtectionCopyPolicy other = (ProtectionCopyPolicy) obj;
        if (journalSize == null) {
            if (other.journalSize != null)
                return false;
        }
        else if (!journalSize.equals(other.journalSize))
            return false;
        return true;
    }
}
