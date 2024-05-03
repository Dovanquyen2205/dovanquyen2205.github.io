package Benhnhan.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Benhnhan.Dao.BenhnhanDao;
import Benhnhan.Dao.ThuocDao;
import Benhnhan.View.AddBenhnhanJFrame;
import Benhnhan.View.AddThuocJFrame;
import Benhnhan.entity.Benhnhan;
import Benhnhan.View.BenhnhanView;
import Benhnhan.entity.Thuoc;
import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class BenhnhanController {
    private BenhnhanDao benhnhandao;
    private BenhnhanView benhnhanview;
    private ThuocDao thuocdao;

    public BenhnhanController(BenhnhanView view) {
        this.benhnhanview = view;
        benhnhandao = new BenhnhanDao();
        benhnhandao = new BenhnhanDao();
        thuocdao = new ThuocDao();
        //bệnh nhân
        benhnhanview.addButtonXoaListener(new DeleteBenhnhanListener());
        benhnhanview.addButtonClearListener(new ClearBenhnhanListener());
        benhnhanview.addButtonsapxeptheotenListener(new SortBenhnhanNameListener());
        benhnhanview.addButtonsapxeptheoIDListener(new SortBenhnhanTinhTrangListener());
        benhnhanview.addListBenhnhanListener(new ListBenhnhanListener());
        benhnhanview.addButtonSuaListener(new SuaBenhnhanListener());
        benhnhanview.addButtonThemBenhnhanListener(new AddBenhnhanListener());
        benhnhanview.addSearchListener(new SearchDocument());
        benhnhanview.addXuatVienListenner(new XuatVien());
        //bệnh án
        
        benhnhanview.addListBenhAnListener(new ListBenhAnListener());
        //thuốc
        benhnhanview.addButtonsuathuocListener(new SuaThuocListener());
        benhnhanview.addButtonxoathuocListener(new XoaThuocListener());
        benhnhanview.addButtonthemthuocListener(new ThemThuocListener());
        benhnhanview.addListThuocListener(new ListThuocListener());
    }
    // show màn hình 
    public void showBenhnhanView() {
        List<Benhnhan> benhnhanList = benhnhandao.getListBenhnhans();
        benhnhanview.setVisible(true);
        benhnhanview.showtablebenhnhan(benhnhanList);
        List<Thuoc> thuoclist = thuocdao.getListThuocs();
        benhnhanview.showtablethuoc(thuoclist);
    }
    
    class AddBenhnhanListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            AddBenhnhanJFrame addview = new AddBenhnhanJFrame();
            addview.setVisible(true);
            ButtonLuuListener buttonLuuListener = new ButtonLuuListener(addview);
            addview.addThemBenhnhanListener(buttonLuuListener);
        }
    }
    
    // tao class add
    class ButtonLuuListener implements ActionListener {

        private AddBenhnhanJFrame addview;

        public ButtonLuuListener(AddBenhnhanJFrame addview) {
            this.addview = addview;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Benhnhan benhnhan = addview.getBenhnhanInfo();
            if (benhnhan != null) {
                benhnhandao.addbenhnhan(benhnhan);
                benhnhanview.showtablebenhnhan(benhnhandao.getListBenhnhans());
                benhnhanview.showMessage("Thêm thành công!");
                addview.setVisible(false);
            }
        }
    }
    
    class SearchDocument implements DocumentListener{

        @Override
        public void insertUpdate(DocumentEvent e) {
            List<Benhnhan> listBenhnhans = benhnhandao.getListBenhnhans();
            if(benhnhanview.checkSeachtextNull()){
                benhnhanview.showtablebenhnhan(listBenhnhans);
            }else{
                benhnhanview.showtablebenhnhan(benhnhanview.SearchList(listBenhnhans));
            }
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            List<Benhnhan> listStudents = benhnhandao.getListBenhnhans();
            if(benhnhanview.checkSeachtextNull()){
                benhnhanview.showtablebenhnhan(listStudents);
            }else{
                benhnhanview.showtablebenhnhan(benhnhanview.SearchList(listStudents));
            }
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            
        }
        
    }
    // sửa thông tin bệnh nhân
    class SuaBenhnhanListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Benhnhan benhnhan = benhnhanview.getBenhnhanInfo();
            if (benhnhan != null) {
                benhnhandao.editXML(benhnhan);
                benhnhanview.showBenhNhan(benhnhan);
                benhnhanview.showMessage("Sửa thành công!");

            }
            benhnhanview.showtablebenhnhan(benhnhandao.getListBenhnhans());
        }
    }
    class XuatVien implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Benhnhan benhnhan = benhnhanview.getBenhnhanInfo();
            if (benhnhan != null) {
                if(benhnhan.getTinhTrangXuatVien() != null) 
                    benhnhan.setTinhTrangXuatVien("Đã xuất viện");
                benhnhandao.editXML(benhnhan);
                benhnhanview.showBenhNhan(benhnhan);
                benhnhanview.showMessage("Xuất viện thành công!");

            }
            benhnhanview.showtablebenhnhan(benhnhandao.getListBenhnhans());
        }
    }
    // xóa bệnh nhân
    class DeleteBenhnhanListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Benhnhan benhnhan = benhnhanview.getBenhnhanInfo();
            if (benhnhan != null) {
                benhnhandao.deleteXML(benhnhan);
                benhnhanview.ClearBenhnhan();
                benhnhanview.showMessage("Xóa thành công!");
            }
            benhnhanview.showtablebenhnhan(benhnhandao.getListBenhnhans());
        }
    }
    
    // clear nhan
    class ClearBenhnhanListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            benhnhanview.ClearBenhnhan();
        }
    }
    
    // sắp xếp theo name
    class SortBenhnhanNameListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            benhnhandao.sortBenhnhanByTen();
            benhnhanview.showtablebenhnhan(benhnhandao.getListBenhnhans());
        }
    }
    
    
    class SortBenhnhanTinhTrangListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            benhnhandao.sortBenhnhanByTinhTrang();
            benhnhanview.showtablebenhnhan(benhnhandao.getListBenhnhans());
        }
    }
    
    class ListBenhnhanListener implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent e) {
            try {
                benhnhanview.showhangduocchonbenhnhan(benhnhandao.getListBenhnhans());
            } catch (ParseException ex) {
                Logger.getLogger(BenhnhanController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    class ListBenhAnListener implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent e) {
            try {
                benhnhanview.showhangduocchonbenhan(benhnhandao.getListBenhnhans());
            } catch (ParseException ex) {
                Logger.getLogger(BenhnhanController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    // list Thuốc
    class ListThuocListener implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent e) {
            try {
                benhnhanview.showhangduocchonthuoc(thuocdao.getListThuocs());
            } catch (ParseException ex) {
                Logger.getLogger(BenhnhanController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    // Thêm thuốc
    class ThemThuocListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            AddThuocJFrame addview = new AddThuocJFrame();
            addview.setVisible(true);
            ButtonLuuThuocListener buttonLuuListener = new ButtonLuuThuocListener(addview);
            addview.addThemBenhnhanListener(buttonLuuListener);
        }
    }
    
     class ButtonLuuThuocListener implements ActionListener {

        private AddThuocJFrame addview;

        public ButtonLuuThuocListener(AddThuocJFrame addview) {
            this.addview = addview;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Thuoc thuoc = addview.getThuocInfo();
            if (thuoc != null) {
                thuocdao.addthuoc(thuoc);
                benhnhanview.showThuoc(thuoc);
                benhnhanview.showtablethuoc(thuocdao.getListThuocs());
                benhnhanview.showMessage("Thêm thành công!");
                addview.setVisible(false);
            }
        }
    }
    // Sửa thuốc
     class SuaThuocListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Thuoc thuoc = benhnhanview.getThuocInfo();
            if (thuoc != null) {
                thuocdao.editthuoc(thuoc);
                benhnhanview.showtablethuoc(thuocdao.getListThuocs());
                benhnhanview.showMessage("Sửa thành công!");
            }
        }
    }
     
    // xóa thuốc
    class XoaThuocListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Thuoc thuoc = benhnhanview.getThuocInfo();
            if (thuoc != null) {
                thuocdao.deletethuoc(thuoc);
                benhnhanview.ClearThuoc();
                benhnhanview.showMessage("Xóa thành công!");
            }
            benhnhanview.showtablethuoc(thuocdao.getListThuocs());
        }
    }
}
