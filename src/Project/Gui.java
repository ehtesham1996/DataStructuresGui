package Project;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

@SuppressWarnings("serial")
public class Gui extends JFrame {
	JPanel stackPanel;
	JPanel queuePanel;
	JPanel listPanel;
	JPanel setPanel;
	JPanel treePanel;
	JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	JLabel Result;

	JTextArea GraphicalResult;

	private JTextField textField;

	StackHelper stack = new StackHelper();
	Queue queue = new Queue();
	BinaryTree btree = new BinaryTree();
	ListHelper list = new ListHelper();
	SetHelper set = new SetHelper();

	private JTextField insertTextField;
	private JTextField removeTextField;
	private JTextField txtInsert;
	private JTextField txtRemove;
	private JTextField txtSearch;
	private JTextField sInsert;
	private JTextField sRemove;
	private JTextField sSearch;

	public Gui() {
		getContentPane().setLayout(null);
		setSize(769, 522);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Stack panel and its including panel and functions ;
		stackPanel = new JPanel();
		stackPanel.setBounds(0, 0, 732, 387);
		stackPanel.setLayout(null);

		JLabel lblStack = new JLabel("Stack");
		lblStack.setBounds(342, 11, 39, 22);
		lblStack.setFont(new Font("Serif", Font.BOLD, 16));
		stackPanel.add(lblStack);

		JPanel stackOperation = new JPanel();
		stackOperation.setBounds(10, 40, 230, 233);
		stackOperation.setBorder(BorderFactory.createLineBorder(Color.black));
		stackPanel.add(stackOperation);
		stackOperation.setLayout(null);

		JLabel lblOperations = new JLabel("Operations");
		lblOperations.setBounds(74, 11, 87, 14);
		stackOperation.add(lblOperations);

		Result = new JLabel("");
		Result.setBounds(20, 162, 184, 60);
		stackOperation.add(Result);
		JButton btnPush = new JButton("Push");
		btnPush.setBounds(10, 46, 89, 23);
		btnPush.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (textField.getText().isEmpty()) {
					Result.setText("Please Enter Something!!");
				} else {
					stack.push(textField.getText());
					Result.setText(textField.getText() + "-> Pushed Succesfully");
					textField.setText("");
					;
					GraphicalResult.setText(stack.print());
					GraphicalResult.setSelectionStart(0);
					GraphicalResult.setSelectionEnd(0);
				}

			}
		});
		stackOperation.add(btnPush);

		textField = new JTextField();
		textField.setBounds(109, 47, 95, 20);
		stackOperation.add(textField);
		textField.setColumns(10);

		JButton btnPop = new JButton("Pop");
		btnPop.setBounds(10, 80, 89, 23);
		btnPop.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (stack.s.empty()) {
					Result.setText("Stack is empty");
				} else {
					Result.setText(stack.pop() + " has been popped succesfully");
					GraphicalResult.setText(stack.print());
					GraphicalResult.setSelectionStart(0);
					GraphicalResult.setSelectionEnd(0);
				}
			}
		});
		stackOperation.add(btnPop);

		JButton btnPeek = new JButton("Peek");
		btnPeek.setBounds(10, 114, 89, 23);
		btnPeek.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

				if (stack.s.empty()) {
					Result.setText("The stack is empty");
				} else {
					Result.setText("Peek Element is :" + stack.peek());
				}
			}
		});
		stackOperation.add(btnPeek);

		JLabel lblResult = new JLabel("Result");
		lblResult.setBounds(74, 148, 46, 14);
		stackOperation.add(lblResult);

		JPanel stackDisplay = new JPanel();
		stackDisplay.setBounds(250, 40, 472, 233);
		stackDisplay.setBorder(BorderFactory.createLineBorder(Color.black));
		stackPanel.add(stackDisplay);
		stackDisplay.setLayout(null);

		GraphicalResult = new JTextArea();
		GraphicalResult.setText("Result Will Display Here");
		GraphicalResult.setEditable(false);
		GraphicalResult.setBounds(10, 36, 452, 186);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 36, 452, 186);
		scrollPane.setViewportView(GraphicalResult);
		stackDisplay.add(scrollPane);

		JLabel lblDisplay = new JLabel("Display ");
		lblDisplay.setBounds(183, 11, 46, 14);
		stackDisplay.add(lblDisplay);

		JPanel stackInformation = new JPanel();
		stackInformation.setBounds(10, 281, 712, 95);
		stackInformation.setBorder(BorderFactory.createLineBorder(Color.black));
		stackPanel.add(stackInformation);
		stackInformation.setLayout(null);

		JLabel lblInformation = new JLabel("Information");
		lblInformation.setBounds(303, 0, 116, 14);
		stackInformation.add(lblInformation);

		JTextArea Info = new JTextArea();
		Info.setText("A stack conatins values which are managed in Last in and first out Sequence (LIFO) . \n "
				+ "The  commonly used stacks are in Infix to Postfix conversion etc and \n "
				+ "The Provided funcnalties are Push,Pop,Peek");
		Info.setBounds(10, 22, 692, 62);
		Info.setEditable(false);
		stackInformation.add(Info);
		// end of stack panel

		// queuePanel and its including Functions;
		queuePanel = new JPanel();
		queuePanel.setBounds(10, 65, 732, 387);

		queuePanel.setLayout(null);

		JLabel lblQueue = new JLabel("Queue");
		lblQueue.setBounds(342, 11, 45, 30);
		lblQueue.setFont(new Font("Serif", Font.BOLD, 16));
		queuePanel.add(lblQueue);

		JPanel queueOperation = new JPanel();
		queueOperation.setBounds(10, 40, 230, 233);
		queueOperation.setBorder(BorderFactory.createLineBorder(Color.black));
		queuePanel.add(queueOperation);
		queueOperation.setLayout(null);
		//
		JTextArea qGraphicalResult = new JTextArea();

		JTextField qtextField = new JTextField();
		qtextField.setBounds(109, 47, 95, 20);
		JLabel qResult = new JLabel("");
		qResult.setBounds(20, 162, 184, 60);
		JButton btnEnqueue = new JButton("Enqueue");
		btnEnqueue.setBounds(10, 46, 89, 23);
		btnEnqueue.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (qtextField.getText().isEmpty()) {
					qResult.setText("Please Enter Something!!");
				} else {
					if (queue.Enqueue(qtextField.getText())) {
						qResult.setText(qtextField.getText() + "-> Enqueued Succesfully");
						qtextField.setText("");
						qGraphicalResult.setText(queue.printqueue());
						qGraphicalResult.setSelectionStart(0);
						qGraphicalResult.setSelectionEnd(0);
					} else {
						qResult.setText("Queue is Full ");
						qtextField.setText("");
					}
				}
			}
		});
		JButton btnDequeue = new JButton("Dequeue");
		btnDequeue.setBounds(10, 80, 89, 23);
		btnDequeue.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (queue.isEmpty()) {
					qResult.setText("Queue is empty");
				} else {
					queue.Dequeue();
					qResult.setText("Dequeued Succesfully ");
					qGraphicalResult.setText(queue.printqueue());
					qGraphicalResult.setSelectionStart(0);
					qGraphicalResult.setSelectionEnd(0);
				}
			}
		});
		JLabel qlblResult = new JLabel("Result");
		qlblResult.setBounds(74, 148, 46, 14);
		queueOperation.add(qtextField);
		queueOperation.add(qResult);
		queueOperation.add(qlblResult);
		queueOperation.add(btnEnqueue);
		queueOperation.add(btnDequeue);

		JLabel queueLblOperation = new JLabel("Operations");
		queueLblOperation.setBounds(74, 11, 87, 14);
		queueOperation.add(queueLblOperation);

		JPanel queueDisplay = new JPanel();
		queueDisplay.setBounds(250, 40, 472, 233);
		queueDisplay.setBorder(BorderFactory.createLineBorder(Color.black));
		queuePanel.add(queueDisplay);
		queueDisplay.setLayout(null);

		JLabel queuelblDisplay = new JLabel("Display ");
		queuelblDisplay.setBounds(183, 11, 46, 14);
		queueDisplay.add(queuelblDisplay);

		qGraphicalResult.setText("Result Will Display Here");
		qGraphicalResult.setEditable(false);
		qGraphicalResult.setBounds(10, 36, 452, 186);
		queueDisplay.add(qGraphicalResult);

		JPanel queueInformation = new JPanel();
		queueInformation.setBounds(10, 281, 712, 95);
		queueInformation.setBorder(BorderFactory.createLineBorder(Color.black));
		queuePanel.add(queueInformation);
		queueInformation.setLayout(null);

		JLabel queuelblInformation = new JLabel("Information");
		queuelblInformation.setBounds(303, 0, 116, 14);
		JTextArea qInfo = new JTextArea();
		qInfo.setText("A queue conatins values which are managed in First in and first out Sequence (FIFO) . \n "
				+ "Queue Data Structures. Queue is also an abstract data type or a linear data structure \n "
				+ "in which the first element is inserted from one end called REAR(also called tail), \n"
				+ "and the deletion of exisiting element takes place from the other end called as FRONT(also called head).");
		qInfo.setBounds(10, 22, 692, 62);
		qInfo.setEditable(false);
		queueInformation.add(queuelblInformation);
		queueInformation.add(qInfo);

		// end of queuePanel

		// ListPanel and its including subpanel and functions
		listPanel = new JPanel();
		listPanel.setBounds(10, 65, 732, 387);

		listPanel.setLayout(null);
		JTextArea lGraphicalResult = new JTextArea("");

		JLabel lbllist = new JLabel("List");
		lbllist.setBounds(342, 11, 39, 22);
		lbllist.setFont(new Font("Serif", Font.BOLD, 16));
		listPanel.add(lbllist);

		JPanel listOperation = new JPanel();
		listOperation.setBounds(10, 40, 230, 233);
		listOperation.setBorder(BorderFactory.createLineBorder(Color.black));
		listPanel.add(listOperation);
		listOperation.setLayout(null);

		JLabel listLblOperation = new JLabel("Operations");
		listLblOperation.setBounds(74, 11, 87, 14);
		listOperation.add(listLblOperation);
		JLabel lResult = new JLabel("Resultout");

		JButton btnInsert_1 = new JButton("Insert");
		btnInsert_1.setBounds(10, 36, 89, 23);
		btnInsert_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (txtInsert.getText().isEmpty()) {
					lResult.setText("Please Enter Something!!");
				} else {
					if (isStringInt(txtInsert.getText())) {
						list.insert(Integer.parseInt(txtInsert.getText()));
						lResult.setText(txtInsert.getText() + "-> inserted  Succesfully");
						txtInsert.setText("");
						lGraphicalResult.setText(list.print());

					} else {
						lResult.setText("Please enter integer only!!");
					}
				}
			}
		});
		listOperation.add(btnInsert_1);

		JButton btnRemIndex = new JButton("Rem Index");
		btnRemIndex.setBounds(10, 70, 89, 23);
		btnRemIndex.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (txtRemove.getText().isEmpty()) {
					lResult.setText("Please Enter Something!!");
				} else {
					if (isStringInt(txtRemove.getText())) {
						if (list.remove(Integer.parseInt(txtRemove.getText()))) {
							lResult.setText(txtRemove.getText() + "-> index value removed ");
							txtRemove.setText("");
							lGraphicalResult.setText(list.print());
							lGraphicalResult.setSelectionStart(0);
							lGraphicalResult.setSelectionEnd(0);
						} else {
							lResult.setText(txtRemove.getText() + "->not found");
						}
					} else {
						lResult.setText("Please enter integer only!!");
					}
				}
			}
		});
		listOperation.add(btnRemIndex);

		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(10, 104, 89, 23);
		btnSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (txtSearch.getText().isEmpty()) {
					lResult.setText("Please Enter Something!!");
				} else {
					if (isStringInt(txtSearch.getText())) {
						if (list.search(Integer.parseInt(txtSearch.getText()))) {
							lResult.setText(txtSearch.getText() + "-> is present index "
									+ list.getindex(Integer.parseInt(txtSearch.getText())));
							txtSearch.setText("");
							lGraphicalResult.setText(list.print());
						} else {
							lResult.setText(txtSearch.getText() + "->not found");
						}
					} else {
						lResult.setText("Please enter integer only!!");
					}
				}
			}
		});
		listOperation.add(btnSearch);

		txtInsert = new JTextField();
		txtInsert.setText("");
		txtInsert.setBounds(107, 37, 86, 20);
		listOperation.add(txtInsert);
		txtInsert.setColumns(10);

		txtRemove = new JTextField();
		txtRemove.setText("");
		txtRemove.setBounds(109, 71, 86, 20);
		listOperation.add(txtRemove);
		txtRemove.setColumns(10);

		txtSearch = new JTextField();
		txtSearch.setText("");
		txtSearch.setBounds(107, 105, 86, 20);
		listOperation.add(txtSearch);
		txtSearch.setColumns(10);

		JLabel lblResult_2 = new JLabel("Result");
		lblResult_2.setBounds(74, 146, 46, 14);
		listOperation.add(lblResult_2);

		lResult.setBounds(10, 171, 183, 51);
		listOperation.add(lResult);

		JPanel listDisplay = new JPanel();
		listDisplay.setBounds(250, 40, 472, 233);
		listDisplay.setBorder(BorderFactory.createLineBorder(Color.black));
		listPanel.add(listDisplay);
		listDisplay.setLayout(null);

		lGraphicalResult.setText("Result Will Display Here");
		lGraphicalResult.setBackground(Color.decode("#F0F0F0"));
		lGraphicalResult.setEditable(false);
		lGraphicalResult.setBounds(10, 36, 452, 186);

		JScrollPane lscrollPane = new JScrollPane();
		lscrollPane.setBounds(10, 36, 452, 186);
		lscrollPane.setViewportView(lGraphicalResult);
		listDisplay.add(lscrollPane);

		JLabel listlblDisplay = new JLabel("Display ");
		listlblDisplay.setBounds(183, 11, 46, 14);
		listDisplay.add(listlblDisplay);

		JPanel listInformation = new JPanel();
		listInformation.setBounds(10, 281, 712, 95);
		listInformation.setBorder(BorderFactory.createLineBorder(Color.black));
		listPanel.add(listInformation);
		listInformation.setLayout(null);

		JLabel listlblInformation = new JLabel("Information");
		listlblInformation.setBounds(303, 0, 116, 14);
		JTextArea lInfo = new JTextArea();
		lInfo.setText("A list is type of data structure in which all elements are linked to each other . \n "
				+ "You can insert value at any index in list or insert in sorted list \n "
				+ "The remove function requires the index value to be removed");
		lInfo.setBounds(10, 22, 692, 62);
		lInfo.setEditable(false);
		listInformation.add(lInfo);
		listInformation.add(listlblInformation);
		// end of list panel

		// set panel
		setPanel = new JPanel();
		setPanel.setBounds(10, 65, 732, 387);

		setPanel.setLayout(null);
		JLabel sResult = new JLabel("");
		JLabel lblset = new JLabel("Set");
		JTextArea sGraphicalResult = new JTextArea();

		lblset.setBounds(342, 11, 39, 22);
		lblset.setFont(new Font("Serif", Font.BOLD, 16));
		setPanel.add(lblset);

		JPanel setOperation = new JPanel();
		setOperation.setBounds(10, 40, 230, 233);
		setOperation.setBorder(BorderFactory.createLineBorder(Color.black));
		JLabel setLblOperation = new JLabel("Operations");
		setLblOperation.setBounds(74, 11, 87, 14);
		setOperation.add(setLblOperation);
		setPanel.add(setOperation);
		setOperation.setLayout(null);

		JButton btnInsert_2 = new JButton("Insert");
		btnInsert_2.setBounds(10, 44, 89, 23);
		setOperation.add(btnInsert_2);

		JButton btnRemove_1 = new JButton("Remove");
		btnRemove_1.setBounds(10, 89, 89, 23);
		btnRemove_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (sRemove.getText().isEmpty()) {
					sResult.setText("Please Enter Something!!");
				} else {
					if (set.remove(sRemove.getText())) {
						sResult.setText(textField.getText() + "-> REMOVED Succesfully");
						sRemove.setText("");
						sGraphicalResult.setText(set.print());
						sGraphicalResult.setSelectionStart(0);
						sGraphicalResult.setSelectionEnd(0);
					} else {
						sResult.setText("Value not present");
					}
				}
			}
		});
		setOperation.add(btnRemove_1);

		JButton btnSearch_1 = new JButton("Search");
		btnSearch_1.setBounds(10, 123, 89, 23);
		btnSearch_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (sSearch.getText().isEmpty()) {
					sResult.setText("Please Enter Something!!");
				} else {
					if (set.search(sSearch.getText())) {
						sResult.setText(sSearch.getText() + "-> is present");
						sSearch.setText("");
						sGraphicalResult.setText(set.print());
						sGraphicalResult.setSelectionStart(0);
						sGraphicalResult.setSelectionEnd(0);
					} else {
						sResult.setText("Value not present in set");
					}
				}
			}
		});
		setOperation.add(btnSearch_1);

		sInsert = new JTextField();
		sInsert.setBounds(112, 45, 86, 20);
		btnInsert_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (sInsert.getText().isEmpty()) {
					sResult.setText("Please Enter Something!!");
				} else {
					if (set.Add(sInsert.getText())) {
						sResult.setText(textField.getText() + "-> inserted Succesfully");
						sInsert.setText("");
						sGraphicalResult.setText(set.print());
						sGraphicalResult.setSelectionStart(0);
						sGraphicalResult.setSelectionEnd(0);
					} else {
						sResult.setText("Duplicate value");
					}
				}
			}
		});
		setOperation.add(sInsert);
		sInsert.setColumns(10);

		sRemove = new JTextField();
		sRemove.setBounds(112, 90, 86, 20);
		setOperation.add(sRemove);
		sRemove.setColumns(10);

		sSearch = new JTextField();
		sSearch.setBounds(112, 124, 86, 20);
		setOperation.add(sSearch);
		sSearch.setColumns(10);

		JPanel setDisplay = new JPanel();
		setDisplay.setBounds(250, 40, 472, 233);
		setDisplay.setBorder(BorderFactory.createLineBorder(Color.black));
		setPanel.add(setDisplay);
		setDisplay.setLayout(null);

		JLabel setlblDisplay = new JLabel("Display ");
		setlblDisplay.setBounds(183, 11, 46, 14);
		setDisplay.add(setlblDisplay);

		JPanel setInformation = new JPanel();
		setInformation.setBounds(10, 281, 712, 95);
		setInformation.setBorder(BorderFactory.createLineBorder(Color.black));
		setPanel.add(setInformation);
		setInformation.setLayout(null);

		JLabel lblsResult = new JLabel("Result");
		lblsResult.setBounds(74, 146, 46, 14);
		setOperation.add(lblsResult);

		sResult.setBounds(10, 171, 183, 51);
		setOperation.add(sResult);

		sGraphicalResult.setText("");
		sGraphicalResult.setBackground(Color.decode("#F0F0F0"));
		sGraphicalResult.setFont(new Font("ARIAL", Font.BOLD, 18));
		sGraphicalResult.setEditable(false);
		sGraphicalResult.setBounds(10, 36, 452, 186);

		JScrollPane sscrollPane = new JScrollPane();
		sscrollPane.setBounds(10, 36, 452, 186);
		sscrollPane.setViewportView(sGraphicalResult);
		setDisplay.add(sscrollPane);
		
		JLabel setlblInformation = new JLabel("Information");
		setlblInformation.setBounds(303, 0, 116, 14);
		JTextArea sInfo=new JTextArea();
		sInfo.setText("A set is type of data structure in which all elements are holded together . \n "
				+ "The order does not matter in set you can insert value at the end of set and does not allows duplicate values.\n "
				+ "The remove function requires the  value to be removed");
		sInfo.setBounds(10, 22, 692, 62);
		sInfo.setEditable(false);
		setInformation.add(sInfo);
		setInformation.add(setlblInformation);
		// End of set Panel

		// treePanel and its including subfunction and display modules
		treePanel = new JPanel();
		treePanel.setBounds(10, 65, 732, 387);

		treePanel.setLayout(null);

		JLabel lbltree = new JLabel("Tree");
		lbltree.setBounds(342, 11, 39, 22);
		lbltree.setFont(new Font("Serif", Font.BOLD, 16));
		treePanel.add(lbltree);

		JPanel treeOperation = new JPanel();
		treeOperation.setBounds(10, 40, 230, 233);
		treeOperation.setBorder(BorderFactory.createLineBorder(Color.black));
		treePanel.add(treeOperation);
		treeOperation.setLayout(null);

		JLabel treeLblOperation = new JLabel("Operations");
		treeLblOperation.setBounds(74, 11, 87, 14);
		treeOperation.add(treeLblOperation);

		insertTextField = new JTextField();
		insertTextField.setBounds(134, 36, 86, 20);
		treeOperation.add(insertTextField);
		insertTextField.setColumns(10);

		JLabel tResult = new JLabel("");
		JTextArea tGraphicalResult = new JTextArea();
		JButton btnInsert = new JButton("Insert");
		btnInsert.setBounds(25, 36, 89, 23);
		btnInsert.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				if (insertTextField.getText().isEmpty()) {
					tResult.setText("Please Enter Something!!");
				} else {
					if (isStringInt(insertTextField.getText())) {
						btree.insert(Integer.parseInt(insertTextField.getText()));
						tResult.setText(insertTextField.getText() + "-> inserted Succesfully");
						insertTextField.setText("");
						tGraphicalResult.setText(btree.displayTree(btree.root));
						tGraphicalResult.setSelectionStart(0);
						tGraphicalResult.setSelectionEnd(0);
					}

					else {
						tResult.setText("Please enter integer only!!");
					}
				}
			}

		});
		treeOperation.add(btnInsert);

		JButton btnRemove = new JButton("Remove");
		btnRemove.setBounds(25, 82, 89, 23);
		btnRemove.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (removeTextField.getText().isEmpty()) {
					tResult.setText("Please Enter Something!!");
				} else {
					if (isStringInt(removeTextField.getText())) {
						if (btree.deleteNode(Integer.parseInt(removeTextField.getText()))) {
							tResult.setText(removeTextField.getText() + "-> deleted  Succesfully");
							removeTextField.setText("");
							tGraphicalResult.setText(btree.displayTree(btree.root));
							tGraphicalResult.setSelectionStart(0);
							tGraphicalResult.setSelectionEnd(0);
						} else {
							tResult.setText(removeTextField.getText() + "->not found");
						}
					} else {
						tResult.setText("Please enter integer only!!");
					}
				}
			}
		});
		treeOperation.add(btnRemove);

		removeTextField = new JTextField();
		removeTextField.setBounds(134, 83, 86, 20);
		treeOperation.add(removeTextField);
		removeTextField.setColumns(10);

		JButton btnHeight = new JButton("Height");
		btnHeight.setBounds(74, 127, 89, 23);
		btnHeight.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "The height of tree is " + btree.getheight(btree.root), "Height",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		treeOperation.add(btnHeight);

		JLabel lblResult_1 = new JLabel("Result");
		lblResult_1.setBounds(84, 164, 65, 14);
		treeOperation.add(lblResult_1);

		tResult.setBounds(21, 183, 199, 39);
		treeOperation.add(tResult);

		JPanel treeDisplay = new JPanel();
		treeDisplay.setBounds(250, 40, 472, 233);
		treeDisplay.setBorder(BorderFactory.createLineBorder(Color.black));
		treePanel.add(treeDisplay);
		treeDisplay.setLayout(null);

		JLabel treelblDisplay = new JLabel("Display ");
		treelblDisplay.setBounds(183, 11, 46, 14);
		treeDisplay.add(treelblDisplay);

		tGraphicalResult.setText("Result Will Display Here");
		tGraphicalResult.setEditable(false);
		tGraphicalResult.setBackground(Color.decode("#F0F0F0"));
		tGraphicalResult.setBounds(10, 36, 452, 186);

		JScrollPane tscrollPane = new JScrollPane();
		tscrollPane.setBounds(10, 36, 452, 186);
		tscrollPane.setViewportView(tGraphicalResult);
		treeDisplay.add(tscrollPane);

		JPanel treeInformation = new JPanel();
		treeInformation.setBounds(10, 281, 712, 95);
		treeInformation.setBorder(BorderFactory.createLineBorder(Color.black));
		treePanel.add(treeInformation);
		treeInformation.setLayout(null);

		JLabel treelblInformation = new JLabel("Information");
		treelblInformation.setBounds(303, 0, 116, 14);

		JTextArea tInfo = new JTextArea();
		tInfo.setText(
				"A binary tree is a type of data structure in which each node has exactly two child nodes and the node  . \n "
						+ "are usually arranged in such a manner that if greater it goes to right and if less or equal then left  \n "
						+ "Search has average case complexti O(Logn) and worst case O(n).Similarly insert has Average case O(logn)  \n"
						+ "and worst case O(n) and Delete has Average case O(logn) has worst case O(n).");
		tInfo.setBounds(10, 22, 692, 62);
		tInfo.setEditable(false);
		treeInformation.add(tInfo);
		treeInformation.add(treelblInformation);
		// End of buttons functions

		// Start of menu bar methods
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnFunctions = new JMenu("Functions");
		menuBar.add(mnFunctions);

		JMenuItem mntmMakeEmpty = new JMenuItem("Make Empty");
		mntmMakeEmpty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// making all structures empty here

				// stack
				stack.makeEmpty();

				// list
				list.makeEmpty();
				// tree
				btree.makeEmpty();
				// queue
				queue.makeEmpty();
				// set
				set.makeEmpty();
				
				// updating views
				Result.setText("");
				GraphicalResult.setText("");
				qResult.setText("");
				qGraphicalResult.setText("");
				tResult.setText("");
				tGraphicalResult.setText("");
				lResult.setText("");
				lGraphicalResult.setText("");
				sResult.setText("");
				sGraphicalResult.setText("");
				// Displaying the successfull result
				JOptionPane.showMessageDialog(null, "Made All Structures Empty Successfully", "Success!!",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mnFunctions.add(mntmMakeEmpty);

		JMenuItem mntmIsempty = new JMenuItem("IsEmpty");
		mntmIsempty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// first check which structure is selected
				if (tabbedPane.getSelectedIndex() == 0) {
					if (stack.s.empty())
						JOptionPane.showMessageDialog(null, "Stack is Empty", "IsEmpty()",
								JOptionPane.INFORMATION_MESSAGE);
					else
						JOptionPane.showMessageDialog(null, "Stack is not Empty", "IsEmpty()",
								JOptionPane.INFORMATION_MESSAGE);
				} else if (tabbedPane.getSelectedIndex() == 1) {
					if (queue.isEmpty())
						JOptionPane.showMessageDialog(null, "QUEUE is Empty", "IsEmpty()",
								JOptionPane.INFORMATION_MESSAGE);
					else
						JOptionPane.showMessageDialog(null, "QUEUE is not Empty", "IsEmpty()",
								JOptionPane.INFORMATION_MESSAGE);
				} else if (tabbedPane.getSelectedIndex() == 2) {
					if (list.isEmpty())
						JOptionPane.showMessageDialog(null, "List is Empty", "IsEmpty()",
								JOptionPane.INFORMATION_MESSAGE);
					else
						JOptionPane.showMessageDialog(null, "List is not Empty", "IsEmpty()",
								JOptionPane.INFORMATION_MESSAGE);
					
				} 
				else if(tabbedPane.getSelectedIndex()==3){
					if (set.isEmpty())
						JOptionPane.showMessageDialog(null, "Set is Empty", "IsEmpty()",
								JOptionPane.INFORMATION_MESSAGE);
					else
						JOptionPane.showMessageDialog(null, "Setis not Empty", "IsEmpty()",
								JOptionPane.INFORMATION_MESSAGE);
				}
				else if (tabbedPane.getSelectedIndex() == 4) {
					if (btree.isEmpty())
						JOptionPane.showMessageDialog(null, "TREE is Empty", "IsEmpty()",
								JOptionPane.INFORMATION_MESSAGE);
					else
						JOptionPane.showMessageDialog(null, "TREE is not Empty", "IsEmpty()",
								JOptionPane.INFORMATION_MESSAGE);
				}

				// similarly will be added later if for needed structures
			}
		});
		mnFunctions.add(mntmIsempty);

		JMenu mnAbout = new JMenu("About");
		menuBar.add(mnAbout);

		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"The Structures in this application are\n Stack\n List\n Tree\n Queue\n Set \n This application is keen to provide all kind of operation of the \n structures given with graphical display . ",
						"About", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mnAbout.add(mntmAbout);

		JMenu mnExit = new JMenu("Exit");
		menuBar.add(mnExit);

		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ObjButtons[] = { "Yes", "No" };
				int PromptResult = JOptionPane.showOptionDialog(null, "Are you sure you want to exit?",
						"Data Structures ", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, ObjButtons,
						ObjButtons[1]);
				if (PromptResult == 0) {
					System.exit(0);
				}
			}
		});
		mnExit.add(mntmExit);
		// End of menu bar

		// start of menu pane

		tabbedPane.setBounds(10, 11, 732, 450);

		tabbedPane.addTab("Stack", null, stackPanel, null);

		tabbedPane.addTab("Queue", null, queuePanel, null);

		tabbedPane.addTab("List", null, listPanel, null);

		tabbedPane.addTab("Set", null, setPanel, null);

		tabbedPane.addTab("Tree", null, treePanel, null);
		getContentPane().add(tabbedPane);

		// end of tabbed pane

		setVisible(true);
	}

	public boolean isStringInt(String s) {
		try {
			Integer.parseInt(s);
			return true;
		} catch (NumberFormatException ex) {
			return false;
		}
	}
}
