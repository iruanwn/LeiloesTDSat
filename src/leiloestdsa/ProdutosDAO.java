/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package leiloestdsa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Ruan
 */
public class ProdutosDAO {
    Connection conn = new conectaDAO().connectDB();
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    
     public void cadastrarProduto (ProdutosDTO produto){
        try {
            prep = conn.prepareStatement("insert into produtos values(?,?,?,?)");
            prep.setInt(1, produto.getId());
            prep.setString(2, produto.getNome());
            prep.setInt(3, produto.getValor());
            prep.setString(4,produto.getStatus());
            prep.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cadastro feito com sucesso");

        } catch (SQLException ex) {
            Logger.getLogger(ProdutosDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao fazer o cadastro");
        }
        
    }
     
      public List<ProdutosDTO> getProdutos() {
                
                try {
                    PreparedStatement ps = conn.prepareStatement("SELECT * FROM produtos");
                    ResultSet rs = ps.executeQuery();            
                    
                    List<ProdutosDTO> listaProdutos = new ArrayList<>();
                    
                    while (rs.next()) {
                        ProdutosDTO produto = new ProdutosDTO();
                        produto.setId(rs.getInt("id"));
                        produto.setNome(rs.getString("nome"));
                        produto.setStatus(rs.getString("status"));
                        produto.setValor(rs.getInt("valor"));
                        
                        
                        listaProdutos.add(produto);    
                    }
                    return listaProdutos;
                    
                } catch (Exception e) {
                    return null;
                }
      }     
      
          public void venderProduto(int id){
        try {
            prep = conn.prepareStatement("update produtos set status = 'vendido' where id = ?");
            prep.setInt(1, id);
            prep.executeUpdate();
            JOptionPane.showMessageDialog(null, "Produto vendido com sucesso");
        } catch (SQLException ex) {
            Logger.getLogger(ProdutosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         
     } 
        
      public List<ProdutosDTO> listarProdutosVendidos() {
                
                try {
                    PreparedStatement ps = conn.prepareStatement("SELECT * FROM produtos WHERE status LIKE 'vendido'");
                    ResultSet rs = ps.executeQuery();            
                    
                    List<ProdutosDTO> listaProdutos = new ArrayList<>();
                    
                    while (rs.next()) { //.next retorna verdadeiro caso exista uma próxima posição dentro do array
                        ProdutosDTO produto = new ProdutosDTO();
                        produto.setId(rs.getInt("id"));
                        produto.setNome(rs.getString("nome"));
                        produto.setStatus(rs.getString("status"));
                        produto.setValor(rs.getInt("valor"));
                        
                        
                        listaProdutos.add(produto);    
                    }
                    return listaProdutos;
                    
                } catch (Exception e) {
                    return null;
                }
            }
}
   
