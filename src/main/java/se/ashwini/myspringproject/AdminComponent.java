package se.ashwini.myspringproject;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class AdminComponent {
    public List<AdminDocument> getDocuments() {
        List<AdminDocument> documents = new ArrayList<>();

        // Create three instances of AdminDocument
        AdminDocument doc1 = new AdminDocument("Title 1", "Description 1");
        AdminDocument doc2 = new AdminDocument("Title 2", "Description 2");
        AdminDocument doc3 = new AdminDocument("Title 3", "Description 3");

        // Add them to a list
        documents.add(doc1);
        documents.add(doc2);
        documents.add(doc3);

        // Return the list
        return documents;
    }
}

