package com.emc.storageos.model.host;

import com.emc.storageos.model.valid.Endpoint;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Request PUT parameter for host update operation.
 */
@XmlRootElement(name = "host_update")
public class HostUpdateParam extends HostParam {
}
