package main;
import java.util.List;

public class Employee implements Comparable<Employee> {
    public static int employeeCount = 0;
    private String id;
    private String firstName;
    private String lastName;
    private int salary;
    private District district;
    private List<Chalet> chalet;
    private Availability availability;

    public Employee(String id, String firstName, String lastName, int salary, District district, List<Chalet> chalet, Availability availability) {
        employeeCount++;
        this.id = id; // Can be later changed to a random number called by a method
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.district = district;
        this.chalet = chalet;
        this.availability = availability;
    }

    public static int getEmployeeCount() {
        return employeeCount;
    }

    public static void setEmployeeCount(int employeeCount) {
        Employee.employeeCount = employeeCount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public List<Chalet> getChalet() {
        return chalet;
    }

    public void setChalet(List<Chalet> chalet) {
        this.chalet = chalet;
    }

    public Availability getAvailability() {
        return availability;
    }

    public void setAvailability(Availability availability) {
        this.availability = availability;
    }

    @Override
    public int compareTo(Employee o) {
        return 0;
    }
}
