package se.ashwini.myspringproject;

import org.springframework.security.core.Authentication; // authentication for currently logged in user
import org.springframework.security.core.context.SecurityContextHolder; //provides access to the security context, which holds information about the currently authenticated user.
import org.springframework.stereotype.Controller; // controller handles HTTP request
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping; // for giving path to our page
import se.ashwini.myspringproject.admin.AdminComponent;
import se.ashwini.myspringproject.admin.AdminDocument;
import se.ashwini.myspringproject.manager.ManagerComponent;
import se.ashwini.myspringproject.manager.ManagerInfo;

import java.util.List;

@Controller
public class WebController {
    private final AdminComponent adminComponent; // dependency injection with constructors
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

    /**
     * @GETMapping used to map get  request.
     * @param model as a parameter, which will send data from your controller to viewpage.
     * add an attribute to the model
     * @return login is the HTML page
     */
    @GetMapping("/user")
    public String ShowMyUserName(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        model.addAttribute("username", username);
        return "user";

        /**
         * handles get request for user.
         * model is a parameter, which will send to data from your controller to viewpage.
         *retrives the authentication details for currently logged in user.
         * SecurityContextHolder holds the security context, which includes information about the current user (like their identity and roles).
         * The getAuthentication() method provides the details of the authenticated use.
         * returns the username as a string
         * adds an attribute to the user
         * return HTML page.
         */


    }
    @GetMapping("/admin")
    public String admin(Model model) {
        List<AdminDocument> documents = adminComponent.getDocuments();
        model.addAttribute("documents", documents);
        return "admin";

    }

    /**
     * handles get request for admin
     * getDocuments method is called from admin component. AdminDocument is class.
     * Adds the documents list to the model under the key "documents".
     * @return admin HTML page.
     */


    @GetMapping("/manager")
    public String manager(Model model) {
        List<ManagerInfo> managerInfoList= managerComponent.getManagerInfo();
        model.addAttribute( "managerInfoList", managerInfoList);
        return "manager";

    }
    /**
     * handles get request for manager.
     * getManagerInfo method is called from manager component. Manager info is class.
     * Adds the manager INFO list to the model under the key managerINfoList.
     * @return manager HTML page.
     */

}
