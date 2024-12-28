package models;

public abstract class Person {
        private String name;
        private String surname;
        private int age;
        private boolean gender; // true = Male, false = Female

        public Person(String name, String surname, int age, boolean gender) {
            this.name = name;
            this.surname = surname;
            this.age = age;
            this.gender = gender;
        }

    public String getName() { return name; }
    public String getSurname() { return surname; }
    public int getAge() { return age; }
    public boolean isMale() { return gender; }

    public void setName(String name) { this.name = name; }
    public void setSurname(String surname) { this.surname = surname; }
    public void setAge(int age) { this.age = age; }
    public void setGender(boolean gender) { this.gender = gender; }

    @Override
    public String toString() {
        String genderString = gender ? "Male" : "Female";
        return "Hi, I am " + name + " " + surname + ", a " + age + "-year-old " + genderString + ".";
    }
}
