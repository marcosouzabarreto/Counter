import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BotaoExcluir implements ActionListener {
    Produto[] produto;
    JTextField excluir;
    JFrame a;
    public BotaoExcluir(Produto[] produto, JTextField excluir, JFrame a){
        this.produto = produto;
        this.excluir = excluir;
        this.a = a;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        a.dispose();
        int achou = 0;
        for (int i = 0; i < produto.length; i++) {

            if (produto[i] != null) {
                if (produto[i].getNome().equals(excluir.getText())) {
                    produto[i] = null;
                    achou = 1;
                }
            }

        }
        if (achou==1){
            JOptionPane.showMessageDialog(null, "Produto excluido");

        } else {
            JOptionPane.showMessageDialog(null,
                    "Nenhum produto com o nome de " +
                    excluir.getText() +
                    " foi encontrado"
            );

        }
    }
}
