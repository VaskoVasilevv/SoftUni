package DefendingClasses.Ex.Google;

public class Children {
    private String name;
    private String childName;
    private String childBirthday;

    public Children(String name, String childName, String childBirthday) {
        this.name = name;
        this.childName = childName;
        this.childBirthday = childBirthday;
    }


    public String toString(){
        return String.format("%s %s\n",childName,childBirthday);
    }

}
