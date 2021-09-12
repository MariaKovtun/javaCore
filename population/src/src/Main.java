package src;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }

        System.out.println("Кол-во несовершеннолетних: ");
        long count = persons.stream().filter(x -> x.getAge()<18).count();
        System.out.println(count);

        System.out.println("Список фамилий призывников: ");
        List<String> res = persons.stream().filter(x -> (x.getSex().equals(Sex.MAN))&(x.getAge()>=18)&(x.getAge()<=27)).
                map(x -> x.getSurname()).
                collect(Collectors.toList());
        res.forEach(System.out::println);

        System.out.println("Потенциально работоспособные люди с высшим образованием: ");
        List<String> res2 = persons.stream().filter(x -> x.getEducation().equals(Education.HIGHER)).
                filter(x -> ((x.getAge()>=18)&(x.getAge()<=65))).
                filter(x -> !((x.getSex().equals(Sex.WOMAN))&(x.getAge()>60))).
                map(Person::getSurname).
                sorted(Comparator.naturalOrder()).
                collect(Collectors.toList());

        res2.forEach(System.out::println);
    }
}
