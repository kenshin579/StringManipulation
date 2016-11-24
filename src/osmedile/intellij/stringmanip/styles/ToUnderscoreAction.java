package osmedile.intellij.stringmanip.styles;

import osmedile.intellij.stringmanip.utils.StringUtil;

public class ToUnderscoreAction extends AbstractCaseConvertingAction {
    public ToUnderscoreAction() {
    }

    public ToUnderscoreAction(boolean setupHandler) {
        super(setupHandler);
    }

    @Override
    public String transformByLine(String s) {
        return StringUtil.wordsToUnderscoreCase(s);
    }
}
