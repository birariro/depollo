
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;

public class CodeReviewToolWindowFactory implements ToolWindowFactory {

	@Override
	public void createToolWindowContent(Project project, ToolWindow toolWindow) {
		System.out.println("[CodeReviewToolWindowFactory] createToolWindowContent");
		CodeReviewToolWindow codeReviewToolWindow = new CodeReviewToolWindow(project);
		ContentFactory contentFactory = ApplicationManager.getApplication().getService(ContentFactory.class);
		Content content = contentFactory.createContent(codeReviewToolWindow.getContent(), null, false);

		toolWindow.getContentManager().addContent(content);
	}
}
