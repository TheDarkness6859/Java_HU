package com.corporate.talent.dao.impl;

import com.corporate.talent.dao.GenericDAO;
import com.corporate.talent.db.DatabaseConnection;
import com.corporate.talent.utils.LogManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class GenericDAOImpl<T> implements GenericDAO<T> {

    protected final DatabaseConnection dc = DatabaseConnection.getInstance();

    //Query Return:
    protected abstract T mapRow (ResultSet rs) throws SQLException;

    //Get Query:
    protected abstract String getSaveQuery ();
    protected abstract String getDeleteQuery ();
    protected abstract String getEditQuery ();
    protected abstract String getReadQuery ();
    protected abstract String getReadByIdQuery ();

    //Set Query:
    protected abstract String setSaveParams (PreparedStatement ps, T object) throws SQLException;
    protected abstract String setDeleteParams (PreparedStatement ps, long id) throws SQLException;
    protected abstract String setEditParams (PreparedStatement ps, T object) throws SQLException;
    protected abstract String setReadByIdParams (PreparedStatement ps, long id) throws SQLException;

    @Override
    public Optional<T> readId (long id) {

        try {

            Connection conn = dc.getConnection();

            try(PreparedStatement ps = conn.prepareStatement(getReadByIdQuery())){

                setReadByIdParams(ps, id);

                try(ResultSet rs = ps.executeQuery()){

                    if (rs.next()){

                        LogManager.addLog("INFO", "User " + id + " found correctly");
                        return Optional.of(mapRow(rs));

                    }else {

                        LogManager.addLog("WARNING", "User " + id + " don´t found in database");
                        return Optional.empty();

                    }

                }

            }

        }catch (SQLException err){

            LogManager.addLog("ERROR", "Failed to execute readId:" + err.getMessage());
            throw new RuntimeException("Database error: " + err);

        }

    }

    @Override
    public List<T> readAll () {

        List<T> users = new ArrayList<>();

        try {

            Connection conn = dc.getConnection();

            try (PreparedStatement ps = conn.prepareStatement(getReadQuery());
                 ResultSet rs = ps.executeQuery()){

                while (rs.next()){

                    users.add(mapRow(rs));

                }

                if (users.isEmpty()) {

                    LogManager.addLog("INFO", "getAll executed: No records found in database.");

                } else {

                    LogManager.addLog("INFO", "getAll executed: " + users.size() + " records retrieved.");

                }

            }


        }catch (SQLException err){

            LogManager.addLog("ERROR", "failed to execute readAll" + err.getMessage());
            throw new RuntimeException("Database error", err);

        }

        return users;

    }

    @Override
    public boolean delete (long id){

        try {

            Connection conn = dc.getConnection();


            try(PreparedStatement ps = conn.prepareStatement(getDeleteQuery())){

                setDeleteParams(ps, id);

                int rows = ps.executeUpdate();

                if (rows > 0){

                    LogManager.addLog("INFO", "User" + id + "Delete correctly");
                    return true;

                }else {

                    LogManager.addLog("WARNING", "The user cannot be delete" + id);
                    return false;

                }

            }

        }catch (SQLException err) {

            LogManager.addLog("ERROR", "Failed to execute delete: " + err.getMessage());
            throw new RuntimeException("Database error", err);

        }


    }

    @Override
    public boolean edit (T user){

        try{

            Connection conn = dc.getConnection();

            try(PreparedStatement ps = conn.prepareStatement(getEditQuery())){

                setEditParams(ps, user);

                int rows = ps.executeUpdate();

                if (rows > 0){

                    LogManager.addLog("INFO", "user updated correctly");
                    return true;

                }else {

                    LogManager.addLog("WARNING", "The user cannot be updated. Check if the ID exists.");
                    return false;

                }

            }

        }catch (SQLException err) {

            LogManager.addLog("ERROR", "failed to update: " + err.getMessage());
            throw new RuntimeException("Database error", err);

        }

    }
}
