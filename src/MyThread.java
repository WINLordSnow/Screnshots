import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

public class MyThread extends Thread{

    private final BufferedImage image;

    MyThread (BufferedImage image) {
        this.image = image;
    }

    @Override
    public void run() {
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ImageIO.write(image, "png", outputStream);
            InputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
            Main.client.files().uploadBuilder("/" + Main.formatter.format(Main.date) + ".png").uploadAndFinish(inputStream);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
