package view;

import java.awt.event.ActionEvent;

import javax.swing.event.ListSelectionEvent;

import control.ControleDados;

public class TelaFuncionario extends TemplatePessoa {
	private ControleDados dados = new ControleDados();

	public TelaFuncionario(ControleDados d) {
		super("Funcion�rios");
		this.dados = d;
	}

	@Override
	public void actionPerformed(ActionEvent e) { // Bot�es controlados pela classe ControleTelaFuncionario
		// TODO Auto-generated method stub

	}

	@Override
	public void valueChanged(ListSelectionEvent e) { // Lista controlada pela classe ControleTelaFuncionario

		// TODO Auto-generated method stub

	}

}
