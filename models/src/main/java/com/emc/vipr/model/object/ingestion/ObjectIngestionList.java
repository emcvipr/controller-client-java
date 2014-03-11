package com.emc.vipr.model.object.ingestion;

import com.emc.vipr.model.object.ObjectNamedRelatedResourceRep;
import com.emc.vipr.model.object.ObjectRelatedResourceRep;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * List of ingestion tasks
 */
@XmlRootElement(name = "object_ingestions")
public class ObjectIngestionList {
    private List<ObjectRelatedResourceRep> objectIngestions =
            new ArrayList<ObjectRelatedResourceRep>();

    /**
     * A list of ingestion tasks
     * @valid None
     */
    @XmlElement(name = "object_ingestion")
    public List<ObjectRelatedResourceRep> getObjectIngestions() {
        return objectIngestions;
    }

    public void setObjectIngestions(List<ObjectRelatedResourceRep> objectIngestions) {
        this.objectIngestions = objectIngestions;
    }

}
