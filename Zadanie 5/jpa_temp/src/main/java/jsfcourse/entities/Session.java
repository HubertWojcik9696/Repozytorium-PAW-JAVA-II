package jsfcourse.entities;

import java.io.Serializable;
import jakarta.persistence.*;
import java.math.BigInteger;


/**
 * The persistent class for the sessions database table.
 * 
 */
@Entity
@Table(name="sessions")
@NamedQuery(name="Session.findAll", query="SELECT s FROM Session s")
public class Session implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Column(name="ip_address")
	private String ipAddress;

	@Column(name="last_activity")
	private int lastActivity;

	@Lob
	private String payload;

	@Lob
	@Column(name="user_agent")
	private String userAgent;

	@Column(name="user_id")
	private BigInteger userId;

	public Session() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIpAddress() {
		return this.ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public int getLastActivity() {
		return this.lastActivity;
	}

	public void setLastActivity(int lastActivity) {
		this.lastActivity = lastActivity;
	}

	public String getPayload() {
		return this.payload;
	}

	public void setPayload(String payload) {
		this.payload = payload;
	}

	public String getUserAgent() {
		return this.userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public BigInteger getUserId() {
		return this.userId;
	}

	public void setUserId(BigInteger userId) {
		this.userId = userId;
	}

}