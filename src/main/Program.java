package main;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Program {

    private final List<Tank> tanks = new ArrayList<>();
    private final Map<Integer,Tank> numbersTank = new HashMap<>();

    public void addTank(){

        System.out.println("Enter a size of tank (liters) : ");
        double howManyVolume = CheckValue.getDoubleValue();
        System.out.println("Enter the amount of liquid of the tank (liters): " );
        double howManyLiquid = CheckValue.getDoubleValue();

        if(howManyVolume>=howManyLiquid) {

            int numberTank = tanks.size() + 1;
                Tank tank = new Tank(howManyVolume, howManyLiquid, numberTank);
                tanks.add(tank);
                numbersTank.put(numberTank,tank);
            }
                else
                    System.out.println("Too small tank !!!");
    }
    public void displayTank(){

        for (Tank tank :tanks ) {
            tank.displayTankInfo();
            System.out.println();
        }
    }
    public void addFluidTank(){

        double diferenceLiquid;
        double addFluid;

        System.out.println("Select the tank number: ");
        int number = CheckValue.getIntValue();
        Tank tank = numbersTank.get(number);

        if(tank==null)
                System.out.println("Bad select");
            else
            {
                diferenceLiquid = tank.getHowManyVolume() - tank.getHowManyLiquid();
                System.out.println("You can add " + diferenceLiquid + " in the tank nr " + number );
                System.out.println("How much liquid do you want to add to the tank ??");
                addFluid = CheckValue.getDoubleValue();

                if (addFluid <= diferenceLiquid)
                    tank.setHowManyLiquid(tank.getHowManyLiquid()+addFluid);
                    else
                        System.out.println(" too much !!!");
            }
    }
    public void pourOut (){

        double pourOutliquid;

        System.out.println("Select the tank number: ");
        int number = CheckValue.getIntValue();
        Tank tank = numbersTank.get(number);

        if(tank==null)
            System.out.println("Bad select");

            else {
            System.out.println("You can pour out maximal " + tank.getHowManyLiquid() + " Liters with the tank nr " + number);
            System.out.println("how much do you want to pour ?");
            pourOutliquid = CheckValue.getDoubleValue();
            if (pourOutliquid >= tank.getHowManyLiquid())
                System.out.println("Do you want too much pour out!!");
            else{
                tank.setHowManyLiquid(tank.getHowManyLiquid()-pourOutliquid);
                }
        }

    }
    public void transfer(){
        System.out.println("Enter the number of the tank you want to pour the liquid out of");
        int numberTankPourOut = CheckValue.getIntValue();
        Tank tank = numbersTank.get(numberTankPourOut);
        System.out.println("Enter the number of the tank you want to pour the liquid into");
        int numberTankPourIn = CheckValue.getIntValue();
        Tank tank2 = numbersTank.get(numberTankPourIn);
        if(tank == null && tank2 == null)
            System.out.println("Bad tank number !!");

            else{

                    double differencePourOutMax = tank.getHowManyLiquid();
                    double differencePourInMax = tank2.getHowManyVolume()-tank2.getHowManyLiquid();
                    double transferFluid;
                    double howMuchTransfer;

                         if(differencePourInMax >= differencePourOutMax)
                             transferFluid = differencePourOutMax;
                         else
                             transferFluid = differencePourInMax;

                    System.out.println("You can max pour out " + differencePourOutMax + " Liters of the tank " + numberTankPourOut);
                    System.out.println("You can max pour in " + differencePourInMax + "Liters of the tank " + numberTankPourIn);
                    System.out.println("You can max transfer " + transferFluid);
                    System.out.println("Enter how much you want to transfer ");
                    howMuchTransfer = CheckValue.getDoubleValue();

                    if (howMuchTransfer > transferFluid)
                        System.out.println("Bad value!!");
                    else{
                        tank.setHowManyLiquid(tank.getHowManyLiquid()-howMuchTransfer);
                        tank2.setHowManyLiquid(tank2.getHowManyLiquid()+howMuchTransfer);
                    }
            }

    }
}
