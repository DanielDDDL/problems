package br.mackenzie.lfs.model;

public class Person {

    private String name;
    private String someOtherInformation;
    private int age;

    public Person() {}

    public Person(String name, int age, String someOtherInformation) {
        this.name = name;
        this.someOtherInformation = someOtherInformation;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSomeOtherInformation() {
        return someOtherInformation;
    }

    public void setSomeOtherInformation(String someOtherInformation) {
        this.someOtherInformation = someOtherInformation;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
