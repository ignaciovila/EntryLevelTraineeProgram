import static org.junit.Assert.*;

import org.junit.Test;

public class TestGuerrero {
	@Test
	public void esHumano(){
		Humano humano = new Humano(50);
		assertTrue(humano instanceof Guerrero);
	}
	
	@Test
	public void esNamekiano(){
		Namekiano namekiano = new Namekiano(75);
		assertTrue(namekiano instanceof Guerrero);
	}
	
	@Test
	public void esSaiyajin(){
		Saiyajin saiyajin = new Saiyajin(80);
		assertTrue(saiyajin instanceof Guerrero);
	}
	
	@Test
	public void humanoTieneVida(){
		Humano humano = new Humano(50);
		assertTrue(humano.getVida() != null);
	}
	
	@Test
	public void namekianoTieneVida(){
		Namekiano namekiano = new Namekiano(75);
		assertTrue(namekiano.getVida() != null);
	}
}