package main;

import javax.swing.plaf.PanelUI;

public class Risk{

    private String riskName;
    private int probability;
    private int impact;
    private int riskValue;

    public Risk(String riskName, int probability, int impact){

        this.riskName = riskName;
        this.probability = probability;
        this.impact = impact;
        this.riskValue = probability * impact;
    }


    public void getRiskMatrix(){

        System.out.println("Risk Name: "+riskName +"  " + "Probability: "+probability+
                "  "+"Impact: " +impact +"  "+ "Risk: " + riskValue);

    }



    public String getRiskName() {
        return riskName;
    }

    public int getProbability() {
        return probability;
    }

    public int getImpact() {
        return impact;
    }

    public int getRiskValue() {
        return riskValue;
    }

    public void setName(String riskName) {
        this.riskName = riskName;
    }

    public void setProbability(int probability) {
        this.probability = probability;
    }

    public void setImpact(int impact) {
        this.impact = impact;
    }
}
