package osmedile.intellij.stringmanip.utils;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * StringUtil Tester.
 *
 * @author <Authors name>
 * @version $Id$
 * @since <pre>03/21/2008</pre>
 */
public class StringUtilTest extends TestCase {

    public StringUtilTest(String name) {
        super(name);
    }

	@Override
    public void setUp() throws Exception {
        super.setUp();
    }

	@Override
    public void tearDown() throws Exception {
        super.tearDown();
    }

    public static Test suite() {
        return new TestSuite(StringUtilTest.class);
    }

    public void testToCamelCase() {
        assertEquals("thisIsAText", StringUtil.toCamelCase("This is a text"));
        //this is ugly but nothing can be done about that.
        assertEquals("whOAhATeSt", StringUtil.toCamelCase("WhOAh a TeSt"));
        assertEquals("whOAhATeSt", StringUtil.toCamelCase("WhOAh_a_TeSt"));
        assertEquals("whOAhATeSt", StringUtil.toCamelCase("WhOAh a_TeSt"));
        //previously
//        assertEquals("whoahATest", StringUtil.toCamelCase("WhOAh a TeSt"));
//        assertEquals("whoahATest", StringUtil.toCamelCase("WhOAh_a_TeSt"));
//        assertEquals("whoahATest", StringUtil.toCamelCase("WhOAh a_TeSt"));
    }

    public void testWordsAndCamelToConstantCase() {
        assertEquals("V2_COUNTER", StringUtil.wordsAndHyphenAndCamelToConstantCase("v2Counter"));
        assertEquals("V22_COUNTER", StringUtil.wordsAndHyphenAndCamelToConstantCase("v22Counter"));
        assertEquals("V22_COUNTER22", StringUtil.wordsAndHyphenAndCamelToConstantCase("v22Counter22"));
		assertEquals("THIS_IS_ATEXT", StringUtil.wordsAndHyphenAndCamelToConstantCase("ThisIsAText"));
		assertEquals("WHOAH_ATEST", StringUtil.wordsAndHyphenAndCamelToConstantCase("WhoahATest"));
		assertEquals("WHOAH_ATEST", StringUtil.wordsAndHyphenAndCamelToConstantCase("Whoah ATest"));
        assertEquals("WHOAH_A_TEST_AGAIN", StringUtil.wordsAndHyphenAndCamelToConstantCase("Whoah  A   Test, again"));
        assertEquals("ANOTHER_T_EST", StringUtil.wordsAndHyphenAndCamelToConstantCase("Another      t_Est"));
        assertEquals("TEST_AGAIN_TEST",
                StringUtil.wordsAndHyphenAndCamelToConstantCase("test again     _    _    test"));
        assertEquals("TEST_AGAIN_TEST", StringUtil.wordsAndHyphenAndCamelToConstantCase("TestAgain_   _    Test"));
    }

    public void testEscapedUnicodeToString() throws Exception {
        assertEquals("Información del diseño", StringUtil.escapedUnicodeToString("Información del diseño"));
        assertEquals("Čás", StringUtil.escapedUnicodeToString("\\u010c\\u00e1s"));
        assertEquals("ďñ", StringUtil.escapedUnicodeToString("\\u010f\\u00f1"));
        assertEquals("abcčd", StringUtil.escapedUnicodeToString("abc\\u010Dd"));
        assertEquals("ěščřžýáíéĚŠČŘŽÝÁÍÉ", StringUtil.escapedUnicodeToString("\\u011B\\u0161\\u010D\\u0159\\u017E\\u00FD\\u00E1\\u00ED\\u00E9\\u011A\\u0160\\u010C\\u0158\\u017D\\u00DD\\u00C1\\u00CD\\u00C9"));
    }

    public void testWordsToConstantCase() {
        assertEquals("THISISATEXT", StringUtil.wordsToConstantCase("ThisIsAText"));
        assertEquals("WHOAH_A_TEST", StringUtil.wordsToConstantCase("Whoah A Test"));
        assertEquals("WHOAH_A_TEST", StringUtil.wordsToConstantCase("Whoah    a tESt"));
        assertEquals("_ANOTHER_TEXT_", StringUtil.wordsToConstantCase("_ANOTHER     TExT_"));
        assertEquals("TEST_AGAIN_____TEST",
                StringUtil.wordsToConstantCase("test agaIN     _    _    _    _    _    test"));
        assertEquals("TEST_AGAIN_____TEST",
                StringUtil.wordsToConstantCase("test agaIN_    _    _    _    _    Test"));
        assertEquals("TEST_AGAIN", StringUtil.wordsToConstantCase(" test agaIN"));
        assertEquals("_TEST_AGAIN", StringUtil.wordsToConstantCase("_  test agaIN"));
        assertEquals("_TEST_AGAIN", StringUtil.wordsToConstantCase("   _  test agaIN"));
    }


