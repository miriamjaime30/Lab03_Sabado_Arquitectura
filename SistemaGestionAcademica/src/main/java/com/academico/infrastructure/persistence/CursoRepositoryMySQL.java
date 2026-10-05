package com.academico.infrastructure.persistence;

import com.academico.domain.model.Curso;
import com.academico.domain.repository.CursoRepository;

import java.util.ArrayList;
import java.util.List;

public class CursoRepositoryMySQL implements CursoRepository {
    private List<Curso> cursos =new ArrayList<>();
    @Override
    public List<Curso> listar(){
        System.out.println("[MySQL] Listando cursos...");
        return new ArrayList<>(cursos);
    }
    @Override
    public void guardar(List<Curso>cursos){
        System.out.println("[MySQL] Guardando"+ cursos.size()+" curso(s)...");
        this.cursos=new ArrayList<>(cursos);
    }
}
