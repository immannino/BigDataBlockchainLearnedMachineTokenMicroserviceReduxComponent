package customer.model;

public class User {

    private String name;
    private String birthday;
    private int age;

    public User() {

    }

    public User(String name, String birthday, int age) {
        this.name = name;
        this.birthday = birthday;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public String getBirthday() {
        return this.birthday;
    }

    public int getAge() {
        return this.age;
    }
}