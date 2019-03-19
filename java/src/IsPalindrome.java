import java.io.BufferedReader;
import java.io.FileReader;

class IsPalindrome {

    private static boolean isPalindrome(String s) {
        String sNoWhitespaceLowered = s.replaceAll("\\W", "").toLowerCase();
        for (int i = 0, j = sNoWhitespaceLowered.length() - 1; i <= j; i++, j--) {
            if (sNoWhitespaceLowered.charAt(i) != sNoWhitespaceLowered.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader("palindromes.txt"))) {
            for (String line; (line = br.readLine()) != null; ) {
                if (!isPalindrome(line)) {
                    throw new Exception("Test failed!");
                }
            }
        }

        try (BufferedReader br = new BufferedReader(new FileReader("not-palindromes.txt"))) {
            for (String line; (line = br.readLine()) != null; ) {
                if (isPalindrome(line)) {
                    throw new Exception("Test failed!");
                }
            }
        }

        System.out.println("All tests passed!");
    }
}
