package uy.yodono.Entidades;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;

import java.util.Date;
import java.util.List;

//Creo la entidad(Tabla) Solicitudes
@Entity
public class Solicitudes {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String hospital;
    private String grupo_Sanguineo;
    private Date fecha_Limite;
    private String motivo;
    private int cantidad_Donantes;
    private String departamento;
    private String Ci_Don;

    //Getters and Setters
    public int getId() {
        return id;
    }
    public String getCi_Don() {
        return Ci_Don;
    }
    public void setCi_Don(String ci_Don) {
        Ci_Don = ci_Don;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getHospital() {
        return hospital;
    }
    public void setHospital(String hospital) {
        this.hospital = hospital;
    }
    public String getGrupo_Sanguineo() {
        return grupo_Sanguineo;
    }
    public void setGrupo_Sanguineo(String grupo_Sanguineo) {
        this.grupo_Sanguineo = grupo_Sanguineo;
    }
    public Date getFecha_Limite() {
        return fecha_Limite;
    }
    public void setFecha_Limite(Date fecha_Limite) {
        this.fecha_Limite = fecha_Limite;
    }
    public String getMotivo() {
        return motivo;
    }
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
    public int getCantidad_Donantes() {
        return cantidad_Donantes;
    }
    public void setCantidad_Donantes(int cantidad_Donantes) {
        this.cantidad_Donantes = cantidad_Donantes;
    }
    public String getDepartamento() {
        return departamento;
    }
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

}
