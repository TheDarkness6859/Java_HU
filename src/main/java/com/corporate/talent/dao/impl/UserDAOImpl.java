package com.corporate.talent.dao.impl;

import com.corporate.talent.models.Developer;
import com.corporate.talent.models.Employable;
import com.corporate.talent.models.Manager;
import com.corporate.talent.models.Person;
import com.corporate.talent.utils.LogManager;

import java.sql.*;

public class UserDAOImpl extends GenericDAOImpl<Person>{

    protected static final String SAVE = "INSERT INTO empleados (nombre, edad, oficina, salario, genero, bonus, puntaje_test, activo, cant_idiomas, rol, lenguaje_principal, presupuesto_mensual) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

    protected static final String DELETE = "DELETE FROM empleados WHERE id = ?;";

    protected static final String UPDATE = "UPDATE empleados SET nombre = ?, edad = ?, oficina = ?, salario = ?, genero = ?, bonus = ?, puntaje_test = ?, activo = ?, cant_idiomas = ?, rol = ?, lenguaje_principal = ?, presupuesto_mensual = ? WHERE id = ?;";

    protected static final String FIND = "SELECT * FROM empleados;";

    protected static final String FINDBY = "SELECT * FROM empleados WHERE id = ?;";

    protected Employable mapRow(ResultSet rs) throws SQLException {

        long id = rs.getLong("id");
        String name = rs.getString("nombre");
        byte age = rs.getByte("edad");
        short office = rs.getShort("oficina");
        double salary = rs.getDouble("salario");
        char gender = rs.getString("genero").charAt(0);
        float bonus = rs.getFloat("bonus");
        byte score = rs.getByte("puntaje_test");
        boolean active = rs.getBoolean("activo");
        int languages = rs.getInt("cant_idiomas");
        String role = rs.getString("rol");

        if ("DEVELOPER".equalsIgnoreCase(role)) {

            return new Developer(
                    id, age, office, salary, gender, bonus, active, languages, name, score,
                    rs.getString("lenguaje_principal")
            );

        } else {

            return new Manager(
                    id, age, office, salary, gender, bonus, active, languages, name, score,
                    rs.getDouble("presupuesto_mensual")
            );

        }

    }

    @Override
    public boolean save (Person p) {

        try {

            Connection conn = dc.getConnection();

            try(PreparedStatement ps = conn.prepareStatement(SAVE, Statement.RETURN_GENERATED_KEYS)){

                setSaveParams(ps, p);

                int rows = ps.executeUpdate();

                if (rows > 0){

                    try (ResultSet rs = ps.getGeneratedKeys()) {

                        if (rs.next()) {

                            LogManager.addLog("INFO", "User save correctly in database");
                            p.setId(rs.getLong(1));
                            return true;

                        }

                    }

                }

                LogManager.addLog("WARNING", "User cannot be saved in database");
                return false;

            }

        }catch (SQLException err) {

            LogManager.addLog("ERROR", "failed to execute save" + err.getMessage());
            return false;

        }

    }

    @Override
    protected String getSaveQuery () {return SAVE;}

    @Override
    protected String getDeleteQuery () {return DELETE;}

    @Override
    protected String getEditQuery () {return UPDATE;}

    @Override
    protected String getReadByIdQuery () {return FINDBY;}

    @Override
    protected String getReadQuery () {return FIND;}

    @Override
    protected void setSaveParams(PreparedStatement ps, Person p) throws SQLException {

        if (p instanceof Employable emp) {

            ps.setString(1, emp.getFullName());
            ps.setByte(2, emp.getAge());
            ps.setShort(3, emp.getOffice());
            ps.setDouble(4, emp.getSalary());
            ps.setString(5, String.valueOf(emp.getGender()));
            ps.setFloat(6, emp.getBonus());
            ps.setByte(7, emp.getTestPoint());
            ps.setBoolean(8, emp.isActive());
            ps.setInt(9, emp.getLanguageQuantity());

            if (emp instanceof Developer dev) {

                ps.setString(10, "DEVELOPER");
                ps.setString(11, dev.getMainLanguage());
                ps.setNull(12, java.sql.Types.DOUBLE);

            } else if (emp instanceof Manager man) {

                ps.setString(10, "MANAGER");
                ps.setNull(11, java.sql.Types.VARCHAR);
                ps.setDouble(12, man.getMonthlyBudget());

            }

        }

    }

    @Override
    protected void setEditParams(PreparedStatement ps, Person p) throws SQLException {

        setSaveParams(ps, p);

        if (p instanceof Employable emp) {

            ps.setLong(13, emp.getId());

        }

    }

    @Override
    protected void setDeleteParams(PreparedStatement ps, long id) throws SQLException {
        ps.setLong(1, id);
    }

    @Override
    protected void setReadByIdParams (PreparedStatement ps, long id) throws SQLException {
        ps.setLong(1, id);
    }

}
