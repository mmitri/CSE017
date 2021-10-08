public class Bird extends Animal implements CanFly{
    private int flyingSpeed;
    private String animalType;

    public Bird(){
        super();
        animalType = "N/a";
    }
    public Bird(String name, String animalType, double weight, int flyingSpeed, int lifespan){
        super();
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
