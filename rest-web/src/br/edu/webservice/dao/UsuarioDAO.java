package br.edu.webservice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.webservice.config.DatabaseConfig;
import br.edu.webservice.util.CriptoUtil;

public class UsuarioDAO {
	
	public boolean isLoggedIn(String usuario, String senha) throws Exception {
		Connection conexao;
		conexao = DatabaseConfig.getInstancia().getConection();
		String sql = "SELECT USUARIO, SENHA FROM TB_USUARIO WHERE USUARIO = ? AND SENHA = ?";
		PreparedStatement statement = conexao.prepareStatement(sql);
		statement.setString(1, usuario);
		statement.setString(2, CriptoUtil.criptoStringMD5(senha));
		ResultSet res  =statement.executeQuery();
		return res.next();
		
		
	}
	
	public static void main(String[] args) {
		try {
			System.out.println(new UsuarioDAO().isLoggedIn("admin", "admin"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
