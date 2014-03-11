package com.emc.vipr.model.catalog;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ExecutionWindowInfo extends ModelInfo {
    private Integer hourOfDayInUTC;                     // Hour of the day for this execution window
    private Integer minuteOfHourInUTC;                  // Minute of the day for this execution window
    private Integer executionWindowLength;              // Length of this execution window
    private String executionWindowLengthType;           // Length type of the execution window: MINUTES, HOURS, DAYS
    private String executionWindowType;                 // Type of the execution window: DAILY, WEEKLY, MONTHLY
    private Integer dayOfWeek;                          // Day of the week for this execution window
    private Integer dayOfMonth;                         // Day of the month for this execution window
    private Boolean lastDayOfMonth = Boolean.FALSE;     // Indicates the day of the week is the last day of the month
    private String tenant;                              // Tenant that this execution window applies to
    private String label;                               // Label for this execution window

    public Integer getHourOfDayInUTC() {
        return hourOfDayInUTC;
    }

    public void setHourOfDayInUTC(Integer hourOfDayInUTC) {
        this.hourOfDayInUTC = hourOfDayInUTC;
    }

    public Integer getMinuteOfHourInUTC() {
        return minuteOfHourInUTC;
    }

    public void setMinuteOfHourInUTC(Integer minuteOfHourInUTC) {
        this.minuteOfHourInUTC = minuteOfHourInUTC;
    }

    public Integer getExecutionWindowLength() {
        return executionWindowLength;
    }

    public void setExecutionWindowLength(Integer executionWindowLength) {
        this.executionWindowLength = executionWindowLength;
    }

    public String getExecutionWindowLengthType() {
        return executionWindowLengthType;
    }

    public void setExecutionWindowLengthType(String executionWindowLengthType) {
        this.executionWindowLengthType = executionWindowLengthType;
    }

    public String getExecutionWindowType() {
        return executionWindowType;
    }

    public void setExecutionWindowType(String executionWindowType) {
        this.executionWindowType = executionWindowType;
    }

    public Integer getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(Integer dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public Integer getDayOfMonth() {
        return dayOfMonth;
    }

    public void setDayOfMonth(Integer dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }

    public Boolean getLastDayOfMonth() {
        return lastDayOfMonth;
    }

    public void setLastDayOfMonth(Boolean lastDayOfMonth) {
        this.lastDayOfMonth = lastDayOfMonth;
    }

    public String getTenant() {
        return tenant;
    }

    public void setTenant(String tenant) {
        this.tenant = tenant;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
