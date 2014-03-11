package com.emc.vipr.client.object;


import com.emc.vipr.client.impl.RestClient;
import com.emc.vipr.model.object.bucket.ObjectBucketRestRep;
import com.emc.vipr.model.object.bucket.ObjectBucketParam;

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
     * @param create parameters needed to create a bucket
     * @return bucket object
     */
    public ObjectBucketRestRep create(ObjectBucketParam create) {
        return client.post(ObjectBucketRestRep.class, create, OBJECT_BUCKET_URL);
    }

    /**
     * Delete bucket.
     * <p>
     *     API Call: <tt>POST /object/bucket/{keypoolName}/deactivate</tt>
     * </p>
     *
     * @param bucketName name of the bucket to be deleted.
     */
    public void deactivate(String bucketName) {
        client.post(String.class, (Object)bucketName, OBJECT_BUCKET_URL + ID_PATH + DEACTIVATE_PATH, bucketName);
    }
}
