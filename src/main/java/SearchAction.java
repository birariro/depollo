import java.util.Optional;

import org.jetbrains.annotations.NotNull;

import com.intellij.ide.BrowserUtil;
import com.intellij.lang.Language;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.actionSystem.LangDataKeys;
import com.intellij.openapi.editor.CaretModel;
import com.intellij.openapi.editor.Editor;
import com.intellij.psi.PsiFile;

public class SearchAction extends AnAction {

	@Override
	public void actionPerformed(@NotNull AnActionEvent e) {

		Optional<PsiFile> psiFile = Optional.ofNullable(e.getData(LangDataKeys.PSI_FILE));
		String languageTag = psiFile
			.map(PsiFile::getLanguage)
			.map(Language::getDisplayName)
			.map(String::toLowerCase)
			.map(lang -> "[" + lang + "]")
			.orElse("");

		Editor editor = e.getRequiredData(CommonDataKeys.EDITOR);
		CaretModel caretModel = editor.getCaretModel();
		String selectedText = caretModel.getCurrentCaret().getSelectedText();

		BrowserUtil.browse("https://stackoverflow.com/search?q=" + selectedText);
	}

	@Override
	public void update(AnActionEvent e) {
		Editor editor = e.getRequiredData(CommonDataKeys.EDITOR);
		CaretModel caretModel = editor.getCaretModel();
		e.getPresentation().setEnabledAndVisible(caretModel.getCurrentCaret().hasSelection());
	}
}
