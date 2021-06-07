
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
        JFrame f = new JFrame();
        f.setTitle("Colsulta");
        f.setSize(800,500);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setBackground(Color.white);
        f.setLayout(null);
        f.setVisible(true);

        JPanel p = new JPanel();
        p.setBounds(f.getWidth()/2-150,f.getHeight()/2-150,300,300);


        JButton botao = new JButton("clica de teste");
        botao.addActionListener(new BotaoVisualizacao(produto));

        p.add(botao);

        f.add(p);
        f.setVisible(true);
    }
}
