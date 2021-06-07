import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BotaoVisualizacao implements ActionListener {
    Produto[] produto;
    JComboBox<String> seletor;
    JFrame prevFrame;

    public BotaoVisualizacao(Produto[] produto, JComboBox<String> seletor, JFrame prevFrame){
        this.produto = produto;
        this.seletor = seletor;
        this.prevFrame = prevFrame;
    }
    @Override
    public void actionPerformed (ActionEvent e) {
        prevFrame.dispose();
        if (seletor.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Selecione uma prateleira valida");

        } else {
            int j;


            JFrame f = new JFrame();
            f.setTitle("Colsulta");
            f.setSize(800, 500);
            f.setExtendedState(JFrame.MAXIMIZED_BOTH);
            f.setBackground(Color.white);

            f.setVisible(true);
            f.setLayout(null);

            JPanel listPanel = new JPanel();
            listPanel.setBounds(f.getWidth() / 2 - 150, f.getHeight() / 2 - 250, 300, 500);

            String[] nomeProduto = new String[produto.length];

            nomeProduto[0] = "Nome: ";
            for (j = 1; j < produto.length; j++) {

                if (produto[j - 1] != null) {
                    if (seletor.getSelectedItem() != null && produto[j - 1].getSetor().equals(seletor.getSelectedItem())) {
                        nomeProduto[j] = produto[j - 1].getNome();

                    }
                }
            }

            JList<String> listaNomes = new JList<>(nomeProduto);

            listaNomes.setFixedCellWidth(150);
            listaNomes.setBackground(Color.white);
            listPanel.add(listaNomes);
            listPanel.setBackground(Color.white);
            f.add(listPanel);
        }
    }
}
