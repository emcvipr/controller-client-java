package com.emc.vipr.model.catalog;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Parameter {
    private String label;                       // Label or key for this parameter to an order
    private String value;                       // Actual value for this parameter (often times an ID)
    private String friendlyValue;               // User friendly text value representing the choice (often the label)

    public Parameter() {
    }

    public Parameter(String label, String value, String friendlyValue) {
        this.label = label;
        this.value = value;
        this.friendlyValue = friendlyValue;
    }

    @Override
    public String toString() {
        return String.format("%s %s", label, value);
    }

    public String getFriendlyValue() {
        return friendlyValue;
    }

    public void setFriendlyValue(String friendlyValue) {
        this.friendlyValue = friendlyValue;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
