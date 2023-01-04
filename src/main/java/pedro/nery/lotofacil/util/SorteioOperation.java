package pedro.nery.lotofacil.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import pedro.nery.lotofacil.domain.Bola;
import pedro.nery.lotofacil.domain.Sorteio;

public class SorteioOperation {

	public static List<Sorteio> getListSort(XSSFWorkbook workbook) {

		List<Sorteio> list = new ArrayList<>();
		Sorteio sorteio;
		Bola bola;

		XSSFSheet sheet = workbook.getSheetAt(0);

		int RowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();

		for (int i = 7; i <= RowCount; i++) {
			if (sheet.getRow(i) != null) {

				List<Bola> bolas = new ArrayList<>();
				sorteio = new Sorteio();

				XSSFCell cell = sheet.getRow(i).getCell(0);
				sorteio.setId((int) cell.getNumericCellValue());

				for (int j = 2; j <= 16; j++) {

					cell = sheet.getRow(i).getCell(j);
					bola = new Bola();
					bola.setId((int) cell.getNumericCellValue());
					bolas.add(bola);
				}
				sorteio.setBolas(bolas);
				list.add(sorteio);
			}
		}

		return list;
	}
	

}
