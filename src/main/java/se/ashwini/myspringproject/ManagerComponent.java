package se.ashwini.myspringproject;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class ManagerComponent {

    public List<ManagerInfo> getManagerInfo() {
        List<ManagerInfo> managerInfoList= new ArrayList<>();

        // Create three instances of AdminDocument
        ManagerInfo info1 = new ManagerInfo("Title 1", "DetailText 1");
        ManagerInfo info2 = new ManagerInfo("Title 2", "DetailText 2");
        ManagerInfo info3 = new ManagerInfo("Title 3", "DetailText 3");



        // Add them to a list
        managerInfoList.add(info1);
        managerInfoList.add(info2);
        managerInfoList.add(info3);

        // Return the list
        return managerInfoList;
    }
}
