package main;

class Task {

    private String taskName;
    private int startWeek;
    private int endWeek;

    Task(String taskName,int startWeek, int endWeek){

        this.taskName = taskName;
        this.startWeek= startWeek;
        this.endWeek= endWeek;

    }

    void showSchedule(){
        System.out.println("Task name: "+taskName +
                " Start Week:" + startWeek + " End Week: " + endWeek);

    }

    String getTaskName() {
        return taskName;
    }

    int getStartWeek() {
        return startWeek;
    }

    int getEndWeek() {
        return endWeek;
    }
}
