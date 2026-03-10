package utils;

public class TestUtils {
	
	public static final String TEXT_COLOR_GREEN = "\u001B[32m"; // from https://www.geeksforgeeks.org/how-to-print-colored-text-in-java-console/
    public static final String TEXT_COLOR_RED = "\u001B[31m"; 
    public static final String TEXT_COLOR_RESET = "\u001B[0m"; 
    
    // TODO3: Refactor printlns into utility methods
    public static void printTestPassed(String testCaseName) {
        System.out.println(TEXT_COLOR_GREEN + "PASSED -- "  + testCaseName + TEXT_COLOR_RESET);
    }

    public static void printTestFailed(String testCaseName) {
        System.out.println(TEXT_COLOR_RED + "FAILED -- " + testCaseName + TEXT_COLOR_RESET);
    }
}
