package com.emc.vipr.client.core;

import com.emc.storageos.model.auth.RoleAssignmentChanges;
import com.emc.storageos.model.auth.RoleAssignmentEntry;
import com.emc.storageos.model.auth.RoleAssignments;
import static com.emc.vipr.client.core.impl.PathConstants.*;

import com.emc.storageos.model.vpool.VDCCapacities;
import com.emc.vipr.client.impl.RestClient;
import com.emc.vipr.client.core.util.ResourceUtils;
import java.util.List;

public class VirtualDataCenter {
    protected final RestClient client;

    public VirtualDataCenter(RestClient client) {
        this.client = client;
    }

    protected String getRoleAssignmentsUrl() {
        return VDC_URL + ROLE_ASSIGNMENT_PATH;
    }

    /**
     * Gets the Capacities for the Virtual Data Center.
     * <p>
     * API Call: <tt>GET /vdc/capacities</tt>
     *
     * @return The VDC Capacities
     */
    public VDCCapacities getCapacities() {
        return client.get(VDCCapacities.class, VDC_CAPACITIES_URL);
    }

    /**
     * Get Role Assignments for the VDC.
     *
     * @return the list of RoleAssignmentEntry
     */
    public List<RoleAssignmentEntry> getRoleAssignments() {
        RoleAssignments response = client.get(RoleAssignments.class, getRoleAssignmentsUrl());
        return ResourceUtils.defaultList(response.getAssignments());
    }

    /**
     * Update Role Assignments for the VDC.
     *
     * @param roleChanges
     *        Role assignment changes
     * @return the list of RoleAssignmentEntry
     */
    public List<RoleAssignmentEntry> updateRoleAssignments(RoleAssignmentChanges roleChanges) {
        RoleAssignments response = client.put(RoleAssignments.class, roleChanges, getRoleAssignmentsUrl());
        return ResourceUtils.defaultList(response.getAssignments());
    }
}
