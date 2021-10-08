public class Cat extends Mammal{
    private String animalType;

    public Cat(){
        super();
        animalType = "N/a";
    }
    public Cat(String name, String animalType, double weight, int lifespan){
        super();
        this.animalType = animalType;
    }
    public String getAnimalType(){
        return animalType;
    }
    public void setAnimalType(String animalType){
        this.animalType = animalType;
    }
}
