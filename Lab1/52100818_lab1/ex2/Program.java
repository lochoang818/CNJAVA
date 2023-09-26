import vn.edu.tdtu.ArrayHandler;
import vn.edu.tdtu.ArrayOutput;

import java.util.Arrays;

public class Program {
    public static void main (String[] arge){
        int[] a = {1,2,3,4,5};
        int[] b = {8,6,2,3,1};
        ArrayOutput.print(a);
        ArrayOutput.print(b);
        int[] c=ArrayHandler.merge(a,b);
        ArrayOutput.print(c);
        ArrayOutput.print(Arrays.stream(c).sorted().toArray());
        ArrayOutput.write(c,"output.txt");
    }
}
