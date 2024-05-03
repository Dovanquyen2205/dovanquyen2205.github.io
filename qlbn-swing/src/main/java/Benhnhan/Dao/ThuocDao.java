/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Benhnhan.Dao;

/**
 *
 * @author VanQuyen
 */

import java.util.ArrayList;
import java.util.List;

import Benhnhan.entity.Thuoc;
import Benhnhan.entity.ThuocXML;
import Benhnhan.utils.FileUtils;
public final class ThuocDao {
    private static final String THUOC_FILE_NAME = "thuoc.xml";
    private List<Thuoc> listThuocs;
    
    public ThuocDao() {
        this.listThuocs = readListThuocs();
        if (listThuocs == null) {
            listThuocs = new ArrayList<Thuoc>();
        }
    }
    public void writeListThuocs(List<Thuoc> thuocs) {
        ThuocXML thuocXML = new ThuocXML();
        thuocXML.setThuoc(thuocs);
        FileUtils.writeXMLtoFile(THUOC_FILE_NAME, thuocXML);
    }
    
    public List<Thuoc> readListThuocs() {
        List<Thuoc> list = new ArrayList<Thuoc>();
        ThuocXML thuocXML = (ThuocXML) FileUtils.readXMLFile(
                THUOC_FILE_NAME, ThuocXML.class);
        if (thuocXML != null) {
            list = thuocXML.getThuoc();
        }
        return list;
    }
    
    public void addthuoc(Thuoc thuoc) {
        int STT = 1;
        if (listThuocs != null && !listThuocs.isEmpty()) {
            STT = listThuocs.size() + 1;
        }
        thuoc.setSTT(STT);
        listThuocs.add(thuoc);
        writeListThuocs(listThuocs);
    }
    
    
    public void editthuoc(Thuoc thuoc) {
    int size = listThuocs.size();
    for (int i = 0; i < size; i++) {
            if (listThuocs.get(i).getMaThuoc().equals(thuoc.getMaThuoc())) {
            listThuocs.get(i).setMaThuoc(null);
            listThuocs.get(i).setTenThuoc(thuoc.getTenThuoc());
            listThuocs.get(i).setNgaySanXuat(thuoc.getNgaySanXuat());
            listThuocs.get(i).setHanSuDung(thuoc.getHanSuDung());
            listThuocs.get(i).setDonViTinh(thuoc.getDonViTinh());
            listThuocs.get(i).setSoLuong(thuoc.getSoLuong());
            listThuocs.get(i).setGiaBan(thuoc.getGiaBan());
            listThuocs.get(i).setTongTien(thuoc.getTongTien());
            listThuocs.get(i).setCongDung(thuoc.getCongDung());
            listThuocs.get(i).setMaBenhNhan(thuoc.getMaBenhNhan());
            writeListThuocs(listThuocs);
            break;
            }
        }
    }
    public boolean deletethuoc(Thuoc thuoc) {
        boolean isFound = false;
        int size = listThuocs.size();
        for (int i = 0; i < size; i++) {
            if (listThuocs.get(i).getMaBenhNhan().equals(thuoc.getMaBenhNhan())) {
                thuoc = listThuocs.get(i);
                isFound = true;
                break;
            }
        }
        if (isFound) {
            listThuocs.remove(thuoc);
            writeListThuocs(listThuocs);
            return true;
        }
        return false;
    }

   

//tìm kiếm theo tên thuốc
    public List<Thuoc> searchByName(String name) {
        List<Thuoc> result = new ArrayList<>();
        for (Thuoc thuoc : listThuocs) {
            if (thuoc.getTenThuoc().contains(name)) {
                result.add(thuoc);
            }
        }
        return result;
    }

    // Tìm kiếm thuốc theo STT
    public List<Thuoc> searchBySTT(int stt) {
        List<Thuoc> result = new ArrayList<>();
        for (Thuoc thuoc : listThuocs) {
            if (thuoc.getSTT() == stt) {
                result.add(thuoc);
            }
        }
        return result;
    }

    //tìm kiếm theo mã thuốc
    public List<Thuoc> searchByMaThuoc(String maThuoc) {
        List<Thuoc> result = new ArrayList<>();
        for (Thuoc thuoc : listThuocs) {
            if (thuoc.getMaThuoc().equals(maThuoc)) {
                result.add(thuoc);
            }
        }
        return result;
    }

    public List<Thuoc> getListThuocs() {
        return listThuocs;
    }

    public void setListThuocs(List<Thuoc> listThuocs) {
        this.listThuocs = listThuocs;
    }   
}
