package jsfcourse.entities;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the jobs database table.
 * 
 */
@Entity
@Table(name="jobs")
@NamedQuery(name="Job.findAll", query="SELECT j FROM Job j")
public class Job implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	private byte attempts;

	@Column(name="available_at")
	private int availableAt;

	@Column(name="created_at")
	private int createdAt;

	@Lob
	private String payload;

	private String queue;

	@Column(name="reserved_at")
	private int reservedAt;

	public Job() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public byte getAttempts() {
		return this.attempts;
	}

	public void setAttempts(byte attempts) {
		this.attempts = attempts;
	}

	public int getAvailableAt() {
		return this.availableAt;
	}

	public void setAvailableAt(int availableAt) {
		this.availableAt = availableAt;
	}

	public int getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(int createdAt) {
		this.createdAt = createdAt;
	}

	public String getPayload() {
		return this.payload;
	}

	public void setPayload(String payload) {
		this.payload = payload;
	}

	public String getQueue() {
		return this.queue;
	}

	public void setQueue(String queue) {
		this.queue = queue;
	}

	public int getReservedAt() {
		return this.reservedAt;
	}

	public void setReservedAt(int reservedAt) {
		this.reservedAt = reservedAt;
	}

}