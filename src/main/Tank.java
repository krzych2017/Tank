package main;

public class Tank {

    private double howManyVolume;
    private double howManyLiquid;
    private int numberTank;

    public Tank (){
    System.out.println("Konstruktor domyślny");}

    public Tank(double howManyVolume, double howManyLiquid, int numberTank) {
        this.howManyVolume = howManyVolume;
        this.howManyLiquid = howManyLiquid;
        this.numberTank = numberTank;
    }

    public double getHowManyVolume() {
        return howManyVolume;
    }
    public double getHowManyLiquid() {
        return howManyLiquid;
    }
    public void setHowManyVolume(double howManyVolume) {
        this.howManyVolume = howManyVolume;
    }
    public void setHowManyLiquid(double howManyLiquid) {
        this.howManyLiquid = howManyLiquid;
    }

    public void displayTankInfo{
        System.out.println("The tank " + numberTank + " has a capacity of " + howManyVolume + " L and contains " + howManyLiquid + " L of fluid" );
    }









}
