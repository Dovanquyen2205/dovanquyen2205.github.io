/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Benhnhan.entity;

/**
 *
 * @author VanQuyen
 */

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "thuoc")
@XmlAccessorType(XmlAccessType.FIELD)
public class ThuocXML {
    private List<Thuoc> thuoc;

    public List<Thuoc> getThuoc() {
        return thuoc;
    }

    public void setThuoc(List<Thuoc> thuoc) {
        this.thuoc = thuoc;
    }
}
