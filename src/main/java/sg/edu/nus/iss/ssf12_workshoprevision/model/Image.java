package sg.edu.nus.iss.ssf12_workshoprevision.model;

public class Image {

    private String name;
    private String filePath;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String toString() {
        return "Image [name=" + name + ", filePath=" + filePath + "]";
    } 
}
