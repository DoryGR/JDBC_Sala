import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class db {

	private static Connection conexao;
	
	public static Properties getPropriedades() throws IOException {
		
		Properties propriedades = new Properties();
		FileInputStream file = new FileInputStream("./properties/db.properties");
		
		propriedades.load(file);
		
		return propriedades;
	}
	
	public static Connection getConexao() throws SQLException, IOException {
		String host;
		String user;
		String password;
		
		Properties propriedade = db.getPropriedades();
		
		host = propriedade.getProperty("host");
		user = propriedade.getProperty("user");
		password = propriedade.getProperty("password");
		
		conexao = DriverManager.getConnection(host, user, password);
		
		return conexao;
	}

	public static void CloseConnection() throws SQLException {
		
		if (conexao != null) {
			conexao.close();
		}
		
	}
}
