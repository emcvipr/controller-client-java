/*
 * Copyright (c) 2015 EMC Corporation
 * All Rights Reserved
 */

package com.emc.vipr.client.core;

import static com.emc.vipr.client.core.util.ResourceUtils.defaultList;

import java.net.URI;
import java.util.List;

import com.emc.storageos.model.BulkIdParam;
import com.emc.storageos.model.TaskResourceRep;
import com.emc.storageos.model.object.BucketBulkRep;
import com.emc.storageos.model.object.BucketDeleteParam;
import com.emc.storageos.model.object.BucketParam;
import com.emc.storageos.model.object.BucketRestRep;
import com.emc.storageos.model.object.BucketUpdateParam;
import com.emc.vipr.client.Task;
import com.emc.vipr.client.Tasks;
import com.emc.vipr.client.ViPRCoreClient;
import com.emc.vipr.client.core.impl.PathConstants;
import com.emc.vipr.client.impl.RestClient;

/**
 * ObjectBuckets resources.
 * <p>
 * Base URL: <tt>/object/buckets</tt>
 */
public class ObjectBuckets extends ProjectResources<BucketRestRep> implements TaskResources<BucketRestRep> {

    public ObjectBuckets(ViPRCoreClient parent, RestClient client) {
        super(parent, client, BucketRestRep.class, PathConstants.OBJECT_BUCKET_URL);
    }

    @Override
    public Tasks<BucketRestRep> getTasks(URI id) {
        return doGetTasks(id);
    }

    @Override
    public Task<BucketRestRep> getTask(URI id, URI taskId) {
        return doGetTask(id, taskId);
    }

    @Override
    protected List<BucketRestRep> getBulkResources(BulkIdParam input) {
        BucketBulkRep response = client.post(BucketBulkRep.class, input, getBulkUrl());
        return defaultList(response.getBuckets());
    }

    /**
     * Begins deactivating the given bucket by ID.
     * <p>
     * API Call: <tt>POST /object/buckets/{id}/deactivate</tt>
     * 
     * @param id
     *            the ID of the file system to deactivate.
     * @param input
     *            the delete configuration.
     * @return a task for monitoring the progress of the operation.
     */
    public Task<BucketRestRep> deactivate(URI id, BucketDeleteParam input) {
        return postTask(input, getDeactivateUrl(), id);
    }

    /**
     * Begins create the bucket.
     * <p>
     * API Call: <tt>POST /object/buckets</tt>
     * 
     * @param input
     *            the create configuration.
     * @return a task for monitoring the progress of the operation.
     */
    public Task<BucketRestRep> create(BucketParam input, URI project) {
        URI uri = client.uriBuilder(baseUrl).queryParam("project", project).build();
        TaskResourceRep task = client.postURI(TaskResourceRep.class, input, uri);
        return new Task<>(client, task, resourceClass);
    }

    /**
     * Begins update the bucket.
     * <p>
     * API Call: <tt>PUT /object/buckets</tt>
     * 
     * @param input
     *            the create configuration.
     * @return a task for monitoring the progress of the operation.
     */
    public Task<BucketRestRep> update(URI id, BucketUpdateParam input) {
        return putTask(input, getIdUrl(), id);
    }
}
