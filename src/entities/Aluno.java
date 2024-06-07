package entities;

import java.util.Date;

public class Aluno {

	public int registroAcademico;
	private String nome;
	private String sexo;
	private Curso curso;
	private String dataIngresso;
	private int periodo;
	private double coeficiente;
	
	public Aluno(int registroAcademico, String nome, String sexo, Curso curso, String dataIngresso, int periodo,double coeficiente) {
		super();
		this.registroAcademico = registroAcademico;
		this.nome = nome;
		this.sexo = sexo;
		this.curso = curso;
		this.dataIngresso = dataIngresso;
		this.periodo = periodo;
		this.coeficiente = coeficiente;
	}
	public Aluno() {
	
	}
	public int getRegistroAcademico() {
		return registroAcademico;
	}

	public void setRegistroAcademico(int registroAcademico) {
		this.registroAcademico = registroAcademico;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}



	public int getPeriodo() {
		return periodo;
	}

	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}

	public double getCoeficiente() {
		return coeficiente;
	}

	public void setCoeficiente(double coeficiente) {
		this.coeficiente = coeficiente;
	} 
	
	
	
}
