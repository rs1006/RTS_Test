/**
 * #1 Print the number of integers in an array that are above the given input
 * and the number that are below, e.g. for the array [1, 5, 2, 1, 10] with input 6, print “above: 1, below: 4”.
 */
public class HighLow {

    /**
     * Gets the High and low
     * @param arr: array
     * @param num: number
     * @return String
     */
    public static String getHighLow(int arr[], int num) {
        int above = 0;
        int below = 0;
        if(arr == null) {
            return buildString(above, below);
        }
        for(int a: arr) {
            if(a > num) {
                above++;
            } else if(a < num) {
                below++;
            }
        }
        return buildString(above, below);
    }

    private static String buildString(int above, int below) {
        StringBuilder builder = new StringBuilder();
        builder.append("above: ");
        builder.append(above);
        builder.append(", ");
        builder.append("below: ");
        builder.append(below);
        return builder.toString();
    }

    public static void main (String args[]) {
        // null check
        System.out.println(getHighLow(null, 0));

        // Provided test
        System.out.println(getHighLow(new int[]{1, 5, 2, 1, 10}, 6));

        // same number test
        System.out.println(getHighLow(new int[]{1, 6, 6, 6, 10}, 6));

        // zero above
        System.out.println(getHighLow(new int[]{1, 6, 6, 6, 10}, 10));

        // zero below
        System.out.println(getHighLow(new int[]{1, 6, 6, 6, 10}, 1));

    }

}
