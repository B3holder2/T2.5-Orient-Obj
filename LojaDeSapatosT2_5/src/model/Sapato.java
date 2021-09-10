package model;

import java.util.Date;

public class Sapato extends Produto {
	private String materialSolado;
	private String materialInterno;
	private String tipoBico;
	private String alturaSalto;
	private String tipoPalmilha;

	
	
	public Sapato(int idProd, String nome, int tamanho, Double preco, String marca, String paisOrigem,
			Date tempoGarantia, char genero, String codBarras, String cor, String material, String materialSolado,
			String materialInterno, String tipoBico, String alturaSalto, String tipoPalmilha) {
		super(idProd, nome, tamanho, preco, marca, paisOrigem, tempoGarantia, genero, codBarras, cor, material);
		setMaterialSolado(materialSolado);
		setMaterialInterno(materialInterno);
		setTipoBico(tipoBico);
		setAlturaSalto(alturaSalto);
		setTipoPalmilha(tipoPalmilha);
	}

	public Sapato() {
		super();
		setMaterialSolado("");
		setMaterialInterno("");
		setTipoBico("");
		setAlturaSalto("");
		setTipoPalmilha("");
	}
	
	public void cadastrar(int idProd, String nome, int tamanho, Double preco, String marca, String paisOrigem, Date tempoGarantia, char genero, 
			 String codBarras, String material, String cor, String materialSolado, String materialInterno, String tipoBico, String alturaSalto, String tipoPalmilha) {
		setIdProd(idProd);
		setNome(nome);
		setTamanho(tamanho);
		setPreco(preco);
		setMarca(marca);
		setPaisOrigem(paisOrigem);
		setTempoGarantia(tempoGarantia);
		setGenero(genero);
		setCodBarras(codBarras);
		setCor(cor);
		setMaterial(material);
		setMaterialSolado(materialSolado);
		setMaterialInterno(materialInterno);
		setTipoBico(tipoBico);
		setAlturaSalto(alturaSalto);
		setTipoPalmilha(tipoPalmilha);
	}
	
	@Override
	public void imprimir() {
		System.out.print("Sapato");
		System.out.println("\nID do Produto: " + this.getIdProd() + "\nNome: " + this.getNome() + "\nTamanho: " + this.getTamanho() +
				"\nPre�o: R$" + this.getPreco() + "\nMarca: " + this.getMarca() + "\nPa�s de Origem: " + this.getPaisOrigem() + "\nTempo de Garantia: " +
				this.getTempoGarantia() + "\nG�nero: " + this.getGenero() + "\nC�digo de Barras: " + this.getCodBarras() + "\nMaterial: " + this.getMaterial() +
				"\nCor: " + this.getCor() + "\nMaterial do Solado: " + this.getMaterialSolado() + "\nMaterial Interno: " + this.getMaterialInterno() +
				"\nTipo de Bico: " + this.getTipoBico() + "\nAltura do Salto: " + this.getAlturaSalto() + "\nTipo de Palmilha: " + this.getTipoPalmilha() + ".");
	}
	
	public void editar(int idProd, String nome, int tamanho, Double preco, String marca, String paisOrigem, Date tempoGarantia, char genero, 
			 String codBarras, String material, String cor, String materialSolado, String materialInterno, String tipoBico, String alturaSalto, String tipoPalmilha) {
		setIdProd(idProd);
		setNome(nome);
		setTamanho(tamanho);
		setPreco(preco);
		setMarca(marca);
		setPaisOrigem(paisOrigem);
		setTempoGarantia(tempoGarantia);
		setGenero(genero);
		setCodBarras(codBarras);
		setCor(cor);
		setMaterial(material);
		setMaterialSolado(materialSolado);
		setMaterialInterno(materialInterno);
		setTipoBico(tipoBico);
		setAlturaSalto(alturaSalto);
		setTipoPalmilha(tipoPalmilha);
	}
	
	@Override
	public String toString() {
		return "\nID do Produto: " + this.getIdProd() + "\nNome: " + this.getNome() + "\nTamanho: " + this.getTamanho() +
				"\nPre�o: R$" + this.getPreco() + "\nMarca: " + this.getMarca() + "\nG�nero: " + this.getGenero() + "\nMaterial: " + this.getMaterial() +
				"\nCor: " + this.getCor() + "\nAltura do Salto: " + this.getAlturaSalto() + ".";
	}

	public String getMaterialSolado() {
		return materialSolado;
	}

	public void setMaterialSolado(String materialSolado) {
		this.materialSolado = materialSolado;
	}

	public String getMaterialInterno() {
		return materialInterno;
	}

	public void setMaterialInterno(String materialInterno) {
		this.materialInterno = materialInterno;
	}

	public String getTipoBico() {
		return tipoBico;
	}

	public void setTipoBico(String tipoBico) {
		this.tipoBico = tipoBico;
	}

	public String getAlturaSalto() {
		return alturaSalto;
	}

	public void setAlturaSalto(String alturaSalto) {
		this.alturaSalto = alturaSalto;
	}

	public String getTipoPalmilha() {
		return tipoPalmilha;
	}

	public void setTipoPalmilha(String tipoPalmilha) {
		this.tipoPalmilha = tipoPalmilha;
	}
	
}
