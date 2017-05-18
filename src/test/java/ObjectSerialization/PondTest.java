package ObjectSerialization;

import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by FAB3659 on 2017-05-18.
 */
public class PondTest {

    @Test
    public void name() throws IOException {
        Pond  p = new Pond();
        p.getDucks().add(new Duck());

        FileOutputStream os = new FileOutputStream("./outputDirectory/pond.out");
        ObjectOutputStream writer = new ObjectOutputStream(os);
        writer.writeObject(p);
    }

}