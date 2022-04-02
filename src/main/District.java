package main;

public class District {

    private int districtId;
    private String districtName;
    private String address;

    public District() {
    }

    public District(int districtId, String districtName, String address) {
        this.districtId = districtId;
        this.districtName = districtName;
        this.address = address;
    }

    public int getDistrictId() {
        return districtId;
    }

    public void setDistrictId(int districtId) {
        this.districtId = districtId;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
