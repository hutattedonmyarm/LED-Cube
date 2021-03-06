import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/*
 * frame.java
 *
 * Copyright 2011 Thomas Buck <xythobuz@me.com>
 * Copyright 2011 Max Nuding <max.nuding@gmail.com>
 * Copyright 2011 Felix Bäder <baeder.felix@gmail.com>
 *
 * This file is part of LED-Cube.
 *
 * LED-Cube is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * LED-Cube is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with LED-Cube.  If not, see <http://www.gnu.org/licenses/>.
 */

public class frame extends JFrame {
  // Anfang Variablen
  private Canvas cubeCanvas = new Canvas();

  // Anfang Attribute
  private JButton editA = new JButton();
  private JButton editB = new JButton();
  private JButton editC = new JButton();
  private JButton editD = new JButton();
  private JButton editE = new JButton();
  private JButton editF = new JButton();
  private JButton editG = new JButton();
  private JButton editH = new JButton();
  private DefaultListModel frameListModel = new DefaultListModel();
  private JList frameList = new JList();
  private JScrollPane frameListScrollPane = new JScrollPane(frameList);
  private JButton frameUp = new JButton();
  private JButton frameDown = new JButton();
  private JButton frameAdd = new JButton();
  private JButton frameRemove = new JButton();
  private JList jList2 = new JList();
  private DefaultListModel jList2Model = new DefaultListModel();
  private JScrollPane jList2ScrollPane = new JScrollPane(jList2);
  private JButton animUp = new JButton();
  private JButton animDown = new JButton();
  private JButton animAdd = new JButton();
  private JButton animRemove = new JButton();
  private JTextField animPath = new JTextField();
  private JButton load = new JButton();
  private JButton save = new JButton();
  private JComboBox jComboBox1 = new JComboBox();
  private JButton upload = new JButton();
  private JButton download = new JButton();
  private JLabel jLabel4 = new JLabel();
  private JTextField frameRemaining = new JTextField();
  // Ende Attribute

  private cubeWorker worker = new cubeWorker();
  // Ende Variablen

