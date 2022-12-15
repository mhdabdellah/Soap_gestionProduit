/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import connection.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Produit;

/**
 *
 * @author chouaib
 */
public class ProduitController extends DBConnection{
    
    //    DBConnection  dbConnection = new DBConnection();
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    //Obtener todos los clientes de la base de datos
    public List<Produit> findAll() throws SQLException {
        try {
            String sql = "SELECT * FROM produit";
            List<Produit> listProduits = new ArrayList<>();

            con = conector();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Produit produit = new Produit(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getInt(6)
                );

                listProduits.add(produit);
            }
            return listProduits;
        } catch (SQLException ex) {
            Logger.getLogger(ClientController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            rs.close();
            ps.close();
            con.close();
        }
    }

    //Obtener un cliente por su id
    public Produit findById(int id_produit) throws SQLException {
        try {
            String sql = "SELECT * FROM produit WHERE id = " + id_produit + "";

            Produit produit = null;

            con = conector();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                produit = new Produit(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getInt(6));

            }

            return produit;
        } catch (SQLException ex) {
            Logger.getLogger(ClientController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            rs.close();
            ps.close();
            con.close();
        }
    }

    //Crear un nuevo cliente
    public boolean create(Produit produit) throws SQLException {
        try {
            String sql = "INSERT INTO produit VALUES(null, ?, ?, ?,?, ?)";

            boolean inseree = false;

            con = conector();

            ps = con.prepareStatement(sql);
            ps.setString(1, produit.getNom());
            ps.setString(2, produit.getType());
            ps.setInt(3, produit.getQuantite());
            ps.setInt(4, produit.getId_client());
            ps.setInt(5, produit.getId_fournisseur());

            if (ps.executeUpdate() == 1) {
                inseree = true;
            }

            return inseree;
        } catch (SQLException ex) {
            Logger.getLogger(ClientController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ps.close();
            con.close();
        }
    }

    //Actualizar un cliente por su id
    public boolean update(Produit produit) throws SQLException {
        try {
            String sql = "UPDATE produit SET nom = ?, type = ?, quantite = ?,idclient = ?, idfournisseur = ? WHERE id = ?";

            boolean respuesta = false;

            con = conector();

            ps = con.prepareStatement(sql);
            ps.setString(1, produit.getNom());
            ps.setString(2, produit.getType());
            ps.setInt(3, produit.getQuantite());
            ps.setInt(4, produit.getId_client());
            ps.setInt(5, produit.getId_fournisseur());
            ps.setInt(6, produit.getId());

            if (ps.executeUpdate() == 1) {
                respuesta = true;
            }

            return respuesta;
        } catch (SQLException ex) {
            Logger.getLogger(ClientController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ps.close();
            con.close();
        }
    }

    //Eliminar un cliente por su id
    public boolean delete(int id_produit) throws SQLException {
        try {
            String sql = "DELETE FROM produit WHERE id = " + id_produit + "";

            boolean respuesta = false;

            con = conector();
            ps = con.prepareStatement(sql);

            if (ps.executeUpdate() == 1) {
                respuesta = true;
            }

            return respuesta;
        } catch (SQLException ex) {
            Logger.getLogger(ClientController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ps.close();
            con.close();
        }
    }

    
}
