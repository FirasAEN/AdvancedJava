package ObjectSerialization;

import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by FAB3659 on 2017-05-18.
 */
public class FooTest {

    @Test
    public void saveObject() throws IOException {
        Foo foo = new Foo();

        FileOutputStream outputStream = new FileOutputStream("./outputDirectory/foo.out");
        ObjectOutputStream objectWriter = new ObjectOutputStream(outputStream);
        objectWriter.writeObject(foo);

        outputStream.close();

    }
}