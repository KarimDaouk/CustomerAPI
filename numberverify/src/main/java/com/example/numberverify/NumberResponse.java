package com.example.numberverify;

public class NumberResponse {
    private String CountryCode;
    private  String CountryName;
    private String OperatorName;

    public String getCountryCode() {
        return CountryCode;
    }

    public void setCountryCode(String countryCode) {
        CountryCode = countryCode;
    }

    public String getCountryName() {
        return CountryName;
    }

    public void setCountryName(String countryName) {
        CountryName = countryName;
    }

    public String getOperatorName() {
        return OperatorName;
    }

    public void setOperatorName(String operatorName) {
        OperatorName = operatorName;
    }

    public NumberResponse(String countryCode, String countryName, String operatorName) {
        CountryCode = countryCode;
        CountryName = countryName;
        OperatorName = operatorName;
    }
}
