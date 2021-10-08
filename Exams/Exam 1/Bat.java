public class Bat extends Mammal implements CanFly{
    private int flyingSpeed;
    private String animalType;
    
    public Bat(){
        super();
        flyingSpeed = 0;
        animalType = "N/a";
    }
    public Bat(String name, String animalType,double weight, int flyingSpeed, int lifespan){
        super();
        this.flyingSpeed = flyingSpeed;
        this.animalType = animalType;
    }
    public int getFlyingSpeed(){
        return flyingSpeed;
    }
    public String getAnimalType(){
        return animalType;
    }
    public void setFlyingSpeed(int flyingSpeed){
        this.flyingSpeed = flyingSpeed;
    }
    public void setAnimalType(String animalType){
        this.animalType = animalType;
    }
    public int flies(){
        return flyingSpeed;
    }
    
}
