/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Run;

/**
 *
 * @author VanQuyen
 */

import Benhnhan.Controller.LoginController;
import Benhnhan.View.LoginView;
import java.awt.EventQueue;

public class Run {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            LoginView view = new LoginView();
            LoginController controller = new LoginController(view);
            // hiển thị màn hình login
            controller.showLoginView();
        });
    }
}
