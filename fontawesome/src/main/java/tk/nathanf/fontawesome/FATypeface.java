package tk.nathanf.fontawesome;

import android.content.Context;
import android.graphics.Typeface;

import java.util.HashMap;

/**
 * A utility class for loading Font Awesome Typefaces.
 */
@SuppressWarnings("WeakerAccess")
public class FATypeface {
    /**
     * A cache of loaded Font Awesome Type Faces.
     */
    private static HashMap<FAType, Typeface> loadedTypeFaces = new HashMap<>();

    /**
     * The Font Awesome Types.
     */
    public enum FAType {
        Brands,
        Light,
        Regular,
        Solid;

        public static FAType getType(int value) {
            if (value == 0) {
                return Brands;
            } else if (value == 1) {
                return Light;
            } else if (value == 2) {
                return Regular;
            } else if (value == 3) {
                return Solid;
            }

            return Regular;
        }
    }

    /**
     * Retrieve a Typeface based on the Font Awesome Type.
     *
     * @param context The Context.
     * @param type    The Font Awesome Type.
     *
     * @return        The typeface.
     */
    @SuppressWarnings("WeakerAccess")
    public static Typeface getTypeFace(Context context, FAType type) {
        if (! loadedTypeFaces.containsKey(type)) {
            String fontName;
            switch(type) {
                case Light:
                    fontName = "fa-light-300.ttf";
                    break;
                case Solid:
                    fontName = "fa-solid-900.ttf";
                    break;
                case Brands:
                    fontName = "fa-brands-400.ttf";
                    break;
                default:
                    fontName = "fa-regular-400.ttf";
                    break;
            }

            Typeface result = Typeface.createFromAsset(context.getAssets(), "fonts/" + fontName);
            loadedTypeFaces.put(type, result);
        }

        return loadedTypeFaces.get(type);
    }
}
