package lambda;

import java.util.*;
import java.util.function.Predicate;

import static java.util.stream.Collectors.*;

/**
 *
 * @author Alin
 */
public class Example3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        List<Person> javaProgrammers = new ArrayList<Person>() {
            {
                add(new Person("小王", "小王1", "Java programmer", "male", 15, 2000));
                add(new Person("老王", "老王1", "Java programmer", "female", 22, 1500));
                add(new Person("老张", "老张1", "Java programmer", "male", 8, 1800));
                add(new Person("二狗", "二狗1", "Java programmer", "female", 66, 5000));
            }
        };

        List<Person> phpProgrammers = new ArrayList<Person>() {
            {
                add(new Person("看看", "看看1", "PHP programmer", "male", 22, 3500));
                add(new Person("试试", "试试1", "PHP programmer", "female", 35, 2200));
                add(new Person("正在", "正在1", "PHP programmer", "male", 11, 1600));
                add(new Person("嗯嗯", "嗯嗯", "PHP programmer", "male", 55, 4500));

            }
        };


        // 涨百分之5的工资
     //   System.out.println("涨百分之5的工资");
     //   Consumer<Person> giveRaise = e -> e.setSalary(e.getSalary() / 100 * 5 + e.getSalary());
       // javaProgrammers.forEach(giveRaise);

        // 打印挣1400美元以上的PHP程序员
        System.out.println("打印挣3400美元以上的PHP程序员:");
        phpProgrammers.stream()
                .filter((p) -> (p.getSalary() > 3400))
                .forEach((p) -> System.out.printf("%s %s; ", p.getFirstName(), p.getLastName()));

        // Define some filters
        Predicate<Person> ageFilter = (p) -> (p.getAge() > 25);
        Predicate<Person> salaryFilter = (p) -> (p.getSalary() > 3400);
        Predicate<Person> genderFilter = (p) -> ("female".equals(p.getGender()));

        System.out.println("年收入超过3400美元且年龄超过24岁的女性PHP程序员");
        phpProgrammers.stream()
                .filter(ageFilter)
                .filter(salaryFilter)
                .filter(genderFilter)
                .forEach((p) -> System.out.printf("%s %s; ", p.getFirstName(), p.getLastName()));


        // limit examples
        System.out.println("先打印3个Java程序员");
        javaProgrammers.stream()
                .limit(3)
                .forEach((p) -> System.out.printf("%s %s; ", p.getFirstName(), p.getLastName()));

        System.out.println("先打印3名女性Java程序员");
        javaProgrammers.stream()
                .filter(genderFilter)
                .limit(3)
                .forEach((p) -> System.out.printf("%s %s; ", p.getFirstName(), p.getLastName()));

        // sorted, collect, limit, min, max examples
        System.out.println("排序和打印前5名Java程序员的名字");
        List<Person> sortedJavaProgrammers = javaProgrammers
                .stream()
                .sorted((p, p2) -> (p.getFirstName().compareTo(p2.getFirstName())))
                .limit(5)
                .collect(toList());

        sortedJavaProgrammers.forEach((p) -> System.out.printf("%s %s; %n", p.getFirstName(), p.getLastName()));

        System.out.println("根据薪水对Java程序员进行排序和打印");
        sortedJavaProgrammers = javaProgrammers
                .stream()
                .sorted((p, p2) -> (p.getSalary() - p2.getSalary()))
                .collect(toList());

        sortedJavaProgrammers.forEach((p) -> System.out.printf("%s %s; %n", p.getFirstName(), p.getLastName()));

        // min is faster than sorting and choosing the first
        System.out.println("获得最低的Java程序员工资");
        Person pers = javaProgrammers
                .stream()
                .min((p1, p2) -> (p1.getSalary() - p2.getSalary()))
                .get();

        System.out.printf("Name: %s %s; Salary: $%,d.", pers.getFirstName(), pers.getLastName(), pers.getSalary());

        System.out.println("获得最高的Java程序员工资");
        Person person = javaProgrammers
                .stream()
                .max((p, p2) -> (p.getSalary() - p2.getSalary()))
                .get();

        System.out.printf("Name: %s %s; Salary: $%,d.", person.getFirstName(), person.getLastName(), person.getSalary());

        // map, collect examples
        System.out.println("将PHP程序员的名字设为字符串");
        String phpDevelopers = phpProgrammers
                .stream()
                .map(Person::getFirstName)
                .collect(joining(" ; "));    // this can be use as a token in further operations

        System.out.println(phpDevelopers);

        System.out.println("设置Java程序员的名字 to Set:");
        Set<String> javaDevFirstName = javaProgrammers
                .stream()
                .map(Person::getFirstName)
                .collect(toSet());

        javaDevFirstName.stream().forEach((s) -> System.out.printf("%s ", s));;

        System.out.println("设置Java程序员的名字to TreeSet:");
        TreeSet<String> javaDevLastName = javaProgrammers
                .stream()
                .map(Person::getLastName)
                .collect(toCollection(TreeSet::new));

        javaDevLastName.stream().forEach((s) -> System.out.printf("%s ", s));

        System.out.println("=======================");
        int numProcessorsOrCores = Runtime.getRuntime().availableProcessors();
        System.out.printf("\n\nParallel version on %s-core machine:", numProcessorsOrCores);

        // parrallel stream, sum examples
        System.out.println("计算支付给Java程序员的总费用");
        int totalSalary = javaProgrammers
                .parallelStream()
                .mapToInt(p -> p.getSalary())
                .sum();

        System.out.printf("计算支付给Java程序员的总费用", totalSalary);

        //Get count, min, max, sum, and average for numbers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        IntSummaryStatistics stats = numbers
                .stream()
                .mapToInt((x) -> x)
                .summaryStatistics();

        System.out.println("Highest number in List : " + stats.getMax());
        System.out.println("Lowest number in List : " + stats.getMin());
        System.out.println("Sum of all numbers : " + stats.getSum());
        System.out.println("Average of all numbers : " + stats.getAverage());
    }

}
