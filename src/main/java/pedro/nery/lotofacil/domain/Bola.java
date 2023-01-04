package pedro.nery.lotofacil.domain;

public class Bola {

	Integer id;
	Integer atraso;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAtraso() {
		return atraso;
	}

	public void setAtraso(Integer atraso) {
		this.atraso = atraso;
	}

	@Override
	public String toString() {
		return "id: " +this.id + ", atraso: "+ this.atraso;
		
	}
}
