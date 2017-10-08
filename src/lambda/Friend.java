package lambda;

import java.time.LocalDate;

public class Friend {
	private Person person;
	private LocalDate becameFriends;

	public Person getPerson() {
		return person;
	}
	public void setPerson(Person friend) {
		this.person = friend;
	}
	public LocalDate getBecameFriends() {
		return becameFriends;
	}
	public void setBecameFriends(LocalDate becameFriends) {
		this.becameFriends = becameFriends;
	}


}
