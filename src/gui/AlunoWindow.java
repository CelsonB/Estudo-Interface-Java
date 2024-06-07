package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import entities.Aluno;
import entities.Curso;
import service.AlunoService;
import service.CursoService;

import javax.swing.JScrollPane;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;

public class AlunoWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField registroAcademico;
	private JTextField nome;
	private JTextField coeficiente;
	private JTable table = new JTable();
	
	private ButtonGroup btnGroupSexo;
	private JRadioButton sexoNaoInformar;
	private JRadioButton sexoMasculino;
	private JRadioButton sexoFeminino;
	private JFormattedTextField dataIngresso;
	

	/**
	 * Launch the application.
	 */
	private MaskFormatter mascaraData;
	private CursoService cursoService;
	private AlunoService alunoService;
	public JComboBox cbCurso = new JComboBox();
	
	private final Action action = new SwingAction();
	private JSpinner periodo;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlunoWindow frame = new AlunoWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public AlunoWindow() {
		try {
			this.mascaraData = new MaskFormatter("##/##/####");
		}catch(Exception ex ) {
			System.out.println(ex);
		}
		this.initCompenents();
		this.cursoService = new CursoService();
		this.alunoService = new AlunoService();
	
		
		this.buscarCursos();
		this.buscarAlunos();

	}
	public void limparComponentes() {
		this.registroAcademico.setText("");
		this.nome.setText("");
		this.sexoMasculino.setSelected(true);
		this.cbCurso.setSelectedIndex(0);
		this.dataIngresso.setText("");
		this.periodo.setValue(1);
		this.coeficiente.setText("");
	}
	public void sair() {
		System.exit(0);
	}
//	public void abrirJanelaSobre() {
//		SobreWindow janelaSobre = new SobreWindow(this);
//		janelaSobre.setVisible(true);
//		this.setVisible(false);
//	}
	
	
	public void initCompenents() {
		setTitle("aluno");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,650,709);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 458, 558);
		

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu Arquivo = new JMenu("Arquivo");
		menuBar.add(Arquivo);
		
		JMenuItem SairMenu = new JMenuItem("Sair");
		SairMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sair();
			}
		});
		Arquivo.add(SairMenu);
		
		JMenu AjudaMenu = new JMenu("Ajuda");
		menuBar.add(AjudaMenu);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Sobre");
		AjudaMenu.add(mntmNewMenuItem_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel ad = new JLabel("Registro Academico");
		ad.setBounds(10, 22, 101, 14);
		contentPane.add(ad);
		
		registroAcademico = new JTextField();
		registroAcademico.setHorizontalAlignment(SwingConstants.TRAILING);
		registroAcademico.setBounds(131, 19, 86, 20);
		contentPane.add(registroAcademico);
		registroAcademico.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(10, 61, 46, 14);
		contentPane.add(lblNewLabel);
		
		nome = new JTextField();
		nome.setBounds(53, 58, 46, 20);
		contentPane.add(nome);
		nome.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Data de ingresso");
		lblNewLabel_1.setBounds(10, 94, 94, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Curso");
		lblNewLabel_2.setBounds(10, 130, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Coeficiente");
		lblNewLabel_3.setBounds(10, 166, 59, 14);
		contentPane.add(lblNewLabel_3);
		
		coeficiente = new JTextField();
		coeficiente.setBounds(77, 163, 86, 20);
		contentPane.add(coeficiente);
		coeficiente.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Periodo");
		lblNewLabel_4.setBounds(10, 202, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		dataIngresso = new JFormattedTextField(mascaraData);
		dataIngresso.setBounds(114, 91, 94, 20);
		contentPane.add(dataIngresso);
		
		
		cbCurso.setBounds(53, 126, 110, 22);
		contentPane.add(cbCurso);
		
		periodo = new JSpinner();
		periodo.setBounds(54, 199, 30, 20);
		contentPane.add(periodo);
		
		JPanel informarSexo = new JPanel();
		informarSexo.setBounds(284, 114, 111, 99);
		contentPane.add(informarSexo);
		
		 sexoNaoInformar = new JRadioButton("N\u00E3o informar");
		sexoNaoInformar.setHorizontalAlignment(SwingConstants.LEFT);
		informarSexo.add(sexoNaoInformar);
		
		 sexoMasculino = new JRadioButton("Masculino");
		sexoMasculino.setHorizontalAlignment(SwingConstants.LEFT);
		informarSexo.add(sexoMasculino);
		
		 sexoFeminino = new JRadioButton("Feminino");
		sexoFeminino.setHorizontalAlignment(SwingConstants.LEFT);
		informarSexo.add(sexoFeminino);
		
		 btnGroupSexo = new ButtonGroup();
		btnGroupSexo.add(sexoNaoInformar);
		btnGroupSexo.add(sexoMasculino);
		btnGroupSexo.add(sexoFeminino);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 227, 427, 2);
		contentPane.add(separator);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				cadastrarAluno();
			}
		});
		btnNewButton.setBounds(131, 240, 89, 23);
		contentPane.add(btnNewButton);
//		
		JButton btnNewButton_1 = new JButton("Limpar Dados");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparComponentes();
			}
		});
		btnNewButton_1.setBounds(10, 240, 111, 23);
		contentPane.add(btnNewButton_1);
		
		JPanel panel = new JPanel();
	
		panel.setBorder(new TitledBorder(null, "JPanel title", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(4, 274, 434, 218);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 16, 422, 211);
		panel.add(scrollPane);
		
	
		scrollPane.setViewportView(table);
		
		JButton atualizarAlunos = new JButton("Atualizar ");
		atualizarAlunos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarAlunos();
			}
		});
		atualizarAlunos.setBounds(343, 240, 89, 23);
		contentPane.add(atualizarAlunos);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Ra", "Nome", "Periodo", "Sexo", "Curso", "Data de inscri\u00E7\u00E3o", "Coeficiente"
			}
		));
	}
	

	public void buscarCursos() {
		List<Curso> cursos = this.cursoService.buscarTodos();
		
		for(Curso cur: cursos) {
			this.cbCurso.addItem(cur);
		}
	}
	
	public void buscarAlunos() {
		DefaultTableModel modelo = (DefaultTableModel) this.table.getModel();
		modelo.fireTableDataChanged();
		modelo.setRowCount(0);
		List<Aluno> alunos = this.alunoService.buscarTodos();
		
		for(Aluno aln : alunos) {
			modelo.addRow(new Object[] {
					aln.getCoeficiente(),
					aln.getCurso(),
					aln.getNome(),
					aln.getPeriodo(),
					aln.getRegistroAcademico(),
					aln.getSexo()
			});
		}
		
		
	}
	

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	public void cadastrarAluno() {
		try {
			Aluno aluno = new Aluno();
			aluno.setCoeficiente(Integer.parseInt(this.registroAcademico.getText() ) );
			aluno.setNome(nome.getText());
			//aluno.setCurso(this.cbCurso.getSelectedItem());
			aluno.setPeriodo(Integer.parseInt(periodo.getValue().toString()));
			aluno.setRegistroAcademico(Integer.parseInt(registroAcademico.getText()));
			aluno.setSexo(selecionarSexo());
			
			this.alunoService.cadastrar(aluno);
			
		}catch(Exception ex ) {
			System.out.println(ex);
		}
	}
	private String selecionarSexo() {
		if(sexoNaoInformar.isSelected()) {
			return "não informar";
		}else
		if(sexoMasculino.isSelected()) {
			return "Masculino";
		}else
		if(sexoFeminino.isSelected()) {
			return "Feminino";
		}
		return "não informado";
	}
}
