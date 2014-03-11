package com.emc.storageos.model.host;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Request POST parameter for host initiator creation.
 */
@XmlRootElement(name = "initiator_create")
public class InitiatorCreateParam extends BaseInitiatorParam {
}
