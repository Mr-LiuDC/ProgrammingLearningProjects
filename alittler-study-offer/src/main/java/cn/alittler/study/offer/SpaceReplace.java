package cn.alittler.study.offer;
//题目描述
//请实现一个函数，将一个字符串中的空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
public class SpaceReplace {

	public static void main(String[] args) {
		SpaceReplace replace = new SpaceReplace();
		StringBuffer str = new StringBuffer("Hello World Ha");
		String new_str = replace.replaceSpace(str );
		System.out.println(new_str);
	}

	public String replaceSpace(StringBuffer str) {
		char[] str_array = str.toString().toCharArray();
		String new_str = "";
		for (char c : str_array) {
			if (c == ' ') {
				new_str += "%20";
			} else {
				new_str += c;
			}
		}
		return new_str;
	}
}
