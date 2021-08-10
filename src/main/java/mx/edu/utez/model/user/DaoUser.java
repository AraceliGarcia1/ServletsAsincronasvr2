package mx.edu.utez.model.user;

import mx.edu.utez.model.games.DaoGames;
import mx.edu.utez.service.ConnectionMySQL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoUser {

    private Connection con; //conneccion base de datos
    private CallableStatement cstm; //permite ejecutar procedimientos almacenados
    private ResultSet rs; //
    final Logger CONSOLE= LoggerFactory.getLogger(DaoGames.class); //impresion en consola

    //saber si existe el usuario y credenciales correctas
    public boolean createSession(String email, String password){
        boolean flag=false;
        try{
            con= ConnectionMySQL.getConnection();
            cstm=con.prepareCall("SELECT *FROM user WHERE email = ? AND password = ?");
            cstm.setString(1,email);
            cstm.setString(2,password);
            rs=cstm.executeQuery();

            if(rs.next()) flag=true;    //el if se puede poner sin llaves por que solo hay una linea despues a ejecutar

        }catch (SQLException e){
            CONSOLE.error("Ha ocurrido un error" + e.getMessage());
        }finally {
         //cierre de conneciones
            ConnectionMySQL.closeConnections(con,cstm,rs);
        }
        return flag;
    }
}
