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
    // Cria instância da classe e configura o tamanho da janela e a torna visvel

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

    // Armazena o painel atual que está sendo exibido
    private JPanel currentPanel;

    // Contrutor define o título da janela e efine um layout de borda e chama a
    // página inicial.
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
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(Box.createVerticalStrut(20));

        JLabel chooseOptionLabel = new JLabel("Escolha uma opção:");
        chooseOptionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(chooseOptionLabel);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(Box.createVerticalStrut(20));

        JButton btnManageStock = new JButton("Gerenciar Estoque");
        JButton btnSell = new JButton("   Realizar Venda    ");
        JButton btnExit = new JButton("Sair");
        btnManageStock.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnSell.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnExit.setAlignmentX(Component.CENTER_ALIGNMENT);

        // gerenciar estoque
        btnManageStock.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibirGerenciarEstoque();
            }
        });

        // vender

        btnSell.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibirRealizarVenda();
            }
        });

        // sair
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
        chooseOptionLabel.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(Box.createVerticalStrut(20));

        JButton btnAddShoe = new JButton("         Adicionar Sapato          ");
        JButton btnRemoveShoe = new JButton("          Remover Sapato          ");
        JButton btnSearchShoe = new JButton("             Buscar Sapato           ");
        JButton btnStockReport = new JButton("Gerar Relatório de Estoque ");
        JButton btnBack = new JButton("Sair");
        btnAddShoe.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnRemoveShoe.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnSearchShoe.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnStockReport.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnBack.setAlignmentX(Component.CENTER_ALIGNMENT);

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

    private void exibirAdicionarSapato() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel cabecalho = new JLabel("Adicionar Sapato");
        panel.add(cabecalho);
        cabecalho.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(Box.createVerticalStrut(20));

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

        // adiciona sapato social
        btnSocial.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // int tamanho,int codigo,double preco,String tipo,String marca

                String tipo = "1";
                gerenciadorEstoque.adicionarSapato(Integer.parseInt(tamanhoField.getText()),
                        Integer.parseInt(codigoField.getText()), Double.parseDouble(precoField.getText()), tipo,
                        marcaField.getText());

                // volta ao gerenciador

                exibirGerenciarEstoque();
            }
        });

        // adiciona sapato corrida
        btnRunningShoe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // adiciona ao estoque
                String tipo = "2";
                gerenciadorEstoque.adicionarSapato(Integer.parseInt(tamanhoField.getText()),
                        Integer.parseInt(codigoField.getText()), Double.parseDouble(precoField.getText()), tipo,
                        marcaField.getText());

                // volta ao gerenciador
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

    private void exibirRemoverSapato() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel cabecalho = new JLabel("Remover Sapato");
        panel.add(cabecalho);
        cabecalho.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(Box.createVerticalStrut(20));

        JTextField codigoField = new JTextField(10);
        JLabel codigoLabel = new JLabel("Código do Produto:");

        JButton btnRemove = new JButton("Remover");
        JButton btnBack = new JButton("Voltar");

        btnRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // remove sapato do estoque
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

        JLabel cabecalho = new JLabel("Buscar Sapato");
        cabecalho.setFont(new Font("Arial", Font.BOLD, 16));
        cabecalho.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(cabecalho);
        panel.add(Box.createVerticalStrut(20));

        JLabel chooseMethodLabel = new JLabel("Escolha um método de busca:");
        chooseMethodLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        

        JButton btnCode = new JButton("        Código       ");
        JButton btnType = new JButton("           Tipo         ");
        JButton btnBrand = new JButton("         Marca       ");
        JButton btnPriceRange = new JButton(" Faixa de preço");
        JButton btnAll = new JButton("         Todos        ");
        JButton btnBack = new JButton("Voltar");

        btnCode.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnType.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnBrand.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnPriceRange.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnAll.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnBack.setAlignmentX(Component.CENTER_ALIGNMENT);

        btnCode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibirBuscarSapatoCodigo();
            }
        });
        btnType.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibirBuscarTipo();
            }
        });
        btnBrand.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibirBuscadoMarca();
            }
        });
        btnPriceRange.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibirBuscarFaixaPreco();
            }
        });
        btnAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibirBuscarTodos();
            }
        });
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibirGerenciarEstoque();
            }
        });

        panel.add(chooseMethodLabel);
        panel.add(Box.createVerticalStrut(10));
        panel.add(btnCode);
        panel.add(Box.createVerticalStrut(10));
        panel.add(btnType);
        panel.add(Box.createVerticalStrut(10));
        panel.add(btnBrand);
        panel.add(Box.createVerticalStrut(10));
        panel.add(btnPriceRange);
        panel.add(Box.createVerticalStrut(10));
        panel.add(btnAll);
        panel.add(Box.createVerticalStrut(10));
        panel.add(btnBack);

        exibirPainel(panel);
    }

    private void exibirRelatorioEstoque() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel titulo = new JLabel("Relatório Estoque:");
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(titulo);
        titulo.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(Box.createVerticalStrut(20));

        JLabel cabecalho = new JLabel("Código     Tipo     Marca     Tamanho     Preço");
        cabecalho.setAlignmentX(Component.CENTER_ALIGNMENT);
        int tamEstoque = gerenciadorEstoque.getTamanhoEstoque();

        JButton btnBack = new JButton("Voltar");
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibirGerenciarEstoque();
            }
        });

        btnBack.setAlignmentX(Component.CENTER_ALIGNMENT);
        if (gerenciadorEstoque.getTamanhoEstoque() >= 1) {
            panel.add(cabecalho);
        } else {
            JLabel estoqueVazio = new JLabel("O Estoque está Vazio!");
            estoqueVazio.setAlignmentX(Component.CENTER_ALIGNMENT);
            panel.add(estoqueVazio);
        }

        for (int i = 0; i < tamEstoque; i++) {

            JLabel aux = new JLabel(gerenciadorEstoque.getSapatoPosicao(i));
            aux.setAlignmentX(Component.CENTER_ALIGNMENT);
            panel.add(aux);
        }

        panel.add(Box.createVerticalStrut(20));
        panel.add(btnBack, BorderLayout.SOUTH);

        exibirPainel(panel);
    }

    private void exibirRealizarVenda() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel welcomeVendaLabel = new JLabel("Escolha uma opção:");
        welcomeVendaLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(welcomeVendaLabel);
        welcomeVendaLabel.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(Box.createVerticalStrut(20));

        JButton btnShowStock = new JButton("              Exibir Estoque           ");

        JButton btnSell = new JButton("            Realizar Venda           ");
        JButton btnHireEmployee = new JButton("      Contratar Funcionário     ");
        JButton btnFireEmployee = new JButton("        Demitir Funcionário        ");
        JButton btnShowEmployees = new JButton("Exibir Lista de Funcionários");
        JButton btnEmployeeReport = new JButton("    Relatório de Funcionário   ");
        JButton btnExit = new JButton("Sair");

        btnShowStock.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnSell.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnHireEmployee.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnFireEmployee.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnShowEmployees.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnEmployeeReport.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnExit.setAlignmentX(Component.CENTER_ALIGNMENT);

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
        panel.add(Box.createVerticalStrut(10));
        panel.add(btnSell);
        panel.add(Box.createVerticalStrut(10));
        panel.add(btnHireEmployee);
        panel.add(Box.createVerticalStrut(10));
        panel.add(btnFireEmployee);
        panel.add(Box.createVerticalStrut(10));
        panel.add(btnShowEmployees);
        panel.add(Box.createVerticalStrut(10));
        panel.add(btnEmployeeReport);
        panel.add(Box.createVerticalStrut(10));
        panel.add(btnExit);

        exibirPainel(panel);
    }

    private void exibirExibirEstoque() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        ;

        JLabel titulo = new JLabel("Estoque:");
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(titulo);
        titulo.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(Box.createVerticalStrut(20));

        JLabel cabecalho = new JLabel("Código     Tipo     Marca     Tamanho     Preço");
        cabecalho.setAlignmentX(Component.CENTER_ALIGNMENT);
        int tamEstoque = gerenciadorEstoque.getTamanhoEstoque();

        JButton btnBack = new JButton("Voltar");
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibirRealizarVenda();
            }
        });

        btnBack.setAlignmentX(Component.CENTER_ALIGNMENT);
        if (gerenciadorEstoque.getTamanhoEstoque() >= 1) {
            panel.add(cabecalho);
        } else {
            JLabel estoqueVazio = new JLabel("O Estoque está Vazio!");
            estoqueVazio.setAlignmentX(Component.CENTER_ALIGNMENT);
            panel.add(estoqueVazio);
        }

        for (int i = 0; i < tamEstoque; i++) {

            JLabel aux = new JLabel(gerenciadorEstoque.getSapatoPosicao(i));
            aux.setAlignmentX(Component.CENTER_ALIGNMENT);
            panel.add(aux);
        }

        panel.add(Box.createVerticalStrut(20));
        panel.add(btnBack, BorderLayout.SOUTH);

        exibirPainel(panel);
    }

    private void exibirContratarFuncionario() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel cabecalho = new JLabel("Contratar Funcionário");
        panel.add(cabecalho);
        cabecalho.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(Box.createVerticalStrut(20));

        JTextField nomeField = new JTextField(10);
        JLabel nomeLabel = new JLabel("Nome do Funcionário:");

        JButton btnOK = new JButton("OK");
        JButton btnBack = new JButton("Voltar");

        btnOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // contrata funcionario
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

    private void exibirDemitirFuncionario() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel cabecalho = new JLabel("Demitir Funcionário");
        panel.add(cabecalho);
        cabecalho.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(Box.createVerticalStrut(20));

        JTextField nomeField = new JTextField(10);
        JLabel nomeLabel = new JLabel("Nome do Funcionário:");

        JButton btnOK = new JButton("OK");
        JButton btnBack = new JButton("Voltar");

        btnOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // demitir funcionario
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
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel cabecalho = new JLabel("Lista Funcionarios:");
        cabecalho.setAlignmentX(Component.CENTER_ALIGNMENT);
        cabecalho.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(cabecalho);
        panel.add(Box.createVerticalStrut(20));

        int numFuncionarios = centralVendas.numFuncionarios();

        if (numFuncionarios < 1) {
            JLabel nenhumFuncionario = new JLabel("Você não tem Funcionarios!");
            nenhumFuncionario.setAlignmentX(Component.CENTER_ALIGNMENT);
            panel.add(nenhumFuncionario);
            panel.add(Box.createVerticalStrut(10));
        }

        JButton btnBack = new JButton("Voltar");
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibirRealizarVenda();
            }
        });
        btnBack.setAlignmentX(Component.CENTER_ALIGNMENT);

        for (int c = 0; c < numFuncionarios; c++) {

            JLabel funcionario = new JLabel(centralVendas.getNomeFuncionarioPos(c));
            funcionario.setAlignmentX(Component.CENTER_ALIGNMENT);
            panel.add(funcionario);
            panel.add(Box.createVerticalStrut(10));
        }

        panel.add(btnBack, BorderLayout.SOUTH);
        exibirPainel(panel);
    }

    private void exibirRelatorioFuncionario() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel cabecalho = new JLabel("Relatório Funcionarios:");
        cabecalho.setAlignmentX(Component.CENTER_ALIGNMENT);
        cabecalho.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(cabecalho);
        panel.add(Box.createVerticalStrut(20));

        int numFuncionarios = centralVendas.numFuncionarios();
        if (numFuncionarios < 1) {
            JLabel nenhumFuncionario = new JLabel("Você não tem Funcionarios!");
            nenhumFuncionario.setAlignmentX(Component.CENTER_ALIGNMENT);
            panel.add(nenhumFuncionario);
            panel.add(Box.createVerticalStrut(10));
        }

        JButton btnBack = new JButton("Voltar");
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibirRealizarVenda();
            }
        });
        btnBack.setAlignmentX(Component.CENTER_ALIGNMENT);

        for (int c = 0; c < numFuncionarios; c++) {

            JLabel nome = new JLabel(centralVendas.getNomeFuncionarioPos(c));
            nome.setAlignmentX(Component.CENTER_ALIGNMENT);
            panel.add(nome);
            JLabel valorVendido = new JLabel(centralVendas.getRelatorioValorVendidoFuncionarioPos(c));
            valorVendido.setAlignmentX(Component.CENTER_ALIGNMENT);
            panel.add(valorVendido);

            int numProdutosVendidos = centralVendas.getNumProdutosFuncionarioPos(c);
            if (numProdutosVendidos >= 1) {
                JLabel tituloProdutosVendidos = new JLabel("Lista de Produtos Vendidos:");
                tituloProdutosVendidos.setAlignmentX(Component.CENTER_ALIGNMENT);
                panel.add(tituloProdutosVendidos);
                JLabel cabecalhoProdutosVendidos = new JLabel("Código     Tipo     Marca     Tamanho     Preço");
                cabecalhoProdutosVendidos.setAlignmentX(Component.CENTER_ALIGNMENT);
                panel.add(cabecalhoProdutosVendidos);

            } else {
                JLabel nenhumProdutoVendido = new JLabel("Nenhum Produto Vendido!");
                nenhumProdutoVendido.setAlignmentX(Component.CENTER_ALIGNMENT);
                panel.add(nenhumProdutoVendido);
            }

            for (int a = 0; a < numProdutosVendidos; a++) {
                JLabel produtoVendido = new JLabel(centralVendas.getProdutoPosFuncionario(c, a));
                produtoVendido.setAlignmentX(Component.BOTTOM_ALIGNMENT);
                panel.add(produtoVendido);
            }
            panel.add(Box.createVerticalStrut(10));
        }

        panel.add(btnBack, BorderLayout.SOUTH);
        exibirPainel(panel);
    }

    private void exibirBuscarSapatoCodigo() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel titulo = new JLabel("Busca por Código");
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(titulo);
        titulo.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(Box.createVerticalStrut(20));

        JLabel cabecalho = new JLabel("Informe o código do produto");
        cabecalho.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField codigoField = new JTextField(10);

        JButton btnBack = new JButton("Voltar");
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibirGerenciarEstoque();
            }
        });
        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                exibirSapatoBuscadoCodigo(Integer.parseInt(codigoField.getText()));

            }
        });

        btnBack.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnBuscar.setAlignmentX(Component.CENTER_ALIGNMENT);
        codigoField.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(cabecalho);
        panel.add(Box.createVerticalStrut(10));
        panel.add(codigoField);
        panel.add(Box.createVerticalStrut(10));
        panel.add(btnBuscar);
        panel.add(Box.createVerticalStrut(10));
        panel.add(btnBack);

        exibirPainel(panel);

    }

    private void exibirSapatoBuscadoCodigo(int codigo) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel titulo = new JLabel("Sapatos Encontrados:");
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(titulo);
        titulo.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(Box.createVerticalStrut(20));

        if (!gerenciadorEstoque.buscarCodigo(codigo).equals("0")) {
            JLabel cabecalho = new JLabel("Código     Tipo     Marca     Tamanho     Preço");
            cabecalho.setAlignmentX(Component.CENTER_ALIGNMENT);
            panel.add(cabecalho);

            int tamEstoque = gerenciadorEstoque.getTamanhoEstoque();
            for (int c = 0; c < tamEstoque; c++) {
                if (!gerenciadorEstoque.compararCodigoPosicao(codigo, c).equals("0")) {
                    JLabel sapato = new JLabel(gerenciadorEstoque.compararCodigoPosicao(codigo, c));
                    sapato.setAlignmentX(Component.CENTER_ALIGNMENT);
                    panel.add(sapato);
                }
            }

        }

        else {
            JLabel cabecalho = new JLabel("Sapato Não Encontrado!");
            cabecalho.setAlignmentX(Component.CENTER_ALIGNMENT);
            panel.add(cabecalho);
        }

        JButton btnBack = new JButton("Voltar");
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibirGerenciarEstoque();
            }
        });

        btnBack.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(Box.createVerticalStrut(10));

        panel.add(btnBack);

        exibirPainel(panel);

    }



    private void exibirBuscadoMarca() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel titulo = new JLabel("Buscar Por Marca");
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(titulo);
        titulo.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(Box.createVerticalStrut(20));

        JLabel marcaLabel = new JLabel("Digite a Marca:");
        marcaLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField marcaField = new JTextField(10);
        marcaField.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibirSapatoBuscadoMarca(marcaField.getText());
            }
        });
        btnBuscar.setAlignmentX(Component.CENTER_ALIGNMENT);


        JButton btnBack = new JButton("Voltar");
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibirGerenciarEstoque();
            }
        });
        btnBack.setAlignmentX(Component.CENTER_ALIGNMENT);


        panel.add(marcaLabel);
        panel.add(Box.createVerticalStrut(10));
        panel.add(marcaField);
        panel.add(Box.createVerticalStrut(10));
        panel.add(btnBuscar);
        panel.add(Box.createVerticalStrut(10));
        panel.add(btnBack);

        exibirPainel(panel);
    }

    private void exibirSapatoBuscadoMarca(String marca) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel titulo = new JLabel("Sapatos Encontrados:");
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(titulo);
        titulo.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(Box.createVerticalStrut(20));

        int tamEstoque = gerenciadorEstoque.getTamanhoEstoque();

        if(gerenciadorEstoque.existeMarca(marca)){
            JLabel cabecalho = new JLabel("Código     Tipo     Marca     Tamanho     Preço");
            cabecalho.setAlignmentX(Component.CENTER_ALIGNMENT);
            panel.add(cabecalho);
        }
        else{
            JLabel cabecalho = new JLabel("Nenhum Sapato Encontrado!");
            cabecalho.setAlignmentX(Component.CENTER_ALIGNMENT);
            panel.add(cabecalho);
        }

        for(int c = 0; c < tamEstoque ; c++){
            if(!gerenciadorEstoque.compararMarcaPosicao(c, marca).equals("0")){
                JLabel sapatoEncontrado = new JLabel(gerenciadorEstoque.compararMarcaPosicao(c, marca));
                sapatoEncontrado.setAlignmentX(Component.CENTER_ALIGNMENT);
                panel.add(sapatoEncontrado);
            }
        }

        

        JButton btnBack = new JButton("Voltar");
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibirGerenciarEstoque();
            }
        });

        btnBack.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(Box.createVerticalStrut(10));
        panel.add(btnBack);

        exibirPainel(panel);

    }


    private void exibirBuscarTipo(){
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel titulo = new JLabel("Buscar por Tipo");
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(titulo);
        titulo.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(Box.createVerticalStrut(20));
     

        JButton btnSapatoSocial = new JButton(" Sapato Social ");
        btnSapatoSocial.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibirResultadoBuscaTipo("Social");
            }
        });
        btnSapatoSocial.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton btnSapatoCorrida = new JButton("Sapato Corrida");
        btnSapatoCorrida.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibirResultadoBuscaTipo("Corrida");
            }
        });
        btnSapatoCorrida.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton btnBack = new JButton("Voltar");
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibirGerenciarEstoque();
            }
        });
        btnBack.setAlignmentX(Component.CENTER_ALIGNMENT);


        panel.add(btnSapatoSocial);
        panel.add(Box.createVerticalStrut(10));
        panel.add(btnSapatoCorrida);
        panel.add(Box.createVerticalStrut(10));
        panel.add(btnBack);
        exibirPainel(panel);
    }



    private void exibirResultadoBuscaTipo(String tipo) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel titulo = new JLabel("Sapatos Encontrados:");
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(titulo);
        titulo.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(Box.createVerticalStrut(20));
     
        int tamEstoque = gerenciadorEstoque.getTamanhoEstoque();
        int numSapatosEncontrados = 0;
        for(int c = 0; c < tamEstoque; c++){
            if(!gerenciadorEstoque.getComparaSapatoPosicaoTipo(c,tipo).equals("0")){
                numSapatosEncontrados++;
                JLabel sapato = new JLabel(gerenciadorEstoque.getComparaSapatoPosicaoTipo(c,tipo));
                sapato.setAlignmentX(Component.CENTER_ALIGNMENT);
                if(numSapatosEncontrados == 1){
                    JLabel cabecalho = new JLabel("Código     Tipo     Marca     Tamanho     Preço");
                    cabecalho.setAlignmentX(Component.CENTER_ALIGNMENT);
                    panel.add(cabecalho);
                }
                panel.add(sapato);
            }
        }
        if(numSapatosEncontrados == 0){
            JLabel nenhumSapatoEncontrado = new JLabel("Nenhum Sapato Encontrado!");
            nenhumSapatoEncontrado.setAlignmentX(Component.CENTER_ALIGNMENT);
            panel.add(nenhumSapatoEncontrado);
        }


        JButton btnBack = new JButton("Voltar");
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibirGerenciarEstoque();
            }
        });
        btnBack.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        panel.add(Box.createVerticalStrut(10));
        panel.add(btnBack);
        exibirPainel(panel);

    }


    private void exibirBuscarFaixaPreco(){
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel titulo = new JLabel("Buscar por Preço");
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(titulo);
        titulo.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(Box.createVerticalStrut(20));
     

        JLabel precoMinimoLabel = new JLabel("Digite o Preço Mínimo");
        precoMinimoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel precoMaximoLabel = new JLabel("Digite o Preço Máximo");
        precoMaximoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JTextField precoMinimoField = new JTextField(10);
        precoMinimoField.setAlignmentX(Component.CENTER_ALIGNMENT);
        JTextField precoMaximoField = new JTextField(10);
        precoMaximoField.setAlignmentX(Component.CENTER_ALIGNMENT);






        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibirResultadoBuscaFaixaPreco(Double.parseDouble(precoMinimoField.getText()) ,  Double.parseDouble(precoMaximoField.getText())  );
            }
        });
        btnBuscar.setAlignmentX(Component.CENTER_ALIGNMENT);


        JButton btnBack = new JButton("Voltar");
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibirGerenciarEstoque();
            }
        });
        btnBack.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        panel.add(precoMinimoLabel);
        panel.add(precoMinimoField);
        panel.add(Box.createVerticalStrut(10));
        panel.add(precoMaximoLabel);
        panel.add(precoMaximoField);
        panel.add(Box.createVerticalStrut(10));
        panel.add(btnBuscar);
        panel.add(Box.createVerticalStrut(10));
        panel.add(btnBack);
        exibirPainel(panel);
    }




    private void exibirResultadoBuscaFaixaPreco(double precoMinimo, Double precoMaximo) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel titulo = new JLabel("Sapatos Encontrados:");
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(titulo);
        titulo.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(Box.createVerticalStrut(20));
     
        int tamEstoque = gerenciadorEstoque.getTamanhoEstoque();
        int numSapaatosEncontrados = 0;
        for(int c = 0; c < tamEstoque ; c++){
            if (!gerenciadorEstoque.compararPrecoPorPosicao(c,precoMaximo,precoMinimo).equals("0")){
                numSapaatosEncontrados++;
                JLabel sapato = new JLabel(gerenciadorEstoque.compararPrecoPorPosicao(c,precoMaximo,precoMinimo));
                sapato.setAlignmentX(Component.CENTER_ALIGNMENT);

                if(numSapaatosEncontrados == 1){
                    JLabel cabecalho = new JLabel("Código     Tipo     Marca     Tamanho     Preço");
                    cabecalho.setAlignmentX(Component.CENTER_ALIGNMENT);
                    panel.add(cabecalho);
                }
                panel.add(sapato);
            }
        }
        if(numSapaatosEncontrados == 0){
            JLabel nenhumSapatoEncontrado = new JLabel("Nenhum Sapato Encontrado!");
            nenhumSapatoEncontrado.setAlignmentX(Component.CENTER_ALIGNMENT);
            panel.add(nenhumSapatoEncontrado);
        }


        JButton btnBack = new JButton("Voltar");
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibirGerenciarEstoque();
            }
        });
        btnBack.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        panel.add(Box.createVerticalStrut(10));
        panel.add(btnBack);
        exibirPainel(panel);

    }


    private void exibirBuscarTodos() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel titulo = new JLabel("Todos os Sapatos:");
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(titulo);
        titulo.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(Box.createVerticalStrut(20));
     

        int tamEstoque = gerenciadorEstoque.getTamanhoEstoque();

        if(tamEstoque == 0){
            JLabel estoqueVazio = new JLabel("Estoque Vazio");
            estoqueVazio.setAlignmentX(Component.CENTER_ALIGNMENT);
            panel.add(estoqueVazio);
        }
        else{
            JLabel cabecalho = new JLabel("Código     Tipo     Marca     Tamanho     Preço");
            cabecalho.setAlignmentX(Component.CENTER_ALIGNMENT);
            panel.add(cabecalho);
            for(int c = 0; c < tamEstoque ; c++){
                JLabel sapato = new JLabel(gerenciadorEstoque.getSapatoPosicao(c));
                sapato.setAlignmentX(Component.CENTER_ALIGNMENT);
                panel.add(sapato);
            }
        }

        JButton btnBack = new JButton("Voltar");
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibirGerenciarEstoque();
            }
        });
        btnBack.setAlignmentX(Component.CENTER_ALIGNMENT);

        
        panel.add(Box.createVerticalStrut(10));
        panel.add(btnBack);
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