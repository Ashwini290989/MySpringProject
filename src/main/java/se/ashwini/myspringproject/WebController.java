package se.ashwini.myspringproject;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import se.ashwini.myspringproject.admin.AdminComponent;
import se.ashwini.myspringproject.admin.AdminDocument;
import se.ashwini.myspringproject.manager.ManagerComponent;
import se.ashwini.myspringproject.manager.ManagerInfo;

import java.util.List;

@Controller
public class WebController {
    private final AdminComponent adminComponent;
    private final ManagerComponent managerComponent;

    public WebController(AdminComponent adminComponent, ManagerComponent managerComponent) {
        this.adminComponent = adminComponent;
        this.managerComponent = managerComponent;
    }

    @GetMapping("/")
    public String firstpage(Model model) {
        model.addAttribute("message", "You are logged in");
        return "login";
    }

    @GetMapping("/user")
    public String ShowMyUserName(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        model.addAttribute("username", username);
        return "user";


    }
    @GetMapping("/admin")
    public String admin(Model model) {
        List<AdminDocument> documents = adminComponent.getDocuments();
        model.addAttribute("documents", documents);
        return "admin";
    }
    @GetMapping("/manager")
    public String manager(Model model) {
        List<ManagerInfo> managerInfoList= managerComponent.getManagerInfo();
        model.addAttribute( "managerInfoList", managerInfoList);
        return "manager";

    }

}
