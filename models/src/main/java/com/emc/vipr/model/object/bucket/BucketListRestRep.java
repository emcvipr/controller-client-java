package com.emc.vipr.model.object.bucket;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Object Bucket information
 */
@XmlRootElement(name = "object_buckets")
public class BucketListRestRep {
	private List<ObjectBucketRestRep> objectBucketList;

    /**
     * A list of buckets
     * @valid None
     * @return list of object buckets
     */
    @XmlElement(name = "object_bucket", required = true)
	public List<ObjectBucketRestRep> getObjectBucketList() {
		if (objectBucketList == null)
		{
			this.objectBucketList = new ArrayList<ObjectBucketRestRep>();
		}
		return objectBucketList;
	}

	public void setObjectBucketList(List<ObjectBucketRestRep> objectBucketList) {
		this.objectBucketList = objectBucketList;
	}
	
	

}
