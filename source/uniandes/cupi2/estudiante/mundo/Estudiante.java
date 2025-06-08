/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 * Universidad de los Andes (Bogotá - Colombia) 
 * Departamento de Ingeniería de Sistemas y Computación
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
     * Representa la nota mínima para no estar en prueba académica.
     */
    public final static double NOTA_PRUEBA_ACADEMICA = 3.25;

    /**
     * Representa la nota mínima para ser candidato a beca.
     */
    public final static double NOTA_CANDIDATO_BECA = 4.75;

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Código del estudiante.
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
     * Crea un nuevo estudiante con los valores dados por parámetro. <br>
     * <b>post: </b> El estudiante fue inicializado con los siguientes valores: <br>
     * Nombre: Juliana, Apellido: Ramírez, Código: 201612345. <br>
     * Los cursos del estudiante fueron inicializados con los siguientes valores: <br>
     * Curso 1 - Código: ISIS1204, Nombre: APO1, Créditos: 3, Departamento: SISTEMAS. <br>
     * Curso 2 - Código: MATE1203, Nombre: Cálculo diferencial, Créditos: 3, Departamento: MATEMÁTICAS. <br>
     * Curso 3 - Código: FISI1100, Nombre: Física 1, Créditos: 4, Departamento: FISICA. <br>
     * Curso 4 - Código: BIOL1405, Nombre: Biología celular, Créditos: 4, Departamento: BIOLOGIA.
     */
    public Estudiante( )
    {
        nombre = "Deyson";
        apellido = "Urrego";
        codigo = 1041531946;
        semestre = (int)(Math.random() * 10) + 1;
        cursos = new Curso[4];
        cursos[0] = new Curso( "ISIS1204", "APO1", 3, Departamento.SISTEMAS );
        cursos[1] = new Curso( "MATE1203", "Cálculo diferencial", 3, Departamento.MATEMATICAS );
        cursos[2] = new Curso( "FISI1100", "Física 1", 4, Departamento.FISICA );
        cursos[3] = new Curso( "BIOL1405", "Biología celular", 4, Departamento.BIOLOGIA );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna el código del estudiante.
     * @return Código del estudiante.
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
     * @return Promedio de los cursos que tienen nota asignada. Si ningún curso tiene nota asignada, retorna -1.
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
     * Indica si el estudiante se encuentra en prueba académica.
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
     * Buscar un curso dado su código.
     * @param pCodigoCurso Código del curso. pCodigoCurso != null && pCodigoCurso != "".
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
     * Registra la nota al curso dado por parámetro. <br>
     * <b>pre: </b> Existe un curso con el código dado. <br>
     * <b>post: </b> El curso tiene una nueva nota.
     * @param pCodigoCurso Código del curso. pCodigoCurso != null && pCodigoCurso != "".
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
     * Cambia el curso con el código dado por parámetro a un nuevo curso con los valores dados por parámetro. <br>
     * Si ya existe un curso con el código que se desea asignar, no se cambiar la información del curso. <br>
     * <b>pre: </b> Existe un curso con el código dado. <br>
     * <b>post: </b> El curso tiene el nuevo código, nombre, créditos y departamento dados por parámetro.
     * @param pCodigoActual Código actual del curso a cambiar. pCodigoActual != null && pCodigoActual != "".
     * @param pNuevoCodigo Nuevo código del curso. pNuevoCodigo != null && pNuevoCodigo != "".
     * @param pNombre Nombre del curso. pNombre != null && pNombre != "".
     * @param pCreditos Créditos del curso. pCreditos > 0.
     * @param pDepartamento Departamento del curso.
     * @return Retorna true si se cambió el curso, false si no se cambió porque ya existía un curso con el código que se deseaba asignar.
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
     * Calcula el salario que ganaría un estudiante si fuera monitor.
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
    // Puntos de Extensión
    // -----------------------------------------------------------------

    /**
     * Método para la extensión 1.
     * @return Respuesta 1.
     */
    public String metodo1( )
    {
    	double promedio = calcularPromedioEstudiante();
    	double salario = calcularSalario();
    	
    	 // Uso de StringBuilder para construir la cadena que  mostrara la información
        StringBuilder Monitor = new StringBuilder();
        Monitor.append("=== Información de salario como monitor ===\n");
        Monitor.append("Nombre del Estudiante: ").append(nombre).append("\n");
        Monitor.append("Semestre actual: ").append(semestre).append("\n");
        Monitor.append("Promedio: ").append(String.format("%.2f", promedio)).append("\n"); // Formateo de promedio
        Monitor.append("Salario estimado como monitor: $").append(String.format("%.2f", salario)); // Formateo de salario

        return Monitor.toString();
    }

    /** 
     * Método para la extensión 2.
     * @return Respuesta 2.
     */
    public String metodo2( )
    {
    	double mejor = mejorNota();
    	
    	StringBuilder mensaje = new StringBuilder();
		mensaje.append("=== Mejor calificación del estuadiante ===\n");
		mensaje.append("El estudiante: ").append(nombre).append(" " + apellido).append("\n");
    	
    	if (mejor == -1)
    	{
    		mensaje.append("No tiene calificaciónes registradas.");
    	} else {
    		
    		mensaje.append("La mejor calificación es: ").append(mejor);
    	}
    		
        return mensaje.toString();
    }
}