package pedro.nery.lotofacil;

import java.io.InputStream;
import java.util.List;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import pedro.nery.lotofacil.domain.Bola;
import pedro.nery.lotofacil.domain.Sorteio;
import pedro.nery.lotofacil.util.BolaOperation;
import pedro.nery.lotofacil.util.ExcelOperation;
import pedro.nery.lotofacil.util.SorteioOperation;
import pedro.nery.lotofacil.util.Verificando;

public class LotoFacil {
	public static void main(String[] args) throws Exception {

		CloseableHttpClient clientCloseableHttpClient = HttpClients.createDefault();
		InputStream stream = ExcelOperation.getPlanilha(clientCloseableHttpClient);

		XSSFWorkbook workbook = new XSSFWorkbook(stream);
		stream.close();
		clientCloseableHttpClient.close();

		List<Sorteio> sorteios = SorteioOperation.getListSort(workbook);
		
		for (Bola bola : BolaOperation.preencheBolaAtradas(sorteios)) {
			if (bola.getAtraso() >= 1) {
				
				System.out.println(bola.toString());
			}
		}

		Verificando.bolasConcurso(sorteios);
		 System.out.println();

		workbook.close();
	}
}
