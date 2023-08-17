package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the appointment database table.
 * 
 */
@Embeddable
public class AppointmentPK implements Serializable {
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable = false, updatable = false)
	private int idbarber;

	@Column(name = "user_id", insertable = false, updatable = false)
	private int userId;

	public AppointmentPK() {
	}

	public int getIdbarber() {
		return this.idbarber;
	}

	public void setIdbarber(int idbarber) {
		this.idbarber = idbarber;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AppointmentPK)) {
			return false;
		}
		AppointmentPK castOther = (AppointmentPK) other;
		return (this.idbarber == castOther.idbarber) && (this.userId == castOther.userId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idbarber;
		hash = hash * prime + this.userId;

		return hash;
	}

	@Override
	public String toString() {
		return "AppointmentPK [idbarber=" + idbarber + ", userId=" + userId + "]";
	}

}