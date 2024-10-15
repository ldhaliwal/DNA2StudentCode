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
    public static int STRCount(String sequence, String STR) {
        char startSTR = STR.charAt(0);
        int strLength = STR.length();
        ArrayList<Integer> strInstances = new ArrayList<>();

//        // Map each letter to a binary representation
//        int[] binaryMap = new int[256];
//        binaryMap['A'] = 0b00;
//        binaryMap['C'] = 0b01;
//        binaryMap['G'] = 0b10;
//        binaryMap['T'] = 0b11;
//
//        int strBinary = 0;
//
//        // Convert the STR to binary
//        for (int i = 0; i < strLength; i++) {
//            strBinary = (strBinary << 2) | binaryMap[STR.charAt(i)];
//        }
//
//        int currentBinary = 0;
//
//        // Iterate through the sequence
//        for (int i = 0; i < sequence.length(); i++) {
//            // Shift the binary representation and add the new character
//            currentBinary = ((currentBinary << 2) | binaryMap[sequence.charAt(i)]) & ((1 << (2 * strLength)) - 1);
//
//            // If enough characters have been processed, compare the two binary values
//            if (i >= strLength - 1) {
//                if (currentBinary == strBinary) {
//                    strInstances.add(i - strLength + 1);
//                    i += strLength - 1;
//                }
//            }
//        }


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
}
