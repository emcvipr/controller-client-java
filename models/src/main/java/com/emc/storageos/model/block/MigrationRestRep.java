/**
 *  Copyright (c) 2013 EMC Corporation
 * All Rights Reserved
 *
 * This software contains the intellectual property of EMC Corporation
 * or is licensed to EMC Corporation from third parties.  Use of this
 * software and the intellectual property contained therein is expressly
 * limited to the terms and conditions of the License Agreement under which
 * it is provided by or on behalf of EMC.
 */
package com.emc.storageos.model.block;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.emc.storageos.model.DataObjectRestRep;
import com.emc.storageos.model.RelatedResourceRep;

/**
 * Migration response.
 */
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlRootElement(name = "block_migration")
public class MigrationRestRep extends DataObjectRestRep {
    private RelatedResourceRep volume;
    private RelatedResourceRep source;
    private RelatedResourceRep target;
    private String startTime;
    private String status;
    private String percentageDone;

    /**
     * The percentage of the migration which has been completed.
     * 
     * @valid 0-100
     * 
     * @return The percent done for the migration.
     */
    @XmlElement(name = "percent_done")
    public String getPercentageDone() {
        return percentageDone;
    }

    public void setPercentageDone(String percentageDone) {
        this.percentageDone = percentageDone;
    }

    /**
     * The source volume for the migration. This volume holds the data
     * to be migrated.
     * 
     * @valid none
     *
     * @return The related resource representation for the migration source.
     */
    @XmlElement(name = "source")
    public RelatedResourceRep getSource() {
        return source;
    }

    public void setSource(RelatedResourceRep source) {
        this.source = source;
    }

    /**
     * The start time of the migration.
     * 
     * @valid <i>EEE</i> <i>MMM</i> <i>dd</i> <i>hh</i>:<i>mm</i>:<i>ss</i> <i>z</i> <i>yyyy</i>
     *
     * @return The migration start time.
     */
    @XmlElement(name = "start_time")
    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    /**
     * The status of the migration.
     * 
     * @valid in-progress = The migration is in progress.
     * @valid complete = The migration has completed.
     * @valid paused = The migration has been paused.
     * @valid cancelled = The migration has been canceled.
     * @valid committed = The migration has been committed.
     * @valid ready = The initial state for a migration after it has been created.
     * @valid error = The migration failed.
     * @valid partially-committed = The migration is in the process of being committed.
     * @valid partially-cancelled = The migration is in the process of being canceled.
     * @valid queued = The migration is queued and awaiting execution.
     *
     * @return The migration status.
     */
    @XmlElement(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * The target volume for the migration. This is the volume to which
     * the data on the source volume is migrated.
     * 
     * @valid none
     *
     * @return The related resource representation for the migration target.
     */
    @XmlElement(name = "target")
    public RelatedResourceRep getTarget() {
        return target;
    }

    public void setTarget(RelatedResourceRep target) {
        this.target = target;
    }

    /**
     * The volume being migrated.
     * 
     * @valid none
     *
     * @return The related resource representation for the volume being migrated.
     */
    @XmlElement(name = "volume")
    public RelatedResourceRep getVolume() {
        return volume;
    }

    public void setVolume(RelatedResourceRep volume) {
        this.volume = volume;
    }
}
