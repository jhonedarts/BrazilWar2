/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package war.view;

import java.util.HashMap;
import javax.swing.JOptionPane;
import war.controller.Jogo;
import war.controller.Mapa;
import war.parametros.Parametros;
/**
 *
 * @author jhone
 */
public class Main extends javax.swing.JFrame {
    private String comando = "";
    private int jogadoresQtd = 0;
    private Mapa mapa = null;
    private Jogo jogo = null;
    private Parametros parametros = null;
    private HashMap<String, javax.swing.JLabel> pinosCor1 = new HashMap<>();
    private HashMap<String, javax.swing.JLabel> pinosCor2 = new HashMap<>();
    private HashMap<String, javax.swing.JLabel> pinosQtd1 = new HashMap<>();
    private HashMap<String, javax.swing.JLabel> pinosQtd2 = new HashMap<>();
    /**
     * 1 - ataque
     * 2 - remanejar
     */
    /**
     * Creates new form Main
     */
    public Main() {
        
        initComponents();
        
        pinosCor1.put("AC", ACpin);
        pinosCor1.put("AP", APpin);
        pinosCor1.put("AM", AMpin);
        pinosCor1.put("PA", PApin);
        pinosCor1.put("RO", RDpin);
        pinosCor1.put("RR", RRpin);
        pinosCor1.put("AL", ALpin);
        pinosCor1.put("BA", BApin);
        pinosCor1.put("CE", CEpin);
        pinosCor1.put("MA", MApin);
        pinosCor1.put("PB", PBpin);
        pinosCor1.put("PE", PEpin);
        pinosCor1.put("PI", PIpin);
        pinosCor1.put("RN", RNpin);
        pinosCor1.put("SE", SEpin);
        pinosCor1.put("GO", GOpin);
        pinosCor1.put("MT", MTpin);
        pinosCor1.put("ES", ESpin);
        pinosCor1.put("MG", MGpin);
        pinosCor1.put("SP", SPpin);
        pinosCor1.put("RJ", RJpin);
        pinosCor1.put("PR", PRpin);
        pinosCor1.put("SC", SCpin);
        pinosCor1.put("RS", RSpin);
        
        pinosQtd1.put("AC", ACpin1);
        pinosQtd1.put("AP", APpin1);
        pinosQtd1.put("AM", AMpin1);
        pinosQtd1.put("PA", PApin1);
        pinosQtd1.put("RO", RDpin1);
        pinosQtd1.put("RR", RRpin1);
        pinosQtd1.put("AL", ALpin1);
        pinosQtd1.put("BA", BApin1);
        pinosQtd1.put("CE", CEpin1);
        pinosQtd1.put("MA", MApin1);
        pinosQtd1.put("PB", PBpin1);
        pinosQtd1.put("PE", PEpin1);
        pinosQtd1.put("PI", PIpin1);
        pinosQtd1.put("RN", RNpin1);
        pinosQtd1.put("SE", SEpin1);
        pinosQtd1.put("GO", GOpin1);
        pinosQtd1.put("MT", MTpin1);
        pinosQtd1.put("ES", ESpin1);
        pinosQtd1.put("MG", MGpin1);
        pinosQtd1.put("SP", SPpin1);
        pinosQtd1.put("RJ", RJpin1);
        pinosQtd1.put("PR", PRpin1);
        pinosQtd1.put("SC", SCpin1);
        pinosQtd1.put("RS", RSpin1);
        
        //war2
        pinosCor2.put("AC", ACpin2);
        pinosCor2.put("AP", APpin2);
        pinosCor2.put("AM", AMpin2);
        pinosCor2.put("PA", PApin2);
        pinosCor2.put("RO", RDpin2);
        pinosCor2.put("RR", RRpin2);
        pinosCor2.put("AL", ALpin2);
        pinosCor2.put("BA", BApin2);
        pinosCor2.put("CE", CEpin2);
        pinosCor2.put("MA", MApin2);
        pinosCor2.put("PB", PBpin2);
        pinosCor2.put("PE", PEpin2);
        pinosCor2.put("MS", MSpin2);
        pinosCor2.put("TO", TOpin2);
        pinosCor2.put("PI", PIpin2);
        pinosCor2.put("RN", RNpin2);
        pinosCor2.put("SE", SEpin2);
        pinosCor2.put("GO", GOpin2);
        pinosCor2.put("MT", MTpin2);
        pinosCor2.put("ES", ESpin2);
        pinosCor2.put("MG", MGpin2);
        pinosCor2.put("SP", SPpin2);
        pinosCor2.put("RJ", RJpin2);
        pinosCor2.put("PR", PRpin2);
        pinosCor2.put("SC", SCpin2);
        pinosCor2.put("RS", RSpin2);
        
        pinosQtd2.put("AC", ACpin3);
        pinosQtd2.put("AP", APpin3);
        pinosQtd2.put("AM", AMpin3);
        pinosQtd2.put("PA", PApin3);
        pinosQtd2.put("RO", RDpin3);
        pinosQtd2.put("RR", RRpin3);
        pinosQtd2.put("AL", ALpin3);
        pinosQtd2.put("BA", BApin3);
        pinosQtd2.put("CE", CEpin3);
        pinosQtd2.put("MA", MApin3);
        pinosQtd2.put("PB", PBpin3);
        pinosQtd2.put("PE", PEpin3);
        pinosQtd2.put("MS", MSpin3);
        pinosQtd2.put("TO", TOpin3);
        pinosQtd2.put("PI", PIpin3);
        pinosQtd2.put("RN", RNpin3);
        pinosQtd2.put("SE", SEpin3);
        pinosQtd2.put("GO", GOpin3);
        pinosQtd2.put("MT", MTpin3);
        pinosQtd2.put("ES", ESpin3);
        pinosQtd2.put("MG", MGpin3);
        pinosQtd2.put("SP", SPpin3);
        pinosQtd2.put("RJ", RJpin3);
        pinosQtd2.put("PR", PRpin3);
        pinosQtd2.put("SC", SCpin3);
        pinosQtd2.put("RS", RSpin3);
    }
    
