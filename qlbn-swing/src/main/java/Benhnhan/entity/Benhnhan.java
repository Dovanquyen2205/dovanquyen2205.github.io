/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Benhnhan.entity;

/**
 *
 * @author VanQuyen
 */
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "student")
@XmlAccessorType(XmlAccessType.FIELD)

public class Benhnhan implements Serializable {
    private static HashMap<String, Integer> prefixCounts = new HashMap<>();
    private String hoTen;
    private Date ngaySinh;
    private String gioiTinh;
    private String SoDienThoai;
    private String queQuan;
    private String hoKhauThuongTru;
    private String maBenhNhan;
    private String maBHYT;
    private Date ngayNhapVien;
    private Date ngayXuatVien;
    private String trieuChung;
    private String chanDoan;
    private String chiDinh;
    private String bacSiKham;
    private String ketLuan;
    private String tinhTrangXuatVien;
    private byte[] imageBytes;
   
    public Benhnhan(String hoTen, Date ngaySinh, String gioiTinh,String SoDienThoai, String queQuan, String hoKhauThuongTru, 
                    int soPhong, String maBenhNhan, String maBHYT, Date ngayNhapVien, 
                    Date ngayXuatVien, String trieuChung, String chanDoan, String chiDinh, 
                    String bacSiKham, String ketLuan, String tinhTrangXuatVien) {
        
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.SoDienThoai = SoDienThoai;
        this.queQuan = queQuan;
        this.hoKhauThuongTru = hoKhauThuongTru;
        this.maBHYT = maBHYT;
        this.ngayNhapVien = ngayNhapVien;
        this.ngayXuatVien = ngayXuatVien;
        this.trieuChung = trieuChung;
        this.chanDoan = chanDoan;
        this.chiDinh = chiDinh;
        this.bacSiKham = bacSiKham;
        this.ketLuan = ketLuan;
        this.tinhTrangXuatVien = tinhTrangXuatVien;
        //lấy mã bệnh nhân theo công thức
        
        generateMaBenhNhan();
    }
    public Benhnhan() {
       
    }
    
    // Getter và setter cho thuộc tính 'ten'
    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }
    
    public String getSoDienThoai() {
        return SoDienThoai;
    }

    public void setSoDienThoai(String SoDienThoai) {
        this.SoDienThoai = SoDienThoai;
    }
    
    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public String getHoKhauThuongTru() {
        return hoKhauThuongTru;
    }

    public void setHoKhauThuongTru(String hoKhauThuongTru) {
        this.hoKhauThuongTru = hoKhauThuongTru;
    }


    private void generateMaBenhNhan() {
        // Lấy các chữ cái đầu từ họ tên
        String hoTenInitials = getInitialsFromHoTen(this.hoTen);

        // Format ngày sinh thành chuỗi "ddMMyyyy"
        SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
        String ngaySinhStr = dateFormat.format(this.ngaySinh);

        // Kết hợp chữ cái đầu từ họ tên và ngày sinh
        String maBenhNhanPrefix = hoTenInitials + ngaySinhStr;

        // Tạo mã bệnh nhân dựa trên mã tiền tố và số thứ tự tăng dần
        int count = 1;
        if (prefixCounts.containsKey(maBenhNhanPrefix)) {
            count = prefixCounts.get(maBenhNhanPrefix) + 1;
        }
        prefixCounts.put(maBenhNhanPrefix, count);
        this.maBenhNhan = maBenhNhanPrefix + String.format("%04d", count);
    }

    // Phương thức lấy chữ cái đầu từ họ tên
    private String getInitialsFromHoTen(String hoTen) {
        String[] parts = hoTen.split(" ");
        StringBuilder initials = new StringBuilder();
        for (String part : parts) {
            if (!part.isEmpty()) {
                initials.append(part.charAt(0));
            }
        }
        return initials.toString().toUpperCase();
    }
    public String getMaBenhNhan() {
        return maBenhNhan;
    }

    public void setMaBenhNhan(String mabenhnhan) {
        if(mabenhnhan != null){
            this.maBenhNhan = mabenhnhan;
        }
        else{
            generateMaBenhNhan();
        }
    }

    public String getMaBHYT() {
        return maBHYT;
    }

    public void setMaBHYT(String maBHYT) {
        this.maBHYT = maBHYT;
    }

    public Date getNgayNhapVien() {
        return ngayNhapVien;
    }

    public void setNgayNhapVien(Date ngayNhapVien) {
        this.ngayNhapVien = ngayNhapVien;
    }

    public Date getNgayXuatVien() {
        return ngayXuatVien;
    }

    public void setNgayXuatVien(Date ngayXuatVien) {
        this.ngayXuatVien = ngayXuatVien;
    }

    public String getTrieuChung() {
        return trieuChung;
    }

    public void setTrieuChung(String trieuChung) {
        this.trieuChung = trieuChung;
    }

    public String getChanDoan() {
        return chanDoan;
    }

    public void setChanDoan(String chanDoan) {
        this.chanDoan = chanDoan;
    }

    public String getChiDinh() {
        return chiDinh;
    }

    public void setChiDinh(String chiDinh) {
        this.chiDinh = chiDinh;
    }

    public String getBacSiKham() {
        return bacSiKham;
    }

    public void setBacSiKham(String bacSiKham) {
        this.bacSiKham = bacSiKham;
    }

    public String getKetLuan() {
        return ketLuan;
    }

    public void setKetLuan(String ketLuan) {
        this.ketLuan = ketLuan;
    }

    public String getTinhTrangXuatVien() {
        return tinhTrangXuatVien;
    }

    public void setTinhTrangXuatVien(String tinhTrangXuatVien) {
        if(tinhTrangXuatVien != null){
            this.tinhTrangXuatVien = tinhTrangXuatVien;
        }
    }
    
    public int getDoTuoi() {
        // Lấy ngày hiện tại
        Date now = new Date();
        
        // Tính số milliseconds từ ngày sinh đến ngày hiện tại
        long timeDiff = now.getTime() - ngaySinh.getTime();
        
        // Chuyển từ milliseconds sang số năm
        long years = timeDiff / 1000 / 60 / 60 / 24 / 365;

        return (int) years;
    }
    public byte[] getImageBytes() {
        return imageBytes;
    }

    public void setImageBytes(byte[] imageBytes) {
        this.imageBytes = imageBytes;
    }
}