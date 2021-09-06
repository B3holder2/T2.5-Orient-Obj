package negocio;
import java.util.*;
import java.text.*;

public class Teste {
	static Cliente cl;
	static Cliente cl2;
	static Endereco end;
	static Endereco end2;
	static Funcionario fun;

	public static void main(String[] args){
		
		GregorianCalendar d = new GregorianCalendar();
		Date dat = d.getTime();
		
		end = new Endereco();
		end.cadastrar(70000000, "Ciudad", "PR", "Rua JK", 15, 04, "Centro", 00, "Casa Amarela");
		
		end2 = new Endereco();
		end2.cadastrar(73333000, "Cidade", "RS", "Rua GV", 16, 05, "Centro", 16, "Casa Verde");
		
		
		cl = new Cliente();
		cl.cadastrar(end, "Felipe", 'M', dat, "111.111.111-11", "(61) 91111-1111", "felipe@gmail.com");
		cl.ler();
		
		cl2 = new Cliente();
		cl2.cadastrar(end2, "Joana", 'F', dat, "222.222.222-22", "(61) 92222-2222", "joana@gmail.com");
		cl2.ler();
		
		fun = new Funcionario();
		fun.cadastrar("Jo�o", dat, "333.333.333-33", "(61) 93333-3333", dat, "Integral", 8, 17, end2);
		fun.ler();
	}

}

