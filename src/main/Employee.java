package main;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Employee implements Comparable<Employee> {
    public static int employeeCount = 0;
    public static HashMap<Integer, Employee> employeeList = new HashMap<>();

    private int id;
    private String firstName;
    private String lastName;
    private int salary;
    private District district;
    private List<Chalet> chalet = new ArrayList<Chalet>();
    private Availability availability;

    public Employee( String firstName, String lastName, int salary, District district, Availability availability) {
        int count = employeeCount + 1;
        this.id = count; // Can be later changed to a random number called by a method
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.district = district;
        this.availability = availability;
        employeeList.put(count ,this);
        employeeCount++;
    }

    public static int getEmployeeCount() {
        return employeeCount;
    }

    public static void setEmployeeCount(int employeeCount) {
        Employee.employeeCount = employeeCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public void getChaletString() {
        for (Chalet chalet : chalet) {
            System.out.println(chalet.toString());
        }
    }

    // To be implemented
    @Override
    public int compareTo(Employee o) {
        return 0;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", salary=" + salary + ", district=" + district  + ", availability=" + availability + '}';
    }

    public static void printEmployeeList() {
        for (Employee employee : employeeList.values()) {
            System.out.println(employee.toString());
        }
    }
}
