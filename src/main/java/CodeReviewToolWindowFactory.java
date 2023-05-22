import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;

public class CodeReviewToolWindowFactory implements ToolWindowFactory {

	private static List<String> questions = new ArrayList<>();
	private JPanel mainPanel;

	@Override
	public void createToolWindowContent(Project project, ToolWindow toolWindow) {
		// toolWindow에 초기 컨텐츠를 추가하는 로직 작성
		// 예를 들어, JPanel에 JTextPane을 추가하는 등의 작업 수행

		// // Content 객체 생성
		// ContentFactory contentFactory = ContentFactory.SERVICE.getInstance();
		// Content content = contentFactory.createContent(toolWindowContentPanel, null, false);
		//
		// // Content 추가
		// toolWindow.getContentManager().addContent(content);
	}
}
