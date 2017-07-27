
public abstract class Guerrero {
	private Integer vida;

	public Guerrero(Integer vidaEjemplo){
		this.vida = vidaEjemplo;
	}
	
	public Integer getVida() {
		return vida;
	}

	public void setVida(Integer vida) {
		this.vida = vida;
	}
}
