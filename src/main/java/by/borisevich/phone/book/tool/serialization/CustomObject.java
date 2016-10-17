package by.borisevich.phone.book.tool.serialization;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * Created by dima on 10/6/16.
 */
public class CustomObject implements Externalizable {
    private boolean b;

    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeBoolean(b);
    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        b = in.readBoolean();
    }

    public boolean isB() {
        return b;
    }

    public void setB(boolean b) {
        this.b = b;
    }
}
