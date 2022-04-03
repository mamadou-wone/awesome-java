package main;

import java.util.HashMap;
import java.util.List;

public class Chalet {
    public static int chaletCount = 0;
    public static HashMap<Integer, Chalet> chaletList = new HashMap<>();

    private int id;
    private String name;
    private Employee employee;
    private int numberOfBeds;
    private District district;
    private boolean isLoan;

    public Chalet(String name, Employee employee, int numberOfBeds, District district) {
       int count = chaletCount + 1;
        this.id = count;
        this.name = name;
        employee.getChalet().add(this);
        this.employee = employee;
        this.numberOfBeds = numberOfBeds;
        this.district = district;
        chaletList.put(count, this);
        chaletCount++;
    }

    public static int getChaletCount() {
        return chaletCount;
    }

    public static void setChaletCount(int chaletCount) {
        Chalet.chaletCount = chaletCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public boolean isLoan() {
        return isLoan;
    }

    public void setLoan(boolean loan) {
        isLoan = loan;
    }

    @Override
    public String toString() {
        return "Chalet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", employee=" + employee +
                ", numberOfBeds=" + numberOfBeds +
                ", district=" + district +
                '}';
    }
}
