
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionVisualizacao implements ActionListener {

    Produto[] produto;
    public ActionVisualizacao(Produto[] produto){
        this.produto = produto;
    }
    @Override
    public void actionPerformed(ActionEvent e){
        int i;
        int productsCounter = 1;
        JFrame f = new JFrame();
        f.setTitle("Colsulta");
        f.setSize(800,500);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setBackground(Color.white);
        f.setLayout(null);
        f.setVisible(true);

        JPanel p = new JPanel();
        JPanel selectShelf = new JPanel();

        p.setLayout(new GridLayout(2,1,1,13));
        selectShelf.setLayout(new GridLayout(2,1,1,5));

        p.setBounds(f.getWidth()/2-100,f.getHeight()/2-100,200,150);



        for (i=0; i < produto.length; i++){
            if (produto[i]!=null) {
                productsCounter++;
            }
        }
        String[] shelfs = new String[productsCounter];
        shelfs[0] = "Selecione a prateleira desejada:";
        for (i=1; i< productsCounter; i++){
            if (produto[i-1]!= null){
                shelfs[i] = produto[i-1].getSetor();
            }
        }


        JComboBox<String> seletor = new JComboBox<>(shelfs);


        JButton botao = new JButton("Procurar");
        botao.addActionListener(new BotaoVisualizacao(produto, seletor, f));

        selectShelf.add(new JLabel("Digite a prateleira desejada: "));
        selectShelf.add(seletor);

        p.add(selectShelf);
        p.add(botao);


        f.add(p);
        f.setVisible(true);
    }
}
