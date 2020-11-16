import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase que implementa el listener de los botones del Buscaminas.
 * @author Iván Gil Martín
 */
public class ActionBoton implements ActionListener{

	/**
	 * Atributos privados de la clase ActionBoton
	 */
	private VentanaPrincipal ventana;
	private int i;
	private int j;

	/**
	 * Constructor parametrizado de la clase ActionBoton
	 * @param ventana
	 * @param i
	 * @param j
	 */
	public ActionBoton(VentanaPrincipal ventana, int i, int j) {
		this.ventana = ventana;
		this.i = i;
		this.j = j;
	}
	
	/**
	 * Accion que realiza cada uno de los botones inicializados en la clase VentanaPrincipal
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		if (ventana.juego.abrirCasilla(i, j)){
			ventana.mostrarNumMinasAlrededor(i, j);
			ventana.actualizarPuntuacion();
		}
		else{
			if (ventana.juego.getPuntuacion() == (ventana.juego.LADO_TABLERO * ventana.juego.LADO_TABLERO) - ventana.juego.MINAS_INICIALES){
				ventana.mostrarFinJuego(false);
			}
			else{
				ventana.mostrarFinJuego(true);
			}
		}

		ventana.refrescarPantalla();
	}
}
