/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Benhnhan.entity;

import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author VanQuyen
 */
public class Thuoc {
    private static HashMap<String, Integer> prefixCounts = new HashMap<>();
    private int STT;
    private String maThuoc;
    private String tenThuoc;
    private Date ngaySanXuat;
    private Date hanSuDung;
    private String donViTinh;
    private int soLuong;
    private double giaBan;
    private double tongTien;
    private String congDung;
    private String maBenhNhan;
    
    public Thuoc(){
        
    }
    public Thuoc(int STT, String maThuoc, String tenThuoc, Date ngaySanXuat, Date hanSuDung,
                 String donViTinh, int soLuong, double giaBan, double tongTien, String congDung,
                 String maBenhNhan) {
        this.STT = STT;
        this.maThuoc = maThuoc;
        this.tenThuoc = tenThuoc;
        this.ngaySanXuat = ngaySanXuat;
        this.hanSuDung = hanSuDung;
        this.donViTinh = donViTinh;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
        this.tongTien = tongTien;
        this.congDung = congDung;
        this.maBenhNhan = maBenhNhan;
    }
    
    
    public int getSTT() {
        return STT;
    }

    public void setSTT(int STT) {
        this.STT = STT;
    }
    public String getMaThuoc() {
        return maThuoc;
    }

    public void setMaThuoc(String maThuoc) {
        if (maThuoc != null) {
            this.maThuoc = maThuoc;
        } else {
            generateMaThuoc();
        }
    }

    public String getTenThuoc() {
        return tenThuoc;
    }

    public void setTenThuoc(String tenThuoc) {
        this.tenThuoc = tenThuoc;
    }

    public Date getNgaySanXuat() {
        return ngaySanXuat;
    }

    public void setNgaySanXuat(Date ngaySanXuat) {
        this.ngaySanXuat = ngaySanXuat;
    }

    public Date getHanSuDung() {
        return hanSuDung;
    }

    public void setHanSuDung(Date hanSuDung) {
        this.hanSuDung = hanSuDung;
    }


    public String getDonViTinh() {
        return donViTinh;
    }

    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public String getCongDung() {
        return congDung;
    }

    public void setCongDung(String congDung) {
        this.congDung = congDung;
    }

    public String getMaBenhNhan() {
        return maBenhNhan;
    }

    public void setMaBenhNhan(String maBenhNhan) {
        this.maBenhNhan = maBenhNhan;
    }
    private void generateMaThuoc() {
        // Tạo tiền tố từ các thông tin của thuốc
        char firstLetter = Character.toUpperCase(this.tenThuoc.charAt(0));
       String maThuocPrefix = String.valueOf(firstLetter);

        // Tạo mã thuốc dựa trên mã tiền tố và số thứ tự tăng dần
        int count = 1;
        if (prefixCounts.containsKey(maThuocPrefix)) {
            count = prefixCounts.get(maThuocPrefix) + 1;
        }
        prefixCounts.put(maThuocPrefix, count);
        this.maThuoc = maThuocPrefix + String.format("%04d", count);
    }
}
