package by.borisevich.phone.book.tool;

import javax.xml.bind.annotation.*;
import java.io.*;

/**
 * Created by dima on 10/6/16.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(name = "dataObj")
public class DataObject extends NonSerializable implements Externalizable {
    @XmlElement
    private int i;
    @XmlElement
    private String s;

    private String[] def;
    @XmlElement
    private CustomObject customObject = new CustomObject();

    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(s);
        out.writeObject(getMyData());
        out.writeObject(getCustomObject());
    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        s = (String) in.readObject();
        setMyData((String) in.readObject());
        setCustomObject((CustomObject) in.readObject());
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public String[] getDef() {
        return def;
    }

    public void setDef(String[] def) {
        this.def = def;
    }

    public CustomObject getCustomObject() {
        return customObject;
    }

    public void setCustomObject(CustomObject customObject) {
        this.customObject = customObject;
    }
}

//public class DataObject extends NonSerializable implements Externalizable{
//    private int i;
//    private String s;
//    private String[] def;
//    private CustomObject customObject = new CustomObject();
//
//    public void writeExternal(ObjectOutput out) throws IOException {
//        out.writeObject(s);
//        out.writeObject(getMyData());
//        out.writeObject(getCustomObject());
//    }
//
//    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
//        s = (String) in.readObject();
//        setMyData((String) in.readObject());
//        setCustomObject((CustomObject) in.readObject());
//    }
//
//    public int getI() {
//        return i;
//    }
//
//    public void setI(int i) {
//        this.i = i;
//    }
//
//    public String getS() {
//        return s;
//    }
//
//    public void setS(String s) {
//        this.s = s;
//    }
//
//    public String[] getDef() {
//        return def;
//    }
//
//    public void setDef(String[] def) {
//        this.def = def;
//    }
//
//    public CustomObject getCustomObject() {
//        return customObject;
//    }
//
//    public void setCustomObject(CustomObject customObject) {
//        this.customObject = customObject;
//    }
//}

//public class DataObject extends NonSerializable implements Serializable{
//    private int i = 5;
//    private String s = "aaa";
//    private String[] def;
//    private CustomObject customObject = new CustomObject();
//
//    private void writeObject(ObjectOutputStream out) throws IOException{
//        out.defaultWriteObject();
//        out.writeObject(getMyData());
//    }
//
//    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException{
//        in.defaultReadObject();
//        setMyData((String) in.readObject());
//    }
//}
