package oppgave4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class Hashset {

	public static void main(String[] args) {
		HashSet<Integer> hashSet = new HashSet<>();
		int[] sortertTabell = new int[100000];
		
		
		// Utfylling av HashSet og tabellen
		int tall = (int) (Math.random() * 1000000);
		for (int i = 0; i < 100000; i++) {
			hashSet.add(tall);
			sortertTabell[i] = tall;
			tall = (tall + 45713) % 1000000;
		}
		
		
		// Sorterer tabellen
		Arrays.sort(sortertTabell);
		
		
		// Søking og måling av tid
		Random tilfeldig = new Random();
		int funnetHash = 0;
		int funnetTab = 0;
		long start, slutt, tid;
		
		
		// HashSet
		start = System.nanoTime();
		for (int i = 0; i < 10000; i++) {
			int tilfeldigTall = tilfeldig.nextInt(1000000);
			if (hashSet.contains(tilfeldigTall)) {
				funnetHash++;
			}
		}
		
		slutt = System.nanoTime();
		tid = (slutt - start) / 1000000;
		System.out.println("HashSet: " + tid + " ms");
		
		
		// Tabell
		start = System.nanoTime();
		for (int i = 0; i < 10000; i++) {
			int tilfeldigTall = tilfeldig.nextInt(1000000);
			if (Arrays.binarySearch(sortertTabell, tilfeldigTall) >= 0) {
				funnetTab++;
			}
		}
		
		slutt = System.nanoTime();
		tid = (slutt - start) / 1000000;
		System.out.println("Binærsøk i tabell: " + tid + " ms");
		
		System.out.println("Antall funnet i HashSet: " + funnetHash);
		System.out.println("Antall funnet i tabell: " + funnetTab);
	}
	/*
	 	Koden genererer først et tilfeldig tall 0...999 999
	 	også blir det utført en binærsøk i den sorterte tabellen for
	 	å finne det tilfeldige tallet. Hvis tallet er funnet, 
	 	øker den telleren for funn i tabellen. 
	 	Til slutt blir det printet ut.
	*/
}