import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainWindow extends JFrame {

    private JButton button;
    private JTextField textField;
    private JList<String> list;
    private DefaultListModel<String> listModel;
    private JPanel panel_1;



    public MainWindow() throws HeadlessException {

        setTitle("GrimmChat v1.0");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(200,200,500,500);


        button = new JButton("Send");
        button.setPreferredSize(new Dimension(100, 50));
        button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listModel.add(0,"Name: " + textField.getText());
            }
        });



        JMenuBar mainMenu = new JMenuBar();
        JMenu mFile = new JMenu("Menu");
        JMenuItem miFileNew = new JMenuItem("Log out");
        JMenuItem miFileExit = new JMenuItem("Exit");
        setJMenuBar(mainMenu);
        mainMenu.add(mFile);
        mFile.add(miFileNew);
        mFile.addSeparator(); // разделительная линия в меню
        mFile.add(miFileExit);

        miFileExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });



        textField = new JTextField();
        textField.setPreferredSize(new Dimension(350, 50));
        textField.addActionListener(new ActionListener() {
            @Override                                                   //---> Отработка события нажатия ENTER;
            public void actionPerformed(ActionEvent e) {
                listModel.add(0,"Name: " + textField.getText());
            }
        });


        listModel = new DefaultListModel<>();
        list = new JList<>(listModel);
        panel_1 = new JPanel();


        panel_1.add(textField,BorderLayout.EAST);
        panel_1.add(button,BorderLayout.WEST);

        add(panel_1,BorderLayout.SOUTH);
        add(list,BorderLayout.CENTER);
        setVisible(true);

    }
}


