import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyThread extends Thread{

    private DbxClientV2 clientV2;
    private BufferedImage image;

    MyThread (DbxClientV2 clientV2, BufferedImage image) {
        this.clientV2 = clientV2;
        this.image = image;
    }

    @Override
    public void run() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd_HHmmss");
        Date date = new Date();

        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ImageIO.write(image, "png", outputStream);
            InputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
            //InputStream inputStream = new FileInputStream("/123.txt");
            clientV2.files().uploadBuilder("/" + formatter.format(date) + ".png").uploadAndFinish(inputStream);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
