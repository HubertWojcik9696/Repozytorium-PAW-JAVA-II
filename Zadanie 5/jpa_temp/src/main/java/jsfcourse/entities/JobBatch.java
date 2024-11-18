package jsfcourse.entities;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the job_batches database table.
 * 
 */
@Entity
@Table(name="job_batches")
@NamedQuery(name="JobBatch.findAll", query="SELECT j FROM JobBatch j")
public class JobBatch implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Column(name="cancelled_at")
	private int cancelledAt;

	@Column(name="created_at")
	private int createdAt;

	@Lob
	@Column(name="failed_job_ids")
	private String failedJobIds;

	@Column(name="failed_jobs")
	private int failedJobs;

	@Column(name="finished_at")
	private int finishedAt;

	private String name;

	@Lob
	private String options;

	@Column(name="pending_jobs")
	private int pendingJobs;

	@Column(name="total_jobs")
	private int totalJobs;

	public JobBatch() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getCancelledAt() {
		return this.cancelledAt;
	}

	public void setCancelledAt(int cancelledAt) {
		this.cancelledAt = cancelledAt;
	}

	public int getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(int createdAt) {
		this.createdAt = createdAt;
	}

	public String getFailedJobIds() {
		return this.failedJobIds;
	}

	public void setFailedJobIds(String failedJobIds) {
		this.failedJobIds = failedJobIds;
	}

	public int getFailedJobs() {
		return this.failedJobs;
	}

	public void setFailedJobs(int failedJobs) {
		this.failedJobs = failedJobs;
	}

	public int getFinishedAt() {
		return this.finishedAt;
	}

	public void setFinishedAt(int finishedAt) {
		this.finishedAt = finishedAt;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOptions() {
		return this.options;
	}

	public void setOptions(String options) {
		this.options = options;
	}

	public int getPendingJobs() {
		return this.pendingJobs;
	}

	public void setPendingJobs(int pendingJobs) {
		this.pendingJobs = pendingJobs;
	}

	public int getTotalJobs() {
		return this.totalJobs;
	}

	public void setTotalJobs(int totalJobs) {
		this.totalJobs = totalJobs;
	}

}