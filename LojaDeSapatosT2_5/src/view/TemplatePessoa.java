package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;

import control.ControleDados;

public abstract class TemplatePessoa extends JFrame implements ActionListener, ListSelectionListener {
	private JLabel texto;
	private JButton btnCadastrar = new JButton("Cadastrar");
	private JButton btnOrdenar = new JButton("Ordenar");
	private JButton btnAtualizar = new JButton("Atualizar");
	private JList<String> listaPessoas = new JList<>();
	private ControleDados dados = new ControleDados();

	public TemplatePessoa(String texto, ControleDados d) {
		super(texto); // JFrame com nome
		this.setSize(560, 520);
		this.setLayout(null);
		this.setResizable(false);

		// Estilo do T�tulo
		this.texto = new JLabel(texto, JLabel.CENTER);
		this.texto.setFont(new Font("Montserrat", Font.BOLD, 44));
		this.texto.setForeground(new Color(29, 53, 87));

		// Cor do Plano de Fundo
		getContentPane().setBackground(new Color(70, 123, 157));

		// Fontes dos Bot�es
		Font f = new Font("Montserrat", Font.PLAIN, 15);
		btnCadastrar.setFont(f);
		btnOrdenar.setFont(f);
		btnAtualizar.setFont(f);

		// Localiza��o e Tamanho dos componentes da tela
		this.texto.setBounds(120, 20, 300, 50);
		btnCadastrar.setBounds(32, 420, 146, 50);
		btnOrdenar.setBounds(198, 420, 146, 50);
		btnAtualizar.setBounds(368, 420, 145, 50);

		// Configurando exclusivamente a lista de Funcion�rios/Clientes
		preencherLista(texto, d);
		this.listaPessoas.setBackground(Color.white);
		this.listaPessoas.setBounds(32, 95, 480, 300);
		this.listaPessoas.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		this.listaPessoas.setVisibleRowCount(10);
		this.listaPessoas.addListSelectionListener(this);

		// Adicionando componentes a tela
		this.add(this.texto);
		this.add(this.listaPessoas);
		this.add(btnCadastrar);
		this.add(btnOrdenar);
		this.add(btnAtualizar);

		// Adicionando o ActionListener
		getBtnCadastrar().addActionListener(this);
		getBtnOrdenar().addActionListener(this);
		getBtnAtualizar().addActionListener(this);

		this.setVisible(true);

	}

	public void preencherLista(String texto, ControleDados d) {
		String[] listaNomes;
		this.dados = d;

		if (texto.equals("Clientes")) {
			listaNomes = new String[dados.getCliente().size()];

			for (int i = 0; i < dados.getCliente().size(); i++) {
				listaNomes[i] = dados.getCliente().get(i).getNome();
			}

			listaPessoas.setListData(listaNomes);
			listaPessoas.updateUI();

		} else if (texto.equals("Funcion�rios")) {
			listaNomes = new String[dados.getFuncionario().size()];

			for (int i = 0; i < dados.getFuncionario().size(); i++) {
				listaNomes[i] = dados.getFuncionario().get(i).getNome();
			}

			listaPessoas.setListData(listaNomes);
			listaPessoas.updateUI();
		}

	}

	public JButton getBtnCadastrar() {
		return btnCadastrar;
	}

	public JButton getBtnOrdenar() {
		return btnOrdenar;
	}

	public JButton getBtnAtualizar() {
		return btnAtualizar;
	}

	public JList<String> getListaPessoas() {
		return listaPessoas;
	}

	public JLabel getTexto() {
		return texto;
	}

}
