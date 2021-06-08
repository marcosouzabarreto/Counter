import javax.swing.*;
import java.awt.*;
import java.util.Objects;


public class LandingPage {

    public static void lookAndFeel() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex){
            System.out.println("Ocorreu algum erro");
        }

    }


    public static JFrame createFrame(){
        JFrame f = new JFrame();
        f.setTitle("Deposito");
        f.setSize(800,500);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.setVisible(true);

        return f;
    }
    public static void main(String[] args) {
        lookAndFeel();

        Produto[] produto = new Produto[1024];

        ImageIcon logo = new ImageIcon(Objects.requireNonNull(LandingPage.class.getClassLoader().getResource("counter.png")));

        JFrame landingPage = createFrame();
        landingPage.setLayout(null);

        JPanel logoPanel = new JPanel();
        logoPanel.setBounds(landingPage.getWidth()/2-250,0,500,500);
        JLabel l = new JLabel();
        l.setIcon(logo);
        logoPanel.add(l);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setBounds(100,landingPage.getHeight()-300,
                landingPage.getWidth()-200,60
        );

        buttonsPanel.setLayout(new GridLayout(1, 4, 15, 0));

        landingPage.add(buttonsPanel);

        JButton botaoCadastro = new JButton("Cadastro");
        botaoCadastro.addActionListener(new ActionCadastro(produto));

        JButton botaoVisualizacao = new JButton("Checar Prateleiras");
        botaoVisualizacao.addActionListener(new ActionVisualizacao(produto));

        JButton botaoMenuSave = new JButton("Menu de Save");
        botaoMenuSave.addActionListener(new ActionSave(produto));

        JButton botaoExcluirProduto = new JButton("Excluir Produtos");
        botaoExcluirProduto.addActionListener(new ActionExcluirProduto(produto));

        buttonsPanel.add(botaoCadastro);
        buttonsPanel.add(botaoVisualizacao);
        buttonsPanel.add(botaoMenuSave);
        buttonsPanel.add(botaoExcluirProduto);

        landingPage.add(logoPanel);
        landingPage.setVisible(true);
    }
}
