package zoomanagement;

public class Pigeons extends Birds{
	public Pigeons(String name,int age,float weight) throws AssertionError {
		if(name ==null){
			throw new AssertionError("name required. null not allowed");
		}
	this.name=name;
	this.age=age;
	this.weight=weight;
	sound="Coo";
	bloodType="Hot";
	diet="Herbivores";
	animalId="Pigeon"+(++animalCount);
}
}