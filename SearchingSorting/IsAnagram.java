//Time Complexity O(n)
//Space Complexity O(n)

// Ques: Check if string b is an anagram of a.

import java.util.Map;
import java.util.HashMap;

class IsAnagram {

	public static boolean isAnagram(String a, String b) {
		
		if(b == null || b.length() == 0)
			return true;
		
		Map<Character, Integer> map = new HashMap<>();
		
		for(int i = 0; i < b.length(); i++) {
			if(b.charAt(i) != ' ') {
				char temp = Character.toLowerCase(b.charAt(i));
				if(map.get(temp) == null)
					map.put(temp, 0);
				map.put(temp, map.get(temp) + 1);
			}
		}

		for(int i = 0; i < a.length(); i++) {
			
			if(a.charAt(i) != ' ') {

				char temp = Character.toLowerCase(a.charAt(i));
				if(map.get(temp) != null){
					map.put(temp, map.get(temp) - 1);
					if(map.get(temp) == 0)
						map.remove(temp);
				}
				
				if(map.isEmpty())
					return true;
			}
		}

		return false;

	}
	
	public static void main(String[] argv) {
		String a = "is Anagram or Not";
		String b = "Got an";
		if(isAnagram(a,b))
			System.out.println("Anagram");
		else
			System.out.println("Not an anagram");
	}
}