/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 * Universidad de los Andes (Bogot� - Colombia) 
 * Departamento de Ingenier�a de Sistemas y Computaci�n
 * Licenciado bajo el esquema Academic Free License version 2.1
 * 
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n2_estudiante 
 * Autor: Equipo Cupi2 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.estudiante.mundo;

import uniandes.cupi2.estudiante.mundo.Curso.Departamento;

/**
 * Estudiante que tiene 4 cursos.
 */
public class Estudiante
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Representa la nota m�nima para no estar en prueba acad�mica.
     */
    public final static double NOTA_PRUEBA_ACADEMICA = 3.25;

    /**
     * Representa la nota m�nima para ser candidato a beca.
     */
    public final static double NOTA_CANDIDATO_BECA = 4.75;

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * C�digo del estudiante.
     */
    private int codigo;

    /**
     * Nombre del estudiante.
     */
    private String nombre;

    /**
     * Apellido del estudiante.
     */
    private String apellido;
    
    
    /**
     * Semestre del estudiante.
     */
    private int semestre;

    /**
     * Array con los cursos del estudiante.
     */
    private Curso[] cursos;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea un nuevo estudiante con los valores dados por par�metro. <br>
     * <b>post: </b> El estudiante fue inicializado con los siguientes valores: <br>
     * Nombre: Juliana, Apellido: Ram�rez, C�digo: 201612345. <br>
     * Los cursos del estudiante fueron inicializados con los siguientes valores: <br>
     * Curso 1 - C�digo: ISIS1204, Nombre: APO1, Cr�ditos: 3, Departamento: SISTEMAS. <br>
     * Curso 2 - C�digo: MATE1203, Nombre: C�lculo diferencial, Cr�ditos: 3, Departamento: MATEM�TICAS. <br>
     * Curso 3 - C�digo: FISI1100, Nombre: F�sica 1, Cr�ditos: 4, Departamento: FISICA. <br>
     * Curso 4 - C�digo: BIOL1405, Nombre: Biolog�a celular, Cr�ditos: 4, Departamento: BIOLOGIA.
     */
    public Estudiante( )
    {
        nombre = "Deyson";
        apellido = "Urrego";
        codigo = 1041531946;
        semestre = (int)(Math.random() * 10) + 1;
        cursos = new Curso[4];
        cursos[0] = new Curso( "ISIS1204", "APO1", 3, Departamento.SISTEMAS );
        cursos[1] = new Curso( "MATE1203", "C�lculo diferencial", 3, Departamento.MATEMATICAS );
        cursos[2] = new Curso( "FISI1100", "F�sica 1", 4, Departamento.FISICA );
        cursos[3] = new Curso( "BIOL1405", "Biolog�a celular", 4, Departamento.BIOLOGIA );
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Retorna el c�digo del estudiante.
     * @return C�digo del estudiante.
     */
    public int darCodigo( )
    {
        return codigo;
    }

    /**
     * Retorna el nombre del estudiante.
     * @return Nombre del estudiante.
     */
    public String darNombre( )
    {
        return nombre;
    }

    /**
     * Retorna el apellido del estudiante.
     * @return Apellido del estudiante.
     */
    public String darApellido( )
    {
        return apellido;
    }
    
    public int darSemestre( )
    {
    	return semestre;
    }

    /**
     * Retorna el curso 1 del estudiante.
     * @return Curso 1 del estudiante.
     */
    public Curso darCurso1( )
    {
        return cursos[0];
    }

    /**
     * Retorna el curso 2 del estudiante.
     * @return Curso 2 del estudiante.
     */
    public Curso darCurso2( )
    {
        return cursos[1];
    }

    /**
     * Retorna el curso 3 del estudiante.
     * @return Curso 3 del estudiante.
     */
    public Curso darCurso3( )
    {
        return cursos[2];
    }

    /**
     * Retorna el curso 4 del estudiante.
     * @return Curso 4 del estudiante.
     */
    public Curso darCurso4( )
    {
        return cursos[3];
    }

    /**
     * Calcula el promedio del estudiante de los cursos que tienen nota asignada.
     * @return Promedio de los cursos que tienen nota asignada. Si ning�n curso tiene nota asignada, retorna -1.
     */
    public double calcularPromedioEstudiante() {
        double totalNota = 0.0;
        double totalCreditos = 0.0;

        for (Curso c : cursos) {
            if (c.estaCalificado()) {
                totalNota += c.darNota() * c.darCreditos();
                totalCreditos += c.darCreditos();
            }
        }

        return totalCreditos > 0 ? totalNota / totalCreditos : -1; // Condicional ternario
    }


    /**
     * Indica si el estudiante se encuentra en prueba acad�mica.
     * @return Retorna true si se encuentra en prueba, false de lo contrario.
     */
    public boolean estaEnPrueba( )
    {
        boolean prueba = false;
        double promedio = calcularPromedioEstudiante( );
        if( promedio < NOTA_PRUEBA_ACADEMICA )
        {
            prueba = true;
        }

        return prueba;
    }

    /**
     * Indica si el estudiante es candidato a una beca.
     * @return Retorna true si es candidato a beca, false de lo contrario.
     */
    public boolean esCandidatoBeca( )
    {
        boolean beca = false;
        double promedio = calcularPromedioEstudiante( );
        if( promedio >= NOTA_CANDIDATO_BECA )
        {
            beca = true;
        }

        return beca;
    }

    /**
     * Buscar un curso dado su c�digo.
     * @param pCodigoCurso C�digo del curso. pCodigoCurso != null && pCodigoCurso != "".
     * @return Curso buscado, null en caso de no encontrarlo.
     */
    public Curso buscarCurso(String pCodigoCurso) {
        for (Curso c : cursos) {
            if (c.darCodigo().equals(pCodigoCurso)) {
                return c;
            }
        }
        return null;
    }


    /**
     * Registra la nota al curso dado por par�metro. <br>
     * <b>pre: </b> Existe un curso con el c�digo dado. <br>
     * <b>post: </b> El curso tiene una nueva nota.
     * @param pCodigoCurso C�digo del curso. pCodigoCurso != null && pCodigoCurso != "".
     * @param pNota Nota para asignar al curso. pNota > 0.
     * @return Retorna true si pudo asignar la nota, false de lo contrario.
     */
    public boolean asignarNotaCurso(String pCodigoCurso, double pNota) {
        Curso c = buscarCurso(pCodigoCurso);
        if (c != null && pNota >= Curso.MINIMA && pNota <= Curso.MAXIMA) {
            c.asignarNota(pNota);
            return true;
        }
        return false;
    }

    /**
     * Cambia el curso con el c�digo dado por par�metro a un nuevo curso con los valores dados por par�metro. <br>
     * Si ya existe un curso con el c�digo que se desea asignar, no se cambiar la informaci�n del curso. <br>
     * <b>pre: </b> Existe un curso con el c�digo dado. <br>
     * <b>post: </b> El curso tiene el nuevo c�digo, nombre, cr�ditos y departamento dados por par�metro.
     * @param pCodigoActual C�digo actual del curso a cambiar. pCodigoActual != null && pCodigoActual != "".
     * @param pNuevoCodigo Nuevo c�digo del curso. pNuevoCodigo != null && pNuevoCodigo != "".
     * @param pNombre Nombre del curso. pNombre != null && pNombre != "".
     * @param pCreditos Cr�ditos del curso. pCreditos > 0.
     * @param pDepartamento Departamento del curso.
     * @return Retorna true si se cambi� el curso, false si no se cambi� porque ya exist�a un curso con el c�digo que se deseaba asignar.
     */
    public boolean cambiarCurso(String pCodigoActual, String pNuevoCodigo, String pNombre, int pCreditos, Departamento pDepartamento) {
        if (buscarCurso(pNuevoCodigo) != null) return false;

        for (int i = 0; i < cursos.length; i++) {
            if (cursos[i].darCodigo().equals(pCodigoActual)) {
                cursos[i] = new Curso(pNuevoCodigo, pNombre, pCreditos, pDepartamento);
                return true;
            }
        }
        return false;
    }

    
    /**
     * Calcula el salario que ganar�a un estudiante si fuera monitor.
     * @return Salario en pesos.
     */
    
    public double calcularSalario()
    {
    	double promedio = calcularPromedioEstudiante();
    	
    	if (promedio == -1)
    	{
    		return 0.0;
    	}
    	
    	if (semestre >= 8) 
    	{
    		return 50000;
    	}
    	
    	if (semestre >= 4)
    	{
    		return (promedio >= 4.5) ? 35000 : 25000; // Condicionales ternarios
    	}
    		
    	return (promedio >= 4.0) ? 25000 : 15000;
    	
    }
    
    public double mejorNota() {
        double mejor = -1;
        for (Curso c : cursos) {
            if (c.estaCalificado() && c.darNota() > mejor) {
                mejor = c.darNota();
            }
        }
        return mejor;
    }

    


    // -----------------------------------------------------------------
    // Puntos de Extensi�n
    // -----------------------------------------------------------------

    /**
     * M�todo para la extensi�n 1.
     * @return Respuesta 1.
     */
    public String metodo1( )
    {
    	double promedio = calcularPromedioEstudiante();
    	double salario = calcularSalario();
    	
    	 // Uso de StringBuilder para construir la cadena que  mostrara la informaci�n
        StringBuilder Monitor = new StringBuilder();
        Monitor.append("=== Informaci�n de salario como monitor ===\n");
        Monitor.append("Nombre del Estudiante: ").append(nombre).append("\n");
        Monitor.append("Semestre actual: ").append(semestre).append("\n");
        Monitor.append("Promedio: ").append(String.format("%.2f", promedio)).append("\n"); // Formateo de promedio
        Monitor.append("Salario estimado como monitor: $").append(String.format("%.2f", salario)); // Formateo de salario

        return Monitor.toString();
    }

    /** 
     * M�todo para la extensi�n 2.
     * @return Respuesta 2.
     */
    public String metodo2( )
    {
    	double mejor = mejorNota();
    	
    	StringBuilder mensaje = new StringBuilder();
		mensaje.append("=== Mejor calificaci�n del estuadiante ===\n");
		mensaje.append("El estudiante: ").append(nombre).append(" " + apellido).append("\n");
    	
    	if (mejor == -1)
    	{
    		mensaje.append("No tiene calificaci�nes registradas.");
    	} else {
    		
    		mensaje.append("La mejor calificaci�n es: ").append(mejor);
    	}
    		
        return mensaje.toString();
    }
}