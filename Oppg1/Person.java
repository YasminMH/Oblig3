package hobbyMengde;

import java.util.HashSet;
import java.util.Set;

public class Person {
	
	private String navn;
	private Set<String> hobbyer;

	
	public Person(String navn, String... hobbyer) {
		this.navn = navn;
		this.hobbyer = new HashSet<>();
		
		for(String hobby : hobbyer) {
			this.hobbyer.add(hobby);
		}
	}
	
	public String getNavn() {
		return navn;
	}
	
	public Set<String> getHobbyer(){
		return hobbyer;
	}
	

	public static class HobbyMatchMain {
			
		public static double match(Person a, Person b) {
			
		Set<String> fellesHobbyer= new HashSet<>(a.getHobbyer());
		fellesHobbyer.retainAll(b.getHobbyer());
		
		
		int antallFelles = fellesHobbyer.size();
		int antallKunHosDenEne = a.getHobbyer().size() - antallFelles;;
		int antallKunHosDenAndre = b.getHobbyer().size() - antallFelles;
		int antallTotalt = a.getHobbyer().size() + b.getHobbyer().size() ;
		
		return antallFelles - (antallKunHosDenEne + antallKunHosDenAndre) / antallTotalt;
		
		}
		
	public static void main(String[] args) {
		
		//oppretter tre personer med ulike hobbyer
		Person p1 = new Person("Anna","Sykling", "Lesing", "Programmering");
		Person p2 = new Person("Ben", "Programmering", "Gaming", "Venner");
		Person p3 = new Person("Charlie", "Løping", "Venner", "Fisking");
		
		//Finner match mellom alle par av personer
		double matchAB = match(p1, p2);
		double matchAC = match(p1, p3);
		double matchBC = match(p2, p3);
		
		//Finn ut hvilke to personer som er best match ut ifra felles hobbyer
		Person bestMatch1 = (matchAB > matchAC && matchAB > matchBC)
				? p1 : (matchAC > matchBC) ? p3 : p2;
		
		Person bestMatch2 = (bestMatch1 == p1) ? (matchAC > matchBC) ? 
				p3 : p2 : (bestMatch1 == p3) ? 
						(matchAB > matchBC) ? 
								p1 : p2 : (matchAB > matchAC) ? 
										p1 : p3;
		
		//skriv så ut match mellom parene. 
		
		System.out.println("Match mellom Anna og Ben: "+matchAB);
		System.out.println("Match mellom Anna og Charlie: "+matchAC);
		System.out.println("Match mellom Ben og Charlie: "+matchBC);
		
		//Skriver ut hvilke to personer som er best match:
		System.out.println("Best math er mellom: "+bestMatch1.getNavn() + " Og " + bestMatch2.getNavn());
	}
		
	}
	
}
	
