package main;

public class ScheduleVariance {

    private double scheduleVariance;
    private double BCOWP; //Budgeted Cost of Work Performed
    private double BCOWS; // Budgeted Cost of Work Scheduled

    public ScheduleVariance(double BCOWP, double BCOWS){

        this.BCOWP = BCOWP;
        this.BCOWS = BCOWS;
        this.scheduleVariance = BCOWP - BCOWS;
    }

    public double getScheduleVariance() {
        return scheduleVariance;
    }
    public String toString(){
        return "Schedule Variance: " + (BCOWP - BCOWS);
    }

    public double getBCOWP() {
        return BCOWP;
    }

    public double getBCOWS() {
        return BCOWS;
    }

    public void setBCOWP(double BCOWP) {
        this.BCOWP = BCOWP;
    }

    public void setBCOWS(double BCOWS) {
        this.BCOWS = BCOWS;
    }
}
