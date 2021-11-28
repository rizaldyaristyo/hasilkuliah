package permutasi;
import java.util.ArrayList;

public class NonRecursiveFix {
    static void permutasi(String str) {

        if (str == null || str.length() == 0) return;

        ArrayList<String> kiri = new ArrayList<>();
        kiri.add(String.valueOf(str.charAt(0)));
        for (int i = 1; i < str.length(); i++) {
            for (int j = kiri.size() - 1; j >= 0 ; j--) {
                String stringKanan = kiri.remove(j);
                for (int k = 0; k <= stringKanan.length(); k++)
                    kiri.add(stringKanan.substring(0, k) + str.charAt(i) + stringKanan.substring(k));
            }
        }
        System.out.println(kiri);
    }
    public static void main(String[] args) {
        String str = "XYZ";
        permutasi(str);
    }
}
