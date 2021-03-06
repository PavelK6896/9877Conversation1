package app.web.pavelk.conversation1;

public class User {

    private String lastName;
    private String firstName;
    private String middleName;
    private Integer age;
    private String passport;

    public User(String lastName, String firstName, String middleName, String age, String passport) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        try {
            this.age = Integer.parseInt(age); // age.isEmpty() ? null : Integer.parseInt(age);
        } catch (NumberFormatException ignored) {
        }
        this.passport = passport;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", age=" + age +
                ", passport='" + passport + '\'' +
                '}';
    }

}
