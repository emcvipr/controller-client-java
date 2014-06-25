package com.emc.vipr.client.object;

import static com.emc.vipr.client.object.impl.PathConstants.CAS_APPLICATIONS_URL;
import static com.emc.vipr.client.object.impl.PathConstants.CAS_CLUSTERS_URL;
import static com.emc.vipr.client.object.impl.PathConstants.CAS_POOLS_URL;
import static com.emc.vipr.client.object.impl.PathConstants.CAS_PROFILES_URL;
import static com.emc.vipr.client.object.impl.PathConstants.CAS_PROFILE_PEA_URL;
import static com.emc.vipr.client.object.impl.PathConstants.ID_PATH;

import java.net.URI;
import java.util.List;

import com.emc.vipr.client.core.util.ResourceUtils;
import com.emc.vipr.client.impl.RestClient;
import com.emc.vipr.model.object.cashead.CasClusterCreateParam;
import com.emc.vipr.model.object.cashead.CasClusterInfoRep;
import com.emc.vipr.model.object.cashead.CasClusterListRep;
import com.emc.vipr.model.object.cashead.CasClusterRep;
import com.emc.vipr.model.object.cashead.CasClusterUpdateParam;
import com.emc.vipr.model.object.cashead.CasPoolCreateParam;
import com.emc.vipr.model.object.cashead.CasPoolInfoRep;
import com.emc.vipr.model.object.cashead.CasPoolListRep;
import com.emc.vipr.model.object.cashead.CasPoolRep;
import com.emc.vipr.model.object.cashead.CasPoolUpdateParam;
import com.emc.vipr.model.object.cashead.CasProfileCreateParam;
import com.emc.vipr.model.object.cashead.CasProfileInfoRep;
import com.emc.vipr.model.object.cashead.CasProfileListRep;
import com.emc.vipr.model.object.cashead.CasProfileRep;
import com.emc.vipr.model.object.cashead.CasProfileUpdateParam;
import com.emc.vipr.model.object.cashead.CasRegisteredApplication;
import com.emc.vipr.model.object.cashead.CasRegisteredApplicationListRep;

public class CasHead {
    private RestClient client;

    public CasHead(RestClient client) {
        this.client = client;
    }

    /**
     * Gets the list of CAS clusters.
     * <p>
     * API Call: <tt>GET /dataservice/cas-cluster</tt>
     * 
     * @return the list of CAS clusters.
     */
    public List<CasClusterInfoRep> getClusters() {
        CasClusterListRep list = client.get(CasClusterListRep.class, CAS_CLUSTERS_URL);
        return ResourceUtils.defaultList(list != null ? list.getCasClusters() : null);
    }

    /**
     * Gets a CAS cluster by ID.
     * <p>
     * API Call: <tt>GET /dataservice/cas-cluster/{id}</tt>
     * 
     * @return the CAS cluster.
     */
    public CasClusterInfoRep getCluster(URI id) {
        return client.get(CasClusterInfoRep.class, CAS_CLUSTERS_URL + ID_PATH, id);
    }

    /**
     * Creates a CAS cluster.
     * <p>
     * API Call: <tt>POST /dataservice/cas-cluster</tt>
     * 
     * @param create
     *        the cluster create configuration.
     * @return a reference to the created cluster.
     */
    public CasClusterRep createCluster(CasClusterCreateParam create) {
        return client.post(CasClusterRep.class, create, CAS_CLUSTERS_URL);
    }

    /**
     * Updates a CAS cluster.
     * <p>
     * API Call: <tt>PUT /dataservice/cas-cluster/{id}</tt>
     * 
     * @param id
     *        the cluster ID.
     * @param update
     *        the cluster update configuration.
     * @return a reference to the updated cluster.
     */
    public CasClusterRep updateCluster(URI id, CasClusterUpdateParam update) {
        return client.put(CasClusterRep.class, update, CAS_CLUSTERS_URL + ID_PATH, id);
    }

    /**
     * Gets the list of CAS profiles within the specified cluster.
     * <p>
     * API Call: <tt>GET /dataservice/cas-cluster/{clusterId}/profile</tt>
     * 
     * @param clusterId
     *        the cluster ID.
     * @return the list of CAS profiles in the cluster.
     */
    public List<CasProfileInfoRep> getProfiles(URI clusterId) {
        CasProfileListRep list = client.get(CasProfileListRep.class, CAS_PROFILES_URL, clusterId);
        return ResourceUtils.defaultList(list != null ? list.getCasProfiles() : null);
    }

