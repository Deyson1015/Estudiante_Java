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

/**
 * Curso del estudiante.
 */
public class Curso
{
    // -----------------------------------------------------------------
    // Enumeraciones
    // -----------------------------------------------------------------
    /**
     * Enumeradores para el departamento del curso.
     */
    public enum Departamento
    {
        /**
         * Representa el departamento de Matemáticas.
         */
        MATEMATICAS,
        /**
         * Representa el departamento de Física.
         */
        FISICA,
        /**
         * Representa el departamento de Ingeniería de sistemas.
         */
        SISTEMAS,
        /**
         * Representa el departamento de Biología.
         */
        BIOLOGIA
    }
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Representa la nota mínima.
     */
    public final static double MINIMA = 1.5;

    /**
     * Representa la nota máxima.
     */
    public final static double MAXIMA = 5.0;

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Código del curso.
     */
    private String codigo;

    /**
     * Nombre del curso.
     */
    private String nombre;

    /**
     * Departamento del curso.
     */
    private Departamento departamento;

    /**
     * Cantidad de créditos del curso.
     */
    private int creditos;

    /**
     * Nota del curso.
     */
    private double nota;

    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------

    /**
     * Crea el curso con los valores dados por parámetro. <br>
     * <b>post: </b> El código, nombre, número de créditos y departamento fueron inicializados con los valores dados por parámetro. <br>
     * La nota del curso fue inicializada en 0.0.
     * @param pCodigo Código del curso. pCodigo != null && pCodigo != "".
     * @param pNombre Nombre del curso. pNombre != null && pNombre != "".
     * @param pCreditos Número de créditos del curso. pCreditos > 0.
     * @param pDepartamento Departamento del curso.
     */
    public Curso( String pCodigo, String pNombre, int pCreditos, Departamento pDepartamento )
    {
        nota = 0.0;
        creditos = pCreditos;
        nombre = pNombre;
        codigo = pCodigo;
        departamento = pDepartamento;
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna el código del curso.
     * @return Código del curso.
     */
    public String darCodigo( )
    {
        return codigo;
    }

    /**
     * Retorna el nombre del curso.
     * @return Nombre del curso.
     */
    public String darNombre( )
    {
        return nombre;
    }

    /**
     * Retorna el número de créditos del curso.
     * @return Número de créditos del curso.
     */
    public int darCreditos( )
    {
        return creditos;
    }

    /**
     * Retorna la nota del curso.
     * @return Nota del curso.
     */
    public double darNota( )
    {
        return nota;
    }

    /**
     * Retorna el departamento del curso.
     * @return Departamento del curso.
     */
    public Departamento darDepartamento( )
    {
        return departamento;
    }

    /**
     * Asigna la nota dada por parámetro. <br>
     * <b>post: </b> Se asigna la nueva nota del curso.
     * @param pNuevaNota Nueva nota del curso. pNuevaNota >= 1.5 && pNuevaNota <= 5.0.
     */
    public void asignarNota( double pNuevaNota )
    {
        nota = pNuevaNota;
    }

    /**
     * Indica si el curso ya ha sido calificado.
     * @return Retorna true si el curso ya tiene nota, false de lo contrario.
     */
    public boolean estaCalificado( )
    {
        boolean calificado = false;
        if( nota != 0.0 )
        {
            calificado = true;
        }
        return calificado;
    }
}