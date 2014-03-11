package com.emc.vipr.client.core.util;

import java.net.URI;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import com.emc.storageos.model.StringHashMapEntry;
import com.emc.storageos.model.adapters.StringSetMapAdapter.Entry;

/**
 * Unmanaged volumes API is pretty poor. Need utilities to process key/value pairs as there is no concrete
 * fields. Hope they don't change the field names.
 */
public class UnmanagedHelper {
    public static final String IS_INGESTABLE = "IS_INGESTABLE";
    public static final String SUPPORTED_VPOOL_LIST = "SUPPORTED_VPOOL_LIST";

    public static Set<URI> getVpoolsForUnmanaged(List<Entry> infoEntries, List<StringHashMapEntry> characteristicsEntries) {
        Set<URI> results = new HashSet<URI>();

        // Only return vpools which this can import if this is supported for ingestion
        if (!isSupportedForIngest(characteristicsEntries)) {
            return results;
        }

        for (Entry entry: infoEntries) {
            if (SUPPORTED_VPOOL_LIST.equals(entry.getKey())) {
                results.add(URI.create(entry.getValue()));
            }
        }
        return results;
    }

    public static boolean isSupportedForIngest(List<StringHashMapEntry> entries) {
        boolean isIngestable = getValue(entries, IS_INGESTABLE, true);
        return isIngestable;
    }

    private static String getValue(List<StringHashMapEntry> entries, String key) {
        for (StringHashMapEntry entry: entries) {
            if ((key != null && key.length() > 0) && key.equals(entry.getName())) {
                return entry.getValue();
            }
        }
        return "";
    }

    private static boolean getValue(List<StringHashMapEntry> entries, String key, boolean defaultValue) {
        String value = getValue(entries, key);
        try {
            return Boolean.parseBoolean(value);
        }
        catch (Exception e) {
            // nothing to do here. We'll just return 0;
        }
        return defaultValue;
    }
}
