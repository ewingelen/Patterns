package wrapper;

public class Main {

    public static void main(String[] args) {
        Person personOne = new Person(0, "Artem", "Skorik");
        Person personTwo = new Person(1, "Denis", "Vasiliev");
        PersonWrapper personWrapper = new PersonWrapper(personOne);
        System.out.println(personWrapper.fullName());
        System.out.println(personWrapper.compare(personTwo));
    }
}
