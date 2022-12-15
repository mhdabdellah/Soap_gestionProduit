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
public class Produit {
    
    private int id;
    private String nom;
    private String type;
    private int quantite;
    private int id_fournisseur;
    private int id_client;

    public Produit(int id, String nom, String type, int quantite, int id_fournisseur, int id_client) {
        this.id = id;
        this.nom = nom;
        this.type = type;
        this.quantite = quantite;
        this.id_fournisseur = id_fournisseur;
        this.id_client = id_client;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getType() {
        return type;
    }

    public int getQuantite() {
        return quantite;
    }

    public int getId_fournisseur() {
        return id_fournisseur;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void setId_fournisseur(int id_fournisseur) {
        this.id_fournisseur = id_fournisseur;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }
    
    
    
}
