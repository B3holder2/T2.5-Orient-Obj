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
	private ControleCliente cliCtrl = new ControleCliente();
	private ControleEndereco endereco = new ControleEndereco();
	Date data = new Date();
	SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

	public ControleTelaDetalheCliente(TelaDetalheCliente detalheCliente) {
		this.detalheCliente = detalheCliente;
	}

	public void clicaBtn(ActionEvent e) {
		JButton clicado = (JButton) e.getSource();

		if (clicado == detalheCliente.getBtnSalvar()) {
			try {
				// Recebendo os valores do endere�o
				endereco.cadastrarEndereco(Integer.parseInt(detalheCliente.getValorCep().getText()), // CEP
						detalheCliente.getValorCidade().getText(), // Cidade
						detalheCliente.getValorUf().getSelectedItem().toString(), // UF
						detalheCliente.getValorRua().getText(), // Nome da Rua
						Integer.parseInt(detalheCliente.getValorNum().getText()), // N�mero
						Integer.parseInt(detalheCliente.getValorQd().getText()), // Quadra
						detalheCliente.getValorBairro().getText(), // Bairro
						Integer.parseInt(detalheCliente.getValorApart().getText()), // N�mero do Apartamento
						detalheCliente.getValorComp().getText()); // Complemento

				// Formatando a data inserida
				try {
					data = formato.parse(detalheCliente.getValorData().getText());
				} catch (ParseException excData) {
					excData.printStackTrace();
				}

				// Cadastrando o cliente
				cliCtrl.cadastrarCliente(endereco.getEnder(), // Endere�o
						detalheCliente.getValorNome().getText(), // Nome
						detalheCliente.getValorGenero().getSelectedItem().toString().charAt(0), // G�nero
						data, detalheCliente.getValorCpf().getText(), detalheCliente.getValorFone().getText(),
						detalheCliente.getValorEmail().getText());

				JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!", null,
						JOptionPane.INFORMATION_MESSAGE);

			} catch (NullPointerException exc1) {
				mensagemErroCadastro();
			} catch (NumberFormatException exc2) {
				mensagemErroCadastro();
			}

		}
		if (clicado == detalheCliente.getBtnDeletar()) {
			JOptionPane.showMessageDialog(null, "SISTEMA EM CONSTRU��O!", null, JOptionPane.INFORMATION_MESSAGE);
		} else {
			// JOptionPane.showMessageDialog(null, "ERRO!", null,
			// JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public void mensagemErroCadastro() {
		JOptionPane.showMessageDialog(null,
				"Erro!\nVerifique se todos os campos est�o preenchidos."
						+ "\nVerifique se os dados em formato num�rico s�o n�meros."
						+ "\nVerifique se a data foi inserida corretamente.",
				null, JOptionPane.ERROR_MESSAGE);
	}

}