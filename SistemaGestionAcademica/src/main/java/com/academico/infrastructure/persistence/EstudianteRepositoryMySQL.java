package com.academico.infrastructure.persistence;

import com.academico.domain.model.Estudiante;
import com.academico.domain.repository.EstudianteRepository;

import java.util.ArrayList;
import java.util.List;

public class EstudianteRepositoryMySQL implements EstudianteRepository {
    private List<Estudiante> estudiantes =new ArrayList<>();
    @Override
    public List<Estudiante>listar(){
        System.out.println("[MySQL] Listando estudiantes ");
        return new ArrayList<>(estudiantes);
    }
    @Override
    public  void guardar(List<Estudiante>estudiantes){
        System.out.println("[MySQL] Guardando"+ estudiantes.size()+"estudiante(s)...");
        this.estudiantes=new ArrayList<>(estudiantes);
    }
}
