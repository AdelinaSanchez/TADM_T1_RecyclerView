package mx.edu.ittepic.tadm_t1_recyclerview;

/**
 * Created by adelina on 14/03/2018.
 */

public class Alumnos {

    private String nombre;
    private String info;
    private int foto;

    public Alumnos(String nombre, String info, int foto) {
        this.nombre = nombre;
        this.info = info;
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
