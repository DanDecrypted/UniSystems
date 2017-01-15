/*
 *  UniSystems is a development package for SOFT 252 at Plymouth University
 *  It is a system designed to allow cars to be loaned out on a custom basis to 
 *  a member of staff. This project was created and developed by Craig Banyard,
 *  Daniel Scott and Najim Mazidi.
 */
package testharness;
import data.Cars;
import car.Car;
import car.Classification;
import car.FuelType;
import car.LoanType;
import car.Location;
import car.Service;
import car.Transmission;
import data.Loans;
import data.StaffMembers;
import data.Administrators;
import java.util.ArrayList;
import java.util.Date;
import people.Address;
import people.Faculty;
import people.Position;
import people.Staff;
import people.Administrator;

/**
 *
 * @author Craig Banyard, Daniel Scott, Najim Mazidi
 */
public class ObjectSerialisationTest{
    private static Cars cars = Cars.getInstance();
    private static StaffMembers staffMembers = StaffMembers.getInstance();
    private static Loans loans = Loans.getInstance();
    private static Administrators admins = Administrators.getInstance();
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        addTestDataAndSave();
        
    }

    public static void addTestDataAndSave() {
        
        Car car = new Car("ABCDEFG", "Land Rover", "Defender", Transmission.AUTOMATIC, FuelType.DIESEL, 
                            Location.PLYMOUTH, "A101" ,Classification.COUPE, 5, 3, 10, LoanType.DAY_LOAN);
        Car car2 = new Car("KP10TKN", "Ford", "Focus", Transmission.MANUAL, FuelType.PETROL,
                            Location.PLYMOUTH, "A102", Classification.COUPE, 5, 5,23445, LoanType.DAY_LOAN);
        Car car3 = new Car("AA16QWE", "Renault", "Twizzy", Transmission.AUTOMATIC, FuelType.ELECTRIC, 
                            Location.DEVONPORT, "A103", Classification.ESTATE, 5, 5,394, LoanType.LONG_TERM_LOAN);
        Car car4 = new Car("AB66ABC", "Mercedes", "Sprinter", Transmission.MANUAL, FuelType.LPG, 
                            Location.PLYMOUTH, "A104", Classification.VAN, 3, 3, 237234, LoanType.LONG_TERM_LOAN);
        Car car5 = new Car("NA15PQD","BMW", "i8", Transmission.AUTOMATIC, FuelType.ELECTRIC, 
                            Location.PLYMOUTH, "A105", Classification.COMPACT, 4, 3, 20050, LoanType.DAY_LOAN);
        Car car6 = new Car("VE55HGG","Vauxhall", "Astra", Transmission.AUTOMATIC, FuelType.PETROL, 
                            Location.PLYMOUTH, "A107", Classification.COMPACT, 4, 3, 20050, LoanType.LONG_TERM_LOAN);
                            
        Staff staff = new Staff("10438524", Position.LECTURER, Faculty.SCIENCE_AND_ENGINEERING, "BGB106", "07474306999", new Address("1", "Tothill Avenue", "Plymouth", "Devon", "PL4 8PH"),
                "Mr", "Najim", "Mazidi", new Date(95,7,26), "Male", "07474306999", "nmazidi95@gmail.com");
        Staff staff2 = new Staff("10488708", Position.SECURITY, Faculty.SCIENCE_AND_ENGINEERING, "PSQA104", "0732345641", new Address("105", "Drake Circus", "Plymouth", "Devon", "PL4 1AA"),
                "Mr", "Craig", "Banyard", new Date(92,6,3), "Male", "0732345641", "craig.banyard@students.plymouth.ac.uk");
        Staff staff3 = new Staff("10501358", Position.TRANSPORT_OFFICE_ADMIN, Faculty.SCIENCE_AND_ENGINEERING, "PSQA301", "07594875693", new Address("45", "Lipson Road", "Plymouth", "Devon", "PL4 8EA"),
                "Dr", "Daniel", "Scott", new Date(94,6,28), "Male", "07594875693", "daniel.r.scott@students.plymouth.ac.uk");
        Staff staff4 = new Staff("12345678", Position.TRANSPORT_OFFICE_ADMIN, Faculty.SCIENCE_AND_ENGINEERING, "PSQA301", "07474306999", new Address("1", "Tothill Avenue", "Plymouth", "Devon", "PL4 8PH"),
                "Mr", "John", "Smith", new Date(95,7,26), "Male", "07474306999", "john.smith@students.plymouth.ac.uk");
        
        Administrator danScott = new Administrator("10501358", Position.TRANSPORT_OFFICE_ADMIN, Faculty.SCIENCE_AND_ENGINEERING, "PSQA301", "07594875693", new Address("45", "Lipson Road", "Plymouth", "Devon", "PL4 8EA"),
                "Dr", "Daniel", "Scott", new Date(94,6,28), "Male", "07594875693", "daniel.r.scott@students.plymouth.ac.uk", "password");
        Administrator najim = new Administrator("10438524", Position.TRANSPORT_OFFICE_ADMIN, Faculty.SCIENCE_AND_ENGINEERING, "BGB106", "07474305999", new Address("1", "Tothill Avenue", "Plymouth", "Devon", "PL4 8PH"),
                "Mr", "Najim", "Mazidi", new Date(95,7,26), "Male", "07474306999", "nmazidi95@gmail.com", "password");
        Administrator craig = new Administrator("10488708", Position.TRANSPORT_OFFICE_ADMIN, Faculty.SCIENCE_AND_ENGINEERING, "BGB106", "07474305999", new Address("15", "Tot Avenue", "Plymouth", "Devon", "PL4 8PH"),
                "Mr", "Craig", "Banyard", new Date(92,6,3), "Male", "07474306999", "cbanyard@bsc.com", "password");
        
        Administrator superUser = new Administrator("admin", Position.TRANSPORT_OFFICE_ADMIN, Faculty.SCIENCE_AND_ENGINEERING, "PSQ101", "1010101010", new Address("15", "Tot Avenue", "Plymouth", "Devon", "PL4 8PH"),
                "Dr", "Super", "User", new Date(94,1,1), "Male", "1010101010", "super@user.com", "password");
        Staff superStaff = new Staff("admin", Position.TRANSPORT_OFFICE_ADMIN, Faculty.SCIENCE_AND_ENGINEERING, "PSQ101", "1010101010", new Address("15", "Tot Avenue", "Plymouth", "Devon", "PL4 8PH"),
                "Dr", "Super", "User", new Date(94,1,1), "Male", "1010101010", "super@user.com");
        
        ArrayList<String> arrayRepairs = new ArrayList<String>();
        arrayRepairs.add("Brakes");
        
        Service service = new Service("John", arrayRepairs, "Fixed the brakes", new Date());
        
        superUser.createCar(car);
        superUser.createCar(car2);
        superUser.createCar(car3);
        superUser.createCar(car4);
        superUser.createCar(car5);
        superUser.createCar(car6);
        superUser.createStaffMember(superStaff);
        superUser.createAdministrator(superUser);
        superUser.createStaffMember(staff);
        superUser.createStaffMember(staff2);
        superUser.createStaffMember(staff3);
        superUser.assignDayLoan(car, staff);
        superUser.assignDayLoan(car2, staff2);
        superUser.assignLongLoan(car3, staff4);
        danScott.createAdministrator(danScott);
        najim.createAdministrator(najim);
        craig.createAdministrator(craig);
        najim.createStaffMember(staff4);
        car2.addService(service);
    }
}
