package lambda;

import lombok.Data;

import java.io.Serializable;

/**
 *
 * @author Alin
 */
@Data
public class Person  implements Serializable {

    private String firstName, lastName, job, gender;
    private Integer salary, age;
    private static final long serialVersionUID = 1L;

    private int id;

    public Person(){}

    public Person(String firstName, String lastName, String job, String gender, Integer salary, Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.job = job;
        this.gender = gender;
        this.salary = salary;
        this.age = age;
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
                ", id=" + id +
                '}';
    }
}
