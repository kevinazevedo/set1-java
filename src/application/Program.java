package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import entities.LogEntry;

public class Program {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		Set<LogEntry> set = new HashSet<>();
		
		System.out.print("Enter file full path: ");
		String path = scan.nextLine();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {		
			String line = br.readLine();				
			while (line != null) {
				String[] fields = line.split(" "); 	
				String username = fields[0];
				Date moment = Date.from(Instant.parse(fields[1]));
				
				set.add(new LogEntry(username, moment));
				line = br.readLine();			
			}
		}
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		System.out.println("Total users: " + set.size());
		
		scan.close();
	}
}
