package review;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import org.jetbrains.annotations.NotNull;

import com.google.gson.JsonArray;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.NullableComponent;
import com.intellij.ui.Gray;
import com.intellij.ui.JBColor;
import com.intellij.ui.components.JBLabel;
import com.intellij.ui.components.JBPanel;
import com.intellij.ui.components.labels.LinkLabel;
import com.intellij.ui.components.panels.VerticalLayout;
import com.intellij.util.ui.JBFont;
import com.intellij.util.ui.JBUI;
import com.intellij.util.ui.UIUtil;

public class ReviewContextPanel  extends JBPanel<ReviewContextPanel> implements NullableComponent {

	private final JPanel myList = new JPanel(new VerticalLayout(JBUI.scale(10)));
	private static java.util.List<String> questions = new ArrayList<>();
	private static List<String> questions_result = new ArrayList<>();

	public ReviewContextPanel(@NotNull Project project, boolean isChatGPTModel) {
		setBorder(JBUI.Borders.empty(10, 10, 10, 0));
		setLayout(new BorderLayout(JBUI.scale(7), 0));
		setBackground(UIUtil.getListBackground());

		JPanel mainPanel = new JPanel(new BorderLayout(0, JBUI.scale(8)));
		mainPanel.setOpaque(false);
		mainPanel.setBorder(JBUI.Borders.emptyLeft(8));
		add(mainPanel,BorderLayout.CENTER);

		JBLabel myTitle = new JBLabel("좌측 상단 타이틀");
		myTitle.setForeground(JBColor.namedColor("Label.infoForeground", new JBColor(Gray.x80, Gray.x8C)));
		myTitle.setFont(JBFont.label());

		JPanel panel = new JPanel(new BorderLayout());
		panel.setOpaque(false);
		panel.setBorder(JBUI.Borders.empty(0,10,10,0));

		panel.add(myTitle, BorderLayout.WEST);
		LinkLabel<String> newChat = new LinkLabel<>("우측 상단 버튼", null);
		newChat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				myList.removeAll();
				myList.updateUI();
				System.out.println("mouseClicked!");
			}
		});
		newChat.setFont(JBFont.label());
		newChat.setBorder(JBUI.Borders.emptyRight(20));
		panel.add(newChat, BorderLayout.EAST);

		mainPanel.add(panel, BorderLayout.NORTH);

		myList.setOpaque(true);
		myList.setBackground(UIUtil.getListBackground());
		myList.setBorder(JBUI.Borders.emptyRight(10));

		add("");
	}

	public void add(String str) {

		myList.add(new JLabel("asd"));
		updateLayout();
		updateUI();
	}
	public void updateLayout() {
		LayoutManager layout = myList.getLayout();
		int componentCount = myList.getComponentCount();
		for (int i = 0 ; i< componentCount ; i++) {
			layout.removeLayoutComponent(myList.getComponent(i));
			layout.addLayoutComponent(null,myList.getComponent(i));
		}
	}


	@Override
	public boolean isNull() {
		return false;
	}
}
