/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
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

@XmlRootElement(name = "benhnhan")
@XmlAccessorType(XmlAccessType.FIELD)
public class BenhnhanXML {
    
    private List<Benhnhan> BN;

    public List<Benhnhan> getBenhnhan() {
        return BN;
    }

    public void setBenhnhan(List<Benhnhan> BN) {
        this.BN = BN;
    }
}
