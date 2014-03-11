/**
 * Copyright (c) 2013 EMC Corporation
 * All Rights Reserved
 *
 * This software contains the intellectual property of EMC Corporation
 * or is licensed to EMC Corporation from third parties.  Use of this
 * software and the intellectual property contained therein is expressly
 * limited to the terms and conditions of the License Agreement under which
 * it is provided by or on behalf of EMC.
 */
package com.emc.vipr.model.sys.eventhandler;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "connectemc_email")
public class ConnectEmcEmail extends ConnectEmcEmailFtpsBase {

    private String emailServer;
    private String port;
    private String primaryEmailAddress;
    private String notifyEmailAddress;
    private String emailSender;
    private String smtpAuthType;
    private String userName;
    private String password;
    private String startTls;
    private String enableTlsCert;

    // SMTP Authorization Types.
    private final static String LOGIN = "login";
    private final static String CRAM_MD5 = "cram-md5";
    private final static String PLAIN = "plain";

    @XmlElement(name = "email_server")
    public String getEmailServer() {
        return emailServer;
    }

    public void setEmailServer(String emailServer) {
        this.emailServer = emailServer;
    }

    @XmlElement(name = "port")
    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }
    
    @XmlElement(name = "primary_email_address")
    public String getPrimaryEmailAddress() {
        return primaryEmailAddress;
    }

    public void setPrimaryEmailAddress(String primaryEmailAddress) {
        this.primaryEmailAddress = primaryEmailAddress;
    }

    @XmlElement(name = "notify_email_address")
    public String getNotifyEmailAddress() {
        return notifyEmailAddress;
    }

    public void setNotifyEmailAddress(String notifyEmailAddress) {
        this.notifyEmailAddress = notifyEmailAddress;
    }

    @XmlElement(name = "email_sender")
    public String getEmailSender() {
        return emailSender;
    }

    public void setEmailSender(String emailSender) {
        this.emailSender = emailSender;
    }

    @XmlElement(name = "smtp_auth_type")
    public String getSmtpAuthType() {
        return smtpAuthType;
    }

    public void setSmtpAuthType(String smtpAuthType) {
        if (smtpAuthType == null || smtpAuthType.isEmpty()
                || smtpAuthType.equalsIgnoreCase(LOGIN)
                || smtpAuthType.equalsIgnoreCase(CRAM_MD5)
                || smtpAuthType.equalsIgnoreCase(PLAIN)) {
            this.smtpAuthType = smtpAuthType;
        } else {
            this.smtpAuthType = PLAIN;
        }
    }

    @XmlElement(name = "username")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @XmlElement(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @XmlElement(name = "start_tls_ind")
    public String getStartTls() {
        return startTls;
    }

    // Must be yes or no, default to no.
    public void setStartTls(String startTls) {
        this.startTls = (startTls != null
                && startTls.trim().equalsIgnoreCase(YES) ? YES.toLowerCase()
                : NO.toLowerCase());
    }

    @XmlElement(name = "enable_tls_cert")
    public String getEnableTlsCert() {
        return enableTlsCert;
    }

    public void setEnableTlsCert(String enableTlsCert) {
        this.enableTlsCert = enableTlsCert;
    }
}
