/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package psv;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarroDAO {

    private final Connection con;

    public CarroDAO(Connection con) {
        this.con = con;
    }

    // Inserir um carro
    public void inserir(CarroBean carro) throws SQLException {

        String sql = "INSERT INTO carro (placa, cor, descricao) "
                   + "VALUES (?, ?, ?)";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, carro.getPlaca());
            stmt.setString(2, carro.getCor());
            stmt.setString(3, carro.getDescricao());

            stmt.executeUpdate();
        }
    }

    // Alterar os dados de um carro
    public void alterar(CarroBean carro) throws SQLException {

        String sql = "UPDATE carro SET cor = ?, descricao = ? "
                   + "WHERE placa = ?";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, carro.getCor());
            stmt.setString(2, carro.getDescricao());
            stmt.setString(3, carro.getPlaca());

            stmt.executeUpdate();
        }
    }

    // Excluir um carro pela placa
    public void excluir(String placa) throws SQLException {

        String sql = "DELETE FROM carro WHERE placa = ?";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, placa);

            stmt.executeUpdate();
        }
    }

    // Listar todos os carros cadastrados
    public List<CarroBean> listarTodos() throws SQLException {

        List<CarroBean> carros = new ArrayList<>();

        String sql = "SELECT placa, cor, descricao FROM carro";

        try (PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                CarroBean carro = new CarroBean();

                carro.setPlaca(rs.getString("placa"));
                carro.setCor(rs.getString("cor"));
                carro.setDescricao(rs.getString("descricao"));

                carros.add(carro);
            }
        }

        return carros;
    }
}

