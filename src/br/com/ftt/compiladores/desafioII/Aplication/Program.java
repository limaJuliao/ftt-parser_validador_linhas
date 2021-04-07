package br.com.ftt.compiladores.desafioII.Aplication;

import java.io.File;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import br.com.ftt.compiladores.desafioII.Business.Parser;

public class Program {

	public static void main(String[] args) {
		try {
			Scanner scanner = new Scanner(new File("prog.txt"));
			PrintWriter pw = new PrintWriter("prog-check.txt", StandardCharsets.UTF_16);
			String txt = "";
			
			while(scanner.hasNextLine()) {
				String linha = scanner.nextLine();
				
				if (Parser.Balanced(linha)) {
					txt += linha + "   --  ok" +"\n";
				} else {
					txt += linha + "   --  inválida" +"\n";
				}
				
			}
			
			scanner.close();
			pw.print(txt);
			pw.close();
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		

	}

}
