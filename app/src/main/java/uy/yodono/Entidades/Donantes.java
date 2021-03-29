package uy.yodono.Entidades;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

//Creo la entidad(Tabla) Donantes
@Entity
public class Donantes {

    @PrimaryKey // Selecciono CI como Primary key
    @NonNull
    private int ci;
    private String passwd;
    private String email;
    private String nombre;
    private String apellido;
    private int telefono;
    private String departamento;
    private String grupo_Sanguineo;

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
        return grupo_Sanguineo;
    }
    public void setGrupo_Sanguineo(String grupo_Sanguineo) {
        this.grupo_Sanguineo = grupo_Sanguineo;
    }
}
