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

import uniandes.cupi2.estudiante.mundo.Curso;
import uniandes.cupi2.estudiante.mundo.Curso.Departamento;
import uniandes.cupi2.estudiante.mundo.Estudiante;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Clase usada para verificar que los métodos de la clase Estudiante estén correctamente implementados.
 */
public class EstudianteTest extends TestCase
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase usada para las pruebas.
     */
    private Estudiante estudiante;

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Escenario 1: Crea un nuevo estudiante sin calificaciones.
     */
    public void setupEscenario1( )
    {
        estudiante = new Estudiante( );
    }

    /**
     * Prueba 1: Verifica el método constructor.<br>
     * <b> Métodos a probar: </b> <br>
     * Curso<br>
     * darCodigo<br>
     * darNombre<br>
     * darApellido<br>
     * darCurso1<br>
     * darCurso2<br>
     * darCurso3<br>
     * darCurso4<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Los valores de los atributos corresponden.
     */
    @Test
    public void testEstudiante( )
    {
        setupEscenario1( );
        assertEquals( "El nombre no corresponde.", "Juliana", estudiante.darNombre( ) );
        assertEquals( "El apellido no corresponde.", "Ramírez", estudiante.darApellido( ) );
        assertEquals( "El código no corresponde.", 201612345, estudiante.darCodigo( ) );
        assertNotNull( "Debería existir el curso 1.", estudiante.darCurso1( ) );
        assertNotNull( "Debería existir el curso 2.", estudiante.darCurso2( ) );
        assertNotNull( "Debería existir el curso 3.", estudiante.darCurso3( ) );
        assertNotNull( "Debería existir el curso 4.", estudiante.darCurso4( ) );
    }

    /**
     * Prueba 2: Verifica el método buscarCurso.<br>
     * <b> Métodos a probar: </b> <br>
     * buscarCurso<br>
     * <b> Casos de prueba: </b> <br>
     * 1. El curso existe.<br>
     * 2. El curso no existe.
     */
    @Test
    public void testBuscarCurso( )
    {
        setupEscenario1( );
        assertNotNull( "El curso debería existir.", estudiante.buscarCurso( "ISIS1204" ) );

        assertNull( "El curso no debería existir.", estudiante.buscarCurso( "ISIS1205" ) );
    }

    /**
     * Prueba 3: Verifica el método buscarCurso.<br>
     * <b> Métodos a probar: </b> <br>
     * asignarNotaCurso<br>
     * <b> Casos de prueba: </b> <br>
     * 1. El curso no existe.<br>
     * 2. El curso existe y la nota no está en el rango.<br>
     * 3. El curso existe y la nota está en el rango.
     */
    @Test
    public void testAsignarNotaCurso( )
    {
        setupEscenario1( );
        assertFalse( "No debería asignar la nota.", estudiante.asignarNotaCurso( "ISSI1205", 3.0 ) );
        assertFalse( "No debería asignar la nota.", estudiante.asignarNotaCurso( "ISIS1204", 6.0 ) );
        assertTrue( "Debería asignar la nota.", estudiante.asignarNotaCurso( "ISIS1204", 3.0 ) );
    }

    /**
     * Prueba 4: Verifica el método calcularPromedioEstudiante.<br>
     * <b> Métodos a probar: </b> <br>
     * calcularPromedioEstudiante<br>
     * asignarNotaCurso<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Ningún curso tiene notas.<br>
     * 2. Todos los cursos tienen notas.
     */
    @Test
    public void testCalcularPromedioEstudiante( )
    {
        setupEscenario1( );
        assertEquals( "El promedio no corresponde.", -1, estudiante.calcularPromedioEstudiante( ), 0.01 );

        estudiante.asignarNotaCurso( "ISIS1204", 4 );
        estudiante.asignarNotaCurso( "FISI1100", 3 );
        estudiante.asignarNotaCurso( "MATE1203", 5 );
        estudiante.asignarNotaCurso( "BIOL1405", 4 );

        assertEquals( "El promedio no corresponde.", 3.93, estudiante.calcularPromedioEstudiante( ), 0.01 );
    }

    /**
     * Prueba 5: Verifica el método estaEnPrueba.<br>
     * <b> Métodos a probar: </b> <br>
     * estaEnPrueba<br>
     * asignarNotaCurso<br>
     * <b> Casos de prueba: </b> <br>
     * 1. No está en prueba.<br>
     * 2. Está en prueba.
     */
    @Test
    public void testEstaEnPrueba( )
    {
        setupEscenario1( );
        estudiante.asignarNotaCurso( "ISIS1204", 4 );
        estudiante.asignarNotaCurso( "FISI1100", 3 );
        estudiante.asignarNotaCurso( "MATE1203", 4 );
        estudiante.asignarNotaCurso( "BIOL1405", 4 );
        assertFalse( "Debería estar en prueba.", estudiante.estaEnPrueba( ) );

        estudiante.asignarNotaCurso( "ISIS1204", 2 );
        estudiante.asignarNotaCurso( "FISI1100", 3 );
        estudiante.asignarNotaCurso( "MATE1203", 2 );
        estudiante.asignarNotaCurso( "BIOL1405", 4 );
        assertTrue( "Debería estar en prueba.", estudiante.estaEnPrueba( ) );
    }

    /**
     * Prueba 6: Verifica el método esCandidatoABeca.<br>
     * <b> Métodos a probar: </b> <br>
     * esCandidatoABeca<br>
     * asignarNotaCurso<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Es candidato.<br>
     * 2. No es candidato.
     */
    @Test
    public void testEsCandidatoABeca( )
    {
        setupEscenario1( );
        estudiante.asignarNotaCurso( "ISIS1204", 4.7 );
        estudiante.asignarNotaCurso( "FISI1100", 5 );
        estudiante.asignarNotaCurso( "MATE1203", 4.9 );
        estudiante.asignarNotaCurso( "BIOL1405", 4.8 );
        assertTrue( "Debería ser candidato a beca.", estudiante.esCandidatoBeca( ) );

        estudiante.asignarNotaCurso( "ISIS1204", 3 );
        estudiante.asignarNotaCurso( "FISI1100", 3 );
        estudiante.asignarNotaCurso( "MATE1203", 3 );
        estudiante.asignarNotaCurso( "BIOL1405", 4 );
        assertFalse( "No debería ser candidato a beca.", estudiante.esCandidatoBeca( ) );
    }

    /**
     * Prueba 7: Verifica el método cambiarCurso.<br>
     * <b> Métodos a probar: </b> <br>
     * cambiarCurso<br>
     * buscarCurso<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Ya existe un curso con el nuevo código.<br>
     * 2. No existe un curso con el nuevo código.
     */
    @Test
    public void testCambiarCurso( )
    {
        setupEscenario1( );
        boolean cambio = estudiante.cambiarCurso( "ISIS1204", "MATE1203", "Nomb", 3, Departamento.SISTEMAS );
        assertFalse( cambio );
        // assertNull( "No debería existir el curso.", estudiante.buscarCurso( "ISIS1204" ) );
        // assertNotNull( "Debería existir el curso.", estudiante.buscarCurso( "Nuevo" ) );

        cambio = estudiante.cambiarCurso( "MATE1203", "ISIS1205", "APO2", 3, Departamento.SISTEMAS );
        assertTrue( cambio );
        // assertNull( "No debería existir el curso.", estudiante.buscarCurso( "Nuevo2" ) );
        // assertNotNull( "Debería existir el curso.", estudiante.buscarCurso( "Nuevo" ) );
    }

}