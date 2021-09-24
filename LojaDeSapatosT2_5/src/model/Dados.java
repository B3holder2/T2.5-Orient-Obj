package model;

import java.util.ArrayList;
import java.util.List;

public class Dados {
	private final ArrayList<Cliente> cliente = new ArrayList<>();
	private final ArrayList<Funcionario> funcionario = new ArrayList<>();
	private final ArrayList<Venda> venda = new ArrayList<>();
	private final ArrayList<Endereco> endereco = new ArrayList<>();
	private final List<Produto> produto = new ArrayList<>();

	public Dados() {

	}

	public ArrayList<Cliente> getCliente() {
		return cliente;
	}

	public ArrayList<Funcionario> getFuncionario() {
		return funcionario;
	}

	public ArrayList<Venda> getVenda() {
		return venda;
	}

	public ArrayList<Endereco> getEndereco() {
		return endereco;
	}

	public List<Produto> getProduto() {
		return produto;
	}

	/*
	 * // CLIENTE public List<Cliente> getCliente() { return cliente; }
	 * 
	 * public void addCliente(Cliente cliente) { this.cliente.add(cliente); }
	 * 
	 * public void imprimirClientes() {
	 * System.out.println("\n~IMPRIMINDO TODOS OS CLIENTES~\n");
	 * 
	 * for (int i = 0; i < cliente.size(); i++) { System.out.println(i + 1 +
	 * "� Cliente: "); cliente.get(i).imprimir(); System.out.println(""); } }
	 * 
	 * public void deletarClientes() { System.out.
	 * println("\n~DELETAR CLIENTE~\n\nEscolha o cliente a ser deletado: ");
	 * 
	 * for (int i = 0; i < cliente.size(); i++) { System.out.println(i + 1 +
	 * "� Cliente: "); cliente.get(i).imprimir(); System.out.println(""); }
	 * 
	 * System.out.print("Op��o escolhida: "); int opc = sc.nextInt(); sc.nextLine();
	 * // Limpando o Buffer
	 * 
	 * while (opc < 1 || opc > cliente.size()) { // Verifica��o de validade do valor
	 * inserido System.out.println("\nVALOR INCORRETO! ESCOLHA UMA OP��O DO MENU!");
	 * System.out.print("Op��o escolhida: "); opc = sc.nextInt(); } opc--;
	 * cliente.remove(opc); System.out.println("Cliente removido!"); }
	 * 
	 * // FUNCIONARIO public List<Funcionario> getFuncionario() { return
	 * funcionario; }
	 * 
	 * public void addFuncionario(Funcionario funcionario) {
	 * this.funcionario.add(funcionario); }
	 * 
	 * public void imprimirFuncionarios() {
	 * System.out.println("\n~IMPRIMINDO TODOS OS FUNCION�RIOS~\n");
	 * 
	 * for (int i = 0; i < funcionario.size(); i++) { System.out.println(i + 1 +
	 * "� Funcion�rio: "); funcionario.get(i).imprimir(); System.out.println(""); }
	 * }
	 * 
	 * public void deletarFuncionarios(Loja loja) { System.out.
	 * println("\n~DELETAR FUNCION�RIO~\n\nEscolha o funcion�rio a ser deletado: ");
	 * 
	 * for (int i = 0; i < funcionario.size(); i++) { System.out.println(i + 1 +
	 * "� Funcion�rio: "); funcionario.get(i).imprimir(); System.out.println(""); }
	 * 
	 * System.out.print("Op��o escolhida: "); int opc = sc.nextInt(); sc.nextLine();
	 * // Limpando o Buffer
	 * 
	 * while (opc < 1 || opc > funcionario.size()) { // Verifica��o de validade do
	 * valor inserido
	 * System.out.println("\nVALOR INCORRETO! ESCOLHA UMA OP��O DO MENU!");
	 * System.out.print("Op��o escolhida: "); opc = sc.nextInt(); } opc--;
	 * loja.deletarFuncionario(funcionario.get(opc)); // Deletando o funcion�rio da
	 * inst�ncia da classe Loja atrav�s do // m�todo loja.deletarFuncionario()
	 * funcionario.remove(opc); System.out.println("Funcion�rio removido!"); }
	 * 
	 * // VENDA public List<Venda> getVenda() { return venda; }
	 * 
	 * public void addVenda(Venda venda) { this.venda.add(venda); }
	 * 
	 * public void imprimirVendas() {
	 * System.out.println("\n~IMPRIMINDO TODAS AS VENDAS~\n");
	 * 
	 * for (int i = 0; i < venda.size(); i++) { System.out.println(i + 1 +
	 * "� Venda: "); venda.get(i).imprimir(); System.out.println(""); } }
	 * 
	 * // ENDERECO public ArrayList<Endereco> getEndereco() { return endereco; }
	 * 
	 * public void addEndereco(Endereco endereco) { this.endereco.add(endereco); }
	 * 
	 * public void imprimirEnderecos() {
	 * System.out.println("\n~IMPRIMINDO TODOS OS ENDERECOS~\n");
	 * 
	 * for (int i = 0; i < endereco.size(); i++) { System.out.println(i + 1 +
	 * "� Endere�o: "); endereco.get(i).imprimir(); System.out.println(""); } }
	 * 
	 * // PRODUTO public List<Produto> getProduto() { return produto; }
	 * 
	 * public void addProduto(Produto produto) { this.produto.add(produto); }
	 * 
	 * public void imprimirProdutos() {
	 * System.out.println("\n~IMPRIMINDO TODOS OS PRODUTOS~\n");
	 * 
	 * for (int i = 0; i < produto.size(); i++) { System.out.print(i + 1 +
	 * "� Produto: "); produto.get(i).imprimir(); System.out.println(""); } }
	 * 
	 * public void deletarProdutos(Estoque estoque) { System.out.
	 * println("\n~DELETAR PRODUTO~\n\nEscolha o produto a ser deletado: ");
	 * 
	 * for (int i = 0; i < produto.size(); i++) { System.out.print(i + 1 +
	 * "� Produto: "); produto.get(i).imprimir(); System.out.println(""); }
	 * 
	 * System.out.print("Op��o escolhida: "); int opc = sc.nextInt(); sc.nextLine();
	 * // Limpando o Buffer
	 * 
	 * while (opc < 1 || opc > produto.size()) { // Validando valor inserido
	 * System.out.println("\nVALOR INCORRETO! ESCOLHA UMA OP��O DO MENU!");
	 * System.out.print("Op��o escolhida: "); opc = sc.nextInt(); } opc--;
	 * estoque.deletarProduto(produto.get(opc)); // Enviando produto para que este
	 * tamb�m seja deletado em Estoque produto.remove(opc); // Deletando produto em
	 * Dados System.out.println("Produto removido!"); }
	 */

}