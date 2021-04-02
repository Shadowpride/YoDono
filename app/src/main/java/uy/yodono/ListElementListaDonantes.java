package uy.yodono;

public class ListElementListaDonantes {
    /*BuscarDonantes = BD */
    public String bdname;
    public String bdgrupo;
    public String bddepartamento;

    public ListElementListaDonantes(String bdname, String bdgrupo, String bddepartamento) {
        this.bdname = bdname;
        this.bdgrupo = bdgrupo;
        this.bddepartamento = bddepartamento;
    }

    public String getBdname() {
        return bdname;
    }

    public void setBdname(String bdname) {
        this.bdname = bdname;
    }

    public String getBdgrupo() {
        return bdgrupo;
    }

    public void setBdgrupo(String bdgrupo) {
        this.bdgrupo = bdgrupo;
    }

    public String getBddepartamento() {
        return bddepartamento;
    }

    public void setBddepartamento(String bddepartamento) {
        this.bddepartamento = bddepartamento;
    }
}
