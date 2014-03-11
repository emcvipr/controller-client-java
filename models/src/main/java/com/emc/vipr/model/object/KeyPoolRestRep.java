package com.emc.vipr.model.object;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.net.URI;

@XmlRootElement(name = "keypool")
public class KeyPoolRestRep {

    private URI _project;
    private String _apiType;
    private URI _objectCos;

    public KeyPoolRestRep() {
    }

    public KeyPoolRestRep(URI project, String apiType, URI objectCos){
        _project = project;
        _apiType = apiType;
        _objectCos = objectCos;
    }

    /**
     * Project associated with the keypool
     * @valid None
     * @return Project
     */
    @XmlElement(name = "project")
    public URI getProject() {
        return _project;
    }

    /**
     * Object vpool associated with the keypool
     * @valid None
     * @return vPool
     * */
    @XmlElement(name = "object_cos")
    public URI getObjectCos() {
        return _objectCos;
    }

    /**
     * api to access this keypool
     * @valid None
     * @return API type
     * */
    @XmlElement(name = "api_type")
    public String getApiType() {
        return _apiType;
    }

    public void setApiType(String _apiType) {
        this._apiType = _apiType;
    }

    public void setObjectCos(URI _objectCos) {
        this._objectCos = _objectCos;
    }

    public void setProject(URI _project) {
        this._project = _project;
    }
}
