package by.borisevich.phone.book.tool.serialization;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * Created by dima on 10/6/16.
 */
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
public class NonSerializable {
    private String myData = "";

    public String getMyData() {
        return myData;
    }

    public void setMyData(String myData) {
        this.myData = myData;
    }
}
