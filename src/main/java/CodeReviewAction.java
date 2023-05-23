
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;


import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowManager;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;

public class CodeReviewAction extends AnAction {

	private static List<String> questions = new ArrayList<>();
	@Override
	public void actionPerformed(AnActionEvent e) {
		// 드래그한 텍스트 얻기
		String selectedText = e.getDataContext().getData(CommonDataKeys.EDITOR).getSelectionModel().getSelectedText();
		questions.add(selectedText);

		// toolWindow 얻기
		Project project = e.getProject();
		ToolWindowManager toolWindowManager = ToolWindowManager.getInstance(project);
		ToolWindow toolWindow = toolWindowManager.getToolWindow("CodeReview");

		// 텍스트 화면에 표시
		if (toolWindow != null) {
			toolWindow.activate(null);
			toolWindow.getContentManager().removeAllContents(true);
			toolWindow.getContentManager().addContent(createContent(questions));
		}
	}


	private Content createContent(List<String> texts) {
		JPanel mainPanel = new JPanel();
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		for (String text : texts) {
			JEditorPane textPane = createBubblePane(text);
			panel.add(textPane);
			panel.add(Box.createVerticalStrut(10)); // 간격 추가
		}


		mainPanel.add(panel);

		ContentFactory contentFactory = ContentFactory.SERVICE.getInstance();
		return contentFactory.createContent(mainPanel, null, false);
	}

	private JEditorPane createBubblePane(String text) {
		JEditorPane textPane = new JEditorPane();
		textPane.setContentType("text/html");
		textPane.setText("<html><body><div style='padding: 5px; border: 1px solid black; width: 100%; background-color: #F0F0F0;'>" + text + "</div></body></html>");
		return textPane;
	}
}
