package calculadora;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gui.AlunoWindow;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class CalculadoraWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField numeroSelecionados;
	private JButton botao2;
	private JButton botao3;
	private JButton botao1_1;
	private JButton botao1_2;
	private JButton botao1_3;
	private JButton botao1_4;
	private JButton botao1_5;
	private JButton botao1_6;
	private JButton botao1_7;
	private JButton botao1_8;
	private JButton botao1_9;
	private List<String> numero = new ArrayList<String>();
	private JButton realizarSoma;
	private int op;
	private int numeroPrimeiro;
	private int numeroSubtrair;
	


	
	public CalculadoraWindow() {
		
		this.initComponents();
		
	}
	
	public void somar() {
		this.numeroPrimeiro = Integer.parseInt(numeroSelecionados.getText());
		numeroSelecionados.setText("");
		numero.clear();
	}
	public void subtrair() {
		this.numeroPrimeiro = Integer.parseInt(numeroSelecionados.getText());
		numeroSelecionados.setText("");
		numero.clear();
	}
	public String resultado() {
		String result = "10";
		if(numeroSelecionados.getText()!="") { switch(op) {
		case 1: 
			result = String.valueOf(numeroPrimeiro+Integer.parseInt(numeroSelecionados.getText()));
			break;
		case 2:
			result = String.valueOf(numeroPrimeiro-Integer.parseInt(numeroSelecionados.getText()));
		break;
		}
	}
		
		
		numeroSelecionados.setText(result);
		return result;
	}
	
	private String mostrarNumero() {
		
		int tamanho = 1; 
		int numeroCompleto =0 ;
		for(int i = 1 ; i< numero.size(); i++) {
			tamanho = tamanho *10;
		}
	for(String str:numero) {
		
		numeroCompleto = numeroCompleto + (Integer.parseInt(str)*tamanho);
		tamanho = tamanho/10;
	}
		return String.valueOf(numeroCompleto) ;
	}
	
	public void initComponents() {
		setTitle("Calcuadora");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 380, 510);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		numeroSelecionados = new JTextField();
		numeroSelecionados.setText("");
		numeroSelecionados.setBounds(0, 41, 364, 44);
		contentPane.add(numeroSelecionados);
		numeroSelecionados.setColumns(10);
		
		JButton botao1 = new JButton("1");
		botao1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numero.add("1");
				numeroSelecionados.setText(mostrarNumero());
			}
		});
		botao1.setBounds(10, 142, 89, 66);
		contentPane.add(botao1);
		
		botao2 = new JButton("2");
		botao2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numero.add("2");
				numeroSelecionados.setText(mostrarNumero());
			}
		});
		botao2.setBounds(140, 142, 89, 66);
		contentPane.add(botao2);
		
		botao3 = new JButton("3");
		botao3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numero.add("3");
				numeroSelecionados.setText(mostrarNumero());
			}
		});
		botao3.setBounds(265, 142, 89, 66);
		contentPane.add(botao3);
		
		botao1_1 = new JButton("4");
		botao1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numero.add("4");
				numeroSelecionados.setText(mostrarNumero());
			}
		});
		botao1_1.setBounds(10, 219, 89, 66);
		contentPane.add(botao1_1);
		
		botao1_2 = new JButton("5");
		botao1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numero.add("5");
				numeroSelecionados.setText(mostrarNumero());
			}
		});
		botao1_2.setBounds(140, 219, 89, 66);
		contentPane.add(botao1_2);
		
		botao1_3 = new JButton("6");
		botao1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numero.add("6");
				numeroSelecionados.setText(mostrarNumero());
			}
		});
		botao1_3.setBounds(265, 219, 89, 66);
		contentPane.add(botao1_3);
		
		botao1_4 = new JButton("7");
		botao1_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numero.add("7");
				numeroSelecionados.setText(mostrarNumero());
			}
		});
		botao1_4.setBounds(140, 309, 89, 66);
		contentPane.add(botao1_4);
		
		botao1_5 = new JButton("8");
		botao1_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numero.add("8");
				numeroSelecionados.setText(mostrarNumero());
			}
		});
		botao1_5.setBounds(10, 309, 89, 66);
		contentPane.add(botao1_5);
		
		botao1_6 = new JButton("9");
		botao1_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numero.add("9");
				numeroSelecionados.setText(mostrarNumero());
			}
		});
		botao1_6.setBounds(265, 309, 89, 66);
		contentPane.add(botao1_6);
		
		botao1_7 = new JButton("0");
		botao1_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numero.add("0");
				numeroSelecionados.setText(mostrarNumero());
			}
		});
		botao1_7.setBounds(140, 394, 89, 66);
		contentPane.add(botao1_7);
		botao1_8 = new JButton("+");
		botao1_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				somar();
				op = 1; 
			}
		});
		//botão subtração
		botao1_8.setBounds(265, 394, 89, 66);
		contentPane.add(botao1_8);
		botao1_9 = new JButton("-");
		botao1_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				subtrair();
				op = 2; 
			}
		});		
		botao1_9.setBounds(10, 394, 89, 66);
		contentPane.add(botao1_9);
		
		realizarSoma = new JButton("=");
		realizarSoma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resultado();
			}
		});
		realizarSoma.setBounds(10, 108, 89, 23);
		contentPane.add(realizarSoma);
	}


}
