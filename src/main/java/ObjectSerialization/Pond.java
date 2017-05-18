package ObjectSerialization;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by FAB3659 on 2017-05-18.
 */
public class Pond  implements Serializable{
    private transient List<Duck> ducks = new ArrayList<>();

    public List<Duck> getDucks() {
        return ducks;
    }

    public void setDucks(List<Duck> ducks) {
        this.ducks = ducks;
    }
}
