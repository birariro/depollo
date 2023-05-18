package setting;

import java.awt.*;

import javax.swing.*;

import org.jetbrains.annotations.Nullable;

import com.intellij.openapi.Disposable;
import com.intellij.openapi.options.Configurable;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.util.NlsContexts;
import com.intellij.ui.TitledSeparator;
import com.intellij.ui.components.BrowserLink;
import com.intellij.ui.components.JBTextField;
import com.intellij.ui.components.fields.ExpandableTextField;

public class SettingsPanel implements Configurable, Disposable {
    private JPanel myMainPanel;
    // 토큰 입력 에리어
    private JPanel tokenTitledBorderBox;
    // 토큰 입력 에리어 > 토큰 input
    private ExpandableTextField accessTokenField;
    // 토큰 입력 에리어 > 만료 시간 input
    private JTextField expireTimeField;
    // 토큰 입력 에리어 > 토큰 버튼
    private JButton loginButton;

    public SettingsPanel() {
        init();
    }

    private void init() {
        accessTokenField.getEmptyText().setText("Click 'Get Token' Button to access token");
        expireTimeField.setEnabled(false);
        expireTimeField.setEditable(false);
        loginButton.addActionListener(e -> {
            Messages.showInputDialog("트큰 얻기", "트큰 얻기", Messages.getQuestionIcon());
        });
    }
    public ExpandableTextField getAccessTokenField() {
        return accessTokenField;
    }

    @Override
    public void dispose() {

    }

    @Override
    public @NlsContexts.ConfigurableName String getDisplayName() {
        return "Depollo";
    }

    @Override
    public @Nullable JComponent createComponent() {
        return myMainPanel;
    }


    private void createUIComponents() {
        tokenTitledBorderBox = new JPanel(new BorderLayout());
        TitledSeparator tsUrl = new TitledSeparator("Access Token Settings");
        tokenTitledBorderBox.add(tsUrl,BorderLayout.CENTER);

    }

    @Override
    public boolean isModified() {
        return false;
    }

    @Override
    public void apply() throws ConfigurationException {

    }
}