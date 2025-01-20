package se.ashwini.myspringproject;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class AdminController {

    private final AdminComponent adminComponent;
    public AdminController(AdminComponent adminComponent) {
        this.adminComponent = adminComponent;
    }
    @GetMapping("/documents")
    public String getDocuments(Model model) {
        List<AdminDocument>documents = adminComponent.getDocuments();
        model.addAttribute("documents", adminComponent.getDocuments());
        return "documents";


    }

}
