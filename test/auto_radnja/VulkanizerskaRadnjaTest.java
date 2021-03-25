package auto_radnja;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import auto_radnja.gume.AutoGuma;



class VulkanizerskaRadnjaTest extends RadnjaTest {
	
	protected VulkanizerskaRadnja vk;

	@BeforeEach
	void setUp() throws Exception {
		vk = new VulkanizerskaRadnja();
	}

	@AfterEach
	void tearDown() throws Exception {
		vk = null;
	}

	@Test
	void testDodajGumu() {
		
		AutoGuma a = new AutoGuma();
		
		a.setMarkaModel("Pirelli");
		a.setPrecnik(20);
		a.setSirina(150);
		a.setVisina(60);
		
		vk.dodajGumu(a);
		
		assertEquals(a.getMarkaModel(), vk.pronadjiGumu("Pirelli"));
	}
	@Test
	void testDodajGumuNull() {
		assertThrows(java.lang.RuntimeException.class, ()->vk.dodajGumu(null));
	}
	@Test
	void testDodajGumuDuplikat() {
		AutoGuma a = new AutoGuma();
		a.setMarkaModel("Pirelli");
		
		AutoGuma a1 = new AutoGuma();
		a1.setMarkaModel("Pirelli");
		
		vk.dodajGumu(a1);
	
		
		
		assertThrows(java.lang.RuntimeException.class, ()->vk.dodajGumu(a));
		
	}

	@Test
	void testPronadjiGumuNull() {
		
		AutoGuma a = new AutoGuma();
		a.setMarkaModel(null);;  // mora se uneti marka i model
		
		vk.dodajGumu(a);
		assertThrows(java.lang.NullPointerException.class, ()->a.getMarkaModel());
		
		
		
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
	
	LinkedList<AutoGuma> novaLista = vk.pronadjiGumu("Sava");
	assertFalse(novaLista.contains(a));
	assertEquals(0, novaLista.size());
		
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
	
	LinkedList<AutoGuma> novaLista = vk.pronadjiGumu("Pirelli");
	assertTrue(novaLista.contains(a));
	assertTrue(novaLista.contains(a1));
	
	assertEquals(a1, vk.pronadjiGumu("Pirelli"));
	
		
	}
	

}
