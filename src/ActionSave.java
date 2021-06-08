import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionSave implements ActionListener {
    Produto[] produto;
    public ActionSave(Produto[] produto){
        this.produto = produto;
    }
    @Override

    public void actionPerformed(ActionEvent e){
        JFrame f = new JFrame();
        f.setSize(300,300);
        f.setExtendedState(Frame.MAXIMIZED_BOTH);
        f.setTitle("Menu de Save");
        f.setLayout(null);
        f.setVisible(true);

        JPanel p = new JPanel();
        p.setBounds(f.getWidth()/2-450,f.getHeight()/2,900,50);

        p.setLayout(new GridLayout(1,3,15,0));

        JButton botaoSave = new JButton("Salvar");
        botaoSave.addActionListener(new SaveButton(produto));

        JButton botaoDelete = new JButton("Deletar");
        botaoDelete.addActionListener(new ActionDeleteList());

        JButton botaoImport = new JButton("Importar");
        botaoImport.addActionListener(new ActionImport(produto));

        p.add(botaoSave);
        p.add(botaoImport);
        p.add(botaoDelete);

        f.add(p);

    }
}
