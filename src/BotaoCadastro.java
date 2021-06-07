import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BotaoCadastro implements ActionListener {

    JTextField nameField;
    JTextField shelfField;
    JFrame f;
    Produto[] produto;

    int i=0;

    public BotaoCadastro(JTextField nameField,
                         JTextField shelfField,
                         JFrame f,
                         Produto[] produto

    ){
        this.nameField = nameField;
        this.shelfField = shelfField;
        this.f = f;
        this.produto = produto;

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        boolean exit = true;
        Produto novoProduto = new Produto();

        while(exit){

            if (produto[i]==null) {

                novoProduto.setNome(nameField.getText());
                novoProduto.setSetor(shelfField.getText());

                produto[i] = novoProduto;
                exit = false;
            } else i++;

        }
        produto[i] = novoProduto;
        JOptionPane.showMessageDialog(null, "Deu bom padrin");
        f.dispose();
    }
}
