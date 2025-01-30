package se.ashwini.myspringproject.admin;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class AdminComponent {
    public List<AdminDocument> getDocuments() { // method which returns a list of admin documents object.
        List<AdminDocument> documents = new ArrayList<>(); //creates  empty list named document.

        // Create three instances of AdminDocument
        AdminDocument doc1 = new AdminDocument("Audit Trails", "Track user activities and changes made to the system");
        AdminDocument doc2 = new AdminDocument("Notification Settings", "Configure email and push notification preferences");
        AdminDocument doc3 = new AdminDocument("user feedback", "Review and respond to user feedback to improve system functionality");

        // Add them to a list
        documents.add(doc1);
        documents.add(doc2);
        documents.add(doc3);

        // Return the list
        return documents;
    }
}

