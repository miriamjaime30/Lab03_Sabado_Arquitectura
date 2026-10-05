package com.academico;
import com.academico.application.CursoService;
import com.academico.domain.repository.CursoRepository;
import com.academico.infrastructure.persistence.CursoRepositoryJson;
import com.academico.infrastructure.persistence.CursoRepositoryMySQL;
import com.academico.infrastructure.persistence.EstudianteRepositoryJson;
import com.academico.infrastructure.persistence.EstudianteRepositoryMySQL;
import com.academico.presentation.EstudianteUI;
import com.academico.presentation.CursoUI;
//agregar
import com.academico.application.EstudianteService;
import com.academico.domain.repository.EstudianteRepository;

import  java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //agregar
        // infraestructura
        //EstudianteRepository repository=new EstudianteRepositoryJson();
        EstudianteRepository estudianteRepository= new EstudianteRepositoryMySQL();
        //CursoRepository cursoRepository =new CursoRepositoryJson();
        CursoRepository cursoRepository = new CursoRepositoryMySQL();

        //aplicacion
        EstudianteService service=new EstudianteService(estudianteRepository);
        CursoService cursoService = new CursoService(cursoRepository);

        // presentacion
        EstudianteUI estudianteUI=new EstudianteUI(service);
        CursoUI cursoUI =new CursoUI(cursoService);

        Scanner sc = new Scanner(System.in);

        int opcion;

        do {

            System.out.println("\n=== SISTEMA DE GESTIÓN ACADÉMICA ===");
            System.out.println("1. Gestionar estudiantes");
            System.out.println("2. Gestionar cursos");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    estudianteUI.mostrarMenu(sc);
                    break;

                case 2:
                    cursoUI.mostrarMenu(sc);
                    break;

                case 0:
                    System.out.println("Sistema finalizado.");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 0);

        sc.close();
    }
}