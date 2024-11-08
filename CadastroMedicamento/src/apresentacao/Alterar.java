package apresentacao;

import negocio.Medicamento;
import persistencia.ControlaMedicamento;

import javax.swing.*;
import javax.swing.text.html.parser.Parser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;



public class Alterar extends JFrame
{
    private JPanel MainPanel;
    private JTextField TMedicamento;
    private JTextField TDataFabricacao;
    private JButton alterarButton;
    private JTextField textPesquisar;
    private JButton btnBuscar;
    private JTextField TPrincipioAtivo;
    private JTextField TDataValidade;
    private JTextField TMedicamentoControlado;
    private JTextField TTipoMedicamento;
    private JTextField Tid;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    ControlaMedicamento cm;


    public Alterar() {
        setContentPane(MainPanel);
        setTitle("Cadastro de Medicamento");
       // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(700, 400);

    }
    public Alterar(ControlaMedicamento cm) {
        setContentPane(MainPanel);
        setTitle("Cadastro de Medicamento");
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(700, 400);

        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pesquisar = textPesquisar.getText();

                for (Medicamento medicamentos : cm.mostrarMedicamento()){

                    if (Objects.equals(medicamentos.getNome(), pesquisar)){
                        Tid.setText(Integer.toString(medicamentos.getId() - 1));

                        TMedicamento.setText(medicamentos.getNome());
                        TPrincipioAtivo.setText(medicamentos.getPrincipioAtivo());
                        TDataFabricacao.setText(medicamentos.getDataFabricacao().format(formatter));
                        TDataValidade.setText(medicamentos.getDataValidade().format(formatter));
                        TMedicamentoControlado.setText(medicamentos.getMedicamentoControlado());
                        TTipoMedicamento.setText(medicamentos.getMedicamentoLiquidoOuComprimido());



                    }else{
                        JOptionPane.showConfirmDialog(null,"Medicamento  não Encontrado");
                    }
                }
            }
        });

        alterarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Medicamento medicamento = new Medicamento();

                medicamento.setNome(TMedicamento.getText());
                medicamento.setPrincipioAtivo(TPrincipioAtivo.getText());
                medicamento.setDataFabricacao(LocalDate.parse(TDataFabricacao.getText(), formatter));
                medicamento.setDataValidade(LocalDate.parse(TDataValidade.getText(),formatter));
                medicamento.setMedicamentoControlado(TMedicamentoControlado.getText());
                medicamento.setMedicamentoLiquidoOuComprimido(TTipoMedicamento.getText());

                if (cm.updateMedicamento(medicamento, Integer.parseInt(Tid.getText()))){
                    JOptionPane.showConfirmDialog(null,"Medicamento Alterado com Sucesso");


                }else {
                    JOptionPane.showMessageDialog(null, "Erro ao Alterar");


                }
            }
        });
    }
}