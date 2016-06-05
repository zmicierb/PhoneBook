package by.borisevich.phone.book.domain;

public enum LoginProfileType {
    USER("USER"),
    DBA("DBA"),
    ADMIN("ADMIN");

    String loginProfileType;

    private LoginProfileType(String loginProfileType) {
        this.loginProfileType = loginProfileType;
    }

    public String getLoginProfileType() {
        return loginProfileType;
    }

}
