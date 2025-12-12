package model;

public class Student {
    private int id;
    private String faculty;
    private String secondName;
    private String firstName;
    private double averageScore;

    public Student() {
    }

    public Student(int id, String faculty, String secondName, String firstName, double averageScore) {
        this.id = id;
        this.faculty = faculty;
        this.secondName = secondName;
        this.firstName = firstName;
        this.averageScore = averageScore;
    }

    public Student(String faculty, String secondName, String firstName, double averageScore) {
        this.faculty = faculty;
        this.secondName = secondName;
        this.firstName = firstName;
        this.averageScore = averageScore;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }
}