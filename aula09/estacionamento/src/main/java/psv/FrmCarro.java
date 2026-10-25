
package psv;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.sql.Connection;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class FrmCarro extends JFrame {

    private final JTextField txtPlaca = new JTextField();
    private final JTextField txtCor = new JTextField();
    private final JTextField txtDescricao = new JTextField();
    private final JLabel lblMensagem = new JLabel(" ");

    private final DefaultTableModel modelo = new DefaultTableModel(
        new String[]{"Placa", "Cor", "Descrição"}, 0
    ) {
        @Override
        public boolean isCellEditable(int linha, int coluna) {
            return false;
        }
    };

    private final JTable tblConsulta = new JTable(modelo);

    public FrmCarro() {
        setTitle("Cadastramento de veículos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel campos = new JPanel(new GridLayout(3, 2, 8, 8));
        campos.setBorder(
            BorderFactory.createTitledBorder("Dados do veículo")
        );

        campos.add(new JLabel("Placa:"));
        campos.add(txtPlaca);
        campos.add(new JLabel("Cor:"));
        campos.add(txtCor);
        campos.add(new JLabel("Descrição:"));
        campos.add(txtDescricao);

        JPanel botoes = new JPanel(new GridLayout(2, 3, 8, 8));

        JButton btnIncluir = new JButton("Incluir");
        JButton btnAlterar = new JButton("Alterar");
        JButton btnExcluir = new JButton("Excluir");
        JButton btnPesquisar = new JButton("Pesquisar");
        JButton btnLimpar = new JButton("Limpar");
        JButton btnFechar = new JButton("Fechar");

        botoes.add(btnIncluir);
        botoes.add(btnAlterar);
        botoes.add(btnExcluir);
        botoes.add(btnPesquisar);
        botoes.add(btnLimpar);
        botoes.add(btnFechar);

        JPanel topo = new JPanel(new BorderLayout(8, 8));
        topo.add(campos, BorderLayout.CENTER);
        topo.add(botoes, BorderLayout.SOUTH);

        add(topo, BorderLayout.NORTH);
        add(new JScrollPane(tblConsulta), BorderLayout.CENTER);
        add(lblMensagem, BorderLayout.SOUTH);

        btnIncluir.addActionListener(e -> incluir());
        btnAlterar.addActionListener(e -> alterar());
        btnExcluir.addActionListener(e -> excluir());
        btnPesquisar.addActionListener(e -> pesquisar());
        btnLimpar.addActionListener(e -> limpar());
        btnFechar.addActionListener(e -> dispose());

        tblConsulta.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                preencherCampos();
            }
        });

        setSize(650, 450);
        setLocationRelativeTo(null);
    }

    private CarroBean lerCampos() {
        CarroBean carro = new CarroBean();
        carro.setPlaca(txtPlaca.getText().trim());
        carro.setCor(txtCor.getText().trim());
        carro.setDescricao(txtDescricao.getText().trim());
        return carro;
    }

    private boolean validarCampos(boolean todos) {
        if (txtPlaca.getText().trim().isEmpty()) {
            lblMensagem.setText("Informe a placa.");
            return false;
        }

        if (todos && (txtCor.getText().trim().isEmpty()
                || txtDescricao.getText().trim().isEmpty())) {
            lblMensagem.setText("Preencha a cor e a descrição.");
            return false;
        }

        return true;
    }

    private void incluir() {
        if (!validarCampos(true)) return;

        try (Connection con = Conexao.abrirConexao()) {
            if (con == null) {
                lblMensagem.setText("Falha na conexão com o banco.");
                return;
            }

            CarroDAO dao = new CarroDAO(con);
            dao.inserir(lerCampos());
            lblMensagem.setText("Veículo cadastrado com sucesso!");
            pesquisar();

        } catch (Exception ex) {
            lblMensagem.setText("Erro: " + ex.getMessage());
        }
    }

    private void alterar() {
        if (!validarCampos(true)) return;

        try (Connection con = Conexao.abrirConexao()) {
            if (con == null) {
                lblMensagem.setText("Falha na conexão com o banco.");
                return;
            }

            CarroDAO dao = new CarroDAO(con);
            dao.alterar(lerCampos());
            lblMensagem.setText("Veículo alterado com sucesso!");
            pesquisar();

        } catch (Exception ex) {
            lblMensagem.setText("Erro: " + ex.getMessage());
        }
    }

    private void excluir() {
        if (!validarCampos(false)) return;

        int resposta = JOptionPane.showConfirmDialog(
            this,
            "Deseja excluir o veículo " + txtPlaca.getText() + "?",
            "Confirmar exclusão",
            JOptionPane.YES_NO_OPTION
        );

        if (resposta != JOptionPane.YES_OPTION) return;

        try (Connection con = Conexao.abrirConexao()) {
            if (con == null) {
                lblMensagem.setText("Falha na conexão com o banco.");
                return;
            }

            CarroDAO dao = new CarroDAO(con);
            dao.excluir(txtPlaca.getText().trim());
            lblMensagem.setText("Veículo excluído com sucesso!");
            pesquisar();

        } catch (Exception ex) {
            lblMensagem.setText("Erro: " + ex.getMessage());
        }
    }

    private void pesquisar() {
        try (Connection con = Conexao.abrirConexao()) {
            modelo.setRowCount(0);

            if (con == null) {
                lblMensagem.setText("Falha na conexão com o banco.");
                return;
            }

            CarroDAO dao = new CarroDAO(con);
            List<CarroBean> carros = dao.listarTodos();

            if (carros == null) {
                lblMensagem.setText("Não foi possível consultar os veículos.");
                return;
            }

            for (CarroBean carro : carros) {
                modelo.addRow(new Object[]{
                    carro.getPlaca(),
                    carro.getCor(),
                    carro.getDescricao()
                });
            }

            lblMensagem.setText(
                carros.size() + " veículo(s) encontrado(s)."
            );

        } catch (Exception ex) {
            lblMensagem.setText("Erro: " + ex.getMessage());
        }
    }

    private void preencherCampos() {
        int linha = tblConsulta.getSelectedRow();

        if (linha < 0) return;

        txtPlaca.setText(modelo.getValueAt(linha, 0).toString());
        txtCor.setText(modelo.getValueAt(linha, 1).toString());
        txtDescricao.setText(modelo.getValueAt(linha, 2).toString());
    }

    private void limpar() {
        txtPlaca.setText("");
        txtCor.setText("");
        txtDescricao.setText("");
        lblMensagem.setText(" ");
        tblConsulta.clearSelection();
        modelo.setRowCount(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new FrmCarro().setVisible(true);
        });
    }
}