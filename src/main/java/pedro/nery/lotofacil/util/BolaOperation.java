package pedro.nery.lotofacil.util;

import java.util.ArrayList;
import java.util.List;

import pedro.nery.lotofacil.domain.Bola;
import pedro.nery.lotofacil.domain.Sorteio;

public class BolaOperation {

	public static List<Bola> preencheBolaAtradas(List<Sorteio> list) {

		List<Bola> bolasVazias = getBolas();

		List<Bola> retList = new ArrayList<>();
		int count = 1;

		for (Bola bola : bolasVazias) {
			count = 1;
			for (Sorteio sorteio : list) {

				for (Bola bola2 : sorteio.getBolas()) {

					if (bola.getId() == bola2.getId()) {

						bola.setAtraso(count -1);

						retList.add(bola);
						count = 0;
						break;
					}
				}
				if (count == 0) {
					break;
				}
				count++;
			}

		}
		return retList;
	}

	private static List<Bola> getBolas() {

		List<Bola> bolas = new ArrayList<>();

		for (int i = 1; i <= 25; i++) {

			Bola bola = new Bola();
			bola.setId(i);
			bolas.add(bola);
		}
		return bolas;
	}
}
