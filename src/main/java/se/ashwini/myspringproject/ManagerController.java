package se.ashwini.myspringproject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@Controller
public class ManagerController {
    private final ManagerComponent managerComponent;

    public ManagerController(ManagerComponent managerComponent) {
        this.managerComponent = managerComponent;
    }

    @GetMapping("/manager")
    public String getManagerInfo(Model model) {
        // Fetch the list of ManagerInfo
        List<ManagerInfo> managerInfoList = managerComponent.getManagerInfo();

        // Add the list to the model
        model.addAttribute("managerInfoList", managerInfoList);

        // Return the name of the HTML view
        return "manager";
    }
}


