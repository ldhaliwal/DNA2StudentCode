import java.util.ArrayList;

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
    radix = 256;
    prime = 2147483647L;

    public static int STRCount(String sequence, String STR) {
        char startSTR = STR.charAt(0);
        int strLength = STR.length();
        int longestRun = 0;

        int strHash = 0;
        int windowHash = 0;

        // Compute hash of STR and first window of sequence
        for (int i = 0; i < strLength; i++) {
            strHash = (int) ((radix * strHash + STR.charAt(i)) % prime);
            windowHash = (int) ((radix * windowHash + sequence.charAt(i)) % prime);
        }

        //Recursive


        ArrayList<Integer> strInstances = new ArrayList<>();


        // Iterate through the sequence
        for (int i = 0; i < sequence.length(); i++){
            // Check that we are starting with the correct letter and that we would index out of bounds
            if(sequence.charAt(i) == startSTR && (i + strLength) <= sequence.length()){
                String currentSTR = sequence.substring(i, i + strLength);
                // Every time an instance of the STR shows up, save its index and move i past the instance
                if(currentSTR.equals(STR)){
                    strInstances.add(i);
                    i += strLength - 1;
                }
            }
        }

        int longestRepeated = 0;
        int currentRepeated = 1;

        // Iterate through the list of STR instances
        for (int i = 0; i < strInstances.size(); i++) {
            if(i != strInstances.size() - 1){
                // If the next index is strLength ahead of the current one, increment currentRepeated
                if ((strInstances.get(i) + strLength) == strInstances.get(i + 1)) {
                    currentRepeated++;
                }
                else {
                    // If not, reset the currentRepeated count
                    currentRepeated = 1;
                }
            }
            // Update longestRepeated if we found a new maximum
            if (currentRepeated > longestRepeated) {
                longestRepeated = currentRepeated;
            }
        }

        // Return the result; if no repeats were found, longestRepeated remains 0, so we return the actual count
        return longestRepeated;
    }


    public int recursive(String STR, String window, int count, int longestRun){
        if(hash(STR) == hash(window)){
            count++;
            // shift window by 3
            return recursive(STR, window, count, longestRun);
        }
        else{
            // shift window by 1
            if(count > longestRun){
                longestRun = count;
            }
            count = 0;
            recursive(STR, window, count, longestRun);
        }

        return 0;
    }

    public long hash(String text){
        int length = text.length();
        long hash = 0;

        for(int i = 0; i < length; i++) {
            hash = (hash * radix + text.charAt(i)) % prime;
        }
        return hash;
    }
}
