package jsfcourse.entities;

import java.io.Serializable;
import jakarta.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the password_reset_tokens database table.
 * 
 */
@Entity
@Table(name="password_reset_tokens")
@NamedQuery(name="PasswordResetToken.findAll", query="SELECT p FROM PasswordResetToken p")
public class PasswordResetToken implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String email;

	@Column(name="created_at")
	private Timestamp createdAt;

	private String token;

	public PasswordResetToken() {
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Timestamp getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}