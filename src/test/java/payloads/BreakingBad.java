package payloads;


@lombok.ToString
public class BreakingBad {
//
//	 "name": "Walter White",
//     "occupation": "Chemistry Professor",
//     "date_of_birth": "1971",
//     "suspect": false
	
	private String name;
	private String occuption;
	private String dataOfBirth;
	private boolean suspect;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getChemistryProfessor() {
		return occuption;
	}
	public void setChemistryProfessor(String chemistryProfessor) {
		this.occuption = chemistryProfessor;
	}
	public String getDataOfBirth() {
		return dataOfBirth;
	}
	public void setDataOfBirth(String dataOfBirth) {
		this.dataOfBirth = dataOfBirth;
	}
	public boolean isSuspect() {
		return suspect;
	}
	public void setSuspect(boolean suspect) {
		this.suspect = suspect;
	}
	
	public BreakingBad(String name, String chemistryProfessor, String dataOfBirth, boolean suspect) {
		
		this.name = name;
		this.occuption = chemistryProfessor;
		this.dataOfBirth = dataOfBirth;
		this.suspect = suspect;
	}
	
	public BreakingBad() {
		
	}
}
