package ru.savin.homework20;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IndianCity {
    private String city;
    private String state;
    private String district;

    @JsonProperty("City")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @JsonProperty("State")
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @JsonProperty("District")
    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    @Override
    public String toString() {
        return "Город: '" + city + '\'' + ", Штат: '" + state + '\'' + ", Округ: '" + district + '\'';
    }
}
