package EJ1;

public class Maquina {
	// CONSTANTES
	protected final String COLOR_DEF = "blanco";
	protected final char CONS_DEF = 'F';
	protected final int PB_DEF = 100;
	protected final int PESO_DEF = 5;
	protected final String coloresStock[] = { "blanco", "negro", "rojo", "azul", "gris" };
	// ATRIBUTOS
	protected int precioBase;
	protected String color;
	protected char consumo;
	protected int peso;
	protected double precioTotal;

	// Constructor por defecto
	public Maquina() {
		this.precioBase = PB_DEF;
		this.color = COLOR_DEF;
		this.consumo = CONS_DEF;
		this.peso = PESO_DEF;
		this.precioFinal();
	}

	// Sobrecarga del constructor
	public Maquina(int precio, int peso) {
		this.precioBase = precio;
		this.color = COLOR_DEF;
		this.consumo = CONS_DEF;
		this.peso = peso;
		this.precioFinal();// Actualizo el precio final del producto
	}

	// Sobrecarga del constructor
	public Maquina(int precio, int peso, String color, char consumo) {
		this.precioBase = precio;
		this.comprobarColor(color);// compruebo que el color este en stock
		this.comprobarConsumo(consumo);// compruebo que el consumo esta entre A y F
		this.peso = peso;
		this.precioFinal();// Actualizo el percio final
	}

	// Metodo para imprimir
	public void toSring() {
		System.out.println("Color: " + this.color + "\nConsumo: " + this.consumo + "\nPeso: " + this.peso + "\nPrecio: "
				+ this.precioBase+"\nPrecio final: "+this.precioTotal);
	}

	// Metodo que comprueba el consumo
	public void comprobarConsumo(char letra) {
		// Hago una comparacion directa porque me los transforma a ASCII
		if (letra >= 'A' && letra <= 'F') {
			this.consumo = letra;
		} else {
			this.consumo = CONS_DEF;
		}
	}
	// Metodo que comprueba el color

	public void comprobarColor(String color) {

		color = color.toLowerCase();// lo pongo en minusculas, asi me lo pueden introducir como quieran

		// recorro el array de colores si alguno coincide me lo guardara en el atributi
		for (int i = 0; i < coloresStock.length; i++) {
			if (color.equals(coloresStock[i])) {
				this.color = color;
			}
			
		}
		// si el color no esta en stock el valor del atributo sera null, uso esa
		// condicion para poner el color por defecto
		if (this.color == null) {
			this.color = COLOR_DEF + "(color por defecto)";
		}
	}

	// Metodo que calcula el precio final dependiendo del consumo y el peso
	protected void precioFinal() {
		
		switch (this.consumo) {
		case 'A':
			this.precioTotal = this.precioBase + 100;
			break;
		case 'B':
			this.precioTotal = this.precioBase + 80;
			break;
		case 'C':
			this.precioTotal = this.precioBase + 60;
			break;
		case 'D':
			this.precioTotal = this.precioBase + 50;
			break;
		case 'E':
			this.precioTotal = this.precioBase + 30;
			break;
		case 'F':
			this.precioTotal = this.precioBase + 10;
			break;

		}

		if (this.peso >= 0 && this.peso <= 19) {

			this.precioTotal += 10;

		} else if (this.peso >= 20 && this.peso <= 49) {

			this.precioTotal += 50;

		} else if (this.peso >= 50 && this.peso <= 79) {

			this.precioTotal += 80;

		} else {

			this.precioTotal += 100;

		}
	}

	// Get & Set
	public int getPrecioBase() {
		return precioBase;
	}

	public void setPrecioBase(int precioBase) {
		this.precioBase = precioBase;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public char getConsumo() {
		return consumo;
	}

	public void setConsumo(char consumo) {
		this.consumo = consumo;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public double getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}

}
