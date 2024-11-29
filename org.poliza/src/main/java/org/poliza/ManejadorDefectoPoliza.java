package org.poliza;

import java.util.Calendar;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.*;

class ManejadorDefectoPoliza extends DefaultHandler {

    private Poliza poliza;
    private String atributo;

    public ManejadorDefectoPoliza(Poliza poliza) {
        this.poliza = poliza;
    }

    @Override
    public void characters(char[] ch, int inicio, int tamanho) {
        String elemento = new String(ch, inicio, tamanho);
        this.setAtributoPoliza(elemento);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        this.atributo = qName;
    }

    private void setAtributoPoliza(String valor) {
        if (this.atributo.equals("nombre")) {
            poliza.setNombre(valor);
        } else if (this.atributo.equals("apellido")) {
            poliza.setApellido(valor);
        } else if (this.atributo.equals("fechaNacimiento")) {
            Calendar cal = Calendar.getInstance();
            int mes = Integer.parseInt(valor.substring(0, 2));
            int dia = Integer.parseInt(valor.substring(3, 5));
            int anho = Integer.parseInt(valor.substring(6, 10));
            cal.set(anho, mes - 1, dia);
            poliza.setFechaNacimiento(cal.getTime());
        } else if (this.atributo.equals("fumador")) {
            poliza.setFumador(valor);
        } else if (this.atributo.equals("estadoCivil")) {
            poliza.setEstadoCivil(valor);
        }
    }

}
