package pedro.nery.lotofacil.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import pedro.nery.lotofacil.domain.Bola;
import pedro.nery.lotofacil.domain.Sorteio;

public class Verificando {

	public static void bolasConcurso(List<Sorteio> lisSorteios) {

		Scanner scanner = new Scanner(System.in);

		List<Bola> bolas = new ArrayList<>();
		int i = 1;
		System.out.println("Digite os números escolhido para Sorteio:");

		while (i <= 15) {

			String bolaId = scanner.nextLine();

			Bola bola = new Bola();
			bola.setId(Integer.parseInt(bolaId));
			bolas.add(bola);
			i++;
		}
		i = 1;

		for (Sorteio sorteio : lisSorteios) {

			for (Bola bola : bolas) {

				for (Bola bola2 : sorteio.getBolas()) {

					if (bola.getId() == bola2.getId()) {
						i++;
					}
				}
			}

			if (i >= 13) {
				System.out.println("sorteio num : " + sorteio.getId() + " saiu " + i + " números");
			}
			i = 1;

		}

	}
}
