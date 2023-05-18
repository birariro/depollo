
import org.jetbrains.annotations.NotNull;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.CaretModel;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowManager;

public class CodeReviewAction extends AnAction {

	private ToolWindow toolWindow;

	@Override
	public void actionPerformed(@NotNull AnActionEvent e) {


		Editor editor = e.getRequiredData(CommonDataKeys.EDITOR);
		CaretModel caretModel = editor.getCaretModel();
		String selectedText = caretModel.getCurrentCaret().getSelectedText();

		System.out.println("selectedText = " + selectedText);

		// MyToolWindowFactory로 선택된 텍스트 전달
		MyToolWindowFactory.setDisplayedText(selectedText);

		// Tool Window 열기
		if (toolWindow != null) {
			toolWindow.show(null);
		}
	}

	@Override
	public void update(AnActionEvent e) {
		toolWindow = ToolWindowManager.getInstance(e.getProject()).getToolWindow("depolloWindow");
		Editor editor = e.getRequiredData(CommonDataKeys.EDITOR);
		CaretModel caretModel = editor.getCaretModel();
		e.getPresentation().setEnabledAndVisible(caretModel.getCurrentCaret().hasSelection());
	}
}
