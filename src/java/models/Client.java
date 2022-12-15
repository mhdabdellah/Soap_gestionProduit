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
public class Client {
    private int id;
    private String nom;
    private String prenom;
    private int age;
    private String telephone;

    public Client(int id, String nom, String prenom, int age, String telephone) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.telephone = telephone;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    

    public void setAge(int age) {
        this.age = age;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    

    public int getAge() {
        return age;
    }

    public String getTelephone() {
        return telephone;
    }
    
    
    
    
    
}
