package Benhnhan.Controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBException;

import Benhnhan.Dao.UserDao;
import Benhnhan.entity.User;
import Benhnhan.View.LoginView;
import Benhnhan.View.BenhnhanView;

public class LoginController {
    private UserDao userDao;
    private LoginView loginView;
    private BenhnhanView benhnhanView;
    
    public LoginController(LoginView view) {
        this.loginView = view;
        this.userDao = new UserDao();
        view.addLoginListener(new LoginListener());
    }
    
    public void showLoginView() {
        loginView.setVisible(true);
    }
    
    /**
     * Lớp LoginListener 
     * chứa cài đặt cho sự kiện click button "Login"
     * 
     * @author viettuts.vn
     */
    class LoginListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            User user = loginView.getUser();
            if (userDao.checkUser(user)) {
                // nếu đăng nhập thành công, mở màn hình quản lý sinh viên
                benhnhanView = new BenhnhanView();
                BenhnhanController benhnhanController = new BenhnhanController(benhnhanView);
                benhnhanController.showBenhnhanView();
                loginView.setVisible(false);
            } else {
                loginView.showMessage("username hoặc password không đúng.");
            }
        }
    }
}
