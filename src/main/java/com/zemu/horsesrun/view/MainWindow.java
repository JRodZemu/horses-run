package com.zemu.horsesrun.view;

import com.zemu.horsesrun.model.Horse;
import com.zemu.horsesrun.service.RaceService;
import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class MainWindow extends JFrame {

    private RaceService service;
    private JPanel pistaPanel;
    private JComboBox<String> circuitoCombo;
    private JButton btnIniciar;

    public MainWindow() {
        setTitle("Carreras de Caballos");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        service = new RaceService();

        initComponents();
        addComponents();
    }

    private void initComponents() {
        pistaPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                dibujarPista(g);
            }
        };
        pistaPanel.setBackground(Color.GREEN.darker());
        pistaPanel.setPreferredSize(new Dimension(600, 400));

        String[] circuitos = {"Corto (100m)", "Medio (200m)", "Largo (300m)"};
        circuitoCombo = new JComboBox<>(circuitos);

        btnIniciar = new JButton("Iniciar carrera");
        btnIniciar.addActionListener(e -> iniciarCarrera());
    }

    private void addComponents() {
        setLayout(new BorderLayout());

        add(pistaPanel, BorderLayout.CENTER);

        JPanel panelControles = new JPanel();
        panelControles.add(new JLabel("Circuito:"));
        panelControles.add(circuitoCombo);
        panelControles.add(btnIniciar);

        add(panelControles, BorderLayout.SOUTH);
    }

    private void iniciarCarrera() {
        double distancia = obtenerDistancia();

        List<Horse> caballos = Arrays.asList(
            new Horse("Relámpago", "rojo"),
            new Horse("Brisa", "azul"),
            new Horse("Tormenta", "verde")
        );

        service.configRace(distancia, caballos);

        Timer timer = new Timer(500, e -> {
            service.wasteMovement();
            pistaPanel.repaint();

            if (service.isFinish()) {
                ((Timer) e.getSource()).stop();
                Horse ganador = service.getWinner();
                JOptionPane.showMessageDialog(this,
                    "¡Ganador: " + ganador.getName() + "!",
                    "Carrera terminada",
                    JOptionPane.INFORMATION_MESSAGE);
            }
        });
        timer.start();
    }

    private double obtenerDistancia() {
        String seleccion = (String) circuitoCombo.getSelectedItem();
        if (seleccion.contains("100")) return 100;
        if (seleccion.contains("200")) return 200;
        return 300;
    }

    private void dibujarPista(Graphics g) {
        g.setColor(Color.WHITE);
        int metaX = 650;
        int yStart = 50;
        int yEnd = 350;
        g.drawLine(metaX, yStart, metaX, yEnd);

        if (service.getHorses() == null) return;

        double distanciaTotal = service.getDistance();
        if (distanciaTotal == 0) return;

        int y = 80;
        for (Horse h : service.getHorses()) {
            int x = 50 + (int) ((h.getPosition() / distanciaTotal) * 600);
            if (x > metaX) x = metaX;

            g.setColor(getColorFromString(h.getColor()));
            g.fillOval(x, y, 30, 20);

            g.setColor(Color.BLACK);
            g.drawString(h.getName(), x, y - 5);

            y += 40;
        }
    }

    private Color getColorFromString(String color) {
        switch (color.toLowerCase()) {
            case "rojo": return Color.RED;
            case "azul": return Color.BLUE;
            case "verde": return Color.GREEN;
            default: return Color.GRAY;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainWindow().setVisible(true);
        });
    }
}