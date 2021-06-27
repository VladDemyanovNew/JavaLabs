package by.VDemyanov.JMS_Lab14.P2Pold;

import java.io.Serializable;

public class MyClass implements Serializable {
    static final long serialVersionUID = 42L;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    private int id;
    private String text;
}