    private void mapUpdate(){
        for (String state : parametros.getEstados()){
            System.out.println("state " +mapa.getCorDoEstado(state));
            if(parametros.getVersao() == 1){
                pinosQtd1.get(state).setText(mapa.getQtdSoldados(state)+"x");
                pinosCor1.get(state).setIcon(new javax.swing.ImageIcon(getClass().getResource("/war/images/"+mapa.getCorDoEstado(state)+"Pin.jpg")));            
            }else if (parametros.getVersao() == 2){
                pinosQtd2.get(state).setText(mapa.getQtdSoldados(state)+"x");
                pinosCor2.get(state).setIcon(new javax.swing.ImageIcon(getClass().getResource("/war/images/"+mapa.getCorDoEstado(state)+"Pin.jpg"))); 
            }                       
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        inicioPanel = new javax.swing.JPanel();
        javax.swing.JButton selecionar2Button = new javax.swing.JButton();
        javax.swing.JButton selecionar1Button = new javax.swing.JButton();
        escolhaJogoLabel = new javax.swing.JLabel();
        backgroundInicio = new javax.swing.JLabel();
        war1Panel = new javax.swing.JPanel();
        ACpin = new javax.swing.JLabel();
        PApin = new javax.swing.JLabel();
        RDpin = new javax.swing.JLabel();
        AMpin = new javax.swing.JLabel();
        GOpin = new javax.swing.JLabel();
        RRpin = new javax.swing.JLabel();
        APpin = new javax.swing.JLabel();
        MTpin = new javax.swing.JLabel();
        MApin = new javax.swing.JLabel();
        PIpin = new javax.swing.JLabel();
        SPpin = new javax.swing.JLabel();
        BApin = new javax.swing.JLabel();
        RJpin = new javax.swing.JLabel();
        PRpin = new javax.swing.JLabel();
        SEpin = new javax.swing.JLabel();
        MGpin = new javax.swing.JLabel();
        RSpin = new javax.swing.JLabel();
        SCpin = new javax.swing.JLabel();
        ALpin = new javax.swing.JLabel();
        PEpin = new javax.swing.JLabel();
        PBpin = new javax.swing.JLabel();
        CEpin = new javax.swing.JLabel();
        RNpin = new javax.swing.JLabel();
        ESpin = new javax.swing.JLabel();
        ACpin1 = new javax.swing.JLabel();
        PApin1 = new javax.swing.JLabel();
        RDpin1 = new javax.swing.JLabel();
        AMpin1 = new javax.swing.JLabel();
        GOpin1 = new javax.swing.JLabel();
        RRpin1 = new javax.swing.JLabel();
        APpin1 = new javax.swing.JLabel();
        MTpin1 = new javax.swing.JLabel();
        MApin1 = new javax.swing.JLabel();
        PIpin1 = new javax.swing.JLabel();
        SPpin1 = new javax.swing.JLabel();
        BApin1 = new javax.swing.JLabel();
        RJpin1 = new javax.swing.JLabel();
        PRpin1 = new javax.swing.JLabel();
        SEpin1 = new javax.swing.JLabel();
        MGpin1 = new javax.swing.JLabel();
        RSpin1 = new javax.swing.JLabel();
        SCpin1 = new javax.swing.JLabel();
        ALpin1 = new javax.swing.JLabel();
        PEpin1 = new javax.swing.JLabel();
        PBpin1 = new javax.swing.JLabel();
        CEpin1 = new javax.swing.JLabel();
        RNpin1 = new javax.swing.JLabel();
        ESpin1 = new javax.swing.JLabel();
        map1 = new javax.swing.JLabel();
        rodadaLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jogadorLabel = new javax.swing.JLabel();
        atacarButton = new javax.swing.JButton();
        remanejarButton = new javax.swing.JButton();
        verCartasButton = new javax.swing.JButton();
        encerrarButton = new javax.swing.JButton();
        inputText = new javax.swing.JTextField();
        okButton = new javax.swing.JButton();
        tipsLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        consoleTextPane = new javax.swing.JTextPane();
        jLabel2 = new javax.swing.JLabel();
        war2Panel = new javax.swing.JPanel();
        PEpin3 = new javax.swing.JLabel();
        AMpin3 = new javax.swing.JLabel();
        RRpin3 = new javax.swing.JLabel();
        SPpin2 = new javax.swing.JLabel();
        RJpin3 = new javax.swing.JLabel();
        SCpin3 = new javax.swing.JLabel();
        CEpin2 = new javax.swing.JLabel();
        RDpin2 = new javax.swing.JLabel();
        BApin3 = new javax.swing.JLabel();
        GOpin3 = new javax.swing.JLabel();
        BApin2 = new javax.swing.JLabel();
        RSpin3 = new javax.swing.JLabel();
        ACpin3 = new javax.swing.JLabel();
        APpin2 = new javax.swing.JLabel();
        RNpin2 = new javax.swing.JLabel();
        RDpin3 = new javax.swing.JLabel();
        MApin2 = new javax.swing.JLabel();
        ALpin2 = new javax.swing.JLabel();
        CEpin3 = new javax.swing.JLabel();
        PApin2 = new javax.swing.JLabel();
        RSpin2 = new javax.swing.JLabel();
        PRpin3 = new javax.swing.JLabel();
        MGpin2 = new javax.swing.JLabel();
        PRpin2 = new javax.swing.JLabel();
        SEpin3 = new javax.swing.JLabel();
        ACpin2 = new javax.swing.JLabel();
        ESpin2 = new javax.swing.JLabel();
        MApin3 = new javax.swing.JLabel();
        SEpin2 = new javax.swing.JLabel();
        PBpin2 = new javax.swing.JLabel();
        RJpin2 = new javax.swing.JLabel();
        PIpin3 = new javax.swing.JLabel();
        RNpin3 = new javax.swing.JLabel();
        ALpin3 = new javax.swing.JLabel();
        PIpin2 = new javax.swing.JLabel();
        RRpin2 = new javax.swing.JLabel();
        PBpin3 = new javax.swing.JLabel();
        MGpin3 = new javax.swing.JLabel();
        ESpin3 = new javax.swing.JLabel();
        APpin3 = new javax.swing.JLabel();
        GOpin2 = new javax.swing.JLabel();
        PEpin2 = new javax.swing.JLabel();
        PApin3 = new javax.swing.JLabel();
        SPpin3 = new javax.swing.JLabel();
        MTpin3 = new javax.swing.JLabel();
        MTpin2 = new javax.swing.JLabel();
        AMpin2 = new javax.swing.JLabel();
        SCpin2 = new javax.swing.JLabel();
        TOpin2 = new javax.swing.JLabel();
        TOpin3 = new javax.swing.JLabel();
        MSpin2 = new javax.swing.JLabel();
        MSpin3 = new javax.swing.JLabel();
        map2 = new javax.swing.JLabel();
        rodadaLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jogadorLabel1 = new javax.swing.JLabel();
        atacarButton1 = new javax.swing.JButton();
        remanejarButton1 = new javax.swing.JButton();
        verCartasButton1 = new javax.swing.JButton();
        encerrarButton1 = new javax.swing.JButton();
        inputText1 = new javax.swing.JTextField();
        okButton1 = new javax.swing.JButton();
        tipsLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        consoleTextPane1 = new javax.swing.JTextPane();
        jLabel4 = new javax.swing.JLabel();
        ataqueAereoButton = new javax.swing.JButton();
        trocarCartaAviaoButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Brazil War");
        setName("frame1"); // NOI18N
        setPreferredSize(new java.awt.Dimension(900, 600));
        getContentPane().setLayout(new java.awt.CardLayout());

        inicioPanel.setLayout(null);

        selecionar2Button.setText("Selecionar WAR 2");
        selecionar2Button.setActionCommand("selecionarWar1");
        selecionar2Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selecionar2ButtonActionPerformed(evt);
            }
        });
        inicioPanel.add(selecionar2Button);
        selecionar2Button.setBounds(660, 350, 130, 23);

        selecionar1Button.setText("Selecionar WAR 1");
        selecionar1Button.setActionCommand("selecionarWar1");
        selecionar1Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selecionar1ButtonActionPerformed(evt);
            }
        });
        inicioPanel.add(selecionar1Button);
        selecionar1Button.setBounds(170, 500, 130, 23);

        escolhaJogoLabel.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        escolhaJogoLabel.setText("Escolha o jogo:");
        inicioPanel.add(escolhaJogoLabel);
        escolhaJogoLabel.setBounds(320, 20, 250, 60);

        backgroundInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/war/images/background-inicio.jpg"))); // NOI18N
        inicioPanel.add(backgroundInicio);
        backgroundInicio.setBounds(0, 0, 928, 600);

        getContentPane().add(inicioPanel, "card2");

        war1Panel.setLayout(null);

        ACpin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/war/images/blackPin.jpg"))); // NOI18N
        war1Panel.add(ACpin);
        ACpin.setBounds(60, 240, 25, 20);

        PApin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/war/images/blackPin.jpg"))); // NOI18N
        war1Panel.add(PApin);
        PApin.setBounds(260, 200, 25, 20);

        RDpin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/war/images/blackPin.jpg"))); // NOI18N
        war1Panel.add(RDpin);
        RDpin.setBounds(150, 230, 25, 20);

        AMpin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/war/images/blackPin.jpg"))); // NOI18N
        war1Panel.add(AMpin);
        AMpin.setBounds(170, 160, 25, 20);

        GOpin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/war/images/blackPin.jpg"))); // NOI18N
        war1Panel.add(GOpin);
        GOpin.setBounds(350, 260, 25, 20);

        RRpin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/war/images/blackPin.jpg"))); // NOI18N
        war1Panel.add(RRpin);
        RRpin.setBounds(200, 70, 25, 20);

        APpin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/war/images/blackPin.jpg"))); // NOI18N
        war1Panel.add(APpin);
        APpin.setBounds(310, 80, 25, 20);

        MTpin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/war/images/blackPin.jpg"))); // NOI18N
        war1Panel.add(MTpin);
        MTpin.setBounds(250, 280, 25, 20);

        MApin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/war/images/blackPin.jpg"))); // NOI18N
        war1Panel.add(MApin);
        MApin.setBounds(380, 140, 25, 20);

        PIpin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/war/images/blackPin.jpg"))); // NOI18N
        war1Panel.add(PIpin);
        PIpin.setBounds(400, 220, 25, 20);

        SPpin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/war/images/blackPin.jpg"))); // NOI18N
        war1Panel.add(SPpin);
        SPpin.setBounds(350, 400, 25, 20);

        BApin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/war/images/blackPin.jpg"))); // NOI18N
        war1Panel.add(BApin);
        BApin.setBounds(410, 280, 25, 20);

        RJpin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/war/images/blackPin.jpg"))); // NOI18N
        war1Panel.add(RJpin);
        RJpin.setBounds(430, 410, 25, 20);

        PRpin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/war/images/blackPin.jpg"))); // NOI18N
        war1Panel.add(PRpin);
        PRpin.setBounds(330, 430, 25, 20);

        SEpin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/war/images/blackPin.jpg"))); // NOI18N
        war1Panel.add(SEpin);
        SEpin.setBounds(500, 260, 25, 20);

        MGpin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/war/images/blackPin.jpg"))); // NOI18N
        war1Panel.add(MGpin);
        MGpin.setBounds(400, 320, 25, 20);

        RSpin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/war/images/blackPin.jpg"))); // NOI18N
        war1Panel.add(RSpin);
        RSpin.setBounds(280, 500, 25, 20);

        SCpin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/war/images/blackPin.jpg"))); // NOI18N
        war1Panel.add(SCpin);
        SCpin.setBounds(340, 460, 25, 20);

        ALpin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/war/images/blackPin.jpg"))); // NOI18N
        war1Panel.add(ALpin);
        ALpin.setBounds(520, 240, 25, 20);

        PEpin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/war/images/blackPin.jpg"))); // NOI18N
        war1Panel.add(PEpin);
        PEpin.setBounds(530, 220, 25, 20);

        PBpin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/war/images/blackPin.jpg"))); // NOI18N
        war1Panel.add(PBpin);
        PBpin.setBounds(540, 190, 25, 20);

        CEpin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/war/images/blackPin.jpg"))); // NOI18N
        war1Panel.add(CEpin);
        CEpin.setBounds(460, 140, 25, 20);

        RNpin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/war/images/blackPin.jpg"))); // NOI18N
        war1Panel.add(RNpin);
        RNpin.setBounds(510, 160, 25, 20);

        ESpin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/war/images/blackPin.jpg"))); // NOI18N
        war1Panel.add(ESpin);
        ESpin.setBounds(470, 370, 30, 20);

        ACpin1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ACpin1.setText("10x");
        war1Panel.add(ACpin1);
        ACpin1.setBounds(90, 240, 23, 20);

        PApin1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        PApin1.setText("10x");
        war1Panel.add(PApin1);
        PApin1.setBounds(290, 200, 23, 20);

        RDpin1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        RDpin1.setText("10x");
        war1Panel.add(RDpin1);
        RDpin1.setBounds(180, 230, 23, 20);

        AMpin1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        AMpin1.setText("10x");
        war1Panel.add(AMpin1);
        AMpin1.setBounds(200, 160, 23, 20);

        GOpin1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        GOpin1.setText("10x");
        war1Panel.add(GOpin1);
        GOpin1.setBounds(380, 260, 23, 20);

        RRpin1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        RRpin1.setText("10x");
        war1Panel.add(RRpin1);
        RRpin1.setBounds(230, 70, 23, 20);

        APpin1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        APpin1.setText("10x");
        war1Panel.add(APpin1);
        APpin1.setBounds(340, 80, 23, 20);

        MTpin1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        MTpin1.setText("10x");
        war1Panel.add(MTpin1);
        MTpin1.setBounds(280, 280, 23, 20);

        MApin1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        MApin1.setText("10x");
        war1Panel.add(MApin1);
        MApin1.setBounds(410, 140, 23, 20);

        PIpin1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        PIpin1.setText("10x");
        war1Panel.add(PIpin1);
        PIpin1.setBounds(430, 220, 23, 20);

        SPpin1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        SPpin1.setText("10x");
        war1Panel.add(SPpin1);
        SPpin1.setBounds(380, 400, 23, 20);

        BApin1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BApin1.setText("10x");
        war1Panel.add(BApin1);
        BApin1.setBounds(440, 280, 23, 20);

        RJpin1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        RJpin1.setText("10x");
        war1Panel.add(RJpin1);
        RJpin1.setBounds(460, 410, 23, 20);

        PRpin1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        PRpin1.setText("10x");
        war1Panel.add(PRpin1);
        PRpin1.setBounds(360, 430, 23, 20);

        SEpin1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        SEpin1.setText("10x");
        war1Panel.add(SEpin1);
        SEpin1.setBounds(530, 260, 23, 20);

        MGpin1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        MGpin1.setText("10x");
        war1Panel.add(MGpin1);
        MGpin1.setBounds(430, 320, 23, 20);

        RSpin1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        RSpin1.setText("10x");
        war1Panel.add(RSpin1);
        RSpin1.setBounds(310, 500, 23, 20);

        SCpin1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        SCpin1.setText("10x");
        war1Panel.add(SCpin1);
        SCpin1.setBounds(370, 460, 23, 20);

        ALpin1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ALpin1.setText("10x");
        war1Panel.add(ALpin1);
        ALpin1.setBounds(550, 240, 23, 20);

        PEpin1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        PEpin1.setText("10x");
        war1Panel.add(PEpin1);
        PEpin1.setBounds(560, 220, 23, 20);

        PBpin1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        PBpin1.setText("10x");
        war1Panel.add(PBpin1);
        PBpin1.setBounds(570, 190, 23, 20);

        CEpin1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        CEpin1.setText("10x");
        war1Panel.add(CEpin1);
        CEpin1.setBounds(490, 140, 23, 20);

        RNpin1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        RNpin1.setText("10x");
        war1Panel.add(RNpin1);
        RNpin1.setBounds(540, 160, 23, 20);

        ESpin1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ESpin1.setText("10x");
        war1Panel.add(ESpin1);
        ESpin1.setBounds(500, 370, 30, 20);

        map1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/war/images/map1.jpg"))); // NOI18N
        war1Panel.add(map1);
        map1.setBounds(0, 0, 589, 600);

        rodadaLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        rodadaLabel.setText("RODADA 1");
        rodadaLabel.setToolTipText("");
        war1Panel.add(rodadaLabel);
        rodadaLabel.setBounds(700, 50, 140, 30);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("É a vez do jogador ");
        war1Panel.add(jLabel1);
        jLabel1.setBounds(650, 100, 130, 20);

        jogadorLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jogadorLabel.setText("AZUL");
        war1Panel.add(jogadorLabel);
        jogadorLabel.setBounds(790, 100, 100, 20);

        atacarButton.setText("Atacar");
        atacarButton.setToolTipText("");
        atacarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atacarButtonActionPerformed(evt);
            }
        });
        war1Panel.add(atacarButton);
        atacarButton.setBounds(650, 150, 90, 23);

        remanejarButton.setText("Remanejar");
        remanejarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remanejarButtonActionPerformed(evt);
            }
        });
        war1Panel.add(remanejarButton);
        remanejarButton.setBounds(780, 150, 90, 23);

        verCartasButton.setText("Ver Cartas");
        verCartasButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verCartasButtonActionPerformed(evt);
            }
        });
        war1Panel.add(verCartasButton);
        verCartasButton.setBounds(650, 190, 90, 23);

        encerrarButton.setText("Encerrar");
        encerrarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                encerrarButtonActionPerformed(evt);
            }
        });
        war1Panel.add(encerrarButton);
        encerrarButton.setBounds(780, 190, 90, 23);

        inputText.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        inputText.setToolTipText("");
        war1Panel.add(inputText);
        inputText.setBounds(650, 230, 170, 30);

        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });
        war1Panel.add(okButton);
        okButton.setBounds(820, 230, 50, 30);

        tipsLabel.setText("Exemplo: GO-BA");
        tipsLabel.setToolTipText("");
        war1Panel.add(tipsLabel);
        tipsLabel.setBounds(650, 260, 220, 14);

        jScrollPane1.setViewportView(consoleTextPane);

        war1Panel.add(jScrollPane1);
        jScrollPane1.setBounds(650, 350, 220, 140);

        jLabel2.setText("CONSOLE");
        war1Panel.add(jLabel2);
        jLabel2.setBounds(650, 330, 60, 14);

        getContentPane().add(war1Panel, "card3");

        war2Panel.setLayout(null);

        PEpin3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        PEpin3.setText("10x");
        war2Panel.add(PEpin3);
        PEpin3.setBounds(570, 230, 23, 20);

        AMpin3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        AMpin3.setText("10x");
        war2Panel.add(AMpin3);
        AMpin3.setBounds(210, 170, 23, 20);

        RRpin3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        RRpin3.setText("10x");
        war2Panel.add(RRpin3);
        RRpin3.setBounds(240, 60, 23, 20);

        SPpin2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/war/images/greenPin.jpg"))); // NOI18N
        war2Panel.add(SPpin2);
        SPpin2.setBounds(360, 410, 25, 20);

        RJpin3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        RJpin3.setText("10x");
        war2Panel.add(RJpin3);
        RJpin3.setBounds(470, 420, 23, 20);

        SCpin3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        SCpin3.setText("10x");
        war2Panel.add(SCpin3);
        SCpin3.setBounds(380, 470, 23, 20);

        CEpin2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/war/images/greenPin.jpg"))); // NOI18N
        war2Panel.add(CEpin2);
        CEpin2.setBounds(470, 150, 25, 20);

        RDpin2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/war/images/greenPin.jpg"))); // NOI18N
        war2Panel.add(RDpin2);
        RDpin2.setBounds(170, 230, 25, 20);

        BApin3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BApin3.setText("10x");
        war2Panel.add(BApin3);
        BApin3.setBounds(450, 280, 23, 20);

        GOpin3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        GOpin3.setText("10x");
        war2Panel.add(GOpin3);
        GOpin3.setBounds(360, 340, 23, 20);

        BApin2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/war/images/greenPin.jpg"))); // NOI18N
        war2Panel.add(BApin2);
        BApin2.setBounds(420, 280, 25, 20);

        RSpin3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        RSpin3.setText("10x");
        war2Panel.add(RSpin3);
        RSpin3.setBounds(320, 510, 23, 20);

        ACpin3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ACpin3.setText("10x");
        war2Panel.add(ACpin3);
        ACpin3.setBounds(100, 240, 23, 20);

        APpin2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/war/images/greenPin.jpg"))); // NOI18N
        war2Panel.add(APpin2);
        APpin2.setBounds(320, 90, 25, 20);

        RNpin2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/war/images/greenPin.jpg"))); // NOI18N
        war2Panel.add(RNpin2);
        RNpin2.setBounds(520, 170, 25, 20);

        RDpin3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        RDpin3.setText("10x");
        war2Panel.add(RDpin3);
        RDpin3.setBounds(200, 230, 23, 20);

        MApin2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/war/images/greenPin.jpg"))); // NOI18N
        war2Panel.add(MApin2);
        MApin2.setBounds(390, 150, 25, 20);

        ALpin2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/war/images/greenPin.jpg"))); // NOI18N
        war2Panel.add(ALpin2);
        ALpin2.setBounds(530, 250, 25, 20);

        CEpin3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        CEpin3.setText("10x");
        war2Panel.add(CEpin3);
        CEpin3.setBounds(500, 150, 23, 20);

        PApin2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/war/images/greenPin.jpg"))); // NOI18N
        war2Panel.add(PApin2);
        PApin2.setBounds(270, 210, 25, 20);

        RSpin2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/war/images/greenPin.jpg"))); // NOI18N
        war2Panel.add(RSpin2);
        RSpin2.setBounds(290, 510, 25, 20);

        PRpin3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        PRpin3.setText("10x");
        war2Panel.add(PRpin3);
        PRpin3.setBounds(360, 430, 23, 20);

        MGpin2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/war/images/greenPin.jpg"))); // NOI18N
        war2Panel.add(MGpin2);
        MGpin2.setBounds(410, 330, 25, 20);

        PRpin2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/war/images/greenPin.jpg"))); // NOI18N
        war2Panel.add(PRpin2);
        PRpin2.setBounds(330, 430, 25, 20);

        SEpin3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        SEpin3.setText("10x");
        war2Panel.add(SEpin3);
        SEpin3.setBounds(540, 270, 23, 20);

        ACpin2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/war/images/greenPin.jpg"))); // NOI18N
        war2Panel.add(ACpin2);
        ACpin2.setBounds(70, 240, 25, 20);

        ESpin2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/war/images/greenPin.jpg"))); // NOI18N
        war2Panel.add(ESpin2);
        ESpin2.setBounds(480, 380, 30, 20);

        MApin3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        MApin3.setText("10x");
        war2Panel.add(MApin3);
        MApin3.setBounds(420, 150, 23, 20);

        SEpin2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/war/images/greenPin.jpg"))); // NOI18N
        war2Panel.add(SEpin2);
        SEpin2.setBounds(510, 270, 25, 20);

        PBpin2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/war/images/greenPin.jpg"))); // NOI18N
        war2Panel.add(PBpin2);
        PBpin2.setBounds(550, 200, 25, 20);

        RJpin2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/war/images/greenPin.jpg"))); // NOI18N
        war2Panel.add(RJpin2);
        RJpin2.setBounds(440, 420, 25, 20);

        PIpin3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        PIpin3.setText("10x");
        war2Panel.add(PIpin3);
        PIpin3.setBounds(440, 220, 23, 20);

        RNpin3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        RNpin3.setText("10x");
        war2Panel.add(RNpin3);
        RNpin3.setBounds(550, 170, 23, 20);

        ALpin3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ALpin3.setText("10x");
        war2Panel.add(ALpin3);
        ALpin3.setBounds(560, 250, 23, 20);

        PIpin2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/war/images/greenPin.jpg"))); // NOI18N
        war2Panel.add(PIpin2);
        PIpin2.setBounds(410, 220, 25, 20);

        RRpin2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/war/images/greenPin.jpg"))); // NOI18N
        war2Panel.add(RRpin2);
        RRpin2.setBounds(210, 60, 25, 20);

        PBpin3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        PBpin3.setText("10x");
        war2Panel.add(PBpin3);
        PBpin3.setBounds(580, 200, 23, 20);

        MGpin3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        MGpin3.setText("10x");
        war2Panel.add(MGpin3);
        MGpin3.setBounds(440, 330, 23, 20);

        ESpin3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ESpin3.setText("10x");
        war2Panel.add(ESpin3);
        ESpin3.setBounds(510, 380, 30, 20);

        APpin3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        APpin3.setText("10x");
        war2Panel.add(APpin3);
        APpin3.setBounds(350, 90, 23, 20);

        GOpin2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/war/images/greenPin.jpg"))); // NOI18N
        war2Panel.add(GOpin2);
        GOpin2.setBounds(330, 340, 25, 20);

        PEpin2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/war/images/greenPin.jpg"))); // NOI18N
        war2Panel.add(PEpin2);
        PEpin2.setBounds(540, 230, 25, 20);

        PApin3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        PApin3.setText("10x");
        war2Panel.add(PApin3);
        PApin3.setBounds(300, 210, 23, 20);

        SPpin3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        SPpin3.setText("10x");
        war2Panel.add(SPpin3);
        SPpin3.setBounds(390, 410, 23, 20);

        MTpin3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        MTpin3.setText("10x");
        war2Panel.add(MTpin3);
        MTpin3.setBounds(290, 300, 23, 20);

        MTpin2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/war/images/greenPin.jpg"))); // NOI18N
        war2Panel.add(MTpin2);
        MTpin2.setBounds(260, 300, 25, 20);

        AMpin2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/war/images/greenPin.jpg"))); // NOI18N
        war2Panel.add(AMpin2);
        AMpin2.setBounds(180, 170, 25, 20);

        SCpin2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/war/images/greenPin.jpg"))); // NOI18N
        war2Panel.add(SCpin2);
        SCpin2.setBounds(350, 470, 25, 20);

        TOpin2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/war/images/greenPin.jpg"))); // NOI18N
        war2Panel.add(TOpin2);
        TOpin2.setBounds(350, 260, 25, 20);

        TOpin3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        TOpin3.setText("10x");
        war2Panel.add(TOpin3);
        TOpin3.setBounds(380, 260, 23, 20);

        MSpin2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/war/images/greenPin.jpg"))); // NOI18N
        war2Panel.add(MSpin2);
        MSpin2.setBounds(260, 390, 25, 20);

        MSpin3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        MSpin3.setText("10x");
        war2Panel.add(MSpin3);
        MSpin3.setBounds(290, 390, 23, 20);

        map2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/war/images/map2.jpg"))); // NOI18N
        war2Panel.add(map2);
        map2.setBounds(0, 0, 600, 600);

        rodadaLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        rodadaLabel1.setText("RODADA 1");
        rodadaLabel1.setToolTipText("");
        war2Panel.add(rodadaLabel1);
        rodadaLabel1.setBounds(700, 50, 140, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("É a vez do jogador ");
        war2Panel.add(jLabel3);
        jLabel3.setBounds(650, 100, 130, 20);

        jogadorLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jogadorLabel1.setText("AZUL");
        war2Panel.add(jogadorLabel1);
        jogadorLabel1.setBounds(790, 100, 100, 20);

        atacarButton1.setText("Atacar");
        atacarButton1.setToolTipText("");
        atacarButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atacarButton1ActionPerformed(evt);
            }
        });
        war2Panel.add(atacarButton1);
        atacarButton1.setBounds(610, 140, 120, 23);

        remanejarButton1.setText("Remanejar");
        remanejarButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remanejarButton1ActionPerformed(evt);
            }
        });
        war2Panel.add(remanejarButton1);
        remanejarButton1.setBounds(740, 140, 140, 23);

        verCartasButton1.setText("Ver Cartas");
        verCartasButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verCartasButton1ActionPerformed(evt);
            }
        });
        war2Panel.add(verCartasButton1);
        verCartasButton1.setBounds(610, 220, 120, 23);

        encerrarButton1.setText("Encerrar");
        encerrarButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                encerrarButton1ActionPerformed(evt);
            }
        });
        war2Panel.add(encerrarButton1);
        encerrarButton1.setBounds(740, 220, 140, 23);

        inputText1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        inputText1.setToolTipText("");
        war2Panel.add(inputText1);
        inputText1.setBounds(620, 260, 210, 30);

        okButton1.setText("OK");
        okButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButton1ActionPerformed(evt);
            }
        });
        war2Panel.add(okButton1);
        okButton1.setBounds(830, 260, 50, 30);

        tipsLabel1.setText("Exemplo: GO-BA");
        tipsLabel1.setToolTipText("");
        war2Panel.add(tipsLabel1);
        tipsLabel1.setBounds(630, 290, 220, 14);

        jScrollPane2.setViewportView(consoleTextPane1);

        war2Panel.add(jScrollPane2);
        jScrollPane2.setBounds(630, 340, 230, 140);

        jLabel4.setText("CONSOLE");
        war2Panel.add(jLabel4);
        jLabel4.setBounds(630, 320, 60, 14);

        ataqueAereoButton.setText("Ataque Aereo");
        ataqueAereoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ataqueAereoButtonActionPerformed(evt);
            }
        });
        war2Panel.add(ataqueAereoButton);
        ataqueAereoButton.setBounds(610, 180, 120, 23);

        trocarCartaAviaoButton.setText("Trocar carta por avião");
        trocarCartaAviaoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trocarCartaAviaoButtonActionPerformed(evt);
            }
        });
        war2Panel.add(trocarCartaAviaoButton);
        trocarCartaAviaoButton.setBounds(740, 180, 139, 23);

        getContentPane().add(war2Panel, "card4");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void selecionar1ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selecionar1ButtonActionPerformed
        parametros = Parametros.getInstance(1);
        mapa = Mapa.getInstance();
        jogo = Jogo.getInstance();
        jogadoresQtd = Integer.parseInt(JOptionPane.showInputDialog("Quantos jogadores?"
                + "\njogador 1 - azul"
                + "\njogador 2 - verde"
                + "\njogador 3 - vermelho"
                + "\njogador 4 - amarelo"
                + "\njogador 5 - branco"
                + "\njogador 6 - preto"));
        jogo.startGame(jogadoresQtd);
        mapUpdate();
        inicioPanel.setVisible(false);
        war1Panel.setVisible(true);
    }//GEN-LAST:event_selecionar1ButtonActionPerformed

    private void selecionar2ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selecionar2ButtonActionPerformed
        parametros = Parametros.getInstance(2);
        mapa = Mapa.getInstance();
        jogo = Jogo.getInstance();
        jogadoresQtd = Integer.parseInt(JOptionPane.showInputDialog("Quantos jogadores?"
                + "\njogador 1 - azul"
                + "\njogador 2 - verde"
                + "\njogador 3 - vermelho"
                + "\njogador 4 - amarelo"
                + "\njogador 5 - branco"
                + "\njogador 6 - preto"));
        jogo.startGame(jogadoresQtd);
        mapUpdate();
        inicioPanel.setVisible(false);
        war2Panel.setVisible(true);
    }//GEN-LAST:event_selecionar2ButtonActionPerformed

    private void atacarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atacarButtonActionPerformed
        comando = "atacar";
        inputText.setVisible(true);
        okButton.setVisible(true);
    }//GEN-LAST:event_atacarButtonActionPerformed

    private void verCartasButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verCartasButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_verCartasButtonActionPerformed

    private void encerrarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_encerrarButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_encerrarButtonActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        inputText.setVisible(false);
        okButton.setVisible(false);
        if(comando == "atacar"){
            
        }else if(comando == "remanejar"){
            
        }
    }//GEN-LAST:event_okButtonActionPerformed

    private void remanejarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remanejarButtonActionPerformed
        comando = "remanejar";
        inputText.setVisible(true);
        okButton.setVisible(true);
    }//GEN-LAST:event_remanejarButtonActionPerformed

    private void atacarButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atacarButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_atacarButton1ActionPerformed

    private void remanejarButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remanejarButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_remanejarButton1ActionPerformed

    private void verCartasButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verCartasButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_verCartasButton1ActionPerformed

    private void encerrarButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_encerrarButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_encerrarButton1ActionPerformed

    private void okButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_okButton1ActionPerformed

    private void ataqueAereoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ataqueAereoButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ataqueAereoButtonActionPerformed

    private void trocarCartaAviaoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trocarCartaAviaoButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_trocarCartaAviaoButtonActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ACpin;
    private javax.swing.JLabel ACpin1;
    private javax.swing.JLabel ACpin2;
    private javax.swing.JLabel ACpin3;
    private javax.swing.JLabel ALpin;
    private javax.swing.JLabel ALpin1;
    private javax.swing.JLabel ALpin2;
    private javax.swing.JLabel ALpin3;
    private javax.swing.JLabel AMpin;
    private javax.swing.JLabel AMpin1;
    private javax.swing.JLabel AMpin2;
    private javax.swing.JLabel AMpin3;
    private javax.swing.JLabel APpin;
    private javax.swing.JLabel APpin1;
    private javax.swing.JLabel APpin2;
    private javax.swing.JLabel APpin3;
    private javax.swing.JLabel BApin;
    private javax.swing.JLabel BApin1;
    private javax.swing.JLabel BApin2;
    private javax.swing.JLabel BApin3;
    private javax.swing.JLabel CEpin;
    private javax.swing.JLabel CEpin1;
    private javax.swing.JLabel CEpin2;
    private javax.swing.JLabel CEpin3;
    private javax.swing.JLabel ESpin;
    private javax.swing.JLabel ESpin1;
    private javax.swing.JLabel ESpin2;
    private javax.swing.JLabel ESpin3;
    private javax.swing.JLabel GOpin;
    private javax.swing.JLabel GOpin1;
    private javax.swing.JLabel GOpin2;
    private javax.swing.JLabel GOpin3;
    private javax.swing.JLabel MApin;
    private javax.swing.JLabel MApin1;
    private javax.swing.JLabel MApin2;
    private javax.swing.JLabel MApin3;
    private javax.swing.JLabel MGpin;
    private javax.swing.JLabel MGpin1;
    private javax.swing.JLabel MGpin2;
    private javax.swing.JLabel MGpin3;
    private javax.swing.JLabel MSpin2;
    private javax.swing.JLabel MSpin3;
    private javax.swing.JLabel MTpin;
    private javax.swing.JLabel MTpin1;
    private javax.swing.JLabel MTpin2;
    private javax.swing.JLabel MTpin3;
    private javax.swing.JLabel PApin;
    private javax.swing.JLabel PApin1;
    private javax.swing.JLabel PApin2;
    private javax.swing.JLabel PApin3;
    private javax.swing.JLabel PBpin;
    private javax.swing.JLabel PBpin1;
    private javax.swing.JLabel PBpin2;
    private javax.swing.JLabel PBpin3;
    private javax.swing.JLabel PEpin;
    private javax.swing.JLabel PEpin1;
    private javax.swing.JLabel PEpin2;
    private javax.swing.JLabel PEpin3;
    private javax.swing.JLabel PIpin;
    private javax.swing.JLabel PIpin1;
    private javax.swing.JLabel PIpin2;
    private javax.swing.JLabel PIpin3;
    private javax.swing.JLabel PRpin;
    private javax.swing.JLabel PRpin1;
    private javax.swing.JLabel PRpin2;
    private javax.swing.JLabel PRpin3;
    private javax.swing.JLabel RDpin;
    private javax.swing.JLabel RDpin1;
    private javax.swing.JLabel RDpin2;
    private javax.swing.JLabel RDpin3;
    private javax.swing.JLabel RJpin;
    private javax.swing.JLabel RJpin1;
    private javax.swing.JLabel RJpin2;
    private javax.swing.JLabel RJpin3;
    private javax.swing.JLabel RNpin;
    private javax.swing.JLabel RNpin1;
    private javax.swing.JLabel RNpin2;
    private javax.swing.JLabel RNpin3;
    private javax.swing.JLabel RRpin;
    private javax.swing.JLabel RRpin1;
    private javax.swing.JLabel RRpin2;
    private javax.swing.JLabel RRpin3;
    private javax.swing.JLabel RSpin;
    private javax.swing.JLabel RSpin1;
    private javax.swing.JLabel RSpin2;
    private javax.swing.JLabel RSpin3;
    private javax.swing.JLabel SCpin;
    private javax.swing.JLabel SCpin1;
    private javax.swing.JLabel SCpin2;
    private javax.swing.JLabel SCpin3;
    private javax.swing.JLabel SEpin;
    private javax.swing.JLabel SEpin1;
    private javax.swing.JLabel SEpin2;
    private javax.swing.JLabel SEpin3;
    private javax.swing.JLabel SPpin;
    private javax.swing.JLabel SPpin1;
    private javax.swing.JLabel SPpin2;
    private javax.swing.JLabel SPpin3;
    private javax.swing.JLabel TOpin2;
    private javax.swing.JLabel TOpin3;
    private javax.swing.JButton atacarButton;
    private javax.swing.JButton atacarButton1;
    private javax.swing.JButton ataqueAereoButton;
    private javax.swing.JLabel backgroundInicio;
    private javax.swing.JTextPane consoleTextPane;
    private javax.swing.JTextPane consoleTextPane1;
    private javax.swing.JButton encerrarButton;
    private javax.swing.JButton encerrarButton1;
    private javax.swing.JLabel escolhaJogoLabel;
    private javax.swing.JPanel inicioPanel;
    private javax.swing.JTextField inputText;
    private javax.swing.JTextField inputText1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jogadorLabel;
    private javax.swing.JLabel jogadorLabel1;
    private javax.swing.JLabel map1;
    private javax.swing.JLabel map2;
    private javax.swing.JButton okButton;
    private javax.swing.JButton okButton1;
    private javax.swing.JButton remanejarButton;
    private javax.swing.JButton remanejarButton1;
    private javax.swing.JLabel rodadaLabel;
    private javax.swing.JLabel rodadaLabel1;
    private javax.swing.JLabel tipsLabel;
    private javax.swing.JLabel tipsLabel1;
    private javax.swing.JButton trocarCartaAviaoButton;
    private javax.swing.JButton verCartasButton;
    private javax.swing.JButton verCartasButton1;
    private javax.swing.JPanel war1Panel;
    private javax.swing.JPanel war2Panel;
    // End of variables declaration//GEN-END:variables
}
