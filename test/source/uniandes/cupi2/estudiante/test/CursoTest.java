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
package uniandes.cupi2.estudiante.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import uniandes.cupi2.estudiante.mundo.Curso;
import uniandes.cupi2.estudiante.mundo.Curso.Departamento;

/**
 * Clase usada para verificar que los métodos de la clase Curso estén correctamente implementados.
 */
public class CursoTest
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase donde se harán las pruebas
     */
    private Curso curso;

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Escenario 1: Construye un curso sin nota.
     */
    public void setupEscenario1( )
    {
        curso = new Curso( "COD", "Nombre", 3, Departamento.SISTEMAS );
    }

    /**
     * Prueba 1: Verifica el método constructor.<br>
     * <b> Métodos a probar: </b> <br>
     * Curso<br>
     * darCodigo<br>
     * darNombre<br>
     * darCreditos<br>
     * darDepartamento<br>
     * darNota<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Los valores de los atributos corresponden.
     */
    @Test
    public void testCurso( )
    {
        setupEscenario1( );
        assertEquals( "El código no corresponde.", "COD", curso.darCodigo( ) );
        assertEquals( "El nombre no corresponde.", "Nombre", curso.darNombre( ) );
        assertEquals( "Los créditos no corresponden.", 3, curso.darCreditos( ) );
        assertEquals( "La nota no corresponde.", 0.0, curso.darNota( ), 0.01 );
        assertTrue( "El departamento no corresponde.", Departamento.SISTEMAS == curso.darDepartamento( ) );
    }

    /**
     * Prueba 2: Verifica el método asignarNota.<br>
     * <b> Métodos a probar: </b> <br>
     * asignarNota<br>
     * darNota<br>
     * <b> Casos de prueba: </b> <br>
     * 1. El curso no tiene nota.<br>
     */
    @Test
    public void testAsignarNota( )
    {
        setupEscenario1( );
        curso.asignarNota( 4.5 );

        assertEquals( "La nota no corresponde.", 4.5, curso.darNota( ), 0.01 );
    }

    /**
     * Prueba 3: Verifica el método estaCalificado.<br>
     * <b> Métodos a probar: </b> <br>
     * asignarNota<br>
     * estaCalificado<br>
     * <b> Casos de prueba: </b> <br>
     * 1. El curso no tiene nota.<br>
     * 2. El curo tiene nota.
     */
    @Test
    public void testEstaCalificado( )
    {
        setupEscenario1( );
        assertFalse( "El curso no debería tener nota.", curso.estaCalificado( ) );
        curso.asignarNota( 4.5 );
        assertTrue( "El curso debería tener nota.", curso.estaCalificado( ) );
    }
}
