
public class Cliente {
	private String cfp;
	private String nome;
	
	public Cliente(String cfp, String nome) {
		this.cfp = cfp;
		this.nome = nome;
	}

	public String getCfp() {
		return cfp;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
