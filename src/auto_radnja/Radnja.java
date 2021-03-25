package auto_radnja;

import java.util.LinkedList;

import auto_radnja.gume.AutoGuma;
/**
 * 
 * interfejs koji predstavlja Radnju 
 * @author Korisnik
 * 
 *
 */

public interface Radnja {
	/**
	 * dodaje novu gumu u Radnju
	 * @param a guma koja se dodaje
	 * @throws NullPointerException ako je vrednost gume null
	 * @throws RuntimeException ako guma vec postoji u vulkanizerskoj radnji
	 * 
	 * dodaje gumu na prvo mesto u listi
	 */
	
	void dodajGumu(AutoGuma a);
	
	/**
	 * pronalazi gumu u vulkanizerskoj radnji
	 * inicijalizuje listu LinkdeList novaLista
	 * 
	 * @param markaModel  marka i model kao jedan string
	 * @param markaModel marka i model gume koji se trazi
	 *  
	 * @return null ako je vrednost markeModel jednako null
	 * 
	 * @return novaLista vraca listu guma za zadatu marku i model
	 */
	
	LinkedList<AutoGuma> pronadjiGumu(String markaModel);

}
