import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	 public static void main(String[] args) {
	        // Generating 10 Schul members for demonstration
	        List<SchulMember> members = Arrays.asList(
	                new SchulMember("Rosenbaum", "Harry", 1985, "Rebecca", "Smith", new String[]{"Joey", "Esther"}, 5),
	                new SchulMember("Erlbaum", "Michael", 1978, "Sharon", "Wagner", new String[]{"Adeena", "Baila", "Tamar","Elisheva","Baruch"}, 10),
	                new SchulMember("Rauch", "Simcha", 1990, "Yocheved", "Glazer", new String[]{}, 1),
	                new SchulMember("Zidele", "Yossi", 1982, "Adeena", "Erlbaum", new String[]{}, 1),
	                new SchulMember("Kohn", "Heshy", 1975, "Malka", "Egert", new String[]{"Sruly"}, 2),
	                new SchulMember("Borish", "Yechezkel", 1989, "Chani", "Erlbaum", new String[]{"Bentzy","Avrumi"}, 4),
	                new SchulMember("Carelbach", "Zevi", 1980, "Yehudit", "Erlbaum", new String[]{"Chaim", "Meir","Shlomo"}, 9),
	                new SchulMember("Wagner", "Marvin", 1973, "Irene", "Herzog", new String[]{"Sharon","David","Kovie"}, 30),
	                new SchulMember("Taylor", "Ian", 1993, "Hannah", "Marcus", new String[]{}, 3),
	                new SchulMember("Anderson", "Gavin", 1987, "Fiona", "Smith", new String[]{"Jack"}, 6)
	        );

	        // 1) Print how many families belong to your schul
	        long familyCount = members.stream()
	                .map(member -> member.getLastNameOfMember() + member.getSpouseLastName())
	                .distinct()
	                .count();
	        System.out.println("Number of families in the schul: " + familyCount);

	        // 2) Print in sorted order how long each family has been a member of your schul
	        System.out.println("");
	        System.out.println("Number of years each family has been in the schul: ");
	        members.stream()
	                .collect(Collectors.groupingBy(member -> member.getLastNameOfMember() + " Family ",
	                        Collectors.summingInt(SchulMember::getYearsOfMembership)))
	                .entrySet().stream()
	                .sorted(Comparator.comparingInt(entry -> entry.getValue()))
	                .forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue() + " years"));

	        // 3) Print out from oldest to youngest the ages of your members (not spouses)
	        System.out.println(" ");
	        System.out.println("Members from oldest to youngest: ");
	        members.stream()
	                .sorted(Comparator.comparingInt(member -> member.getBirthDateOfMember()))
	                .forEach(member -> System.out.println("Member: " + member.getFirstNameOfMember() + " " + member.getLastNameOfMember()
	                		+ " Age: " + (2024 - member.birthDateOfMember)));

	        // 4) Sort the names of the spouses of all members
	        System.out.println("");
	        System.out.println("Names of spouses of members:");
	        members.stream()
	                .map(SchulMember::getSpouseFirstName)
	                .sorted()
	                .forEach(System.out::println);

	        // 5) Print out all families who have more than 3 children
	        System.out.println("");
	        members.stream()
	                .filter(member -> member.getChildrenNames().length > 3)
	                .forEach(member -> System.out.println("Families with more than 3 children: " + member.getLastNameOfMember() + " family"));

	        // 6) Print out the names of all children whose name is larger (alphabetically) than the letter “c” (and what family they belong to).
	       
	        System.out.println("");
	        System.out.println("Children with names greater than the letter C:");
	        members.stream()
	                .flatMap(member -> Arrays.stream(member.getChildrenNames()).map(child -> new Object[]{member.getLastNameOfMember(), child}))
	                .filter(arr -> ((String) arr[1]).compareToIgnoreCase("c") > 0)
	                .forEach(arr -> System.out.println("Family: " + arr[0] + ", Child: " + arr[1]));
	    }
	}

