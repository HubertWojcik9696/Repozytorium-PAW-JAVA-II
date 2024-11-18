package jsfcourse.entities;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the cache_locks database table.
 * 
 */
@Entity
@Table(name="cache_locks")
@NamedQuery(name="CacheLock.findAll", query="SELECT c FROM CacheLock c")
public class CacheLock implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String key;

	private int expiration;

	private String owner;

	public CacheLock() {
	}

	public String getKey() {
		return this.key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public int getExpiration() {
		return this.expiration;
	}

	public void setExpiration(int expiration) {
		this.expiration = expiration;
	}

	public String getOwner() {
		return this.owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

}