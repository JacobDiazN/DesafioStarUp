package cl.praxis.models.dto;

import java.sql.Timestamp;

public class Usuario {
    private int id;
    private String nick;
    private String nombre;
    private String password;
    private int peso;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Rol rol;

    // Constructores, getters y setters aquí

    // Constructor vacío
    public Usuario() {
    }

    // Constructor con todos los campos
    public Usuario(int id, String nick, String nombre, String password, int peso, Timestamp createdAt, Timestamp updatedAt) {
        this.id = id;
        this.nick = nick;
        this.nombre = nombre;
        this.password = password;
        this.peso = peso;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
    
    

    public Usuario(int id, String nick, String nombre, String password, int peso, Timestamp createdAt,
			Timestamp updatedAt, Rol rol) {
		super();
		this.id = id;
		this.nick = nick;
		this.nombre = nombre;
		this.password = password;
		this.peso = peso;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.rol = rol;
	}

	// Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
    
    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}
