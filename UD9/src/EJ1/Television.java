package EJ1;

public class Television extends Maquina{
	private final int RES_DEF = 20;
	private final boolean TDT_DEF = false;
	private int resolucion;
	private boolean tdt;
	
	public Television() {
		super();
		this.resolucion = RES_DEF;
		this.tdt = TDT_DEF;
	}
	
	public Television(int precio, int peso) {
		super(precio, peso);
		this.resolucion = RES_DEF;
		this.tdt = TDT_DEF;
	}
	
	public Television(int precio, int peso, String color, char consumo, int resolucion, boolean tdt) {
		super(precio,peso,color,consumo);
		this.resolucion = resolucion;
		this.tdt = tdt;
		precioFinal(resolucion,tdt);
	}

	private void precioFinal(int resolucion2, boolean tdt ) {
		super.precioFinal();
		if(this.tdt) {
			this.precioTotal += 50; 
		}
		
		if(this.resolucion > 40) {
			this.precioTotal += this.precioTotal * 0.3;
		}
		
	}

	public int getResolucion() {
		return resolucion;
	}

	public void setResolucion(int resolucion) {
		this.resolucion = resolucion;
	}

	public boolean isTdt() {
		return tdt;
	}

	public void setTdt(boolean tdt) {
		this.tdt = tdt;
	}
	
}
