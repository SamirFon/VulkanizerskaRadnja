package auto_radnja;

import java.util.LinkedList;

import auto_radnja.gume.AutoGuma;

/**
 * Klasa VulkanizerskaRadnja koja predstavlja funkciju radnje
 * 
 * klasa ima listu guma sa svim gumama u radnji
 * 
 * @author Korisnik
 *
 */

public  class VulkanizerskaRadnja implements Radnja {
	/**
	 * 
	 * Lista guma koja je LinkedList i koja je inicijalizovana
	 */

	private LinkedList<AutoGuma> gume = new LinkedList<AutoGuma>();

	
	@Override
	public void dodajGumu(AutoGuma a) {
		
		if (a == null)
			throw new NullPointerException("Guma ne sme biti null");
		if (gume.contains(a))
			throw new RuntimeException("Guma vec postoji");
		gume.addFirst(a);
	}
	
	

	@Override
	public LinkedList<AutoGuma> pronadjiGumu(String markaModel) {
		
		if (markaModel == null)
			return null;
		LinkedList<AutoGuma> novaLista = new LinkedList<AutoGuma>();
		for (int i = 0; i < gume.size(); i++)
			if (gume.get(i).equals(markaModel))
				novaLista.add(gume.get(i));
		return novaLista;
	}

}
