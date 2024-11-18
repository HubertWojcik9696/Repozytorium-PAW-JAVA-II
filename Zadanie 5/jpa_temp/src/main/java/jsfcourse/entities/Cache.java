package jsfcourse.entities;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the cache database table.
 * 
 */
@Entity
@NamedQuery(name="Cache.findAll", query="SELECT c FROM Cache c")
public class Cache implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String key;

	private int expiration;

	@Lob
	private String value;

	public Cache() {
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

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}