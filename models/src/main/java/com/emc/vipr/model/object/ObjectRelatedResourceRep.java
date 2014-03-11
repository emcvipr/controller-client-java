package com.emc.vipr.model.object;

import com.emc.storageos.model.RestLinkRep;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.net.URI;

/**
 * Information about related resource representations
 */
@XmlAccessorType(XmlAccessType.PROPERTY)
public class ObjectRelatedResourceRep {
    private URI _id;
    private RestLinkRep _selfLink;

    public ObjectRelatedResourceRep() {
    }

    public ObjectRelatedResourceRep(URI id, RestLinkRep selfLink) {
        this._id = id;
        this._selfLink = selfLink;
    }

    /**
     * Object related resource Id
     * @valid None
     * @return Id
     */
    @XmlElement(name = "id")
    public URI getId()  {
        return _id;
    }
    public void setId(URI id)  {
        _id = id;
    }

    @XmlElement(name = "link")
    public RestLinkRep getLink(){
        return _selfLink;
    }
    public void setLink(RestLinkRep link) {
        _selfLink = link;
    }

}
