package pedro.nery.lotofacil.domain;

import java.util.List;

public class Sorteio {

	Integer id;
	List<Bola> bolas;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Bola> getBolas() {
		return bolas;
	}

	public void setBolas(List<Bola> bolas) {
		this.bolas = bolas;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Concurso: " + id + " Bolas:" + showBola(bolas);
	}

	private String showBola(List<Bola> bolas) {
		String msg = "";
		for (Bola bola : bolas) {

			msg = msg + bola.getId() + ", ";
		}
		return msg;
	}
}
