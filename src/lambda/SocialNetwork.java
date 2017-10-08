package lambda;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class SocialNetwork {
	private Set<Person> people;

	// imperative
	public Set<Person> lonelyPeopleImperative() {
		Set<Person> result = new HashSet<Person>();
		for (Person person : people) {
			if (person.getFriends().isEmpty())
				result.add(person);
		}
		return result;
	}

	// declarative
	public Set<Person> lonelyPeopleDeclarative() {
		return people.stream()
				.filter(person -> person.getFriends().isEmpty())
				.collect(Collectors.toSet());
	}

	// imperative
	public int averageNumberOfFriendsImperative() {
		int sum = 0;
		for (Person person : people) {
			sum += person.getFriends().size();
		}
		return sum / people.size();
	}

	// declarative
	public int averageNumberOfFriendsDeclarative() {
		return people.stream()
				.map(Person::getFriends)
				.map(friend -> friend.size())
				.reduce(0, (x, y) -> x + y)
					/*
					 List<Integer> sizes;
					 int x = 0;
					 for (int y: sizes)
					 	x = x + y;
					 return x;
					 */
				/ people.size();
	}
}
