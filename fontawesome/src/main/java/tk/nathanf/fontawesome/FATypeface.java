package tk.nathanf.fontawesome;

import android.content.Context;
import android.graphics.Typeface;

import java.util.HashMap;

public class FATypeface {
    private static HashMap<FAType, Typeface> loadedTypeFaces = new HashMap<>();

    public enum FAType {
        Brands(0),
        Light(1),
        Regular(2),
        Solid(3);

        private int value;

        FAType(int value) {
            this.value = value;
        }

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
