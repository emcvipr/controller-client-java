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

package com.emc.vipr.model.object;

import com.emc.storageos.model.RestLinkRep;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.net.URI;

@XmlAccessorType(XmlAccessType.PROPERTY)
public class ObjectNamedRelatedResourceRep  extends ObjectRelatedResourceRep {

    private String _name;

    public ObjectNamedRelatedResourceRep() {
    }

    public ObjectNamedRelatedResourceRep(URI id, RestLinkRep selfLink, String name) {
        super(id, selfLink);
        this._name = name;
    }

    /**
     * Object related resource name
     * @valid None
     * @return Name
     */
    @XmlElement(name = "name")
    public String getName() {
        return _name;
    }
    public void setName(String name) {
        _name = name;
    }
}
