package wrapper;

public class PersonWrapper extends Person {

    public PersonWrapper(Person person) {
        super(person);
    }

    public String fullName() {
        return name + " " + surname;
    }

    public boolean compare(Person person) {
        return id == person.id;
    }
}
