/**
 * Created by Paca on 3/21/14.
 */
public class Auto {
        String patente;
        String marca;
        String modelo;
        String color;

        public Auto(String patente, String marca, String modelo, String color) {
            this.patente = patente;
            this.marca = marca;
            this.modelo = modelo;
            this.color = color;
        }

        public String getPatente() {
            return patente;
        }

        public void setPatente(String patente) {
            this.patente = patente;
        }

        public String getMarca() {
            return marca;
        }

        public String getModelo() {
            return modelo;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }
}

