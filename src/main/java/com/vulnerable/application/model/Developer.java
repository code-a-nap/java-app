package com.vulnerable.application.model;

public class Developer extends GenericUser {
    private String[] languages;
    private String seniority;
    private Object additionalInfo;

    public Developer() {
    }

    public Developer(String username, Integer age, Boolean isAdmin, String flag, String[] languages, String seniority,
            Object additionalInfo) {
        super(username, age, isAdmin, flag);
        this.languages = languages;
        this.seniority = seniority;
        this.additionalInfo = additionalInfo;
    }

    public Object getAdditionalInfo() {
        return this.additionalInfo;
    }

    public void setAdditionalInfo(Object additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public String[] getLanguages() {
        return this.languages;
    }

    public void setLanguages(String[] languages) {
        this.languages = languages;
    }

    public String getSeniority() {
        return this.seniority;
    }

    public void setSeniority(String seniority) {
        this.seniority = seniority;
    }

    @Override
    public String toString() {
        return "{" +
                " username='" + getUsername() + "'" +
                ", age='" + getAge() + "'" +
                ", isAdmin='" + isIsAdmin() + "'" +
                ", flag='" + getFlag() + "'" +
                " languages='" + getLanguages() + "'" +
                ", seniority='" + getSeniority() + "'" +
                ", additionalInfo='" + getAdditionalInfo() + "'" +
                "}";
    }

}
