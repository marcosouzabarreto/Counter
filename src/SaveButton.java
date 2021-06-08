import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.PrintWriter;

public class SaveButton implements ActionListener {
    Produto[] produto;
    public SaveButton(Produto[] produto){
        this.produto = produto;
    }


    @Override
    public void actionPerformed(ActionEvent e){
        String[] nome = new String[produto.length];
        String[] prateleira = new String[produto.length];

        for (int i=0;i<produto.length;i++){
            if (produto[i]!= null){
                nome[i] = produto[i].getNome();
                prateleira[i] = produto[i].getSetor();
            }
        }
        try{
            FileWriter arqNomes = new FileWriter("save\\nome.txt", true);
            FileWriter arqSetor = new FileWriter("save\\prateleiras.txt", true);

            PrintWriter gravarNomes = new PrintWriter(arqNomes);
            PrintWriter gravarSetor = new PrintWriter(arqSetor);

            for (String s : nome) {
                if (s != null) gravarNomes.println(s);
            }
            for (int i = 0; i< nome.length; i++){
                if (prateleira[i]!= null) gravarSetor.println(prateleira[i]);
            }

            arqNomes.close();
            arqSetor.close();
            JOptionPane.showMessageDialog(null,"Lista salva com sucesso");
        } catch (Exception exception){
            JOptionPane.showMessageDialog(null, exception.toString());
        }

    }
}
