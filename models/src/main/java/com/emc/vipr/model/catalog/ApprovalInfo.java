package com.emc.vipr.model.catalog;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement
public class ApprovalInfo extends ModelInfo {
    private String message;         // Approval or rejection message
    private Date dateActioned;      // Date approve or reject was performed
    private String status;          // Approval Status. One of PENDING, APPROVED, REJECTED
    private String approvedBy;      // User ID this approval is approved or rejected by
    private Reference order;        // Reference to the order this approval is related to
    private String tenant;          // Tenant for this approval request

    public String getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }

    public Date getDateActioned() {
        return dateActioned;
    }

    public void setDateActioned(Date dateActioned) {
        this.dateActioned = dateActioned;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Reference getOrder() {
        return order;
    }

    public void setOrder(Reference order) {
        this.order = order;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTenant() {
        return tenant;
    }

    public void setTenant(String tenant) {
        this.tenant = tenant;
    }
}
