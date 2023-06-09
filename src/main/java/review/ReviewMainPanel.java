package review;

import java.awt.*;

import javax.swing.*;

import org.jetbrains.annotations.NotNull;

import com.intellij.find.SearchTextArea;
import com.intellij.openapi.project.Project;
import com.intellij.ui.OnePixelSplitter;
import com.intellij.ui.components.JBTextArea;

public class ReviewMainPanel {

	private final Project project;
	private final OnePixelSplitter splitter;
	private final SearchTextArea searchTextArea;
	private final JButton sendButton;
	private JPanel actionPanel;
	private ReviewContextPanel contentPanel;

	public ReviewMainPanel(@NotNull Project project, boolean isChatGPTModel) {
		System.out.println("[ReviewMainPanel] ReviewMainPanel" );
		this.project = project;
		splitter = new OnePixelSplitter(true,.98f);
		splitter.setDividerWidth(2);

		searchTextArea = new SearchTextArea(new JBTextArea(),true);
		searchTextArea.setMinimumSize(new Dimension(searchTextArea.getWidth(), 500));
		sendButton = new JButton("send");

		actionPanel = new JPanel(new BorderLayout());
		actionPanel.add(searchTextArea, BorderLayout.CENTER);
		actionPanel.add(sendButton, BorderLayout.EAST);

		contentPanel = new ReviewContextPanel(project, isChatGPTModel);
		splitter.setFirstComponent(contentPanel);
		splitter.setSecondComponent(actionPanel);

	}
	public JPanel init() {
		return splitter;
	}
}
