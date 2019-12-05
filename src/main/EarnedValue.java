package main;

public class EarnedValue {

    private double earnedValue;//TODO:Should it be the amount of work completed/scheduled amount of work completed in %?
    private double completedWork; //% of Completed Work
    private double BAC; //BAC = Budget at Completion

    public EarnedValue(double completedWork, double BAC){

        this.completedWork = completedWork;
        this.BAC = BAC;
        this.earnedValue = completedWork/BAC;
    }

    public double getEarnedValue() {
        return earnedValue;
    }

    public String toString(){
        return "Earned Value: " + earnedValue;
    }

    public double getCompletedWork() {
        return completedWork;
    }

    public double getBAC() {
        return BAC;
    }

    public void setCompletedWork(double completedWork) {
        this.completedWork = completedWork;
    }

    public void setBAC(double BAC) {
        this.BAC = BAC;
    }
}
