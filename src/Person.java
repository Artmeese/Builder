import java.util.Objects;

public class Person {
    protected final String name;
    protected final String surname;
    protected int age; // Builder передает сюда -1 по умолчанию, чтобы можно было установить 0 для новорожденного,
    protected String address;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        if (age == -1){             //Предупреждаем, если возраст не установлен
            System.out.println("Age not set, -1 will be returned");
        }
        return age;
    }
    public void setAddress(String adress) {
        this.address = adress;
    }
    public boolean hasAge(){
        return age != -1;
    }
    public boolean hasAddress(){
        return address != null;
    }
    public void happyBirthday() {
        this.age++;
    }
    public PersonBuilder newChildBuilder(){
        return new PersonBuilder()
                .setSurname(this.surname)
                .setAge(0)                  //Устанавливаем возраст как для новорожденного
                .setAddress(this.address);
    }

    @Override
    public String toString() {
        return "{" +
                "Имя '" + name + '\'' +
                ", Фамилия '" + surname + '\'' +
                ", Возраст " + age +
                ", Адрес '" + address + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, address);
    }
}
