package sch.hunnu.entity;

public class ft {
    private String name;
    private String age;

    public ft(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public ft() {
    }

    @Override
    public String toString() {
        return "ft{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
