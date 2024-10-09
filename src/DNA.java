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
                }
            }
        }

        int longestRepeated = 1;

        for(int i = 0; i < strInstances.size() -1; i++){
            if(strInstances.get(i) == (strInstances.get(i + 1) - strLeng)){
                longestRepeated += 1;
            }
//            else if ((strInstances.get(i + 1) > (strInstances.get(i) + strLeng)){
//                int temp = 1;
//            }
        }

        System.out.println(strInstances);

        return longestRepeated;
    }
}
