package pe.edu.usil.model;

import java.io.Serializable;

public class Usuario implements Serializable {
    private Long id;
    private String nombreCompleto;
    private String correo;
    private String password;

    public Usuario() {}

    public static class Builder {
        private Long id;
        private String nombreCompleto;
        private String correo;
        private String password;

        public Builder id(Long id) { this.id = id; return this; }
        public Builder nombreCompleto(String nombreCompleto) { this.nombreCompleto = nombreCompleto; return this; }
        public Builder correo(String correo) { this.correo = correo; return this; }
        public Builder password(String password) { this.password = password; return this; }
        public Usuario build() {
            Usuario u = new Usuario();
            u.id = id;
            u.nombreCompleto = nombreCompleto;
            u.correo = correo;
            u.password = password;
            return u;
        }
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombreCompleto() { return nombreCompleto; }
    public void setNombreCompleto(String nombreCompleto) { this.nombreCompleto = nombreCompleto; }
    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}