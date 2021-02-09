package EJ1;

public class Lavadora extends Maquina{
	private final int CARGA_DEF = 5;
	private int carga;
	
	public Lavadora() {
		super();
		this.carga = CARGA_DEF;
	}
	
	public Lavadora(int precio,  int peso) {
		super(precio,peso);
		this.carga = CARGA_DEF;
	}
	
	public Lavadora(int precio, int peso, String color, char consumo, int carga) {
		super(precio,peso,color,consumo);
		this.carga = carga;
		precioFinal(this.carga);
	}
	
	private void precioFinal(int carga) {
		super.precioFinal();
		if(carga >= 30) {
			this.precioTotal += 50;
		}
	}
	
	

	public int getCarga() {
		return carga;
	}

	public void setCarga(int carga) {
		this.carga = carga;
	}
	
}
