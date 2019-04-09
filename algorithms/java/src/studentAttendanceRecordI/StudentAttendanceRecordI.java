package studentAttendanceRecordI;

/**
 * @author adaivskenan
 * @date 2019/04/09
 */
public class StudentAttendanceRecordI {

    public static void main(String[] args) {
        System.out.println(checkRecord("PPALLP"));
    }

    public static boolean checkRecord(String s) {
        int a = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                a++;
                if (a > 1) {
                    return false;
                }
            }
            if (s.charAt(i) == 'L' && (i + 2) < s.length() && s.charAt(i + 1) == 'L' && s.charAt(i + 2) == 'L') {
                return false;
            }
        }
        return true;
    }
}
