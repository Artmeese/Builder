import java.util.Locale;

public class PersonBuilder {
    protected String name;
    protected String surname;
    protected int age = -1;
    protected String address;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }
    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }
    public PersonBuilder setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be a negative number"); //Предупреждение о минусовом возрасте и оставляем -1
        } else {
            this.age = age;
        }
        return this;
    }
    public PersonBuilder setAddress(String adress) {
        this.address = adress;
        return this;
    }
    public Person build() {
        if (this.name == null || this.surname == null) {
            throw new IllegalStateException("Name and surname must be set");
        } else {
            Person person = new Person(this.name, this.surname, this.age); //передаем -1 возраст в любом случае
            person.setAddress(this.address);
            return person;
        }
    }
}
