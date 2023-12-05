package codigo;



//Bibliotecas gráficas para java
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//JFrame é uma classe com janela GUI
public class SistemaLoja extends JFrame {
    GerenciadorEstoque gerenciadorEstoque = GerenciadorEstoque.getInstance();
    CentralVendas centralVendas = new CentralVendas();
    //Cria instância da classe e configura o tamanho da janela e a torna visvel

    public static void main(String[] args) {
         
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                SistemaLoja sistemaLoja = new SistemaLoja();
                sistemaLoja.setSize(600, 500);
                sistemaLoja.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                sistemaLoja.setVisible(true);
            }
        });
    }

    //Armazena o painel atual que está sendo exibido
    private JPanel currentPanel;

    //Contrutor define o título da janela e efine um layout de borda e chama a página inicial.
    public SistemaLoja() {
        setTitle("Sistema de Loja");
        setLayout(new FlowLayout());
        setBackground(Color.DARK_GRAY);

        exibirPaginaInicial();
    }

    private void exibirPaginaInicial() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel welcomeLabel = new JLabel("Bem Vindo");
        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(welcomeLabel);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD,16));
        panel.add(Box.createVerticalStrut(20)); 

        JLabel chooseOptionLabel = new JLabel("Escolha uma opção:");
        chooseOptionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(chooseOptionLabel);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD,16));
        panel.add(Box.createVerticalStrut(20)); 

        JButton btnManageStock = new JButton("Gerenciar Estoque");
        JButton btnSell = new JButton("Realizar Venda");
        JButton btnExit = new JButton("Sair");


        //gerenciar estoque
        btnManageStock.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibirGerenciarEstoque();
            }
        });

        //vender

        
        btnSell.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibirRealizarVenda();
            }
        });

        //sair
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibirPaginaInicial();
            }
        });

        panel.add(btnManageStock);
        panel.add(Box.createVerticalStrut(10));
        panel.add(btnSell);
        panel.add(Box.createVerticalStrut(10));
        panel.add(btnExit);
        panel.add(Box.createVerticalStrut(10));

        exibirPainel(panel);
    }


        private void exibirGerenciarEstoque() {

            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    
            JLabel chooseOptionLabel = new JLabel("Escolha uma opção:");
            chooseOptionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            panel.add(chooseOptionLabel);
            chooseOptionLabel.setFont(new Font("Arial", Font.BOLD,16));
            panel.add(Box.createVerticalStrut(20)); 
    
            JButton btnAddShoe = new JButton("Adicionar Sapato");
            JButton btnRemoveShoe = new JButton("Remover Sapato");
            JButton btnSearchShoe = new JButton("Buscar Sapato");
            JButton btnStockReport = new JButton("Gerar Relatório de Estoque");
            JButton btnBack = new JButton("Sair");
    
            btnAddShoe.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    exibirAdicionarSapato();
                }
            });
            btnRemoveShoe.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    exibirRemoverSapato();
                }
            });
            btnSearchShoe.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    exibirBuscarSapato();
                }
            });
            btnStockReport.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    exibirRelatorioEstoque();
                }
            });
            btnBack.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    exibirPaginaInicial();
                }
            });
    
            panel.add(btnAddShoe);
            panel.add(Box.createVerticalStrut(10));
            panel.add(btnRemoveShoe);
            panel.add(Box.createVerticalStrut(10));
            panel.add(btnSearchShoe);
            panel.add(Box.createVerticalStrut(10));
            panel.add(btnStockReport);
            panel.add(Box.createVerticalStrut(10));
            panel.add(btnBack);
    
            exibirPainel(panel);
        }
    
        //adicionar sapato Feito!
        private void exibirAdicionarSapato() {
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    
            JTextField marcaField = new JTextField(10);
            JTextField tamanhoField = new JTextField(10);
            JTextField precoField = new JTextField(10);
            JTextField codigoField = new JTextField(10);
    
            JLabel marcaLabel = new JLabel("Marca:");
            JLabel tamanhoLabel = new JLabel("Tamanho:");
            JLabel precoLabel = new JLabel("Preço:");
            JLabel codigoLabel = new JLabel("Código:");
    
            JButton btnSocial = new JButton("Sapato Social");
            JButton btnRunningShoe = new JButton("Tênis de Corrida");
            JButton btnBack = new JButton("Voltar");
    

            //adiciona sapato social
            btnSocial.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //int tamanho,int codigo,double preco,String tipo,String marca

                    String tipo = "1";
                    gerenciadorEstoque.adicionarSapato(Integer.parseInt(tamanhoField.getText()) ,Integer.parseInt(codigoField.getText()),Double.parseDouble(precoField.getText()),tipo,marcaField.getText());

                    //volta ao gerenciador
                    
                    exibirGerenciarEstoque();
                }
            });

            //adiciona sapato corrida
            btnRunningShoe.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    //adiciona ao estoque
                    String tipo = "2";
                    gerenciadorEstoque.adicionarSapato(Integer.parseInt(tamanhoField.getText()) ,Integer.parseInt(codigoField.getText()),Double. parseDouble(precoField.getText()),tipo,marcaField.getText());

                    //volta ao gerenciador
                    exibirGerenciarEstoque();
                }
            });
            btnBack.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    exibirGerenciarEstoque();
                }
            });
    
            panel.add(marcaLabel);
            panel.add(marcaField);
            panel.add(tamanhoLabel);
            panel.add(tamanhoField);
            panel.add(precoLabel);
            panel.add(precoField);
            panel.add(codigoLabel);
            panel.add(codigoField);
            panel.add(btnSocial);
            panel.add(btnRunningShoe);
            panel.add(btnBack);
    
            exibirPainel(panel);
        }


    
        //remover sapato Feito!
        private void exibirRemoverSapato() {
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    
            JTextField codigoField = new JTextField(10);
            JLabel codigoLabel = new JLabel("Código do Produto:");
    
            JButton btnRemove = new JButton("Remover");
            JButton btnBack = new JButton("Voltar");
    
            btnRemove.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    //remove sapato do estoque
                    gerenciadorEstoque.removerSapato(Integer.parseInt(codigoField.getText()));

                    exibirGerenciarEstoque();
                }
            });
            btnBack.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    exibirGerenciarEstoque();
                }
            });
    
            panel.add(codigoLabel);
            panel.add(codigoField);
            panel.add(btnRemove);
            panel.add(btnBack);
    
            exibirPainel(panel);
        }
    

        private void exibirBuscarSapato() {
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    
            JLabel chooseMethodLabel = new JLabel("Escolha um método de busca:");
            chooseMethodLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
    
            JButton btnCode = new JButton("Código");
            JButton btnType = new JButton("Tipo");
            JButton btnBrand = new JButton("Marca");
            JButton btnPriceRange = new JButton("Faixa de preço");
            JButton btnAll = new JButton("Todos");
            JButton btnBack = new JButton("Voltar");
    
            btnCode.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    exibirGerenciarEstoque();
                }
            });
            btnType.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    exibirGerenciarEstoque();
                }
            });
            btnBrand.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    exibirGerenciarEstoque();
                }
            });
            btnPriceRange.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    exibirGerenciarEstoque();
                }
            });
            btnAll.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    exibirGerenciarEstoque();
                }
            });
            btnBack.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    exibirGerenciarEstoque();
                }
            });
    
            panel.add(chooseMethodLabel);
            panel.add(btnCode);
            panel.add(btnType);
            panel.add(btnBrand);
            panel.add(btnPriceRange);
            panel.add(btnAll);
            panel.add(btnBack);
    
            exibirPainel(panel);
        }
    



        private void exibirRelatorioEstoque() {
            JPanel panel = new JPanel();
            panel.setLayout(new BorderLayout());
    
            JButton btnBack = new JButton("Voltar");
            btnBack.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    exibirGerenciarEstoque();
                }
            });
    
            panel.add(btnBack, BorderLayout.SOUTH);
    
            exibirPainel(panel);
        }
    



        

        private void exibirRealizarVenda() {
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

            JLabel welcomeVendaLabel = new JLabel("Escolha uma opção:");
            welcomeVendaLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            panel.add(welcomeVendaLabel);
            welcomeVendaLabel.setFont(new Font("Arial", Font.BOLD,16));
            panel.add(Box.createVerticalStrut(20));
    
            JButton btnShowStock = new JButton("Exibir Estoque");
            JButton btnSell = new JButton("Realizar Venda");
            JButton btnHireEmployee = new JButton("Contratar Funcionário");
            JButton btnFireEmployee = new JButton("Demitir Funcionário");
            JButton btnShowEmployees = new JButton("Exibir Lista de Funcionários");
            JButton btnEmployeeReport = new JButton("Relatório de Funcionário");
            JButton btnExit = new JButton("Sair");
    
            btnShowStock.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    exibirExibirEstoque();
                }
            });
            btnSell.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    exibirRealizarVenda();
                }
            });
            btnHireEmployee.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    exibirContratarFuncionario();
                }
            });
            btnFireEmployee.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    exibirDemitirFuncionario();
                }
            });
            btnShowEmployees.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    exibirListaFuncionarios();
                }
            });
            btnEmployeeReport.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    exibirRelatorioFuncionario();
                }
            });
            btnExit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    exibirPaginaInicial();
                }
            });
    
            panel.add(btnShowStock);
            panel.add(btnSell);
            panel.add(btnHireEmployee);
            panel.add(btnFireEmployee);
            panel.add(btnShowEmployees);
            panel.add(btnEmployeeReport);
            panel.add(btnExit);
    
            exibirPainel(panel);
        }
    
        private void exibirExibirEstoque() {
            JPanel panel = new JPanel();
            panel.setLayout(new BorderLayout());
    
     
            JButton btnBack = new JButton("Voltar");
            btnBack.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    exibirRealizarVenda();
                }
            });
    
            panel.add(btnBack, BorderLayout.SOUTH);
    
            exibirPainel(panel);
        }
    

        //contratar funcionario Feito!!
        private void exibirContratarFuncionario() {
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    
            JTextField nomeField = new JTextField(10);
            JLabel nomeLabel = new JLabel("Nome do Funcionário:");
    
            JButton btnOK = new JButton("OK");
            JButton btnBack = new JButton("Voltar");
    
            btnOK.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    //contrata funcionario
                    centralVendas.contratarFuncionario(nomeField.getText());

                    exibirRealizarVenda();
                }
            });
            btnBack.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    exibirRealizarVenda();
                }
            });
    
            panel.add(nomeLabel);
            panel.add(nomeField);
            panel.add(btnOK);
            panel.add(btnBack);
    
            exibirPainel(panel);
        }
    

        //demitir funcionario Feito!
        private void exibirDemitirFuncionario() {
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    
            JTextField nomeField = new JTextField(10);
            JLabel nomeLabel = new JLabel("Nome do Funcionário:");
    
            JButton btnOK = new JButton("OK");
            JButton btnBack = new JButton("Voltar");
    
            btnOK.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    //demitir funcionario
                    centralVendas.demitirFuncionario(nomeField.getText());

                    exibirRealizarVenda();
                }
            });
            btnBack.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    exibirRealizarVenda();
                }
            });
    
            panel.add(nomeLabel);
            panel.add(nomeField);
            panel.add(btnOK);
            panel.add(btnBack);
    
            exibirPainel(panel);
        }
    





        private void exibirListaFuncionarios() {
            JPanel panel = new JPanel();
            panel.setLayout(new BorderLayout());
    
    
            JButton btnBack = new JButton("Voltar");
            btnBack.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    exibirRealizarVenda();
                }
            });
    
            panel.add(btnBack, BorderLayout.SOUTH);
    
            exibirPainel(panel);
        }
    
        private void exibirRelatorioFuncionario() {
            JPanel panel = new JPanel();
            panel.setLayout(new BorderLayout());
    
        
    
            JButton btnBack = new JButton("Voltar");
            btnBack.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    exibirRealizarVenda();
                }
            });
    
            panel.add(btnBack, BorderLayout.SOUTH);
    
            exibirPainel(panel);
        }
    
        private void exibirPainel(JPanel panel) {
            if (currentPanel != null) {
                remove(currentPanel);
            }
            currentPanel = panel;
            add(panel, BorderLayout.CENTER);
            revalidate();
            repaint();
        }
    }