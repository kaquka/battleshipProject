package GUI;

import System.PuntoXY;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelTablero extends JPanel{	
    public Celda[][] celdas; //Celdas jugables donde habra agua, barcos, etc..
    public int tablength=10;
	
    public PanelTablero() {
        //Construimos celdas para las "aguas"
        this.setOpaque(false);
        celdas = new Celda[tablength][tablength];
        for (int i = 0; i < tablength; i++)
            for (int j = 0; j < tablength; j++)
                celdas[i][j] = new Celda(new PuntoXY(i,j));

        //Celdas que indican las coordenadas del tablero
        Celda[] celdasX = new Celda[tablength];
        Celda[] celdasY = new Celda[tablength];
        for (int i = 0; i < tablength; i++) {
            celdasX[i] = new Celda(new JLabel(Integer.toString(i)));
            celdasY[i] = new Celda(new JLabel(Integer.toString(i)));
        }
        //Maquetamos tablero
        setLayout(new GridLayout(11,11,3,3)); //Esta grilla tendr� ambos tipos de celdas
         //La grilla se rellena fila a fila.
         //1� fila
        JPanel p=new JPanel();
        p.setOpaque(false);
        add(p);//Primera celda de la grilla no ser� nada, solo un panel vac�o.
         //A continuaci�n, las Celdas con n�mero para las Columnas, o sea, el eje Y de coordenadas
        for (Celda valorEjeY: celdasY)
            add(valorEjeY);

         //Las siguientes filas las automatizamos con bucles anidado
        for (int i = 0; i < tablength ; i++) {
            add(celdasX[i]); //Comienza con n�mero de Fila, o sea, eje X
            //A continuaci�n, una tanda de Celdas "agua" de las que tenemos en la matriz
            for (Celda agua: celdas[i])
                add(agua);
        }
		
    }
    
    public void setColor(int x, int y, Color color){
        celdas[x][y].setBackground(color);
    }
        
	/**
	 * Habr�n dos tipos de Celdas.
	 * Una tendr� una etiqueta para mostrar el n�mero de fila
	 * o columna que representa, con valores de 0 a 7. Ser�n las
	 * Celdas que identifican las coordenadas.
	 *
	 * Las otras no tendr�n etiqueta y representar�n las "aguas" donde
	 * se lleva a cabo la batalla.
	 *
	 * Tendremos dos constructores, cada uno para configurar la Celda
	 * de un modo u otro.
	 */
	private class Celda extends JPanel {
		
		PuntoXY coord; //Solo algunas casillas tendr�n coordenadas
		
		public Celda(PuntoXY coord) {
			this.coord = coord;
			setPreferredSize(new Dimension(50, 50));
			setBorder(BorderFactory.createLineBorder(Color.BLACK, 4, true));
			setBackground(Color.WHITE);
		}
		
		public Celda(JLabel numCelda) {
			setPreferredSize(new Dimension(25, 25));
			setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
			numCelda.setFont(new Font("Verdana", Font.BOLD, 22));
			numCelda.setForeground(Color.WHITE);
			add(numCelda);
			setBackground(Color.BLACK);
		}
                
          
	}

}