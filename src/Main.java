import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws AWTException {
	// write your code here

        final String ACCESS_TOKEN = "TVhOhu1SDcEAAAAAAAAAAVzpkv8p5r1V5FzlevopLHwB__qIYwr6lHzgAYzfqBGX";

        BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));



        DbxRequestConfig config = DbxRequestConfig.newBuilder("dropbox/java-tutorial").build();
        DbxClientV2 client = new DbxClientV2(config, ACCESS_TOKEN);


        MyThread thread = new MyThread(client, image);
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
