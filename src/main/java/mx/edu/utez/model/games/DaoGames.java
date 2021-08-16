package mx.edu.utez.model.games;

import mx.edu.utez.model.category.BeanCategory;
import mx.edu.utez.service.ConnectionMySQL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class DaoGames {
    private Connection con;
    private CallableStatement cstm;
    private ResultSet rs;
    final Logger CONSOLE= LoggerFactory.getLogger(DaoGames.class);

    public List<BeanGames> findAll(){
        List<BeanGames> listGames = new ArrayList<>();
        try{
           con= ConnectionMySQL.getConnection() ;
           cstm= con.prepareCall("SELECT G.*,C.idCategory,C.name as 'Name_category',C.status as 'status_category' FROM games G INNER  JOIN  category C WHERE G.Category_idCategory=C.idCategory ");
           rs= cstm.executeQuery();


            while(rs.next()){
                BeanCategory beanCategory = new BeanCategory();
                BeanGames beanGames = new BeanGames();

                beanCategory.setIdCategory(rs.getInt("idCategory"));
                beanCategory.setName(rs.getString("Name_category"));
                beanCategory.setStatus(rs.getInt("status_category"));

                beanGames.setIdGames(rs.getInt("idGames"));
                beanGames.setName(rs.getString("name"));
                beanGames.setImgGame(Base64.getEncoder().encodeToString(rs.getBytes("imgGame")));
                beanGames.setDatePremiere(rs.getString("datePremiere"));
                beanGames.setStatus(rs.getInt("status"));
                beanGames.setCategory_idCategory(beanCategory);

                listGames.add(beanGames);
            }

        }catch (SQLException e){
            CONSOLE.error("Ha ocurrido un error: " + e.getMessage());

        }finally {
            ConnectionMySQL.closeConnections(con, cstm, rs);
        }
        return listGames;
    }

    public BeanGames findById (int idGames){
           BeanGames games = null;
        try {

            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("SELECT * FROM games AS G INNER JOIN category AS C ON G.Category_idCategory = C.idCategory WHERE G.idGames = ?");
            cstm.setInt(1, idGames);
            rs = cstm.executeQuery();

            if(rs.next()){
                BeanCategory category = new BeanCategory();
                games = new BeanGames();

                category.setIdCategory(rs.getInt("idCategory"));
                category.setName(rs.getString("name"));
                category.setStatus(rs.getInt("status"));

                games.setIdGames(rs.getInt("idGames"));
                games.setName(rs.getString("name"));
                byte[] imgBytes = rs.getBytes("imgGame");
                String photo = Base64.getEncoder().encodeToString(imgBytes);
                games.setDatePremiere(rs.getString("datePremiere"));
                games.setStatus(rs.getInt("status"));

                games.setCategory_idCategory(category);

            }
        }catch (SQLException e){
            CONSOLE.error("Ha ocurrido un error: " + e.getMessage());
        } finally {
            ConnectionMySQL.closeConnections(con, cstm, rs);
        }
        return games;
    }

    public boolean create(BeanGames games, InputStream image){
        boolean flag = false;
        try{
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("{call sp_create(?,?,?,?)}");
            cstm.setString(1, games.getName());
            cstm.setBlob(2,image);
            cstm.setString(3, games.getDatePremiere());
            cstm.setInt(4, games.getCategory_idCategory().getIdCategory());
            cstm.execute();
            flag = true;
        }catch(SQLException e){
            CONSOLE.error("Ha ocurrido un error: " + e.getMessage());
        } finally {
            ConnectionMySQL.closeConnections(con, cstm);
        }
        return flag;
    }

    public boolean update(BeanGames games){
        boolean flag = false;
        try{
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("{call sp_update(?,?,?,?,?,?}");
            cstm.setString(1, games.getName());
            cstm.setBytes(2, Base64.getDecoder().decode(games.getImgGame()));
            cstm.setString(3, games.getDatePremiere());
            cstm.setInt(4, games.getCategory_idCategory().getIdCategory());
            cstm.setInt(5,games.getIdGames());

            flag = cstm.execute();
        }catch(SQLException e){
            CONSOLE.error("Ha ocurrido un error: " + e.getMessage());
        }finally{
            ConnectionMySQL.closeConnections(con, cstm);
        }
        return flag;
    }

    public boolean delete(int idGames){
        boolean flag = false;
        try{
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("{call sp_delete(?)}");
            cstm.setInt(1, idGames);

            flag = cstm.execute();
        }catch(SQLException e){
            CONSOLE.error("Ha ocurrido un error: " + e.getMessage());
        }finally{
            ConnectionMySQL.closeConnections(con, cstm);
        }
        return flag;
    }

}

