/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 *
 * @author mulis
 */
@SupportedSourceVersion(SourceVersion.RELEASE_25)
public class MessageTest {
    
    public MessageTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    /**
     *
     */

    

    @Test
    public void testValidMessage() {
        assertEquals("Message ready to send.", Message.validateMessage("Hello"));
    }

    @Test
    public void testLongMessage() {
        String msg = "A".repeat(260);
        assertTrue(Message.validateMessage(msg).contains("exceeds"));
    }

    @Test
    public void testRecipientValid() {
        Message m = new Message("+27718693002", "Hi");
        assertTrue(m.checkRecipientCell().contains("successfully"));
    }

    @Test
    public void testRecipientInvalid() {
        Message m = new Message("08575", "Hi");
        assertTrue(m.checkRecipientCell().contains("incorrectly"));
    }

    @Test
    public void testHash() {
        Message m = new Message("+27718693002", "Hi tonight");
        assertTrue(m.createMessageHash().contains("HITONIGHT"));
    }
 }


