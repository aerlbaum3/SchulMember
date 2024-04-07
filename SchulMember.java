import java.sql.Date;
import java.time.LocalDate;
import java.util.Comparator;

public class SchulMember{

	String lastNameOfMember;
	String firstNameOfMember;
	int birthDateOfMember;
	String spouseFirstName;
	String spouseLastName;
	String[] childrenNames; 
	int yearsOfMembership;
	//public int compareTo()  // for age of member
	
	public SchulMember(String lastName, String firstName, int birthDate, String spouseFName, String spouseLName,String[] childrenNames, 
			int years) {
		this.birthDateOfMember = birthDate;
		this.lastNameOfMember = lastName;
		this.firstNameOfMember = firstName;
		this.spouseFirstName = spouseFName;
		this.spouseLastName = spouseLName;
		this.childrenNames = childrenNames;
		this.yearsOfMembership = years;
	}
	  

    public String getLastNameOfMember() {
        return lastNameOfMember;
    }

    public void setLastNameOfMember(String lastNameOfMember) {
        this.lastNameOfMember = lastNameOfMember;
    }

    public String getFirstNameOfMember() {
        return firstNameOfMember;
    }

    public void setFirstNameOfMember(String firstNameOfMember) {
        this.firstNameOfMember = firstNameOfMember;
    }

    public int getBirthDateOfMember() {
        return birthDateOfMember;
    }

    public void setBirthDateOfMember(int birthDateOfMember) {
        this.birthDateOfMember = birthDateOfMember;
    }

    public String getSpouseFirstName() {
        return spouseFirstName;
    }

    public void setSpouseFirstName(String spouseFirstName) {
        this.spouseFirstName = spouseFirstName;
    }

    public String getSpouseLastName() {
        return spouseLastName;
    }

    public void setSpouseLastName(String spouseLastName) {
        this.spouseLastName = spouseLastName;
    }

    public String[] getChildrenNames() {
        return childrenNames;
    }

    public void setChildrenNames(String[] childrenNames) {
        this.childrenNames = childrenNames;
    }

    public int getYearsOfMembership() {
        return yearsOfMembership;
    }

    public void setYearsOfMembership(int yearsOfMembership) {
        this.yearsOfMembership = yearsOfMembership;
    }

    // Comparator for age
    public static Comparator<SchulMember> ageComparator = Comparator.comparingInt(SchulMember::getBirthDateOfMember);
}
