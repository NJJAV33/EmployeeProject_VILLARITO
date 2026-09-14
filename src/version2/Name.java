package version2;

public class Name {
    private String firstName;
    private String middleName;
    private String lastName;

    public Name() {
    }

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Name(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        //need to get first letter only; middle initial
        if (middleName == null || middleName.isEmpty()) {
            return "";
        }
        return middleName.substring(0, 1);
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        if (middleName == null || middleName.isEmpty()) {
            return String.format("%s, %s", lastName, firstName);
        }
        return String.format("%s, %s %s.", lastName, firstName, getMiddleName());
    }
}
