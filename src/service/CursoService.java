package service;
import java.util.ArrayList;
import java.util.List;

import entities.Curso;

public class CursoService {

	private List<Curso> cursos; 
	public CursoService() {
		this.cursos = new ArrayList<Curso>();
		this.cursos.add(new Curso (1,"BCC","Integral",8));
		this.cursos.add(new Curso (2,"ADS","Nortuno",6));
		this.cursos.add(new Curso (3,"Mecanica","Integral",10));
		this.cursos.add(new Curso(4,"Biologia","Integral",8));
		
	
}
	public List<Curso> buscarTodos(){
		return this.cursos;
	}
}
	
