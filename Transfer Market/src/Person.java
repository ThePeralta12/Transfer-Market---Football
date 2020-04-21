import java.io.Serializable;


public class Person implements Serializable
{
   // Made a new PROJECT CALLED TRANSFER MARKET AND CRATED A CLASS CALLED PERSON
	private int personId;
	private String name;
	private int Age;
	private String team;//this would be an array in another context
	private String nationality;
	//final is a constant it means it can't be changed.
	private static final long serialVersionUID = 1L;
public Person(){
		
	}
	
	
	public String getNationality() {
		return nationality;
	}


	public void setNationality(String nationality) {
		this.nationality = nationality;
	}


	
	
	public int getPersonId() {
		return personId;
	}



	public void setPersonId(int personId) {
		this.personId = personId;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getAge() {
		return Age;
	}



	public void setAge(int age) {
		Age = age;
	}



	public String getTeam() {
		return team;
	}



	public void setTeam(String team) {
		this.team = team;
	}



	
}
