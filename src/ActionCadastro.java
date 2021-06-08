import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionCadastro implements ActionListener {
    Produto[] produto;


    public ActionCadastro(Produto[] produto){
        this.produto = produto;
    }

    @Override

    public void actionPerformed(ActionEvent e) {
        JFrame f = new JFrame();

        int formWidth = 300;
        int formHeight = 250;

        f.setTitle("Cadastrar produto");
        f.setSize(300,300);
        f.setExtendedState(Frame.MAXIMIZED_BOTH);
        f.setLayout(null);
        f.setVisible(true);

        JPanel formPanel = new JPanel();

        formPanel.setBounds(
                f.getWidth()/2 - formWidth/2,
                f.getHeight()/2 - formHeight/2,
                formWidth, formHeight
        );

        formPanel.setLayout(new GridLayout(3, 1, 0,25));

        JPanel namePanel = new JPanel();
        JTextField nameField = new JTextField();

        namePanel.setLayout(new GridLayout(2, 1, 0, 2));
        namePanel.add(new JLabel("Nome do produto:"));
        namePanel.add(nameField);



        JPanel shelfPanel = new JPanel();
        JTextField shelfField = new JTextField();

        shelfPanel.setLayout(new GridLayout(2, 1, 0, 2));
        shelfPanel.add(new JLabel("Nome da prateleira:"));
        shelfPanel.add(shelfField);

        JButton botaoCadastro = new JButton("Cadastrar");
        botaoCadastro.addActionListener(new BotaoCadastro(nameField, shelfField, f, produto));

        formPanel.add(namePanel);
        formPanel.add(shelfPanel);
        formPanel.add(botaoCadastro);

        f.add(formPanel);

        f.setVisible(true);
    }
}
