
public class TestCar{
    public static void main (String []args){
        Car basicCar = new BasicCar();

        CarWithAC acCar = new CarWithAC();
        acCar.setCar(basicCar);

        CarWithGPS gpsCar = new CarWithGPS();
        gpsCar.setCar(acCar);
        
        System.out.println(gpsCar.assemble());

    }
}