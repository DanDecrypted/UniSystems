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
import car.Transmission;
import java.util.Date;
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
    Car testDayCar;
    Car testLongCar;
    LongLoan testLongLoan;
    DayLoan testDayLoan;
    
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
    }

    @Test
    public void testGetPassword() {
        assertEquals("password", admin.getPassword());
    }

    @Test
    public void testSetPassword() {
        admin.setPassword("abc123");
        assertEquals("abc123", admin.getPassword());
    }

    @Test
    public void testCreateCar() {
        admin.createCar(testDayCar);
    }

    @Test
    public void testGetLoansForRef() {
    }

    @Test
    public void testGetDayLoansForRef() {
    }

    @Test
    public void testGetLongLoansForRef() {
    }

    @Test
    public void testGetStaffForRefNumb() {
    }

    @Test
    public void testGetCarByReg() {
        assertNotNull(admin.getCarByReg(testDayCar.getRegNo()));
    }

    @Test
    public void testGetLoansForCar() {
    }

    @Test
    public void testGetLoans() {
    }

    @Test
    public void testCreateStaffMember() {
    }

    @Test
    public void testCreateAdministrator() {
    }

    @Test
    public void testGetAdminstrators() {
    }

    @Test
    public void testRemoveAdministrator() {
    }

    @Test
    public void testRemoveStaffMember() {
    }

    @Test
    public void testAssignLongLoan() {
    }

    @Test
    public void testAssignDayLoan() {
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
    }

    @Test
    public void testSendForService() {
    }

    @Test
    public void testGetCars() {
    }
    
}
