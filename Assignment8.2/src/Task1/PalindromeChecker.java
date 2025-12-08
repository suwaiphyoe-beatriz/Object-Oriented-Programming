package Task1;

public class PalindromeChecker {

    public boolean isPalindrome(String str) {
        if (str == null) return false;

        String cleaned = str.replaceAll("[^A-Za-z0-9]", "").toLowerCase();

        int left = 0, right = cleaned.length() - 1;
        while (left < right) {
            if (cleaned.charAt(left) != cleaned.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

