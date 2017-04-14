import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class characteristicsBundle {
	private static final String BUNDLE_NAME = "core.Locale.Characteristics.CharacteristicsBundle"; //$NON-NLS-1$

	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle
			.getBundle(BUNDLE_NAME);

	private characteristicsBundle() {
	}

	public static String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
}
