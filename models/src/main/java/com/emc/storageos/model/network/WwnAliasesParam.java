package com.emc.storageos.model.network;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * This is a list of the SAN zones returned from the NetworkSystem.
 */
@XmlRootElement(name="wwn_aliases")
public class WwnAliasesParam {

    private List<? extends WwnAliasParam> aliases;
    private String fabricId;
    
    public WwnAliasesParam() {}

    public WwnAliasesParam(List<? extends WwnAliasParam> aliases) {
        this.aliases = aliases;
    }
    
    /**
     * The identifier of the fabric where the aliases will be added. It can be either
     * the fabric name or its WWN.
     * <p>
     * This field is required for Brocade only. If provided for Cisco it will ignored.
     * @valid none
     */
    @XmlElement(name="fabric_id")
    public String getFabricId() {
        return fabricId;
    }

    /**
     * Sets the fabric identifier which either its name or WWN.
     * @param fabricId
     */
    public void setFabricId(String fabricId) {
        this.fabricId = fabricId;
    }

    /**
     * A list of alias. Each alias has a name and a WWN address
     * @valid none
     */
    @XmlElement(name="wwn_alias")
    public List<? extends WwnAliasParam> getAliases() {
        if (aliases == null) {
            aliases = new ArrayList<WwnAliasParam>();
        }
        return aliases;
    }

    public void setAliases(List<? extends WwnAliasParam> aliases) {
        this.aliases = aliases;
    }
    
}
