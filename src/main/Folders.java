package main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Folders {

	public static int findNthIndexOf (String str, String needle, int occurence)
            throws IndexOutOfBoundsException {
    int index = -1;
    Pattern p = Pattern.compile(needle, Pattern.MULTILINE);
    Matcher m = p.matcher(str);
    while(m.find()) {
        if (--occurence == 0) {
            index = m.start();
            break;
        }
    }
    if (index < 0) throw new IndexOutOfBoundsException();
    return index;
}

    public static Collection<String> folderNames(String xml, char startingLetter) throws Exception {
    	List<String> tags = new ArrayList<String>();
    	List<String> result = new ArrayList<String>();
    	while (xml.length() > 0) {
    		tags.add(xml.substring(xml.indexOf("<"), xml.indexOf(">") + 1));
    		xml = xml.substring(xml.indexOf(">")+1);
		}

    	for (int i = 0; i < tags.size(); i++) {
			if (!tags.get(i).contains("folder name=\"" + startingLetter)) {
				tags.remove(i);
				i--;
			}
		}


    	for (int i = 0; i < tags.size(); i++) {
			result.add(tags.get(i).substring(tags.get(i).indexOf("=") + 2, findNthIndexOf(tags.get(i), "\"", 2)));
		}

    	//result.add(tags.get(0).substring(tags.get(0).indexOf("f")));
    	return result;
    }

    public static void main(String[] args) throws Exception {
        String xml =
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                "<folder name=\"c\">" +
                    "<folder name=\"program files\">" +
                        "<folder name=\"uninstall information\" />" +
                        "<folder name=\"glenn\" />" +
                    "</folder>" +
                    "<folder name=\"users\" />" +
                "</folder>";

        Collection<String> names = folderNames(xml, 'g');
        for(String name: names)
            System.out.println(name);
    }
}
