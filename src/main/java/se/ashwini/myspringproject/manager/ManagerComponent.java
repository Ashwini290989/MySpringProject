package se.ashwini.myspringproject.manager;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class ManagerComponent {

    public List<ManagerInfo> getManagerInfo() {
        List<ManagerInfo> managerInfoList= new ArrayList<>();

        // Create three instances of AdminDocument
        ManagerInfo info1 = new ManagerInfo("Team overview", "Detail overview of performance and task");
        ManagerInfo info2 = new ManagerInfo("Project updates", "Latest updates on ongoing projects");
        ManagerInfo info3 = new ManagerInfo("Budget Management", "Tools and data for managing budgets");



        // Add them to a list
        managerInfoList.add(info1);
        managerInfoList.add(info2);
        managerInfoList.add(info3);

        // Return the list
        return managerInfoList;
    }
}
