public class Student {
    private String name;
    private String matric;
    private boolean hasBorrowed;  

    public Student(String name, String matric) {
        this.name = name;
        this.matric = matric;
        hasBorrowed = false;
    }

    public String getName() {
        return name;
    }

    public String getMatric() {
        return matric;
    }

    public boolean getHasBorrowed() {
        return hasBorrowed;
    }

    //claude
    public void setHasBorrowed(boolean hasBorrowed) {
        this.hasBorrowed = hasBorrowed;
    }
    //end claude

    
    public String toString() {
        return name + " (" + matric + ")";
    }
}
