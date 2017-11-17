package Bases4Linea;
import java.util.Scanner;
public class Bases4Linea {
	/*Fundamentos para cuatro en linea
	 * 12/11/2017
	 * inicio de prueba 17:00 horas
	 * fin de prueba  19:30
	 * esto lo que hace es ir poniendo la posicion que el jugador elija en el tablero
	 * para estar lista faltaria la validacion de cuando el usuario uno o dos gano
	 * 13/11/2017
	 * se agrega la validacion en horizontal y vertical, juego funciona
	 * y se soluciuona problema de sustitucion de elemento al sobreporner uno 
	 * encima del otro.
	 * inicio de prueba 12:00 horas
	 * fin de prueba  20:00
	 * pendiente validacion diagonal
	 * 16/11/2017
	 * se agrega variable para empate
	 * se agrega validacion diagonal
	 * se agregan encabezados a las coumnas 
	 *  17/11/2017
	 *  se cambia modo de seleccion de numeros a letras*/
	public static String salir="";
	public static int ficha, fila=6, colum=6;
	public static int [][] matrix = new int [fila][colum];
	public static void main(String[] args) {
		int cont=0; String seleccion="";
		Scanner scan = new Scanner(System.in);
		do{
			System.out.print("Digite \"I\" para iniciar o \"S\" para salir ");
			salir = scan.next();
			if(salir.equalsIgnoreCase("i")){
				imprimir();
				System.out.println("");
			}
			while(salir.equalsIgnoreCase("i")){
					System.out.print("Digite columna jugador 1: ");
					seleccion= scan.next();
					eleccion(seleccion);
					jugador1(ficha-1);
					imprimir();
					
					System.out.print("Digite columna jugador 2: ");
					seleccion= scan.next();
					eleccion(seleccion);
					jugador2(ficha-1);
					imprimir();
					
					ganador();
					cont++;
					empate(cont);
			}
			
			if(salir.equalsIgnoreCase("s")){
				System.out.println("Vamos de salida....");
			}else{
				System.out.println("Digite lo que se le solicito");
			}
		}while(!salir.equalsIgnoreCase("s"));
		scan.close();
	}
	public static void eleccion(String seleccion){
		if(seleccion.equalsIgnoreCase("a")){
			ficha=1;
		}else if(seleccion.equalsIgnoreCase("b")){
			ficha=2;
		}
		else if(seleccion.equalsIgnoreCase("c")){
			ficha=3;
		}else if(seleccion.equalsIgnoreCase("d")){
			ficha=4;
		}else if(seleccion.equalsIgnoreCase("e")){
			ficha=5;
		}else if(seleccion.equalsIgnoreCase("f")){
			ficha=6;
		}
	}
	public static void jugador1(int ficha){
		for(int i=0; i<matrix.length;i++){
			for(int j=0; j<matrix.length; j++){
				if((i==(matrix.length-1) && j==ficha) && matrix[j][i] != 1 
						&& matrix[j][i] != 2){
					matrix[j][i] = 1;
					
				}else if((i<matrix.length && j==ficha) && (matrix[j][i] == 1 
						|| matrix[j][i] == 2)){
					matrix[j][i-1] = 1;
					i++;
				}
			}
		}
	}
	public static void jugador2(int ficha){
		for(int i=0; i<matrix.length;i++){
			for(int j=0; j<matrix.length; j++){
				if((i==(matrix.length-1) && j==ficha) && matrix[j][i] != 2 
						&& matrix[j][i] != 1){
					matrix[j][i] = 2;
					
				}else if((i<matrix.length && j==ficha) && (matrix[j][i] == 1 
						|| matrix[j][i] == 2)){
					matrix[j][i-1] = 2;
					i++;
				}
			}
		}
	}
	public static void imprimir(){
		System.out.print("\n* A  B  C  D  E  F *\n");
		for(int i=0; i<matrix.length;i++){
			System.out.print("|");
			for(int j=0; j<matrix.length; j++){
				System.out.print(" "+matrix[j][i]+" ");
			}
			System.out.print("|");
			System.out.println("");
		}
	}
	public static void empate(int cont){
		if(cont==(fila*colum)-1){
			System.out.println("Juego Empatado");
			salir="s";
		}
	}
	public static void ganador(){
		for(int i=0; i<matrix.length;i++){
			for(int j=0; j<matrix.length; j++){
				if((matrix[0][i]==1 && matrix[1][i]==1 && matrix[2][i]==1 && matrix[3][i]==1)
						|| (matrix[1][i]==1 && matrix[2][i]==1 && matrix[3][i]==1 && matrix[4][i]==1)
						|| (matrix[2][i]==1 && matrix[3][i]==1 && matrix[4][i]==1 && matrix[5][i]==1)
						|| (matrix[j][0]==1 && matrix[j][1]==1 && matrix[j][2]==1 && matrix[j][3]==1)
						|| (matrix[j][1]==1 && matrix[j][2]==1 && matrix[j][3]==1 && matrix[j][4]==1)
						|| (matrix[j][2]==1 && matrix[j][3]==1 && matrix[j][4]==1 && matrix[j][5]==1)){
					System.out.println("Jugador Uno gano");
					salir="s";
					break;
				}else if((matrix[0][i]==2 && matrix[1][i]==2 && matrix[2][i]==2 && matrix[3][i]==2)
						|| (matrix[1][i]==2 && matrix[2][i]==2 && matrix[3][i]==2 && matrix[4][i]==2)
						|| (matrix[2][i]==2 && matrix[3][i]==2 && matrix[4][i]==2 && matrix[5][i]==2)
						|| (matrix[j][0]==2 && matrix[j][1]==2 && matrix[j][2]==1 && matrix[j][3]==2)
						|| (matrix[j][1]==2 && matrix[j][2]==2 && matrix[j][3]==2 && matrix[j][4]==2)
						|| (matrix[j][2]==2 && matrix[j][3]==2 && matrix[j][4]==2 && matrix[j][5]==2)){
					System.out.println("Jugador Dos gano");
					salir="s";
					break;
				}
				
				if((matrix[0][0]==1 && matrix[1][1]==1 && matrix[2][2]==1 && matrix[3][3]==1)
						|| (matrix[0][2]==1 && matrix[1][3]==1 && matrix[2][4]==1 && matrix[3][5]==1)
						|| (matrix[0][1]==1 && matrix[1][2]==1 && matrix[2][3]==1 && matrix[3][4]==1)
						|| (matrix[1][2]==1 && matrix[2][3]==1 && matrix[3][4]==1 && matrix[4][5]==1)						
						|| (matrix[0][0]==1 && matrix[1][1]==1 && matrix[2][2]==1 && matrix[3][3]==1)
						|| (matrix[1][1]==1 && matrix[2][2]==1 && matrix[3][3]==1 && matrix[4][4]==1)
						|| (matrix[2][2]==1 && matrix[3][3]==1 && matrix[4][4]==1 && matrix[5][5]==1)
						|| (matrix[1][0]==1 && matrix[2][1]==1 && matrix[3][2]==1 && matrix[4][3]==1)
						|| (matrix[2][1]==1 && matrix[3][2]==1 && matrix[4][3]==1 && matrix[5][4]==1)
						|| (matrix[2][0]==1 && matrix[3][1]==1 && matrix[4][2]==1 && matrix[5][3]==1)
						|| (matrix[0][3]==1 && matrix[1][2]==1 && matrix[2][1]==1 && matrix[3][0]==1)
						|| (matrix[0][4]==1 && matrix[1][3]==1 && matrix[2][2]==1 && matrix[3][1]==1)
						|| (matrix[1][3]==1 && matrix[2][2]==1 && matrix[3][1]==1 && matrix[4][0]==1)
						|| (matrix[0][5]==1 && matrix[1][4]==1 && matrix[2][3]==1 && matrix[3][2]==1)
						|| (matrix[1][4]==1 && matrix[2][3]==1 && matrix[3][2]==1 && matrix[4][1]==1)
						|| (matrix[2][3]==1 && matrix[3][2]==1 && matrix[4][1]==1 && matrix[5][0]==1)
						|| (matrix[1][5]==1 && matrix[2][4]==1 && matrix[3][3]==1 && matrix[4][2]==1)
						|| (matrix[2][4]==1 && matrix[3][3]==1 && matrix[4][2]==1 && matrix[5][1]==1)
						|| (matrix[2][5]==1 && matrix[3][4]==1 && matrix[4][3]==1 && matrix[5][2]==1)){
					System.out.println("Jugador Uno gano");
					salir="s";
					break;
				}else if((matrix[0][0]==2 && matrix[1][1]==2 && matrix[2][2]==2 && matrix[3][3]==2)
						|| (matrix[0][2]==2 && matrix[1][3]==2 && matrix[2][4]==2 && matrix[3][5]==2)
						|| (matrix[0][1]==2 && matrix[1][2]==2 && matrix[2][3]==2 && matrix[3][4]==2)
						|| (matrix[1][2]==2 && matrix[2][3]==2 && matrix[3][4]==2 && matrix[4][5]==2)						
						|| (matrix[0][0]==2 && matrix[1][1]==2 && matrix[2][2]==2 && matrix[3][3]==2)
						|| (matrix[1][1]==2 && matrix[2][2]==2 && matrix[3][3]==2 && matrix[4][4]==2)
						|| (matrix[2][2]==2 && matrix[3][3]==2 && matrix[4][4]==2 && matrix[5][5]==2)
						|| (matrix[1][0]==2 && matrix[2][1]==2 && matrix[3][2]==2 && matrix[4][3]==2)
						|| (matrix[2][1]==2 && matrix[3][2]==2 && matrix[4][3]==2 && matrix[5][4]==2)
						|| (matrix[2][0]==2 && matrix[3][1]==2 && matrix[4][2]==2 && matrix[5][3]==2)
						|| (matrix[0][3]==2 && matrix[1][2]==2 && matrix[2][1]==2 && matrix[3][0]==2)
						|| (matrix[0][4]==2 && matrix[1][3]==2 && matrix[2][2]==2 && matrix[3][1]==2)
						|| (matrix[1][3]==2 && matrix[2][2]==2 && matrix[3][1]==2 && matrix[4][0]==2)
						|| (matrix[0][5]==2 && matrix[1][4]==2 && matrix[2][3]==2 && matrix[3][2]==2)
						|| (matrix[1][4]==2 && matrix[2][3]==2 && matrix[3][2]==2 && matrix[4][1]==2)
						|| (matrix[2][3]==2 && matrix[3][2]==2 && matrix[4][1]==2 && matrix[5][0]==2)
						|| (matrix[1][5]==2 && matrix[2][4]==2 && matrix[3][3]==2 && matrix[4][2]==2)
						|| (matrix[2][4]==2 && matrix[3][3]==2 && matrix[4][2]==2 && matrix[5][1]==2)
						|| (matrix[2][5]==2 && matrix[3][4]==2 && matrix[4][3]==2 && matrix[5][2]==2)){
					System.out.println("Jugador Dos gano");
					salir="s";
					break;
					
				}
			}
		}
	}

}
