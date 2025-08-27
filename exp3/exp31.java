package hi;
import java.util.Scanner;
import java.util.Arrays;
public class exp31 {                                                //check aplhabetics
                                                                     // character.isAlphabetic(char value) 
	public static void main(String[] args) {                          //character.isdigit(char value)
        Scanner sc = new Scanner(System.in);
        String name;
        System.out.println("enter any string:");
           name = sc. next();
           char arr[]= name.toCharArray();
        char c = name.charAt(0);
        for (int i=1;i<arr.length;i++){
        	if( c == arr[i]) {
              arr[i]='$';
        	}   	
        }
         String r_str = Arrays.toString(arr);
         String rv=r_str.replace(',', ' ');
         String sr = rv.replace('[', ' ');
         String re = sr.replace(']',' ');
        System.out.println("the replaced  string: "+re);           
	}
}