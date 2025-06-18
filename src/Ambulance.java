public class Ambulance {
private String driverName;
private String registrationNumber;
private String companyName;

public Ambulance(String driverName, String registrationNumber, String companyName) {
    this.driverName = driverName;
    this.registrationNumber = registrationNumber;
    this.companyName = companyName;
}

public String getDriverName() {
    return driverName;
}

public String getRegistrationNumber() {
    return registrationNumber;
}

public String getCompanyName() {
    return companyName;
}

// Used in Admin views
@Override
public String toString() {
    return "Ambulance{" +
            "Driver='" + driverName + '\'' +
            ", Reg#='" + registrationNumber + '\'' +
            ", Company='" + companyName + '\'' +
            '}';
}

// Used in Emergency
public String shortInfo() {
    return "Ambulance{" +
            "Driver='" + driverName + '\'' +
            ", Reg#='" + registrationNumber + '\'' +
            '}';
}
}
