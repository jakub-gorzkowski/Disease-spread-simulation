import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GUI extends JFrame {
    public static GUI instance;
    private int columns; // x
    private int rows; // y
    private List<JPanel> panels;

    private GUI (int columns, int rows) {
        this.columns = columns;
        this.rows = rows;
        this.panels = new ArrayList<>();
    }

    public static GUI getInstance(int columns, int rows) {
        if (instance == null) {
            instance = new GUI(rows, columns);
        }
        return instance;
    }

    public void initializeUI() {
        setTitle("Disease spread simulation");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(columns, rows));

        for(int i = 0; i < columns * rows; i++) {
            JPanel panel = new JPanel();
            panel.setPreferredSize(new Dimension(5,5));
            panel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
            add(panel);
        }

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void visualizeSubjects(double x, double y) {
        int index = (int) (10 * y) * columns + (int) (10 * x);
        if (index >= 0 && index < panels.size()) {
            panels.get(index).setBackground(Color.RED);
        }
    }
}
