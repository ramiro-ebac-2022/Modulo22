package br.com.zavala.Exercicio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import br.com.zavala.Domain.Pessoa;

public class Streams {
    
    public static void main(String[] args) {
        List<Pessoa> pessoas = new ArrayList<Pessoa>();

        //Leitura dos dados
        try (Scanner s = new Scanner(System.in)) {
            String leitura = "N";
			String nome,sexo;
			Pessoa p1;
			System.out.println("LEITURA DE DADOS DAS PESSOAS");
			System.out.println("============================");
            do {
				System.out.println("Nome : ");
				nome = s.next();
				System.out.println("Sexo(M/F) : ");
				sexo = s.next();
				p1 = new Pessoa(nome,sexo);
                pessoas.add(p1);
				System.out.println("");
				System.out.println("==> Digite 'S' para novo registro. Digite outra letra para terminar : ");
				leitura = s.next();
			} while(leitura.equals("S"));
        }

        //Impressão dos dados
		System.out.println("");
		imprimePessoa(pessoas);

    }

    private static void imprimePessoa(List<Pessoa> pessoas) {
    
        System.out.println("Pessoas do sexo Masculino :");
		System.out.println("---------------------------");
		List<Pessoa> masculino = pessoas.stream()
                                .filter(pessoa -> pessoa.getSexo().startsWith("M"))
                                .collect(Collectors.toList());
        masculino.forEach(pessoa -> System.out.println(pessoa));

        System.out.println("");
        System.out.println("Pessoas do sexo Feminino :");
		System.out.println("---------------------------");
		List<Pessoa> feminino = pessoas.stream()
                                .filter(pessoa -> pessoa.getSexo().startsWith("F"))
                                .collect(Collectors.toList());
        feminino.forEach(pessoa -> System.out.println(pessoa));

    }
}
