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
import models.Fournisseur;

/**
 *
 * @author chouaib
 */
public class FournisseurController extends DBConnection{
    
    //    DBConnection  dbConnection = new DBConnection();
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    //Obtener todos los clientes de la base de datos
    public List<Fournisseur> findAll() throws SQLException {
        try {
            String sql = "SELECT * FROM fournisseur";
            List<Fournisseur> listFournisseur = new ArrayList<>();

            con = conector();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Fournisseur fournisseur = new Fournisseur(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5));

                listFournisseur.add(fournisseur);
            }
            return listFournisseur;
        } catch (SQLException ex) {
            Logger.getLogger(FournisseurController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            rs.close();
            ps.close();
            con.close();
        }
    }

    //Obtener un cliente por su id
    public Fournisseur findById(int id_fournisseur) throws SQLException {
        try {
            String sql = "SELECT * FROM fournisseur WHERE id = " + id_fournisseur + "";

            Fournisseur fournisseur = null;

            con = conector();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                fournisseur = new Fournisseur(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5));

            }

            return fournisseur;
        } catch (SQLException ex) {
            Logger.getLogger(FournisseurController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            rs.close();
            ps.close();
            con.close();
        }
    }

    //Crear un nuevo cliente
    public boolean create(Fournisseur fournisseur) throws SQLException {
        try {
            String sql = "INSERT INTO fournisseur VALUES(null, ?, ?, ?,?)";

            boolean inseree = false;

            con = conector();

            ps = con.prepareStatement(sql);
            ps.setString(1, fournisseur.getNom());
            ps.setString(2, fournisseur.getDommain());
            ps.setString(3, fournisseur.getAddress());
            ps.setString(4, fournisseur.getTelephone());

            if (ps.executeUpdate() == 1) {
                inseree = true;
            }

            return inseree;
        } catch (SQLException ex) {
            Logger.getLogger(FournisseurController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ps.close();
            con.close();
        }
    }

    //Actualizar un cliente por su id
    public boolean update(Fournisseur fournisseur) throws SQLException {
        try {
            String sql = "UPDATE fournisseur SET nom = ?, dommain = ?, address = ?,telephone = ? WHERE id = ?";

            boolean respuesta = false;

            con = conector();

            ps = con.prepareStatement(sql);
            ps.setString(1, fournisseur.getNom());
            ps.setString(2, fournisseur.getDommain());
            ps.setString(3, fournisseur.getAddress());
            ps.setString(4, fournisseur.getTelephone());
            ps.setInt(5, fournisseur.getId());

            if (ps.executeUpdate() == 1) {
                respuesta = true;
            }

            return respuesta;
        } catch (SQLException ex) {
            Logger.getLogger(FournisseurController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ps.close();
            con.close();
        }
    }

    //Eliminar un cliente por su id
    public boolean delete(int id_fournisseur) throws SQLException {
        try {
            String sql = "DELETE FROM fournisseur WHERE id = " + id_fournisseur + "";

            boolean respuesta = false;

            con = conector();
            ps = con.prepareStatement(sql);

            if (ps.executeUpdate() == 1) {
                respuesta = true;
            }

            return respuesta;
        } catch (SQLException ex) {
            Logger.getLogger(FournisseurController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ps.close();
            con.close();
        }
    }

    
}
