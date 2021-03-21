package com.jp;

import java.awt.Font;
import javax.swing.*;



public class Driver {

	private static final int SET_TO_WORD_SEARCH = 0;
	private static final int SET_TO_ANAGRAMMER = 1;
	private static int functionSpinnerState = 0;

	private static JFrame mainFrame;
	private static JLabel inputLabel;
	private static JLabel functionLabel;
	private static JLabel wildcardLabel;
	private static JTextField textInput;
	private static JButton activateButton;
	private static JScrollPane outputScrollPane;
	private static JTextArea outputTextArea;
	private static JSpinner functionSpinner;
	private static Dawg thisDawg;

	public static void main(String[] args) throws Exception{

		mainFrame = new JFrame("TWL06 DAWG Lexicon Engine");
		inputLabel = new JLabel("Enter A String");
		functionLabel = new JLabel("Choose Lexicon Function");
		wildcardLabel = new JLabel("'?' = Wildcard Character");
		textInput = new JTextField(20);
		activateButton = new JButton("Activate");
		outputScrollPane = new JScrollPane();
		outputTextArea = new JTextArea();
		functionSpinner = new JSpinner();

		outputTextArea.setColumns(20);
		outputTextArea.setRows(5);
		outputTextArea.setEditable(false);
		outputTextArea.setFont(new Font("Courier", Font.PLAIN, 12));
		outputScrollPane.setViewportView(outputTextArea);

		functionSpinner.setModel(new javax.swing.SpinnerListModel(new String[] {"Word Search       ", "Anagrammer       "}));

		textInput.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				textInputActionPerformed(evt);
			}
		});
		activateButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				activateButtonActionPerformed(evt);
			}
		});
		functionSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
			public void stateChanged(javax.swing.event.ChangeEvent evt) {
				functionSpinnerStateChanged(evt);
			}
		});


		GroupLayout layout = new GroupLayout(mainFrame.getContentPane());
		mainFrame.getContentPane().setLayout(layout);

		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
						.addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
							.addComponent(functionLabel)
							.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
							.addComponent(functionSpinner))
						.addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
							.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addGroup(layout.createSequentialGroup()
									.addComponent(textInput, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
									.addComponent(inputLabel))
								.addComponent(wildcardLabel))
							.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(activateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addComponent(outputScrollPane, javax.swing.GroupLayout.Alignment.LEADING))
					.addGap(60, 60, 60))
			);
			layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
						.addGroup(layout.createSequentialGroup()
							.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(textInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(inputLabel))
							.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(wildcardLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
							.addGap(9, 9, 9))
						.addGroup(layout.createSequentialGroup()
							.addComponent(activateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
					.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(functionLabel)
						.addComponent(functionSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(outputScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE -10)
					.addContainerGap())
			);


		mainFrame.pack();
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setVisible(true);
		thisDawg = new Dawg();
	}

	private static void textInputActionPerformed(java.awt.event.ActionEvent evt) {
		String theInput = textInput.getText();
		if ( validateInput(theInput) ) {
			if ( functionSpinnerState == SET_TO_WORD_SEARCH ) {
				if ( theInput.indexOf('?') == -1 )outputTextArea.setText(thisDawg.searchForString(theInput));
				else outputTextArea.setText(thisDawg.searchForPattern(theInput));
			}
			else {
				outputTextArea.setText(thisDawg.anagram(theInput));
			}
		}
		else outputTextArea.setText("\"" + theInput + "\" Invalid, try again.");
		textInput.selectAll();
	}

	private static void activateButtonActionPerformed(java.awt.event.ActionEvent evt) {
		String theInput = textInput.getText();
		if ( validateInput(theInput) ) {
			if ( functionSpinnerState == SET_TO_WORD_SEARCH ) {
				if ( theInput.indexOf('?') == -1 )outputTextArea.setText(thisDawg.searchForString(theInput));
				else outputTextArea.setText(thisDawg.searchForPattern(theInput));
			}
			else {
				outputTextArea.setText(thisDawg.anagram(theInput));
			}
		}
		else outputTextArea.setText("\"" + theInput + "\" Invalid, try again.");
		textInput.requestFocusInWindow();
		textInput.selectAll();
	}

	private static void functionSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {
		String functionReturn = new String((String)functionSpinner.getValue());
		if ( functionReturn.equals("Word Search       ") ) functionSpinnerState = SET_TO_WORD_SEARCH;
		else functionSpinnerState = SET_TO_ANAGRAMMER;
	}

	// Anagramming allows the '?' wildcard char to be input.
	private static boolean validateInput(String userInput){
		char currentChar;
		for( int x = (userInput.length() - 1); x >= 0; x-- ){
			currentChar = userInput.charAt(x);
			if ( currentChar >= 'A' && currentChar <= 'Z' ) continue;
			if ( currentChar >= 'a' && currentChar <= 'z' ) continue;
			if ( currentChar == '?' ) continue;
			return false;
		}
		return true;
	}

}
