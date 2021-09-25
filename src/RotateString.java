/**
 * #2 Rotate the characters in a string by a given input and have the overflow appear at the beginning,
 * e.g. “MyString” rotated by 2 is “ngMyStri”.
 */
public class RotateString {


    /**
     * Simple algorithm to rotate and shift O(n^2)
     * @param str
     * @param rotate
     * @return
     */
    public static String rotateBruteForce(String str, int rotate) {
        // Null check
        if(str == null || str.trim().equals("")) {
            return str;
        }

        // Convert to char array
        char chars[] = str.toCharArray();
        int length = str.length();

        if(rotate % length == 0) {
            return str;
        }

        // if rotate % length == 0
        rotate = rotate % length;
        for(int i = 0; i<rotate; i++) {
            char temp = chars[length - 1];
            int j = length - 2;
            while( j >= 0) {
                chars[j+1] = chars[j];
                j--;
            }
            chars[0] = temp;
        }
        return new String(chars);
    }

    /**
     * O(n) space, O(n) complexity
     * @param str
     * @param rotate
     * @return
     */
    public static String rotateBetterWay(String str, int rotate) {

        if(str == null || str.trim().equals("")) {
            return str;
        }
        char chars[] = str.toCharArray();
        int length = str.length();

        if(rotate % length == 0) {
            return str;
        }
        rotate = rotate % length;

        char copy[] = new char[rotate];
        int k = 0;

        // Copy the subset of the array
        for(int i = length - rotate; i<length; i++) {
            copy[k] = chars[i];
            k++;
        }


        // Push the rest to the back
        for(int i = length - rotate - 1; i>=0; i--) {
            chars[i + rotate] = chars[i];
        }

        // Set the rest to the front
        for(int i = 0; i<rotate; i++) {
            chars[i] = copy[i];
        }
        return new String(chars);
    }


    public static void main (String args[]) {
        // null check
        System.out.println(rotateBruteForce(null, 4));
        System.out.println(rotateBetterWay(null, 4));

        System.out.println(rotateBruteForce("MyString", 2));
        System.out.println(rotateBetterWay("MyString", 2));

        System.out.println(rotateBruteForce("MyString", 8));
        System.out.println(rotateBetterWay("MyString", 8));

        System.out.println(rotateBruteForce("MyString", 100));
        System.out.println(rotateBetterWay("MyString", 100));
    }


}
