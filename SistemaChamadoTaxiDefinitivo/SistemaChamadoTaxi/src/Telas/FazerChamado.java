/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Telas;

import Classes.Carro;
import Classes.Chamado;
import Classes.Cliente;
import Classes.Empacotamento;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class FazerChamado extends javax.swing.JFrame {
    Calendar dataAtual;
    ArrayList<Object> veiculos;
    ArrayList<Object> clientes;
    ArrayList<Object> chamados;
    int id = 0;
    int linhaSelecionada = -1;
    
    public FazerChamado() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        dataAtual = Calendar.getInstance();
        veiculos = Empacotamento.lerArquivoBinario("veiculos");
        clientes = Empacotamento.lerArquivoBinario("clientes");
        chamados = Empacotamento.lerArquivoBinario("chamados");
        
        telaAtivacao(false);
        carregarVeiculos();
        carregarClietes();
        carregarTabelaChamados(tfPesquisar.getText());
        obterLinhaSelect();
        
        jblQuantAtendidos.setText(Integer.toString(chamados.size()));
        jblMostrarKmPercorridos.setText(Double.toString(totalKmPercorrido()) + "Km");
        jblMostrarFaturamentoTotal.setText("R$ " + Double.toString(faturamentoTotal()));
        
    }
    
   private void telaAtivacao(boolean flag){
        cbxTipo.setEnabled(flag);
        cbxCliente.setEnabled(flag);
        cbxVeiculo.setEnabled(flag);
        jblsetDestinoViagem.setEnabled(flag);
        jblsetOrigemViagem.setEnabled(flag);
        spnKmInicial.setEnabled(flag);
        spnKmFinal.setEnabled(flag);
        
        lblMostrarId.setText("000");
        
        btnCancelarChamado.setEnabled(flag);
        btnLimparChamado.setEnabled(flag);
        btnSalvarChamado.setEnabled(flag);
   }
   
   
   private void carregarClietes(){
       for(Object objeto:clientes){
           Cliente cliente = (Cliente) objeto;
           cbxCliente.addItem(cliente.getNome());
       }
   }
   
   private void carregarVeiculos(){
       for(Object objeto:veiculos){
           Carro veiculo = (Carro) objeto;
           cbxVeiculo.addItem(veiculo.getModelo() + "/" + veiculo.getPlaca());
           
       }
   }
    
    public double faturamentoTotal(){
        double faturamento = 0d;
        for(Object objeto:chamados){
            Chamado chamado = (Chamado) objeto;
            faturamento += chamado.getValorTotalChamado();
        }
        return faturamento;
        
    }
    
    public double totalKmPercorrido(){
        double distancia = 0d;
        for(Object objeto:chamados){
            Chamado chamado = (Chamado) objeto;
            distancia += chamado.getKmFinal() - chamado.getKmInicial();
        }
        return distancia;
    }

    public void addClienteCb(ArrayList<Object> clientes){
        for(Object objeto:clientes){
            Cliente cliente = (Cliente) objeto;
            cbxCliente.addItem(cliente.getNome() + " - " + cliente.getCPF());
        }
    }
    
    
    private void carregarTabelaChamados(String valorProcurado) {
        String procurado = valorProcurado.toLowerCase();
        DefaultTableModel modelo = new DefaultTableModel(new Object[]
            {"Id","Data","Cliente","CPF","Origem","Destino","Veiculo","Tipo","Valor"},0);

                for(Object objeto:chamados){
                    Chamado chamado = (Chamado) objeto;
                    if(chamado.toString().toLowerCase().contains(procurado)){
                        Object linha[] = new Object[]{chamado.getId(),
                            getDateTime(chamado.getData()),
                            chamado.getCliente().getNome(),
                            chamado.getCliente().getCPF(),
                            chamado.getOrigem(),
                            chamado.getDestino(),
                            chamado.getCarro().getPlaca(),
                            chamado.getTipo(),
                            chamado.getValorTotalChamado()};

                        modelo.addRow(linha);
                    }
                    
                
                }
        
        tblAtributos.setModel(modelo);
        
        tblAtributos.getColumnModel().getColumn(0).setPreferredWidth(15);
        tblAtributos.getColumnModel().getColumn(1).setPreferredWidth(35);
        tblAtributos.getColumnModel().getColumn(2).setPreferredWidth(75);
        tblAtributos.getColumnModel().getColumn(3).setPreferredWidth(50);
        tblAtributos.getColumnModel().getColumn(4).setPreferredWidth(75);
        tblAtributos.getColumnModel().getColumn(5).setPreferredWidth(75);
        tblAtributos.getColumnModel().getColumn(6).setPreferredWidth(35);
        tblAtributos.getColumnModel().getColumn(7).setPreferredWidth(50);
        tblAtributos.getColumnModel().getColumn(8).setPreferredWidth(15);
        
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnFecharVerChamados = new javax.swing.JButton();
        pnlFazer = new javax.swing.JPanel();
        jblFazerChamado = new javax.swing.JLabel();
        jblID = new javax.swing.JLabel();
        lblMostrarId = new javax.swing.JLabel();
        jblNomeCliente = new javax.swing.JLabel();
        cbxCliente = new javax.swing.JComboBox<>();
        jblTipoChamado = new javax.swing.JLabel();
        cbxTipo = new javax.swing.JComboBox<>();
        jblOrigem = new javax.swing.JLabel();
        jblsetOrigemViagem = new javax.swing.JTextField();
        jblDestino = new javax.swing.JLabel();
        jblsetDestinoViagem = new javax.swing.JTextField();
        jblKmInicial = new javax.swing.JLabel();
        jblKmFinal = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnNovoChamado = new javax.swing.JButton();
        btnLimparChamado = new javax.swing.JButton();
        btnCancelarChamado = new javax.swing.JButton();
        btnSalvarChamado = new javax.swing.JButton();
        spnKmInicial = new javax.swing.JSpinner();
        spnKmFinal = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        cbxVeiculo = new javax.swing.JComboBox<>();
        pnlVer = new javax.swing.JPanel();
        jblVerchamados = new javax.swing.JLabel();
        jblPesquisar = new javax.swing.JLabel();
        tfPesquisar = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        jsp = new javax.swing.JScrollPane();
        tblAtributos = new javax.swing.JTable();
        jblClientesAtendidos = new javax.swing.JLabel();
        jblQuantAtendidos = new javax.swing.JLabel();
        jblKmPercorrido = new javax.swing.JLabel();
        jblMostrarKmPercorridos = new javax.swing.JLabel();
        jblFaturamentoTotal = new javax.swing.JLabel();
        jblMostrarFaturamentoTotal = new javax.swing.JLabel();
        btnDeletar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnFecharVerChamados.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnFecharVerChamados.setText("Fechar");
        btnFecharVerChamados.setToolTipText("Volte para a tela inicial");
        btnFecharVerChamados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharVerChamadosActionPerformed(evt);
            }
        });

        jblFazerChamado.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jblFazerChamado.setText("FAZER CHAMADO");

        jblID.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jblID.setText("Id:");

        lblMostrarId.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblMostrarId.setText("Mostrar Id");

        jblNomeCliente.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jblNomeCliente.setText("Clientes");

        cbxCliente.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        jblTipoChamado.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jblTipoChamado.setText("Tipo:");

        cbxTipo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        cbxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Corrida", "Viagem" }));
        cbxTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTipoActionPerformed(evt);
            }
        });

        jblOrigem.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jblOrigem.setText("Origem");

        jblsetOrigemViagem.setToolTipText("Insira o local de origem");
        jblsetOrigemViagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jblsetOrigemViagemActionPerformed(evt);
            }
        });

        jblDestino.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jblDestino.setText("Destino");

        jblsetDestinoViagem.setToolTipText("Insira o local de destino");
        jblsetDestinoViagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jblsetDestinoViagemActionPerformed(evt);
            }
        });

        jblKmInicial.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jblKmInicial.setText("KmInicial");

        jblKmFinal.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jblKmFinal.setText("KmFinal");

        btnNovoChamado.setText("Novo");
        btnNovoChamado.setToolTipText("Limpe todos os campos");
        btnNovoChamado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoChamadoActionPerformed(evt);
            }
        });

        btnLimparChamado.setText("Limpar");
        btnLimparChamado.setToolTipText("Limpe todos os campos");
        btnLimparChamado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparChamadoActionPerformed(evt);
            }
        });

        btnCancelarChamado.setText("Cancelar");
        btnCancelarChamado.setToolTipText("Cancelar criação do chamado");
        btnCancelarChamado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarChamadoActionPerformed(evt);
            }
        });

        btnSalvarChamado.setText("Salvar");
        btnSalvarChamado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarChamadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnNovoChamado, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(btnLimparChamado, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btnCancelarChamado, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(btnSalvarChamado, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNovoChamado, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimparChamado, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelarChamado, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalvarChamado, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        spnKmInicial.setModel(new javax.swing.SpinnerNumberModel(0.0d, null, null, 1.0d));

        spnKmFinal.setModel(new javax.swing.SpinnerNumberModel(0.0d, null, null, 1.0d));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Veiculo");

        cbxVeiculo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        cbxVeiculo.setPreferredSize(new java.awt.Dimension(108, 41));

        javax.swing.GroupLayout pnlFazerLayout = new javax.swing.GroupLayout(pnlFazer);
        pnlFazer.setLayout(pnlFazerLayout);
        pnlFazerLayout.setHorizontalGroup(
            pnlFazerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFazerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlFazerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFazerLayout.createSequentialGroup()
                        .addGroup(pnlFazerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlFazerLayout.createSequentialGroup()
                                .addGap(215, 215, 215)
                                .addComponent(jblFazerChamado))
                            .addGroup(pnlFazerLayout.createSequentialGroup()
                                .addGroup(pnlFazerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(pnlFazerLayout.createSequentialGroup()
                                        .addComponent(jblNomeCliente)
                                        .addGap(38, 38, 38)
                                        .addComponent(cbxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlFazerLayout.createSequentialGroup()
                                        .addComponent(jblID)
                                        .addGap(20, 20, 20)
                                        .addComponent(lblMostrarId)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(39, 39, 39)
                                .addGroup(pnlFazerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jblTipoChamado)
                                    .addComponent(jLabel1))
                                .addGap(63, 63, 63)
                                .addGroup(pnlFazerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbxTipo, 0, 247, Short.MAX_VALUE)
                                    .addComponent(cbxVeiculo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(pnlFazerLayout.createSequentialGroup()
                                .addGroup(pnlFazerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jblOrigem)
                                    .addComponent(jblKmInicial))
                                .addGap(27, 27, 27)
                                .addGroup(pnlFazerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlFazerLayout.createSequentialGroup()
                                        .addComponent(jblsetOrigemViagem, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(41, 41, 41)
                                        .addComponent(jblDestino))
                                    .addGroup(pnlFazerLayout.createSequentialGroup()
                                        .addComponent(spnKmInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(155, 155, 155)
                                        .addComponent(jblKmFinal)))
                                .addGap(35, 35, 35)
                                .addGroup(pnlFazerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jblsetDestinoViagem, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(spnKmFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(9, 9, 9))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFazerLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 618, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81))))
        );
        pnlFazerLayout.setVerticalGroup(
            pnlFazerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFazerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jblFazerChamado)
                .addGap(15, 15, 15)
                .addGroup(pnlFazerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlFazerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jblID)
                        .addComponent(lblMostrarId))
                    .addGroup(pnlFazerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(cbxVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24)
                .addGroup(pnlFazerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFazerLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jblNomeCliente))
                    .addComponent(cbxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jblTipoChamado)
                    .addComponent(cbxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlFazerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFazerLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jblOrigem))
                    .addComponent(jblsetOrigemViagem, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlFazerLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jblDestino))
                    .addComponent(jblsetDestinoViagem, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(pnlFazerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFazerLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(pnlFazerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jblKmInicial)
                            .addComponent(spnKmInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlFazerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jblKmFinal)
                        .addComponent(spnKmFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jblVerchamados.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jblVerchamados.setText("Ver chamados");

        jblPesquisar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jblPesquisar.setText("Pesquisar");

        tfPesquisar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        tfPesquisar.setToolTipText("Insira o valor de pesquisa de acordo com o filtro");

        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/IconPesquisar.png"))); // NOI18N
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        tblAtributos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Data", "Cliente", "CPF", "Origem", "Destino", "Veiculo", "Tipo", "Valor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jsp.setViewportView(tblAtributos);

        jblClientesAtendidos.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jblClientesAtendidos.setText("Clientes atendidos:");

        jblQuantAtendidos.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        jblKmPercorrido.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jblKmPercorrido.setText(" Km percorrido(s):");

        jblMostrarKmPercorridos.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        jblFaturamentoTotal.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jblFaturamentoTotal.setText("Faturamento total:");

        jblMostrarFaturamentoTotal.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        btnDeletar.setText("Deletar");
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlVerLayout = new javax.swing.GroupLayout(pnlVer);
        pnlVer.setLayout(pnlVerLayout);
        pnlVerLayout.setHorizontalGroup(
            pnlVerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlVerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jsp)
                    .addGroup(pnlVerLayout.createSequentialGroup()
                        .addComponent(jblClientesAtendidos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jblQuantAtendidos, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jblKmPercorrido)
                        .addGap(18, 18, 18)
                        .addComponent(jblMostrarKmPercorridos, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jblFaturamentoTotal)
                        .addGap(18, 18, 18)
                        .addComponent(jblMostrarFaturamentoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 15, Short.MAX_VALUE))
                    .addGroup(pnlVerLayout.createSequentialGroup()
                        .addComponent(jblPesquisar)
                        .addGap(18, 18, 18)
                        .addComponent(tfPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(btnPesquisar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDeletar)
                        .addGap(32, 32, 32)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlVerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jblVerchamados)
                .addGap(374, 374, 374))
        );
        pnlVerLayout.setVerticalGroup(
            pnlVerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jblVerchamados)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlVerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlVerLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jblPesquisar))
                    .addGroup(pnlVerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnDeletar)
                        .addComponent(btnPesquisar)))
                .addGap(28, 28, 28)
                .addComponent(jsp, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlVerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jblMostrarKmPercorridos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jblMostrarFaturamentoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlVerLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(pnlVerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jblClientesAtendidos)
                            .addComponent(jblQuantAtendidos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jblFaturamentoTotal)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlVerLayout.createSequentialGroup()
                        .addComponent(jblKmPercorrido)
                        .addGap(2, 2, 2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(471, 471, 471)
                        .addComponent(btnFecharVerChamados, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(pnlVer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(pnlFazer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(pnlFazer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlVer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(btnFecharVerChamados, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private String getDateTime(Date data) {
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	return dateFormat.format(data);
    }
    
    public Cliente getClienteCbx(){
        Cliente cliente = null;
        for(Object objeto:clientes){
            cliente = (Cliente) objeto;
            if(cbxCliente.getItemAt(cbxCliente.getSelectedIndex()).contains(cliente.getCPF())){
                break;
                
            }
        }
        return cliente;
    }
    
    private Carro getCarroCbx(){
        Carro veiculo = null;
        for(Object objeto:veiculos){
           veiculo = (Carro) objeto;
           if(cbxVeiculo.getItemAt(cbxVeiculo.getSelectedIndex()).contains(veiculo.getPlaca())){
               break;
           }
           
        }
        return veiculo;
    }
    
    private Chamado registrarChamado(){
        Chamado chamado = null;
        if(jblsetOrigemViagem.getText().isEmpty() == true
            || jblsetDestinoViagem.getText().isEmpty() == true
            || cbxCliente.getSelectedIndex() == -1
            || cbxVeiculo.getSelectedIndex() == -1
            || (Double) spnKmFinal.getValue() <= 0)
        {
            JOptionPane.showMessageDialog(null, "Todos os campos devem estar preenchidos para o chamado ser criado","ERRO",JOptionPane.ERROR_MESSAGE);
            
        }else{
        
            double kmInicial =  (Double) spnKmInicial.getValue();
            double kmFinal =  (Double) spnKmFinal.getValue();
            double valor = (kmFinal - kmInicial) * 1.8d;
            //Cria o chamado com os valores recebidos
            
            chamado = new Chamado(id,
                cbxTipo.getItemAt(cbxTipo.getSelectedIndex()),
                jblsetOrigemViagem.getText(),
                jblsetDestinoViagem.getText(),
                kmInicial,
                kmFinal,
                valor,
                getClienteCbx(),
                getCarroCbx(),
                dataAtual.getTime());
            
            JOptionPane.showMessageDialog(null, "Chamado cadastrado com suceso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            
        }
        
        return chamado;
    }
    
    public void obterLinhaSelect() {
        tblAtributos.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                if (event.getValueIsAdjusting()) {
                    return; // Ignora eventos intermediários
                }
                
                int selectedRow = tblAtributos.getSelectedRow();
                // Verifica se alguma linha foi selecionada
                if (selectedRow != -1) {
                    // Obtém os valores da linha selecionada
                   linhaSelecionada = selectedRow;
                   btnDeletar.setEnabled(true);
                   
                }else{
                    linhaSelecionada = -1;
                    btnDeletar.setEnabled(false);
                }
            }
        });
    }
    
    private void jblsetDestinoViagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jblsetDestinoViagemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jblsetDestinoViagemActionPerformed

    private void jblsetOrigemViagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jblsetOrigemViagemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jblsetOrigemViagemActionPerformed

    private void btnLimparChamadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparChamadoActionPerformed
        jblsetOrigemViagem.requestFocus();
       
        jblsetDestinoViagem.setText(null);
        jblsetOrigemViagem.setText(null);
        spnKmInicial.setValue(0);
        spnKmFinal.setValue(0);
        
    }//GEN-LAST:event_btnLimparChamadoActionPerformed

    private void btnSalvarChamadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarChamadoActionPerformed

            chamados.add(registrarChamado());
            
            Empacotamento.gravarArquivoBinario(chamados, "chamados");
            
            jblQuantAtendidos.setText(Integer.toString(chamados.size()));
            jblMostrarKmPercorridos.setText(Double.toString(totalKmPercorrido()) + "Km");
            jblMostrarFaturamentoTotal.setText("R$ " + Double.toString(faturamentoTotal()));
            
            carregarTabelaChamados(tfPesquisar.getText());
            
            //Habilita o botão para fazer novo chamado
            btnNovoChamado.setEnabled(true);
           
            //Desabilida os inputs
            cbxTipo.setEnabled(false);
            cbxCliente.setEnabled(false);
            cbxVeiculo.setEnabled(false);
            jblsetDestinoViagem.setEnabled(false);
            jblsetOrigemViagem.setEnabled(false);
            spnKmInicial.setEnabled(false);
            spnKmFinal.setEnabled(false);
            
            spnKmInicial.setValue(0d);
            spnKmFinal.setValue(0d);

            // Desabilita os botões 
            btnLimparChamado.setEnabled(false);
            btnCancelarChamado.setEnabled(false);
            btnSalvarChamado.setEnabled(false);
    }//GEN-LAST:event_btnSalvarChamadoActionPerformed

    private void btnNovoChamadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoChamadoActionPerformed
        
        //Habilitar entradas
        cbxTipo.setEnabled(true);
        cbxCliente.setEnabled(true);
        cbxVeiculo.setEnabled(true);
        jblsetDestinoViagem.setEnabled(true);
        jblsetOrigemViagem.setEnabled(true);
        spnKmInicial.setEnabled(true);
        spnKmFinal.setEnabled(true);

        
        //Habilitar botões 
        btnLimparChamado.setEnabled(true);
        btnSalvarChamado.setEnabled(true);
        btnCancelarChamado.setEnabled(true);
        
        //botar cursor no primiro campo
        jblsetOrigemViagem.requestFocus();
        
        //Desabilitar botão de novo chamado
        btnNovoChamado.setEnabled(false);
        
        //Gerar Id
        Random gerador = new Random();
        id = gerador.nextInt(999);
        
        lblMostrarId.setText(Integer.toString(id));
        
        //Limpar entradas
        jblsetDestinoViagem.setText(null);
        jblsetOrigemViagem.setText(null);
        spnKmInicial.setValue(0d);
        spnKmFinal.setValue(0d);
        
        
    }//GEN-LAST:event_btnNovoChamadoActionPerformed

    private void btnCancelarChamadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarChamadoActionPerformed
        //Desabilitar entradas
        jblNomeCliente.setEnabled(false);
        jblsetDestinoViagem.setEnabled(false);
        jblsetOrigemViagem.setEnabled(false);
        spnKmInicial.setEnabled(false);
        spnKmFinal.setEnabled(false);
        lblMostrarId.setText("000");
        
        //Desabilitar botões 
        btnLimparChamado.setEnabled(false);
        btnSalvarChamado.setEnabled(false);
        btnCancelarChamado.setEnabled(false);
        btnNovoChamado.setEnabled(true);
    }//GEN-LAST:event_btnCancelarChamadoActionPerformed

    private void btnFecharVerChamadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharVerChamadosActionPerformed

        this.setVisible(false);
        new Index().setVisible(true);
    }//GEN-LAST:event_btnFecharVerChamadosActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        if(chamados.isEmpty()){
            JOptionPane.showMessageDialog(null,"Voce não possui chamados salvos, faça um para pesquisar","ERRO",JOptionPane.ERROR_MESSAGE);
        }else{
            carregarTabelaChamados(tfPesquisar.getText());
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void cbxTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxTipoActionPerformed

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
        // TODO add your handling code here:
        if(linhaSelecionada != -1){
            chamados.remove(linhaSelecionada);
            Empacotamento.gravarArquivoBinario(chamados, "chamados");

            carregarTabelaChamados(tfPesquisar.getText());
        }
    }//GEN-LAST:event_btnDeletarActionPerformed

    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FazerChamado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FazerChamado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FazerChamado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FazerChamado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FazerChamado().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarChamado;
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnFecharVerChamados;
    private javax.swing.JButton btnLimparChamado;
    private javax.swing.JButton btnNovoChamado;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSalvarChamado;
    private javax.swing.JComboBox<String> cbxCliente;
    private javax.swing.JComboBox<String> cbxTipo;
    private javax.swing.JComboBox<String> cbxVeiculo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel jblClientesAtendidos;
    private javax.swing.JLabel jblDestino;
    private javax.swing.JLabel jblFaturamentoTotal;
    private javax.swing.JLabel jblFazerChamado;
    private javax.swing.JLabel jblID;
    private javax.swing.JLabel jblKmFinal;
    private javax.swing.JLabel jblKmInicial;
    private javax.swing.JLabel jblKmPercorrido;
    private javax.swing.JLabel jblMostrarFaturamentoTotal;
    private javax.swing.JLabel jblMostrarKmPercorridos;
    private javax.swing.JLabel jblNomeCliente;
    private javax.swing.JLabel jblOrigem;
    private javax.swing.JLabel jblPesquisar;
    private javax.swing.JLabel jblQuantAtendidos;
    private javax.swing.JLabel jblTipoChamado;
    private javax.swing.JLabel jblVerchamados;
    private javax.swing.JTextField jblsetDestinoViagem;
    private javax.swing.JTextField jblsetOrigemViagem;
    private javax.swing.JScrollPane jsp;
    private javax.swing.JLabel lblMostrarId;
    private javax.swing.JPanel pnlFazer;
    private javax.swing.JPanel pnlVer;
    private javax.swing.JSpinner spnKmFinal;
    private javax.swing.JSpinner spnKmInicial;
    private javax.swing.JTable tblAtributos;
    private javax.swing.JTextField tfPesquisar;
    // End of variables declaration//GEN-END:variables
}
