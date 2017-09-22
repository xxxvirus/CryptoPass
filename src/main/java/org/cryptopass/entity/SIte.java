package org.cryptopass.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class SIte {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nameOfS;
	private String loginOnS;
	private String pass;
	@ManyToOne
	private User user;
	@OneToOne
	@JoinColumn(name = "aes_id")
	private KeyAES keyAES;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameOfS() {
		return nameOfS;
	}

	public void setNameOfS(String nameOfS) {
		this.nameOfS = nameOfS;
	}

	public String getLoginOnS() {
		return loginOnS;
	}

	public void setLoginOnS(String loginOnS) {
		this.loginOnS = loginOnS;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public KeyAES getKeyAES() {
		return keyAES;
	}

	public void setKeyAES(KeyAES keyAES) {
		this.keyAES = keyAES;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SIte other = (SIte) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
