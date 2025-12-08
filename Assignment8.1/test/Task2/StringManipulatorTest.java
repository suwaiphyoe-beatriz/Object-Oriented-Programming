package Task2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StringManipulatorTest {

    private final StringManipulator sm = new StringManipulator();

    @Test
    void testConcatenate() {
        assertEquals("HelloWorld", sm.concatenate("Hello", "World"));
        assertEquals("abc", sm.concatenate("a", "bc"));
        assertEquals("", sm.concatenate("", ""));
    }

    @Test
    void testFindLength() {
        assertEquals(5, sm.findLength("Hello"));
        assertEquals(0, sm.findLength(""));
    }

    @Test
    void testConvertToUpperCase() {
        assertEquals("HELLO", sm.convertToUpperCase("hello"));
        assertEquals("ABC", sm.convertToUpperCase("AbC"));
    }

    @Test
    void testConvertToLowerCase() {
        assertEquals("hello", sm.convertToLowerCase("HELLO"));
        assertEquals("abc", sm.convertToLowerCase("AbC"));
    }

    @Test
    void testContainsSubstring() {
        assertTrue(sm.containsSubstring("Hello world", "world"));
        assertFalse(sm.containsSubstring("Hello", "xyz"));
        assertFalse(sm.containsSubstring(null, "x")); // defensive case
    }
}

