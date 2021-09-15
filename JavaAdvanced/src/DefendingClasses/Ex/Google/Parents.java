package DefendingClasses.Ex.Google;

public class Parents {
    private String name;
    private String parentName;
    private String parentBirthday;

    public Parents(String name, String parentName, String parentBirthday) {
        this.name = name;
        this.parentName = parentName;
        this.parentBirthday = parentBirthday;
    }

    @Override
    public String toString() {
        return String.format("%s %s\n", parentName, parentBirthday);
    }

}
