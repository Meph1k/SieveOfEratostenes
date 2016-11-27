package pl.polsl.java.lab1.piotrsuwala.view;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import pl.polsl.java.lab1.piotrsuwala.model.Helpers;
import pl.polsl.java.lab1.piotrsuwala.model.CollatzConjecture;
import pl.polsl.java.lab1.piotrsuwala.model.FibonacciSequence;
import pl.polsl.java.lab1.piotrsuwala.model.KarnaughMapPrimes;
import pl.polsl.java.lab1.piotrsuwala.model.RowsAndColumns;
import pl.polsl.java.lab1.piotrsuwala.model.SieveOfEratostenes;

/**
 * The main class. Everything is launched here.
 * @author Piotr Suwała
 * @version 1.0
 */
public class Main extends JPanel implements ActionListener {
    JTextArea output;
    JScrollPane scrollPane;
    String newline = "\n";
    JPanel contentPane;
    static JFrame frame;
    static final private String PREVIOUS = "previous";
    static final private String UP = "up";
    static final private String NEXT = "next";
    
    /**
     * Creates navigation buttons
     * @param imageName
     * @param actionCommand
     * @param toolTipText
     * @param altText
     * @return JButton
     */
    
    protected JButton makeNavigationButton(String imageName,
                                           String actionCommand,
                                           String toolTipText,
                                           String altText) {
       
        JButton button = new JButton();
        button.setActionCommand(actionCommand);
        button.setToolTipText(toolTipText);
        button.addActionListener(this);

        return button;
    }
    
    /**
     * adds buttons
     * @param toolBar toolbar to which add buttons 
     */
    
    protected void addButtons(JToolBar toolBar) {
        JButton button = null;
        button = makeNavigationButton("Back24", PREVIOUS,
                                      "Back to previous something-or-other",
                                      "Previous");
        toolBar.add(button);
        button = makeNavigationButton("Up24", UP,
                                      "Up to something-or-other",
                                      "Up");
        toolBar.add(button);
        button = makeNavigationButton("Forward24", NEXT,
                                      "Forward to something-or-other",
                                      "Next");
        toolBar.add(button);
    }
    
    /**
     * creates menu
     * @return menu bar
     */

    public JMenuBar createMenuBar() {
        JMenuBar menuBar;
        JMenu menu;
        JMenuItem menuItem;

        menuBar = new JMenuBar();
        
        menu = new JMenu("Options");
        menu.setMnemonic(KeyEvent.VK_O);
        menuBar.add(menu);
        
        menuItem = new JMenuItem("About",
                                 KeyEvent.VK_A);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_1, ActionEvent.ALT_MASK));
        menuItem.addActionListener(this);
        menu.add(menuItem);
        
        menuItem = new JMenuItem("Exit",
                                 KeyEvent.VK_E);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_1, ActionEvent.ALT_MASK));
        menuItem.addActionListener(this);
        menu.add(menuItem);

        menu = new JMenu("Select a problem");
        menu.setMnemonic(KeyEvent.VK_S);
        menuBar.add(menu);

        menuItem = new JMenuItem("Collatz conjecture",
                                 KeyEvent.VK_C);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_1, ActionEvent.ALT_MASK));
        menuItem.addActionListener(this);
        menu.add(menuItem);
        
        menuItem = new JMenuItem("Fibonacci sequence",
                                 KeyEvent.VK_F);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_2, ActionEvent.ALT_MASK));
        menuItem.addActionListener(this);
        menu.add(menuItem);
        
        menuItem = new JMenuItem("Prime numbers",
                                 KeyEvent.VK_P);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_3, ActionEvent.ALT_MASK));
        menuItem.addActionListener(this);
        menu.add(menuItem);
        
        menuItem = new JMenuItem("Karnaugh map",
                                 KeyEvent.VK_K);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_4, ActionEvent.ALT_MASK));
        menuItem.addActionListener(this);
        menu.add(menuItem);
        
        return menuBar;
    }
    
    /**
     * creates content pane
     * @return content pane
     */

    public Container createContentPane() {
        contentPane = new JPanel(new BorderLayout());
        contentPane.setOpaque(true);
        output = new JTextArea(5, 30);
        output.setEditable(false);
        scrollPane = new JScrollPane(output);
        contentPane.add(scrollPane, BorderLayout.CENTER);

        return contentPane;
    }
    
    /**
     * Just a usual action listener
     * @param e event
     */

    public void actionPerformed(ActionEvent e) {
        JMenuItem source = (JMenuItem)(e.getSource());
        String s = "Action event detected."
                   + newline
                   + "    Event source: " + source.getText();
        if ("Karnaugh map" == source.getText()) {
            int[][] karnaughMapArray = new KarnaughMapPrimes().getKarnaughMap4x4WithPrimes();
            RowsAndColumns data = new Helpers().array2DToObject(karnaughMapArray);
            JTable table = new JTable(data.rowData, data.columnsNames);
            frame.getContentPane().remove(this.scrollPane);
            JScrollPane scrollPane = new JScrollPane(table);
            final JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);

            splitPane.setTopComponent(this.scrollPane);
            splitPane.setBottomComponent(scrollPane);

            frame.add(splitPane, BorderLayout.CENTER);
            frame.setVisible(true);

            splitPane.setDividerLocation(0.5);
        } else if ("Prime numbers" == source.getText()) {
            SieveOfEratostenes sieveOfEratostenes = new SieveOfEratostenes();
            sieveOfEratostenes.runEratostenesSieve(30);
            int primes[] = sieveOfEratostenes.getPrimes();
            for (int prime : primes) {
                output.append(Integer.toString(prime));
                output.append(" ");
            }
        } else if ("Fibonacci sequence" == source.getText()) {
            FibonacciSequence fibonacciSequence = new FibonacciSequence(30);
            fibonacciSequence.computeFibonacciSequence();
            List fibonacciSequenceComputed = fibonacciSequence.getArrayOfFibonacciSequence();
            for (Object fib : fibonacciSequenceComputed) {
                output.append(fib.toString());
                output.append(" ");
            }
        } else if ("Collatz conjecture" == source.getText()) {
            CollatzConjecture collatzConjecture = new CollatzConjecture();
            collatzConjecture.computeCollatzConjencture(400);
            int numberOfSteps = collatzConjecture.getNumberOfSteps();
            output.append(Integer.toString(numberOfSteps));
        } else if ("Exit" == source.getText()) {
            int result = JOptionPane.showConfirmDialog((Component) null, "Are you sure?",
            "alert", JOptionPane.OK_CANCEL_OPTION);
            if (0 == result) {
                System.exit(1);
            }
        } else {
            JOptionPane.showMessageDialog(frame, "An app for the Java course");
        }
        output.append(s + newline);
        output.setCaretPosition(output.getDocument().getLength());
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        frame = new JFrame("Karnaugh Map & Problems");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Main demo = new Main();
        
        JMenuBar menu = demo.createMenuBar();
        
        frame.setJMenuBar(menu);
        JToolBar toolbar = new JToolBar();
        toolbar.setRollover(true);


        JButton button = new JButton("Previous");
        toolbar.add(button);
        toolbar.addSeparator();
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Previous");
            }
        });

        button = new JButton("next");
        toolbar.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Next");
            }
        });

        frame.setContentPane(demo.createContentPane());
        Container contentPane = frame.getContentPane();
        contentPane.add(toolbar, BorderLayout.NORTH);

        frame.setSize(450, 260);
        frame.setVisible(true);
    }
    /**
     * The main method. Executes everything.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
