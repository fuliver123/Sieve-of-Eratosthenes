import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Prime100m {

    static int MAX = 100000000;

    static void booleanFill(boolean[] arr, boolean value) {
        int len = arr.length;
        if (len > 0) {
            arr[0] = value;
        }
        for (int i = 1; i < len; i += i) {
            System.arraycopy(arr, 0, arr, i, ((len - i) < i) ? (len - i) : i);
        }
    }

    static void sangNGT(boolean[] arr) {
        booleanFill(arr, true);
        for (int i = 2; i * i < MAX; ++i) {
            if (arr[i]) {
                for (int j = i * i; j < MAX; j += i) {
                    arr[j] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        boolean[] arr = new boolean[MAX];
        sangNGT(arr);
        try {
            FileWriter fw = new FileWriter("Prime 100m.txt");
            for (int i = 2; i < MAX; ++i) {
                if (arr[i]) {
                    fw.write(i + " ");
                }
            }
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(Prime100m.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Time: " + ((double) (System.nanoTime() - start) / 1000000000));
    }
}
