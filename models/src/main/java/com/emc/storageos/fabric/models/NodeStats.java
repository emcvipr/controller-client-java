/**
 *  Copyright (c) 2013 EMC Corporation
 * All Rights Reserved
 *
 * This software contains the Stringellectual property of EMC Corporation
 * or is licensed to EMC Corporation from third parties.  Use of this
 * software and the Stringellectual property contained therein is expressly
 * limited to the terms and conditions of the License Agreement under which
 * it is provided by or on behalf of EMC.
 */
package com.emc.storageos.fabric.models;

import java.io.Serializable;
import java.net.URI;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Individual node statistics
 *
 */
public class NodeStats implements Serializable {
    
    private URI nodeId;
    private String cpuNum;
    private String cpuSpeed; 
    private String cpuIdle; //%
    private String loadOne;
    private String loadFive;
    private String loadFifteen; 
    private String procRun;
    private String memTotal; 
    private String memFree; 
    private String memBuffers; 
    private String memCached; 
    private String swapTotal; 
    private String swapFree; 
    private String bootTime; 
    private String osRelease;
    
    /**
     * Node id
     */
    @XmlElement(name = "node_id")
    public URI getNodeId() {
        return nodeId;
    }

    public void setNodeId(URI nodeId) {
        this.nodeId = nodeId;
    }
    
    /**
     * Number of CPUs in the system
     */
    @XmlElement(name = "cpu_num")
    public String getCpuNum() {
        return cpuNum;
    }

    public void setCpuNum(String cpuNum) {
        this.cpuNum = cpuNum;
    }
    
    /**
     * CPU speed in MHz
     */
    @XmlElement(name = "cpu_speed")
    public String getCpuSpeed() {
        return cpuSpeed;
    }

    public void setCpuSpeed(String cpuSpeed) {
        this.cpuSpeed = cpuSpeed;
    }
    
    /**
     * Percentage of time the CPU was idle
     */
    @XmlElement(name = "cpu_idle")
    public String getCpuIdle() {
        return cpuIdle;
    }

    public void setCpuIdle(String cpuIdle) {
        this.cpuIdle = cpuIdle;
    }
    
    /**
     * One minute load average
     */
    @XmlElement(name = "load_one")
    public String getLoadOne() {
        return loadOne;
    }

    public void setLoadOne(String loadOne) {
        this.loadOne = loadOne;
    }
    
    /**
     * Five minute load average
     */
    @XmlElement(name = "load_five")
    public String getLoadFive() {
        return loadFive;
    }

    public void setLoadFive(String loadFive) {
        this.loadFive = loadFive;
    }
    
    /**
     * Fifteen minute load average
     */
    @XmlElement(name = "load_fifteen")
    public String getLoadFifteen() {
        return loadFifteen;
    }

    public void setLoadFifteen(String loadFifteen) {
        this.loadFifteen = loadFifteen;
    }
    
    /**
     * Total number of running processes
     */
    @XmlElement(name = "proc_run")
    public String getProcRun() {
        return procRun;
    }

    public void setProcRun(String procRun) {
        this.procRun = procRun;
    }
    
    /**
     * Total amount of memory in KB
     */
    @XmlElement(name = "mem_total")
    public String getMemTotal() {
        return memTotal;
    }

    public void setMemTotal(String memTotal) {
        this.memTotal = memTotal;
    }
    
    /**
     * Amount of available memory in KB
     */
    @XmlElement(name = "mem_free")
    public String getMemFree() {
        return memFree;
    }

    public void setMemFree(String memFree) {
        this.memFree = memFree;
    }
    
    /**
     * Amount of buffered memory in KB
     */
    @XmlElement(name = "mem_buffers")
    public String getMemBuffers() {
        return memBuffers;
    }

    public void setMemBuffers(String memBuffers) {
        this.memBuffers = memBuffers;
    }
    
    /**
     * Amount of cached memory in KB
     */
    @XmlElement(name = "mem_cached")
    public String getMemCached() {
        return memCached;
    }

    public void setMemCached(String memCached) {
        this.memCached = memCached;
    }
    
    /**
     * Total amount of swap space in KB
     */
    @XmlElement(name = "swap_total")
    public String getSwapTotal() {
        return swapTotal;
    }

    public void setSwapTotal(String swapTotal) {
        this.swapTotal = swapTotal;
    }
    
    /**
     * Amount of available swap memory in KB
     */
    @XmlElement(name = "swap_free")
    public String getSwapFree() {
        return swapFree;
    }

    public void setSwapFree(String swapFree) {
        this.swapFree = swapFree;
    }
    
    /**
     * Last time the system was booted in seconds
     */
    @XmlElement(name = "boot_time")
    public String getBootTime() {
        return bootTime;
    }

    public void setBootTime(String bootTime) {
        this.bootTime = bootTime;
    }
    
    /**
     * Operating system release
     */
    @XmlElement(name = "os_release")
    public String getOsRelease() {
        return osRelease;
    }

    public void setOsRelease(String osRelease) {
        this.osRelease = osRelease;
    }
}
