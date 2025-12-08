package Task1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PalindromeCheckerTest {

    @Test
    void testSimplePalindrome() {
        PalindromeChecker checker = new PalindromeChecker();
        assertTrue(checker.isPalindrome("radar"));
        assertTrue(checker.isPalindrome("level"));
    }

    @Test
    void testPhrasePalindrome() {
        PalindromeChecker checker = new PalindromeChecker();
        assertTrue(checker.isPalindrome("A man, a plan, a canal, Panama"));
        assertTrue(checker.isPalindrome("No lemon, no melon"));
    }

    @Test
    void testNonPalindrome() {
        PalindromeChecker checker = new PalindromeChecker();
        assertFalse(checker.isPalindrome("hello"));
        assertFalse(checker.isPalindrome("openai"));
    }

    @Test
    void testEmptyAndSingleChar() {
        PalindromeChecker checker = new PalindromeChecker();
        assertTrue(checker.isPalindrome(""));
        assertTrue(checker.isPalindrome("a"));
    }
}

