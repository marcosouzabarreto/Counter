import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionExcluirProduto implements ActionListener {
    Produto[] produto;
    public ActionExcluirProduto(Produto[] produto){
        this.produto = produto;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame f = new JFrame();
        f.setSize(300,300);
        f.setExtendedState(Frame.MAXIMIZED_BOTH);
        f.setLayout(null);
        f.setVisible(true);

        JPanel p = new JPanel();
        p.setLayout(new GridLayout(2,1,0,15));
        p.setBounds(f.getWidth()/2-100,f.getHeight()/2-150,200,150);


        JPanel wrapper = new JPanel();
        wrapper.setLayout(new GridLayout(2,1,0,5));

        wrapper.add(new JLabel("Nome do produto a ser excluido: "));
        JTextField excluir = new JTextField();
        wrapper.add(excluir);



        JButton botaoExcluir = new JButton("Excluir");
        botaoExcluir.addActionListener(new BotaoExcluir(produto, excluir, f));

        p.add(wrapper);
        p.add(botaoExcluir);
        f.add(p);

        f.setVisible(true);

    }
}
