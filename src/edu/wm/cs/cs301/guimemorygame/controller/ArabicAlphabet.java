package edu.wm.cs.cs301.guimemorygame.controller;

public class ArabicAlphabet implements Alphabet { 
	public char[] toCharArray() {
		char[] arabicArr = {
	            '\u0627', '\u0628', '\u062A', '\u062B', '\u062C', '\u062D', '\u062E', '\u062F', '\u0630', '\u0631',
	            '\u0632', '\u0633', '\u0634', '\u0635', '\u0636', '\u0637', '\u0638', '\u0639', '\u063A', '\u0641',
	            '\u0642', '\u0643', '\u0644', '\u0645', '\u0646', '\u0647', '\u0648', '\u0649', '\u064A',
	            '\u0621', '\u0622', '\u0623', '\u0624', '\u0625', '\u0626', '\u0629', '\u0633', '\u0634', '\u0635',
	            '\u0636', '\u0637', '\u0638', '\u0639', '\u063A', '\u0641', '\u0642', '\u0643', '\u0644', '\u0645',
	            '\u0646', '\u0647', '\u0648', '\u0649', '\u064A'
	        };
		return arabicArr;
	}
}