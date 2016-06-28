package dao;

import java.util.ArrayList;
import java.util.List;
import model.Cliente;
import persistence.ConnectionMySql;

public class ClienteDAO extends ConnectionMySql{

    //Metodo para insertar cliente
    public void cadastar(Cliente c) throws Exception{
        OpenDatabase();


        SQL = "INSERT INTO tb_cliente (nome, email, telefone, sexo, datanascimento)"
                + "VALUES(?,?,?,?,?)";
        ps = con.prepareStatement(SQL);
        ps.setString(1, c.getNome());
        ps.setString(2, c.getEmail());
        ps.setLong(3, c.getTel());
        ps.setString(4, Character.toString(c.getSexo()));
        ps.setDate(5, c.getDtnasc());
        ps.execute();
        CloseDatabase();
    }

    //Medoto para buscar cliente
    public Cliente buscaporId(Integer id)throws Exception{
        OpenDatabase();
        SQL = "SELECT * FROM tb_cliente WHERE id_cliente=?";
        ps = con.prepareStatement(SQL);
        ps.setInt(1, id);
        rs = ps.executeQuery();
        Cliente c = new Cliente();
        if(rs.next())
            c.setId(rs.getInt("id_cliente"));
            c.setNome(rs.getString("nome"));
            c.setEmail(rs.getString("email"));
            c.setTel(rs.getLong("telefone"));
            if(rs.getString("sexo")!=null)
                c.setSexo(rs.getString("sexo").charAt(0));
            c.setDtnasc(rs.getDate("datanascimento"));
        CloseDatabase();
        return c;
    }

    //Listar cliente
    public List<Cliente> listar() throws Exception{
        OpenDatabase();
        SQL = "SELECT * FROM tb_cliente ORDER BY nome";
        ps = con.prepareStatement(SQL);
        rs = ps.executeQuery();
        List<Cliente> listaClientes = new ArrayList<Cliente>();
        while(rs.next()){
            Cliente c = new Cliente();
            c.setId(rs.getInt("id_cliente"));
            c.setNome(rs.getString("nome"));
            c.setEmail(rs.getString("email"));
            c.setTel(rs.getLong("telefone"));
            if(rs.getString("sexo") != null){
               c.setSexo(rs.getString("sexo").charAt(0));
            }
            c.setDtnasc(rs.getDate("datanascimento"));
            listaClientes.add(c);
        }
        CloseDatabase();
        return listaClientes;
    }

    //Actualizar Cliente
    public void atualizar(Cliente c) throws Exception{
        OpenDatabase();
        SQL = "UPDATE tb_cliente SET nome=?, email=?, telefone=?, sexo=?, datanascimento=?"
            + "WHERE id_cliente=?";
        ps = con.prepareStatement(SQL);
        ps.setString(1, c.getNome());
        ps.setString(2, c.getEmail());
        ps.setLong(3, c.getTel());
        ps.setString(4, Character.toString(c.getSexo()));
        ps.setDate(5, new java.sql.Date(c.getDtnasc().getTime()));
        ps.setInt(6, c.getId());
        ps.execute();
        CloseDatabase();
    }
    
    //Eliminar cliente
    public void excluir(Integer id) throws Exception{
        OpenDatabase();
        SQL = "DELETE FROM tb_cliente WHERE id_cliente=?";
        ps = con.prepareStatement(SQL);
        ps.setInt(1, id);
        ps.execute();
        CloseDatabase();
    }
}