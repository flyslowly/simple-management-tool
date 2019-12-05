package main;

public class CostVariance {

    private double costVariance;
    private double BCOW; //Budgeted Cost of Work
    private double ACOW; //Actual Cost of Work

    public CostVariance(double BCOW, double ACOW){

        this.BCOW = BCOW;
        this.ACOW = ACOW;
        this.costVariance = BCOW - ACOW;
    }

    public double getBCOW() {
        return BCOW;
    }

    public double getACOW() {
        return ACOW;
    }

    public void setBCOW(double BCOW) {
        this.BCOW = BCOW;
    }

    public void setACOW(double ACOW) {
        this.ACOW = ACOW;
    }

    public double getCostVariance(){
        return costVariance;
    }

    public String toString() {
        return "Cost Variance: " + costVariance;
    }
}
