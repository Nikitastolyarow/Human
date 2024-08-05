public class PersonBuilder {

    private String name;
    private String surname;
    private int age = 12;
    private String address;

    public PersonBuilder setName(String name) throws IllegalArgumentException {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Имя не указано");
        }
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) throws IllegalArgumentException {
        if (surname == null || surname.isEmpty()) {
            throw new IllegalArgumentException("Фамилия не указана");
        }
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) throws IllegalArgumentException {
        if (age < 0) {
            throw new IllegalArgumentException("Возраст неможет быть отрицательным");
        }
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() throws IllegalStateException {
        if (name == null || surname == null) {
            throw new IllegalStateException("Имя и фамилия не указаны");
        }
        Person person;
        if (age < 0) {
            person = new Person(name, surname);
        } else {
            person = new Person(name, surname, age);
        }
        if (address != null) {
            person.setAddress(address);
        }
        return person;
    }
}
