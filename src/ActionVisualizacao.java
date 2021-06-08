
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


        String[] shelfs = new String[produto.length];
        shelfs[0] = "Selecione a prateleira desejada:";
        int j;
        for (i=1; i < produto.length; i++){
        int verifica = 0;
            String verificador;

            if (produto[i-1]!= null){

                verificador = produto[i-1].getSetor();
                for (j=1;j < shelfs.length;j++){
                    if (verificador.equals(shelfs[j])) verifica = 1;
                }
                if (verifica==0) shelfs[i] = verificador;

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
