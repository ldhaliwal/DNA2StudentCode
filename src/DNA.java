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

    /**
     * TODO: Complete this function, STRCount(), to return longest consecutive run of STR in sequence.
     */
    public static int STRCount(String sequence, String STR) {
        char startSTR = STR.charAt(0);
        int strLeng = STR.length();

        ArrayList<Integer> strInstances = new ArrayList<Integer>();

        for (int i = 0; i < sequence.length(); i++){
            if(sequence.charAt(i) == startSTR && (i + strLeng) <= sequence.length()){
                String currentSTR = sequence.substring(i, i + strLeng);
                if(currentSTR.equals(STR)){
                    strInstances.add(i);
                    i += strLeng - 1;
                }
            }
        }

        int longestRepeated = 0;
        int currentRepeated = 1;

        // Iterate through the list of STR instances
        for (int i = 0; i < strInstances.size(); i++) {
            if(i != strInstances.size() - 1){
                // If the next index is strLength ahead of the current one, increment currentRepeated
                if ((strInstances.get(i) + strLeng) == strInstances.get(i + 1)) {
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
}