    /**
     * Gets a CAS profile within a cluster by name.
     * <p>
     * API Call: <tt>GET /dataservice/cas-cluster/{clusterId}/profile/{profileName}</tt>
     * 
     * @param clusterId
     *        the cluster ID.
     * @param profileName
     *        the name of the profile.
     * @return the CAS profile.
     */
    public CasProfileInfoRep getProfile(URI clusterId, String profileName) {
        return client.get(CasProfileInfoRep.class, CAS_PROFILES_URL + ID_PATH, clusterId, profileName);
    }

    /**
     * Create a CAS profile within the given cluster.
     * <p>
     * API Call: <tt>POST /dataservice/cas-cluster/{clusterId}/profile</tt>
     * 
     * @param clusterId
     *        the cluster ID.
     * @param create
     *        the profile create configuration.
     * @return a reference to the created profile.
     */
    public CasProfileRep createProfile(URI clusterId, CasProfileCreateParam create) {
        return client.post(CasProfileRep.class, create, CAS_PROFILES_URL, clusterId);
    }

    /**
     * Updates a CAS profile within the given cluster.
     * <p>
     * API Call: <tt>PUT /dataservice/cas-cluster/{clusterId}/profile/{profileName}</tt>
     * 
     * @param clusterId
     *        the cluster ID.
     * @param profileName
     *        the name of the profile to update.
     * @param create
     *        the profile update configuration.
     * @return a reference to the updated profile.
     */
    public CasProfileRep updateProfile(URI clusterId, String profileName, CasProfileUpdateParam update) {
        return client.put(CasProfileRep.class, update, CAS_PROFILES_URL + ID_PATH, clusterId, profileName);
    }

    /**
     * Gets the list of CAS pools within a cluster.
     * <p>
     * API Call: <tt>GET /dataservice/cas-cluster/{clusterId}/pool</tt>
     * 
     * @param clusterId
     *        the cluster ID.
     * @return the list of CAS pools within the cluster.
     */
    public List<CasPoolInfoRep> getPools(URI clusterId) {
        CasPoolListRep list = client.get(CasPoolListRep.class, CAS_POOLS_URL, clusterId);
        return ResourceUtils.defaultList(list != null ? list.getCasPools() : null);
    }

    /**
     * Gets a CAS pool within a cluster.
     * <p>
     * API Call: <tt>GET /dataservice/cas-cluster/{clusterId}/pool/{poolName}</tt>
     * 
     * @param clusterId
     *        the cluster ID.
     * @param poolName
     *        the name of the pool.
     * @return the CAS pool within the cluster.
     */
    public CasPoolInfoRep getPool(URI clusterId, String poolName) {
        return client.get(CasPoolInfoRep.class, CAS_POOLS_URL + ID_PATH, clusterId, poolName);
    }

    /**
     * Creates a CAS pool within a cluster.
     * <p>
     * API Call: <tt>POST /dataservice/cas-cluster/{clusterId}/pool</tt>
     * 
     * @param clusterId
     *        the cluster ID.
     * @param create
     *        the create pool configuration.
     * @return a reference to the created pool.
     */
    public CasPoolRep createPool(URI clusterId, CasPoolCreateParam create) {
        return client.post(CasPoolRep.class, create, CAS_POOLS_URL, clusterId);
    }

    /**
     * Updates a CAS pool within a cluster.
     * <p>
     * API Call: <tt>PUT /dataservice/cas-cluster/{clusterId}/pool/{poolName}</tt>
     * 
     * @param clusterId
     *        the cluster ID.
     * @param poolName
     *        the name of the pool to update.
     * @param update
     *        the update pool configuration.
     * @return a reference to the updated pool.
     */
    public CasPoolRep updatePool(URI clusterId, String poolName, CasPoolUpdateParam update) {
        return client.put(CasPoolRep.class, update, CAS_POOLS_URL + ID_PATH, clusterId, poolName);
    }

    public String getProfilePea(URI clusterId, String profileName) {
        return client.get(String.class, CAS_PROFILE_PEA_URL, clusterId, profileName);
    }

    public List<CasRegisteredApplication> getRegisteredApplications(URI clusterId) {
        CasRegisteredApplicationListRep list = client.get(CasRegisteredApplicationListRep.class, CAS_APPLICATIONS_URL,
                clusterId);
        return ResourceUtils.defaultList(list != null ? list.getCasRegisteredApplications() : null);
    }
}
