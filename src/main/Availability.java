package main;

import java.util.HashMap;

public class Availability {
    private HashMap<String, Boolean> availability;

    public Availability() {
        availability = new HashMap<>();
        availability.put("Monday", false);
        availability.put("Tuesday", false);
        availability.put("Wednesday", false);
        availability.put("Thursday", false);
        availability.put("Friday", false);
        availability.put("Saturday", false);
        availability.put("Sunday", false);
    }

    public HashMap<String, Boolean> getAvailability() {
        return availability;
    }

    public void setAvailability(HashMap<String, Boolean> availability) {
        this.availability = availability;
    }

    public void setAvailability(String day, Boolean available) {
        availability.put(day, available);
    }

    public Boolean getAvailability(String day) {
        return availability.get(day);
    }

    public String getAvailabilityString() {
        StringBuilder sb = new StringBuilder();
        for (String day : availability.keySet()) {
            sb.append(day).append(": ").append(availability.get(day)).append("\n");
        }
        return sb.toString();
    }
}
