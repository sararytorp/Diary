public class Entry {
    private String titleOfEntry;
    private String contentOfEntry;
    private String dateOfEntry;

    public Entry(String titleOfEntry, String contentOfEntry, String dateOfEntry) {
        this.titleOfEntry = titleOfEntry;
        this.contentOfEntry = contentOfEntry;
        this.dateOfEntry = dateOfEntry;
    }

    public Entry() {
    }

    public String getTitleOfEntry() {
        return titleOfEntry;
    }

    public void setTitleOfEntry(String titleOfEntry) {
        this.titleOfEntry = titleOfEntry;
    }

    public String getContentOfEntry() {
        return contentOfEntry;
    }

    public void setContentOfEntry(String contentOfEntry) {
        this.contentOfEntry = contentOfEntry;
    }

    public String getDateOfEntry() {
        return dateOfEntry;
    }

    public void setDateOfEntry(String dateOfEntry) {
        this.dateOfEntry = dateOfEntry;
    }


}
