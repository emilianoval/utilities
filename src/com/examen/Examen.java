package com.examen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Examen {
	
	public static void main(String[] args) {
		int numero;
		String texto;
		Scanner entrada = new Scanner(System.in);
		System.out.println("Digite un numero entre 0-9");
		numero = Integer.parseInt(entrada.next());
		Scanner entradaString = new Scanner(System.in);
		System.out.println("Digite texto y numeros para validar si es palindromo o multiplos del numero que digito");
		texto = entradaString.nextLine();
		
		// funcion
		ejecutarFuncion(numero, texto);
		entrada.close();
		entradaString.close();
	}

	private static void ejecutarFuncion(int numero, String texto) {
		// TODO Auto-generated method stub
		StringBuffer cadenaFinal = new StringBuffer();
		// Descomponemos la cadena en tokens
		StringTokenizer tokens=new StringTokenizer(texto);
		String [] ordenamientoFinal = new String[100];
		
		int contador = 0;
		while(tokens.hasMoreTokens()){
			
			// Es numero lo agregamos a la lista para validar maximo multiplo  
			String temp = tokens.nextToken();
			if(esnumero(temp)){
	        	// Es multiplo del numero ingresado?
				int auxNumero=Integer.parseInt(temp);
				if(auxNumero % numero == 0){
					cadenaFinal.append(auxNumero);
					cadenaFinal.append(", ");
					ordenamientoFinal[contador] = auxNumero+",";
					contador++;
					
				}
	         }else{// son cadenas
	        	 // eliminamos caracteres extraños y commas
	        	 String aRemplazar=temp;
	     		 String remplazado=aRemplazar.replace(",", "");
	     		
	        	// validamos si es paindromo
	        	if(esPalindromo(remplazado)){
	        		//si es
	        		cadenaFinal.append(remplazado);
	        		ordenamientoFinal[contador] = remplazado+",";
	        		cadenaFinal.append(", ");
	        		
					contador++;
	        	}else{
	        	    // no es
	        	} 
	         }  
			//System.out.println(tokens.nextToken());
	        }
	    List<String> list = new ArrayList<String>();

	    for(String s : ordenamientoFinal) {
	       if(s != null && s.length() > 0) {
	          list.add(s);
	       }
	    }

	    ordenamientoFinal = list.toArray(new String[list.size()]);
	    Arrays.sort(ordenamientoFinal);
	    
	    for (String temp : ordenamientoFinal) {
			System.out.print( temp);
		}
	}

	private static boolean esnumero(String nextToken) {
		// TODO Auto-generated method stub
		boolean isNumber = true;
		
		try {
			Integer.parseInt(nextToken);
		} catch (Exception e) {
			// TODO: handle exception
			isNumber = false;
		}
		return isNumber;
	}
	
	public static boolean esPalindromo(String cadena) {
		boolean flag = true;
		int aux;
		String stringAux = "";
		// quitamos los espacios
		for (int x = 0; x < cadena.length(); x++) {
			if (cadena.charAt(x) != ' ')
				stringAux += cadena.charAt(x);
		}
		// volvemos a asignar variables
		cadena = stringAux;
		aux = cadena.length();
		// comparamos cadenas
		for (int i = 0; i < (cadena.length()); i++) {
			if (cadena.substring(i, i + 1).equals(
					cadena.substring(aux - 1, aux)) == false) {
				// si una sola letra no corresponde no es un palindromo por
				// tanto
				// sale del ciclo con valor false
				flag = false;
				break;
			}
			aux--;
		}
		return flag;
	}

}
