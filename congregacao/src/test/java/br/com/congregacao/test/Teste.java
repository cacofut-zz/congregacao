package br.com.congregacao.test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import javax.management.Query;

public class Teste {

	public static void main(String[] args) {
		
		System.out.println( System.getProperty( "user.home" ) );
		String separator = System.getProperty("file.separator");
		System.out.println( separator );
		
		//\Desktop\banco_de_dados
		Path caminho = Paths.get( System.getProperty( "user.home" ) ,  "Desktop"+separator+"banco_de_dados"+separator+"teste.txt");
		System.out.println( caminho );
		try {

			List<String> linhas = Files.lines(caminho, StandardCharsets.ISO_8859_1 ).collect(Collectors.toList());
			IntStream.range(0, linhas.size() )
				.forEach( indice -> {
					System.out.println( linhas.get(indice) );
				});
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
