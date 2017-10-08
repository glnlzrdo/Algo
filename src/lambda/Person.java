package lambda;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Person {

	public enum Gender { MALE, FEMALE }

	private Name name;
	private LocalDate birhtday;
	private Gender gender;
	private Hometown hometown;

	private Set<Friend> friends = new HashSet<>();

	// declarative
	public Set<Person> friendOfFriends() {
		return friends.stream()
				.flatMap(friend -> friend.getPerson().getFriends().stream())
				.map(Friend::getPerson)
				.filter(person -> person != this)
				.collect(Collectors.toSet());
	}

	// imperative Optional
	public Optional<Friend> longestFriendshipImperative() {
		Friend result = null;
		for (Friend friend : friends) {
			if (result == null || friend.getBecameFriends().isBefore(result.getBecameFriends()))
				result = friend;
		}
		return Optional.ofNullable(result);
	}
	
	

	// imperative
	public Set<Hometown> hometownsOfFriendsImperative() {
		Set<Hometown> result = new HashSet<>();
		for (Friend friend : friends) {
			result.add(friend.getPerson().getHometown());
		}
		return result;
	}

	// declarative
	// lambda
	public Set<Hometown> hometownsOfFriendsDeclarative1() {
		return friends.stream()
				.map(friend -> friend.getPerson().getHometown())
				.collect(Collectors.toSet());
	}

	// method reference
	public Set<Hometown> hometownsOfFriendsDeclarative2() {
		return friends.stream()
				.map(Friend::getPerson)
				.map(Person::getHometown)
				.collect(Collectors.toSet());
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public LocalDate getBirhtday() {
		return birhtday;
	}

	public void setBirhtday(LocalDate birhtday) {
		this.birhtday = birhtday;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Hometown getHometown() {
		return hometown;
	}

	public void setHometown(Hometown hometown) {
		this.hometown = hometown;
	}

	public Set<Friend> getFriends() {
		return friends;
	}

	public void setFrineds(Set<Friend> frineds) {
		this.friends = frineds;
	}



}
