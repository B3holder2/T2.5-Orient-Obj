package control;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;

import view.TelaCliente;
import view.TelaDetalheCliente;

public class ControleTelaCliente {
	private TelaCliente cliente;

	public ControleTelaCliente(TelaCliente cliente) {
		this.cliente = cliente;
	}

	public void clicaBtn(ActionEvent e) {
		JButton clicado = (JButton) e.getSource();

		if (clicado == cliente.getBtnCadastrar()) {
			new TelaDetalheCliente();
		} else if (clicado == cliente.getBtnOrdenar()) {
			JOptionPane.showMessageDialog(null, "SISTEMA EM CONSTRU��O!", null, JOptionPane.INFORMATION_MESSAGE);
		} else if (clicado == cliente.getBtnAtualizar()) {
			JOptionPane.showMessageDialog(null, "SISTEMA EM CONSTRU��O!", null, JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "ERRO!", null, JOptionPane.INFORMATION_MESSAGE);
		}

	}

	public void clicaLista(ListSelectionEvent e) {
		Object selecionado = e.getSource();

		if (e.getValueIsAdjusting()) {
			JOptionPane.showMessageDialog(null, cliente.getListaPessoas().getSelectedIndex() + " � o index", null,
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

}
