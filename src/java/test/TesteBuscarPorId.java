package test;

import dao.ClienteDAO;
import model.Cliente;

public class TesteBuscarPorId {
    public static void main(String[] args) throws Exception{
        ClienteDAO dao = new ClienteDAO();
        Cliente cliente = dao.buscaporId(1);

        System.out.println("Cod: " + cliente.getId());
        System.out.println("Nombre: " + cliente.getNome());
        System.out.println("Telefono: 0" + cliente.getTel());  //Inicio de parametro
        System.out.println("Email: " + cliente.getEmail());
        System.out.println("Sexo: " + cliente.getSexo());
        System.out.println("DN: " + cliente.getDtnasc());
    }
}