package persistent;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.util.xmlb.XmlSerializerUtil;

@State(
	name = "DepolloSettingState",
	storages = @Storage("depollo.xml")
)
public class DepolloSettingState implements PersistentStateComponent<DepolloSettingState> {

	private static DepolloSettingState instance;
	public String accessToken = "";
	public String expireTime = "";

	public static DepolloSettingState getInstance() {
		if (instance == null) {
			instance = new DepolloSettingState();
		}
		return instance;
	}
	@Override
	public @Nullable DepolloSettingState getState() {
		return this;
	}

	@Override
	public void loadState(@NotNull DepolloSettingState state) {
		XmlSerializerUtil.copyBean(state, this);
	}

}
