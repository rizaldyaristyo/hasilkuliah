package permutasi;


public class Rekursif {
     static void permutasi(String candidate, String remaining) {

        if (remaining == null) return;

        if (remaining.length() == 0) System.out.print(" " + candidate);


        for (int i = 0; i < remaining.length(); i++) {
            String newCandidate = candidate + remaining.charAt(i);
            String newRemaining = remaining.substring(0, i) + remaining.substring(i + 1);
            permutasi(newCandidate, newRemaining);
        }
    }

    public static void main(String[] args) {
        String str = "XYZ";
        permutasi("", str);

    }
}
