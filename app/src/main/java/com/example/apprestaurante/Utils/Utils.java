package com.example.apprestaurante.Utils;

public class Utils {
    private static String TipoUsuario;
    private static int idUsuario;

    private static Utils instance;

    private Utils () {

    }
    public static Utils getInstance() {
        if (instance == null) {
            instance = new Utils();
        }
        return instance;
    }

    public String getTipoUsuario () {
        return TipoUsuario;
    }

    public void setTipoUsuario (String tipoU) {
        this.TipoUsuario = tipoU;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

}
