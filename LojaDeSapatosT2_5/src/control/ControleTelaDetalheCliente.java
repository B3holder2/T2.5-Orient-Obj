package control;

import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import view.TelaDetalheCliente;

public class ControleTelaDetalheCliente {
	private TelaDetalheCliente detalheCliente;
	private ControleCliente cliCtrl;
	private ControleEndereco endereco;
	private ControleDados dados = new ControleDados();
	private int indexCliente, opc;
	Date data = new Date();
	SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

	public ControleTelaDetalheCliente(TelaDetalheCliente detalheCliente, ControleDados d, int editarSalvar, int idx) {
		this.detalheCliente = detalheCliente;
		this.dados = d;
		cliCtrl = new ControleCliente(dados);
		endereco = new ControleEndereco(dados);
		opc = editarSalvar;
		indexCliente = idx;
	}

	public void imprimirEditarDetalhe(TelaDetalheCliente tela, ControleDados d, int index) {

		// Definindo o index do g�nero
		int iGen = 0;
		if (d.getCliente().get(index).getGenero() == 'M') {
			iGen = 0;
		} else if (d.getCliente().get(index).getGenero() == 'F') {
			iGen = 1;
		} else if (d.getCliente().get(index).getGenero() == 'O') {
			iGen = 2;
		}

		// Imprimindo dados do cliente
		tela.getValorNome().setText(d.getCliente().get(index).getNome());
		tela.getValorGenero().setSelectedIndex(iGen);
		tela.getValorData().setText(formato.format(d.getCliente().get(index).getDataNasc()));
		tela.getValorCpf().setText(d.getCliente().get(index).getCpf());
		tela.getValorFone().setText(d.getCliente().get(index).getTelefone());
		tela.getValorEmail().setText(d.getCliente().get(index).getEmail());

		// Imprimindo dados do endere�o do cliente
		tela.getValorCep().setText(String.valueOf(d.getEnderecoCliente().get(index).getCep()));
		tela.getValorCidade().setText(d.getEnderecoCliente().get(index).getCidade());
		tela.getValorUf().setSelectedItem(d.getEnderecoCliente().get(index).getUf());
		tela.getValorRua().setText(d.getEnderecoCliente().get(index).getNomeRua());
		tela.getValorNum().setText(String.valueOf(d.getEnderecoCliente().get(index).getNumero()));
		tela.getValorQd().setText(String.valueOf(d.getEnderecoCliente().get(index).getQuadra()));
		tela.getValorBairro().setText(d.getEnderecoCliente().get(index).getBairro());
		tela.getValorApart().setText(String.valueOf(d.getEnderecoCliente().get(index).getNumApart()));
		tela.getValorComp().setText(d.getEnderecoCliente().get(index).getComplemento());

	}

