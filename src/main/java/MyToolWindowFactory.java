import javax.swing.*;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;

public class MyToolWindowFactory implements ToolWindowFactory {

	private static String displayedText = "none"; // 선택된 텍스트를 저장하는 변수
	private JPanel MyToolWindowFactory;

	@Override
	public void createToolWindowContent(Project project, ToolWindow toolWindow) {

		JPanel mainPanel = new JPanel();
		JLabel question = new JLabel(displayedText);
		mainPanel.add(question);

		ContentFactory contentFactory = ContentFactory.SERVICE.getInstance();
		Content content = contentFactory.createContent(mainPanel, "", false);
		toolWindow.getContentManager().addContent(content);
	}

	// 선택된 텍스트를 설정하는 메서드
	public static void setDisplayedText(String text) {
		displayedText = text;
	}
}
