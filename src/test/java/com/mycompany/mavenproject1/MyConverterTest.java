/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import com.mycompany.mavenproject1.MyConverter;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dick
 */
public class MyConverterTest {
    
    public MyConverterTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

   

    /**
     * Test of convert method, of class MyConverter.
     */
    @Test
    public void testConvert() {
        System.out.println("convert");
        String f = "567";
        MyConverter instance = new MyConverter();
        Integer expResult = 567;
        Integer result = instance.convert(f);
        assertEquals(expResult, result);
       
    }
    
}
