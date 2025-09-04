package iuh.fit.se.dao;

import iuh.fit.se.models.LocalDateCustom;
import iuh.fit.se.models.Person;
import jakarta.annotation.Nullable;
import lombok.Getter;
import net.datafaker.Faker;

import java.util.HashSet;
import java.util.Set;

public class PersonStorage {
    @Getter
    private static final Set<Person> persons = new HashSet<>();

    static {
        Faker faker = new Faker();
        for (int i = 0; i < 30; i++) {
            Person person = new Person();
            person.setId(i + "");
            person.setName(faker.name().name());
            person.setDob(LocalDateCustom.of(faker.timeAndDate().birthday(18, 60)));
            person.setAge(LocalDateCustom.compareYear(person.getDob(), LocalDateCustom.now()));
            persons.add(person);
        }
    }

    @Nullable
    public static Person getPerson(String id) {
        return (Person) persons.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }

    public static boolean addPerson(Person person) {
        if (person.getId() == null) {
            person.setId(persons.size() + "");
        }
        return persons.add(person);
    }

    public static boolean updatePerson(Person person) {
        Person oldPerson = getPerson(person.getId());
        if (oldPerson == null) {
            return false;
        }
        if(person.getName() != null) oldPerson.setName(person.getName());
        if(person.getAge() > 18) oldPerson.setAge(person.getAge());
        if(person.getDob() != null) oldPerson.setDob(person.getDob());
        return true;
    }

    public static boolean removePerson(String id) {
        return persons.removeIf(p -> p.getId().equals(id));
    }
}
