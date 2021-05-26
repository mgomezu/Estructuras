
package Controlador;

import java.io.FileNotFoundException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import Vista.Vista;
import Vista.Vista_Admin_Cursos;
import Vista.Vista_Admin_Est;
import Vista.Vista_Admin_Inicio;
import Vista.Vista_Admin_Profe;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Controlador_Admin_Cursos {

    Vista_Admin_Cursos vista;

    public Controlador_Admin_Cursos() {
        vista = new Vista_Admin_Cursos();
        vista.getAñadirCursos().setOnAction(new EventoAñadirCursos());
        vista.getEliminarCursos().setOnAction(new EventoEliminarCursos());
        vista.getActualizarCursos().setOnAction(new EventoActualizarCursos());
        vista.getCerrar().setOnAction(new EventoCerrar());
    }

    public Vista_Admin_Cursos getVista() {
        return vista;
    }

    private class EventoCerrar implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent t) {

            Controlador_Admin_Inicio controlador = null;
            
            controlador = new Controlador_Admin_Inicio();
                Vista vista = controlador.getVista();
                Singleton singleton
                        = Singleton.getSingleton();
                Stage stage = singleton.getStage();
                stage.setScene(vista.getScena());
                stage.setTitle("Nombre_Aplicacion");
                stage.show();
            
        }
    }

    private class EventoAñadirCursos implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent t) {
            Controlador_Adm_C_An controlador = null;
            
            controlador = new Controlador_Adm_C_An();
                Vista vista = controlador.getVista();
                Singleton singleton
                        = Singleton.getSingleton();
                Stage stage = singleton.getStage();
                stage.setScene(vista.getScena());
                stage.setTitle("Nombre_Aplicacion");
                stage.show();
            
        }
    }
    
    private class EventoEliminarCursos implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent t) {
            Controlador_Adm_C_E controlador = null;
            
            controlador = new Controlador_Adm_C_E();
                Vista vista = controlador.getVista();
                Singleton singleton
                        = Singleton.getSingleton();
                Stage stage = singleton.getStage();
                stage.setScene(vista.getScena());
                stage.setTitle("Nombre_Aplicacion");
                stage.show();

        }
    }

    private class EventoActualizarCursos implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent t) {
            Controlador_Adm_C_Ac controlador = null;
            
            controlador = new Controlador_Adm_C_Ac();
                Vista vista = controlador.getVista();
                Singleton singleton
                        = Singleton.getSingleton();
                Stage stage = singleton.getStage();
                stage.setScene(vista.getScena());
                stage.setTitle("Nombre_Aplicacion");
                stage.show();   
        }
    }

}