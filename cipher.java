import java.util.*;
public class cipher{

    public static void main(String args[]){
        String alp = "abcdefghijklmnopqrstuvwxyz 0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String to be Encrypted : ");
        String plain = sc.nextLine();
        String enc = "";
        for(int i =0;i<plain.length();i++){
            char c = plain.charAt(i);
            int x = alp.indexOf(c);
            x = (x+3)%alp.length();
            enc += alp.charAt(x);
        }
        System.out.println("Encrypted String is : "+enc);
    }

}
