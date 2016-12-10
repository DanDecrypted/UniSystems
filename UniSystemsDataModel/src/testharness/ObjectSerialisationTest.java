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
import car.Service;
import car.Transmission;
import data.Loans;
import data.StaffMembers;
import java.util.ArrayList;
import java.util.Date;
import people.Address;
import people.Faculty;
import people.Position;
import people.Staff;
import people.Administrator;
import loaning.Loan;
import loaning.DayLoan;
import loaning.LongLoan;

/**
 *
 * @author Craig Banyard, Daniel Scott & Najim Mazidi
 */
public class ObjectSerialisationTest{
    private static Cars cars = Cars.getInstance();
    private static StaffMembers staffMembers = StaffMembers.getInstance();
    private static Loans loans = Loans.getInstance();
    private static Administrator admin = new Administrator();
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
        Car car = new Car("ABCDEFG", Transmission.AUTOMATIC, FuelType.DIESEL, 
                            "Plymouth", Classification.COUPE, 5, 3,10);
        Car car2 = new Car("KP10TKN", Transmission.MANUAL, FuelType.PETROL,
                            "Plymouth", Classification.COUPE, 5, 5,23445);
        Car car3 = new Car("AA16QWE", Transmission.AUTOMATIC, FuelType.ELECTRIC, 
                            "DEVONPORT", Classification.ESTATE, 5, 5,394);
        Car car4 = new Car("AB66ABC", Transmission.MANUAL, FuelType.LPG, 
                            "Plymouth", Classification.VAN, 3, 3, 237234);
        Car car5 = new Car("NA15PQD", Transmission.AUTOMATIC, FuelType.ELECTRIC, 
                            "Plymouth", Classification.COMPACT, 4, 3, 20050);
        Staff staff = new Staff("10438524", Position.LECTURER, Faculty.SCIENCE_AND_ENGINEERING, "BGB106", "07474306999", new Address("1", "Tothill Avenue", "Plymouth", "Devon", "PL4 8PH"),
                "Mr", "Najim", "Mazidi", new Date(1995,07,26), "Male", "07474306999", "nmazidi95@gmail.com");
        Staff staff2 = new Staff("10488708", Position.SECURITY, Faculty.SCIENCE_AND_ENGINEERING, "PSQA104", "0732345641", new Address("105", "Drake Circus", "Plymouth", "Devon", "PL4 1AA"),
                "Mr", "Craig", "Banyard", new Date(1992,06,03), "Male", "0732345641", "craig.banyard@students.plymouth.ac.uk");
        Staff staff3 = new Staff("10501358", Position.ASSOCIATE_HEAD_OF_SCHOOL, Faculty.BUSINESS, "PSQA301", "07345723886", new Address("45", "Lipson Road", "Plymouth", "Devon", "PL4 8EA"),
                "Mr", "Daniel", "Scott", new Date(1992,6,3), "Male", "07345723886", "daniel.scott@students.plymouth.ac.uk");
        
        ArrayList<String> arrayRepairs = new ArrayList<String>();
        arrayRepairs.add("Brakes");
        
        Service service = new Service("John", arrayRepairs, "Fixed the brakes");
        
        admin.assignDayLoan(car, staff);
        admin.assignLongLoan(car2, staff2);
        admin.assignDayLoan(car4, staff);
        admin.assignDayLoan(car5, staff3);
        admin.assignLongLoan(car3, staff3);
        admin.createCar(car);
        
        car2.addService(service);
        admin.createCar(car2);
        admin.createCar(car3);
        admin.createCar(car4);
        admin.createCar(car5);
        admin.createStaffMember(staff);
        admin.createStaffMember(staff2);
        admin.createStaffMember(staff3);
    }
}
