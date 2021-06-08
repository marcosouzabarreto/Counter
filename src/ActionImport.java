import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class ActionImport implements ActionListener {
    Produto[] produto;

    public ActionImport(Produto[] produto){
        this.produto = produto;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        int i;
        try {
            FileReader arqNomes = new FileReader("save\\nome.txt");
            FileReader arqSetor = new FileReader("save\\codigos.txt");


            BufferedReader lerArqNome = new BufferedReader(arqNomes);
            BufferedReader lerArqSetor = new BufferedReader(arqSetor);


            String linhaNome = lerArqNome.readLine();
            String linhaSetor = lerArqSetor.readLine();


            for (i=0; i< produto.length; i++){
                Produto novoProduto = new Produto();

                if ((linhaNome!=null)&&(linhaSetor!=null)){
                    novoProduto.setNome(linhaNome);
                    novoProduto.setSetor(linhaSetor);

                    produto[i] = novoProduto;

                    linhaNome = lerArqNome.readLine();
                    linhaSetor = lerArqSetor.readLine();
                }
            }

            arqNomes.close();
            arqSetor.close();

            JOptionPane.showMessageDialog(null, "Lista importada com sucesso");
        } catch (FileNotFoundException ex){
            JOptionPane.showMessageDialog(null, "Nao existe lista a ser recuperada");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
