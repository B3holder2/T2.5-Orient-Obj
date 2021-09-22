package main;
import java.util.*;

import model.*;

public class Teste {
	

	public static void main(String[] args){
		//Objetos
		Endereco end;
		Endereco end2;
		Cliente cl;
		Cliente cl2;
		Funcionario fun;
		Funcionario fun2;
		Pagamento pag;
		Pagamento pag2;
		Tenis ten;
		Sapato sap;
		Bota bot;
		Salto sal;
		Estoque est;
		Loja loj;
		Venda ven;
		Dados dado = new Dados();
		
		//Cadastrando datas
		GregorianCalendar d = new GregorianCalendar();
		Date dat = d.getTime();
		
		System.out.println("===================================================================");
		//ENDERE�O: Instanciando e inserindo dados		
		end = new Endereco();
		end.cadastrar(70000000, "Ciudad", "PR", "Rua JK", 15, 04, "Centro", 00, "Casa Amarela");
		
		end2 = new Endereco();
		end2.cadastrar("Goi�nia", "Rua 7 de Setembro", 488, "Setor Oeste");
		
		//Editando dados
		end.editar(73000000, "Cascavel", "PR", "Rua Python", 6, 7, "Setor Sul", 6, "Casa coral");
		
		//Imprimindo dados separadamente
		System.out.println("Imprimindo endere�os separadamente: \nEndere�o 1: ");
		end.imprimir();
		System.out.println("\nEndere�o 2: ");
		end2.imprimir();
		
		//Salvando dados na inst�ncia da classe Dados
		dado.addEndereco(end);
		dado.addEndereco(end2);
		
		System.out.println("-------------------------------------------------------------------");
		
		//Imprimindo todos os endere�os
		dado.imprimirEnderecos();
		
		System.out.println("===================================================================");
		
		//FUNCION�RIO: Instanciando e inserindo dados
		fun = new Funcionario();
		fun.cadastrar("Jo�o", dat, "333.333.333-33", "(61) 93333-3333", dat, "Integral", 8, 17, end);
		
		fun2 = new Funcionario();
		fun2.cadastrar("M�rio", dat, "444.444.444-44", "(61) 94444-4444", dat, "Matutino", 8, 12, end2);
		
		//Editando dados
		fun.editar("Jos�", dat, "343.434.343-34", "(61) 93443-4334", dat, "Vespertino", 12, 18, end);
		
		//Imprimindo dados separadamente
		System.out.println("Imprimindo funcion�rios separadamente: \nFuncion�rio 1: ");
		fun.imprimir();
		System.out.println("\nEndere�o 2: ");
		fun2.imprimir();
		
		//Salvando todos os funcion�rios em uma ArrayList
		ArrayList<Funcionario> funcio = new ArrayList<>();		
		funcio.add(fun);
		funcio.add(fun2);
		
		//Salvando dados na inst�ncia da classe Dados
		dado.addFuncionario(fun);
		dado.addFuncionario(fun2);
		
		System.out.println("-------------------------------------------------------------------");
		
		//Imprimindo todos os funcion�rios
		dado.imprimirFuncionarios();
		
		System.out.println("===================================================================");
		
		//CLIENTE: Instanciando e inserindo dados
		cl = new Cliente();
		cl.cadastrar(end, "Felipe", 'M', dat, "111.111.111-11", "(61) 91111-1111", "felipe@gmail.com");
		
		cl2 = new Cliente();
		cl2.cadastrar(end2, "Joana", 'F', dat, "222.222.222-22", "(61) 92222-2222", "joana@gmail.com");
		
		//Editando dados
		cl2.editar(end2, "J�lia", 'F', dat, "121.212.121-12", "(61) 92112-1221", "julia@gmail.com");
		
		//Imprimindo dados separadamente
		System.out.println("Imprimindo clientes separadamente: \nCliente 1: ");
		cl.imprimir();
		System.out.println("\nCliente 2: ");
		cl2.imprimir();
		
		//Salvando dados na inst�ncia da classe Dados
		dado.addCliente(cl);
		dado.addCliente(cl2);
		
		System.out.println("-------------------------------------------------------------------");
		
		//Imprimindo todos os clientes
		dado.imprimirClientes();
		
		System.out.println("===================================================================");
		
		//Classes Filhas de PRODUTO (SALTO, SAPATO, T�NIS E BOTA): Instanciando e inserindo dados
		ten = new Tenis();
		ten.cadastrar(1, "Run 7", 41, 210.5, "Asics", "Taiwan", dat, 'M', "00010001", "Tecido Mash", 
				"Vermelho", "Corrida", "Gel", "Pronada", "Gel", 250.1, "Cadar�o", "Azul");
		
		sap = new Sapato();
		sap.cadastrar(2, "Mocassim", 42, 200.99, "Democrata", "Brasil", dat, 'U', "11101110", "Nappa",
				"Preto", "Borracha", "Espuma", "Quadrado", "Baixo", "Comum");
		
		bot = new Bota();
		bot.cadastrar(3, "Botina", 43, 152.8, "Rio Branco", "Brasil", dat, 'U', "10101010", "Couro",
				"Marrom", "Trabalho", "M�dio", "Pequeno", "N�o possui", "Borracha");
		
		sal = new Salto();
		sal.cadastrar(4, "Salto Alto", 40, 500.0, "Schutz", "Brasil", dat, 'F', "01010101",
				"Couro Org�nico", "Bege", "Scarpin", "Bege", "Vermelho", "Alto");
		
		//Editando dados
		ten.editar(1, "T�nis Performance Run 7", 45, 200.0, "Asics", "EUA", dat, 'M', "0100110101",
				"Tecido Mash", "Azul", "Corrida", "Gel", "Comum", "Gel", 250.5, "Cadar�o", "Preto");
		sap.editar(2, "Mocassim", 40, 200.99, "Havana", "Portugal", dat, 'U', "01011111", "Couro",
				"Marrom", "Borracha", "Tecido", "Arredondado", "N�o Possui", "EVA");
		bot.editar(3, "Bota Americana", 37, 163.3, "Texans", "China", dat, 'F', "0000010000", "Couro",
				"Branco", "Passeio", "Alto", "Baixo", "N�o Possui", "Borracha");
		sal.editar(4, "Salto Alto", 38, 500.0, "NotHere", "Argentina", dat, 'F', "01000110010",
				"Couro Org�nico", "Preto", "Scarpin", "Preto", "Vermelho", "Alto");
		
		//Imprimindo dados separadamente
		System.out.println("Imprimindo produtos separadamente: \nProduto 1: ");
		ten.imprimir();
		System.out.println("\nProduto 2: ");
		sap.imprimir();
		System.out.println("\nProduto 3: ");
		bot.imprimir();
		System.out.println("\nProduto 4: ");
		sal.imprimir();		
		
		//Salvando todos os produtos e suas quantidades vendidas em Lists e ArrayLists
		ArrayList<Integer> qtdVend = new ArrayList<>();
		final List<Produto> prod = new ArrayList<>();
		
		prod.add(ten);
		qtdVend.add(1);
		
		prod.add(sap);
		qtdVend.add(1);
		
		prod.add(bot);
		qtdVend.add(1);
		
		prod.add(sal);
		qtdVend.add(1);
		
		//Salvando dados na inst�ncia da classe Dados		
		dado.addProduto(sal);
		dado.addProduto(bot);
		dado.addProduto(sap);
		dado.addProduto(ten);
		
		System.out.println("-------------------------------------------------------------------");
		
		//Imprimindo todos os produtos
		dado.imprimirProdutos();
		
		System.out.println("===================================================================");
		
		//ESTOQUE: Instanciando e inserindo dados
		est = new Estoque();
		est.cadastrar(10, "Salto", dat, sal);
		est.cadastrar(20, "Bota", dat, bot);
		est.cadastrar(30, "Sapatos", dat, sap);
		est.cadastrar(40, "T�nis", dat, ten);
		
		//Editando dados
		est.editar();
		
		System.out.println("-------------------------------------------------------------------");
		
		//Imprimindo dados
		est.imprimir();
		
		System.out.println("===================================================================");

		//LOJA: Instanciando e inserindo dados
		loj = new Loja();
		loj.cadastrar("Casas Americanas", 34684354, 8, 18, "www.google.com", end2, est, funcio); 
		//Note que no campo de Funcionario estamos inserindo uma ArrayList com todos os funcion�rios cadastrados
		
		//Editando dados
		loj.editar("Magazine Popular", 84343845, 9, 20, "www.google.com.br", end, est, funcio);
		
		/* O m�todo deletarFuncionario(), da classe Loja, ser� chamado automaticamente quando deletarmos um funcion�rio
		 * no objeto dado da classe Dados atrav�s do m�todo deletarFuncionarios()
		 * */
		
		//Imprimindo dados
		loj.imprimir();
		
		System.out.println("\n===================================================================");
		
		
		//PAGAMENTO: Instanciando e inserindo dados
		pag = new Pagamento();
		pag.cadastrar(500.0, "D�bito", dat, 0);
		
		pag2 = new Pagamento();
		pag2.cadastrar(500.0, "Cr�dito", dat, 5);
		
		//Editando dados
		pag2.editar(500.0, "Parcelado", dat, 2);
		
		//Imprimindo pagamentos separadamente
		System.out.print("\nImprimindo pagamentos separadamente: \nPagamento 1: ");
		pag.imprimir();
		System.out.print("\nPagamento 2: ");
		pag2.imprimir();
		
		//Salvando todos os pagamentos em uma ArrayList
		ArrayList<Pagamento> pagmt = new ArrayList<>();
		pagmt.add(pag);
		pagmt.add(pag2);
		
		System.out.println("\n===================================================================");
		
		//VENDA: Instanciando e inserindo dados
		ven = new Venda();
		ven.cadastrar(1064.29, 64.29, dat, fun, cl, prod, pagmt, qtdVend); 
		/* Note que nos espa�os de Produto, Pagamento e Quantidade Vendida estamos inserindo Lists/ArrayLists
		 * com os dados previamente cadastrados e armazenados nestas
		 * */
		
		//Editando dados
		ven.editar(1100.0, 100.0, dat, fun2);
		
		//Imprimindo vendas separadamente
		System.out.println("Imprimindo vendas separadamente: \nVenda 1: ");
		ven.imprimir();
		
		System.out.println("\n-------------------------------------------------------------------");
		
		//Salvando dados na inst�ncia da classe Dados
		dado.addVenda(ven);
		
		//Imprimindo todas as vendas
		dado.imprimirVendas();
		
		System.out.println("===================================================================");
		
		//DADOS: Utilizando m�todos que n�o foram utilizados acima
		/* Destaca-se que acima j� foram utilizados os seguintes m�todos: 
		 * imprimirClientes()
		 * imprimirFuncionarios()
		 * imprimirVendas()
		 * imprimirEnderecos()
		 * imprimirProdutos()
		 * */
		
		//Deletando produtos
		dado.deletarProdutos(est);
		
		System.out.println("-------------------------------------------------------------------");
		
		//Imprimindo todos os produtos restantes
		dado.imprimirProdutos();
		
		System.out.println("-------------------------------------------------------------------");
		
		//Deletando funcion�rios
		dado.deletarFuncionarios(loj);
		
		System.out.println("-------------------------------------------------------------------");
				
		//Imprimindo todos os funcion�rios restantes
		dado.imprimirFuncionarios();
				
		System.out.println("-------------------------------------------------------------------");
		
		//Deletando clientes
		dado.deletarClientes();
		
		System.out.println("-------------------------------------------------------------------");
						
		//Imprimindo todos os funcion�rios restantes
		dado.imprimirClientes();
						
		System.out.println("-------------------------------------------------------------------");
	}

}