    public void testWordsToHyphenCase() {
        assertEquals("this-is-a-text", StringUtil.wordsToHyphenCase("THIS IS A TEXT"));
        assertEquals("whoah-a-test", StringUtil.wordsToHyphenCase("Whoah A Test"));
        assertEquals("whoah-a-test", StringUtil.wordsToHyphenCase("Whoah    a tESt"));
    }

    public void testToDotCase() {
        assertEquals("this.is.a.text", StringUtil.toDotCase("THIS IS A TEXT"));
        assertEquals("whoah.a.test", StringUtil.toDotCase("Whoah A   Test"));
        assertEquals("whoah.a...test", StringUtil.toDotCase("Whoah A - _ Test"));
        assertEquals("whoah.a.t.est", StringUtil.toDotCase("Whoah    a tESt"));
    }

    public void testWordsToUnderscoreStringInJava() {
        assertEquals("THIS_IS_A_TEXT", StringUtil.wordsToUnderscoreCase("THIS IS A TEXT"));
        assertEquals("THISISATEXT", StringUtil.wordsToUnderscoreCase("THIS--IS-A-TEXT"));
        assertEquals("THIS_IS_A_TEXT", StringUtil.wordsToUnderscoreCase("THIS   IS A   TEXT"));
        assertEquals("A_B", StringUtil.wordsToUnderscoreCase("A_B "));
        assertEquals("A_B", StringUtil.wordsToUnderscoreCase("A_B"));
        assertEquals("A_B", StringUtil.wordsToUnderscoreCase("A  B"));
        assertEquals("A_B", StringUtil.wordsToUnderscoreCase("A__B"));
        assertEquals("ThisIsAText", StringUtil.wordsToUnderscoreCase("ThisIsAText"));
        assertEquals("This_Is_A_Text", StringUtil.wordsToUnderscoreCase("This_Is_A__Text"));
        assertEquals("Whoah_A_Test", StringUtil.wordsToUnderscoreCase("Whoah A Test"));
        assertEquals("Whoah_a_tESt", StringUtil.wordsToUnderscoreCase("Whoah    a tESt"));
        assertEquals("singleLine_clientA는_removeFormat하고_clientB는_EndOffset에_table_삽입하는_경우", StringUtil.wordsToUnderscoreCase("singleLine - clientA는 removeFormat하고, clientB는 EndOffset에 table 삽입하는 경우"));
        assertEquals("multiLine_clientA는_removeFormat_newLine_하고_clientB는_EndOffset에_table_삽입하는_경우", StringUtil.wordsToUnderscoreCase("multiLine - clientA는 removeFormat(newLine)하고, clientB는 EndOffset에 table 삽입하는 경우"));

        //todo: need to change the logic later
        assertEquals("Bug_126481_same_offset_clientA는_텍스트_삽입__w_fontColor__clientB는_텍스트_삽입__w_underline_하는_경우", StringUtil.wordsToUnderscoreCase("Bug 126481: same offset - clientA는 텍스트 삽입 (w/ fontColor), clientB는 텍스트 삽입 (w/ underline)하는 경우"));
        assertEquals("insert_table_2P_clientA는_삽입_clientB는_삽입_same_offset에서_하는_경우", StringUtil.wordsToUnderscoreCase("insert, table 2P : clientA는 삽입, clientB는 삽입 same offset에서 하는 경우"));
        assertEquals("filter_갱신_fonStyle__same_offset_step3_997_1_TP1_cUpdate_filter_ty1_il0_a_c_f_2_3_4_2_2_7_2_sheet_0_cUpdate_color_FFFF00_2_2_7_4_sheet_0", StringUtil.wordsToUnderscoreCase("filter 갱신 / fonStyle (same offset) - step3 - 997_1 : TP1 cUpdate : filter : {'ty':1,'il':[['0',['a','c','f'],[2,3,4]]]} : [2, 2, 7, 2] : sheet 0/ cUpdate : color : '#FFFF00' : [2, 2, 7, 4] : sheet 0"));
    }
}
