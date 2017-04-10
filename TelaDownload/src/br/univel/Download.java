package br.univel;

public class Download implements Runnable {
	private int id;
	private String endereco;
	private int progresso;
	private DownloadTableModel modelo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getProgresso() {
		return progresso;
	}

	public void setProgresso(int progresso) {
		this.progresso = progresso;
	}

	@Override
	public void run() {
		for (int i = 0; i <= 100; i++) {
			setProgresso(i);
			modelo.fireTableDataChanged();
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

	public void setTableModel(DownloadTableModel modelo) {
		this.modelo = modelo;
	}

}
