package com.emc.vipr.model.object.zone;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * vdc insert parameters
 */
@XmlRootElement(name = "vdc_insert")
public class VdcInsertParam {
    private String vdcName;
    private String dataEndPoints;
    private String cmdEndPoints;
    private String secretKeys;
    private String secretNewKeys;

    @XmlElement
    public String getVdcName() {
        return vdcName;
    }

    public void setVdcName(String vdcName) {
        this.vdcName = vdcName;
    }

    @XmlElement
    public String getDataEndPoints() {
        return dataEndPoints;
    }

    public void setDataEndPoints(String dataEndPoints) {
        this.dataEndPoints = dataEndPoints;
    }

    @XmlElement
    public String getCmdEndPoints() {
        return cmdEndPoints;
    }

    public void setCmdEndPoints(String cmdEndPoints) {
        this.cmdEndPoints = cmdEndPoints;
    }

    @XmlElement
    public String getSecretKeys() {
        return secretKeys;
    }

    public void setSecretKeys(String secretKeys) {
        this.secretKeys = secretKeys;
    }

    @XmlElement
    public String getSecretNewKeys() {
        return secretNewKeys;
    }

    public void setSecretNewKeys(String secretNewKeys) {
        this.secretNewKeys = secretNewKeys;
    }
}
