package com.emc.vipr.client.object.util;

import com.emc.vipr.model.object.ObjectRelatedResourceRep;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ObjectResourceUtils {
    /**
     * Gets the ID of a reference, null safe.
     *
     * @param ref
     *        the resource reference.
     * @return the ID.
     */
    public static URI id(ObjectRelatedResourceRep ref) {
        return ref != null ? ref.getId() : null;
    }

    /**
     * Gets a list of IDs of data objects, null safe.
     *
     * @param refs
     *        list of resource references.
     * @return List of IDs.
     */
    public static List<URI> refIds(Collection<? extends ObjectRelatedResourceRep> refs) {
        List<URI> ids = new ArrayList<URI>();
        if (refs != null) {
            for (ObjectRelatedResourceRep ref : refs) {
                ids.add(ref.getId());
            }
        }
        return ids;
    }
}
