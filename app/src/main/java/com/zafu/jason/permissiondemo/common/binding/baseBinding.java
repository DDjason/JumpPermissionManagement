package com.zafu.jason.permissiondemo.common.binding;

import android.databinding.BindingAdapter;
import android.text.InputFilter;
import android.text.Spanned;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.zafu.jason.permissiondemo.common.ContextHolder;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: Yangyd
 * E-mail: yangyd@erongdu.com
 * Date: 2017/12/27$ 14:05$
 * <p/>
 */
public class baseBinding {
    private static InputFilter emojiFilter = new InputFilter() {
        Pattern pattern = Pattern.compile("[\ud83c\udc00-\ud83c\udfff]|[\ud83d\udc00-\ud83d\udfff]|[\u2600-\u27ff]", Pattern.UNICODE_CASE | Pattern
                .CASE_INSENSITIVE);
        String regEx =
                "[^a-zA-Z0-9\u4E00-\u9FA5]";
        Pattern patternOnly = Pattern.compile(regEx);

        @Override
        public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
            Matcher matcher = pattern.matcher(source);
            if (matcher.find()) {
                Log.i("CharSequence", "不允许输入表情");
                Toast.makeText(ContextHolder.getContext(), "不允许输入表情", Toast.LENGTH_SHORT).show();
                return "";
            }
            return null;
        }
    };

    @BindingAdapter("inputFilter")
    public static void editTextFilter(EditText editText, int type) {
        InputFilter[] old      = editText.getFilters();
        InputFilter[] filters  = new InputFilter[old.length + 1];
        int           position = 0;
        for (; position < old.length; position++) {
            filters[position] = old[position];
        }
        filters[position] = emojiFilter;
        editText.setFilters(filters);
    }
}
