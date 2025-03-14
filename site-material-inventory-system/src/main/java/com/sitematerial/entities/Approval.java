package com.sitematerial.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Approvals")
public class Approval {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer approvalID;

    @ManyToOne
    @JoinColumn(name = "requestID")
    private MaterialRequest request;

    @ManyToOne
    @JoinColumn(name = "approvedBy")
    private User approvedBy;

    private LocalDate approvedDate;
    private String comments;

    public Approval() {
		// TODO Auto-generated constructor stub
	}

	public Approval(Integer approvalID, MaterialRequest request, User approvedBy, LocalDate approvedDate,
			String comments) {
		super();
		this.approvalID = approvalID;
		this.request = request;
		this.approvedBy = approvedBy;
		this.approvedDate = approvedDate;
		this.comments = comments;
	}

	public Integer getApprovalID() {
		return approvalID;
	}

	public void setApprovalID(Integer approvalID) {
		this.approvalID = approvalID;
	}

	public MaterialRequest getRequest() {
		return request;
	}

	public void setRequest(MaterialRequest request) {
		this.request = request;
	}

	public User getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(User approvedBy) {
		this.approvedBy = approvedBy;
	}

	public LocalDate getApprovedDate() {
		return approvedDate;
	}

	public void setApprovedDate(LocalDate approvedDate) {
		this.approvedDate = approvedDate;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "Approval [approvalID=" + approvalID + ", request=" + request + ", approvedBy=" + approvedBy
				+ ", approvedDate=" + approvedDate + ", comments=" + comments + "]";
	}
    
}
