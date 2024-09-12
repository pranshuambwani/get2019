package zoomanagement;

public class Snake extends Reptile{
	public Snake(String name,int age,float weight) throws AssertionError{
		if(name ==null){
			throw new AssertionError("name required. null not allowed");
		}
	this.name=name;
	this.age=age;
	this.weight=weight;
	sound="Hiss";
	bloodType="Cold";
	diet="Carnivorous";
	animalId="Snake"+(++animalCount);
}
}