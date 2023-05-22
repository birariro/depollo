
import java.awt.*;

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

	@Override
	public void actionPerformed(AnActionEvent e) {
		// 드래그한 텍스트 얻기
		String selectedText = e.getDataContext().getData(CommonDataKeys.EDITOR).getSelectionModel().getSelectedText();

		// toolWindow 얻기
		Project project = e.getProject();
		ToolWindowManager toolWindowManager = ToolWindowManager.getInstance(project);
		ToolWindow toolWindow = toolWindowManager.getToolWindow("CodeReview");

		// 텍스트 화면에 표시
		if (toolWindow != null) {
			toolWindow.activate(null);
			toolWindow.getContentManager().removeAllContents(true);
			toolWindow.getContentManager().addContent(createContent(selectedText));
		}
	}


	private Content createContent(String text) {
		JTextPane textPane = new JTextPane();
		textPane.setText(text);

		JScrollPane scrollPane = new JScrollPane(textPane);
		JPanel panel = new JPanel(new BorderLayout());
		panel.add(scrollPane, BorderLayout.CENTER);

		ContentFactory contentFactory = ContentFactory.SERVICE.getInstance();
		return contentFactory.createContent(panel, null, false);
	}
}
