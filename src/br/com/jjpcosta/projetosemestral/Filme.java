package br.com.jjpcosta.projetosemestral;

public class Filme {
	private String titulo;
	private String sinopse;
	private String genero;
	private String assistir;
	private boolean assistido;
	private int avaliacao;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getAssistir() {
		return assistir;
	}

	public void setAssistir(String assistir) {
		this.assistir = assistir;
	}

	public boolean isAssistido() {
		return assistido;
	}

	public void setAssistido(boolean assistido) {
		this.assistido = assistido;
	}

	public int getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(int avaliacao) {
		this.avaliacao = avaliacao;
	}

	@Override
	public String toString() {
		return "Filme [titulo=" + titulo + ", sinopse=" + sinopse + ", genero=" + genero + ", assistir=" + assistir
				+ ", assistido=" + assistido + ", avaliacao=" + avaliacao + "]";
	}

}
