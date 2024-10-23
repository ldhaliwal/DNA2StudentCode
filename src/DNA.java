/**
 * DNA
 * <p>
 * A puzzle created by Zach Blick
 * for Adventures in Algorithms
 * at Menlo School in Atherton, CA
 *</p>
 * <p>
 * Completed by: Liliana Dhaliwal
 *</p>
 */

public class DNA {
    static int radix = 4;
    static long prime = 2147483647L;
    static int longestRun = 0;
    static int strLength;
    static long strHash;

    public static int STRCount(String sequence, String STR) {
        strLength = STR.length();
        strHash = hash(STR);

        int runCount = 0;

        // Iterate through the sequence
        for (int i = 0; i < sequence.length(); i++){
            if(hash(STR) == hash(sequence, i)) {
                runCount = consecutiveMatches(sequence, i) + 1;
                if (runCount > longestRun){
                    longestRun = runCount;
                }
            }
        }

        return longestRun;
    }


    public static int consecutiveMatches(String sequence, int start){
        if(strHash != hash(sequence, start)){
            return 0;
        }
        else if (start <= (sequence.length() - strLength)) {
            return 1 + consecutiveMatches(sequence, start+strLength);
        }
        return 1;
    }

    public static long hash(String text) {
        return hash(text, 0);
    }

    public static long hash(String text, int startIndex){
        int length = text.length();
        long hash = 0;

        for(int i = startIndex; i < startIndex + length; i++) {
            hash = (hash * radix + text.charAt(i)) % prime;
        }
        return hash;
    }

    public static long shiftHash(String text, int startIndex){
        int length = text.length();
        long hash = 0;

        for(int i = 0; i < length; i++) {
            hash = (hash * radix + text.charAt(i)) % prime;
        }
        return hash;
    }

}
