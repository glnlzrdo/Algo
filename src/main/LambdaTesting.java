package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class MainHolder {
	private List<Sample> samples;

	public List<Sample> getSamples() {
		return samples;
	}

	public void setSamples(List<Sample> samples) {
		this.samples = samples;
	}
}

class Sample {
	private List<SubObject> subObjects;

	public List<SubObject> getSubObjects() {
		return subObjects;
	}

	public void setSubObjects(List<SubObject> subObjects) {
		this.subObjects = subObjects;
	}
}

class SubObject {
	private String name;
	private String type;
	private int count;

	public SubObject(String name, String type, int count) {
		super();
		this.name = name;
		this.type = type;
		this.count = count;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public int getCount() {
		return count;
	}

	public Stream getNameStream() {
		return Stream.of(name);
	}

}

public class LambdaTesting {
	public static void main(String[] args) {
		long start, end;
		/*Sample sample = new Sample();
		List<SubObject> subObjects = new ArrayList<SubObject>();
		List<Sample> samples = new ArrayList<Sample>();

		subObjects.add(new SubObject("One", "Uno", 1));
		subObjects.add(new SubObject("Two", "Dos", 2));
		subObjects.add(new SubObject("Three", "Tres", 3));
		samples.add(sample);
		samples.add(sample);
		sample.setSubObjects(subObjects);

		sample.getSubObjects().forEach(obj -> {
			System.out.println(obj.getName() + obj.getType() + obj.getCount());
		});

		sample.getSubObjects().addAll((List <SubObject>) sample.getSubObjects().parallelStream()
			.filter(subObject -> subObject.getCount() > 2).collect(Collectors.toList()));

		sample.getSubObjects().forEach(obj -> {
			System.out.println(obj.getName() + obj.getType() + obj.getCount());
		});*/

		/*samples
			.parallelStream()
			.filter(subObject -> subObject.getSubObjects())*/
		/*
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
		List<Integer> twoEvenSquares =
				numbers.parallelStream()
					.filter(n -> {
						System.out.println("filtering " + n);
						return n % 2 == 0;
						})
					.map(n -> {
						System.out.println("mapping " + n);
						return n * n;
						})
					.limit(2)
					.collect(Collectors.toList());
		List<Integer> i = numbers.parallelStream()
					.map(Integer::intValue)
					.collect(Collectors.toList());
		System.out.println(i);

		int newInt = numbers.parallelStream()
							.mapToInt(Integer::intValue)
							.sum();
		System.out.println(newInt);
		*/
		//List<Client> clients = createClients();
		
		List<Client> clients = new ArrayList<>();
		for (int i = 0; i < 40000; i++) {
			clients.addAll(createClients());
		}		
		
		start = System.currentTimeMillis();
		
		//Streams
		/*
		System.out.println("Client Names with #3 on tel: " +
				clients.parallelStream()
					.filter(client -> client.getTelephone().contains("3"))
					.map(Client::getName)
					.collect(Collectors.toList())
			);

		System.out.println("Clients from NYC: " +
				clients.parallelStream()
					.filter(client -> client.getAddress().equalsIgnoreCase("nyc"))
					.map(Client::getName)
					.sorted()
//					.reduce("", (str1, str2) -> str1.equalsIgnoreCase("alex") ? str1 : str2)
					.reduce("", (str1, str2) -> str1 + "[" + str2 +"]")
			);

		System.out.println("Clients with Id > 3: " +
				clients.parallelStream()
					.filter(client -> client.getClientId() > 3)
					.map(Client::getName)
					.collect(Collectors.toList())
			);
		
		System.out.println("Clients with Id < 3: ");
		clients.parallelStream()
					.filter(client -> client.getClientId() < 3)
					.map(Client::getName)
					.forEach(System.out::println);

		Map<String, List<Client>> map = clients.parallelStream()
				.filter(client -> client.getAddress().contains("L"))
				.collect(Collectors.groupingBy(Client::getName));
		System.out.println("Clients with Address that has L:\n" + map);

//		Map<Boolean, Set<Client>> map2 = clients.parallelStream()
//				.collect(Collectors.partitioningBy(client -> client.getName().startsWith("A"), Collectors.toSet()));
//		System.out.println("Clients with Name that doesn't start with A:\n" + map2.get(false));
//		System.out.println("Clients with Name that start with A:\n" + map2.get(true));
		*/
		
		//For Each
			
		System.out.println("Client Names with #3 on tel: ");
		for (Client client : clients) {
			if (client.getTelephone().contains("3")) {
				System.out.print(" " + client.getName());
			}
		}
			
		System.out.println("Clients from NYC: ");
		for (Client client : clients) {
			if (client.getAddress().equalsIgnoreCase("nyc")) {
				System.out.print(" " + client.getName());
			}
		}	

		System.out.println("Clients with Id > 3: ");
		for (Client client : clients) {
			if (client.getClientId() > 3) {
				System.out.print(" " + client.getName());
			}
		}	

		
		System.out.println("Clients with Id < 3: ");
		for (Client client : clients) {
			if (client.getClientId() < 3) {
				System.out.print(" " + client.getName());
			}
		}	

		Map<String, List<Client>> map = new HashMap<String, List<Client>>();
		List<String> names = new ArrayList<>();
		List<Client> list = new ArrayList<>();
		for (Client client : clients) {			
			if (client.getAddress().contains("L")) {
				names.add(client.getName());
				list.add(client);
			}			
		}
		
		for (String str : names) {
			List<Client> c = new ArrayList<>();
			for (Client client : list) {
				if (str == client.getName())
					c.add(client);
			}
			map.put(str, c);
		}		
		System.out.println("Clients with Address that has L:\n" + map);
		
		
		end = System.currentTimeMillis();
		System.out.println("Duration: " + ((double)(end - start) / 1000) + " seconds");
	}


	private static List<Client> createClients() {
		return Arrays.asList(
					new Client(1, "Axel", "NYC", "123"),
					new Client(2, "Lila", "MNL", "234"),
					new Client(3, "Alex", "NYC", "345"),
					new Client(4, "Gabi", "LAX", "456"),
					new Client(5, "Chab", "MIA", "567")
				);
	}

}
