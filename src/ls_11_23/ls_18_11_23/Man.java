package ls_11_23.ls_18_11_23;

public class Man {

    private String firstName;
    private String lastName;
    private int age;
    private int children;
    private Address address;

    public Man(String firstName, String lastName, int age, int children, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.children = children;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
