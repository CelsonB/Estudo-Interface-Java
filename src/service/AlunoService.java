package service;
import java.util.ArrayList;
import java.util.List;

import entities.*;


	
public class AlunoService {
	private List<Aluno> alunos;
	
	public AlunoService() {
		
		alunos = new ArrayList<Aluno>();
		
		alunos.add(new Aluno(11111,"João da Silva","Masculino", new Curso(2,"ADS", "Noturno", 6), "10/02/2020",4,0.54));
		alunos.add(new Aluno(22222,"Maria oliveira","Feminino", new Curso(4,"Biologia", "Integral", 8), "01/08/20222",1,0.0));
		alunos.add(new Aluno(22222,"Ricardo Oliverira","Masculino", new Curso(1,"BCC", "Integral", 10), "01/08/2020",6,0.80));
		
	}
	public List<Aluno> buscarTodos(){
		return this.alunos;
	}
	
	public void cadastrar(Aluno aluno) {
		this.alunos.add(aluno);
	}
	
}
