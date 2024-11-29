package org.poliza;

import org.xml.sax.InputSource;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.StringBufferInputStream;
import java.util.Date;

public class Poliza {
    private String nombre;
    private String apellido;
    private String fumador;
    private Date fechaNacimiento;
    private String estadoCivil;

    public Poliza(String cadenaXml) {
        try {
            SAXParserFactory fabrica = SAXParserFactory.newInstance();
            SAXParser parser = fabrica.newSAXParser();
            InputSource fuente = new InputSource(new StringBufferInputStream(cadenaXml));
            parser.parse(fuente, new ManejadorDefectoPoliza(this));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void setNombre(String nombre) { this.nombre = nombre; }
    void setApellido(String apellido) { this.apellido = apellido; }
    void setFumador(String fumador) { this.fumador = fumador; }
    void setFechaNacimiento(Date fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }
    void setEstadoCivil(String estadoCivil) { this.estadoCivil = estadoCivil; }

    public String getNombre() { return this.nombre; }
    public Date getFechaNacimiento() { return this.fechaNacimiento; }
    public String getApellido() { return this.apellido; }
    public String getEstadoCivil() { return this.estadoCivil; }
    public String getFumador() { return this.fumador; }

    public void validar() {
        // Validar los datos.
    }

    public void guardar() {
        // Guardar los datos.
    }
}
