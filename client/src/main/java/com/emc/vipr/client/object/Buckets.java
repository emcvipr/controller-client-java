package com.emc.vipr.client.object;

import com.emc.vipr.client.impl.RestClient;
import com.emc.vipr.model.object.bucket.BucketListRestRep;
import com.emc.vipr.model.object.bucket.ObjectBucketRestRep;
import com.emc.vipr.model.object.bucket.ObjectBucketParam;
import com.emc.vipr.model.object.bucket.UpdateBucketOwnerParam;
import com.emc.vipr.model.object.retention.BucketRetentionInfoRep;
import com.emc.vipr.model.object.retention.BucketRetentionUpdateParam;

import java.net.URI;

import static com.emc.vipr.client.object.impl.PathConstants.*;

public class Buckets {

    private RestClient client;

    public Buckets(RestClient client) {
        this.client = client;
    }

    /**
     * Create bucket
     * <p>
     * API Call: <tt>POST /object/bucket</tt>
     * 
     * @param create
     *        parameters needed to create a bucket
     * @return bucket object
     */
    public ObjectBucketRestRep create(ObjectBucketParam create) {
        return client.post(ObjectBucketRestRep.class, create, OBJECT_BUCKET_URL);
    }
    
    /**
     * 
     * @param namespace
     * @return List of bucket associated with namespace and logged in tenant
     */
    public BucketListRestRep getBucketList(URI namespace)
    {
    	return client.get(BucketListRestRep.class, OBJECT_BUCKET_URL + ID_PATH, namespace);
    }

    /**
     * Delete bucket.
     * <p>
     * API Call: <tt>POST /object/bucket/{bucketName}/deactivate</tt>
     * </p>
     * 
     * @param bucketName
     *        name of the bucket to be deleted.
     */
    public void deactivate(String bucketName) {
        client.post(String.class, (Object) bucketName, OBJECT_BUCKET_URL + ID_PATH + DEACTIVATE_PATH, bucketName);
    }

    /**
     * Gets the retention information for a given bucket.
     * <p>
     * API Call: <tt>GET /object/bucket/{bucketName}/retention</tt>
     * </p>
     * 
     * @param bucketName
     *        the name of the bucket.
     * @return the retention information.
     */
    public BucketRetentionInfoRep getRetention(String bucketName) {
        return client.get(BucketRetentionInfoRep.class, OBJECT_BUCKET_RETENTION_URL, bucketName);
    }

    /**
     * Sets the retention information for a given bucket.
     * <p>
     * API Call: <tt>PUT /object/bucket/{bucketName}/retention</tt>
     * </p>
     * 
     * @param bucketName
     *        the name of the bucket.
     * @param update
     *        the updated bucket retention information.
     */
    public void setRetention(String bucketName, BucketRetentionUpdateParam update) {
        client.put(String.class, update, OBJECT_BUCKET_RETENTION_URL, bucketName);
    }

    /**
     * Updates the owner of a given bucket
     * <p>
     * API Call: <tt>POST /object/bucket/{bucketName}/owner</tt>
     * </p>
     *
     * @param bucketName
     *        the name of the bucket.
     * @param update
     *        bucket owner update information
     */
    public void updateOwner(String bucketName, UpdateBucketOwnerParam update) {
        client.post(String.class, update, OBJECT_BUCKET_UPDATE_OWNER_URL, bucketName);
    }
}
