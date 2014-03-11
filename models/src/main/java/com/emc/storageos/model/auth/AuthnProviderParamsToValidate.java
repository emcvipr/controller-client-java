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
package com.emc.storageos.model.auth;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElementWrapper;

/**
 * Container class to store parameters to validate an authnprovider.
 * This is a subset of what can be found in AuthnBaseParam, CreateParam, UpdateParam
 */
@XmlRootElement(name = "authnprovider_validate")
public class AuthnProviderParamsToValidate {

    private String managerDN;
    private String managerPwd;
    private List<String> urls;
    private String searchBase;
    private String mode;
    private String groupAttr;

    public AuthnProviderParamsToValidate() {}
    
    public AuthnProviderParamsToValidate(String managerDN, String managerPwd,
            List<String> urls, String searchBase) {
        this.managerDN = managerDN;
        this.managerPwd = managerPwd;
        this.urls = urls;
        this.searchBase = searchBase;
    }
    
    public AuthnProviderParamsToValidate(String managerDN, String managerPwd,
            String searchBase) {
        this.managerDN = managerDN;
        this.managerPwd = managerPwd;
        this.searchBase = searchBase;
    }

    @XmlElement(name = "manager_dn_validate")
    public String getManagerDN() {
        return managerDN;
    }

    public void setManagerDN(String managerDN) {
        this.managerDN = managerDN;
    }

    @XmlElement(name = "manager_pwd_validate")
    public String getManagerPwd() {
        return managerPwd;
    }

    public void setManagerPwd(String managerPwd) {
        this.managerPwd = managerPwd;
    }

    @XmlElementWrapper(name = "server_urls_validate")
    public List<String> getUrls() {
        if (urls == null) {
            urls = new ArrayList<String>();
        }
        return urls;
    }

    public void setUrls(List<String> urls) {
        this.urls = urls;
    }

    @XmlElement(name = "search_base_validate")
    public String getSearchBase() {
        return searchBase;
    }

    public void setSearchBase(String searchBase) {
        this.searchBase = searchBase;
    }
    
    @XmlElement(name = "mode_validate")
    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    @XmlElement(name = "group_attr_validate")
    public String getGroupAttr() {
        return groupAttr;
    }

    public void setGroupAttr(String groupAttr) {
        this.groupAttr = groupAttr;
    }
}
