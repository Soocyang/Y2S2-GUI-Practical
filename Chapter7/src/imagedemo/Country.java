package imagedemo;

import java.io.Serializable;
import java.util.*;
import javax.swing.ImageIcon;

public class Country implements Serializable {
    private String name;
    private String fullName;
    private String capital;
    private ImageIcon flag;

    public Country() {
    }

    public Country(String name, String fullName, String capital, ImageIcon flag) {
        this.name = name;
        this.fullName = fullName;
        this.capital = capital;
        this.flag = flag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public ImageIcon getFlag() {
        return flag;
    }

    public void setFlag(ImageIcon flag) {
        this.flag = flag;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Country other = (Country) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format("%-50s %-50s %-50s", name, fullName, capital);
    }
}
