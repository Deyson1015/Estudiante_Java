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

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 * Panel con las opciones.
 */
@SuppressWarnings("serial")
public class PanelOpciones extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Representa el comando para verificar si el estudiante está en prueba académica.
     */
    private static final String PRUEBA = "PRUEBA";

    /**
     * Representa el comando para verificar si el estudiante es apto para un beca.
     */
    private static final String BECA = "BECA";

    /**
     * Representa el comando para la opción 1.
     */
    private static final String OPCION1 = "OPCION_1";

    /**
     * Representa el comando para la opción 2.
     */
    private static final String OPCION2 = "OPCION_2";

    // -----------------------------------------------------------------
    // Atributos de Interfaz
    // -----------------------------------------------------------------

    /**
     * Botón para verificar que el estudiante está en prueba.
     */
    private JButton btnPrueba;

    /**
     * Botón para verificar que el estudiante puede tener beca.
     */
    private JButton btnBeca;

    /**
     * Botón para el punto de extensión 1.
     */
    private JButton btnOpcion1;

    /**
     * Botón para el punto de extensión 2.
     */
    private JButton btnOpcion2;

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    /**
     * Ventana principal de la aplicación.
     */
    private InterfazEstudiante principal;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea el panel con sus botones.
     * @param pPrincipal Ventana principal de la aplicación. pPrincipal != null.
     */
    public PanelOpciones( InterfazEstudiante pPrincipal )
    {
        principal = pPrincipal;
        setLayout( new GridLayout( 1, 4, 2, 2 ) );
        setBorder( new TitledBorder( "Opciones" ) );

        btnBeca = new JButton( "Candidato beca" );
        btnBeca.setActionCommand( BECA );
        btnBeca.addActionListener( this );
        add( btnBeca );

        btnPrueba = new JButton( "Prueba académica" );
        btnPrueba.setActionCommand( PRUEBA );
        btnPrueba.addActionListener( this );
        add( btnPrueba );

        btnOpcion1 = new JButton( "Opción 1" );
        btnOpcion1.setActionCommand( OPCION1 );
        btnOpcion1.addActionListener( this );
        add( btnOpcion1 );

        btnOpcion2 = new JButton( "Opción 2" );
        btnOpcion2.setActionCommand( OPCION2 );
        btnOpcion2.addActionListener( this );
        add( btnOpcion2 );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Manejo de los eventos de los botones.
     * @param pEvento Acción que generó el evento. pEvento != null.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );

        if( comando.equals( BECA ) )
        {
            principal.estudianteCandidatoBeca( );
        }
        else if( comando.equals( PRUEBA ) )
        {
            principal.estudianteEnPrueba( );
        }
        else if( comando.equals( OPCION1 ) )
        {
            principal.reqFuncOpcion1( );
        }
        else if( comando.equals( OPCION2 ) )
        {
            principal.reqFuncOpcion2( );
        }

    }

}
