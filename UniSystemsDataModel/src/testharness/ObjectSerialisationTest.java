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
 * @author Craig Banyard, Daniel Scott & Najim Mazidi
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
        /*Car car = new Car("ABCDEFG", Transmission.AUTOMATIC, FuelType.DIESEL, 
                            "Plymouth", Classification.COUPE);
        admin.createCar(car);*/
        addTestDataAndSave();
        //loadFromDisk();
        
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
        Staff staff = new Staff("10438524", Position.LECTURER, Faculty.SCIENCE_AND_ENGINEERING, "BGB106", "07474306999", new Address("1", "Tothill Avenue", "Plymouth", "Devon", "PL4 8PH"),
                "Mr", "Najim", "Mazidi", new Date(1995,07,26), "Male", "07474306999", "nmazidi95@gmail.com");
        Staff staff2 = new Staff("10488708", Position.SECURITY, Faculty.SCIENCE_AND_ENGINEERING, "PSQA104", "0732345641", new Address("105", "Drake Circus", "Plymouth", "Devon", "PL4 1AA"),
                "Mr", "Craig", "Banyard", new Date(1992,06,03), "Male", "0732345641", "craig.banyard@students.plymouth.ac.uk");
        Staff staff3 = new Staff("10501358", Position.TRANSPORT_OFFICE_ADMIN, Faculty.SCIENCE_AND_ENGINEERING, "PSQA301", "07594875693", new Address("45", "Lipson Road", "Plymouth", "Devon", "PL4 8EA"),
                "Dr", "Daniel", "Scott", new Date(1994,6,28), "Male", "07594875693", "daniel.r.scott@students.plymouth.ac.uk");
        
        Administrator danScott = new Administrator("10501358", Position.TRANSPORT_OFFICE_ADMIN, Faculty.SCIENCE_AND_ENGINEERING, "PSQA301", "07594875693", new Address("45", "Lipson Road", "Plymouth", "Devon", "PL4 8EA"),
                "Dr", "Daniel", "Scott", new Date(1994,6,28), "Male", "07594875693", "daniel.r.scott@students.plymouth.ac.uk", "password");
        Administrator najim = new Administrator("10438524", Position.TRANSPORT_OFFICE_ADMIN, Faculty.SCIENCE_AND_ENGINEERING, "BGB106", "07474305999", new Address("1", "Tothill Avenue", "Plymouth", "Devon", "PL4 8PH"),
                "Mr", "Najim", "Mazidi", new Date(1995,7,26), "Male", "07474306999", "nmazidi95@gmail.com", "password");
        Administrator craig = new Administrator("10488708", Position.TRANSPORT_OFFICE_ADMIN, Faculty.SCIENCE_AND_ENGINEERING, "BGB106", "07474305999", new Address("15", "Tot Avenue", "Plymouth", "Devon", "PL4 8PH"),
                "Mr", "Craig", "Banyard", new Date(1992,6,03), "Male", "07474306999", "cbanyard@bsc.com", "password");
        
        ArrayList<String> arrayRepairs = new ArrayList<String>();
        arrayRepairs.add("Brakes");
        
        Service service = new Service("John", arrayRepairs, "Fixed the brakes");
        
        danScott.assignDayLoan(car, staff);
        danScott.assignLongLoan(car2, staff2);
        danScott.assignDayLoan(car4, staff);
        danScott.assignDayLoan(car5, staff3);
        danScott.assignLongLoan(car3, staff3);
        danScott.createCar(car);
        danScott.createAdministrator(danScott);
        najim.createAdministrator(najim);
        
        car2.addService(service);
        danScott.createCar(car2);
        danScott.createCar(car3);
        danScott.createCar(car4);
        danScott.createCar(car5);
        danScott.createStaffMember(staff);
        danScott.createStaffMember(staff2);
        danScott.createStaffMember(staff3);
    }
}
