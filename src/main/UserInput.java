package main;

class TextInput {
	private String value = "";
	
	public void add(char c) {
		value += c;
	}

	public String getValue() {
		return value;
	}

}

class NumericInput extends TextInput {
	private String value = "";
	@Override
	public void add(char c) {
		value += c;
	}

	@Override
	public String getValue() {
		return value.replaceAll("\\D", "");
	}
}

public class UserInput {
    public static void main(String[] args) {
        TextInput input = new NumericInput();
        input.add('1');
        input.add('a');
        input.add('0');
        input.add('B');
        input.add(' ');
        input.add('4');
        System.out.println(input.getValue());
    }
}
