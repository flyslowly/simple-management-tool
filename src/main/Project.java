package main;

public class Project {

    private String projectName;
    private Member []members;
    private Risk []risks;
    private Task []tasks;
    private ScheduleVariance scheduleVariance;
    private EarnedValue earnedValue;
    private CostVariance costVariance;

    public Project(String projectName, Risk[] risks, Task[] tasks, ScheduleVariance sv, EarnedValue ev, CostVariance cv){
        this.projectName = projectName;
        this.risks = risks;
        this.tasks = tasks;
        this.scheduleVariance = sv;
        this.earnedValue = ev;
        this.costVariance = cv;
    }


    public void showSchedule(){
        System.out.println("  Project Schedule");
        System.out.println();
        System.out.printf("%15s%-4s%-4s%-4s%-4s%-4s%-4s%-4s%-2s%n","","W1","W2","W3","W4","W5","W6","W7","W8");
        System.out.println("Task Name");
        for (Task task:tasks) {
            System.out.printf("%-15s",task.getTaskName());
            if (task.getStartWeek() == task.getEndWeek()){
                for (int i = 1; i < 9; i++) {
                    if (task.getStartWeek() == i){
                        System.out.printf("%s","**");
                    }else if (task.getStartWeek() > i){
                        System.out.printf("%4s","");
                    }
                }
                System.out.printf("%n");
            }else {
                for (int i = 1; i < 9; i++) {
                    if (task.getStartWeek() == i && task.getStartWeek() < 8){
                        System.out.printf("%s","****");
                        for (int j = i + 1; j < 9; j++) {
                            if (task.getEndWeek() > j) {
                                System.out.printf("%s", "****");
                            } else if (task.getEndWeek() == j) {
                                System.out.printf("%s", "**");
                            }
                        }
                    }else if (task.getStartWeek() > i){
                        System.out.printf("%4s","");
                    }
                }
                System.out.printf("%n");
            }
        }
    }

    public void showRiskMatrix(){
        System.out.printf("%18s%s%n","","Risk Matrix");
        System.out.println(".....................................");
        System.out.printf("%18s%-2s%-2s%-2s%-2s%-2s%-2s%-2s%-2s%-2s%n","","1","2","3","4","5","6","7","8","9");
        System.out.println("Description");
        for (Risk risk:risks) {
            System.out.printf("%-18s",risk.getRiskName());
            for (int i = 1; i < 10; i++) {
                if (risk.getRiskValue() == i){
                    System.out.printf("%s","+");
                }else if (risk.getRiskValue() > i){
                    System.out.printf("%s","++");
                }
            }
            System.out.printf("%n");
        }
    }

    //Getters and setters
    public String getProjectName() {
        return this.projectName;
    }

    public Member[] getMembers() {
        return members;
    }

    public Risk[] getRisks() {
        return risks;
    }

    public Task[] getTasks() {
        return tasks;
    }

    public ScheduleVariance getScheduleVariance() {
        return scheduleVariance;
    }

    public CostVariance getCostVariance() {
        return costVariance;
    }

    public EarnedValue getEarnedValue() {
        return earnedValue;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public void setMembers(Member []members){
        this.members = members;
    }

    public void setRisks(Risk []risks){
        this.risks = risks;
    }

    public void setTasks(Task []tasks){
        this.tasks = tasks;
    }

    public void setScheduleVariance(ScheduleVariance scheduleVariance) {
        this.scheduleVariance = scheduleVariance;
    }

    public void setEarnedValue(EarnedValue earnedValue) {
        this.earnedValue = earnedValue;
    }

    public void setCostVariance(CostVariance costVariance) {
        this.costVariance = costVariance;
    }

}
