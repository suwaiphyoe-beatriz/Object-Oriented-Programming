import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Person {
    String name;
    int age;
    String city;

    public Person(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    @Override
    public String toString() {
        return name + ", " + age + ", " + city;
    }
}

public class Task1 {
    public static void main(String[] args) {
        // Create a list of Person objects
        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 25, "New York"));
        people.add(new Person("Bob", 30, "Los Angeles"));
        people.add(new Person("Charlie", 22, "New York"));
        people.add(new Person("David", 28, "Chicago"));
        people.add(new Person("Eva", 35, "New York"));

        // Sort by age using lambda and Comparator
        people.sort(Comparator.comparingInt(p -> p.age));

        System.out.println("Sorted by age:");
        people.forEach(System.out::println);

        // Filter by city
        people.removeIf(p -> !p.city.equals("New York"));

        System.out.println("\nFiltered by city (New York):");
        people.forEach(System.out::println);
    }
}

