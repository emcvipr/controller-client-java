/*
 * Copyright (c) 2014 EMC Corporation
 * All Rights Reserved
 *
 * This software contains the intellectual property of EMC Corporation
 * or is licensed to EMC Corporation from third parties.  Use of this
 * software and the intellectual property contained therein is expressly
 * limited to the terms and conditions of the License Agreement under which
 * it is provided by or on behalf of EMC.
 */

package com.emc.vipr.model.object.cashead;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * A single entry in Application Registration.
 *
 * App registration is a feature of CAS Head that allows to keep track on what clients connected to server via CAS API.
 * For each combination of application/app version/sdk version/hostname/profile and os we keep a record with information
 * about number of authentications and time of first and last successful authentications.
 *
 * This information can't be changed via REST API, it is updated only by head. List of app registration entries is stored
 * namespace head metadata.
 */
@XmlRootElement(name = "cas_registered_application")
public class CasRegisteredApplication {

    private String applicationId;
    private String applicationVersion;
    private String sdkVersion;
    private String hostname;
    private String profile;
    private String os;

    private int numberOfAuthentications;
    private long firstAuthentication;
    private long latestAuthentication;

    public CasRegisteredApplication(String applicationId, String applicationVersion, String sdkVersion,
                                    String hostname, String profile, String os, int numberOfAuthentications,
                                    long firstAuthentication, long latestAuthentication) {
        this.applicationId = applicationId;
        this.applicationVersion = applicationVersion;
        this.sdkVersion = sdkVersion;
        this.hostname = hostname;
        this.profile = profile;
        this.os = os;
        this.numberOfAuthentications = numberOfAuthentications;
        this.firstAuthentication = firstAuthentication;
        this.latestAuthentication = latestAuthentication;
    }

    public CasRegisteredApplication() {

    }


    /**
     * Application ID. Can be set via CAS API. May be empty.
     */
    @XmlElement(name = "application_id")
    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    /**
     * Application version. Can be set via CAS API. May be empty.
     */
    @XmlElement(name = "application_version")
    public String getApplicationVersion() {
        return applicationVersion;
    }

    public void setApplicationVersion(String applicationVersion) {
        this.applicationVersion = applicationVersion;
    }

    /**
     * SDK version used by application to connect to CAS head.
     */
    @XmlElement(name = "sdk_version")
    public String getSdkVersion() {
        return sdkVersion;
    }

    public void setSdkVersion(String sdkVersion) {
        this.sdkVersion = sdkVersion;
    }

    /**
     * Hostname of the client used to access CAS head.
     */
    @XmlElement(name = "hostname")
    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    /**
     * Profile name used to access CAS head
     */
    @XmlElement(name = "profile")
    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    /**
     * Operation system of the client
     */
    @XmlElement(name = "os")
    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    /**
     * Number of authentications for this app registration entry
     */
    @XmlElement(name = "authentications")
    public int getNumberOfAuthentications() {
        return numberOfAuthentications;
    }

    public void setNumberOfAuthentications(int numberOfAuthentications) {
        this.numberOfAuthentications = numberOfAuthentications;
    }

    /**
     * Timestamp of the first authentication
     */
    @XmlElement(name = "first_authentication")
    public long getFirstAuthentication() {
        return firstAuthentication;
    }

    public void setFirstAuthentication(long firstAuthentication) {
        this.firstAuthentication = firstAuthentication;
    }

    /**
     * Timestamp of the latest authentication
     */
    @XmlElement(name = "latest_authentication")
    public long getLatestAuthentication() {
        return latestAuthentication;
    }

    public void setLatestAuthentication(long latestAuthentication) {
        this.latestAuthentication = latestAuthentication;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) {
            return true;
        }
        if(o == null || getClass() != o.getClass()) {
            return false;
        }

        CasRegisteredApplication that = (CasRegisteredApplication) o;

        if(firstAuthentication != that.firstAuthentication) {
            return false;
        }
        if(latestAuthentication != that.latestAuthentication) {
            return false;
        }
        if(numberOfAuthentications != that.numberOfAuthentications) {
            return false;
        }
        if(applicationId != null ? !applicationId.equals(that.applicationId) : that.applicationId != null) {
            return false;
        }
        if(applicationVersion != null ? !applicationVersion.equals(that.applicationVersion) : that.applicationVersion
                != null) {
            return false;
        }
        if(hostname != null ? !hostname.equals(that.hostname) : that.hostname != null) {
            return false;
        }
        if(os != null ? !os.equals(that.os) : that.os != null) {
            return false;
        }
        if(profile != null ? !profile.equals(that.profile) : that.profile != null) {
            return false;
        }
        if(sdkVersion != null ? !sdkVersion.equals(that.sdkVersion) : that.sdkVersion != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = applicationId != null ? applicationId.hashCode() : 0;
        result = 31 * result + (applicationVersion != null ? applicationVersion.hashCode() : 0);
        result = 31 * result + (sdkVersion != null ? sdkVersion.hashCode() : 0);
        result = 31 * result + (hostname != null ? hostname.hashCode() : 0);
        result = 31 * result + (profile != null ? profile.hashCode() : 0);
        result = 31 * result + (os != null ? os.hashCode() : 0);
        result = 31 * result + numberOfAuthentications;
        result = 31 * result + (int) (firstAuthentication ^ (firstAuthentication >>> 32));
        result = 31 * result + (int) (latestAuthentication ^ (latestAuthentication >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "CasRegisteredApplication{" +
                "applicationId='" + applicationId + '\'' +
                ", applicationVersion='" + applicationVersion + '\'' +
                ", sdkVersion='" + sdkVersion + '\'' +
                ", hostname='" + hostname + '\'' +
                ", profile='" + profile + '\'' +
                ", os='" + os + '\'' +
                ", numberOfAuthentications=" + numberOfAuthentications +
                ", firstAuthentication=" + firstAuthentication +
                ", latestAuthentication=" + latestAuthentication +
                '}';
    }
}
