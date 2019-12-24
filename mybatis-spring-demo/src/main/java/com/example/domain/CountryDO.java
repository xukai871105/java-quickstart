package com.example.domain;

/**
 * @author xukai
 */
public class CountryDO {
    private Long id;
    private String countryName;
    private String countryCode;

    public Long getId() {
        return id;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @Override
    public String toString() {
       return String.format("%s %s", countryName, countryCode);
    }
}
