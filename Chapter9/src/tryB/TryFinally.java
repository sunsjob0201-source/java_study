package tryB;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TryFinally {

    public static void main(String[] args) {

        FileInputStream in = null;

        try {

            in = new FileInputStream("C:/data/nothing.gif");

        } catch (FileNotFoundException e) {

            System.out.println("ファイルが見つかりませんでした。");

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (in != null) {
                    in.close();
                }

            } catch (IOException e) {

                e.printStackTrace();
            }
        }
        
    }
}