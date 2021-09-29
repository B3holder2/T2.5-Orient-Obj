package view;

import java.awt.event.ActionEvent;

import javax.swing.event.ListSelectionEvent;

import control.ControleTelaFuncionario;

public class TelaFuncionario extends Template {
	private ControleTelaFuncionario controlTela;

	public TelaFuncionario() {
		super("Funcion�rios");
		this.controlTela = new ControleTelaFuncionario(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) { // Bot�es controlados pela classe ControleTelaFuncionario
		this.controlTela.clicaBtn(e);

	}

	@Override
	public void valueChanged(ListSelectionEvent e) { // Lista controlada pela classe ControleTelaFuncionario
		this.controlTela.clicaLista(e);
	}

}
