package lambda;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Alin
 */
public class Person  implements Serializable {

    private String firstName, lastName, job, gender;
    private int salary, age;
    private static final long serialVersionUID = 1L;
    public Person(String firstName, String lastName, String job, String gender, int age, int salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.job = job;
        this.salary = salary;
    }
    public Person(){}

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getJob() {
        return job;
    }

    public String getGender() {
        return gender;
    }

    public int getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", job='" + job + '\'' +
                ", gender='" + gender + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return salary == person.salary &&
                age == person.age &&
                Objects.equals(firstName, person.firstName) &&
                Objects.equals(lastName, person.lastName) &&
                Objects.equals(job, person.job) &&
                Objects.equals(gender, person.gender);
    }

    @Override
    public int hashCode() {

        return Objects.hash(firstName, lastName, job, gender, salary, age);
    }
}
