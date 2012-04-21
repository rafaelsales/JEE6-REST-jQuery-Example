package rafaelcds.model;

public enum ETipoMovimentacao {
	RECEITA("Receita"), DESPESA("Despesa");

	private final String nome;

	private ETipoMovimentacao(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	@Override
	public String toString() {
		return nome;
	}
}
