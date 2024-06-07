package calculadora;

import java.awt.EventQueue;

import gui.AlunoWindow;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Calculadora");
		
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculadoraWindow calc= new CalculadoraWindow();
					calc.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
