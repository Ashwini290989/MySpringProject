package se.ashwini.myspringproject.manager;

public class ManagerInfo {
    private String title;
    private String InfoText;

    public ManagerInfo(String title, String infoText) {
        this.title = title;
        InfoText = infoText;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInfoText() {
        return InfoText;
    }

    public void setInfoText(String infoText) {
        InfoText = infoText;
    }
}
