package com.monaco.contatti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author Girolamo Monacò
 */

@Entity
@Table(name = "contatti")
public class Contatti {

    private long id;
    private String nome;
    private String email;
    private String telefono;
    private String indirizzo;
    private String note;
    private String latitudine;
    private String longitudine;

    public Contatti() {
    }

    public Contatti(long id, String nome, String email, String telefono,
                    String indirizzo, String note, String latitudine,
                    String longitudine) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefono = telefono;
        this.indirizzo = indirizzo;
        this.note = note;
        this.latitudine = latitudine;
        this.longitudine = longitudine;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "nome", nullable = false)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Column(name = "email", nullable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "telefono", nullable = false)
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Column(name = "indirizzo", nullable = false)
    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    @Column(name = "note", nullable = false)
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Column(name = "latitudine", nullable = false)
    public String getLatitudine() {
        return latitudine;
    }

    public void setLatitudine(String latitudine) {
        this.latitudine = latitudine;
    }

    @Column(name = "longitudine", nullable = false)
    public String getLongitudine() {
        return longitudine;
    }

    public void setLongitudine(String longitudine) {
        this.longitudine = longitudine;
    }
}
