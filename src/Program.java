import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program {

	public static void main(String[] args) throws SQLException, IOException {
		
		Connection con = db.getConexao();
		System.out.println("*** Conexão Realizada com Sucesso! ***");
		
		
		Aluno a = new Aluno("Ana Laura", "Feminino", Date.valueOf("2013-12-17"));
		
		// Inserindo um registro
		String sql = "INSERT INTO aluno (nome, sexo, dt_nasc) VALUES ( ?, ?, ?)";
		
		PreparedStatement pst = con.prepareStatement(sql);
		
		pst.setString( 1, a.getNome() );
		pst.setString( 2, a.getSexo() );
		pst.setDate( 3, a.getDt_nasc() );
		
		pst.execute();
		
		// Consultando os dados
		String sql2 = "SELECT * FROM aluno";
		
		Statement st = con.createStatement();
		
		ResultSet rs = st.executeQuery(sql2);
		
		while (rs.next()){
			System.out.println( rs.getInt("id") + " " + 
		                        rs.getString(2) + " " + 
					            rs.getString(3)
		                      );
		}
		
		//fechando os recursos
		rs.close();
		st.close();
		db.CloseConnection();
		System.out.println("*** Conexão Encerrada ! ***");
	}

}
