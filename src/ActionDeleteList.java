import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class ActionDeleteList implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        boolean a, b;

        File nameFile = new File("save\\nome.txt");
        File shelfFile = new File("save\\prateleiras.txt");

        a = nameFile.delete();
        b = shelfFile.delete();


        if (a && b) {
            JOptionPane.showMessageDialog(null, "Lista deletada com sucesso");
        } else {
            JOptionPane.showMessageDialog(null, "Nao existe lista a ser excluida");
        }
    }
}
