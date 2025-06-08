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
     * Curso 1 del estudiante.
     */
    private Curso curso1;

    /**
     * Curso 2 del estudiante.
     */
    private Curso curso2;

    /**
     * Curso 3 del estudiante.
     */
    private Curso curso3;

    /**
     * Curso 4 del estudiante.
     */
    private Curso curso4;

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
        nombre = "Juliana";
        apellido = "Ramírez";
        codigo = 201612345;
        curso1 = new Curso( "ISIS1204", "APO1", 3, Departamento.SISTEMAS );
        curso2 = new Curso( "MATE1203", "Cálculo diferencial", 3, Departamento.MATEMATICAS );
        curso3 = new Curso( "FISI1100", "Física 1", 4, Departamento.FISICA );
        curso4 = new Curso( "BIOL1405", "Biología celular", 4, Departamento.BIOLOGIA );
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

    /**
     * Retorna el curso 1 del estudiante.
     * @return Curso 1 del estudiante.
     */
    public Curso darCurso1( )
    {
        return curso1;
    }

    /**
     * Retorna el curso 2 del estudiante.
     * @return Curso 2 del estudiante.
     */
    public Curso darCurso2( )
    {
        return curso2;
    }

    /**
     * Retorna el curso 3 del estudiante.
     * @return Curso 3 del estudiante.
     */
    public Curso darCurso3( )
    {
        return curso3;
    }

    /**
     * Retorna el curso 4 del estudiante.
     * @return Curso 4 del estudiante.
     */
    public Curso darCurso4( )
    {
        return curso4;
    }

    /**
     * Calcula el promedio del estudiante de los cursos que tienen nota asignada.
     * @return Promedio de los cursos que tienen nota asignada. Si ningún curso tiene nota asignada, retorna -1.
     */
    public double calcularPromedioEstudiante( )
    {
        double totalNota = 0.0;
        double totalCreditos = 0.0;
        double promedio = -1;

        if( curso1.estaCalificado( ) == true )
        {
            totalNota += ( curso1.darNota( ) * curso1.darCreditos( ) );
            totalCreditos += curso1.darCreditos( );
        }
        if( curso2.estaCalificado( ) == true )
        {
            totalNota += ( curso2.darNota( ) * curso2.darCreditos( ) );
            totalCreditos += curso2.darCreditos( );
        }
        if( curso3.estaCalificado( ) == true )
        {
            totalNota += ( curso3.darNota( ) * curso3.darCreditos( ) );
            totalCreditos += curso3.darCreditos( );
        }
        if( curso4.estaCalificado( ) == true )
        {
            totalNota += ( curso4.darNota( ) * curso4.darCreditos( ) );
            totalCreditos += curso4.darCreditos( );
        }

        if( totalCreditos > 0 )
        {
            promedio = ( double )totalNota / totalCreditos;
        }

        return promedio;
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
    public Curso buscarCurso( String pCodigoCurso )
    {
        Curso buscado = null;

        if( curso1.darCodigo( ).equals( pCodigoCurso ) )
        {
            buscado = curso1;
        }
        else if( curso2.darCodigo( ).equals( pCodigoCurso ) )
        {
            buscado = curso2;
        }
        else if( curso3.darCodigo( ).equals( pCodigoCurso ) )
        {
            buscado = curso3;
        }
        else if( curso4.darCodigo( ).equals( pCodigoCurso ) )
        {
            buscado = curso4;
        }

        return buscado;
    }

    /**
     * Registra la nota al curso dado por parámetro. <br>
     * <b>pre: </b> Existe un curso con el código dado. <br>
     * <b>post: </b> El curso tiene una nueva nota.
     * @param pCodigoCurso Código del curso. pCodigoCurso != null && pCodigoCurso != "".
     * @param pNota Nota para asignar al curso. pNota > 0.
     * @return Retorna true si pudo asignar la nota, false de lo contrario.
     */
    public boolean asignarNotaCurso( String pCodigoCurso, double pNota )
    {
        Curso buscado = buscarCurso( pCodigoCurso );
        boolean registra = false;
        if( pNota >= Curso.MINIMA && pNota <= Curso.MAXIMA && buscado != null )
        {
            buscado.asignarNota( pNota );
            registra = true;
        }

        return registra;
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
    public boolean cambiarCurso( String pCodigoActual, String pNuevoCodigo, String pNombre, int pCreditos, Departamento pDepartamento )
    {
        boolean asigno = false;
        if( buscarCurso( pNuevoCodigo ) == null )
        {
            if( curso1.darCodigo( ).equals( pCodigoActual ) )
            {
                curso1 = new Curso( pNuevoCodigo, pNombre, pCreditos, pDepartamento );
            }
            else if( curso2.darCodigo( ).equals( pCodigoActual ) )
            {
                curso2 = new Curso( pNuevoCodigo, pNombre, pCreditos, pDepartamento );
            }
            else if( curso3.darCodigo( ).equals( pCodigoActual ) )
            {
                curso3 = new Curso( pNuevoCodigo, pNombre, pCreditos, pDepartamento );
            }
            else if( curso4.darCodigo( ).equals( pCodigoActual ) )
            {
                curso4 = new Curso( pNuevoCodigo, pNombre, pCreditos, pDepartamento );
            }
            asigno = true;
        }
        return asigno;
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
        return "Respuesta 1";
    }

    /**
     * Método para la extensión 2.
     * @return Respuesta 2.
     */
    public String metodo2( )
    {
        return "Respuesta 2";
    }
}