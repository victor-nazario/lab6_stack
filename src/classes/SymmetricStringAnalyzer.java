package classes;

public class SymmetricStringAnalyzer {
	private String s; 
	public SymmetricStringAnalyzer(String s) {
		this.s = s; 
	}
	
	/**
	 * Determines if the string s is symmetric in its contents
	 * @return true if it is; false, otherwise. 
	 */
	public boolean isValidContent() { 
		SLLStack<Character> charStack = new SLLStack<Character>();
		int sl=s.length();
		for(int i=0; i<sl; i++) {
			char c = s.charAt(i);
			if(Character.isLetter(c))
				if(Character.isUpperCase(c))
					charStack.push(c);
				else if(charStack.isEmpty()) 
					return false;
				else {
					char t = charStack.top();
					if(t == Character.toUpperCase(c))
						charStack.pop();
					else 
						return false;
				}
			else
				return false;
				}
		return true;
		}
	
	public String toString() { 
		return s; 
	}

	public String parenthesizedExpression() 
	throws StringIsNotSymmetricException 
	{
		try {
			if(!isValidContent())
				throw new StringIsNotSymmetricException();
		} catch(StringIsNotSymmetricException e) {
			e.printStackTrace();
		}
		
		SLLStack<Character> charStack = new SLLStack<Character>();
		String str = ""; 
		int sl = s.length();
		if(isValidContent()) {
			for(int i=0; i<sl; i++) {
				char c = s.charAt(i);
				if(Character.isUpperCase(c)) {
					charStack.push('<');
					charStack.push(c);
					str += '<';
					str += c;
					str += " ";
				} else {
					charStack.push(c);
					charStack.push('>');
					str += c;
					str += '>';
					str += " ";		
				}
			}
		}
		return str;	
	}
}
