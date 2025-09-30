package poly.edu.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    @Autowired
    private HttpServletRequest request;
    @GetMapping("/login/form")
    public String form() {
        return "poly/form";
    }
    @PostMapping("/login/check")
    public String login(Model model) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if ("poly".equals(username) && "123".equals(password)) {
            model.addAttribute("message", "Đăng nhập thành công! Xin chào " + username);
        } else {
            model.addAttribute("message", "Sai tên đăng nhập hoặc mật khẩu!");
        }
        return "poly/form";
    }
}
