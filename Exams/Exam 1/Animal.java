abstract class Animal implements Comparable<Animal>{
    private String name;
    private double weight;
    private int lifespan;

    public Animal(){
        name = "N/a";
        weight = 0.0;
        lifespan = 0;
    }
    protected Animal(String name, double weight,int lifespan){
        this.name = name;
        this.weight = weight;
        this.lifespan = lifespan;
    }
    public String getName(){
        return name;
    }
    public double getWeight(){
        return weight;
    }
    public int getLifespan(){
        return lifespan;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setWeight(double weight){
        this.weight = weight;
    }
    public void setLifespan(int lifespan){
        this.lifespan = lifespan;
    }
    
    public String toString(){
        return String.format("%-10s\t%-10d\t%-10d",name,weight,lifespan);
    }
    public int compareTo(Animal a){
        return 1;
    }
}
