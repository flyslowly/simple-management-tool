package main;

public class Member {

    private String id;
    private String name;
    private double salaryPerHour;
    private int timeSpent;
    private Project workProject;


    public Member(String id, String name, double salaryPerHour, int timeSpent){
        this.id = id;
        this.name = name;
        this.salaryPerHour = salaryPerHour;
        this.timeSpent = timeSpent;

    }


    public Member(String id, String name, double salaryPerHour, Project workProject, int timeSpent) {
        this.id = id;
        this.name = name;
        this.salaryPerHour = salaryPerHour;
        this.workProject = workProject;
        this.timeSpent = timeSpent;


    }

    public void showSpentTime(){
        System.out.println("Name: " +getName()+ " Id: " +getId() + " Time Spent: " + getTimeSpent());
    }

    public void showMemberInfo() {
        System.out.println("Name: " +getName()+ " Id: " +getId() +
                " Paticipated project: " + getWorkProject() +
                " Salary per hour: " + getSalaryPerHour() +"/hour  Spend: " +
                getTimeSpent() + " hours");;

    }

    //getters and setters


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalaryPerHour() {
        return salaryPerHour;
    }

    public int getTimeSpent() {
        return timeSpent;
    }

    public Project getWorkProject() {
        return workProject;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalaryPerHour(double salaryPerHour) {
        this.salaryPerHour = salaryPerHour;
    }

    public void setWorkProject(Project workProject) {
        this.workProject = workProject;
    }


}
