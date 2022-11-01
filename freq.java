public class freq {

    public static void main(String[] args) {

        String enc = "UZQSOVUOHXMOPVGPOZPEVSGZWSZOPFPESXUDBMETSXAIZVUEPHZHMDZSHZOWSFPAPPDTSVPQUZWYMXUZUHSXEPYEPOPDZSZUFPOMBZWPFUPZHMDJUDTMOHMQ";

        String alp = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        int len = enc.length();
        double frq[] = new double[26];

        for (int i = 0; i < alp.length(); i++) {
            frq[i] = (getOccurance(alp.charAt(i), enc) / len) * 100;
            System.out.println(alp.charAt(i) + " : " + frq[i]);
        }

        System.out.println(enc);

        System.out.println(enc.replace('P', 'e')
                .replace('Z', 't')
                .replace('U', 'i')
                .replace('Q', 'w')
                .replace('S', 'a')
                .replace('O', 's')
                .replace('V', 'd')
                .replace('H', 'c')
                .replace('X', 'l')
                .replace('M', 'o')
                .replace('G', 'y')
                .replace('E', 'r')
                .replace('W', 'h')
                .replace('F', 'v')
                .replace('D', 'n')
                .replace('B', 'f')
                .replace('T', 'm')
                .replace('A', 'b')
                .replace('I', 'u')
                .replace('Y', 'p')
                .replace('J', 'g'));

    }

    private static double getOccurance(char c, String enc) {
        int x = 0;
        for (int i = 0; i < enc.length(); i++) {
            if (enc.charAt(i) == c)
                x++;
        }
        return x;
    }

}
