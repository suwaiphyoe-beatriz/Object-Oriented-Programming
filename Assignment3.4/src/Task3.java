import java.io.*;

// Student class
class Student implements Serializable {
    int id;
    String name;
    int age;

    Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return id + " - " + name + " (" + age + " yrs)";
    }
}

// Course class
class Course implements Serializable {
    String code;
    String name;
    String instructor;

    Course(String code, String name, String instructor) {
        this.code = code;
        this.name = name;
        this.instructor = instructor;
    }

    @Override
    public String toString() {
        return code + ": " + name + " (Instructor: " + instructor + ")";
    }
}

// Enrollment class
class Enrollment implements Serializable {
    Student student;
    Course course;
    String date;

    Enrollment(Student student, Course course, String date) {
        this.student = student;
        this.course = course;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Enrollment:\n  Student: " + student + "\n  Course: " + course + "\n  Date: " + date;
    }
}

// Main
public class Task3 {
    public static void main(String[] args) {
        String filename = "enrollments.ser";

        Student s = new Student(1001, "Alice Johnson", 22);
        Course c = new Course("OOP101", "Object-Oriented Programming", "Dr. Smith");
        Enrollment e = new Enrollment(s, c, "2025-01-15");

        // Serialize
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(e);
            System.out.println("Enrollment serialized to " + filename);
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        // Deserialize
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            Enrollment loaded = (Enrollment) in.readObject();
            System.out.println("\nDeserialized object:\n" + loaded);
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}
