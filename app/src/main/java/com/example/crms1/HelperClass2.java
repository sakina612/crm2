package com.example.crms1;

public class HelperClass2 {
    String company_name,description,language;
    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
    public HelperClass2(String company_name, String description, String language) {
        this.company_name = company_name;
        this.description = description;
        this.language = language;

        //  this.cgpa= this.cgpa;
        // this.address= this.address;
    }

    public HelperClass2() {
    }
}
