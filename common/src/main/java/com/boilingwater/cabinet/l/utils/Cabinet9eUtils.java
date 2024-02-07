package com.boilingwater.cabinet.l.utils;

/**
 * L系列电柜工具类
 *
 * @author Benana
 * @since 2024-01-30
 */
public class Cabinet9eUtils {

    /**
     * 字符串是否为空
     *
     * @param cs 字符串
     * @return true为空 false不为空
     */
    public static boolean isBlank(final CharSequence cs) {
        final int strLen = length(cs);
        if (strLen == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if (!Character.isWhitespace(cs.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 字符串长度
     *
     * @param cs 字符串
     * @return 长度
     */
    public static int length(final CharSequence cs) {
        return cs == null ? 0 : cs.length();
    }
}
