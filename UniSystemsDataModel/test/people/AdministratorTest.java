/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package people;

import car.Car;
import car.Classification;
import car.FuelType;
import car.LoanType;
import car.Location;
import car.Status;
import car.Transmission;
import java.util.Date;
import data.Administrators;
import data.StaffMembers;
import data.Cars;
import loaning.DayLoan;
import loaning.LongLoan;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dansc
 */
public class AdministratorTest {
    Administrator admin;
    Administrator testAdmin;
    Car testDayCar;
    Car testLongCar;
    LongLoan testLongLoan;
    DayLoan testDayLoan;
    Staff testStaff;
    
    public AdministratorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        Date dob = new Date(28,6,1994);
        admin = new Administrator("10501358", Position.ASSOCIATE_HEAD_OF_SCHOOL, 
        Faculty.SCIENCE_AND_ENGINEERING, "PSQ101", "07594875693", new Address(
        "11 Whitefield Terrace", "Flat 4", "Plymouth", "Devon", "PL48NH"), "DR", 
        "Daniel", "Scott", dob, "Male", "07594875693", "daniel.r.scott@students.plymouth.ac.uk", 
        "password");
        testAdmin = new Administrator("101010", Position.ASSOCIATE_HEAD_OF_SCHOOL, 
        Faculty.SCIENCE_AND_ENGINEERING, "PSQ101", "07594875693", new Address(
        "11 Whitefield Terrace", "Flat 4", "Plymouth", "Devon", "PL48NH"), "DR", 
        "Daniel", "Scott", dob, "Male", "07594875693", "daniel.r.scott@students.plymouth.ac.uk", 
        "password");
        testStaff = new Staff("10501358", Position.ASSOCIATE_HEAD_OF_SCHOOL, 
        Faculty.SCIENCE_AND_ENGINEERING, "PSQ101", "07594875693", new Address(
        "11 Whitefield Terrace", "Flat 4", "Plymouth", "Devon", "PL48NH"), "DR", 
        "Daniel", "Scott", dob, "Male", "07594875693", "daniel.r.scott@students.plymouth.ac.uk");
        testDayCar = new Car("ABCDEFG", "Land Rover", "Defender", Transmission.AUTOMATIC, FuelType.DIESEL, 
                            Location.PLYMOUTH, "A101" ,Classification.COUPE, 5, 3, 10, LoanType.DAY_LOAN);
        testLongCar = new Car("AA16QWE", "Renault", "Twizzy", Transmission.AUTOMATIC, FuelType.ELECTRIC, 
                            Location.DEVONPORT, "A103", Classification.ESTATE, 5, 5,394, LoanType.LONG_TERM_LOAN);
        
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testInitialiseData() {
        admin.initialiseData();
    }

    @Test
    public void testGetPassword() {
        assertNotNull(admin.getPassword());
    }

    @Test
    public void testSetPassword() {
        admin.setPassword("abc123");
        assertEquals("abc123", admin.getPassword());
    }

    @Test
    public void testCreateCar() {
        admin.createCar(testDayCar);
        admin.createCar(testLongCar);
    }

    @Test
    public void testGetLoansForRef() {
        assertNotNull(admin.getLoansForRef("10501358"));
    }

    @Test
    public void testGetDayLoansForRef() {
        assertNotNull(admin.getDayLoansForRef("10501358"));
    }

    @Test
    public void testGetLongLoansForRef() {
        assertNotNull(admin.getLongLoansForRef("10501358"));
    }

    @Test
    public void testGetStaffForRefNumb() {
        assertNotNull(admin.getStaffForRefNumb("10501358"));
    }

    @Test
    public void testGetCarByReg() {
        assertNotNull(admin.getCarByReg(testDayCar.getRegNo()));
    }

    @Test
    public void testGetLoansForCar() {
        assertNotNull(admin.getLoansForCar(testLongCar));
    }

    @Test
    public void testGetLoans() {
        assertNotNull(admin.getLoans());
    }

    @Test
    public void testCreateStaffMember() {
        admin.createStaffMember(testStaff);
        assertEquals(StaffMembers.getInstance().getStaffMembers().size(), admin.getStaffMembers().size());
    }

    @Test
    public void testCreateAdministrator() {
        admin.createAdministrator(admin);
        admin.createAdministrator(testAdmin);
        assertEquals(admin.getAdminstrators().size(), Administrators.getInstance().getAdministrators().size());
    }

    @Test
    public void testGetAdminstrators() {
        assertNotNull(admin.getAdminstrators());
    }

    @Test
    public void testRemoveAdministrator() {
        admin.removeAdministrator(testAdmin);
        assertEquals(Administrators.getInstance().getAdministrators().size(), admin.getAdminstrators().size());
    }

    @Test
    public void testRemoveStaffMember() {
        admin.removeStaffMember(testStaff);
        assertEquals(admin.getStaffMembers().size(), StaffMembers.getInstance().getStaffMembers().size());
        admin.createStaffMember(testStaff);
    }

    @Test
    public void testAssignLongLoan() {
        admin.assignLongLoan(testLongCar, testStaff);
    }

    @Test
    public void testAssignDayLoan() {
        admin.assignDayLoan(testDayCar, testStaff);
    }

    @Test
    public void testReturnCar_Car_Loan() {
    }

    @Test
    public void testReturnCar_Car_DayLoan() {
    }

    @Test
    public void testReturnCar_Car_LongLoan() {
    }

    @Test
    public void testMakeNotes_Car_String() {
    }

    @Test
    public void testMakeNotes_Loan_String() {
    }

    @Test
    public void testCheckCar() {
        admin.checkCar(testDayCar);
        assertEquals(testDayCar.getStatus(), Status.AVAILABLE);
    }

    @Test
    public void testSendForService() {
        admin.sendForService(testDayCar);
        assertTrue(Status.IN_FOR_SERVICE == testDayCar.getStatus());
    }

    @Test
    public void testGetCars() {
        assertEquals(admin.getCars().size(), Cars.getInstance().getCars().size());
    }
    
}
