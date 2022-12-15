///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
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
import models.Client;

public class ClientController extends DBConnection {

    //    DBConnection  dbConnection = new DBConnection();
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    //Obtener todos los clientes de la base de datos
    public List<Client> findAll() throws SQLException {
        try {
            String sql = "SELECT * FROM client";
            List<Client> listClients = new ArrayList<>();

            con = conector();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Client client = new Client(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5));

                listClients.add(client);
            }
            return listClients;
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
    public Client findById(int id_client) throws SQLException {
        try {
            String sql = "SELECT * FROM client WHERE id = " + id_client + "";

            Client client = null;

            con = conector();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                client = new Client(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5));

            }

            return client;
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
    public boolean create(Client client) throws SQLException {
        try {
            String sql = "INSERT INTO client VALUES(null, ?, ?, ?,?)";

            boolean inseree = false;

            con = conector();

            ps = con.prepareStatement(sql);
            ps.setString(1, client.getNom());
            ps.setString(2, client.getPrenom());
            ps.setInt(3, client.getAge());
            ps.setString(4, client.getTelephone());

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
    public boolean update(Client client) throws SQLException {
        try {
            String sql = "UPDATE client SET nom = ?, prenom = ?, age = ?,telephone = ? WHERE id = ?";

            boolean respuesta = false;

            con = conector();

            ps = con.prepareStatement(sql);
            ps.setString(1, client.getNom());
            ps.setString(2, client.getPrenom());
            ps.setInt(3, client.getAge());
            ps.setString(4, client.getTelephone());
            ps.setInt(5, client.getId());

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
    public boolean delete(int id_client) throws SQLException {
        try {
            String sql = "DELETE FROM client WHERE id = " + id_client + "";

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