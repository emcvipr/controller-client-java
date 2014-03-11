package com.emc.vipr.model.object;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * A list of base URLs
 */
@XmlRootElement(name = "base_urls")
public class BaseUrlList {
    private List<ObjectNamedRelatedResourceRep> baseUrls;

    /**
     * List of base URLs
     * @valid none
     */
    @XmlElement(name="base_url")
    public List<ObjectNamedRelatedResourceRep> getBaseUrls() {
        if (baseUrls == null) {
            baseUrls = new ArrayList<ObjectNamedRelatedResourceRep>();
        }
        return baseUrls;
    }

    public void setBaseUrls(List<ObjectNamedRelatedResourceRep> baseUrls) {
        this.baseUrls = baseUrls;
    }
}
