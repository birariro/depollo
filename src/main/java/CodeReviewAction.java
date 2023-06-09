
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;


import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowManager;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;

public class CodeReviewAction extends AnAction {

	private static List<String> questions = new ArrayList<>();
	private static List<String> questions_result = new ArrayList<>();
	@Override
	public void actionPerformed(AnActionEvent e) {

		Project project = e.getProject();
		ToolWindowManager toolWindowManager = ToolWindowManager.getInstance(project);
		ToolWindow toolWindow = toolWindowManager.getToolWindow("CodeReview");
		toolWindow.activate(null);

		//
		// // 드래그한 텍스트 얻기
		// String selectedText = e.getDataContext().getData(CommonDataKeys.EDITOR).getSelectionModel().getSelectedText();
		// questions.add(selectedText);
		// //test
		// questions_result.add(selectedText+" result");
		//
		//
		// // toolWindow 얻기
		// Project project = e.getProject();
		// ToolWindowManager toolWindowManager = ToolWindowManager.getInstance(project);
		// ToolWindow toolWindow = toolWindowManager.getToolWindow("CodeReview");
		//
		//
		//
		// // 텍스트 화면에 표시
		// if (toolWindow != null) {
		// 	toolWindow.activate(null);
		// 	toolWindow.getContentManager().removeAllContents(true);
		// 	toolWindow.getContentManager().addContent(createContent(questions));
		// }
	}


	private Content createContent(List<String> texts) {
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.insets = new Insets(5, 5, 5, 5); // 패딩을 위한 insets 설정

		for (int i = 0; i < texts.size(); i++) {
			String question = questions.get(i);
			String questionResult = questions_result.get(i);

			JPanel questionBox = getQuestionBox(question);
			constraints.gridy = i * 2;
			mainPanel.add(questionBox, constraints);

			JPanel questionResultBox = getQuestionResultBox(questionResult);
			constraints.gridy = i * 2 + 1;
			mainPanel.add(questionResultBox, constraints);
		}

		JScrollPane scrollPane = new JScrollPane(mainPanel);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		ContentFactory contentFactory = ContentFactory.SERVICE.getInstance();
		return contentFactory.createContent(scrollPane, null, false);
	}

	private JPanel getQuestionBox(String text) {

		//바디
		JPanel panel = new JPanel();
		//텍스트
		JLabel jLabel = new JLabel();
		jLabel.setText("<html><body><div style='padding: 5px; border: 1px solid white; border-radius: 10px; width: 100%; color: black; background-color: #F0F0F0;'>" + text + "</div></body></html>");

		panel.add(jLabel);
		panel.add(Box.createVerticalStrut(10)); // 간격 추가

		return panel;
	}

	private JPanel getQuestionResultBox(String text) {

		//바디
		JPanel panel = new JPanel();
		//텍스트
		JLabel jLabel = new JLabel();
		jLabel.setText("<html><body><div style='padding: 5px; border: 1px solid white; border-radius: 10px; width: 100%; color: red; background-color: #F0F0F0;'>" + text + "</div></body></html>");

		panel.add(jLabel);
		panel.add(Box.createVerticalStrut(10)); // 간격 추가

		return panel;
	}
}
