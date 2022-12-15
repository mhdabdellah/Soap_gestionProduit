/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webService;

import controllers.*;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import models.Client;
import models.Fournisseur;
import models.Produit;

/**
 *
 * @author chouaib
 */
@WebService(serviceName = "gestionProduitWebService")
public class gestionProduitWebService {

    ClientController clientController = new ClientController();
    FournisseurController fournisseurController = new FournisseurController();
    ProduitController produitController = new ProduitController();

    // afficher tous les etudiant
    @WebMethod(operationName = "findAllClient")
    public List<Client> findAllClients() {
        System.out.print("getALL client");
        try {
            return clientController.findAll();
        } catch (NullPointerException|SQLException ex) {
            Logger.getLogger(gestionProduitWebService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    // afficher tous les Fournisseurs
    @WebMethod(operationName = "findAllFournisseur")
    public List<Fournisseur> findAllFournisseur() {
        System.out.print("getALL Fournisseur");
        try {
            return fournisseurController.findAll();
        } catch (NullPointerException|SQLException ex) {
            Logger.getLogger(gestionProduitWebService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    // afficher tous les Produit
    @WebMethod(operationName = "findAllProduit")
    public List<Produit> findAllProduit() {
        System.out.print("getALL Produit");
        try {
            return produitController.findAll();
        } catch (NullPointerException|SQLException ex) {
            Logger.getLogger(gestionProduitWebService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
     //rechercher a un etudiant par son id
    @WebMethod(operationName = "findClientById")
    public Client findClientById(@WebParam(name = "id") int id) {
        try {
            return clientController.findById(id);
        } catch (SQLException ex) {
            Logger.getLogger(gestionProduitWebService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    //rechercher a un etudiant par son id
    @WebMethod(operationName = "findFournisseurById")
    public Fournisseur findFournisseurById(@WebParam(name = "id") int id) {
        try {
            return fournisseurController.findById(id);
        } catch (SQLException ex) {
            Logger.getLogger(gestionProduitWebService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    //rechercher a un etudiant par son id
    @WebMethod(operationName = "findProduitById")
    public Produit findById(@WebParam(name = "id") int id) {
        try {
            return produitController.findById(id);
        } catch (SQLException ex) {
            Logger.getLogger(gestionProduitWebService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    //Creer un nouveau etudiant
    @WebMethod(operationName = "createClient")
    public String createClient(@WebParam(name = "client") Client client) {
        try {
            if (clientController.create(client)) {
                return "Le Client " + client.getNom() + " est Cree.";
            }
            return "Erreur dans la creation d'un etudiant";
        } catch (SQLException ex) {
            Logger.getLogger(gestionProduitWebService.class.getName()).log(Level.SEVERE, null, ex);
            return "Erreur au niveau du requete";
        }
    }
    
    //Creer un nouveau etudiant
    @WebMethod(operationName = "createFournisseur")
    public String createFournisseur(@WebParam(name = "fournisseur") Fournisseur fournisseur) {
        try {
            if (fournisseurController.create(fournisseur)) {
                return "Le fournisseur " + fournisseur.getNom() + " est Cree.";
            }
            return "Erreur dans la creation d'un etudiant";
        } catch (SQLException ex) {
            Logger.getLogger(gestionProduitWebService.class.getName()).log(Level.SEVERE, null, ex);
            return "Erreur au niveau du requete";
        }
    }
    
    //Creer un nouveau etudiant
    @WebMethod(operationName = "createProduit")
    public String createProduit(@WebParam(name = "etudiant") Produit produit) {
        try {
            if (produitController.create(produit)) {
                return "Le produit " + produit.getNom() + " est Cree.";
            }
            return "Erreur dans la creation d'un etudiant";
        } catch (SQLException ex) {
            Logger.getLogger(gestionProduitWebService.class.getName()).log(Level.SEVERE, null, ex);
            return "Erreur au niveau du requete";
        }
    }

    //Modifier un etudiant
    @WebMethod(operationName = "updateClient")
    public Client updateClient(@WebParam(name = "client") Client client) {
        try {
            Client clientUpdated = null;
            if (clientController.update(client)) {
                clientUpdated = clientController.findById(client.getId());
            }
            return clientUpdated;
        } catch (SQLException ex) {
            Logger.getLogger(gestionProduitWebService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    //Modifier un etudiant
    @WebMethod(operationName = "updateFournisseur")
    public Fournisseur updateFournisseur(@WebParam(name = "fournisseur") Fournisseur fournisseur) {
        try {
            Fournisseur fournisseurUpdated = null;
            if (fournisseurController.update(fournisseur)) {
                fournisseurUpdated = fournisseurController.findById(fournisseur.getId());
            }
            return fournisseurUpdated;
        } catch (SQLException ex) {
            Logger.getLogger(gestionProduitWebService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    //Modifier un etudiant
    @WebMethod(operationName = "updateProduit")
    public Produit update(@WebParam(name = "produit") Produit produit) {
        try {
            Produit produitUpdated = null;
            if (produitController.update(produit)) {
                produitUpdated = produitController.findById(produit.getId());
            }
            return produitUpdated;
        } catch (SQLException ex) {
            Logger.getLogger(gestionProduitWebService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    //Supprimer un etudiant
    @WebMethod(operationName = "deleteClient")
    public String deleteClient(@WebParam(name = "id") int id) {
        try {
            String msg = "le client ne peut pas supprimer";
            if (clientController.delete(id)) {
                msg = "le client est Supprimee";
            }
            return msg;
        } catch (SQLException ex) {
            Logger.getLogger(gestionProduitWebService.class.getName()).log(Level.SEVERE, null, ex);
            return "Erreur au niveau de requete";
        }
    }
    
    //Supprimer un etudiant
    @WebMethod(operationName = "deleteFournisseur")
    public String deleteFournisseur(@WebParam(name = "id") int id) {
        try {
            String msg = "le fournisseur ne peut pas supprimer";
            if (fournisseurController.delete(id)) {
                msg = "le fournisseur est Supprimee";
            }
            return msg;
        } catch (SQLException ex) {
            Logger.getLogger(gestionProduitWebService.class.getName()).log(Level.SEVERE, null, ex);
            return "Erreur au niveau de requete";
        }
    }
    
    //Supprimer un etudiant
    @WebMethod(operationName = "deleteProduit")
    public String deleteProduit(@WebParam(name = "id") int id) {
        try {
            String msg = "le produit ne peut pas supprimer";
            if (produitController.delete(id)) {
                msg = "le produit est Supprimee";
            }
            return msg;
        } catch (SQLException ex) {
            Logger.getLogger(gestionProduitWebService.class.getName()).log(Level.SEVERE, null, ex);
            return "Erreur au niveau de requete";
        }
    }
}
