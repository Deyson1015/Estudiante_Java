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
package uniandes.cupi2.estudiante.interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

import uniandes.cupi2.estudiante.mundo.Curso.Departamento;
import uniandes.cupi2.estudiante.mundo.Estudiante;

/**
 * Ventana principal de la aplicación.
 */
@SuppressWarnings("serial")
public class InterfazEstudiante extends JFrame
{

    // ------------------------------------------------------------------
    // Atributos de Interfaz
    // -----------------------------------------------------------------

    /**
     * Panel con la imagen.
     */
    private PanelImagen panelImagen;

    /**
     * Panel con la información del estudiante.
     */
    private PanelInfoEstudiante panelInfoEstudiante;

    /**
     * Panel con las opciones.
     */
    private PanelOpciones panelOpciones;

    /**
     * Panel con la información del curso 1.
     */
    private PanelCurso panelCurso1;

    /**
     * Panel con la información del curso 2.
     */
    private PanelCurso panelCurso2;

    /**
     * Panel con la información del curso 3.
     */
    private PanelCurso panelCurso3;

    /**
     * Panel con la información del curso 4.
     */
    private PanelCurso panelCurso4;

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    /**
     * Clase principal del mundo.
     */
    private Estudiante estudiante;

    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------

    /**
     * Crea la ventana principal de la aplicación con todos sus paneles.
     */
    public InterfazEstudiante( )
    {
        setTitle( "Estudiante" );
        setSize( 800, 650 );
        setDefaultCloseOperation( javax.swing.JFrame.EXIT_ON_CLOSE );

        estudiante = new Estudiante( );

        setLayout( new BorderLayout( ) );

        JPanel panelNorte = new JPanel( );
        panelNorte.setLayout( new BorderLayout( ) );

        panelImagen = new PanelImagen( );
        panelNorte.add( panelImagen, BorderLayout.NORTH );

        panelInfoEstudiante = new PanelInfoEstudiante( );
        panelNorte.add( panelInfoEstudiante, BorderLayout.CENTER );

        add( panelNorte, BorderLayout.NORTH );

        JPanel panelCentro = new JPanel( );
        panelCentro.setLayout( new GridLayout( 2, 2 ) );

        panelCurso1 = new PanelCurso( this );
        panelCentro.add( panelCurso1 );
        panelCurso2 = new PanelCurso( this );
        panelCentro.add( panelCurso2 );
        panelCurso3 = new PanelCurso( this );
        panelCentro.add( panelCurso3 );
        panelCurso4 = new PanelCurso( this );
        panelCentro.add( panelCurso4 );

        add( panelCentro, BorderLayout.CENTER );

        panelOpciones = new PanelOpciones( this );
        add( panelOpciones, BorderLayout.SOUTH );

        setLocationRelativeTo( null );
        setResizable( false );

        actualizar( );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Actualiza todos los paneles.
     */
    public void actualizar( )
    {
        panelInfoEstudiante.actualizar( estudiante );
        panelCurso1.actualizar( estudiante.darCurso1( ) );
        panelCurso2.actualizar( estudiante.darCurso2( ) );
        panelCurso3.actualizar( estudiante.darCurso3( ) );
        panelCurso4.actualizar( estudiante.darCurso4( ) );
    }

    /**
     * Asigna la nota de un curso.
     * @param pCodigo Código del curso que se le va a asignar la nota. pCodigo != null && pCodigo != "".
     */
    public void asignarNotaCurso( String pCodigo )
    {
        String ingresado = JOptionPane.showInputDialog( this, "Nota obtenida en el curso:", "Asignar nota", JOptionPane.DEFAULT_OPTION );

        if( ingresado != null )
        {
            try
            {
                double nota = Double.parseDouble( ingresado );
                if( nota < 0 )
                {
                    JOptionPane.showMessageDialog( this, "El valor ingresado debe ser un valor positivo.", "Asignar nota", JOptionPane.ERROR_MESSAGE );
                }
                else
                {
                    boolean asigno = estudiante.asignarNotaCurso( pCodigo, nota );
                    if( asigno == true )
                    {
                        actualizar( );
                    }
                    else
                    {
                        JOptionPane.showMessageDialog( this, "La nota debe estar entre 1.5 y 5.0.", "Asignar nota", JOptionPane.ERROR_MESSAGE );
                    }
                }
            }
            catch( NumberFormatException e )
            {
                JOptionPane.showMessageDialog( this, "Debe ingresar un valor numérico.", "Asignar nota", JOptionPane.ERROR_MESSAGE );
            }
        }
    }

    /**
     * Indica si el estudiante está en prueba o no.
     */
    public void estudianteEnPrueba( )
    {
        double promedio = estudiante.calcularPromedioEstudiante( );
        boolean estaPrueba = estudiante.estaEnPrueba( );

        if( promedio == -1 )
        {
            JOptionPane.showMessageDialog( this, "Debe asignar nota al menos a un curso.", "Estudiante en prueba", JOptionPane.INFORMATION_MESSAGE );
        }
        else
        {
            if( estaPrueba )
            {
                JOptionPane.showMessageDialog( this, "El estudiante se encuentra en prueba académica (promedio < 3.25).", "Estudiante en prueba", JOptionPane.INFORMATION_MESSAGE );
            }
            else
            {
                JOptionPane.showMessageDialog( this, "El estudiante no se encuentra en prueba académica (promedio >= 3.25).", "Estudiante en prueba", JOptionPane.INFORMATION_MESSAGE );
            }
        }

    }

    /**
     * Indica si el estudiante es candidato a beca o no.
     */
    public void estudianteCandidatoBeca( )
    {
        double promedio = estudiante.calcularPromedioEstudiante( );
        boolean beca = estudiante.esCandidatoBeca( );

        if( promedio == -1 )
        {
            JOptionPane.showMessageDialog( this, "Debe asignar nota al menos a un curso.", "Estudiante candidato a beca", JOptionPane.INFORMATION_MESSAGE );
        }
        else
        {
            if( beca )
            {
                JOptionPane.showMessageDialog( this, "El estudiante es candidato a beca (promedio >= 4.75).", "Estudiante candidato a beca", JOptionPane.INFORMATION_MESSAGE );
            }
            else
            {
                JOptionPane.showMessageDialog( this, "El estudiante no es candidato a beca (promedio < 4.75).", "Estudiante candidato a beca", JOptionPane.INFORMATION_MESSAGE );
            }
        }

    }

    /**
     * Cambia la información del curso actual.
     * @param pCodigoActual Código actual del curso. pCodigoActual != null && pCodigoActual != "".
     * @param pNuevoCodigo Código nuevo del curso. pCodigoNuevo != null && pCodigoNuevo != "".
     * @param pNombre Nombre nuevo del curso. pNombre != "" && pNombre != null.
     * @param pDepartamento Departamento del curso. pDepartamento != null.
     * @param pCreditos Créditos a asignar. pCreditos >= 0.
     */
    public void cambiarCurso( String pCodigoActual, String pNuevoCodigo, String pNombre, Departamento pDepartamento, int pCreditos )
    {
        if( estudiante.cambiarCurso( pCodigoActual, pNuevoCodigo, pNombre, pCreditos, pDepartamento ) )
        {
            actualizar( );
        }
        else
        {
            JOptionPane.showMessageDialog( this, "Ya existe un curso con código " + pNuevoCodigo + ".", "Cambiar curso", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Muestra el diálogo que permite cambiar un curso y su información.
     * @param pCodigoCurso Código del curso a cambiar. pCodigoCurso != "" && pCodigoCurso != null.
     */
    public void mostrarDialogoCambiarCurso( String pCodigoCurso )
    {
        DialogoCambiarCurso dialogo = new DialogoCambiarCurso( this, pCodigoCurso );
        dialogo.setVisible( true );
    }

    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------

    /**
     * Opción 1 de extensión.
     */
    public void reqFuncOpcion1( )
    {
        String respuesta = estudiante.metodo1( );
        actualizar( );
        JOptionPane.showMessageDialog( this, respuesta, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Opción 2 de extensión.
     */
    public void reqFuncOpcion2( )
    {
        String respuesta = estudiante.metodo2( );
        actualizar( );
        JOptionPane.showMessageDialog( this, respuesta, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    // -----------------------------------------------------------------
    // Main
    // -----------------------------------------------------------------

    /**
     * Ejecuta la aplicación.
     * @param pArgs Parámetros de la ejecución. No son necesarios.
     */
    public static void main( String[] pArgs )
    {
        try
        {
            // Unifica la interfaz para Mac y para Windows.
            UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName( ) );

            InterfazEstudiante interfaz = new InterfazEstudiante( );
            interfaz.setVisible( true );
        }
        catch( Exception e )
        {
            e.printStackTrace( );
        }
    }
}