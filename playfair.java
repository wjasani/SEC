import java.util.Scanner;

public class playfair {

    public static void main(String[] args) {
        char key[][] = new char[5][5];
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Plain Text Message : ");
        String pt = sc.nextLine();
        System.out.println("Enter Key : ");
        String keyt = sc.nextLine();
        keyt = keyt.replace("j", "i");
        String alp = "abcdefghiklmnopqrstuvwxyz";
        pt = pt.replaceAll("\\s", "");
        keyt = keyt.replaceAll("\\s", "");
        System.out.println(keyt + "\n" + pt);
        String pfs = "";
        for (int i = 0; i < keyt.length(); i++) {
            char x = keyt.charAt(i);
            if (!pfs.contains(x + "")) {
                int k = pfs.length() / 5;
                int l = (pfs.length() % 5);
                pfs += x;
                // System.out.println("pfs:" + pfs + "::" + pfs.length() + "\nk:" + k + "\nl:" +
                // l);
                key[k][l] = x;
                alp.replace(x + "", "");
            }
        }
        for (int i = 0; i < alp.length(); i++) {
            char x = alp.charAt(i);
            if (!pfs.contains(x + "")) {
                int k = pfs.length() / 5;
                int l = (pfs.length() % 5);
                pfs += x;
                // System.out.println("pfs:" + pfs + "::" + pfs.length() + "\nk:" + k + "\nl:" +
                // l);
                key[k][l] = x;
                alp.replace(x + "", "");
            }
        }
        for (char[] i : key) {
            for (char j : i) {
                System.out.print("|\t" + j + "\t|");
            }
            System.out.println();
        }
        String ptc[] = { pt, "y" };
        while (ptc[1] == "y") {
            ptc = checkpt(pt);
            pt = ptc[0];
        }
        if (pt.length() % 2 != 0)
            pt = pt + "z";
        String di[] = new String[pt.length() / 2];
        for (int i = 0; i < di.length; i++) {
            char k = pt.charAt(i * 2);
            char l = pt.charAt((i * 2) + 1);
            di[i] = String.valueOf(k) + String.valueOf(l);
            // System.out.println(i + " : " + k + l);
        }
        String res = "";
        for (String s : di) {
            char k = s.charAt(0);
            char l = s.charAt(1);
            int ki = pfs.indexOf(k);
            int li = pfs.indexOf(l);
            int ka[] = { ki / 5, ki % 5 };
            int la[] = { li / 5, li % 5 };
            if (!(ka[0] == la[0] || ka[1] == la[1])) {
                res = res + key[ka[0]][la[1]] + key[la[0]][ka[1]];
            } else if (ka[0] == la[0]) {
                res = res + key[ka[0]][(la[1] + 1) % 5] + key[la[0]][(ka[1] + 1) % 5];
            } else if (ka[1] == la[1]) {
                // System.out.println("k1 " + ((ka[0] + 1) % 5) + "," + la[1] + "\nk2 " +
                // ((la[0] + 1) % 5) + "," + ka[1]);
                res = res + key[(ka[0] + 1) % 5][la[1]] + key[(la[0] + 1) % 5][ka[1]];
            }
        }

        System.out.println("Encrypted Text : " + res);

    }

    private static String[] checkpt(String pt) {
        for (int i = 0; i < pt.length() / 2; i++) {
            char k = pt.charAt(i * 2);
            char l = pt.charAt((i * 2) + 1);
            String x = k + "" + l;
            if (k == l) {
                String y = k + "x" + l;
                String res = addChar(pt, 'x', (i * 2) + 1);
                // System.out.println(x + "::" + y + "::" + res);
                return new String[] { res, "y" };
            }
        }
        return new String[] { pt, "n" };
    }

    public static String addChar(String str, char ch, int position) {
        return str.substring(0, position) + ch + str.substring(position);
    }

}
