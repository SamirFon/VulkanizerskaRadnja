package auto_radnja.gume;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;



class AutoGumaTest {
	
	AutoGuma a;

	@BeforeEach
	void setUp() throws Exception {
		a= new AutoGuma();
	}

	@AfterEach
	void tearDown() throws Exception {
		a=null;
	}

	@Test
	void testAutoGuma() {
		a= new AutoGuma();
	assertNotNull(a);
	}

	@Test
	void testAutoGumaStringIntIntInt() {
		a= new AutoGuma("Pireli", 20, 150, 55);
		assertNotNull(a);
		assertEquals(20, a.getPrecnik());
		assertEquals(150, a.getSirina());
		assertEquals(55, a.getVisina());
	}
	@Test
	void testSetMarkaModel() {
		a.setMarkaModel("Pireli 365");
		
		assertEquals("Pireli 365", a.getMarkaModel());
	}
	@Test
	void testSetMarkaModelNull() {
		assertThrows(java.lang.RuntimeException.class, ()->a.setMarkaModel(null));
	}
	
	@Test
	void testSetMarkaModelKaratakString() {
		assertThrows(java.lang.RuntimeException.class,()-> a.setMarkaModel("ae"));
}

	@Test
	void testSetPrecnikUGraniciManjeOd() {
	
		assertThrows(java.lang.RuntimeException.class, ()->a.setPrecnik(10));

	}
	@Test
	void testSetPrecnikUGraniciVeceOd() {
		
		assertThrows(java.lang.RuntimeException.class, ()-> a.setPrecnik(25));

		
	}
	@ParameterizedTest
	@CsvSource({
		"20,20, true",
		"20,18,false",
		"18,20, false"
	})
	void testSetPrecnik(int precnik, int precnik1, boolean eq) {
		a.setPrecnik(precnik);
		
		AutoGuma a1 = new AutoGuma();
		a1.setPrecnik(precnik1);
		assertEquals(eq, a.equals(a1));
	}

	@Test
	void testSetSirinaUGraniciManjeOd() {
		assertThrows(java.lang.RuntimeException.class, ()->a.setSirina(20));
	}

	@Test
	void testSetSirinaUGraniciVeceOd() {
		assertThrows(java.lang.RuntimeException.class, ()->a.setSirina(380));
	}
	
	@Test
	void testSetSirina() {
		a.setSirina(150);
		assertEquals(150, a.getSirina());
		
	}

	@ParameterizedTest
	@CsvSource({
		"150,150, true",
		"20,150,false",
		"150,20, false"
	})
	void testSetSirinaParam(int sirina, int sirina1,boolean eq) {
		a.setSirina(sirina);
		
		AutoGuma a1 = new AutoGuma();
		a1.setSirina(sirina1);
		assertEquals(eq, a.equals(a1));
		
	}
	@Test
	void testSetVisina() {
		a.setVisina(30);
		assertEquals(30, a.getVisina());
	}
	
	@Test
	void testSetVisinaUpseguManjaOd() {
		assertThrows(java.lang.RuntimeException.class, ()->a.setVisina(15));
	}
	
	@Test
	void testSetVisinaUOpseguVecaOd() {
		assertThrows(java.lang.RuntimeException.class, ()->a.setVisina(100));
		
		
	}
	@ParameterizedTest
	@CsvSource({
		"55,55, true",
		"30,55,false",
		"55,30, false"
	})
	void testSetVisinaParam(int visina, int visina1,boolean eq) {
		a.setVisina(visina);
		
		AutoGuma a1 = new AutoGuma();
		a1.setVisina(visina1);
		assertEquals(eq, a.equals(a1));
		
	}
	@Test
	void testToString() {
	
	a.setMarkaModel("Pirelli");
	a.setPrecnik(20);
	a.setSirina(50);
	a.setVisina(60);
	
	String guma = a.toString();
	
	assertTrue(guma.contains("Pirelli"));
	assertTrue(guma.contains("20"));
	assertTrue(guma.contains("50"));
	assertTrue(guma.contains("60"));
	}

	@ParameterizedTest
	@CsvSource({
	
	"Pirelli, 20,50,60,Pirelli,20,50,60, true",
	"Pirelli, 20,50,60,Pirelli,20,60,60, false",
	"Pirelli, 20,50,60,Tigar,20,50,60, false",
	"Pirelli, 20,50,50,Pirelli,20,50,60, false",
	
	
	})
	void testEqualsObject(String markaModel, int precnik, int sirina,  int visina,
			String markaModel1, int precnik1, int sirina1,  int visina1, boolean eq) {

		a.setMarkaModel(markaModel);
		a.setPrecnik(precnik);
		a.setSirina(sirina);
		a.setVisina(visina);
		
		AutoGuma a1 = new AutoGuma();
		a1.setMarkaModel(markaModel1);
		a1.setPrecnik(precnik1);
		a1.setSirina(sirina1);
		a1.setVisina(visina1);
		
		assertEquals(eq, a.equals(a1));
}
	

}