	public void clicaBtn(ActionEvent e) { // CONTROLANDO AS A��ES DOS BOT�ES DE TelaDetalheCliente
		JButton clicado = (JButton) e.getSource();

		if (clicado == detalheCliente.getBtnSalvar() && opc == 0) { // SALVAR CLIENTE
			try {
				// Recebendo os valores do endere�o
				endereco.cadastrarEndereco(1, Integer.parseInt(detalheCliente.getValorCep().getText()), // CEP
						detalheCliente.getValorCidade().getText(), // Cidade
						detalheCliente.getValorUf().getSelectedItem().toString(), // UF
						detalheCliente.getValorRua().getText(), // Nome da Rua
						Integer.parseInt(detalheCliente.getValorNum().getText()), // N�mero
						Integer.parseInt(detalheCliente.getValorQd().getText()), // Quadra
						detalheCliente.getValorBairro().getText(), // Bairro
						Integer.parseInt(detalheCliente.getValorApart().getText()), // N�mero do Apartamento
						detalheCliente.getValorComp().getText()); // Complemento

				// Formatando a data inserida
				data = formato.parse(detalheCliente.getValorData().getText());

				// Cadastrando o cliente
				cliCtrl.cadastrarCliente(endereco.getEnder(), // Endere�o
						detalheCliente.getValorNome().getText(), // Nome
						detalheCliente.getValorGenero().getSelectedItem().toString().charAt(0), // G�nero
						data, // Data de nascimento
						detalheCliente.getValorCpf().getText(), // CPF
						detalheCliente.getValorFone().getText(), // Telefone
						detalheCliente.getValorEmail().getText()); // Email

				cliCtrl.setNome(detalheCliente.getValorNome().getText());

				JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!", null,
						JOptionPane.INFORMATION_MESSAGE);
				detalheCliente.dispose();

			} catch (NullPointerException exc1) {
				mensagemErroCadastro();
			} catch (NumberFormatException exc2) {
				mensagemErroCadastro();
			} catch (ParseException excData) {
				excData.printStackTrace();
				mensagemErroCadastro();
			}

		} else if (clicado == detalheCliente.getBtnSalvar() && opc == 1) { // SALVAR CLIENTE EDITADO
			try {
				// Recebendo os valores do endere�o
				endereco.editarEndereco(1, dados, indexCliente, // Dados para preencher o endere�o
						Integer.parseInt(detalheCliente.getValorCep().getText()), // CEP
						detalheCliente.getValorCidade().getText(), // Cidade
						detalheCliente.getValorUf().getSelectedItem().toString(), // UF
						detalheCliente.getValorRua().getText(), // Nome da Rua
						Integer.parseInt(detalheCliente.getValorNum().getText()), // N�mero
						Integer.parseInt(detalheCliente.getValorQd().getText()), // Quadra
						detalheCliente.getValorBairro().getText(), // Bairro
						Integer.parseInt(detalheCliente.getValorApart().getText()), // N�mero do Apartamento
						detalheCliente.getValorComp().getText()); // Complemento

				// Formatando a data inserida
				data = formato.parse(detalheCliente.getValorData().getText());

				// Editando o cliente
				cliCtrl.editarCliente(dados, this.getIndexCliente(), // Index do cliente a ser editado
						endereco.getEnder(), // Endere�o
						detalheCliente.getValorNome().getText(), // Nome
						detalheCliente.getValorGenero().getSelectedItem().toString().charAt(0), // G�nero
						data, // Data de nascimento
						detalheCliente.getValorCpf().getText(), // CPF
						detalheCliente.getValorFone().getText(), // Telefone
						detalheCliente.getValorEmail().getText()); // Email

				cliCtrl.setNomeAt(detalheCliente.getValorNome().getText(), this.getIndexCliente());

				JOptionPane.showMessageDialog(null, "Cliente editado com sucesso!", null,
						JOptionPane.INFORMATION_MESSAGE);
				detalheCliente.dispose();

			} catch (NullPointerException exc1) {
				mensagemErroCadastro();
			} catch (NumberFormatException exc2) {
				mensagemErroCadastro();
			} catch (ParseException excData) {
				excData.printStackTrace();
				mensagemErroCadastro();
			}

		} else if (clicado == detalheCliente.getBtnDeletar()) { // DELETAR CLIENTE
			try {
				if (detalheCliente.getValorNome().getText().equals(dados.getCliente().get(indexCliente).getNome())
						&& detalheCliente.getValorCpf().getText()
								.equals(dados.getCliente().get(indexCliente).getCpf())) {
					cliCtrl.deletarCliente(dados, indexCliente);
					JOptionPane.showMessageDialog(null, "Cliente deletado com sucesso!", null,
							JOptionPane.INFORMATION_MESSAGE);
					detalheCliente.dispose();
				} else {
					JOptionPane.showMessageDialog(null, "ERRO!\nSelecione um cliente na lista para deletar!", null,
							JOptionPane.ERROR_MESSAGE);
				}
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Erro!\nN�o h� cliente a ser deletado!", null,
						JOptionPane.ERROR_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(null, "ERRO!", null, JOptionPane.ERROR_MESSAGE);
		}
	}

	public void mensagemErroCadastro() {
		JOptionPane.showMessageDialog(null,
				"Erro!\nVerifique se todos os campos est�o preenchidos."
						+ "\nVerifique se os dados em formato num�rico s�o n�meros."
						+ "\nVerifique se a data foi inserida corretamente.",
				null, JOptionPane.ERROR_MESSAGE);
	}

	public int getIndexCliente() {
		return indexCliente;
	}

	public void setIndexCliente(int indexCliente) {
		this.indexCliente = indexCliente;
	}

	public int getOpc() {
		return opc;
	}

	public void setOpc(int opc) {
		this.opc = opc;
	}

}
