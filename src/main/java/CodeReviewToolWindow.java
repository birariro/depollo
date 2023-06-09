

import javax.swing.*;

import org.jetbrains.annotations.NotNull;

import com.intellij.openapi.project.Project;

import review.ReviewMainPanel;

public class CodeReviewToolWindow {

	private final ReviewMainPanel panel;

	public CodeReviewToolWindow(@NotNull Project project) {
		System.out.println("[CodeReviewToolWindow] CodeReviewToolWindow");
		this.panel = new ReviewMainPanel(project, true);
	}


	public ReviewMainPanel getPanel() {
		return panel;
	}

	public JPanel getContent() {
		return panel.init();
	}
}
