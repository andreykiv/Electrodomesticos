package EJ1;

import java.util.ArrayList;

import javax.swing.JOptionPane;


/*
 * @author Toni Arjona
 * */
public class Electrodomestico_App {
	// creo el contador fuera del main porque lo voy a usra en diferentes metodos y
	// quiero que cambie su valor
	private static int i = 1, numTV = 0, numLav = 0;
	private static double totalTV = 0, totalLav = 0, totalElec = 0;
	//MAIN
	public static void main(String[] args) {
		ArrayList<Maquina> maquinas = new ArrayList<Maquina>();

		String val = JOptionPane.showInputDialog("Cuantos electrodomesticos: ");
		int limite = Integer.parseInt(val);

		while (i <= limite) {
			String op = JOptionPane.showInputDialog(
					"Producto " + i + ":" + "\n1.- Electrodomestico" + "\n2.- Lavadora" + "\n3.- Televisor");

			switch (op) {
			case "1":
				crearMaquina(maquinas);
				break;
			case "2":
				crearLavadora(maquinas);
				break;
			case "3":
				crearTV(maquinas);
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opcion erronea");
				break;
			}
		}

		precioFinal(maquinas,limite);

	}

	private static void precioFinal(ArrayList<Maquina> maquinas, int limite) {
		
		JOptionPane.showMessageDialog(null, "El total es de "+(totalElec+totalTV+totalLav)+"€"
				+"\n Electrodomesticos ->"+(limite-(numTV+numLav))+""
						+ "-> "+totalElec
						+"\n Televisores -> "+numTV+" -> "+totalTV
						+"\n Lavadoras -> "+numLav+" -> "+totalLav);

	}

	private static void crearTV(ArrayList<Maquina> maquinas) {

		Television tv = crearTV();
		if (tv != null) {
			maquinas.add(tv);
			totalTV += tv.getPrecioTotal();
			numTV ++;
			i++;
		} else {
			JOptionPane.showMessageDialog(null, "Error al guardar el televisor");
		}

	}

	private static void crearLavadora(ArrayList<Maquina> maquinas) {
		Lavadora lavadora = crearLavadora();
		if (lavadora != null) {
			maquinas.add(lavadora);
			totalLav += lavadora.getPrecioTotal();
			numLav++;
			i++;
		} else {
			JOptionPane.showMessageDialog(null, "Error al guardar el televisor");
		}

	}

	private static void crearMaquina(ArrayList<Maquina> maquinas) {
		Maquina maq = crearMaquina();
		if (maq != null) {
			maquinas.add(maq);
			totalElec += maq.getPrecioTotal();
			i++;
		} else {
			JOptionPane.showMessageDialog(null, "Error al guardar el televisor");
		}
	}

	private static Maquina crearMaquina() {
		String precio = JOptionPane.showInputDialog("Precio: ");
		String peso = JOptionPane.showInputDialog("Peso(Kg) : ");
		String color = JOptionPane.showInputDialog("Color: ");
		String consumo = JOptionPane.showInputDialog("Consumo(A->F) : ");

		if (!precio.equals("") && !peso.equals("")) {

			Maquina maq = new Maquina(Integer.parseInt(precio), Integer.parseInt(peso));
			return maq;

		} else if (!precio.equals("") && !peso.equals("") && !color.equals("") && !consumo.equals("")) {

			Maquina maq = new Maquina(Integer.parseInt(precio), Integer.parseInt(peso), color, consumo.charAt(0));
			return maq;

		} else if (precio.equals("") && peso.equals("") && color.equals("") && consumo.equals("")) {
			Maquina maq = new Maquina();
			return maq;
		} else {
			return null;
		}
	}

	private static Lavadora crearLavadora() {
		String precio = JOptionPane.showInputDialog("Precio: ");
		String peso = JOptionPane.showInputDialog("Peso(Kg) : ");
		String color = JOptionPane.showInputDialog("Color: ");
		String consumo = JOptionPane.showInputDialog("Consumo(A->F) : ");
		String carga = JOptionPane.showInputDialog("Carga(Kg) : ");

		if (!precio.equals("") && !peso.equals("")) {

			Lavadora lavadora = new Lavadora(Integer.parseInt(precio), Integer.parseInt(peso));
			return lavadora;

		} else if (!precio.equals("") && !peso.equals("") && !color.equals("") && !consumo.equals("")
				&& !carga.equals("")) {

			Lavadora lavadora = new Lavadora(Integer.parseInt(precio), Integer.parseInt(peso), color, consumo.charAt(0),
					Integer.parseInt(carga));
			return lavadora;

		} else if (precio.equals("") && peso.equals("") && color.equals("") && consumo.equals("") && carga.equals("")) {
			Lavadora lavadora = new Lavadora();
			return lavadora;
		} else {
			return null;
		}
	}

	private static Television crearTV() {
		String precio = JOptionPane.showInputDialog("Precio: ");
		String peso = JOptionPane.showInputDialog("Peso(Kg) : ");
		String color = JOptionPane.showInputDialog("Color: ");
		String consumo = JOptionPane.showInputDialog("Consumo(A->F) : ");
		String resolucion = JOptionPane.showInputDialog("Resolucion: ");
		String tdt = JOptionPane.showInputDialog("TDT(S/N) : ");

		if (!precio.equals("") && !peso.equals("")) {
			Television tv = new Television(Integer.parseInt(precio), Integer.parseInt(peso));
			return tv;
		} else if (!precio.equals("") && !peso.equals("") && !color.equals("") && !consumo.equals("")
				&& !resolucion.equals("") && !tdt.equals("")) {
			boolean aux = false;
			if (tdt.equals("S")) {
				aux = true;
				;
			}

			Television tv = new Television(Integer.parseInt(precio), Integer.parseInt(peso), color, consumo.charAt(0),
					Integer.parseInt(resolucion), aux);
			return tv;
		} else if (precio.equals("") && peso.equals("") && color.equals("") && consumo.equals("")
				&& resolucion.equals("") && tdt.equals("")) {
			Television tv = new Television();
			return tv;
		} else {
			return null;
		}

	}

}
