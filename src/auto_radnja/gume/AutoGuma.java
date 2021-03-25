package auto_radnja.gume;

/**
 * 
 * Klasa koja predstavlja Auto gume u vulkanizerskoj radnji
 * 
 * Klasa ima string vrednost za markuModel i int vrednost za precnik, sirinu i visinu
 * 
 * @author Korisnik
 * 
 * @version 0.1
 *
 */

public class AutoGuma {
	
/**
 * Marka i model kao String cija je pocetna vrednost null
 */

	private String markaModel = null;
	
	/**
	 * precnik gume kao int  i ima pocetnu vrednost minus jedan
	 */
	private int precnik = -1;
	/**
	 * Precnik kao int  i imapocetnu vrednost minus jedan
	 */
	private int sirina = -1;
	/**
	 * Visina kao int  i ima pocetnu vrednost minus jedan
	 */
	private int visina = -1;
/**
 * Konstrukor klase AutoGuma 
 * 
 */
	public AutoGuma() {

	}
	/**
	 * 
	 * Konstuktor koji inicijalizuje objekat i postavlja vrednosti marku i model, precnik, sirinu i visinu
	 * 
	 * @param markaModel maraka i model auto gume kao jedan String
	 * @param precnik precnik auto gume kao int
	 * @param sirina sirina auto gume kao int
	 * @param visina visina auto gume kao int
	 */

	public AutoGuma(String markaModel, int precnik, int sirina, int visina) {
		super();
		setMarkaModel(markaModel);
		setPrecnik(precnik);
		setSirina(sirina);
		setVisina(visina);
	}
	/**
	 * Vraca marku i model gume
	 * @return markaModel kao jedan String
	 */

	public String getMarkaModel() {
		return markaModel;
	}

	/**
	 * postavlja novu vrednost marke i modela
	 * 
	 * @param markaModel  maraka i model kao jedan string
	 * @throws java.lang.NullPointerException ako je uneta vrednost za markaModel  null
	 * @throws java.lang.RuntimeException ako je uneta vrednost za markaModel manja od 3 karaktera
	 */
	public void setMarkaModel(String markaModel) {
		if (markaModel == null)
			throw new NullPointerException("Morate uneti marku i model");
		if (markaModel.length() < 3)
			throw new RuntimeException("Marka i model moraju sadrzati bar 3 znaka");
		
		this.markaModel = markaModel;
	}
	/**
	 * vraca precnik gume
	 * @return precnik gume kao int 
	 */
	public int getPrecnik() {
		return precnik;
	}
	
	/**
	 * 
	 * postavlja precnik gume na novu vrednost
	 * @param precnik precnik gume kao int
	 * @throws java.lang.RuntimeException ako je precnik manji od 13 i veci od 22
	 */

	public void setPrecnik(int precnik) {
		if (precnik < 13 && precnik > 22)
			throw new RuntimeException("Precnik van opsega");
		this.precnik = precnik;
	}

	/**
	 * vraca sirinu gume
	 * @return sirina kao int
	 */
	public int getSirina() {
		return sirina;
	}
	/**
	 * postavlja sirinu gume na novu vrednost
	 * @param sirina sirina gume kao int
	 * @throws java.lang.RuntimeException ako je sirna manja od 135 i veca od 335
	 */
	
	public void setSirina(int sirina) {
		if (sirina < 135 && sirina > 355)
			throw new RuntimeException("Sirina van opsega");
		this.sirina = sirina;
	}
	/**
	 * vraca visinu gume
	 * @return visina gume kao int
	 */

	public int getVisina() {
		return visina;
	}
	/**
	 * 
	 * postavlja visinu gume na novu vrednost
	 * 
	 * @param visina visina gume kao int
	 * 
	 * @throws java.lang.RuntimeException ako je visina manja od 25 ili veca od 95
	 */
	public void setVisina(int visina) {
		if (visina < 25 || visina > 95)
			throw new RuntimeException("Visina van opsega");
		this.visina = visina;
	}
	/**
	 * 
	 * vraca opis gume sa svim podacima o gumi
	 * @return vraca podatke o gumi kao String
	 */
	@Override
	public String toString() {
		return "AutoGuma [markaModel=" + markaModel + ", precnik=" + precnik + ", sirina=" + sirina + ", visina="
				+ visina + "]";
	}
	/**
	 * 
	 * poredi dva objekta AutoGuma i vraca true ako su isti i false ako su razliciti
	 * 
	 *  poredi gume po markaModel , precniku, sirini i visini i vrednost svih atributa mora da bude ista
	 *  
	 *  @return  vraca true ako su obe gume klase AutoGuma istih precnika, visine, sirine i markaModel
	 *  
	 *  @return  vracac false u ostalim slucajevima 
	 * 
	 * 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AutoGuma other = (AutoGuma) obj;
		if (markaModel == null) {
			if (other.markaModel != null)
				return false;
		} else if (!markaModel.equals(other.markaModel))
			return false;
		if (precnik != other.precnik)
			return false;
		if (sirina != other.sirina)
			return false;
		if (visina != other.visina)
			return false;
		return true;
	}

}