  private int saveExitDialog() {
    String[] Optionen = {"Yes", "No"};
    int Auswahl = JOptionPane.showOptionDialog(this, "Do you want to save your changes?", "Save?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, Optionen, Optionen[0]);
    if (Auswahl == JOptionPane.YES_OPTION) {
       worker.saveState(animPath.getText());
       return 1;
    } else {
       return 0;
    }
  }

  private void errorMessage(String s) {
  String[] Optionen = {"OK"};
  JOptionPane.showOptionDialog(this, s, "Error!", JOptionPane.YES_OPTION, JOptionPane.ERROR_MESSAGE, null, Optionen, Optionen[0]);
  }

  public frame(String title) {
    // Frame-Initialisierung
    super(title);

    String[] sPorts = worker.getSerialPorts();
    for(int i = 0; i < sPorts.length; i++){
      jComboBox1.addItem(sPorts[i]);
    }
    
    for(int i = 0; i < worker.numOfAnimations(); i++){
      jList2Model.addElement(worker.getAnimationName(i));
    }
    for(int i = 0; i < worker.numOfFrames(); i++){
      frameListModel.add(i, worker.getFrameName(i));
    }

    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent evt) {
             if (worker.changedStateSinceSave()) {
                  saveExitDialog();
             }
             System.exit(0);
      }
    });
    int frameWidth = 661; 
    int frameHeight = 417;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2 ;
    setLocation(x, y);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten

    cubeCanvas.setBounds(8, 8, 250, 250);
    cubeCanvas.setBackground(Color.GRAY);
    cp.add(cubeCanvas);
    editA.setBounds(264, 8, 107, 25);
    editA.setText("Layer A");
    editA.setFont(new Font("Dialog", Font.PLAIN, 13));
    cp.add(editA);
    editA.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        editA_ActionPerformed(evt);
      }
    });

    editB.setBounds(264, 40, 107, 25);
    editB.setText("Layer B");
    editB.setFont(new Font("Dialog", Font.PLAIN, 13));
    cp.add(editB);
    editB.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        editB_ActionPerformed(evt);
      }
    });

    editC.setBounds(264, 72, 107, 25);
    editC.setText("Layer C");
    editC.setFont(new Font("Dialog", Font.PLAIN, 13));
    cp.add(editC);
    editC.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        editC_ActionPerformed(evt);
      }
    });

    editD.setBounds(264, 104, 107, 25);
    editD.setText("Layer D");
    editD.setFont(new Font("Dialog", Font.PLAIN, 13));
    cp.add(editD);
    editD.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        editD_ActionPerformed(evt);
      }
    });

    editE.setBounds(264, 136, 107, 25);
    editE.setText("Layer E");
    editE.setFont(new Font("Dialog", Font.PLAIN, 13));
    cp.add(editE);
    editE.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        editE_ActionPerformed(evt);
      }
    });

    editF.setBounds(264, 168, 107, 25);
    editF.setText("Layer F");
    editF.setFont(new Font("Dialog", Font.PLAIN, 13));
    cp.add(editF);
    editF.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        editF_ActionPerformed(evt);
      }
    });

    editG.setBounds(264, 200, 107, 25);
    editG.setText("Layer G");
    editG.setFont(new Font("Dialog", Font.PLAIN, 13));
    cp.add(editG);
    editG.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        editG_ActionPerformed(evt);
      }
    });

    editH.setBounds(264, 232, 107, 25);
    editH.setText("Layer H");
    editH.setFont(new Font("Dialog", Font.PLAIN, 13));
    cp.add(editH);
    editH.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        editH_ActionPerformed(evt);
      }
    });

    frameListScrollPane.setBounds(384, 8, 145, 249);
    frameList.setModel(frameListModel);
    //frameListModel.addElement();
    cp.add(frameListScrollPane);
    frameUp.setBounds(544, 8, 107, 33);
    frameUp.setText("Move up");
    frameUp.setFont(new Font("Dialog", Font.PLAIN, 13));
    cp.add(frameUp);
    frameUp.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        frameUp_ActionPerformed(evt);
      }
    });

    frameDown.setBounds(544, 152, 107, 33);
    frameDown.setText("Move down");
    frameDown.setFont(new Font("Dialog", Font.PLAIN, 13));
    cp.add(frameDown);
    frameDown.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        frameDown_ActionPerformed(evt);
      }
    });

    frameAdd.setBounds(544, 56, 107, 33);
    frameAdd.setText("Add");
    frameAdd.setFont(new Font("Dialog", Font.PLAIN, 13));
    cp.add(frameAdd);
    frameAdd.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        frameAdd_ActionPerformed(evt);
      }
    });

    frameRemove.setBounds(544, 104, 107, 33);
    frameRemove.setText("Remove");
    frameRemove.setFont(new Font("Dialog", Font.PLAIN, 13));
    cp.add(frameRemove);
    frameRemove.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        frameRemove_ActionPerformed(evt);
      }
    });

    jList2ScrollPane.setBounds(8, 264, 209, 121);
    jList2.setModel(jList2Model);
    //jList2Model.addElement("");
    cp.add(jList2ScrollPane);
    animUp.setBounds(224, 264, 99, 25);
    animUp.setText("Move up");
    animUp.setFont(new Font("Dialog", Font.PLAIN, 13));
    cp.add(animUp);
    animUp.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        animUp_ActionPerformed(evt);
      }
    });

    animDown.setBounds(224, 360, 99, 25);
    animDown.setText("Move down");
    animDown.setFont(new Font("Dialog", Font.PLAIN, 13));
    cp.add(animDown);
    animDown.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        animDown_ActionPerformed(evt);
      }
    });

    animAdd.setBounds(224, 296, 99, 25);
    animAdd.setText("Add");
    animAdd.setFont(new Font("Dialog", Font.PLAIN, 13));
    cp.add(animAdd);
    animAdd.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        animAdd_ActionPerformed(evt);
      }
    });

    animRemove.setBounds(224, 328, 99, 25);
    animRemove.setText("Remove");
    animRemove.setFont(new Font("Dialog", Font.PLAIN, 13));
    cp.add(animRemove);
    animRemove.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        animRemove_ActionPerformed(evt);
      }
    });

    animPath.setBounds(344, 264, 305, 24);
    animPath.setEditable(false);
    animPath.setText("Load/Save an animation file...");
    animPath.setFont(new Font("Dialog", Font.PLAIN, 13));
    cp.add(animPath);
    load.setBounds(344, 296, 147, 25);
    load.setText("Load");
    load.setFont(new Font("Dialog", Font.PLAIN, 13));
    cp.add(load);
    load.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        load_ActionPerformed(evt);
      }
    });

    save.setBounds(504, 296, 147, 25);
    save.setText("Save");
    save.setFont(new Font("Dialog", Font.PLAIN, 13));
    cp.add(save);
    save.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        save_ActionPerformed(evt);
      }
    });

    jComboBox1.setBounds(344, 328, 305, 24);
    jComboBox1.setFont(new Font("Dialog", Font.PLAIN, 13));
    cp.add(jComboBox1);
    upload.setBounds(344, 360, 147, 25);
    upload.setText("Upload");
    upload.setFont(new Font("Dialog", Font.PLAIN, 13));
    cp.add(upload);
    upload.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        upload_ActionPerformed(evt);
      }
    });

    download.setBounds(504, 360, 147, 25);
    download.setText("Download");
    download.setFont(new Font("Dialog", Font.PLAIN, 13));
    cp.add(download);
    download.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        download_ActionPerformed(evt);
      }
    });

    jLabel4.setBounds(536, 208, 112, 20);
    jLabel4.setText("Frames remaining:");
    jLabel4.setFont(new Font("Dialog", Font.PLAIN, 13));
    cp.add(jLabel4);
    frameRemaining.setBounds(536, 232, 113, 24);
    frameRemaining.setEditable(false);
    frameRemaining.setText("2048");
    frameRemaining.setFont(new Font("Dialog", Font.PLAIN, 13));
    cp.add(frameRemaining);
    jList2.setFont(new Font("Dialog", Font.PLAIN, 13));
    frameList.setFont(new Font("Dialog", Font.PLAIN, 13));
    // Ende Komponenten
    jList2.addListSelectionListener(new MyListSelectionListener(jList2, worker));
    setResizable(false);
    setVisible(true);
  }

  // Anfang Methoden

  // Anfang Ereignisprozeduren
  public void editA_ActionPerformed(ActionEvent evt) {

  }

  public void editB_ActionPerformed(ActionEvent evt) {

  }

  public void editC_ActionPerformed(ActionEvent evt) {

  }

  public void editD_ActionPerformed(ActionEvent evt) {

  }

  public void editE_ActionPerformed(ActionEvent evt) {

  }

  public void editF_ActionPerformed(ActionEvent evt) {

  }

  public void editG_ActionPerformed(ActionEvent evt) {

  }

  public void editH_ActionPerformed(ActionEvent evt) {

  }

  public void frameUp_ActionPerformed(ActionEvent evt) {
         int i = frameList.getSelectedIndex();
         if ((i > 0) && (frameListModel.getSize() >= 2)) {
            Object tmp = frameListModel.get(i);
            frameListModel.set(i, frameListModel.get(i - 1));
            frameListModel.set(i - 1, tmp);
            frameList.setSelectedIndex(i - 1);
            worker.moveFrame(worker.UP);
         }
  }

  public void frameDown_ActionPerformed(ActionEvent evt) {
         int i = frameList.getSelectedIndex();
         if ((i >= 0) && (frameListModel.getSize() >= 2) && (i < (frameListModel.getSize() - 1))) {
            Object tmp = frameListModel.get(i);
            frameListModel.set(i, frameListModel.get(i + 1));
            frameListModel.set(i + 1, tmp);
            frameList.setSelectedIndex(i + 1);
            worker.moveFrame(worker.DOWN);
         }
  }

  public void frameAdd_ActionPerformed(ActionEvent evt) {
         worker.addFrame();
         frameRemaining.setText(Integer.toString(worker.framesRemaining()));
  }

  public void frameRemove_ActionPerformed(ActionEvent evt) {
         worker.removeFrame(jList2.getSelectedIndex());
         frameRemaining.setText(Integer.toString(worker.framesRemaining()));
  }

  public void animUp_ActionPerformed(ActionEvent evt) {
         int i = jList2.getSelectedIndex();
         if ((i > 0) && (jList2Model.getSize() >= 2)) {
            Object tmp = jList2Model.get(i);
            jList2Model.set(i, jList2Model.get(i - 1));
            jList2Model.set(i - 1, tmp);
            jList2.setSelectedIndex(i - 1);
            worker.moveAnimation(worker.UP);
         }
  }

  public void animDown_ActionPerformed(ActionEvent evt) {
         int i = jList2.getSelectedIndex();
         if ((i >= 0) && (jList2Model.getSize() >= 2) && (i < (jList2Model.getSize() - 1))) {
            Object tmp = jList2Model.get(i);
            jList2Model.set(i, jList2Model.get(i + 1));
            jList2Model.set(i + 1, tmp);
            jList2.setSelectedIndex(i + 1);
            worker.moveAnimation(worker.DOWN);
         }
  }

  public void animAdd_ActionPerformed(ActionEvent evt) {
    if(worker.addAnimation() == -1){
      //show error Dialog
    }

  }

  public void animRemove_ActionPerformed(ActionEvent evt) {
     worker.removeAnimation(jList2.getSelectedIndex());
  }

  public void load_ActionPerformed(ActionEvent evt) {
    worker.loadState(animPath.getText());
  }

  public void save_ActionPerformed(ActionEvent evt) {
    worker.saveState(animPath.getText());
  }


  public void upload_ActionPerformed(ActionEvent evt) {
         if (jComboBox1.getSelectedItem().equals("Select serial port...")) {
            errorMessage("No serial port selected...");
         } else {
           worker.uploadState((String)jComboBox1.getSelectedItem());
         }
  }

  public void download_ActionPerformed(ActionEvent evt) {
         if (jComboBox1.getSelectedItem().equals("Select serial port...")) {
      errorMessage("No serial port selected...");
         } else {
           worker.downloadState((String)jComboBox1.getSelectedItem());
         }
  }

  // Ende Ereignisprozeduren

  public static void main(String[] args) {
    new frame("Cube Control");
  }
  // Ende Methoden
}

class MyListSelectionListener implements ListSelectionListener {

  JList alist;
  cubeWorker worker;
  MyListSelectionListener(JList animList, cubeWorker w){
    alist = animList;
    worker = w;
  }
  public void valueChanged(ListSelectionEvent evt) {
    if (!evt.getValueIsAdjusting()) {
       worker.selectAnimation(alist.getSelectedIndex());
    }
  }
}

