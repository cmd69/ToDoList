package vista;

import controlador.InterfaceControlador;
import modelo.InterfaceModelo;
import modelo.Tabla;

import javax.swing.*;
import java.awt.*;

public class Vista implements InterfaceVista {

    private InterfaceModelo modelo;
    private Tabla tabla;
    private InterfaceControlador controlador;
    private JPanel cuerpo;
    private JPanel info;
    private JFrame ventana;
    private JPanel prioridad;
    private JPanel completada;
    private JButton aplicar;

    public Vista(){}

    public void run(){
        //BASE
        ventana = new JFrame("To Do List");
        Container container = ventana.getContentPane();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

        //PANEL PRIORIDAD
        ButtonGroup gPrioridad = new ButtonGroup();
        JRadioButton alta = new JRadioButton("Alta");
        JRadioButton media = new JRadioButton("Media");
        JRadioButton baja = new JRadioButton("Baja");
        JRadioButton pTodas = new JRadioButton("Todas");
        gPrioridad.add(alta);
        gPrioridad.add(media);
        gPrioridad.add(baja);
        gPrioridad.add(pTodas);
        prioridad = new JPanel();
        prioridad.setLayout(new GridLayout(4, 1));
        prioridad.add(alta);
        prioridad.add(media);
        prioridad.add(baja);
        prioridad.add(pTodas);
        prioridad.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Priodidad"));

        //PANEL COMPLETADA
        ButtonGroup gCompletadas = new ButtonGroup();
        JRadioButton sCompletada = new JRadioButton("Completada");
        JRadioButton nCompletada = new JRadioButton("No completada");
        JRadioButton cTodas = new JRadioButton("Todas");
        gCompletadas.add(sCompletada);
        gCompletadas.add(nCompletada);
        gCompletadas.add(cTodas);
        //sCompletada.setSelected(true);
        completada = new JPanel();
        completada.setLayout(new GridLayout(4, 1));
        completada.add(sCompletada);
        completada.add(nCompletada);
        completada.add(cTodas);
        completada.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Completada"));

        //PANEL BOTON APLICAR
        JPanel panelAplicar = new JPanel();
        aplicar = new JButton("Aplicar Filtros");
        panelAplicar.add(aplicar);

        //PANEL FILTROS
        JPanel filtros = new JPanel(new GridLayout());
        filtros.add(prioridad);
        filtros.add(completada);
        filtros.add(panelAplicar);

        //PANEL CUERPO
        cuerpo = new JPanel();
        cuerpo.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Lista de tareas"));

        //PANEL INFO
        info = new JPanel();
        info.setLayout(new BoxLayout(info, BoxLayout.Y_AXIS));
        info.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Detalles de la tarea"));
        //titulo
        JPanel pTitulo = new JPanel();
        JLabel textoTitulo = new JLabel("Título: ");
        JTextField titulo = new JTextField(20);
        pTitulo.add(textoTitulo);
        pTitulo.add(titulo);
        info.add(pTitulo);
        //descripcion
        JPanel pDesc = new JPanel();
        JLabel textoDesc = new JLabel("Descripción: ");
        JTextArea desc = new JTextArea(4, 40);
        pDesc.add(textoDesc);
        pDesc.add(desc);
        info.add(pDesc);
        //completada
        JCheckBox checkBox = new JCheckBox("Completada");
        info.add(checkBox);

        //NUEVA TAREA BOTONES
        JPanel botonesNueva = new JPanel();
        botonesNueva.setLayout(new BoxLayout(botonesNueva, BoxLayout.X_AXIS));
        JButton nuevo = new JButton("Nuevo");
        JButton actualiza = new JButton("Actualiza");
        JButton borrar = new JButton("Borrar");
        botonesNueva.add(nuevo);
        botonesNueva.add(actualiza);
        botonesNueva.add(borrar);

        //NUEVA TAREA FILTROS
        ButtonGroup gnPrioridad = new ButtonGroup();
        JRadioButton gnAlta = new JRadioButton("Alta");
        JRadioButton gnMedia = new JRadioButton("Media");
        JRadioButton gnBaja = new JRadioButton("Baja");
        gnPrioridad.add(gnAlta);
        gnPrioridad.add(gnMedia);
        gnPrioridad.add(gnBaja);
        JPanel gnPanel = new JPanel();
        gnPanel.setLayout(new BoxLayout(gnPanel, BoxLayout.X_AXIS));
        gnPanel.add(gnAlta);
        gnPanel.add(gnMedia);
        gnPanel.add(gnBaja);
        gnPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Priodidad"));
        JPanel gridGnPanel = new JPanel();
        gridGnPanel.setLayout(new GridLayout());
        gridGnPanel.add(gnPanel);

        //AÑADIR PANELES A LA VENTANA
        container.add(filtros);
        container.add(cuerpo);
        container.add(info);
        container.add(gridGnPanel);
        container.add(botonesNueva);

        //VALORES VENTANA
        ventana.setVisible(true);
        //ventana.setSize(650, 500);
        ventana.pack();
        ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);
    }
}
