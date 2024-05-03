package Benhnhan.Dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import Benhnhan.entity.Benhnhan;
import Benhnhan.entity.BenhnhanXML;
import Benhnhan.utils.FileUtils;

/**
 * StudentDao class
 * 
 * @author viettuts.vn
 */
public class BenhnhanDao {
    private static final String BENHNHAN_FILE_NAME = "benhnhan.xml";
    private List<Benhnhan> listBenhnhans;

    public BenhnhanDao() {
        this.listBenhnhans = readListBenhnhans();
        if (listBenhnhans == null) {
            listBenhnhans = new ArrayList<Benhnhan>();
        }
    }

    /**
     * Lưu các đối tượng benhnhan vào file benhnhan.xml
     * 
     * @param students
     */
    public void writeListBenhnhans(List<Benhnhan> benhnhan) {
        BenhnhanXML benhnhanXML = new BenhnhanXML();
        benhnhanXML.setBenhnhan(benhnhan);
        FileUtils.writeXMLtoFile(BENHNHAN_FILE_NAME, benhnhanXML);
    }

    /**
     * Đọc các đối tượng benhnhan từ file benhnhan.xml
     * 
     * @return list
     */
    public List<Benhnhan> readListBenhnhans() {
        List<Benhnhan> list = new ArrayList<Benhnhan>();
        BenhnhanXML benhnhanXML = (BenhnhanXML) FileUtils.readXMLFile(
                BENHNHAN_FILE_NAME, BenhnhanXML.class);
        if (benhnhanXML != null) {
            list = benhnhanXML.getBenhnhan();
        }
        return list;
    }
    

    /**
     * thêm benhnhan vào listBenhnhans và lưu listBenhnhans vào file
     * 
     * @param student
     */
    public void addbenhnhan(Benhnhan benhnhan) {
        
        listBenhnhans.add(benhnhan);
        writeListBenhnhans(listBenhnhans);
    }

    /**
     * cập nhật student vào listBenhnhans và lưu listbenhnhans vào file
     * 
     * @param student
     */
    public void editXML(Benhnhan benhnhan) {
        int size = listBenhnhans.size();
        for (int i = 0; i < size; i++) {
            if (listBenhnhans.get(i).getMaBenhNhan().equals(benhnhan.getMaBenhNhan())) {
            listBenhnhans.get(i).setHoTen(benhnhan.getHoTen());
            listBenhnhans.get(i).setNgaySinh(benhnhan.getNgaySinh());
            listBenhnhans.get(i).setGioiTinh(benhnhan.getGioiTinh());
            listBenhnhans.get(i).setQueQuan(benhnhan.getQueQuan());
            listBenhnhans.get(i).setHoKhauThuongTru(benhnhan.getHoKhauThuongTru());
            listBenhnhans.get(i).setMaBHYT(benhnhan.getMaBHYT());
            listBenhnhans.get(i).setTinhTrangXuatVien(benhnhan.getTinhTrangXuatVien());
            listBenhnhans.get(i).setNgayNhapVien(benhnhan.getNgayNhapVien());
            listBenhnhans.get(i).setNgayXuatVien(benhnhan.getNgayXuatVien());
            listBenhnhans.get(i).setTrieuChung(benhnhan.getTrieuChung());
            listBenhnhans.get(i).setChanDoan(benhnhan.getChanDoan());
            listBenhnhans.get(i).setChiDinh(benhnhan.getChiDinh());
            listBenhnhans.get(i).setBacSiKham(benhnhan.getBacSiKham());
            listBenhnhans.get(i).setKetLuan(benhnhan.getKetLuan());
            if(listBenhnhans.get(i).getHoTen().equals(benhnhan.getHoTen()) || listBenhnhans.get(i).getNgaySinh().equals(benhnhan.getNgaySinh())){
                listBenhnhans.get(i).setMaBenhNhan(null);
            }
            break;
            }
        }
       writeListBenhnhans(listBenhnhans);
    }

    public boolean deleteXML(Benhnhan benhnhan) {
    boolean isFound = false;
    int size = listBenhnhans.size();
    for (int i = 0; i < size; i++) {
        if (listBenhnhans.get(i).getMaBenhNhan().equals(benhnhan.getMaBenhNhan())) {
            benhnhan = listBenhnhans.get(i);
            isFound = true;
            listBenhnhans.remove(i); // Xóa bệnh nhân khỏi danh sách
            break;
        }
    }
    if (isFound) {
            listBenhnhans.remove(benhnhan);
            writeListBenhnhans(listBenhnhans);
            return true;
        }
    return false;
}

    /**
     * sắp xếp danh sách theo tên theo tứ tự tăng dần
     */
    public void sortBenhnhanByTen() {
        Collections.sort(listBenhnhans, new Comparator<Benhnhan>() {
            public int compare(Benhnhan BN1, Benhnhan BN2) {
                return BN1.getHoTen().compareTo(BN2.getHoTen());
            }
        });
    }
    public void sortBenhnhanByTinhTrang() {
        Collections.sort(listBenhnhans, new Comparator<Benhnhan>() {
            public int compare(Benhnhan BN1, Benhnhan BN2) {
                return BN1.getTinhTrangXuatVien().compareTo(BN2.getTinhTrangXuatVien());
            }
        });
    }

    /**
     * sắp xếp danh sách theo tuổi theo tứ tự tăng dần
     */
    
    public List<Benhnhan> getListBenhnhans() {
        return listBenhnhans;
    }

    public void setListBenhnhans(List<Benhnhan> listBenhnhans) {
        this.listBenhnhans = listBenhnhans;
    }
}