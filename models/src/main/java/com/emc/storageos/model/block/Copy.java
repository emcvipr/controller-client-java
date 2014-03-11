package com.emc.storageos.model.block;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.net.URI;

/**
 * Specifies the copy to be operated on
 * 
 * 	type: type of protection (rp, native, srdf)
 * 	sync: synchronize the mirror
 * 	copyID: the URI of the copy to be operated on, if none specified operate on all copies for that type
 * 	name: name of a new mirror being created by start operation
 * 	count: number of mirrors to create using start operation
 */
@XmlRootElement(name = "copy")
public class Copy {
	
	private String type;
	private String sync;
	private URI copyID;
	private String name;
    private Integer count;

    public Copy() {}
            
    public Copy(String type, String sync, URI copyID, String name, Integer count) {
    	this.type = type;
    	this.sync = sync;
    	this.copyID = copyID;
    	this.name = name;
        this.count = count;
    }

    /**
     * @valid true
     * @valid false
     */
    @XmlElement(name = "sync", required = false, defaultValue = "false")
    public String getSync() {
        return sync;
    }

    public void setSync(String sync) {
        this.sync = sync;
    }

    /**
     * Type of protection.
     * @valid none
     */
    @XmlElement(name = "type", required = true)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

	/**
	 * @return the copyID
	 */
    @XmlElement(name = "copyID", required = false)
    public URI getCopyID() {
		return copyID;
	}

	public void setCopyID(URI copyID) {
		this.copyID = copyID;
	}
	
    /** 
     * User provided name. 
     * @valid none
     */
    @XmlElement(name = "name", required = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * User provided number of copies.
     * @valid none
     */
    @XmlElement(name = "count", required = false)
    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
    
}
