package JavaOOP.ExceptionAndErrorHandling.Lab;

public class Person {
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
    }

    public void setFirstName(String firstName) {
        validateStringField(firstName,"first");
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        validateStringField(lastName,"last");

        this.lastName = lastName;
    }

    public void setAge(int age) {
        if (age < 0 || age>120){
            throw new InvalidPersonNameException("Age should be in the range [0...120]");
        }
        this.age = age;
    }

    private void validateStringField(String str, String fieldName) {
        if (str == null || str.trim().isEmpty()) {
            throw new IllegalArgumentException("The " + fieldName + " name cannot null or empty");
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }
}
