package Persistencia;
import Datos.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author dorianivc
 */
public class DBQuerys {
    public RDS db=null;
    
   public DBQuerys(){
    db= new RDS();    
    }
   
   public int executeUpdate(String statement) {
        try {
            Statement stm = db.conexion.createStatement();
            stm.executeUpdate(statement);
            return stm.getUpdateCount();
        } catch (SQLException ex) {
            return 0;
        }
    }
   
   public void crer_usuario(Usuario user) throws Exception{
         String sql = "insert into Banco.Usuario values('%s','%s','%s','%s')";
       
        sql = String.format(sql,user.getCedula(), user.getNombre(),user.getPassword(), user.getTipoUsuario());

        int count = executeUpdate(sql);
        if (count == 0) {
            throw new Exception("Error al crear usuario");
        }
   }
   
   
   public void obtener_usuarios() throws SQLException {
        Connection conn = db.conexion;
        Statement statement = null;
        try {

            System.out.println("Creating statement...");
            statement = conn.createStatement();
            String sql;
            sql = "select * from Aerolinea.Pais; ";
            //STEP 5: Extract data from result set
            try (ResultSet rs = statement.executeQuery(sql)) {
                //STEP 5: Extract data from result set
                while (rs.next()) {
                    //Retrieve by column name
                    String atributo = rs.getString("nombre");
                    String atributo2 = rs.getString("cedula");
                    //Display values
                    System.out.println("Informacion Usuario de la base de datos en AWS--> " + "Nombre: " + atributo + " cedula : " + atributo2);
                }
                //STEP 6: Clean-up environment
            }
            statement.close();
            conn.close();
        } catch (SQLException se) {
            //Handle errors for JDBC

        } catch (Exception e) {
            //Handle errors for Class.forName

        } finally {
            //finally block used to close resources
            if (statement != null) {
                statement.close();
            } // nothing we can do
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
            }//end finally try
        }//end try
    }
   
}
