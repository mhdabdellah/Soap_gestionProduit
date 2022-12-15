/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author chouaib
 */
public class Fournisseur {
    private int id;
    private String nom;
    private String dommain;
    private String address;
    private String telephone;

    public Fournisseur(int id, String nom, String dommain, String address, String telephone) {
        this.id = id;
        this.nom = nom;
        this.dommain = dommain;
        this.address = address;
        this.telephone = telephone;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getDommain() {
        return dommain;
    }

    public String getAddress() {
        return address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDommain(String dommain) {
        this.dommain = dommain;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    
    
    
    
    
}
