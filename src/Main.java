import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    final static SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd_HHmmss");
    static DbxClientV2 client = null;
    static Date date;

    public static void main(String[] args) throws AWTException {

        final String ACCESS_TOKEN = "3ZFJM89xGXYAAAAAAAAAAazHS5vEVaI7wT_dijz_wg2PosqqzGtdOH9KB53WLMHu";

        DbxRequestConfig config = DbxRequestConfig.newBuilder("dropbox/java-tutorial").build();
        client = new DbxClientV2(config, ACCESS_TOKEN);

        for (;;) {
            BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
            date = new Date();
            MyThread thread = new MyThread(image);
            thread.start();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
