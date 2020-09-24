package lambda;

import java.io.Serializable;

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
}
