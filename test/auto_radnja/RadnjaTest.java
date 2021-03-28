package auto_radnja;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;
import java.util.List;

import auto_radnja.Radnja;
import auto_radnja.gume.AutoGuma;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.converter.JavaTimeConversionPattern;

 

public abstract class RadnjaTest {


	
	protected Radnja vk;

	private LinkedList<AutoGuma> gume = new LinkedList<AutoGuma>();
	
	AutoGuma a;


	
	@Test
	void testDodajGumu() {
		
		AutoGuma a = new AutoGuma();
		
		a.setMarkaModel("Pirelli");
		a.setPrecnik(20);
		a.setSirina(150);
		a.setVisina(60);
		
		vk.dodajGumu(a);					
		

		assertEquals("Pirelli", a.getMarkaModel());
		
	

	
	}
		
	
	@Test
	void testDodajGumuNull() {
	
		 a = null;
			                     
		
		assertThrows(java.lang.NullPointerException.class, ()-> vk.dodajGumu(a));
	}
	
	
	@Test
	void testDodajGumuDuplikat() {
		
		
		AutoGuma a = new AutoGuma();
		a.setMarkaModel("Pirelli");
		
		AutoGuma a1 = new AutoGuma();
		a1.setMarkaModel("Pirelli");
		
		vk.dodajGumu(a);
	
		
		
		assertThrows(java.lang.RuntimeException.class, ()->vk.dodajGumu(a1));
		
		
	}
	


	@Test
	void testPronadjiGumuNull() {
		
		AutoGuma a = new AutoGuma();
		
		a.setMarkaModel(null);     // mora se uneti marka i model jer baca exception iz set metode markaModel
		a.setPrecnik(20);
		a.setSirina(155);
		a.setVisina(55);
		
		vk.dodajGumu(a);
			
		
	}
	
	@Test
	void testPronadjiGumu() {
	
	AutoGuma a = new AutoGuma();
	a.setMarkaModel("Pirelli");
	
	AutoGuma a1 = new AutoGuma();
	a1.setMarkaModel("Tigar");
	
	AutoGuma a2 = new AutoGuma();
	a2.setMarkaModel("Barum");
	
	vk.dodajGumu(a);
	vk.dodajGumu(a1);
	vk.dodajGumu(a2);
	
	List<AutoGuma> nova = vk.pronadjiGumu("Pirelli");

	
	assertTrue(nova.contains(a));
	
	
	}
	
	@Test
	void testPronadjiGumuIsteMarkeIModela() {
	
	AutoGuma a = new AutoGuma();
	a.setMarkaModel("Pirelli");
	a.setPrecnik(20);
	
	AutoGuma a1 = new AutoGuma();
	a1.setMarkaModel("Pirelli");
	a1.setPrecnik(21);
	
	AutoGuma a2 = new AutoGuma();
	a2.setMarkaModel("Barum");
	a2.setPrecnik(19);
	
	
	vk.dodajGumu(a);
	vk.dodajGumu(a1);
	vk.dodajGumu(a2);
	


	
	List<AutoGuma> nova = vk.pronadjiGumu("Pirelli");
	
	assertEquals(2,nova.size());
	assertEquals(nova.size(), vk.pronadjiGumu("Pirelli").size());
	
		
	}
	@Test
	void testPronadjiGumuNepostojeceMarkeIModela() {
		
		AutoGuma a = new AutoGuma();
		a.setMarkaModel("Pirelli");
		a.setPrecnik(20);
		
		AutoGuma a1 = new AutoGuma();
		a1.setMarkaModel("Pirelli");
		a1.setPrecnik(21);
		
		AutoGuma a2 = new AutoGuma();
		a2.setMarkaModel("Barum");
		a2.setPrecnik(19);
		
	
		
		vk.dodajGumu(a);
		vk.dodajGumu(a1);
		vk.dodajGumu(a2);
		
	
	
		
		
		assertEquals(0, vk.pronadjiGumu("Sava").size());
		
		

	}
}
