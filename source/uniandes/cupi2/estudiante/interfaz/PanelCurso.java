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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import uniandes.cupi2.estudiante.mundo.Curso;

/**
 * Panel con la información de un curso.
 */
@SuppressWarnings("serial")
public class PanelCurso extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Representa el comando para asignar nota.
     */
    public final static String ASIGNAR_NOTA = "Asignar nota";

    /**
     * Representa el comando para cambiar el curso.
     */
    public final static String CAMBIAR_CURSO = "Cambiar curso";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicación.
     */
    private InterfazEstudiante principal;

    /**
     * Código del curso.
     */
    private String codigoCurso;

    // -----------------------------------------------------------------
    // Atributos de Interfaz
    // -----------------------------------------------------------------

    /**
     * Etiqueta nombre.
     */
    private JLabel lblNombre;

    /**
     * Etiqueta departamento.
     */
    private JLabel lblDepartamento;

    /**
     * Etiqueta créditos.
     */
    private JLabel lblCreditos;

    /**
     * Etiqueta notas.
     */
    private JLabel lblNotas;

    /**
     * Etiqueta para la imagen.
     */
    private JLabel lblImagen;

    /**
     * Campo de texto para el nombre;
     */
    private JTextField txtNombre;

    /**
     * Campo de texto para el departamento.
     */
    private JTextField txtDepartamento;

    /**
     * Campo de texto para los créditos.
     */
    private JTextField txtCreditos;

    /**
     * Campo de texto para la nota.
     */
    private JTextField txtNota;

    /**
     * Botón para asignar nota.
     */
    private JButton btnAsignarNota;

    /**
     * Botón para cambiar de curso.
     */
    private JButton btnCambiarCurso;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea el panel que muestra la información de un curso.
     * @param pPrincipal Ventana principal de la aplicación. pPrincipal != null.
     */
    public PanelCurso( InterfazEstudiante pPrincipal )
    {
        principal = pPrincipal;

        setBorder( new TitledBorder( "Curso " ) );
        setLayout( new BorderLayout( ) );

        JPanel panelAux = new JPanel( );
        panelAux.setLayout( new GridLayout( 5, 2, 3, 3 ) );

        lblNombre = new JLabel( "Nombre:" );
        panelAux.add( lblNombre );

        txtNombre = new JTextField( );
        txtNombre.setEditable( false );
        panelAux.add( txtNombre );

        lblDepartamento = new JLabel( "Departamento:" );
        panelAux.add( lblDepartamento );

        txtDepartamento = new JTextField( );
        txtDepartamento.setEditable( false );
        panelAux.add( txtDepartamento );

        lblCreditos = new JLabel( "Créditos:" );
        panelAux.add( lblCreditos );

        txtCreditos = new JTextField( );
        txtCreditos.setEditable( false );
        panelAux.add( txtCreditos );

        lblNotas = new JLabel( "Nota:" );
        panelAux.add( lblNotas );

        txtNota = new JTextField( );
        txtNota.setEditable( false );
        panelAux.add( txtNota );

        btnCambiarCurso = new JButton( "Cambiar curso" );
        btnCambiarCurso.setActionCommand( CAMBIAR_CURSO );
        btnCambiarCurso.addActionListener( this );
        panelAux.add( btnCambiarCurso );

        btnAsignarNota = new JButton( "Asignar nota" );
        btnAsignarNota.setActionCommand( ASIGNAR_NOTA );
        btnAsignarNota.addActionListener( this );
        panelAux.add( btnAsignarNota );

        add( panelAux, BorderLayout.CENTER );

        JPanel pnlImg = new JPanel( );
        pnlImg.setLayout( new GridLayout( 1, 2 ) );
        lblImagen = new JLabel( );
        pnlImg.add( lblImagen );
        pnlImg.add( new JLabel( ) );
        add( pnlImg, BorderLayout.WEST );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Actualiza el panel con la información del curso dado.
     * @param pCurso Curso con la información. pCurso != null.
     */
    public void actualizar( Curso pCurso )
    {
        txtNombre.setText( pCurso.darNombre( ) );
        setBorder( new TitledBorder( pCurso.darCodigo( ) ) );
        codigoCurso = pCurso.darCodigo( );
        String depto = "";
        String ruta = "./data/imagenes/";
        switch( pCurso.darDepartamento( ) )
        {
            case MATEMATICAS:
            {
                depto = "Matemática";
                ruta += "matematica.png";
                break;
            }
            case FISICA:
            {
                depto = "Física";
                ruta += "fisica.png";
                break;
            }
            case SISTEMAS:
            {
                depto = "Ing. Sistemas";
                ruta += "sistemas.png";
                break;
            }
            case BIOLOGIA:
            {
                depto = "Biología";
                ruta += "biologia.png";
                break;
            }
        }
        ImageIcon icono = new ImageIcon( ruta );
        lblImagen.setIcon( icono );
        txtDepartamento.setText( depto );
        txtCreditos.setText( pCurso.darCreditos( ) + "" );
        txtNota.setText( pCurso.darNota( ) + "" );
    }

    /**
     * Manejo de los eventos de los botones.
     * @param pEvento Acción que generó el evento. pEvento != null.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );
        if( comando.equals( ASIGNAR_NOTA ) )
        {
            principal.asignarNotaCurso( codigoCurso );
        }
        else if( comando.equals( CAMBIAR_CURSO ) )
        {
            principal.mostrarDialogoCambiarCurso( codigoCurso );
        }
    }

}
