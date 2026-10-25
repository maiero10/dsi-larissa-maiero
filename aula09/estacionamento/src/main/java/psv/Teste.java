/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Camargo
 */

package psv;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Teste {

    public static void main(String[] args) {

        try (Connection con = Conexao.abrirConexao()) {

            System.out.println("Conexão com o MySQL realizada com sucesso!");

            CarroDAO dao = new CarroDAO(con);

            // 1. Inserir um carro
            CarroBean carro = new CarroBean();
            carro.setPlaca("ABC1234");
            carro.setCor("Azul");
            carro.setDescricao("Carro de teste");

            dao.inserir(carro);
            System.out.println("\nCarro inserido com sucesso!");

            // 2. Listar os carros
            System.out.println("\n--- LISTA DE CARROS ---");
            List<CarroBean> carros = dao.listarTodos();

            for (CarroBean c : carros) {
                System.out.println(
                    "Placa: " + c.getPlaca()
                    + " | Cor: " + c.getCor()
                    + " | Descrição: " + c.getDescricao()
                );
            }

            // 3. Alterar a cor do carro
            carro.setCor("Vermelho");
            carro.setDescricao("Carro de teste atualizado");

            dao.alterar(carro);
            System.out.println("\nCarro alterado com sucesso!");

            // 4. Listar novamente para verificar a alteração
            System.out.println("\n--- CARRO APÓS ALTERAÇÃO ---");
            carros = dao.listarTodos();

            for (CarroBean c : carros) {
                System.out.println(
                    "Placa: " + c.getPlaca()
                    + " | Cor: " + c.getCor()
                    + " | Descrição: " + c.getDescricao()
                );
            }

            // 5. Excluir o carro de teste
            dao.excluir("ABC1234");
            System.out.println("\nCarro excluído com sucesso!");

            // 6. Conferir a lista após a exclusão
            System.out.println("\n--- LISTA APÓS EXCLUSÃO ---");
            carros = dao.listarTodos();

            for (CarroBean c : carros) {
                System.out.println(
                    "Placa: " + c.getPlaca()
                    + " | Cor: " + c.getCor()
                    + " | Descrição: " + c.getDescricao()
                );
            }

        } catch (SQLException e) {
            System.err.println("Erro ao executar o teste:");
            e.printStackTrace();
        }
    }
}
// mvn exec:java -Dexec.mainClass="psv.FrmCarro" (pra executar pelo cmd)
/* schema = estacionamento (código do SQL)
use estacionamento; 
create table carro (
	placa char(7) not null primary key,
	cor varchar(20), 
	descricao varchar(100) 
);

CREATE USER 'app_estacionamento'@'localhost'
IDENTIFIED BY 'Estacionamento2026!';

GRANT SELECT, INSERT, UPDATE, DELETE
ON estacionamento.carro
TO 'app_estacionamento'@'localhost';

SELECT user, host
FROM mysql.user
WHERE user = 'app_estacionamento';

ALTER USER 'app_estacionamento'@'localhost'
IDENTIFIED BY 'Estacionamento2026!';

GRANT SELECT, INSERT, UPDATE, DELETE
ON estacionamento.carro
TO 'app_estacionamento'@'localhost';
*/