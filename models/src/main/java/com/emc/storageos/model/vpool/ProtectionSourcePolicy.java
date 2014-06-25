package com.emc.storageos.model.vpool;

import javax.xml.bind.annotation.XmlElement;

public class ProtectionSourcePolicy {
    
    private String journalSize;
    private String remoteCopyMode;
    private Long rpoValue;
    private String rpoType;
    
    public ProtectionSourcePolicy() {}
    
    public ProtectionSourcePolicy(String journalSize, String remoteCopyMode, Long rpoValue, String rpoType) {
        this.journalSize = journalSize;
        this.remoteCopyMode = remoteCopyMode;
        this.rpoValue = rpoValue;
        this.rpoType = rpoType;
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

    /**
     * The remote copy mode, sync or async
     * 
     * @valid ASYNCHRONOUS = RecoverPoint CG will be in Asynchronous mode (default)
     * @valid SYNCHRONOUS = RecoverPoint CG will be in Synchronous mode
     */
    @XmlElement(name="remote_copy_mode", required = false)
    public String getRemoteCopyMode() {
        return remoteCopyMode;
    }

    public void setRemoteCopyMode(String remoteCopyMode) {
        this.remoteCopyMode = remoteCopyMode;
    }

	/**
	 * RPO value sent to RP
	 * 
	 * @return RPO value
	 */
    @XmlElement(name="rpo_value", required = false)
	public Long getRpoValue() {
		return rpoValue;
	}

	public void setRpoValue(Long rpoValue) {
		this.rpoValue = rpoValue;
	}

	/**
	 * Type of RPO unit
	 * 
	 * @valid SECONDS = Seconds (time-based RPO)
     * @valid MINUTES = Minutes (time-based RPO)
     * @valid HOURS = Hours (time-based RPO)
     * @valid WRITES = Number of writes (transaction-based RPO)
     * @valid BYTES = Bytes (sized-based RPO)
     * @valid KB = Kilobytes (sized-based RPO)
     * @valid MB = Megabytes (sized-based RPO)
     * @valid GB = Gigabytes (sized-based RPO)
     * @valid TB = Terabytes (sized-based RPO)
	 */
    @XmlElement(name="rpo_type", required = false)
	public String getRpoType() {
		return rpoType;
	}

	public void setRpoType(String rpoType) {
		this.rpoType = rpoType;
	}

    
}
