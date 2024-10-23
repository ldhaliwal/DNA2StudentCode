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
    static final int RADIX = 4;
    static final long PRIME = 2147483647L;
    static int longestRun;
    static int strLength;
    static long strHash;

    public static int STRCount(String sequence, String STR) {
        longestRun = 0;
        strLength = STR.length();
        strHash = hash(STR);

        int runCount = 0;

        // Iterate through the sequence
        for (int i = 0; i < sequence.length()-strLength; i++){
            if(hash(STR) == hash(sequence, i)) {
                runCount = consecutiveMatches(sequence, i);
                if (runCount > longestRun){
                    longestRun = runCount;
                }
            }
        }

        return longestRun;
    }


    public static int consecutiveMatches(String sequence, int start){
        if(start > (sequence.length() - strLength) || strHash != hash(sequence, start)){
            return 0;
        }
        return 1 + consecutiveMatches(sequence, start+strLength);
    }

    public static long hash(String text) {
        return hash(text, 0);
    }

    public static long hash(String text, int startIndex){
        long hash = 0;

        for(int i = startIndex; i < startIndex + strLength; i++) {
            hash = (hash * RADIX + text.charAt(i)) % PRIME;
        }
        return hash;
    }

    public static long shiftHash(String text, int startIndex){
        int length = text.length();
        long hash = 0;

        for(int i = 0; i < length; i++) {
            hash = (hash * RADIX + text.charAt(i)) % PRIME;
        }
        return hash;
    }

}
