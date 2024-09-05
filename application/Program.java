package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

import entities.LogEntry;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter file full path: ");
		String path = sc.nextLine();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))){
			Set<LogEntry> set = new HashSet<>();								// HashSet PQ para contar a quantidade de usuários não precisa estar em ordem
			
			String line = br.readLine(); 										// li minha linha
			
			while (line != null) {
				
				String[] fields = line.split(" ");								// Recortei o que está na linha com o espaço
				String userName = fields[0];									// Coloquei o que está na primeira parte da linha na variável userName
				Date moment = Date.from(Instant.parse(fields[1]));				// coloqueo o que está na segunda parte da linha na variável moment
				
				set.add(new LogEntry(userName, moment));						// Adicionei as variáveis userName e moment no meu objeto LogEntry
				
				line = br.readLine();											// Agora, vou mandar ler a proxíma linha
			}
			
			System.out.println("Total users: " + set.size()); 					// .size() = o tamanho no meu arquivo
			
		}
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		// 			Endereço do arquivo : /home/tom/Área de Trabalho/Tecnologia/in4.txt
		
		sc.close();
	}
}
