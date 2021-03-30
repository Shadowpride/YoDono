package uy.yodono.Entidades;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

//Creo la entidad(Tabla) Donantes
// M.N: implemento Serializable para poder pasar la instancia como parámetro de un intent
@Entity
public class Donantes implements Serializable {

    @PrimaryKey // Selecciono CI como Primary key
    @NonNull
    private int ci;
    private String passwd;
    private String email;
    private String nombre;
    private String apellido;
    private int telefono;
    private String departamento;

    public String getGrupo_sanguineo() {
        return grupo_sanguineo;
    }

    private String grupo_sanguineo;


    public Donantes( int ci, String passwd, String email, String nombre, String apellido, int telefono, String departamento, String grupo_sanguineo ) {
        this.ci = ci;
        this.passwd = passwd;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.departamento = departamento;
        this.grupo_sanguineo = grupo_sanguineo;
    }


    //Getters and Setters

    public int getCi() {
        return ci;
    }
    public void setCi(int ci) {
        this.ci = ci;
    }
    public String getPasswd() {
        return passwd;
    }
    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public int getTelefono() {
        return telefono;
    }
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    public String getDepartamento() {
        return departamento;
    }
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
    public String getGrupo_Sanguineo() {
        return grupo_sanguineo;
    }
    public void setGrupo_Sanguineo(String grupo_Sanguineo) {
        this.grupo_sanguineo = grupo_Sanguineo;
    }
}
