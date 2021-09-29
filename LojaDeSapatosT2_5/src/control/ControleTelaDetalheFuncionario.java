package control;

import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import view.TelaDetalheFuncionario;

public class ControleTelaDetalheFuncionario {
	private TelaDetalheFuncionario detalheFunc;
	private ControleFuncionario funCtrl;
	private ControleEndereco endereco;
	private ControleDados dados = new ControleDados();
	private int indexFunc;
	private int opcEditarSalvar;
	Date data = new Date();
	Date dataContrat = new Date();
	SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

	public ControleTelaDetalheFuncionario(TelaDetalheFuncionario detalheFunc, int opcaoEditarSalvar, int indexFuncio) {
		this.detalheFunc = detalheFunc;
		funCtrl = new ControleFuncionario();
		this.opcEditarSalvar = opcaoEditarSalvar;
		this.indexFunc = indexFuncio;
	}

	public void clicaBtn(ActionEvent e) { // CONTROLANDO AS A��ES DOS BOT�ES DE TelaDetalheFuncion�rio
		JButton clicado = (JButton) e.getSource();

		if (clicado == detalheFunc.getBtnSalvar() && opc == 0) { // SALVAR FUNCIONARIO
			try {
				// Recebendo os valores do endere�o
				endereco.cadastrarEndereco(2, Integer.parseInt(detalheFunc.getValorCep().getText()), // CEP
						detalheFunc.getValorCidade().getText(), // Cidade
						detalheFunc.getValorUf().getSelectedItem().toString(), // UF
						detalheFunc.getValorRua().getText(), // Nome da Rua
						Integer.parseInt(detalheFunc.getValorNum().getText()), // N�mero
						Integer.parseInt(detalheFunc.getValorQd().getText()), // Quadra
						detalheFunc.getValorBairro().getText(), // Bairro
						Integer.parseInt(detalheFunc.getValorApart().getText()), // N�mero do Apartamento
						detalheFunc.getValorComp().getText()); // Complemento

				// Formatando a data inserida
				data = formato.parse(detalheFunc.getValorData().getText());
				dataContrat = formato.parse(detalheFunc.getValorDataCon().getText());

				// Cadastrando o Funcionario
				funCtrl.cadastrarFuncionario(endereco.getEnder(), // Endere�o
						detalheFunc.getValorNome().getText(), // Nome
						data, // Data de nascimento
						detalheFunc.getValorCpf().getText(), // CPF
						detalheFunc.getValorFone().getText(), // Telefone
						dataContrat, // Data de Contrata��o
						detalheFunc.getValorTurno().getSelectedItem().toString(), // Turno
						Integer.parseInt(detalheFunc.getValorEntrada().getSelectedItem().toString()), // Hora de Entrada
						Integer.parseInt(detalheFunc.getValorSaida().getSelectedItem().toString())); // Hora de Sa�da

				funCtrl.setNome(detalheFunc.getValorNome().getText());

				JOptionPane.showMessageDialog(null, "Funcion�rio cadastrado com sucesso!", null,
						JOptionPane.INFORMATION_MESSAGE);
				detalheFunc.dispose();

			} catch (NullPointerException exc1) {
				mensagemErroCadastro();
			} catch (NumberFormatException exc2) {
				mensagemErroCadastro();
			} catch (ParseException excData) {
				excData.printStackTrace();
				mensagemErroCadastro();
			}

		} else if (clicado == detalheFunc.getBtnSalvar() && opc == 1) { // SALVAR FUNCIONARIO EDITADO
			try {
				// Recebendo os valores do endere�o
				endereco.editarEndereco(2, dados, indexFunc, // Dados para preencher o endere�o
						Integer.parseInt(detalheFunc.getValorCep().getText()), // CEP
						detalheFunc.getValorCidade().getText(), // Cidade
						detalheFunc.getValorUf().getSelectedItem().toString(), // UF
						detalheFunc.getValorRua().getText(), // Nome da Rua
						Integer.parseInt(detalheFunc.getValorNum().getText()), // N�mero
						Integer.parseInt(detalheFunc.getValorQd().getText()), // Quadra
						detalheFunc.getValorBairro().getText(), // Bairro
						Integer.parseInt(detalheFunc.getValorApart().getText()), // N�mero do Apartamento
						detalheFunc.getValorComp().getText()); // Complemento

				// Formatando a data inserida
				data = formato.parse(detalheFunc.getValorData().getText());
				dataContrat = formato.parse(detalheFunc.getValorDataCon().getText());

				// Editando o funcion�rio
				funCtrl.editarFuncionario(dados, this.getIndexFunc(), // Index do cliente a ser editado
						endereco.getEnder(), // Endere�o
						detalheFunc.getValorNome().getText(), // Nome
						data, // Data de nascimento
						detalheFunc.getValorCpf().getText(), // CPF
						detalheFunc.getValorFone().getText(), // Telefone
						dataContrat, // Data de Contrata��o
						detalheFunc.getValorTurno().getSelectedItem().toString(), // Turno
						Integer.parseInt(detalheFunc.getValorEntrada().getSelectedItem().toString()), // Hora de Entrada
						Integer.parseInt(detalheFunc.getValorSaida().getSelectedItem().toString())); // Hora de Sa�da

				funCtrl.setNomeAt(detalheFunc.getValorNome().getText(), this.getIndexFunc());

				JOptionPane.showMessageDialog(null, "Funcion�rio editado com sucesso!", null,
						JOptionPane.INFORMATION_MESSAGE);
				detalheFunc.dispose();

			} catch (NullPointerException exc1) {
				mensagemErroCadastro();
			} catch (NumberFormatException exc2) {
				mensagemErroCadastro();
			} catch (ParseException excData) {
				excData.printStackTrace();
				mensagemErroCadastro();
			}

		} else if (clicado == detalheFunc.getBtnDeletar()) { // DELETAR FUNCION�RIO
			try {
				if (detalheFunc.getValorNome().getText().equals(dados.getFuncionario().get(indexFunc).getNome())
						&& detalheFunc.getValorCpf().getText().equals(dados.getFuncionario().get(indexFunc).getCpf())) {
					funCtrl.deletarFuncionario(dados, indexFunc);
					JOptionPane.showMessageDialog(null, "Funcion�rio deletado com sucesso!", null,
							JOptionPane.INFORMATION_MESSAGE);
					detalheFunc.dispose();
				} else {
					JOptionPane.showMessageDialog(null, "ERRO!\nSelecione um funcion�rio na lista para deletar!", null,
							JOptionPane.ERROR_MESSAGE);
				}
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Erro!\nN�o h� funcion�rio a ser deletado!", null,
						JOptionPane.ERROR_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(null, "ERRO!", null, JOptionPane.ERROR_MESSAGE);
		}
	}

	public void imprimirDetalhes(TelaDetalheFuncionario tela, int index) {

		// Imprimindo dados do funcion�rio

		// Imprimindo dados do endere�o do funcion�rio

	}

	public void mensagemErroCadastro() {
		JOptionPane.showMessageDialog(null,
				"Erro!\nVerifique se todos os campos est�o preenchidos."
						+ "\nVerifique se os dados em formato num�rico s�o n�meros."
						+ "\nVerifique se as datas foram inseridas corretamente.",
				null, JOptionPane.ERROR_MESSAGE);
	}

}
