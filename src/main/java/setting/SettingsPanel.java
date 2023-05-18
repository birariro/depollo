package setting;

import java.awt.*;

import javax.swing.*;

import org.jetbrains.annotations.Nullable;

import com.intellij.openapi.Disposable;
import com.intellij.openapi.options.Configurable;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.util.NlsContexts;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.ui.TitledSeparator;
import com.intellij.ui.components.fields.ExpandableTextField;

import persistent.DepolloSettingState;

public class SettingsPanel implements Configurable, Disposable {
    private JPanel mainPanel;
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
            Messages.showInputDialog("토큰 얻기", "토큰 얻기", Messages.getQuestionIcon());
        });
    }
    public ExpandableTextField getAccessTokenField() {
        return accessTokenField;
    }

    @Override
    public void dispose() {

    }

    @Override
    public void reset() {
        DepolloSettingState state = DepolloSettingState.getInstance();

        accessTokenField.setText(state.accessToken);
        expireTimeField.setText(state.expireTime);
    }
    @Override
    public @NlsContexts.ConfigurableName String getDisplayName() {
        return "Depollo";
    }

    @Override
    public @Nullable JComponent createComponent() {
        return mainPanel;
    }


    private void createUIComponents() {
        tokenTitledBorderBox = new JPanel(new BorderLayout());
        TitledSeparator tsUrl = new TitledSeparator("Access Token Settings");
        tokenTitledBorderBox.add(tsUrl,BorderLayout.CENTER);

    }

    //설정 화면에서 apply 버튼의 활성여부
    @Override
    public boolean isModified() {

        DepolloSettingState state = DepolloSettingState.getInstance();

        return !StringUtil.equals(state.accessToken, accessTokenField.getText()) ||
            !StringUtil.equals(state.expireTime, expireTimeField.getText());
    }

    @Override
    public void apply() {
        DepolloSettingState state = DepolloSettingState.getInstance();
        state.accessToken = accessTokenField.getText();
        state.expireTime = expireTimeField.getText();
    }
}