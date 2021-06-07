import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BotaoVisualizacao implements ActionListener {
    Produto[] produto;


    public BotaoVisualizacao(Produto[] produto){
        this.produto = produto;
    }
    @Override
    public void actionPerformed (ActionEvent e){

        int j;
        int productsCounter = 0;
        JFrame f = new JFrame();
        f.setTitle("Colsulta");
        f.setSize(800,500);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setBackground(Color.white);

        f.setVisible(true);
        f.setLayout(null);

        JPanel listPanel = new JPanel();
        listPanel.setBounds(f.getWidth()/2-150,f.getHeight()/2-250,300,500);

        String[] nomeProduto = new String[produto.length];

        nomeProduto[0] = "Nome: ";
        for (j=1; j < produto.length; j++){

            if (produto[j-1]!=null){
                nomeProduto[j] = produto[j-1].getNome();
                productsCounter++;
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
